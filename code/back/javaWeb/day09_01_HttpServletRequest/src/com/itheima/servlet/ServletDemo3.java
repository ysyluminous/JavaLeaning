package com.itheima.servlet;

import com.itheima.entity.User;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by yaosiyuan on 1/8/2017.
 */
@WebServlet(name = "ServletDemo3",urlPatterns = {"/demo3"})
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //告诉服务器要使用什么编码，注：浏览器使用的是什么编码，传过来就是什么编码
        request.setCharacterEncoding("UTF-8");//只能解决post方式的编码问题
        //get方式编码
//        String name = new String(name.getBytes("iso-8859-1"),"UTF-8");
//        test2(request);
//        test3(request);
//        test4(request);


    }

    private void test4(HttpServletRequest request) {
        //获取表单信息
        User u = new User();
        System.out.println("封装数据前" + u.toString());
        Map<String,String[]> map =  request.getParameterMap();
        for (Map.Entry<String, String[]> m: map.entrySet()){
            String name = m.getKey();
            String[] value = m.getValue();

            //创建一个属性描述器
            try {
                PropertyDescriptor pd = new PropertyDescriptor(name,User.class);
                //得到setter属性
                Method setter = pd.getWriteMethod();
                if (value.length ==1){
                    setter.invoke(u,value[0]);//给一个值的变量赋值
                }else{
                    setter.invoke(u,(Object)value);//相当于给一个复选框赋值
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }


        System.out.println("封装数据后" + u.toString());
    }

    private void test3(HttpServletRequest request) throws UnsupportedEncodingException {
        //告诉服务器要使用什么编码，注：浏览器使用的是什么编码，传过来就是什么编码
        request.setCharacterEncoding("UTF-8");
        //获取素有的表单name的名字
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();//得到每一个name名
//            System.out.println(name);
            String [] values = request.getParameterValues(name); //根据name名得到value值
            for(int i = 0; values!=null && i < values.length;i++){
                System.out.println(name+"\t"+values[i]);
            }
        }
    }

    private void test2(HttpServletRequest request) throws UnsupportedEncodingException {
        //告诉服务器要使用什么编码，注：浏览器使用的是什么编码，传过来就是什么编码
        request.setCharacterEncoding("UTF-8");

        //获取表单数据
        //根据表单中name属性的名，获取value属性的值方法
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String [] hobbies = request.getParameterValues("hobby");

        String city = request.getParameter("city");

        System.out.println(userName);
        System.out.println(pwd);
        System.out.println(sex);
        for (int i = 0;hobbies !=null && i < hobbies.length;i++){
            System.out.print(hobbies[i] + "\t");
        }
        System.out.println();
        System.out.println(city);
    }
}
