/***********************************************************************
 *
 * 文件名:	ArrayTest5
 * 
 * 文件描述:	
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
	 
	 
	 
	 
class ArrayTest5 
{
	public static void main(String[] args)
	{
		//java自带转换
		//System.out.println(Integer.toBinaryString(60));
		
		toHex(60);
	}
	
	//十进制转十六进制
	public static void toHex(int num)
	{		
		StringBuffer sb = new StringBuffer();
		
		for(int x = 0; x < 8; x++)
		{
			/* 	&15
			15的二进制是1111,用与,(真和真的时候为真)
			第一次循环算出最右边四位的十六进制
			*/
			int temp = num & 15;
		
			if(temp > 9)
			{
				//System.out.print((char)(temp - 10 + 'a'));
				sb.append((char)(temp - 10 + 'a'));
			}
			else
				//System.out.print(temp);
				sb.append(temp);
			
			/*  >>>4
			无符号右移>>> 无论开头是1是0补的都是0 
			原数的二进制右移四位 开始二次循环计算 右边4n的十六进制
			*/
			num = num >>> 4;
		}
		System.out.println(sb.reverse());
	}
	
	/* 十进制转换为二进制
	*/
	public static void toBin(int num)
	{	
		// 能装数据的容器
		StringBuffer sb = new StringBuffer();
		
		while(num > 0 )
		{
			//System.out.println(num % 2);
			
			sb.append(num % 2);
			num = num / 2;
		}
		
		System.out.print(sb.reverse());
	}
	
}
	 
	 



 
 
 
 
 
 