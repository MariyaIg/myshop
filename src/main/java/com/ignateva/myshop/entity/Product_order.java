package com.ignateva.myshop.entity;

public class Product_order {
    private int id;
    private int product_id;
    private int order_id;
    private int amount;

    public Product_order(int id, int product_id, int order_id, int amount) {
        this.id = id;
        this.product_id = product_id;
        this.order_id = order_id;
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
