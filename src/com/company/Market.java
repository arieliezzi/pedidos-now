package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Market extends User {
    private Direction directionMarket;
    private String name;
    private ArrayList<Product> products;

    public Market(String userName, String pass, String email, Direction directionMarket, String name, ArrayList<Product> products) {
        super(userName, pass, email);
        this.setDirectionMarket(directionMarket);
        this.setName(name);
        this.setProducts(products);
    }

    public Market(String userName, String pass, String email, Direction directionMarket, String name) {
        super(userName, pass, email);
        this.setDirectionMarket(directionMarket);
        this.setName(name);
        products = new ArrayList<Product>();
    }


    public String toString() {
        return "\nName : " + this.getName() +"\nE-mail : "+this.getEmail() + "\nDirection : " + this.getDirectionMarket().getStreet() + " / " + this.getDirectionMarket().getNumber();
    }

    public Direction getDirectionMarket() {
        return directionMarket;
    }

    public void setDirectionMarket(Direction directionMarket) {
        this.directionMarket = directionMarket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addNewProduct() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creando nuevo producto: ");
        System.out.println("Ingrese el nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese una descripcion del producto:");
        String description = scan.nextLine();

        System.out.println("Ingrese la cantidad disponible");
        int stock = scan.nextInt();

        System.out.println("Precio:");
        float price = scan.nextFloat();


        Product product = new Product(name, description, stock, price);
        products.add(product);
    }

    public void showProducts() {
        for (int i = 0; i < this.getProducts().size(); i++) {
            System.out.println("Producto nro " + i + " : " + this.getProducts().get(i).toString());
            System.out.println("<------------------------------------------------------------------>");
        }

    }

    public Product findProduct(int index) throws Exception {
        Product product;
        try {
            product = getProducts().get(index);
        } catch (NullPointerException e) {
            throw new Exception("El producto no se encontraba en la lista");
        }
        return product;
    }


    public void stockHandler() { //Muestra productos y permite modificar stock
        int i=0;
        for (Product p :this.getProducts()){
            System.out.println("Articulo "+i+" "+p.toString());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese articulo a modificar : ");
        int resp = scanner.nextInt();
        System.out.println("Ingrese nuevo stock (El stock actual no sera considerado) : ");
        Scanner scanner2 = new Scanner(System.in);
        int newStock = scanner2.nextInt();
        this.getProducts().get(resp).setStock(newStock);
    }

    public void editMarket(){
        System.out.println("Que campo desea modificar : ");
        System.out.println("1 - Nombre");
        System.out.println("2 - E-mail");
        System.out.println("3 - Direccion");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese seleccion : ");
        int resp = scanner.nextInt();
        Scanner scanner2 = new Scanner(System.in);
        switch(resp){
            case 1:
                System.out.println("Ingrese nuevo valor para nombre : ");
                this.setName(scanner2.nextLine());
                break;
            case 2:
                System.out.println("Ingrese nuevo valor para E-mail: ");
                this.setEmail(scanner2.nextLine());
                break;
            case 3:
                System.out.println("Edicion de direccion : ");
                this.getDirectionMarket().editDirection();
                break;
        }
        System.out.println("Operacion terminada con exito!");
    }

}
