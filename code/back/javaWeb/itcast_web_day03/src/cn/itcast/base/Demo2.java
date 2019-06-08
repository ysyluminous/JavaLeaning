package cn.itcast.base;

import java.util.ArrayList;
import java.util.List;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.20
 *
 * Summary:
 * 基本类型--->包装类型  自动装箱
 * 包装类型--->基本类型  自动拆箱
 *
 * 高速缓存
 * true、false byte 介于-128到127之间的整数，介于\u0000和\u007F之间的字符
 * 因此这些基本类型的包装类对象，是用一个对象。
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Demo2 {
    public static void main(String args[]){
        List list = new ArrayList();
        int i = 10;
        list.add(new Integer(i));
        //5.0的做法
        int j = 100;
        list.add(j);//实际上编译器吧基本类型的j自动调用了new Integer(10)，传递给数组

        //遍历
        int k = (Integer) list.get(1); //自动拆箱
        System.out.println(k);

        //注意的问题
//        思考：
//        Integer ii = null;
//        int jj = ii;
//        System.out.print(jj);

        Boolean b1 = true;
        Boolean b2 = true;
        System.out.println(b1 == b2); //真
        Integer i1 = 129;
        Integer i2 = 129;
        System.out.println(i1 == i2); //真
        Float f1 = 0.1f;
        Float f2 = 0.1f;
        System.out.println(f1 == f2); //假
    }







}
