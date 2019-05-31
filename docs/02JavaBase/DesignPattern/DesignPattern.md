单例设计模式：★★★★★(必问的) 
----------------------------

解决的问题：**保证一个类在内存中的对象唯一性。** 

比如：多程序读取一个配置文件时，建议配置文件封装成对象。会方便操作其中数据，又要保证多个程序读到的是同一个配置文件对象，就需要该配置文件对象在内存中是唯一的。

** Runtime()方法就是单例设计模式进行设计的。**

** 如何保证对象唯一性呢？ **

**思想：** 

1，不让其他程序创建该类对象。

 2，在本类中创建一个本类对象。 

3，对外提供方法，让其他程序获取这个对象。 

**步骤：** 

1，因为创建对象都需要构造函数初始化，只要将本类中的构造函数私有化，其他程序就无法再创建该类对象； 

2，就在类中创建一个本类的对象； 

3，定义一个方法，返回该对象，让其他程序可以通过方法就得到本类对象。（作用：可控） 

**代码体现：** 

1，私有化构造函数； 

2，创建私有并静态的本类对象； 

3，定义公有并静态的方法，返回该对象。 
```JAVA

//饿汉式 

class Single{ 

private Single(){} //私有化构造函数。 

private static Single s = new Single();  //创建私有并静态的本类对象。

 public static Single getInstance(){  //定义公有并静态的方法，返回该对象。 

return s; 

} 

} 

//懒汉式:延迟加载方式。

 Class Single2{ 

private Single2(){} 

private static Single2 s = null; 

public static Single2 getInstance(){ 

if(s==null) 

s = new Single2(); 

return s; 

}

 }
```

## 饿汉式和懒汉式的区别：

饿汉式是类一加载进内存就创建好了对象；

懒汉式则是类才加载进内存的时候，对象还没有存在，只有调用了getInstance()方法时，

对象才开始创建。


懒汉式是延迟加载，如果多个线程同时操作懒汉式时就有可能出现线程安全问题，解决线程安全问题

可以加同步来解决。但是加了同步之后，每一次都要比较锁，效率就变慢了，

所以可以加双重判断来提高程序效率。

如将上述懒汉式的Instance函数改成同步：
```JAVA

public static Single getInstance()

{

if(s==null)

{

synchronized(Single.class)

{

if(s==null)

s=new Single();

}

}

return s;

}
```

注：开发常用饿汉式，因为饿汉式简单安全。懒汉式多线程的时候容易发生问题

### 模板方法设计模式：

解决的问题：当功能内部一部分实现时确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
```java
abstract class GetTime{
 //此功能如果不需要复写，可加final限定
  public final void getTime(){

    long start = System.currentTimeMillis();
//不确定的功能部分，提取出来，通过抽象方法实现
    code();
    long end = System.currentTimeMillis();

    System.out.println("毫秒是："+(end-start));
  }
//抽象不确定的功能，让子类复写实现
  public abstract void code();

}

  class SubDemo extends GetTime{

  public void code(){ //子类复写功能方法

    for(int y=0; y\<1000; y++){

    System.out.println("y");

  }

  }

}
```
