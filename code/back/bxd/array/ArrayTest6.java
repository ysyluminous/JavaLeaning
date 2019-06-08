package bxd;
/************************************************************************
*
* 文件名:	ArrayTest6
* 
* 文件描述:	查表法十进制转十六进制
*
* 创建人:	Yao Siyuan,
*	
* 总结:	
*
* 版本号:	0.1
* 			2016年5月29日11:14:43 看到04_10_14:34
* 
* 修改记录:
*			0.1:
* 
************************************************************************/


class ArrayTest6
{
	public static void main (String[] args)
	{
		//toHex(60);
		toBin(6);
	}
	
	public static void toBin(int num)
	{
		//定义二进制的表
		char [] chs = {'0','1'};
		
		//定义一个临时存储容器
		char [] arr = new char[32];
		
		//定义一个操作数组的指针并初始化为数组长度
		int pos = arr.length;
		
		//while 控制只循环有效位,当所有有效值循环执行完毕后结束
		//只循环有效位
		while(num != 0)
		{
			
			//临时变量temp存放 每次和 1&后的二进制值
			int temp = num & 1;
			
			//pos初值为数组长度,
			//每次循环把&的二进制值存放到数组最后一个索引处(每次使用前--)
			arr[--pos] = chs[temp];
			
			//将数值右移一位
			num = num >>>1;
		}
		
		for(int x = pos; x < arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		
	}
	
	public static void toHex(int num)
	{
		/*  十六进制表

			0 1 2 3 4 5 6 7 8 9  A  B  C  D  E  F  ==十六进制中的元素
			0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
			
			查表法:将所有的元素临时存储起来, 建立对应关系
			每一次&15后的值作为索引去查建立好的表,就可以找到对应的元素
			这样比 -10+'a'简单得多
			
			这个表怎么建立的?
			可以通过数组的形式来进行定义
			
			发现终于出结果了,但是是反着的,想要正过来呢,
			可以通过StringBuffer reverse功能来完成
			但是这个工具还没有学习
			
			所以可以使用已经学习过的容器,数组来完成
			
		*/
		char[] chs = {	'0','1','2','3',
						'4','5','6','7',
						'8','9','A','B',
						'C','D','E','F'};
		
		// 定义一个临时容器
		char[] arr = new char[8]; //	'/u000'一个空位,空格
		int pos = arr.length;
		
		while(num != 0)
		{
			//15的二进制是1111; 
			//&是真和真的时候为真
			//temp存储从右开始四位的十六进制
			//num&15就是
			int temp = num & 15;
			
			//System.out.println(chs[temp]);
			
			//chs[temp] 根据或位出来的值取出chs数组中的十六进制值
			arr[--pos] = chs[temp];
		
			num = num >>> 4;
		}
	
		//存储数据的arr数组遍历
		for(int x = pos; x < arr.length ; x++)
		{
			System.out.print(arr[x]+",");
		}
		
	}
	

}





