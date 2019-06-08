package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "DologinServlet",urlPatterns = {"/dologin"})
public class DologinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        //处理业务逻辑
        if ("tom".equals(userName) && "123".equals(pwd)){
            request.getSession().setAttribute("name",userName);
            request.getRequestDispatcher("/success.jsp").forward(request,response);
        }else {
            request.setAttribute("msg", "用户名或密码不正确！");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
