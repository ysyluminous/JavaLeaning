package com.yaosiyuan.ehcache;

/**
 * @ClassName com.yaosiyuan.ehcache.User
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/5/19 16:23
 * @Version 1.0
 **/
public class User {
    private int id;
    private String name;


    public User() {

    }
    public User(int id , String name) {
        super();
        this.id= id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "com.yaosiyuan.ehcache.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
