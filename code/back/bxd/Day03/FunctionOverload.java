/************************************************************************
 *
 * 文件名:	FunctionOverload		
 * 
 * 文件描述:	bxd_day03_函数重载.java
 *
 * 创建人:	Yao Siyuan,								
 *	
 * 总结:	什么时候用重载:
 *			当定义的功能相同,但参与运算的位置内容不同
 *			就定义一个函数名称,以表示其功能,方便阅读,
 *			而通过参数列表的不同来区分多个同名函数.---重载
 *
 * 版本号:	0.1
 * 
 * 修改记录:
 *			0.1:
 * 
 ************************************************************************/


class FunctionOverload
{
	public static void main(String[] args)
	{
		//add(4,5);
		//add(4,5,6);
		System.out.println("hello world");
		
	}

 
	//定义一个加法运算,获取两个整数的和
	public static int add(int x, int y)
	{	
		return x+y;
	}

	//定义一个加法,获取三个整数的和
	public static int add(int x,int y, int z)
	{
		return x+y+z;
	}

	public static void print99(int num)
	{
		for (int x = 1; x<=num; x++)
		{
			for (int y =1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}
 
	public static void print99()
	{
		for (int x = 1; x<=9; x++)
		{
			for (int y =1; y<=x; y++)
			{
				System.out.print(y+"*"+x+"="+y*x+"\t");
			}
			System.out.println();
		}
	}
 
 
}
 
 
 
 
 
 
 
 
 
 