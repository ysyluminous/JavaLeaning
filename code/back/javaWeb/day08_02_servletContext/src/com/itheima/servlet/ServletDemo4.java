package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by yaosiyuan on 1/7/2017.
 */
@WebServlet(name = "ServletDemo4",urlPatterns={"/demo4"} )
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        text1();
        // TODO: 路径获取？？？？？？？？？？？
        String path = this.getServletContext().getRealPath("WEB-INF/classes/b.properties");
        Properties properties = new Properties();
        properties.load(new FileInputStream(path));

        System.out.print(properties.get("key"));



    }
    //获取WEB-INF下的a.properties文件
    private void text1() throws IOException {
        String path = this.getServletContext().getRealPath("/WEB-INF/a.properties");//参数一定要以/开头
//        System.out.println(realPath);
        //创建一个Properties
        Properties pro = new Properties();
        pro.load(new FileInputStream(path));
        System.out.print(pro.getProperty("key"));
    }
}
