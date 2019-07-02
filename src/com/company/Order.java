package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Order {
    static int countId = 0;
    private int id;
    private ArrayList<Product> products;
    private float desc;
    private Market market;
    private Dealer dealer;
    private Client client;
    private Date date;
    private boolean state; //para identificar si esta pendiente o no


    public Order(ArrayList<Product> products, float desc, Market market, Client client, Date date) {
        this.id = getId();
        this.setProducts(products);
        this.setDesc(desc);
        this.setMarket(market);
        this.setDealer(null);
        this.setClient(client);
        this.setDate(date);
        this.setState(false);
    }

    public Order(float desc, Market market, Client client, Date date) {
        this.id = getId();
        products = new ArrayList<Product>();
        this.setDesc(desc);
        this.setMarket(market);
        this.setDealer(null);
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

    public boolean getState() {
        return this.state;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private int getId() {
        countId++;
        return countId;
    }

    public float getTotal() {
        float total = 0;
        for (Product p : getProducts()) {
            total = total + p.getPrice();
        }

        return total;
    }

    public void showFullOrder() {
        System.out.println("Market : " + this.getMarket().getName());
        System.out.println("Order : --->");
        for (int i = 0; i < this.getProducts().size(); i++) {

            System.out.println("\n" + this.getProducts().get(i).toString());
        }
        System.out.println("\nTotal : $" + this.getTotal());
    }

    public void showOrderProducts() { //Creo esta funcion para poder listar los productos a la hora de editar
        for (int i = 0; i < this.getProducts().size(); i++) {
            System.out.println("\n" + i + this.getProducts().get(i).toString());
        }
    }

    public void editOrder() throws Exception {
        System.out.println("\n\nSeleccione el producto a modificar : ");
        this.showOrderProducts(); //Listo los productos de esta orden
        System.out.println("\n\nIngrese nro de producto a modificar: ");
        Scanner scanner = new Scanner(System.in);
        int productIndex = scanner.nextInt();//Almaceno el index del producto a modificar
        Product toModify = this.getProducts().get(productIndex); //Capturo el producto
        try {
            toModify.modifyProduct();
        } catch (Exception e) {
            e.printStackTrace(); //Aca deberiamos crear otra excepecion
        }
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
