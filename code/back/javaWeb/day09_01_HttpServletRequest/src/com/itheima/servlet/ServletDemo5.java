package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "ServletDemo5",urlPatterns = {"/demo5"})
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //

        String str = "aaaa";
        //请求包含
        request.getRequestDispatcher("/demo6").include(request,response);

        System.out.println("我想办事");
        System.out.println("我办不了，但我可以找人帮你办");

        //将非表单的数据添加道request的域中
        request.setAttribute("s",str);

        //将请求转发到demo6
//        request.getRequestDispatcher("/demo6").forward(request,response);

        //注：请求转发不能跳转到其他应用
//        request.getRequestDispatcher("www.baidu.com").forward(request,response);

        //使用重定向
//        response.sendRedirect(request.getContextPath()+"/demo6");
//        response.sendRedirect("/demo6");

        //可以跳转到其他应用
//        response.sendRedirect("http://www.baidu.com");
//        System.out.println("事办完了");





    }
}
