package com.itheima.history;

import com.itheima.entity.Book;
import com.itheima.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "ShowAllBooksServlet",urlPatterns = {"/showbooks"})
public class ShowAllBooksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.write("我家有以下好书<br/>");
        Map<String, Book> books = DBUtil.findAllBooks();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            out.write("<a href='"+request.getContextPath()+"/bookdetil?id="+book.getKey()+"' target='_blank'>"+book.getValue().getName()+"</a><br/>");
        }

        out.write("<hr/>我最近浏览过的书有：<br/>");
        Cookie[] cookies =request.getCookies();
        for (int i = 0; cookies!= null && i<cookies.length;i++){
            //判断是否有historyBookId的cookie
            if ("historyBookId".equals(cookies[i].getName())){
                String value = cookies[i].getValue();//1-2-3
                String[] ids = value.split("-");
                for (int j = 0;j < ids.length;j++){
                    //根据ID得到指定的书
                    Book book = DBUtil.findBookById(ids[j]);
                    out.print(book.getName()+"</br>");
                }
            }
        }


    }
}










