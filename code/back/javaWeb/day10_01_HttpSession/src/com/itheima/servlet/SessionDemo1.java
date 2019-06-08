package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "SessionDemo1",urlPatterns = {"/SessionDemo1"})
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

//        name = new String(name.getBytes("GBK"),"UTF-8");
        //得到一个HttpSession对象
        HttpSession session = request.getSession();
        session.setAttribute("name",name);
        response.getWriter().write(session.getId());
    }
}













