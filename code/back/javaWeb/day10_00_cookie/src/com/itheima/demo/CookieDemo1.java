package com.itheima.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import static java.lang.System.out;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "CookieDemo1",urlPatterns = {"/servlet/ck1"})
public class CookieDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取客户端保存的最后访问时间
        Cookie[] cookies = request.getCookies();//获取客户端的所有cookie对象
        for (int i = 0;cookies != null && i < cookies.length;i++){
            //判断当前的cookie中的name是否是想要的cookie

            if ("lastAccessTime".equals(cookies[i].getName())){
                //如果是想要的cookie，则把cookie取出
                long l = Long.parseLong(cookies[i].getValue());
                out.write("你的最后访问时 间为"+new Date(l).toLocaleString());//yyyy-MM-dd
            }
        }
        out.print("<a href='/servlet/clear'>clear</a>");



        //创建cookie并把信息写回到客户端
        Cookie lastAccessTime = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        //设置cookie的有效时间，单位是秒
        lastAccessTime.setMaxAge(60*5);//保存时间为5分钟

        //设置cookie的path
//        lastAccessTime.setPath("demo1");
        lastAccessTime.setPath("/");

        //把cookie信息写回浏览器
        response.addCookie(lastAccessTime);

    }
}







