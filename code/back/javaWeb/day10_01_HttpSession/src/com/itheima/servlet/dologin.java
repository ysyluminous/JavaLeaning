package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "dologin",urlPatterns = {"/dologin"})
public class dologin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String code = request.getParameter("code");
        String scode = (String) request.getSession().getAttribute("scode");
        //处理业务逻辑
        if ("tom".equals(userName) && "123".equals(pwd)){
            if (!code.equals(scode)){
                String msg = "验证码错误";
                request.setAttribute("msg",msg);
                //
                 //分发转向
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
            out.print("登陆成功");
        }
    }
}
