package com.itheima.jdbcdemo;

import org.junit.Test;

import java.sql.*;
import java.util.Properties;

import static java.lang.Class.forName;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/13/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Demo2 {

    @Test
    public void text1() throws ClassNotFoundException, SQLException {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        ResultSet re = statement.executeQuery("SELECT * FROM users");

//        处理结果
        while (re.next()){
            System.out.println(re.getObject(1));
            System.out.println(re.getObject(2));
            System.out.println(re.getObject(3));
            System.out.println(re.getObject(4));
            System.out.println(re.getObject(5));
            System.out.println("----------");
        }

//      关闭连接
        re.close();
        connection.close();
        statement.close();
    }


    @Test
    public void test2() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","root");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06",info);
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        ResultSet re = statement.executeQuery("SELECT * FROM users");

//        处理结果
        while (re.next()){
            System.out.println(re.getObject(1));
            System.out.println(re.getObject(2));
            System.out.println(re.getObject(3));
            System.out.println(re.getObject(4));
            System.out.println(re.getObject(5));
            System.out.println("----------");
        }

//      关闭连接
        re.close();
        connection.close();
        statement.close();
    }



    @Test
    public void test3() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        ResultSet re = statement.executeQuery("SELECT * FROM users");

//        处理结果
        while (re.next()){
            System.out.println(re.getObject(1));
            System.out.println(re.getObject(2));
            System.out.println(re.getObject(3));
            System.out.println(re.getObject(4));
            System.out.println(re.getObject(5));
            System.out.println("----------");
        }

//      关闭连接
        re.close();
        connection.close();
        statement.close();
    }



    @Test
    public void test4(){
        Connection connection = null;
        Statement statement = null;
        ResultSet re = null;
        try {
            //注册驱动，
            Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
            //获取链接Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

            //得到执行sql语句的对象statement
            statement = connection.createStatement();

//        执行sql语句 返回结果
            re = statement.executeQuery("SELECT * FROM users");

//        处理结果
            while (re.next()){
                System.out.println(re.getObject(1));
                System.out.println(re.getObject(2));
                System.out.println(re.getObject(3));
                System.out.println(re.getObject(4));
                System.out.println(re.getObject(5));
                System.out.println("----------");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (re != null){
                try {
                    re.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                re = null;
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connection= null;
            }
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                statement = null;
            }
        }

//      关闭连接

    }
}
