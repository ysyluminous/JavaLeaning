package cn.itcast.base;

import org.junit.Test;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.24
 *·
 * Summary:	一个方法的参数列表中，只能有一个可变参数，且必须放在最后。
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
//可变参数
public class Demo4 {
    //计算任意数量的整数的和
    public int sum(int...args){//可变参数就当做数组来用
        int sum = 0;
        for (int i:args){
            sum+=i;
        }
        return sum;
    }

    @Test//如何使用带有可变参数的方法
    public void test1(){
        int result = sum(1,2,3,4);
        System.out.println(result);
    }

    @Test
    public void test2(){
        int values[] = {1,2,3,4,5};
        int result = sum(values);
        System.out.print(result);

    }

}
