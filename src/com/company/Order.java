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

    private int getId() {
        countId++;
        return countId;
    }


    public void showOrderProducts(){ //Creo esta funcion para poder listar los productos a la hora de editar
        for (int i=0; i< this.getProducts().size(); i++){
            System.out.println("\n"+i+this.getProducts().get(i).toString());
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

}
