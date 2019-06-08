package bxd;
/************************************************************************
 *
 * 文件名:	ArrayTest7
 * 
 * 文件描述:	进制转换优化
 *
 * 创建人:	Yao Siyuan
 *		
 * 总结:	
 *
 * 版本号:	0.1
 * 
 * 修改记录:
 *			0.1:
 * 
 ************************************************************************/
 
 
class ArrayTest7
{
	public static void main(String args [])
	{
		toBin(60);
	}
	
	/* 十进制转二进制 */
	public static void toBin(int num)
	{
		trans(num,1,1);
	}
	
	
	/* 十进制转八进制 */
	public static void toba(int num)
	{
		trans(num,7,3);
	}
	
	/* 十进制转十六进制 */
	public static void toHex(int num)
	{
		trans(num,15,4);
	}
	
	public static void trans(int num, int bease, int offset)
	{
		if(num == 0)
		{
			System.out.print(0);
			return;
		}
		
		char[] chs = {	'0','1','2','3',
						'4','5','6','7',
						'8','9','A','B',
						'C','D','E','F'};
						
		char arr[] = new char[32];
		
		int pos = arr.length;
		
		while(num != 0)
		{
			int temp = num & bease;
			
			arr[--pos] = chs[temp];
			
			num = num >>>offset;
			
		}
		
		for(int x = pos; x < arr.length; x++)
		{
			System.out.print(arr[x]);
		}
		
		
	}


 
 }
 
 
 
 
 
 
 
 