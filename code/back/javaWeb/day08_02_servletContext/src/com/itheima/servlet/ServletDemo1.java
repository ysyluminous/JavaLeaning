package com.itheima.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/7/2017.
 */
@WebServlet(name = "ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通多调用GenericServlet的方法得到ServletContext对象
        ServletContext application = this.getServletContext();
        //向ServletContext中添加一个键值对
        application.setAttribute("name","tom");
    }
}
