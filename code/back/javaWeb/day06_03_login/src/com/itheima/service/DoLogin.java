package com.itheima.service;

import com.itheima.entity.User;
import com.itheima.util.DBUtils;

import java.sql.*;

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
public class DoLogin {
    /**
     * 根据用户名和密码查询用户对象信息
     * @param name
     * @param pwd
     * @return u
     */
    public User findUser(String name, String pwd){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User u = null;

        try {
            conn= DBUtils.getConnection();
            String sql = "select * from users where username = ? and password = ?";
            stmt = conn.prepareStatement(sql);

            //给问号赋值
            stmt.setString(1,name);
            stmt.setString(2,pwd);
            rs = stmt.executeQuery();
//            sql注入
//            rs = stmt.executeQuery("SELECT * FROM  users where username='" + name + "'and password='" + pwd + "'");
//          SELECT * FROM  users where username='" + name + "'and password='           dasd' or '1' = '1      '

            if (rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,stmt,conn);
        }
        return u;
    }
}
