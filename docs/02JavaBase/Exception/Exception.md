异常
====

![D:\\1 - 副本\\Evernote_files\\Image [34].png](media/212c96627c2ffa4819a92c8ae88b23c5.png)

Throwable类是java中Error(错误)和Exception(异常)的父类    
 当程序在运行过程中产生了异常，则程序中止运行

Error类及其子类在开发中一般不用处理

Exception是所有异常的父类    
分为运行时异常（RunTimeException类及其子类[非强制性异常]）和非运行时异常（非RunTimeException的其他子类[强制捕获型异常]）

Error和Exception的区别和联系：
------------------------------

java 中 Throwable 类有两个子类，分别为 Error 和 Exception。

Error 类及其子类用于定义合理的 java 程序不应该处理的错误信息；

Exception 类及其子类用于定义合理的 java 应用程序需要捕获的异常信息。
```

捕获异常：try catch

格式：

try{

可能出现异常的代码

 }catch( 要扑火的异常  变量名 ){

处理异常的代码，如果没有异常，这里不执行 

}finally{ 无论是否捕获住异常都会执行的代码 

}  
```
注：finally关键字用于异常处理，无论是否出现异常，都会执行

使用注意点：

catch时大异常放到后面，小异常放到前面，兄弟异常随便

printStackTrace()  打印异常信息

try可以有多个catch子句，但只能有一个finally子句

抛出异常：

通过 throw 关键字可以在方法中手动抛出异常(throw new
Exception())。在方法签名处可以通过 throws关键字标明这个方法抛出了哪些异常
```java
//一个方法可以抛出多个异常：
public void setAge(int age) thorws BadException,RunTimeExpection{
  if(age < = 0){
    throw new BadException("年龄数据错误");
  }

}
```


```java
//一个方法可以抛出多个异常，逗号分割 
public void setAge(int age) thorws BadException,RunTimeExpection{

}
```

在方法中抛出一个非运行时异常，则必须在方法签名处使用throws关键字标记，调用者使用try
catch将代码块包裹

自定义异常：通过类继承现有的异常实现

自定义异常继承自 Exception 类或者 Exceptionde 子类，就创建了自定义异常。

分类：自定义异常也分为运行时异常和非运行时异常，继承自 RuntimeException
及其子类是运行时异常，否则是非运行时异常

### 常见的异常以及避免方法

- java.lang.NullPointerException(空指针异常)  
> 当对象的值为null时候调用对象的方法或者属性的时候会引起空指针异常        
注意：不能使用null的equals方法进行比较，否则会报错
避免方法：1.短路操作（关系运算符&&  \|\|）  
2.变换顺序，使用"".equals(null),不使用null.equals("")

- java.lang.ArrayIndexOutOfBoundsException(数组下标越界异常)  
>在使用数组的时候，下标大于最大下标值(数组length-1)或者使用负下标值都会引起该异常

- java.lang.IndexOutOfBoundsException   在集合list添加数据时，add("A",B)
 如果索引超出范围 (index \< 0 \|\| index \> size())

java.lang.ArithmeticException:divide by zero 除数不能为0

java.lang.StackOverflowError     栈内存溢出    当出现死循环时，容易出现该异常

java.lang.ClassCastException(类型转换异常)
 进行强制类型转换的时候产生的异常，一般是在父类引用指向子类对象时出现，如果父类引用指向的子类对象的类型不是目标子类类型而进行强制类型转换时将产生类型转换异常，例如
Aniaml animal= new  Cat();Dog dog = （Dog）animal 强转 animal 对象为 Dog
类型时出现

java.lang.NumberFormatException 数字格式异常   
 在String转Integer时，传入的参数必须是纯数字的字符串，否则就会抛出该异常

java.io.FileNotFoundException 文件找不到
FileOutputSream()创建输出流的时候，如果该文件存在，但它是一个目录，而不是常规文件；或者该文件不存在会去创建它，但无法创建它；抑或因为其他某些原因而无法打开它，则抛出该异常

java.io.NotSerializableException
 当实例需要具有序列化接口时，抛出此异常，序列化运行时或实例的类会抛出此异常。参数应该为类的名称

### 什么是异常

对问题的描述。将问题进行对象的封装。

导致程序运行不正常的现象有很多，所以，就有很多的异常对象。

而这些异常对象存在着共性的内容，所以，可以不断的进行抽取。最终形成了异常的体系结构。

**异 常：**
----------------

Throwable
---------

\--------java.lang.Throwable：异常体系的根类

Throwable：可抛出的。

\|--Error：重大的问题，我们处理不了。也不需要编写代码处理。比如说内存溢出。

\|--Exception：一般性的错误，是需要我们编写代码进行处理的。

\|--RuntimeException:运行时异常，这个我们也不需要处理。其实就是为了让他在运行时出问题，然后我们回来修改代码。

无论是错误还是异常，它们都有具体的子类体现每一个问题，它们的子类都有一个共性，就是都以父类名才作为子类的后缀名。

这个体系中的所有类和对象都具备一个独有的特点；就是可抛性。

可抛性的体现：就是这个体系中的类和对象都可以被throws和throw两个关键字所操作。
```java

class ExceptionDemo{

public static void main(String[] args) {

//byte[] buf = new
byte[1024\*1024\*700];//java.lang.OutOfMemoryError内存溢出错误

}

}
```
在开发时，如果定义功能时，发现该功能会出现一些问题，应该将问题在定义功能时标示出来，这样调用者就可以在使用这个功能的时候，预先给出处理方式。

如何标示呢？通过throws关键字完成，格式：throws 异常类名,异常类名...

这样标示后，调用者，在使用该功能时，就必须要处理，否则编译失败。

处理方式有两种：1、捕捉；2、抛出。

对于捕捉：java有针对性的语句块进行处理。

try {

需要被检测的代码；

}

catch(异常类 变量名){

异常处理代码；

}

fianlly{

一定会执行的代码；

}

假如catch中有return语句， finally里中的代码会执行吗？

是在return前，还是在return后呢？

会，在return前执行finally里面的代码。

catch (Exception e) { //e用于接收try检测到的异常对象。

System.out.println("message:"+e.getMessage());//获取的是异常的信息。

System.out.println("toString:"+e.toString());//获取的是异常的名字+异常的信息。

e.printStackTrace();//打印异常在堆栈中信息；异常名称+异常信息+异常的位置。

}

## 异常处理原则
------------

功能抛出几个异常，功能调用如果进行try处理，需要与之对应的catch处理代码块，这样的处理有针对性，抛几个就处理几个。

特殊情况：try对应多个catch时，如果有父类的catch语句块，一定要放在下面。

## throw 和throws关键字的区别：
----------------------------

有throws的时候可以没有throw。

有throw的时候，如果throw抛的异常是Exception体系，那么必须有throws在方法上声明。

throw用于抛出异常对象，后面跟的是异常对象；throw用在方法内。

throws用于抛出异常类，后面跟的异常类名，可以跟多个，用逗号隔开。throws用在方法上。

通常情况：方法内容如果有throw，抛出异常对象，并没有进行处理，那么方法上一定要声明，否则编译失败。但是也有特殊情况。

注意：RunTimeExpection除外，也就说，函数内如果抛出的是RuntimeExpection异常，函数上可以不用声明。

## 异常分两种：
------------

1：编译时被检查的异常，只要是Exception及其子类都是编译时被检测的异常。该异常在编译时，如果没有处理(没有抛也没有try)，编译失败。该异常被标识，代表着可以被处理。

2：运行时异常，其中Exception有一个特殊的子类RuntimeException，以及RuntimeException的子类是运行异常，也就说这个异常是编译时不被检查的异常。

在编译时，不需要处理，编译器不检查。

该异常的发生，建议不处理，让程序停止。需要对代码进行修正。

编译时被检查的异常和运行时异常的区别：
--------------------------------------

编译被检查的异常在方法内被抛出，方法必须要声明，否编译失败。

声明的原因：是需要调用者对该异常进行处理。

运行时异常如果在方法内被抛出，在方法上不需要声明。

不声明的原因：不需要调用者处理，运行时异常发生，已经无法再让程序继续运行，所以，不让调用处理的，直接让程序停止，由调用者对代码进行修正。

定义异常处理时，什么时候定义try，什么时候定义throws呢？

功能内部如果出现异常，如果内部可以处理，就用try；

如果功能内部处理不了，就必须声明出来，让调用者处理。使用throws抛出，交给调用者处理。谁调用了这个功能谁就是调用者；

自定义异常：当开发时，项目中出现了java中没有定义过的问题时，这时就需要我们按照java异常建立思想，将项目的中的特有问题也进行对象的封装。这个异常，称为自定义异常。

对于除法运算，0作为除数是不可以的。java中对这种问题用ArithmeticException类进行描述。对于这个功能，在我们项目中，除数除了不可以为0外，还不可以为负数。可是负数的部分java并没有针对描述。所以我们就需要自定义这个异常。

## 自定义异常的步骤：
------------------

1：定义一个子类继承Exception或RuntimeException，让该类具备可抛性(既可以使用throw和throws去调用此类)。

2：通过throw 或者throws进行操作。
```JAVA
class MyExcepiton extends Exception{
  MyExcepiton(){}
  MyExcepiton(String message){
      super(message);
  }
}
class MyException extends RuntimeException{
  MyExcepiton(){}
  MyExcepiton(String message){
  super(message);
  }
}
```
异常的转换思想：
当出现的异常是调用者处理不了的，就需要将此异常转换为一个调用者可以处理的异常抛出。

try catch finally的几种结合方式：

try...catch

try...catch...catch...

try...catch...catch...finally

这种情况，如果出现异常，并不处理，但是资源一定关闭，所以try
finally集合只为关闭资源。

记住：finally很有用，主要用户关闭资源。无论是否发生异常，资源都必须进行关闭。

System.exit(0); //退出jvm，只有这种情况finally不执行。

当异常出现后，在子父类进行覆盖时，有了一些新的特点：

1：当子类覆盖父类的方法时，如果父类的方法抛出了异常，那么子类的方法要么不抛出异常要么抛出父类异常或者该异常的子类，不能抛出其他异常。

2：如果父类抛出了多个异常，那么子类在覆盖时只能抛出父类的异常的子集。

注意：

如果父类或者接口中的方法没有抛出过异常，那么子类是不可以抛出异常的，如果子类的覆盖的方法中出现了异常，只能try不能throws。

如果这个异常子类无法处理，已经影响了子类方法的具体运算，这时可以在子类方法中，通过throw抛出RuntimeException异常或者其子类，这样，子类的方法上是不需要throws声明的。

多个异常同时被捕获的时候，记住一个原则：

先逮小的，再逮大的。

## Exception和RuntimeException的区别
---------------------------------

A:Exception:一般性的错误，是需要我们编写代码进行处理的。

B:RuntimeException:运行时异常，这个我们也不需要处理。

其实就是为了让他在运行时出问题，然后我们回来修改代码。

在用throws抛出一个的时候，如果这个异常是属于RuntimeException的体系的时候，

我们在调用的地方可以不用处理。(RuntimeException和RuntimeException的子类)

在用throws抛出一个的时候，如果这个异常是属于Exception的体系的时候，

我们在调用的地方必须进行处理或者继续抛出。



## main方法是如何处理异常的。

A:在main里面编写代码进行处理

B:交给jvm自己进行处理。采用的是jvm的默认处理方式。

其实就是相当于调用了异常对象的printStackTrace()方法。

## Throwable类的学习

getMessage():获取异常信息，返回字符串。

toString():获取异常类名和异常信息，返回字符串。

printStackTrace():获取异常类名和异常信息，以及异常出现在程序中的位置。返回值void。
