package com.itheima.datasource;

import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 2/4/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/


public class TestJDBC {
    @Test
    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;

        DataSource ds = new MyDataSource();

        try {
            conn = ds.getConnection(); //从池子中取出一个链接  com.mysql.jdbc.Connection
            ps = conn.prepareStatement("...");
            //..
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();//关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
