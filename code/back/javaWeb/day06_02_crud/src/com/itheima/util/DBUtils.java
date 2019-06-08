package com.itheima.util;

import java.sql.*;
import java.util.ResourceBundle;

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
public class DBUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        //此对象是用于加载properties文件数据的
        ResourceBundle rb = ResourceBundle.getBundle("dbinfo");
        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //得到链接的方法
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return  DriverManager.getConnection(url,username,password);
    }

    //关闭资源的方法
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
                //关闭资源
                if (rs!= null){
                    try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

}
