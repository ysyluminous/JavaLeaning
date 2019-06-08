package cn.itcast.base.reflect;

import java.util.Date;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.24
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Person {
    public String name = "传智播客";

    public Person() {
        System.out.println("构造方法执行了");
    }

    public Person(String name) {
        System.out.print("姓名="+name);
    }
    public Person(String name,int age){
        System.out.print("姓名="+name+"年龄="+age);
    }
    private Person(int age){
        System.out.print("年龄="+age);
    }

    public void m1(){
        System.out.println("m1");
    }
    public void m2(String name){
        System.out.println(name);
    }
    public String  m3(String name,int age){
        System.out.println(name+":"+age);
        return "ITCast";
    }

    private void m4(Date d){
        System.out.println(d);
    }
    public static void m5(){
        System.out.println("m5");
    }
    private static void m6(String [] strs){
        System.out.println(strs.length);
    }

    public static void main(String args[]){
        System.out.println("main");

    }


}
