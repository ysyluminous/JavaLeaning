package com.itheima.jdbcdemo;

import java.sql.*;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/13/2017.
 *
 * Summary:	使用JDBC技术实现查询数据库数据，并显示在控制台中
 *
 * @version 0.1
 *
 * Record:
 *			0.1:


 ************************************************************************/
public class Demo1 {

    public static void main(String args[]) throws SQLException {

        //注册驱动，
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

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
}
