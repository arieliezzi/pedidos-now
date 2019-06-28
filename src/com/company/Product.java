package com.company;

import java.util.Scanner;

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


    public void modifyProduct() throws Exception {
        Scanner scan = new Scanner(System.in);


        System.out.println("Edicion de producto : ");


        System.out.println("Que campo va a modificar?");
        System.out.println("1 - Nombre");
        System.out.println("2 - Descripcion");
        System.out.println("3 - Precio");
        System.out.println("4 - Stock");
        System.out.println("\n\n Ingrese seleccion : ");
       int res = scan.nextInt();

        switch (res) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                this.setName(scan.nextLine());
                break;
            case 2:
                System.out.println("Ingrese la nueva descripcion");
                this.setDescription(scan.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo precio");
               this.setPrice(scan.nextFloat());
                break;
            case 4:
                System.out.println("Ingrese el nuevo stock");
                this.setStock(scan.nextInt());
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }


    }
}
