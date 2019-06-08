package com.itheima.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by yaosiyuan on 1/7/2017.
 */
@WebServlet(name = "ServletDemo3",urlPatterns = {"/demo3"})
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过路径得到一个输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/classes/1.png");
        FileInputStream fis = new FileInputStream(path);

        //创建字节输出流
        ServletOutputStream sos = response.getOutputStream();


        String filename= path.substring(path.lastIndexOf("\\")+1);

        //告知客户端要下载文件
        response.setHeader("content-disposition","attachment;filename="+filename);
        response.setHeader("content-type","image/png");


        //设置文件名的编码
        filename = URLEncoder.encode(filename,"UTF-8");//将不安全的文件名改为UTF-8

        //执行输出操作
        int len =1;
        byte []b = new byte[1024];
        while ((len=fis.read(b))!=-1){
            sos.write(b,0,len);
        }
    }
}
