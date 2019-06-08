package com.itheima.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "ClearServlet",urlPatterns = {"/servlet/clear"})
public class ClearServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //创建一个cookie对象
        Cookie ck = new Cookie("lastAccessTime","");
        ck.setPath("/");//要设置被删除cookie 的path，否则可能删错对象
        ck.setMaxAge(0);//相当于删除
        response.addCookie(ck);//讲ck写回客户端缓存
    }
}
