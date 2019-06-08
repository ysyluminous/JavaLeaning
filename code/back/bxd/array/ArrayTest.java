/************************************************************************
 *
 * 文件名:	ArrayTest
 * 
 * 文件描述:	bxd_day04_03_数组常见操作,获取最值
 *			给定一个数组{5,1,6,4,2,8,9}.
 *			1.获取数组中的最大值,以及最小值
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

 
class ArrayTest
{
	
	/*
		获取数组中的最大值
		思路:
		1.获取最值,需要进行比较,每一次比较都会有一个较大的值,因为该值不确定,
		通过一个变量进行存储,
		2.让数组中的每一个元素和这个变量中的值进行比较,
		如果大于变量中的值,就用该变量记录最大值
		3.当所有的元素都比较完成,那么该变量中存储的就是数组中的最大值.
		
		
		
		步骤:
		1.定义一个变量,初始化为数组中的任意一个元素即可,
		2.通过循环语句对数组进行遍历
		3.在遍历过程中定义判断条件,如果遍历到的元素比变量中的元素大,就赋值给该变量.
	
		需要定义一个功能来完成,以便提高复用性,
		1.明确结果,数组中的最大元素,int
		2.未知内容:一个数组,int[]
		
	*/
	

	public static void main (String[] args)
	{
		int arr[] = {2,2,5,76,8,9,3,100};
		int max = getMin(arr);
		System.out.println("max="+max);
	}
	
	
	//获取double类型数组的最大值,因为功能一直,所以定义相同函数名称,以重载形式存在
	public static double getMax(double [] arr)
	{
		
	}
	
	public static int getMax(int [] arr)
	{
		int max = arr[0];
		for(int x = 1; x <arr.length; x++)
		{
			if(arr[x] > max)
				max = arr[x];
		}
			return max;
	}
	
	
	/*
		获取最大值的另外一种方式;
		可不可以将临时变量初始化为0呢?
		可以,这种方式,其实是在初始化为数组中的任意一个角标
	
	*/
	public static int getMax_2(int [] arr)
	{
		int max = 0;
		for(int x = 1; x <arr.length; x++)
		{
			if(arr[x] > arr[max])
				max = x;
		}
			return arr[max];
	}
	
	public static int getMin(int[] arr)
	{
		int min = 0;
		for(int x = 1; x < arr.length; x++)
		{
			if(arr[x] < arr[min])
				min = x;
		}
		return arr[min];
	}
}
 
 

 
 
 
 
 