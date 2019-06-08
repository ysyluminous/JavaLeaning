package com.yaosiyuan;

/**
 * @ClassName Person
 * @Description TODO
 * @Author yaosiyuan
 * @Date 2019/5/18 22:56
 * @Version 1.0
 **/

public class Person {

    private  int id;
    private  String name;

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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
