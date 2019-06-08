package com.itheima.entity;


/************************************************************************
 *
 * Filename:
 *
 * Describe: mindview/page
 *
 * @author yaosiyuan on 1/11/2017.
 *
 * Summary:
 *
 * @version 0.1
 *
 * Record:
 *			0.1:
 *
 ************************************************************************/
public class Student {
    private String name;
    private String pwd;
    private City address = new City();

    public City getAddress() {
        return address;
    }

    public void setAddress(City address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
