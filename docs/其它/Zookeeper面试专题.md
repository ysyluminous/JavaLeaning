#### Zookeeper是什么框架
- 分布式的、开源的分布式应用程序协调服务，原本是Hadoop、HBase的一个重要组件。它为分布式应用提供一致性服务的软件，包括：配置维护、域名服务、分布式同步、组服务等。

#### 应用场景
- zookeeper的功能很强大，应用场景很多，结合我实际工作中使用Dubbo框架的情况，Zookeeper主要是做注册中心用。基于Dubbo框架开发的提供者、消费者都向Zookeeper注册自己的URL，消费者还能拿到并订阅提供者的注册URL，以便在后续程序的执行中去调用提供者。而提供者发生了变动，也会通过Zookeeper向订阅的消费者发送通知。

#### Paxos算法& Zookeeper使用协议
- Paxos算法是分布式选举算法，Zookeeper使用的 ZAB协议（Zookeeper原子广播），二者有相同的地方，比如都有一个Leader，用来协调N个Follower的运行；Leader要等待超半数的Follower做出正确反馈之后才进行提案；二者都有一个值来代表Leader的周期。
- 不同的地方在于：
- ZAB用来构建高可用的分布式数据主备系统（Zookeeper），Paxos是用来构建分布式一致性状态机系统。

Paxos算法、ZAB协议要想讲清楚可不是一时半会的事儿，自1990年莱斯利·兰伯特提出Paxos算法以来，因为晦涩难懂并没有受到重视。后续几年，兰伯特通过好几篇论文对其进行更进一步地解释，也直到06年谷歌发表了三篇论文，选择Paxos作为chubby cell的一致性算法，Paxos才真正流行起来。

对于普通开发者来说，尤其是学习使用Zookeeper的开发者明确一点就好：分布式Zookeeper选举Leader服务器的算法与Paxos有很深的关系。

#### ZooKeeper提供的常见服务
- 命名服务 - 按名称标识集群中的节点。它类似于DNS，但仅对于节点。
- 配置管理 - 加入节点的最近的和最新的系统配置信息。
- 集群管理 - 实时地在集群和节点状态中加入/离开节点。
- 选举算法 - 选举一个节点作为协调目的的leader。
- 高度可靠的数据注册表 - 即使在一个或几个节点关闭时也可以获得数据。
- 锁定和同步服务 - 在修改数据的同时锁定数据。

#### Zookeeper有哪几种节点类型
- 持久节点：创建之后一直存在，除非有删除操作，创建节点的客户端会话失效也不影响此节点。
- 持久顺序节点 ：跟持久一样，就是父节点在创建下一级子节点的时候，记录每个子节点创建的先后顺序，会给每个子节点名加上一个数字后缀。
- 临时节点：创建客户端会话失效（注意是会话失效，不是连接断了），节点也就没了。不能建子节点。
- 临时顺序节点

#### Zookeeper对节点的watch监听通知是永久的吗？
- 不是。官方声明：一个Watch事件是一个一次性的触发器，当被设置了Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了Watch的客户端，以便通知它们。

#### 为什么不是watch监听通知不是永久的？
- 如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，这太消耗性能了。
- 一般是客户端执行getData(“/节点A”,true)，如果节点A发生了变更或删除，客户端会得到它的watch事件，但是在之后节点A又发生了变更，而客户端又没有设置watch事件，就不再给客户端发送。

#### 部署方式？集群中的机器角色都有哪些？集群最少要几台机器
- 单机，集群。Leader、Follower。集群最低3（2N+1）台，保证奇数，主要是为了选举算法。
- 集群如果有3台机器，挂掉一台集群还能工作吗？挂掉两台呢？
- 记住一个原则：过半存活即可用。

#### 集群支持动态添加机器吗
- 其实就是水平扩容了，Zookeeper在这方面不太好。两种方式：
- 全部重启：关闭所有Zookeeper服务，修改配置之后启动。不影响之前客户端的会话。
- 逐个重启：顾名思义。这是比较常用的方式。

#### zookeeper是如何保证事务的顺序一致性的
- zookeeper采用了递增的事务Id来标识，所有的proposal都在被提出的时候加上了zxid，zxid实际上是一个64位的数字，高32位是epoch用来标识leader是否发生改变，如果有新的leader产生出来，epoch会自增，低32位用来递增计数。当新产生proposal的时候，会依据数据库的两阶段过程，首先会向其他的server发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行

#### zookeeper是如何选取主leader的？
- 所有节点创建具有相同路径 /app/leader_election/guid_ 的顺序、临时节点。
- ZooKeeper集合将附加10位序列号到路径，创建的znode将是 /app/leader_election/guid_0000000001，/app/leader_election/guid_0000000002等。
- 对于给定的实例，在znode中创建最小数字的节点成为leader，而所有其他节点是follower。
- 每个follower节点监视下一个具有最小数字的znode。例如，创建znode/app/leader_election/guid_0000000008的节点将监视znode/app/leader_election/guid_0000000007，创建znode/app/leader_election/guid_0000000007的节点将监视znode/app/leader_election/guid_0000000006。
- 如果leader关闭，则其相应的znode/app/leader_electionN会被删除。
- 下一个在线follower节点将通过监视器获得关于leader移除的通知。
- 下一个在线follower节点将检查是否存在其他具有最小数字的znode。如果没有，那么它将承担leader的角色。否则，它找到的创建具有最小数字的znode的节点将作为leader。
- 类似地，所有其他follower节点选举创建具有最小数字的znode的节点作为leader。

#### 机器中为什么会有master；
- 在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行master选举。

#### ZooKeeper集群中服务器之间是怎样通信的？
- Leader服务器会和每一个Follower/Observer服务器都建立TCP连接，同时为每个F/O都创建一个叫做LearnerHandler的实体。LearnerHandler主要负责Leader和F/O之间的网络通讯，包括数据同步，请求转发和Proposal提议的投票等。Leader服务器保存了所有F/O的LearnerHandler。

#### zookeeper是否会自动进行日志清理？如何进行日志清理？
- zk自己不会进行日志清理，需要运维人员进行日志清理

#### ZK选举过程
- 当leader崩溃或者leader失去大多数的follower，这时候zk进入恢复模式，恢复模式需要重新选举出一个新的leader，让所有的Server都恢复到一个正确的状态。Zk的选举算法使用ZAB协议：
- ①　选举线程由当前Server发起选举的线程担任，其主要功能是对投票结果进行统计，并选出推荐的Server；
- ②　选举线程首先向所有Server发起一次询问(包括自己)；
- ③　选举线程收到回复后，验证是否是自己发起的询问(验证zxid是否一致)，然后获取对方的id(myid)，并存储到当前询问对象列表中，最后获取对方提议的leader相关信息(id,zxid)，并将这些信息存储到当次选举的投票记录表中；
- ④　收到所有Server回复以后，就计算出zxid最大的那个Server，并将这个Server相关信息设置成下一次要投票的Server；
- ⑤　线程将当前zxid最大的Server设置为当前Server要推荐的Leader，如果此时获胜的Server获得n/2 + 1的Server票数， 设置当前推荐的leader为获胜的Server，将根据获胜的Server相关信息设置自己的状态，否则，继续这个过程，直到leader被选举出来。
- 通过流程分析我们可以得出：要使Leader获得多数Server的支持，则Server总数最好是奇数2n+1，且存活的Server的数目不得少于n+1

#### 客户端对ServerList的轮询机制是什么
- 随机，客户端在初始化( new ZooKeeper(String connectString, int sessionTimeout, Watcher watcher) )的过程中，将所有Server保存在一个List中，然后随机打散，形成一个环。之后从0号位开始一个一个使用。
- 两个注意点：
- ①　Server地址能够重复配置，这样能够弥补客户端无法设置Server权重的缺陷，但是也会加大风险。（比如: 192.168.1.1:2181,192.168.1.1:2181,192.168.1.2:2181).
- ②　如果客户端在进行Server切换过程中耗时过长，那么将会收到SESSION_EXPIRED. 这也是上面第1点中的加大风险之处

##### 客户端如何正确处理CONNECTIONLOSS(连接断开) 和 SESSIONEXPIRED(Session 过期)两类连接异常**
- 在ZooKeeper中，服务器和客户端之间维持的是一个长连接，在 SESSION_TIMEOUT 时间内，服务器会确定客户端是否正常连接(客户端会定时向服务器发送heart_beat),服务器重置下次SESSION_TIMEOUT时间。因此，在正常情况下，Session一直有效，并且zk集群所有机器上都保存这个Session信息。在出现问题情况下，客户端与服务器之间连接断了（客户端所连接的那台zk机器挂了，或是其它原因的网络闪断），这个时候客户端会主动在地址列表（初始化的时候传入构造方法的那个参数connectString）中选择新的地址进行连接。

####  一个客户端修改了某个节点的数据，其它客户端能够马上获取到这个最新数据吗
ZooKeeper不能确保任何客户端能够获取（即Read Request）到一样的数据，除非客户端自己要求：方法是客户端在获取数据之前调用org.apache.zookeeper.AsyncCallback.VoidCallback, java.lang.Object) sync.

通常情况下（这里所说的通常情况满足：1. 对获取的数据是否是最新版本不敏感，2. 一个客户端修改了数据，其它客户端是否需要立即能够获取最新），可以不关心这点。

在其它情况下，最清晰的场景是这样：ZK客户端A对 /my_test 的内容从 v1->v2, 但是ZK客户端B对 /my_test 的内容获取，依然得到的是 v1. 请注意，这个是实际存在的现象，当然延时很短。解决的方法是客户端B先调用 sync(), 再调用 getData().

#### ZK为什么不提供一个永久性的Watcher注册机制
不支持用持久Watcher的原因很简单，ZK无法保证性能。

使用watch需要注意的几点

①　Watches通知是一次性的，必须重复注册.

②　发生CONNECTIONLOSS之后，只要在session_timeout之内再次连接上（即不发生SESSIONEXPIRED），那么这个连接注册的watches依然在。

③　节点数据的版本变化会触发NodeDataChanged，注意，这里特意说明了是版本变化。存在这样的情况，只要成功执行了setData()方法，无论内容是否和之前一致，都会触发NodeDataChanged。

④　对某个节点注册了watch，但是节点被删除了，那么注册在这个节点上的watches都会被移除。

⑤　同一个zk客户端对某一个节点注册相同的watch，只会收到一次通知。

⑥　Watcher对象只会保存在客户端，不会传递到服务端。

#### 我能否收到每次节点变化的通知
如果节点数据的更新频率很高的话，不能。

原因在于：当一次数据修改，通知客户端，客户端再次注册watch，在这个过程中，可能数据已经发生了许多次数据修改，因此，千万不要做这样的测试：”数据被修改了n次，一定会收到n次通知”来测试server是否正常工作。（我曾经就做过这样的傻事，发现Server一直工作不正常？其实不是）。即使你使用了GitHub上这个客户端也一样。


#### 是否可以拒绝单个IP对ZK的访问,操作
ZK本身不提供这样的功能，它仅仅提供了对单个IP的连接数的限制。你可以通过修改iptables来实现对单个ip的限制，当然，你也可以通过这样的方式来解决。https://issues.apache.org/jira/browse/ZOOKEEPER-1320

####  在getChildren(String path, boolean watch)是注册了对节点子节点的变化，那么子节点的子节点变化能通知吗
不能

#### 创建的临时节点什么时候会被删除，是连接一断就删除吗？延时是多少？
连接断了之后，ZK不会马上移除临时数据，只有当SESSIONEXPIRED之后，才会把这个会话建立的临时数据移除。因此，用户需要谨慎设置Session_TimeOut




#### ZooKeeper是什么？
ZooKeeper是一个开放源码的分布式协调服务，它是集群的管理者，监视着集群中各个节点的状态根据节点提交的反馈进行下一步合理操作。最终，将简单易用的接口和性能高效、功能稳定的系统提供给用户。
分布式应用程序可以基于Zookeeper实现诸如数据发布/订阅、负载均衡、命名服务、分布式协调/通知、集群管理、Ma ster选举、分布式锁和分布式队列等功能。
Zookeeper保证了如下分布式一致性特性：
1、顺序一致性
2、原子性
3、单一视图
4、可靠性
5、实时性（最终一致性）
客户端的读请求可以被集群中的任意一台机器处理，如果读请求在节点上注册了监听器，这个监听器也是由所连接的zookeeper机器来处理。对于写请求，这些请求会同时发给其他zookeeper机器并且达成一致后，请求才会返回成功。因此，随着zookeeper的集群机器增多，读请求的吞吐会提高但是写请求的吞吐会下降。
有序性是zookeeper中非常重要的一个特性，所有的更新都是全局有序的，每个更新都有一个唯一的时间戳，这个时间戳称为zxid（Zookeeper Transaction Id）。而读请求只会相对于更新有序，也就是读请求的返回结果中会带有这个zookeeper最新的zxid。
#### ZooKeeper提供了什么？
1、文件系统
2、通知机制
##  Zookeeper文件系统
Zookeeper提供一个多层级的节点命名空间（节点称为znode）。与文件系统不同的是，这些节点都可以设置关联的数据，而文件系统中只有文件节点可以存放数据而目录节点不行。
Zookeeper为了保证高吞吐和低延迟，在内存中维护了这个树状的目录结构，这种特性使得Zookeeper不能用于存放大量的数据，每个节点的存放数据上限为1M。
4. ZAB协议？
ZAB协议是为分布式协调服务Zookeeper专门设计的一种支持崩溃恢复的原子广播协议。
ZAB协议包括两种基本的模式：崩溃恢复和消息广播。
当整个zookeeper集群刚刚启动或者Leader服务器宕机、重启或者网络故障导致不存在过半的服务器与Leader服务器保持正常通信时，所有进程（服务器）进入崩溃恢复模式，首先选举产生新的Leader服务器，然后集群中Follower服务器开始与新的Leader服务器进行数据同步，当集群中超过半数机器与该Leader服务器完成数据同步之后，退出恢复模式进入消息广播模式，Leader服务器开始接收客户端的事务请求生成事物提案来进行事务请求处理。
5. 四种类型的数据节点 Znode
1、PERSISTENT-持久节点
除非手动删除，否则节点一直存在于Zookeeper上
2、EPHEMERAL-临时节点
临时节点的生命周期与客户端会话绑定，一旦客户端会话失效（客户端与zookeeper连接断开不一定会话失效），那么这个客户端创建的所有临时节点都会被移除。
3、PERSISTENT_SEQUENTIAL-持久顺序节点
基本特性同持久节点，只是增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。
4、EPHEMERAL_SEQUENTIAL-临时顺序节点
基本特性同临时节点，增加了顺序属性，节点名后边会追加一个由父节点维护的自增整型数字。
6. Zookeeper Watcher 机制 -- 数据变更通知
Zookeeper允许客户端向服务端的某个Znode注册一个Watcher监听，当服务端的一些指定事件触发了这个Watcher，服务端会向指定客户端发送一个事件通知来实现分布式的通知功能，然后客户端根据Watcher通知状态和事件类型做出业务上的改变。
工作机制：
1、客户端注册watcher
2、服务端处理watcher
3、客户端回调watcher
Watcher特性总结：
1、一次性
无论是服务端还是客户端，一旦一个Watcher被触发，Zookeeper都会将其从相应的存储中移除。这样的设计有效的减轻了服务端的压力，不然对于更新非常频繁的节点，服务端会不断的向客户端发送事件通知，无论对于网络还是服务端的压力都非常大。
2、客户端串行执行
客户端Watcher回调的过程是一个串行同步的过程。
3、轻量
3.1、Watcher通知非常简单，只会告诉客户端发生了事件，而不会说明事件的具体内容。
3.2、客户端向服务端注册Watcher的时候，并不会把客户端真实的Watcher对象实体传递到服务端，仅仅是在客户端请求中使用boolean类型属性进行了标记。
4、watcher event异步发送watcher的通知事件从server发送到client是异步的，这就存在一个问题，不同的客户端和服务器之间通过socket进行通信，由于网络延迟或其他因素导致客户端在不通的时刻监听到事件，由于Zookeeper本身提供了ordering guarantee，即客户端监听事件后，才会感知它所监视znode发生了变化。所以我们使用Zookeeper不能期望能够监控到节点每次的变化。Zookeeper只能保证最终的一致性，而无法保证强一致性。
5、注册watcher getData、exists、getChildren
6、触发watcher create、delete、setData
7、当一个客户端连接到一个新的服务器上时，watch将会被以任意会话事件触发。当与一个服务器失去连接的时候，是无法接收到watch的。而当client重新连接时，如果需要的话，所有先前注册过的watch，都会被重新注册。通常这是完全透明的。只有在一个特殊情况下，watch可能会丢失：对于一个未创建的znode的exist watch，如果在客户端断开连接期间被创建了，并且随后在客户端连接上之前又删除了，这种情况下，这个watch事件可能会被丢失。
7. 客户端注册Watcher实现
1、调用getData()/getChildren()/exist()三个API，传入Watcher对象
2、标记请求request，封装Watcher到WatchRegistration
3、封装成Packet对象，发服务端发送request
4、收到服务端响应后，将Watcher注册到ZKWatcherManager中进行管理
5、请求返回，完成注册。
8. 服务端处理Watcher实现
1、服务端接收Watcher并存储
接收到客户端请求，处理请求判断是否需要注册Watcher，需要的话将数据节点的节点路径和ServerCnxn（ServerCnxn代表一个客户端和服务端的连接，实现了Watcher的process接口，此时可以看成一个Watcher对象）存储在WatcherManager的WatchTable和watch2Paths中去。
2、Watcher触发
以服务端接收到 setData() 事务请求触发NodeDataChanged事件为例：
2.1 封装WatchedEvent
将通知状态（SyncConnected）、事件类型（NodeDataChanged）以及节点路径封装成一个WatchedEvent对象
2.2 查询Watcher
从WatchTable中根据节点路径查找Watcher
2.3 没找到；说明没有客户端在该数据节点上注册过Watcher
2.4 找到；提取并从WatchTable和Watch2Paths中删除对应Watcher（从这里可以看出Watcher在服务端是一次性的，触发一次就失效了）
3、调用process方法来触发Watcher
这里process主要就是通过ServerCnxn对应的TCP连接发送Watcher事件通知。
9. 客户端回调Watcher
客户端SendThread线程接收事件通知，交由EventThread线程回调Watcher。客户端的Watcher机制同样是一次性的，一旦被触发后，该Watcher就失效了。
10. ACL权限控制机制
UGO（User/Group/Others）
目前在Linux/Unix文件系统中使用，也是使用最广泛的权限控制方式。是一种粗粒度的文件系统权限控制模式。
ACL（Access Control List）访问控制列表
包括三个方面：
权限模式（Scheme）
1、IP：从IP地址粒度进行权限控制
2、Digest：最常用，用类似于 username:password 的权限标识来进行权限配置，便于区分不同应用来进行权限控制
3、World：最开放的权限控制方式，是一种特殊的digest模式，只有一个权限标识“world:anyone”
4、Super：超级用户
授权对象
授权对象指的是权限赋予的用户或一个指定实体，例如IP地址或是机器灯。
权限 Permission
1、CREATE：数据节点创建权限，允许授权对象在该Znode下创建子节点
2、DELETE：子节点删除权限，允许授权对象删除该数据节点的子节点
3、READ：数据节点的读取权限，允许授权对象访问该数据节点并读取其数据内容或子节点列表等
4、WRITE：数据节点更新权限，允许授权对象对该数据节点进行更新操作
5、ADMIN：数据节点管理权限，允许授权对象对该数据节点进行ACL相关设置操作
11. Chroot特性
3.2.0版本后，添加了 Chroot特性，该特性允许每个客户端为自己设置一个命名空间。如果一个客户端设置了Chroot，那么该客户端对服务器的任何操作，都将会被限制在其自己的命名空间下。
通过设置Chroot，能够将一个客户端应用于Zookeeper服务端的一颗子树相对应，在那些多个应用公用一个Zookeeper进群的场景下，对实现不同应用间的相互隔离非常有帮助。
12. 会话管理
分桶策略：将类似的会话放在同一区块中进行管理，以便于Zookeeper对会话进行不同区块的隔离处理以及同一区块的统一处理。
分配原则：每个会话的“下次超时时间点”（ExpirationTime）
计算公式：
ExpirationTime_ = currentTime + sessionTimeout
ExpirationTime = (ExpirationTime_ / ExpirationInrerval + 1) * ExpirationInterval , ExpirationInterval 是指 Zookeeper 会话超时检查时间间隔，默认 tickTime
13. 服务器角色
Leader
1、事务请求的唯一调度和处理者，保证集群事务处理的顺序性
2、集群内部各服务的调度者
Follower
1、处理客户端的非事务请求，转发事务请求给Leader服务器
2、参与事务请求Proposal的投票
3、参与Leader选举投票
Observer
1、3.0版本以后引入的一个服务器角色，在不影响集群事务处理能力的基础上提升集群的非事务处理能力
2、处理客户端的非事务请求，转发事务请求给Leader服务器
3、不参与任何形式的投票
14. Zookeeper 下 Server工作状态
服务器具有四种状态，分别是LOOKING、FOLLOWING、LEADING、OBSERVING。
1、LOOKING：寻找Leader状态。当服务器处于该状态时，它会认为当前集群中没有Leader，因此需要进入Leader选举状态。
2、FOLLOWING：跟随者状态。表明当前服务器角色是Follower。
3、LEADING：领导者状态。表明当前服务器角色是Leader。
4、OBSERVING：观察者状态。表明当前服务器角色是Observer。
15. 数据同步
整个集群完成Leader选举之后，Learner（Follower和Observer的统称）回向Leader服务器进行注册。当Learner服务器想Leader服务器完成注册后，进入数据同步环节。
数据同步流程：（均以消息传递的方式进行）
Learner向Learder注册
数据同步
同步确认
Zookeeper的数据同步通常分为四类：
1、直接差异化同步（DIFF同步）
2、先回滚再差异化同步（TRUNC+DIFF同步）
3、仅回滚同步（TRUNC同步）
4、全量同步（SNAP同步）
在进行数据同步前，Leader服务器会完成数据同步初始化：
peerLastZxid：
从learner服务器注册时发送的ACKEPOCH消息中提取lastZxid（该Learner服务器最后处理的ZXID）
minCommittedLog：
Leader服务器Proposal缓存队列committedLog中最小ZXID
maxCommittedLog：
Leader服务器Proposal缓存队列committedLog中最大ZXID
直接差异化同步（DIFF同步）
场景：peerLastZxid介于minCommittedLog和maxCommittedLog之间
先回滚再差异化同步（TRUNC+DIFF同步）
场景：当新的Leader服务器发现某个Learner服务器包含了一条自己没有的事务记录，那么就需要让该Learner服务器进行事务回滚--回滚到Leader服务器上存在的，同时也是最接近于peerLastZxid的ZXID
仅回滚同步（TRUNC同步）
场景：peerLastZxid 大于 maxCommittedLog
全量同步（SNAP同步）
场景一：peerLastZxid 小于 minCommittedLog
场景二：Leader服务器上没有Proposal缓存队列且peerLastZxid不等于lastProcessZxid
16. zookeeper是如何保证事务的顺序一致性的？
zookeeper采用了全局递增的事务Id来标识，所有的proposal（提议）都在被提出的时候加上了zxid，zxid实际上是一个64位的数字，高32位是epoch（时期; 纪元; 世; 新时代）用来标识leader周期，如果有新的leader产生出来，epoch会自增，低32位用来递增计数。当新产生proposal的时候，会依据数据库的两阶段过程，首先会向其他的server发出事务执行请求，如果超过半数的机器都能执行并且能够成功，那么就会开始执行。
17. 分布式集群中为什么会有Master？
在分布式环境中，有些业务逻辑只需要集群中的某一台机器进行执行，其他的机器可以共享这个结果，这样可以大大减少重复计算，提高性能，于是就需要进行leader选举。
18. zk节点宕机如何处理？
Zookeeper本身也是集群，推荐配置不少于3个服务器。Zookeeper自身也要保证当一个节点宕机时，其他节点会继续提供服务。
如果是一个Follower宕机，还有2台服务器提供访问，因为Zookeeper上的数据是有多个副本的，数据并不会丢失；
如果是一个Leader宕机，Zookeeper会选举出新的Leader。
ZK集群的机制是只要超过半数的节点正常，集群就能正常提供服务。只有在ZK节点挂得太多，只剩一半或不到一半节点能工作，集群才失效。
所以
3个节点的cluster可以挂掉1个节点(leader可以得到2票>1.5)
2个节点的cluster就不能挂掉任何1个节点了(leader可以得到1票<=1)
19. zookeeper负载均衡和nginx负载均衡区别
zk的负载均衡是可以调控，nginx只是能调权重，其他需要可控的都需要自己写插件；但是nginx的吞吐量比zk大很多，应该说按业务选择用哪种方式。
#### Zookeeper有哪几种几种部署模式？
部署模式：单机模式、伪集群模式、集群模式。
#### 集群最少要几台机器，集群规则是怎样的?
集群规则为2N+1台，N>0，即3台。
#### 集群支持动态添加机器吗？
其实就是水平扩容了，Zookeeper在这方面不太好。两种方式：
全部重启：关闭所有Zookeeper服务，修改配置之后启动。不影响之前客户端的会话。
逐个重启：在过半存活即可用的原则下，一台机器重启不影响整个集群对外提供服务。这是比较常用的方式。
3.5版本开始支持动态扩容。
23. Zookeeper对节点的watch监听通知是永久的吗？为什么不是永久的?
不是。官方声明：一个Watch事件是一个一次性的触发器，当被设置了Watch的数据发生了改变的时候，则服务器将这个改变发送给设置了Watch的客户端，以便通知它们。
为什么不是永久的，举个例子，如果服务端变动频繁，而监听的客户端很多情况下，每次变动都要通知到所有的客户端，给网络和服务器造成很大压力。
一般是客户端执行getData(“/节点A”,true)，如果节点A发生了变更或删除，客户端会得到它的watch事件，但是在之后节点A又发生了变更，而客户端又没有设置watch事件，就不再给客户端发送。
在实际应用中，很多情况下，我们的客户端不需要知道服务端的每一次变动，我只要最新的数据即可。
24. Zookeeper的java客户端都有哪些？
java客户端：zk自带的zkclient及Apache开源的Curator。
25. chubby是什么，和zookeeper比你怎么看？
chubby是google的，完全实现paxos算法，不开源。zookeeper是chubby的开源实现，使用zab协议，paxos算法的变种。
26. 说几个zookeeper常用的命令。
常用命令：ls get set create delete等。
27. ZAB和Paxos算法的联系与区别？
相同点：
1、两者都存在一个类似于Leader进程的角色，由其负责协调多个Follower进程的运行
2、Leader进程都会等待超过半数的Follower做出正确的反馈后，才会将一个提案进行提交
3、ZAB协议中，每个Proposal中都包含一个 epoch 值来代表当前的Leader周期，Paxos中名字为Ballot
不同点：
ZAB用来构建高可用的分布式数据主备系统（Zookeeper），Paxos是用来构建分布式一致性状态机系统。
28. Zookeeper的典型应用场景
Zookeeper是一个典型的发布/订阅模式的分布式数据管理与协调框架，开发人员可以使用它来进行分布式数据的发布和订阅。
通过对Zookeeper中丰富的数据节点进行交叉使用，配合Watcher事件通知机制，可以非常方便的构建一系列分布式应用中年都会涉及的核心功能，如：
1、数据发布/订阅
2、负载均衡
3、命名服务
4、分布式协调/通知
5、集群管理
6、Master选举
7、分布式锁
8、分布式队列
1. 数据发布/订阅
介绍
数据发布/订阅系统，即所谓的配置中心，顾名思义就是发布者发布数据供订阅者进行数据订阅。
目的
动态获取数据（配置信息）
实现数据（配置信息）的集中式管理和数据的动态更新
设计模式
Push 模式
Pull 模式
数据（配置信息）特性：
1、数据量通常比较小
2、数据内容在运行时会发生动态更新
3、集群中各机器共享，配置一致
如：机器列表信息、运行时开关配置、数据库配置信息等
基于Zookeeper的实现方式
1、数据存储：将数据（配置信息）存储到Zookeeper上的一个数据节点
2、数据获取：应用在启动初始化节点从Zookeeper数据节点读取数据，并在该节点上注册一个数据变更Watcher
3、数据变更：当变更数据时，更新Zookeeper对应节点数据，Zookeeper会将数据变更通知发到各客户端，客户端接到通知后重新读取变更后的数据即可。
2. 负载均衡
zk的命名服务
命名服务是指通过指定的名字来获取资源或者服务的地址，利用zk创建一个全局的路径，这个路径就可以作为一个名字，指向集群中的集群，提供的服务的地址，或者一个远程的对象等等。
分布式通知和协调
对于系统调度来说：操作人员发送通知实际是通过控制台改变某个节点的状态，然后zk将这些变化发送给注册了这个节点的watcher的所有客户端。
对于执行情况汇报：每个工作进程都在某个目录下创建一个临时节点。并携带工作的进度数据，这样汇总的进程可以监控目录子节点的变化获得工作进度的实时的全局情况。
zk的命名服务（文件系统）
命名服务是指通过指定的名字来获取资源或者服务的地址，利用zk创建一个全局的路径，即是唯一的路径，这个路径就可以作为一个名字，指向集群中的集群，提供的服务的地址，或者一个远程的对象等等。
zk的配置管理（文件系统、通知机制）
程序分布式的部署在不同的机器上，将程序的配置信息放在zk的znode下，当有配置发生改变时，也就是znode发生变化时，可以通过改变zk中某个目录节点的内容，利用watcher通知给各个客户端，从而更改配置。
Zookeeper集群管理（文件系统、通知机制）
所谓集群管理无在乎两点：是否有机器退出和加入、选举master。
对于第一点，所有机器约定在父目录下创建临时目录节点，然后监听父目录节点的子节点变化消息。一旦有机器挂掉，该机器与 zookeeper的连接断开，其所创建的临时目录节点被删除，所有其他机器都收到通知：某个兄弟目录被删除，于是，所有人都知道：它上船了。
新机器加入也是类似，所有机器收到通知：新兄弟目录加入，highcount又有了，对于第二点，我们稍微改变一下，所有机器创建临时顺序编号目录节点，每次选取编号最小的机器作为master就好。
## Zookeeper分布式锁（文件系统、通知机制）
有了zookeeper的一致性文件系统，锁的问题变得容易。锁服务可以分为两类，一个是保持独占，另一个是控制时序。
对于第一类，我们将zookeeper上的一个znode看作是一把锁，通过createznode的方式来实现。所有客户端都去创建 /distribute_lock 节点，最终成功创建的那个客户端也即拥有了这把锁。用完删除掉自己创建的distribute_lock 节点就释放出锁。
对于第二类， /distribute_lock 已经预先存在，所有客户端在它下面创建临时顺序编号目录节点，和选master一样，编号最小的获得锁，用完删除，依次方便。
Zookeeper队列管理（文件系统、通知机制）
两种类型的队列：
1、同步队列，当一个队列的成员都聚齐时，这个队列才可用，否则一直等待所有成员到达。
2、队列按照 FIFO 方式进行入队和出队操作。
第一类，在约定目录下创建临时目录节点，监听节点数目是否是我们要求的数目。
第二类，和分布式锁服务中的控制时序场景基本原理一致，入列有编号，出列按编号。在特定的目录下创建PERSISTENT_SEQUENTIAL节点，创建成功时Watcher通知等待的队列，队列删除序列号最小的节点用以消费。此场景下Zookeeper的znode用于消息存储，znode存储的数据就是消息队列中的消息内容，SEQUENTIAL序列号就是消息的编号，按序取出即可。由于创建的节点是持久化的，所以不必担心队列消息的丢失问题。
