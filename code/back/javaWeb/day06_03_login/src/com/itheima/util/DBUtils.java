package com.itheima.util;

import jdk.internal.dynalink.beans.StaticClass;

import java.sql.*;
import java.util.ResourceBundle;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/15/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class DBUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driverClass;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        //给上面四个变量赋值
        url = rb.getString("url");
        user = rb.getString("user");
        password = rb.getString("password");
        driverClass = rb.getString("driverClass");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
        //得到链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

//    关闭资源
        public static void closeAll(ResultSet rs, Statement stmt,Connection conn){
            if (rs!= null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }


            if (stmt!= null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }

            if (conn!= null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
            }
        }

}
