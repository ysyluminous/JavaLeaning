package com.itcast.servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yaosiyuan on 1/7/2017.
 */
@WebServlet(name = "ServletConfigDemo1")
public class ServletConfigDemo1 extends HttpServlet {
//    private ServletConfig config;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config=config;
//
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//获得配置文件中的信息
        String encoding = config.getInitParameter("encoding");
        System.out.print(encoding);*/

        //第二种方式
        String encoding = super.getInitParameter("encoding");
//        System.out.println(encoding);

        //第三方式
        String encoding1 = this.getServletConfig().getInitParameter("encoding");
        System.out.println(encoding1);



    }
}
