package com.company;

import java.util.ArrayList;

public class Dealer extends Person {

    private Vector2 actualCoords;
    private boolean available;

    public Dealer(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, ArrayList<Order> orders, Vector2 actualCoords, boolean available) {
        super(userName, pass, email, lastName, name, direction, telphone, orders);
        this.setActualCoords(actualCoords);
        this.setAvailable(available);
    }

    public Dealer(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, Vector2 actualCoords, boolean available) {
        super(userName, pass, email, lastName, name, direction, telphone);
        this.setActualCoords(actualCoords);
        this.setAvailable(available);
    }

    public Vector2 getActualCoords() {
        return actualCoords;
    }

    public void setActualCoords(Vector2 actualCoords) {
        this.actualCoords = actualCoords;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
