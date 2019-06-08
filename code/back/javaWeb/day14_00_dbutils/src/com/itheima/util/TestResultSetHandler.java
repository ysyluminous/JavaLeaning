package com.itheima.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

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
public class TestResultSetHandler {

    @Test//ArrayHandler:适合读取一条记录,把该记录的每列值封装到一个数组中Object[]
    public void test1() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        Object []arr = qr.query("select * from users where id = ?",new ArrayHandler(),4);
        for (Object o : arr){
            System.out.println(o);
        }
    }

    @Test//ArrayHandler:适合读取多条记录,把该记录的每列值封装到一个数组中Object[],把数组封装到一个list中
    public void test2() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<Object[]> query = qr.query("select * from users",new ArrayListHandler());


        for (Object [] os : query){
            for (Object o : os) {
                System.out.println(o);
            }
            System.out.println("----");
        }
    }



    @Test//ColumnListHandler:读某一列的数据,封装到List中
    public void test3() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<Object> list = qr.query("select * from users",new ColumnListHandler(2));

            for (Object o : list) {
                System.out.println(o);
            }

    }


    @Test//
    public void test4() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        List<Object[]> query = qr.query("select * from users",new ArrayListHandler());

        for (Object [] os : query){
            for (Object o : os) {
                System.out.println(o);
            }
            System.out.println("----");
        }
    }
}
