/*
package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

*/
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
 ************************************************************************//*

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            ps= conn.prepareStatement("INSERT INTO  users(username,password,email,birthday) VALUE (?,?,?,?)");
            ps.setString(Integer.parseInt("1"),user.getUsername());
            ps.setString(Integer.parseInt("2"),user.getPassword());
            ps.setString(Integer.parseInt("3"),user.getEmail());
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date = sdf.format(user.getBirthday());
//        ps.setString(4,date);
            ps.setString(Integer.parseInt("4"), String.valueOf(user.getBirthday()));

            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        } finally {
            DBUtils.closeAll(null,ps,conn);
        }
    }

    @Override
    public User findUser(User user) throws Exception {
        return null;
    }

    @Override
    public boolean findUserByName(String name) {
        return false;
    }
}
*/
package com.itheima.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.utils.DBUtils;

public class UserDaoImpl implements UserDao {

    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(user.getBirthday());
            ps.setString(4, date);

            int i = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败！");
        }finally{
            DBUtils.closeAll(null, ps, conn);
        }
    }

    public User findUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            rs = ps.executeQuery();
            if(rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setBirthday(rs.getDate(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeAll(rs, ps, conn);
        }
        return u;
    }

    public boolean findUserByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from users where username=?");
            ps.setString(1, name);

            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeAll(rs, ps, conn);
        }
        return false;
    }

}
