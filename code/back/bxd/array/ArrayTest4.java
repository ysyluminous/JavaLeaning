package bxd;
/************************************************************************
*
* 文件名:	ArrayTest4
* 
* 文件描述:	数组的查找操作 
* 			折半查找 
*          	练习
*			
*			练习:有一个有序的数组,想要将一个元素插入到该数组中,
* 			还要保证该数组是有序的.如何获取钙元素在数组中的位置
*
* 创建人:	Yao Siyuan 2016年5月26日18:47:38
*	
* 总结:		
*
* 版本号:	0.1
* 
* 修改记录:
*			0.1:
* 
************************************************************************/

class ArrayTest4
{                  
	public static void main (String[] args)
	{
		// int [] arr = {2,4,5,6,83,1};
		// int index = getIndex(arr,83);
		
		int [] arr = {2,4,5,6,8,9};
		int index = getIndex_2(arr,7);
		System.out.println("index = "+index);
	}
	
	/*
		折半查找,提高效率,但是必须要保证该数组是有序的数组
	*/
	public static int halfSearch(int arr[],int key)
	{
		int min,max,mid;
		
		min = 0;
		max = arr.length - 1;
		mid = (max + min) / 2;
		
		while(arr[mid] != key)
		{
			if(key > arr[mid])
				min = mid + 1;
			else if(key < arr[mid])
				max = mid - 1;
			
			if(min > max)
			return -1;
			
			mid = (max + min) / 2;
			
		
		}
		return mid;
	}
	
	public static int halfSearch_2(int arr[], int key)
	{
		int min = 0, max = arr.length - 1, mid;
		
		while(min <= max)
		{
			mid = (max + min) >> 1; //右移n位就是除以2的n次方
			
			if(key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;
			else 
				return mid;
		}
		return -1;
	}
	//定义功能,获取key第一次出现在数组中的位置,如果返回-1代表该key在数组中不存在
	public static int getIndex(int[] arr, int key)
	{
		
		for(int x = 0; x < arr.length; x++)
		{
			if(arr[x] == key)
			return x;
		}
		return -1;
		
	}
	
	/* 练习
	练习:有一个有序的数组,想要将一个元素插入到该数组中, 
	还要保证该数组是有序的.如何获取钙元素在数组中的位置 
	*/

	
	public static int getIndex_2(int[] arr, int key)
	{
		
		int min = 0, max = arr.length - 1, mid;
		
		while(min <= max)
		{
			mid = (max + min) >> 1; //右移n位就是除以2的n次方
			
			if(key > arr[mid])
				min = mid + 1;
			else if (key < arr[mid])
				max = mid - 1;
			else 
				return mid;
		}
		return min;
		
	}
	
}








