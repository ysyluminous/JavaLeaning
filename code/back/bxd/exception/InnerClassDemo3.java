/************************************************************************
 *
 * 文件名:	InnerClassDemo3
 * 			
 * 文件描述:	第9天_03_面向对象_内部类定义原则
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


访问格式：
当内部类定义在外部类的成员位置上，而且并非私有，可以在外部其他类中。
格式：
	外部类名.内部类名 变量名 = 外部类对象.内部类对象
	
2.当内部类在成员位置上，就可以被成员修饰符所修饰
	比如 private：讲内部类在外部类中进行封装
	static：内部类就具备static的特性。
	？？当内部类被static修饰后，就只能访问外部类中的static成员，出现了访问局限。
	
	在外部其他类中，如何直接访问static内部类中的非静态成员？
	new Outer.Inner().function();
	
	在外部其他类中，如何直接访问static内部类的静态成员呢？
	Outer.Inner.function();
		
	注意：当内部类中定义了静态成员，该内部类必须是static的。
	
	当外部类中的静态方法访问内部类时，内部类也必须是静态的。
	
当描述事物时候，事物的内部还有事物，该事物用内部类来描述。
因为内部事务在使用外部事物的内容。

class Body
{
	private class XinZang
	{
		
	}
	
	public void show()  
	{
		new XinZang().
	}
}
	
*/
 
 class Outer
{
	private int x = 3;  //私有在本类中有效
	
	static class Inner //内部类，内部类可以被私有修饰
	{
		int x = 4；
		static void function()
		{
			int x = 6；
			System.out.println("inner :"+ Outer.this.x);
		}
		
		class Inner2
		{
			void show()
			{
				System.out.print(Inner2 show);
			}
		}
	}
	
	public static void method()
	{
		Inner.function();
		
		//Inner in = new Inner();
		//in.function();
		
	}
}

class InnerClassDemo2
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













