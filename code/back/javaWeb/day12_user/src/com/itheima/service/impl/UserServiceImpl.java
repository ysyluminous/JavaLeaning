/*
package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;

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

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) throws Exception {
        userDao.addUser(user);
    }
}
*/
package com.itheima.service.impl;

import org.omg.CORBA.UserException;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.exception.UserExistException;
import com.itheima.exception.UsersException;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    public void register(User user) throws Exception {
        userDao.addUser(user);
    }

    public User login(User user)  {
        User u = null;
        try {

            u = userDao.findUser(user);

        } catch (Exception e) {
            e.printStackTrace();
            //写入日志
        }
        return u;
    }

    public boolean findUserByName(String name) throws UserExistException {
        boolean b = userDao.findUserByName(name);
        if(b){
            throw new UserExistException("用户名已存在");
        }
        return b;
    }

}
