package com.itheima.util;

import com.itheima.entity.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
public class DBUtil {
    private static Map<String,Book> books = new HashMap<String,Book>();

    static {
        books.put("1",new Book("1","浪潮之巅",20,"奥斯特"));
        books.put("2",new Book("2","圆运动的古中医学说",20,"234"));
        books.put("3",new Book("3","Java编程思想",20,"123"));
        books.put("4",new Book("4","教父",20,"于娟"));
        books.put("5",new Book("5","从你的全世界路过",20,"于娟"));
        books.put("6",new Book("6","JAVA核心技术",20,"于娟"));
        books.put("7",new Book("7","思考中医",20,"于娟"));
        books.put("8",new Book("8","黄帝内经",20,"于娟"));
        books.put("9",new Book("9","大型网站核心技术",20,"于娟"));
    }

    //得到所有的书
    public static Map<String,Book> findAllBooks(){
        return books;
    }
    //根据id查找指定的书
    public static Book findBookById(String id){
        return books.get(id);
    }
}













