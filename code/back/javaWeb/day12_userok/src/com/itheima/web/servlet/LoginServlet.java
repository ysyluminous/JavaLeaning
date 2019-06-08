package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.exception.UsersException;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/12/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
@WebServlet(name = "LoginServlet",urlPatterns = {"/servlet/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();


        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }


        UserService us = new UserServiceImpl();

        User u = null;
        try {
            u = us.login(user);

            //分发转向
            if(u!=null){
                request.getSession().setAttribute("u", user);//如果登录成功，就把user对象放到session对象 中
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("/login1.jsp").forward(request, response);
            }
        } catch (UsersException e) {
//                request.setAttribute("msg",e.getMessage());
//                request.getRequestDispatcher("/login1.jsp").forward(request,response);
                e.printStackTrace();
                //登录失败跳回登录页面
//              response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
    }

//        request.setAttribute("u",user);
//        request.getRequestDispatcher("/index1.jsp").forward(request,response);
}

