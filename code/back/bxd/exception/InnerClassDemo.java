/************************************************************************
 *
 * 文件名:	InnerClassDemo
 * 			
 * 文件描述:	第9天_01_面向对象_内部类访问规则
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
/*内部类的访问规则:
1.内部类可以直接访问外部类汇中的成员，包括私有。
2.外部类要访问内部类，必须建立内部类对象。
*/
class Outer
{
	private int x = 3;  //私有在本类中有效
	
	private class Inner //内部类，内部类可以被私有修饰
	{
		int x = 4；
		void function()
		{
			int x = 6；
			System.out.println("inner :"+ Outer.this.x);
		}
	}
	
	void method()
	{
		Inner in = new Inner();
		in.function();
		
	}
}

class InnerClassDemo
{
	public static void main(String args[])
	{
		//Outer out = new Outer();
		//out.method();
		
		//直接访问内部类中的成员
		//外部类.内部类名 = new 外部类.new 内部类
		Outer.Inner in = new Outer().new Inner();
		in.method();
	}
}
















