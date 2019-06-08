package com.itheima.util;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
public class TestCRUD {



    @Test
    public void test1(){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = C3P0Util.getConnection();
            ps = conn.prepareStatement("insert into account(name,money) VALUES ('ggg',2000)");
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            C3P0Util.release(conn,ps,null);
        }

        System.out.println(conn);
    }


}
