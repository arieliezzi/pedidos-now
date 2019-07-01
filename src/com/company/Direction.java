package com.company;

import java.util.Scanner;

public class Direction {

    private Vector2 coords;
    private String street;
    private int number;
    private int floor;
    private String dept; // cambio a string porq no encuentro como scanear el proximo char

    public Direction(Vector2 coords, String street, int number, int floor, String dept) {
        this.setCoords(coords);
        this.setStreet(street);
        this.setNumber(number);
        this.setFloor(floor);
        this.setDept(dept);
    }

    public String toString(){
        return "\nCalle : "+this.getStreet()+"\nNumero : "+this.getNumber()+"\nPiso : "+this.getFloor()+"\nDpto : "+this.getDept()
                +"\nCoords : "+this.getCoords().toString();
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

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void editDirection(){ //Creo modificacion de Direccion para poder modificar el cliente
        System.out.println("\n\nSeleccione el campo a modificar");
        System.out.println("\n1.Calle");
        System.out.println("\n2.Nro Calle");
        System.out.println("\n3.Nro de Piso");
        System.out.println("\n4.Nro de Dpto");
        System.out.println("\n5.Coordenadas");
        System.out.println("\n\n Ingrese seleccion : ");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();

    switch(select){
        case 1:
            System.out.println("\nIngrese la nueva calle : ");
            this.setStreet(scan.nextLine());
            break;
        case 2:
            System.out.println("\nIngrese Nro de calle: ");
            this.setStreet(scan.nextLine());
            break;
        case 3:
            System.out.println("\nIngrese Nro de piso : ");
            this.setFloor(scan.nextInt());
            break;
        case 4:
            System.out.println("\nIngrese Nro de Dpto");
            this.setDept(scan.next());
            break;
        case 5:
            System.out.println("\nEdicion de coordenadas : ");
            System.out.println("\n\nIngrese X : ");
            this.getCoords().setX(scan.nextInt());
            System.out.println("\n\nIngrese Y : ");
            this.getCoords().setY(scan.nextInt());
            break;
    }
    }
}
