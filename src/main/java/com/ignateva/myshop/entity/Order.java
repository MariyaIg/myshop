package com.ignateva.myshop.entity;

import java.util.Date;

public class Order extends Entity {
    private int id;
    private int number;
    Date date;
    private String title;
    private int price;
    private int amount;
    private String description;

    public Order() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order(int id, int number, Date date) {
        super(id);
        this.number = number;
        this.date = date;
    }
    public Order( int number, Date date) {
        this.number = number;
        this.date = date;
    }
    public Order(Date date,String title, String description, int amount,int price) {

        this.date = date;
        this.title=title;
        this.description=description;
        this.amount = amount;
        this.price =price;

    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}



