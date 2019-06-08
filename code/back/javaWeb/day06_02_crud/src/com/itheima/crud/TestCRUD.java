package com.itheima.crud;

import com.itheima.entity.User;
import com.itheima.util.DBUtils;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/14/2017.
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
    public void TestSelect(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet  re= null;

        try {
            conn  = DBUtils.getConnection();
            stmt = conn.createStatement();
            re = stmt.executeQuery("select * FROM  users");
            List<User> list = new ArrayList<User>();
            while (re.next()){
                User u = new User();
                u.setId(re.getInt(1));
                u.setName(re.getString(2));
                u.setPassword(re.getNString(3));
                u.setEmail(re.getString(4));
                u.setBirthday(re.getDate(5));
                list.add(u);
            }

            for (User user: list
                 ) {
                System.out.println(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
    }finally {
        DBUtils.closeAll(re,stmt,conn);
        }
    }

    @Test
    public void TestInsert(){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn  = DBUtils.getConnection();
            stmt =conn.prepareStatement("insert into users VALUES (?,?,?,?,?)");
            stmt.setInt(1,4);
            stmt.setString(2,"aaaa");
            stmt.setString(3,"aaa");
            stmt.setString(4,"aaa@163.com");
//            stmt.setDate(5,new java.sql.Date(System.currentTimeMillis()));
            stmt.setString(5,"2019-12-20");

            int i = stmt.executeUpdate();
            if (i>0){
                System.out.println("成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,stmt,conn);
        }
    }


    @Test
    public void TestUpdate(){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn  = DBUtils.getConnection();
            stmt = conn.prepareStatement("update users set username=?,password=?,email=? where id = ?");

            stmt.setString(1,"jerry123");
            stmt.setString(2,"123");
            stmt.setString(3,"jerry123@163.com");
            stmt.setInt(4,4);
            int i = stmt.executeUpdate();

            if (i>0){
                System.out.println("成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,stmt,conn);
        }
    }

    @Test
    public void TestDelet(){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn  = DBUtils.getConnection();
            String sql = "delete from users where id = 4";
            stmt = conn.prepareStatement(sql);
            if (6>0){
                System.out.println("成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,stmt,conn);
        }
    }

}
