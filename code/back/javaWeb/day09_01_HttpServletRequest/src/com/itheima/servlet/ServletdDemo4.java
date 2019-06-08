package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "ServletdDemo4",urlPatterns = {"/demo4"})
public class ServletdDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        ServletInputStream sis = request.getInputStream();
        int len = 0;
        byte[] b = new byte[1024];

        while ((len = sis.read(b) )!= -1){
            System.out.println(new String(b,0,len));
        }

        sis.close();







    }
}
