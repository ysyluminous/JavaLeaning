package com.yaosiyuan.shrio;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @ClassName com.yaosiyuan.shrio.MyShiroRealm
 * @Description 自定义用户账号密码，不在通过ini文件
 * @Author yaosiyuan
 * @Date 2019/4/21 15:06
 * @Version 1.0
 **/
public class MyShiroRealm implements Realm {
                public String getName() {
                    return "myRealm";
                }

                public boolean supports(AuthenticationToken authenticationToken) {
                    return authenticationToken instanceof UsernamePasswordToken;
                }

                public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
                    UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
                    String username = usernamePasswordToken.getUsername();
                    String password = new String(usernamePasswordToken.getPassword());

                    if (!"tom".equals(username)){
                        throw new UnknownAccountException("找不到该用户");
        }
        if (!"0000".equals(password)){
            throw  new IncorrectCredentialsException("密码错误");
        }


        if (1==1){
            throw new LockedAccountException("账号被锁定");
        }
        return new SimpleAuthenticationInfo(username,password,getName());


    }
}
