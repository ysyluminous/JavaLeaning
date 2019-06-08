/*
package com.itheima.web.servlet;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet(name = "RegServlet",urlPatterns = {"/regservlet"})
public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取表单数据
        User user = new User();

        // TODO: 1/11/2017
        try {
            ConvertUtils.register(new Converter(){   //注册一个日期转换器
                @Override
                public Object convert(Class type, Object value) {
                    Date date1 = null;
                    if (value instanceof String){
                        String date = (String) value;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date1 = sdf.parse(date);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    return date1;
                }
            },Date.class);
            ConvertUtils.register(new DateLocaleConverter(),Date.class);
            BeanUtils.populate(user,request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //调用业务逻辑

        UserService us = new UserServiceImpl();
        try {
            us.register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //分发转向
        response.getWriter().write("注册成功");
        response.setHeader("refresh","1;url="+request.getContextPath()+"/index.jsp");

    }
}
*/


package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.itheima.domain.User;
import com.itheima.domain.UserForm;
import com.itheima.exception.UserExistException;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;


@WebServlet(name = "RegServlet",urlPatterns = {"/regservlet"})
public class RegServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        // 获取表单数据
        // 验证操作
        UserForm uf = new UserForm();
        try {
            BeanUtils.populate(uf, request.getParameterMap());
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        if (!uf.validate()) {// 如果map中不为空，说明有错误信息
            request.setAttribute("uf", uf);
            request.getRequestDispatcher("/reg.jsp").forward(request, response);
            return;
        }

        User user = new User();
        try {
			/*
			 * ConvertUtils.register(new Converter() {//注册一个日期转换器
			 *
			 * public Object convert(Class type, Object value) { Date date1 =
			 * null; if(value instanceof String){ String date = (String) value;
			 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); try {
			 * date1 = sdf.parse(date); } catch (ParseException e) {
			 * e.printStackTrace(); } } return date1; } }, Date.class);
			 */
            ConvertUtils.register(new DateLocaleConverter(), Date.class);

            BeanUtils.populate(user, request.getParameterMap());

            // 调用业务逻辑
            UserService us = new UserServiceImpl();
            //查看用户名是否已被注册
            us.findUserByName(user.getUsername());

            us.register(user);
        } catch (UserExistException e) {

            request.setAttribute("error", "用户名已存在");
            request.getRequestDispatcher("/reg.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 分发转向
        response.getWriter().write("注册成功！1秒跳转到主页");
        response.setHeader("refresh", "1;url=" + request.getContextPath()
                + "/index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}


