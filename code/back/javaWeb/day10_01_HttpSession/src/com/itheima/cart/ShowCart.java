package com.itheima.cart;

import com.itheima.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "ShowCart",urlPatterns = {"/showCart"})
public class ShowCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("购物车有以下商品:</br>");
        //得到session对象
        List<Book> books = (List<Book>) request.getSession().getAttribute("cart");
        if (books == null){
            out.print("你还什么都没买");
            response.setHeader("refresh","2;url=/showbooks");
        }
        for (Book book : books){
            out.write(book.getName()+"</br>");
        }
    }
}
