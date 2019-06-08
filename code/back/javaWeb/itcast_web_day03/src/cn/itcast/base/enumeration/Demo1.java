package cn.itcast.base.enumeration;

import org.junit.Test;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.24
 *
 * Summary:	枚举值放到第一行
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Demo1 {
    @Test
    public void test1(){
        Student s = new Student();
        s.setName("陈冠希");
        s.setGrade(Grade.B);

        Grade g = s.getGrade();
        String v = g.getValue();
//        System.out.print(v);


        String localeValue = g.toLocaleString();
        System.out.println(localeValue);
    }

    @Test
    public void test2(){
        WeekDay wd = WeekDay.SUN;
        System.out.println(wd.toLocaleString());
        switch (wd){

        }
    }

    //枚举中的常用方法
    @Test
    public void test3(){
        WeekDay wd = WeekDay.SUN;
        String name = wd.name();    //枚举类型对应的字符串名称
        System.out.println(name);


        String str = "MON";
        WeekDay wd1 = WeekDay.valueOf(str);
        System.out.println(wd1.toLocaleString());


        WeekDay wd2 =WeekDay.SUN;
        System.out.println(wd2.ordinal());
    }

    @Test
    public void test4(){
        WeekDay[] wds = WeekDay.values();
        for (WeekDay wd:wds){
            System.out.println(wd.name());
        }
    }


}
