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
@WebServlet(name = "ServletDemo5", urlPatterns={"/demo5"})
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我要办事");
        System.out.println("你的是事我办不了，但是我可以帮你找人办");

        ServletContext servletContext = this.getServletContext();
        servletContext.getRequestDispatcher("/demo6").forward(request,response);

        System.out.println("事办完了");


    }
}
