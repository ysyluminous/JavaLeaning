/* 
privat
：私有，权限修饰符：用于修饰类中的成员(成员变量，成员函数。)
私有只在本类中有效。

将age私有化以后，类以外即使建立了对象也不能直接访问。
但是人应该有年龄，就需要在Person类中提供对应访问age的方式。

注意：私有仅仅是封装的一种表现形式。

之所以对外提供访问方式，就因为可以在访问方式中假如逻辑判断等语句。
对方问的数据进行操作。提高代码健壮性。



 */
class Person
{
	private int age;
	public void setAge(int a)
	{
		if(a > 0 && a <130)
		{
			age = a;
			speak();
		}
		esle
			System.out.println("feifa aeg");
	}
	
	public int getAge()
	{
		return age;
	}
	private void speak()
	{
		System.out.println("age="+age);
	}
} 
 
 class PersonDemo
 {
	 
	 public static void main(String [] args)
	 {
		 Person p = new Person();
		 
		 // p.age - -20;
		 p.setAge(-40);
		 //p.speak();
	 }	 
 }
 
 
 
 
 
 