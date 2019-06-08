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
@WebServlet(name = "ServletDemo1",urlPatterns = {"/demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            getMethod();获得请求方式
//      ***getRequestURL();返回客户端发出请求时的完整URL
//      ***getRequestRUI();返回请求行中的资源名部分
//      *****getContextPath();当前应用的虚拟目录/day09_01_request
//      getQueryString();返回请求行中的参数部分


//        System.out.println(request);
//        System.out.println(response);

        System.out.println(request.getMethod());

        // TODO: 输出有误
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        System.out.println(request.getContextPath());
        System.out.println(request.getQueryString());









    }
}
