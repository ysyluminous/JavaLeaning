package com.itheima.entity;

import java.util.Arrays;

/**
 * Created by yaosiyuan on 1/8/2017.
 */

//在实体类中的字段要与表单中的name名一致，约定优于编码
public class User {
    private String userName;
    private String pwd;
    private String sex;
    private String city;
    private String [] hobby;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
