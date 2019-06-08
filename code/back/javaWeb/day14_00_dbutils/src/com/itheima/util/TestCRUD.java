package com.itheima.util;

import javafx.beans.binding.ObjectExpression;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 2/5/2017.
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
    public void testInsert(){
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        try {
            qr.update("insert into users (username,password,email,birthday) values(?,?,?,?)","菜11","123","c10@123.com",new Date());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());

        try {
            qr.update("update users set username = ?,password = ? where id = ?","周杰伦","333","37");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //批处理,只能执行相同的sql语句
    @Test
    public void testBatch() throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());


        Object [][] params = new Object[10][];//高维代表执行多少次sql语句
        for (int i = 0; i < params.length;i++){
            params[i] = new Object[]{"菜10"+i,"123","c10@163.com",new Date()};//给每次执行的sql语句赋值
        }

            qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)",params);


    }


}
