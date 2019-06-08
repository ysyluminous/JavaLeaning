package com.itheima.entity;

import com.itheima.util.DBUtils;
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
public class TestTransaction {

    @Test
    public void test1(){
        Connection conn  = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ); //mysql默认级别

            conn.setAutoCommit(false); // 相当于开启事务begin
            ps = conn.prepareStatement("update account set money = money - 100 where name ='aaa' ");
            ps.executeUpdate();

            int i = 10/0;

            ps = conn.prepareStatement("update account set money = money + 100 where name ='bbb' ");
            ps.executeUpdate();

            conn.commit();//提交事务 commit
        } catch (ClassNotFoundException e) {
            try {
                conn.rollback();//回滚事务
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,ps,conn);
        }
    }
}
