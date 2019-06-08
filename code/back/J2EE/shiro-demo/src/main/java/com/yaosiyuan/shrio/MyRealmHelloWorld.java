package com.yaosiyuan.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @ClassName MyRealmHelloWorld
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/4/21 20:37
 * @Version 1.0
 **/
public class MyRealmHelloWorld {
    public static void main(String[] args) {
        //1.创建SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();


        SecurityUtils.setSecurityManager(securityManager);

        //2.获取Subject对象
        Subject subject = SecurityUtils.getSubject();


        //3.登陆
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("tom", "0000");
        try {

            subject.login(usernamePasswordToken);
            System.out.println("登陆成功");
        } catch (UnknownAccountException ex) {//找不到账号时抛出的异常
            System.out.println("UnknownAccountException");
        } catch (IncorrectCredentialsException ex) {//密码不正确时抛出
            System.out.println("IncorrectCredentialsException");
        } catch (LockedAccountException ex) {//账号锁定的异常
            System.out.println("LockedAccountException");
        } catch (AuthenticationException ex) {//父异常
            System.out.println("AuthenticationException");
        }


    }
}
