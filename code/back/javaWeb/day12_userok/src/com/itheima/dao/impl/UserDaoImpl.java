package com.itheima.dao.impl;


import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.PreparedStatement;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/11/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class UserDaoImpl  implements UserDao {
    @Override
    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String date = sdf.format(user.getBirthday());
            ps.setString(4, user.getBirthday());

            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败！");
        }finally{
            DBUtils.closeAll(null, ps, conn);
        }
    }

    @Override
    public User findUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        User u = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("SELECT * FROM users WHERE username=? and password=?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());

            rs = ps.executeQuery();
            if (rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(rs,ps,conn);
        }
        return u;
    }

    @Override
    public boolean findUserByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet re = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("SELECT * from users where username = ?");

            ps.setString(1,name);

            re = ps.executeQuery();

            if (re.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(re,ps,conn);
        }

        return false;
    }
}
