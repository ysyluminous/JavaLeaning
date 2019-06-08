/************************************************************************
 *
 * 文件名:	ExceptionDemo2
 *
 * 文件描述:	第9天_05_面向对象_异常概述
 第9天_06_面向对象_异常try-catch
 *
 * 创建人:	Yao Siyuan,
 *
 * 总结:
 *
 * 版本号:	0.1
 *
 * 修改记录:
 *			0.1:
 *
 ************************************************************************/


/*
异常:就是程序在运行时出现的不正常情况。
异常由来：问题也是现实生活中一个具体的事物，也可以通过java累的形式进行描述，并封装成对象
	其实就是java对不正常情况进行描述后的对象体现。

对于问题的划分：两种：一种是严重的问题，一种是非严重的问题。
	对于error一般不编写针对性的代码对其进行处理。
对于非严重的，java通过Exception类进行描述。
	对于Exception可以使用针对性的处理方式进行处理。

无论Error或者Exception都具有一些共性内容。
比如：不正常情况的信息，引发原因等。

Throwable
	|--Error
	|--Exceotion

2、异常的处理
java提供了特有的语句进行处理
try
{
	需要被检测的代码；
}
catch(异常类 变量)
{
	处理异常的代码；(处理方式)
}
finaly
{
	一定会执行的语句；
}

3.对捕获到的异常对象进行常见方法操作。
	String getMessage() :获取异常的信息


在函数上声明异常
便于提高安全性，让调用出进行处理，不处理编译失败

对多异常的处理
1.声明异常时候，建议声明更为具体的异常，这样处理的可以更具体。

*/



class Demo
{
    //在功能上通过throws关键字生命了该功能有可能会出现问题
    int div(int a, int b)  throws ArithmeticException,ArrayIndexOutOfBoundsException
    {
        int [] arr = new int [a];
        System.out.println(arr[5]);
        return a / b;
    }
}


class ExceptionDemo2
{
    public static void main(String args []){ //throws Exception

        Demo d = new Demo();
        try{
            int x = d.div(5,1);
            System.out.println("x="+x);
        }

        catch(ArithmeticException e)
        {
                                        //父类的引用接收子类的对象
            System.out.println("除0了"); //Exception e = new ArithmeticException();
            System.out.print(e.toString());

        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.print(e.toString());
            System.out.print("角标越界了");

        }

        System.out.println("Over");



    }
}













