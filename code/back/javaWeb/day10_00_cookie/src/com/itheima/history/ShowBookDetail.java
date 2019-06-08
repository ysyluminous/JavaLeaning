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
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
@WebServlet(name = "ShowBookDetail",urlPatterns = {"/bookdetil"})
public class ShowBookDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //显示图书的详细信息
        //获得id
        String id = request.getParameter("id");
        Book book = DBUtil.findBookById(id);

//        out.write(book.toString());
        out.print(book);

        //把当前浏览过的书的id写回到客户端
        String  historyBookId = organizedID(id,request);;
        Cookie ck = new Cookie("historyBookId", historyBookId);
        ck.setPath("/");
        ck.setMaxAge(Integer.MAX_VALUE);//设置cookis的保存时间
        response.addCookie(ck);//写回到客户端
    }

/*
*   客户端                         showAllBooks             showBookDetail
*  没有Cookie                           1                   historyBookId=1
*  有Cookie，但没有historyBookid         1                    historyBookId=1
*  historyBookId=1                      2                   historyBookId=2-1
*  historyBookId=1-2                    2                   historyBookId=2-1
*  historyBookId=1-2-3                  2                   historyBookId=2-1-3
*  historyBookId=1-2-3                  4                   historyBookId=4-1-2
*
* */

    private String organizedID(String id,HttpServletRequest request){
            //得到客户端的Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            return id;
        }

        //查找有没有name叫做historyBook的cookie
        Cookie historyBook = null;
        for (int i = 0; i < cookies.length;i++){
            if ("historyBookId".equals(cookies[i].getName())){
                historyBook = cookies[i];
            }
        }

        if (historyBook == null){
            return id;
        }

        String value = historyBook.getValue();//2-1-3
        String[] values = value.split("-");
        //把数组转换为集合
        LinkedList<String> list = new LinkedList<String >(Arrays.asList(values));

        if (list.size() < 3){ //1 2
            if (list.contains(id)){
                //如果包含当前id的值，则删除这个id
                list.remove(id);
            }
        }else {
            if (list.contains(id)){
                list.remove(id);
                //说明有3本书的id了
            }else{
                //把最有一个id删除
                list.removeLast();
            }
        }
        //最新的书的ID添加到最前面
        list.addFirst(id);

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size();i++){
            if (i>0){
                sb.append("-");
            }
            sb.append(list.get(i));
        }
        System.out.println(sb);
        return sb.toString();
    }








}











