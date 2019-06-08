package com.yaosiyuan.shrio;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.Arrays;

/**
 * @ClassName HelloWorld
 * @Description 测试类，使用ini文件作为realm
 * @Author yaosiyuan
 * @Date 2019/4/18 21:29
 * @Version 1.0
 **/
public class HelloWorld {

    public static void main(String[] args) {
        //1.创建SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();


        SecurityUtils.setSecurityManager(securityManager);

        //2.获取Subject对象
        Subject subject = SecurityUtils.getSubject();

        //3.判断subject是否认证（登陆）
        System.out.println("isAuthenticated?" + subject.isAuthenticated());
        if (!subject.isAuthenticated()) {
            //4.根据账号和密码进行登录
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("yaosiyuan", "yaosiyuan");

            try {
                //5.通过login方法进行登录，如果登陆失败，会抛出AuthenticationException及其子异常
                subject.login(usernamePasswordToken);
                System.out.println("登录成功");


                //getPrincipal()返回登陆账号名，如果用string接受需要强转
                System.out.println(subject.getPrincipal() + "登陆成功");

                //通过hasRole()方法判断subject是否拥有某个角色
                System.out.println("has Admin?" + subject.hasRole("admin"));
                //subject.checkRole("user");同样是判断subject是否拥有某个角色，如果没有，则抛出异常


                //hasRoles方法可以同时判断subject多个角色，返回类型为boolean类型的数组
                boolean[] results = subject.hasRoles(Arrays.asList("admin", "user"));
                for (boolean result : results) {
                    System.out.println(result);
                }

                //hasAllRoles()判断subject是否同时拥有这些角色。如果一个没有就返回false
                System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user")));


                //权限判定
                System.out.println("------");
                //isPermitted()判断subject是否拥有指定权限
                System.out.println("" + subject.isPermitted("user:add"));
                System.out.println("" + subject.isPermitted("custorm:add"));


                boolean[] permitteds = subject.isPermitted("user:add", "custorm:add");
                for (boolean permitted : permitteds) {
                    System.out.println(permitted);
                }

                //isPermittedAll判断subject是否同时具有权限
                System.out.println(subject.isPermittedAll("user:add", "custorm:add"));

                //checkPermission 判断subject是否有权限，没有则抛出异常。
//                subject.checkPermission("user:add");


                //session在非web环境下也可以使用，建议使用这个。
                Session session = subject.getSession();
                session.setAttribute("uname","yaosiyuan");
                System.out.println(session.getAttribute("uname"));

                //安全退出
                subject.logout();

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
}
