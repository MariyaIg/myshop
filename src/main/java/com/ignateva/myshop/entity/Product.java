package com.ignateva.myshop.entity;

public class Product extends Entity{
    private int id;
    private String title;
    private int price;
    private String description;
    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Товар: [id=" + id + ", Наименование=" + title + ", price " + price + ", description + " + description;
    }

    public Product(int id, String title,String description,int price) {
        super(id);
        this.title = title;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
