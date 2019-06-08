package com.itheima.cart;

import com.itheima.entity.Book;
import com.itheima.util.DButil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosiyuan on 1/10/2017.
 */
@WebServlet(name = "AddCart",urlPatterns = {"/addCart"})
public class AddCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //根据ID得到书
        String id = request.getParameter("id");
        Book book = DButil.findBookById(id);
        PrintWriter out = response.getWriter();

        //得到session对象
        HttpSession session = request.getSession();
        //从session中取出list（购物车）
        List<Book> list = (List<Book>) request.getSession().getAttribute("cart");
        if (list == null){
            list = new ArrayList<Book>();
        }
        list.add(book);
        out.print("购买成功！");
        session.setAttribute("cart",list);
        String url = request.getContextPath()+"/showbooks";
        response.setHeader("refresh", "2;url="+response.encodeURL(url));
    }
}







