package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Created by yaosiyuan on 1/8/2017.
 */
@WebServlet(name = "ServletDemo5",urlPatterns = {"/demo5"})
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");

//        response.setIntHeader("refresh",1);
//
//        Random r = new Random();
//        response.getWriter().write(r.nextInt()+"");

        response.getWriter().write("注册成功！3秒钟跳到主页");
//        设置3秒钟跳转
        response.setHeader("refresh","3;url=/demo6");
    }
}
