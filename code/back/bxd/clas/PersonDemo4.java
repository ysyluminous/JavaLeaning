/* 
this语句
：用于构造函数之间进行相互调用。

this语句只能定义在构造函数的第一样，因为初始化要先执行。
 */
 
 class Person
 {
	 private String name;
	 private int aeg;
	 
	 {
		 
		 System.out.println("code run");
	 }
	 
	 Person()
	 {
		 //this("haha");
		 System.out.println("Person run");
	 }
	 Person(String name)
	 {
		 //this();
		 this.name = name;
	 }
	 Person(String name,int age)
	 {
		 //this(name);
		 //this.name = name;
		 this.age = age;
	 }
	 
 }
 
 class PersonDemo4
 {
	 public static void main(String [] args)
	 {
		 new Person();
		 //Person p = new Person("lisi",30);
		 
		 //Person p1 = new Person("lisi2",36);
	 }
 }
 
 
 
 
 
 
 
 
 
 
 
 