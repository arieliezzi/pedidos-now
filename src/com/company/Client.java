package com.company;

import java.util.ArrayList;

public class Client extends Person {

    private ArrayList<Direction> frequentsDirections;


    public Client(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, ArrayList<Order> orders, ArrayList<Direction> frequentsDirections) {
        super(userName, pass, email, lastName, name, direction, telphone, orders);
        this.setFrequentsDirections(frequentsDirections);
    }

    public Client(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone) {
        super(userName, pass, email, lastName, name, direction, telphone);
        this.frequentsDirections = new ArrayList<Direction>();
    }

    public ArrayList<Direction> getFrequentsDirections() {
        return frequentsDirections;
    }

    public void setFrequentsDirections(ArrayList<Direction> frequentsDirections) {
        this.frequentsDirections = frequentsDirections;
    }

    public void addNewFrequentDirection(Direction pDirection)
    {
        frequentsDirections.add(pDirection);
    }
}
