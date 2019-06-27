package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person extends User {

    private String lastName;
    private String name;
    private Direction direction;
    private int tel; //cambie el nombre porq tiraba warning
    private ArrayList<Order> orders;


    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int tel, ArrayList<Order> orders) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTel(tel);
        this.setOrders(orders);
    }

    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int tel) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTel(tel);

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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void showOrdersName(){ //creo para listar a la hora de editar o buscar
        for (int i=0; i<this.getOrders().size(); i++){
            System.out.println("\n\n"+i+" "+this.getOrders().get(i).getMarket().getName()); //Solo muestro el nombre para seleccionar
        }
    }
    public Order getSpecificOrder(){ //Permite seleccionar el market y retorna la orden
        System.out.println("\nChoose a Market : ");
        this.showOrdersName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese seleccion : ");
        int resp = scanner.nextInt();
        return this.getOrders().get(resp);
    }
}