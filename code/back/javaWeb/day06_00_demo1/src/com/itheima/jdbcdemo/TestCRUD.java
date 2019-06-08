package com.itheima.jdbcdemo;

import com.itheima.entity.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/14/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class TestCRUD {



    @Test
    public void testSelect() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        ResultSet rs = statement.executeQuery("SELECT password,email,birthday,id,username from users");

        List<User> list = new ArrayList<User>();
//        处理结果
        while (rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setName(rs.getString("username"));
            u.setEmail(rs.getString("email"));
            u.setBirthday(rs.getString("birthday"));
            list.add(u);
        }

//      关闭连接
        rs.close();
        connection.close();
        statement.close();

        for (User user:list
             ) {
            System.out.println(user);
            
        }
        
        
        
    }














    @Test
    public void testInsert() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        int i = statement.executeUpdate("INSERT INTO  users VALUES (1,'yaosiyuan','123','yaosiyuan@163.com','1997-03-18')");

//        处理结果
        if (i >0){
            System.out.println("连接成功");
        }else {
            System.out.println("连接失败");
        }

//      关闭连接

        connection.close();
        statement.close();
    }

    @Test
    public void testUpdate() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        int i = statement.executeUpdate("UPDATE users SET username = 'ysy',PASSWORD ='12123',email = 'ysy@163.com' WHERE id = 1");

//        处理结果
        if (i >0){
            System.out.println("连接成功");
        }else {
            System.out.println("连接失败");
        }

//      关闭连接

        connection.close();
        statement.close();
    }



    @Test
    public void testDelete() throws Exception {
        //注册驱动，
        Class.forName("com.mysql.jdbc.Driver");
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06?user=root&password=root");
        //获取链接Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "root");

        //得到执行sql语句的对象statement
        Statement statement = connection.createStatement();

//        执行sql语句 返回结果
        int i = statement.executeUpdate("DELETE FROM users WHERE id=4");

//        处理结果
        if (i >0){
            System.out.println("连接成功");
        }else {
            System.out.println("修改了"+i+"行");
        }

//      关闭连接

        connection.close();
        statement.close();
    }





}
