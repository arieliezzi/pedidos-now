package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    static int countId = 0;
    private int id;
    private ArrayList<Product> products;
    private float desc;
    private Market market;
    private Dealer dealer;
    private Client client;
    private Date date;

    public Order(ArrayList<Product> products, float desc, Market market, Dealer dealer, Client client, Date date) {
        this.id = getId();
        this.setProducts(products);
        this.setDesc(desc);
        this.setMarket(market);
        this.setDealer(dealer);
        this.setClient(client);
        this.setDate(date);
    }

    public Order(float desc, Market market, Dealer dealer, Client client, Date date) {
        this.id = getId();
        products = new ArrayList<Product>();
        this.setDesc(desc);
        this.setMarket(market);
        this.setDealer(dealer);
        this.setClient(client);
        this.setDate(date);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public float getDesc() {
        return desc;
    }

    public void setDesc(float desc) {
        this.desc = desc;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private int getId()
    {
        countId++;
        return countId;
    }
}
