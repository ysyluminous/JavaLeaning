package com.itheima.pool;

import com.itheima.util.DBUtils;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/15/2017.
 *
 * Summary:	模拟数据库连接池，不具备实际开发意义
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class SimpleConnectionPool {
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

        public Connection getConnectionFromPool(){
            Connection conn = null;
            if (pool.size()>0){
                conn = pool.removeFirst();  //从池子中取出一个链接
                return conn;
            }else{
                //等待
                //新创建一个链接
                throw new RuntimeException("服务器忙");
            }
        }


        //释放资源
        public void release(Connection conn){

            pool.addLast(conn);
        }


}

