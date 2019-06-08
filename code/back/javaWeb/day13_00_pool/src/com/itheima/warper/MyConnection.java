package com.itheima.warper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

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
public class MyConnection extends MyConnectionWarper {
    private Connection oldConn;
    private LinkedList<Connection> pool;
    public MyConnection(Connection oldConn, LinkedList<Connection> pool) {
        super(oldConn);
        this.oldConn = oldConn;
        this.pool= pool;
    }

    @Override
    public void close() throws SQLException {
        pool.addLast(oldConn);
    }
}
