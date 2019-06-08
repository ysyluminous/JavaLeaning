/************************************************************************
 *
 * 文件名:	ArrayTest2
 * 
 * 文件描述:	bxd_day04_04_数组排序,选择排序
 *			给定一个数组{5,1,6,4,2,8,9}.
 *			1.进行排序
 *
 * 创建人:	Yao Siyuan
 *	
 * 总结:		选择排序,内循环结束一次,最值出现在头角上
 *			冒泡排序,相邻的两个元素进行比较,如果符合条件换位
 * 版本号:	0.1
 * 
 * 修改记录:
 *			0.1:
 * 
 ************************************************************************/
 
 
 
class ArrayTest2
{	
	//数组选择排序函数
	public static void selectSort(int [] arr)
	{ 
		for (int x = 0; x < arr.length - 1; x++)
		{
			for (int y = x + 1; y < arr.length; y++)
			{
				if(arr[x] < arr[y])
				{
					int temp = arr[x];
					arr [x] = arr[y];
					arr[y] = temp;
				}
			}
		}
	}
	
	//主函数
	public static void main(String[] args)
	{
		int arr []= {1,2,3,5,6,872,2};
		
		//排序前;
		//printArray(arr);
		
		//排序
		//selectSort(arr);
		bubbleSort(arr);
		
		//排序后
		printArray(arr);	
	}
	
	//打印数组函数
	public static void printArray(int arr[])
	{
		System.out.print("[");
		
		for(int x = 0; x < arr.length; ++x)
		{
			if(x != arr.length -1)
				System.out.print(arr[x]+", ");
			else
				System.out.println(arr[x]+"]");
		}
		
	}
	
	//冒泡排序
	public static void bubbleSort(int arr[])
	{
		
		
		for(int x = 0;x < arr.length-1; x++)	
		{
			//减x的:让每次比较的元素减少.-1避免越界
			for(int y = 0;y < arr.length - x-1;y++)
			{
				if(arr[y] > arr[y+1])
				{
					int temp = arr[y];
					arr[y] = arr[y+1];
					arr[y+1] = temp;
				}
			}
		}
	}
	
}
 
 
 
 
 
 
 
 
 
 
 
 