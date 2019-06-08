/************************************************************************
 *
 * 文件名:	ArrayDemo3
 * 
 * 文件描述:	bxd_day04_01_数组				
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
 

class ArrayDemo3
{
	public static void main(String[] args)
	{
		
		//数组的操作
		//获取数组中的元素,通常会用到遍历
		
		//int arr[] = new int[3];
		
		int arr[] = {1,2,3,4,5,6,7};
		//数组中有一个属性,可以直接获取到数组的元素,length
		//使用方式,数组名.length
		/* System.out.println("length:"+arr.length);
		
		// int sum = 0;
		for(int x = 0; x < arr.length; x++)
		{
			// sum += arr[x];
			System.out.println("arr["+x+"]="+arr[x]+";"); //arr[0] = 0;
		}
	*/
	
	// System.out.println(arr);
	
	 printArray(arr);
	// printArray(arr);
	} 
	
	//定义功能,用于打印数组中的元素,元素间用逗号隔开
	public static void printArray(int[] arr)
	{
		System.out.print("[");
		
		for(int x = 0; x < arr.length; x++)
		{	
			if(x != arr.length-1)
				System.out.print(arr[x]+",");
			else
				System.out.println(arr[x]+"]");
			
		}
	}
}













