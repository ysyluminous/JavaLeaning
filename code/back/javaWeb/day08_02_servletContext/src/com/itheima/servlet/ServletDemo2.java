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
@WebServlet(name = "ServletDemo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletContext = (String) this.getServletContext().getAttribute("name");
        if (servletContext == null){
            System.out.println("你不能直接访问这个类");
        }
        System.out.println(servletContext);

    }
}
