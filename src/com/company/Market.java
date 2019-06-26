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

    public Market(String userName, String pass, String email,Direction directionMarket, String name) {
        super(userName, pass, email);
        this.setDirectionMarket(directionMarket);
        this.setName(name);
        products= new ArrayList<Product>();
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

    public void addNewProduct()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Creando nuevo producto");
        System.out.println("Ingrese el nombre:");
        String name = scan.nextLine();

        System.out.println("Ingrese una descripcion del producto:");
        String description = scan.nextLine();

        System.out.println("Ingrese la cantidad disponible");
        int stock = scan.nextInt();

        System.out.println("Precio:");
        float price = scan.nextFloat();


        Product product = new Product(name,description,stock,price);
        products.add(product);
    }

    public void showProducts()
    {
        for (Product p: getProducts()) {
            System.out.println(p);
        }
    }

    public void modifyProduct() throws Exception
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Elige el producto a modificar: ");
        showProducts();

        System.out.println("");
        System.out.println("Ingrese el ID del producto a modificar");
        int res = scan.nextInt();

        Product product = findProduct(res);

        System.out.println("Que campo va a modificar?");
        System.out.println("1 - Nombre");
        System.out.println("2 - Descripcion");
        System.out.println("3 - Precio");
        System.out.println("4 - Stock");

        res = scan.nextInt();

        switch (res) {
            case 1:
                System.out.println("Ingrese el nuevo nombre");
                product.setName(scan.nextLine());
                break;
            case 2:
                System.out.println("Ingrese la nueva descripcion");
                product.setDescription(scan.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo precio");
                product.setPrice(scan.nextFloat());
                break;
            case 4:
                System.out.println("Ingrese el nuevo stock");
                product.setStock(scan.nextInt());
                break;
            default:
                System.out.println("Opcion incorrecta");
                modifyProduct();
                break;
        }


    }


    private Product findProduct(int index) throws Exception
    {
        Product product;
        try {
            product = getProducts().get(index);
        }
        catch(NullPointerException e) {
            throw new Exception("El producto no se encontraba en la lista");
        }

        return product;
    }


}
