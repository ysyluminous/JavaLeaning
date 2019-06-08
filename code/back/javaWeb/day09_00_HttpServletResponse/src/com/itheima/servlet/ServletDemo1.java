package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yaosiyuan on 1/7/2017.
 */
@WebServlet(name = "ServletDemo1",urlPatterns = {"/demo1"})
public class ServletDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//      服务器中默认的编码是ISO-8859-1，它不支持中文
//      tomcat规定的
/*//        告诉浏览器应该使用UTF-8解析文本
        response.setCharacterEncoding("UTF-8");
//        告诉客户端应该使用什么编码
        response.setHeader("content-type","text/html;charset='UTF-8'");*/

//      告诉服务器应该使用UTF-8解析文本，告诉客户端要使用什么编码
        response.setContentType("text/html;charset=UTF-8");

        //得到一个字符输出流
        PrintWriter out = response.getWriter();
        out.write("你好!!!");//向客户端相应文本内容
//        out.write("<html><head><meta charset='UTF-8'></head><body>你好123！</body></html>");
    }
}
