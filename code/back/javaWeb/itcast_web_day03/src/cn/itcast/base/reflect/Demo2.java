package cn.itcast.base.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.26
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/

//反射类中的方法
public class Demo2 {
    //public void m1()
    @Test
    public void test1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Person p = new Person();

        Class clazz = Person.class;
        Method m = clazz.getMethod("m1",null);//得到方法干嘛？
        m.invoke(p,null); //调用方法
    }

    //public void m2(String name)
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Person p = new Person();

        Class clazz = Person.class;
        Method m = clazz.getMethod("m2",String.class);//得到方法干嘛？
        m.invoke(p,"姚斯元"); //调用方法
    }

    //public String  m3(String name,int age)
    @Test
    public void test3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Person p = new Person();

        Class clazz = Person.class;
        Method m = clazz.getMethod("m3",String.class,int.class);//得到方法干嘛？
        String returnValue = (String) m.invoke(p,"姚斯元",20); //调用方法
        System.out.println(returnValue);
    }

    //private void m4(Date d)
    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Class clazz = Person.class;
        Person p = (Person) clazz.newInstance();
        Method m = clazz.getDeclaredMethod("m4", Date.class);//得到方法干嘛？
        m.setAccessible(true);
        m.invoke(p,new Date()); //调用方法
    }

    //public static void m5()
    @Test
    public void test5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Class clazz = Person.class;
//        Person p = (Person) clazz.newInstance();
        Method m = clazz.getDeclaredMethod("m5",null);//得到方法干嘛？
        m.invoke(null,null); //调用方法
    }


    //private static void m6(String [] strs)
    @Test
    // TODO: 2016.11.26
    public void test6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Class clazz = Person.class;
//        Person p = (Person) clazz.newInstance();
        Method m = clazz.getDeclaredMethod("m6",String[].class);//得到方法干嘛？
        m.setAccessible(true);
        m.invoke(null,new String[]{"a","b"}); //调用方法
    }

    //private static void m6(String [] strs)
    @Test
    public void test7() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {


        Class clazz = Person.class;
//        Person p = (Person) clazz.newInstance();
        Method m = clazz.getMethod("main",String[].class);//得到方法干嘛？
        m.invoke(null,new String[]{"a","b"}); //调用方法
    }

}
