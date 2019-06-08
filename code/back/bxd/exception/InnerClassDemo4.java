/************************************************************************
 *
 * 文件名:	InnerClassDemo4
 * 			
 * 文件描述:	第9天_04_面向对象_匿名内部类
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
内部类定义在局部时，
	1.不可以被成员修饰符修饰
	2.可以直接访问外部类中的成员，因为还有外部类中的引用。
	但是不可以访问它所在的局部中的变量，只能访问被final修饰的局部变量。

*/
 
class Outer
{
	int x = 3;
	
	void method()
	{
		final int y = 4;
		class Inner
		{
			void function()
			{
				System.out.print(y);
			}
			new Inner().function();
		}
	}
}

class InnerClassDemo4
{
	public static void main(String args [])
	{
		Outer out = new Outer();
		//两次进出栈内存
		out.method(7);
		out.method(8);
	}
}
 
 
 
 
 
 