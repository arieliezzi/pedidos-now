package com.company;

import java.util.ArrayList;

public abstract class Person extends User {

    private String lastName;
    private String name;
    private Direction direction;
    private int telphone;
    private ArrayList<Order> orders;


    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, ArrayList<Order> orders) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTelphone(telphone);
        this.setOrders(orders);
    }

    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTelphone(telphone);

        orders = new ArrayList<Order>();
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTelphone() {
        return telphone;
    }

    public void setTelphone(int telphone) {
        this.telphone = telphone;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }
}