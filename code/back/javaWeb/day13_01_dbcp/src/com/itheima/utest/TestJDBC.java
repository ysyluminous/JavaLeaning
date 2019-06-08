package com.itheima.utest;

import com.itheima.utils.DBCPUtil;
import org.junit.Test;

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

        try {
            conn = DBCPUtil.getConnection();
            ps = conn.prepareStatement("..");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtil.release(conn,ps,null);
        }
    }
}
