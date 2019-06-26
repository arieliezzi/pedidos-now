package com.company;

public class Direction {

    private Vector2 coords;
    private String street;
    private int number;
    private int floor;
    private char dept;

    public Direction(Vector2 coords, String street, int number, int floor, char dept) {
        this.setCoords(coords);
        this.setStreet(street);
        this.setNumber(number);
        this.setFloor(floor);
        this.setDept(dept);
    }

    public Vector2 getCoords() {
        return coords;
    }

    public void setCoords(Vector2 coords) {
        this.coords = coords;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public char getDept() {
        return dept;
    }

    public void setDept(char dept) {
        this.dept = dept;
    }
}
