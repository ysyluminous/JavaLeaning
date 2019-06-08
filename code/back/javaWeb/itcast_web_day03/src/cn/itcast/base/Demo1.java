package cn.itcast.base;
import java.util.List;

import static java.lang.System.out; //引入静态成员
import static java.lang.System.*; //引入该类中所有的静态成员
import static java.util.Arrays.*;
/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.20
 *
 * Summary:	静态导入
 * 作用：导入类中的静态成员
 * 语法：import static java.lang.System.out;
 * 或者 import static java.lang.System.*;
 *
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Demo1 {
    public static void main(String args[]){
        out.print("Hello World!!");
        long time = currentTimeMillis();
//        System.out.print(time);

        System.currentTimeMillis();
        String s[] = {"a","b","c"};
        List list = asList(s);
        System.out.print(list);
    }
}
