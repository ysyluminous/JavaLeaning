package com.itheima.demo;

import org.junit.Assert;
import org.junit.Test;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/13/2017.
 *
 * Summary:	测试方法不能有返回值，不能有参数
 *
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class TestCalc {
    @Test
    public void text1(){
        Calc c = new Calc();
        c.add(1,3);
        Assert.assertEquals(3,c.add(1,2));

//        System.out.println("aaaaaaaaaa");
    }

    @Test
    public void test2(){
//        System.out.println("bbbbbbbb");
        Calc c = new Calc();
        Assert.assertEquals(3,c.div(10,3),0.4);

    }

}
