package com.itheima.pool;

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
public class Test {

    public static void main(String args[]){
        DataSource ds = new MyDataSource();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ds.getConnection();
            ps = conn.prepareStatement("....");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
               conn.close();   //不要关
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
