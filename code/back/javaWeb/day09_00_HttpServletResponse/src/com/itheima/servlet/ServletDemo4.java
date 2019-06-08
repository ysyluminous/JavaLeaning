package com.itheima.servlet;


import cn.dsna.util.images.ValidateCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by yaosiyuan on 1/8/2017.
 */
@WebServlet(name = "ServletDemo4",urlPatterns = {"/demo4"})
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        test1(response);
        //告诉浏览器不使用缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setIntHeader("expires",0);

        ValidateCode vc = new ValidateCode(110,25,4,9);
        vc.write(response.getOutputStream());

    }

    private void test1(HttpServletResponse response) throws IOException {
        int width = 110;
        int height = 25;
        //在内存中创建一个图像对象
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //创建一个画笔
        Graphics g = img.getGraphics();

        //给图片添加背景颜色
        g.setColor(Color.PINK);//设置一个颜色
        g.fillRect(1,1,width-2,height-2);//填充颜色

        //给边框一个颜色
        g.drawRect(0,0,width-1,height-1);//设置边框的显示坐标

        //设置文本样式
        g.setColor(Color.BLUE);
        g.setFont(new Font("宋体",Font.BOLD|Font.ITALIC,15));
        //给图片添加文字
        Random rand = new Random();
        int position = 20;
        for (int i = 0;i < 4; i++){
            g.drawString(rand.nextInt(10)+"",position,20);
            position+=20;
        }

        //添加9条下划线
        for (int i =0;i<9;i++){
            g.drawLine(rand.nextInt(width),rand.nextInt(height),rand.nextInt(width),rand.nextInt(height));
        }
        //将图片对象以流的方式输出到客户端
        ImageIO.write(img,"jpg",response.getOutputStream());
    }
}
