/************************************************************************
 *
 * 文件名:	StaticDemo
 * 
 * 文件描述:	第六天_01_面向对象_Static
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
	static关键字
		用于修饰成员(成员变量和成员函数)
	被修饰后的成员具备以下特点
		随着类的加载而加载
		优先于对象存在
		被所有对象所共享
		可以直接被类名调用
	适用注意
		静态方法只能访问静态成员
		静态方法不可以写this和super关键字
		主函数是静态的 
	*/
	
class Person
{
	String name;
	Sting country = "CN";
	public void show()
	{
		System.out.print(name+"::"+country);
		
	}
}

class StaticDemo
{
	public static void main(String args [])
	{
		Person p = new Person();
		P.name = "zhangsan";
		P.show();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
 