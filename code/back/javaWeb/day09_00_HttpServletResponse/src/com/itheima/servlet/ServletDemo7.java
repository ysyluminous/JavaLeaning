package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/8/2017.
 */
@WebServlet(name = "ServletDemo7",urlPatterns = {"/demo7"})
public class ServletDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("A:我要借钱！");
        System.out.println("B:我没有，胆识我可以告诉你谁有");
//        //告诉浏览器要重新定向新的资源
//        response.setStatus(302);
//        //告诉浏览器要访问那个URL
//        response.setHeader("location","/demo9");

        //请求重定向
        response.sendRedirect("/demo9");
        System.out.println("我去了");
    }
}
