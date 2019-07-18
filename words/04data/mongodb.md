相比关系型数据库存储灵活，字段格式灵活更改。可以允许包含不同个字段的域。

安装 MongoDB服务
----------------

通过执行bin/mongod.exe，使用--install选项来安装服务，使用--config选项来指定之前创建的配置文件。
cmd进

入d:\\MongoDB\\Server\\3.4\\bin

C:\\Program Files\\MongoDB\\Server\\3.4\\

mongod.exe --config "C:\\Program Files\\MongoDB\\Server\\3.4\\mongo.conf"
--install

启动MongoDB服务

net start MongoDB

关闭MongoDB服务

net stop MongoDB

移除MongoDB服务

" d:\\MongoDB\\Server\\3.4\\bin\\mongod.exe" ‐‐remove

启动mongodb服务，

命令执行后，浏览器中输入http://127.0.0.1:27017看到如下界面即说明启动成功

![](media/56f07d001fb56e8554ce543d2ae2bac8.png)

出现下图说明安装成功

![](media/adc349e9d1acff9592419ee38d5c5baf.png)

也可以通过bin目录下的mongo.exe连接mongodb

![](media/e743aac38a0c41cdcf6fe5a8c2bce457.png)

安装studio3t

studio3t是mongodb优秀的客户端工具。官方地址在<https://studio3t.com/>

### 下载 studio3t

![](media/95533f997cec3727247a5271e71859ff.png)

### 安装并启动：

### 创建一个新连接：

![](media/a91eca97aeeea010ed67760fee4839fb.png)

![](media/7ec475b84fe202b25efa3842524c5112.png)

### 填写连接信息：

![](media/94aef8ae26cc7ffd99c73d85267199c2.png)

### 连接成功：

![](media/b8bed83f5db168deb0266ab8e7ee1513.png)

### 修改字体：

默认Studio3t的字体太小，需要修改字体：

点击菜单：Edit--->Preferences

![](media/9270e122ddbea4bb953e1a5726b2f6ee.png)

连接mongodb
-----------

mongodb的使用方式是客户服务器模式，即使用一个客户端连接mongodb数据库（服务端）。

### 命令格式

mongodb://[username:password\@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?

options]]

mongodb:// 固定前缀

username：账号，可不填

password：密码，可不填

host：主机名或ip地址，只有host主机名为必填项。

port：端口，可不填，默认27017

/database：连接某一个数据库

?options：连接参数，key/value对

例子：

mongodb://localhost 连接本地数据库27017端口

mongodb://root:itcast\@localhost
使用用户名root密码为itcast连接本地数据库27017端口

mongodb://localhost,localhost:27018,localhost:27019，连接三台主从服务器，端口为27017、27018、27019

### 使用mongodb自带的javascript shell（mongo.exe）连接

windows 版本的mongodb安装成功，在安装目录下的bin目录有mongo.exe客户端程序

![](media/80b164971588ac38abf27ced12d32fcf.png)

cmd状态执行mongo.exe：

![](media/7d7bbe3ee58abfecc794a551648a85b2.png)

此时就可以输入命令来操作mongodb数据库了，javascript
shell可以运行javascript程序。

### 使用studio3T连接

### 使用java程序连接

详细参数：http://mongodb.github.io/mongo-java-driver/3.4/driver/tutorials/connect-to-mongodb/

添加依赖：
```
<dependency>
  <groupId>org.mongodb</groupId>
  <artifactId>mongo‐java‐driver</artifactId>
  <version>3.4.3</version>
</dependency>
```

测试程序：
```java

\@Test

public void testConnection(){

//创建mongodb 客户端

MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

//或者采用连接字符串

//MongoClientURI connectionString = new

MongoClientURI("mongodb://root:root\@localhost:27017");

//MongoClient mongoClient = new MongoClient(connectionString);

//连接数据库

MongoDatabase database = mongoClient.getDatabase("test");

// 连接collection

MongoCollection<Document> collection = database.getCollection("student");

//查询第一个文档

Document myDoc = collection.find().first();

//得到文件内容 json串

String json = myDoc.toJson();

System.out.println(json);

}
```

数据库
------

1、查询数据库

show dbs 查询全部数据库

db 显示当前数据库

2、创建数据库

命令格式：

use DATABASE_NAME

例子：

use test02

有test02数据库则切换到此数据库，没有则创建。

注意：

新创建的数据库不显示，需要至少包括一个集合。

3、删除数据库（慎用！！！）

命令格式：

db.dropDatabase()

例子：

删除test02数据库

先切换数据库：use test02

再执行删除：db.dropDatabase()

集合
----

集合相当于关系数据库中的表，一个数据库可以创建多个集合，一个集合是将相同类型的文档管理起来。

1 、创建集合

db.createCollection(name, options)

name: 新创建的集合名称

options: 创建参数 可省略

例子

> db.createCollection("student")

{ "ok" : 1 }

2、删除集合

db.collection.drop()

例子：

db.student.drop() 删除student集合

文档
----

### 插入文档

mongodb中文档的格式是json格式，下边就是一个文档，包括两个key：_id主键和name
```

{

"_id" : ObjectId("5b2cc4bfa6a44812707739b5"),

"name" : "test"

}
```

插入命令：
```
db.COLLECTION_NAME.insert(document)
```

每个文档默认以_id作为主键，主键默认类型为ObjectId（对象类型），mongodb会自动生成主键值。

例子：
```

db.student.insert({"name":"test","age":10})
```

注意：同一个集合中的文档的key可以不相同！但是建议设置为相同的。

### 更新文档

命令格式：

db.collection.update(

<query>,

<update>,

<options>

)

query:查询条件，相当于sql语句的where

update：更新文档内容

options：选项

#### 替换文档

>   将符合条件
>   "name":"北京黑马程序"的第一个文档替换为{"name":"北京黑马程序员","age":10}。

db.student.update({"name":"test"},{"name":"北京黑马程序员","age":10})

#### \$set修改器

使用\$set修改器指定要更新的key，key不存在则创建，存在则更新。

将符合条件 "name":"北京黑马程序"的所有文档更新name和age的值。

db.student.update({"name":"黑马程序员"},{\$set:{"name":"北京黑马程序员","age":10}},{multi:true})

multi：false表示更新第一个匹配的文档，true表示更新所有匹配的文档。

删除文档
--------

命令格式：

db.student.remove(<query>)

query：删除条件，相当于sql语句中的where

1、删除所有文档

db.student.remove({})

2、删除符合条件的文档

db.student.remove({"name":"黑马程序员"})

查询文档
--------

命令格式：

db.collection.find(query, projection)

query：查询条件，可不填

projection：投影查询key，可不填

1、查询全部

db.student.find()

2、查询符合条件的记录

查询name等为"黑马程序员"的文档。

db.student.find({"name":"黑马程序员"})

3、投影查询

只显示name和age两个key，_id主键不显示。

db.student.find({"name":"黑马程序员"},{name:1,age:1,_id:0})

用户
----

### 创建用户

语法格式：

mongo>db.createUser(

{ user: "<name>",

pwd: "<cleartext password>",

customData: { <any information> },

roles: [

{ role: "<role>", db: "<database>" } \| "<role>",

...

]}

)

例子：

创建root用户，角色为root

use admin

db.createUser(

{

user:"root",

pwd:"root",

roles:[{role:"root",db:"admin"}]

}

)

内置角色如下：

1. 数据库用户角色：read、readWrite;

2. 数据库管理角色：dbAdmin、dbOwner、userAdmin；

3 . 集群管理角色：clusterAdmin、clusterManager、clusterMonitor、hostManager；

4. 备份恢复角色：backup、restore；

5. 所有数据库角色：readAnyDatabase、readWriteAnyDatabase、userAdminAnyDatabase、

dbAdminAnyDatabase

6. 超级用户角色：root

查询用户

查询当前库下的所有用户：

show users

### 认证登录

1、mongo.conf文件新增：

\#开启认证

auth=true

2、重启服务

3、使用账号密码链接

mongo.exe链接

mongo.exe -u root -p root --authenticationDatabase admin

3T链接

![](media/06350392da39bcc51c02c51d295164bb.png)

### 删除用户

语法格式：

db.dropUser("用户名")

例子：
```

use admin

db.createUser(

{

user:"test",

pwd:"test",

roles:[{role:"root",db:"admin"}]

}

)
```
删除root1用户

```
db.dropUser("test")
```

### 修改用户

语法格式：
```

db.updateUser(

"<username>",

{

  customData : { <any information> },

  roles : [

  { role: "<role>", db: "<database>" } \| "<role>",

  ...

  ],

  pwd: "<cleartext password>"

},

writeConcern: { <write concern> })
```

例子：

修改test用户的角色为readWriteAnyDatabase

use admin

db.updateUser("test",{roles:[{role:"readWriteAnyDatabase",db:"admin"}]})

修改密码

语法格式：

db.changeUserPassword("username","newPasswd")

例子：

修改test用户的密码为123

use admin

db.changeUserPassword("test","123")

常见问题
========

破解studio 3t
-------------

Studio 3T 临时破解教程

使用数据可视化工具Studio 3T查看MongoDB数据集数据，但是Studio
3T试用过期了，没了权限打不开软件怎么办？

这里通过建立批处理文件，重置试用时间，即可临时破解权限。

每次开机重启脚本重置试用时间，即可重新获得使用权Studio 3T；

注意： 此教程通过重置studio 3t的试用时间解决无法使用的问题，并非永久破解；

代码仅作为参考。

| \@echo off ECHO 重置Studio 3T的使用日期...... FOR /f "tokens=1,2,\* " %%i IN ('reg query "HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\3t\\mongochef\\enterprise" \^\| find /V "installation" \^\| find /V "HKEY"') DO ECHO yes \| reg add "HKEY_CURRENT_USER\\Software\\JavaSoft\\Prefs\\3t\\mongochef\\enterprise" /v %%i /t REG_SZ /d "" ECHO 重置完成, 按任意键退出...... pause>nul exit |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|


二、将批处理文件studio3t.bat剪贴或复制到如下路径：

C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp

在桌面生成该批文件的快捷方式 （如下图）

双击该批处理文件 · 运行重置试用时限

![å¨è¿éæå¥å¾çæè¿°](media/330dc799a822094213f8617ede504db3.jpg)

上图，路径找不到，就通过显示隐藏文件夹，来找到文件夹ProgramData …

三、双击桌面Studio 3T软件的快捷方式，完成启用并开始使用服务。

<https://blog.csdn.net/u012211603/article/details/85178856>

mongodb无法注册windows服务
--------------------------

2019-03-31T11:11:43.033+0800 I CONTROL [main] \*\*\*\*\* SERVER RESTARTED
\*\*\*\*\*

2019-03-31T11:11:43.466+0800 I CONTROL [main] Trying to install Windows service
'MongoDB'

2019-03-31T11:11:43.468+0800 I CONTROL [main] Error connecting to the Service
Control Manager: 拒绝访问。 (5)

cmder开启管理员后

2019-03-31T11:15:13.307+0800 I CONTROL [main] \*\*\*\*\* SERVER RESTARTED
\*\*\*\*\*

2019-03-31T11:15:13.717+0800 I CONTROL [main] Trying to install Windows service
'MongoDB'

2019-03-31T11:15:13.720+0800 I CONTROL [main] Service 'MongoDB' (MongoDB)
installed with command line '"C:\\Program
Files\\MongoDB\\Server\\3.4\\bin\\mongod.exe" --config "C:\\Program
Files\\MongoDB\\Server\\3.4\\mongo.conf" --service'

2019-03-31T11:15:13.720+0800 I CONTROL [main] Service can be started from the
command line with 'net start MongoDB'

发生服务特定错误: 100.
----------------------

λ net start MongoDB

MongoDB 服务正在启动 .

MongoDB 服务无法启动。

发生服务特定错误: 100.

请键入 NET HELPMSG 3547 以获得更多的帮助。

方法，

1、安装目录没有 data目录

2、在mongodb安装路径下data文件中有两个文件一个mongod.lock和storage.bson，一般删除mongod.lock就可以了，如果服务错误代码100还不能解决，就把storage.bson一起删掉再启动就可以了！

解决后

λ net start MongoDB

MongoDB 服务正在启动 ..

MongoDB 服务已经启动成功。
