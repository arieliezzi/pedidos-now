package com.company;

public class Product {
    static int countId = 0;
    private int id;
    private String name;
    private String description;
    private int stock;
    private float price;


    public Product(String name, String description, int stock, float price) {
        this.id = setId();
        this.setName(name);
        this.setDescription(description);
        this.setStock(stock);
        this.setPrice(price);
    }

    private int setId() {
        countId++;
        return countId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return id + "- " + name + " - " + " " + description + " stock =" + stock + " $" + price;
    }
}
