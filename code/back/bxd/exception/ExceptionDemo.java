/************************************************************************
 *
 * 文件名:	ExceptionDemo
 * 			
 * 文件描述:	第9天_05_面向对象_异常概述
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
*/


class Demo
{
	int div(int a, int b) 
	{
		return a / b;
	}
}


class Exception
{
	public static void main(String args [])
	{
		Demo d = new Demo();
		int x = d.div(4.0);
		System.out.println("x="+x);
		
		System.out.println("Over");
		
		 
	}
}













