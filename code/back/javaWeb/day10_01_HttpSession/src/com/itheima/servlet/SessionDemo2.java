package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "SessionDemo2",urlPatterns = {"/SessionDemo2"})
public class SessionDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //得到一个HttpSession对象
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        if (name != null){
            out.println(name);

        }else {
            out.println("你不能访问该资源");
        }
        out.println(session.getId());
    }
}








