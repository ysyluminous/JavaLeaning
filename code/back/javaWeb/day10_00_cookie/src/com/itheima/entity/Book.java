package com.itheima.entity;

/**
 * Created by yaosiyuan on 1/9/2017.
 */
public class Book {
    private String id;
    private String name;
    private double price;
    private String author;

    public Book(String id, String name, double price, String author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
