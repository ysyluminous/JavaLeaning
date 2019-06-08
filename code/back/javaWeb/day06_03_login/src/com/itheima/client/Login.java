package com.itheima.client;

import com.itheima.entity.User;
import com.itheima.service.DoLogin;

import java.util.Scanner;

/************************************************************************
 *
 * Filename:	
 *
 * Describe: 
 *
 * @author Yao Siyuan on 1/15/2017.
 *
 * Summary:	
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Login {
        public static void main(String args[]){
            Scanner input = new Scanner(System.in);
            System.out.println("请输入用于名");
            String name = input.nextLine();
            System.out.println("请输入密码");
            String pwd = input.nextLine();

            DoLogin dl = new DoLogin();
            User user = dl.findUser(name, pwd); // 调用查询用户的方法
            if (user != null){
                System.out.println("欢迎你"+name);
            }else {
                System.out.println("用户名或密码错误");
            }
        }

}
