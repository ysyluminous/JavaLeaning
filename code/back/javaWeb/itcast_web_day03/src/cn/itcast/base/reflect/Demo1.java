package cn.itcast.base.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: mindview/page 
 *
 * @author Yao Siyuan on 2016.11.24
 *
 * Summary:	反射是框架设计的灵魂
 *          必须先得到类的字节码文件，Class clazz = class.forName(类的完整类名);
 *
 *          如何得到类的字节码：
 *              Class.forName(类的完整类名);
 *              对象引用名称.getClass();
 *              类名.class；
 *
 * @version 0.1
 *
 * Record:
 *			0.1:cn.itcast.base.reflect.Person
 *
 ************************************************************************/
public class Demo1 {

    @Test  //public Person()
    public void test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class clazz = Person.class;

//        //代表Person类在内存中的字节码文件
//        Class clazz = Class.forName("cn.itcast.base.reflect.Person");
//        //得到构造方法干嘛？创建对象
//        Constructor c = clazz.getConstructor(null);
//        c.newInstance(null);




//        Person p = new Person();
    }




    @Test  //public Person()
    public void test11() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        Class clazz = Person.class;

        //代表Person类在内存中的字节码文件
        Class clazz = Class.forName("cn.itcast.base.reflect.Person");

        Person p = (Person) clazz.newInstance(); //调用默认的构造方法
        System.out.println(p.name);



        //得到构造方法干嘛？创建对象
//        Constructor c = clazz.getConstructor(null);
//        c.newInstance(null);
//
//        Person p = new Person();
    }

    @Test   //public Person(String name)
    public void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //代表Person类在内存中的字节码文件
        Class clazz = Class.forName("cn.itcast.base.reflect.Person");
        //得到构造方法干嘛？创建对象
        Constructor c = clazz.getConstructor(String.class);
        c.newInstance("姚斯元");

//        Person p = new Person();
    }

    @Test   //public Person(String name,int age)
    public void test3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //代表Person类在内存中的字节码文件
        Class clazz = Class.forName("cn.itcast.base.reflect.Person");
        //得到构造方法干嘛？创建对象
        Constructor c = clazz.getConstructor(String.class,int.class);
        Person p = (Person) c.newInstance("姚斯元",20);
        System.out.print(p.name);
//        Person p = new Person();
    }

    @Test   //private Person(int age)
    public void test4() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //代表Person类在内存中的字节码文件
        Class clazz = Class.forName("cn.itcast.base.reflect.Person");
        //得到构造方法干嘛？创建对象
        //读取私有的构造方法的
        Constructor c = clazz.getDeclaredConstructor(int.class);

        c.setAccessible(true);  //暴力反射
        Person p = (Person) c.newInstance(20);
        System.out.println(p.name);
//        Person p = new Person();
    }

    @Test   //类中所有的构造方达
    public void test5() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //代表Person类在内存中的字节码文件
        Class clazz = Class.forName("cn.itcast.base.reflect.Person");
        Constructor [] cs = clazz.getDeclaredConstructors();
        System.out.println(cs.length);
    }
}
