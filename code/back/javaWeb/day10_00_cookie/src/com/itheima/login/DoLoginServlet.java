package com.itheima.login;

import com.sun.org.apache.regexp.internal.RE;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.System.out;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "DoLoginServlet",urlPatterns = {"/dologin"})
public class DoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String remember = request.getParameter("remember");



        Cookie ck = new Cookie("userName", userName);
        ck.setPath("/");

        //处理业务逻辑
        if ("tom".equals(userName)&&"123".equals(pwd)){
            if (remember!=null){

                ck.setMaxAge(Integer.MAX_VALUE); //设置cookie的有效保存时间
            }else {
                ck.setMaxAge(0);//删除cookie
            }
            response.addCookie(ck);//将cookie写回到客户端
            out.write("登陆成功");
        }else{
            out.write("登陆失败！！");
            //设置两秒钟重新登录
            response.setHeader("refresh","2;url=/login");
        }

        //分发转向
    }
}







