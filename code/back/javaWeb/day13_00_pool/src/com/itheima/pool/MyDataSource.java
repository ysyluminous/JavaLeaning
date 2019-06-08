package com.itheima.pool;

import com.itheima.util.DBUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

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
public class MyDataSource implements DataSource{
    //创建一个存放连接的池子
    private static LinkedList<Connection> pool =(LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());

    static {
        try {
            for (int i = 0; i < 10; i++) {
                Connection conn = DBUtils.getConnection();
                pool.add(conn);
            }
        }catch (Exception e) {
            System.out.println("初始化链接失败，请检查配置文件是否正确");
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        if (pool.size()>0){
            conn = pool.removeFirst();  //从池子中取出一个链接
            return conn;

        }else{
            throw new RuntimeException("服务器忙");
        }

    }

    //释放资源
    public void release(Connection conn){
        pool.addLast(conn);
    }
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }


    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }





    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
