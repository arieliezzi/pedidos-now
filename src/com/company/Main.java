package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static UserController userController;
    private static OrderController orderController;

    public static void main(String[] args) throws Exception {

        userController = new UserController();
        orderController = new OrderController(userController);
        init();
        int option = 0;
        while (option != 5) {

            option = ShowOptions();
            optionSelection(option);
        }

    }

    private static void init() {


        Direction dir1 = new Direction(new Vector2(1, 1), "Alem", 123, 0, "0");
        Direction dir2 = new Direction(new Vector2(15, 20), "Cordoba", 123, 0, "0");
        Direction dir3 = new Direction(new Vector2(75, 80), "Jara", 321, 0, "0");
        Client client1 = new Client("client1", "asd123", "client1@hotmail.com", "Benitez", "Martin", dir1, 123234);
        userController.addNewUser(client1);
        Client client2 = new Client("client2", "asd123", "client2@hotmail.com", "Perez", "Pablo", dir2, 1553234);
        userController.addNewUser(client2);
        Client client3 = new Client("client3", "asd123", "client3@hotmail.com", "Campaña", "Martin", dir3, 863234);
        userController.addNewUser(client3);

        Direction dir4 = new Direction(new Vector2(1, 6), "Alem", 123, 0, "0");
        Direction dir5 = new Direction(new Vector2(25, 10), "Cordoba", 123, 0, "0");
        Direction dir6 = new Direction(new Vector2(39, 63), "Jara", 321, 0, "0");


        ArrayList<Product> productosBawm = new ArrayList();
        Product product1 = new Product("Hamburguesa Americana", "Hamburguesa con panceta y cheddar", 5, 250);
        Product product2 = new Product("Pinta", "Cerveza rubia", 1225, 110);
        Product product3 = new Product("Papas Bravas", "Papas picantes", 9999, 190);
        productosBawm.add(product1);
        productosBawm.add(product2);
        productosBawm.add(product3);
        ArrayList<Product> productosMac = new ArrayList();
        Product product4 = new Product("Big Mac", "Hamburguesa clasica", 5, 250);
        Product product5 = new Product("Nuggets", "Nuggets de pollo", 121, 110);
        Product product6 = new Product("Ensalada", "Caesar", 9999, 190);
        productosMac.add(product4);
        productosMac.add(product5);
        productosMac.add(product6);
        ArrayList<Product> productosCheverry = new ArrayList();
        Product product7 = new Product("Pinta", "Cerveza clasica", 125, 250);
        Product product8 = new Product("Bondiola", "Bondiola a la cerveza negra", 121, 110);
        Product product9 = new Product("Ensalada", "Campestre", 9999, 190);
        productosCheverry.add(product7);
        productosCheverry.add(product8);
        productosCheverry.add(product9);
        Market market1 = new Market("market1", "market1", "macdonalds@yahoo.com", dir4, "McDonalds", productosMac);
        userController.addNewUser((market1));
        Market market2 = new Market("market2", "market2", "baum@yahoo.com", dir5, "Baum", productosBawm);
        userController.addNewUser((market2));
        Market market3 = new Market("market3", "market3", "Cheverry@yahoo.com", dir6, "Cheverry", productosCheverry);
        userController.addNewUser((market3));


        Dealer delivery1 = new Dealer(orderController, "Martincho1992", "asd123", "de1@hotmail.com", "Benitez", "Martin", dir1
                , 123234, new ArrayList<Order>(), new Vector2(), false);
        userController.addNewUser(delivery1);
        Dealer delivery2 = new Dealer(orderController, "JuanCa223", "asd123", "de1@hotmail.com", "Vermot", "JuanCarlos", dir2
                , 123234, new ArrayList<Order>(), new Vector2(), false);
        userController.addNewUser(delivery2);

        Order order1 = new Order(productosBawm, 0, market2, client1, new Date());
        Order order2 = new Order(productosMac, 0, market1, client2, new Date());
        orderController.addOrder(order1);
        orderController.addOrder(order2);

        orderController.showOrders();
    }

    private static int ShowOptions() {
        clearScreen();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\nBienvenide!");
        System.out.println("Seleccione una opcion");
        System.out.println("1 - Login");
        System.out.println("2 - Registrar cliente");
        System.out.println("3 - Registrar  delivery");
        System.out.println("4 - Registrar  negocio");
        System.out.println("5 - Salir ");
        System.out.println("\nIngrese seleccion : ");
        int result = scan.nextInt();
        return result;
    }


    private static int optionSelection(int pValue) throws Exception {
        switch (pValue) {
            case 1:
                loginUi();
                break;
            case 2:
                userController.createClient();
                break;
            case 3:
                userController.createDealer();
                break;
            case 4:
                userController.createMarket();
                break;
            case 5:
                System.out.println("\n\nSaliendo del sistema..... Que tenga un buen dia");
                return 1;

            default:
                System.out.println("Dato ingresado no valido");
                ShowOptions();
                break;
        }
        return 0;
    }

    public static void clearScreen() { //Not working
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    static void loginUi() throws Exception {
        clearScreen();
        Scanner scan = new Scanner(System.in);

        String user;
        String pass;

        System.out.println("Usuario:");

        user = scan.nextLine();

        System.out.println("Contraseña:");

        pass = scan.nextLine();

        User u = userController.loguin(user, pass);

        if (u == null) {
            System.out.println("Nombre de usuario o contraseña incorrecto");
            loginUi();
        } else {
            if (u instanceof Client)
                showMenuClient((Client) u); //Comienzo a llevarme el cliente como parametro
            else if (u instanceof Dealer)
                showMenuDelivery((Dealer) u);
            else if (u instanceof Market)
                showMenuMarket((Market) u);
        }
    }

    static void showMenuDelivery(Dealer delivery) throws Exception {
        boolean back = false;
        while (back == false) {
            System.out.println("\nDelivery Menu : ");
            delivery.setAvailable(true); //Habilito el delivery
            System.out.println("Ingrese una nueva opcion:");
            System.out.println("1 - Solicitar cliente");
            System.out.println("2 - Entregar pedido");
            System.out.println("3 - Ver pedidos pendientes");
            System.out.println("4 - Ver mis datos");
            System.out.println("5 - Modificar datos");
            System.out.println("9 - Back to login page");
            System.out.println("\nIngrese seleccion : ");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if (select == 9) {
                back = true;
            }
            deliveryOptionSelection(select, delivery);
        }

    }

    private static void deliveryOptionSelection(int pValue, Dealer delivery) throws Exception {
        switch (pValue) {
            case 1:
                delivery.asignOrder(orderController, delivery); // le asigno un delivery a la orden
                break;
            case 2:
                delivery.deliverOrder(); //Elimina del delivery y del orderController la orden, la entrega al cliente
                break;
            case 3:
                delivery.showOrdersName(); //Muestra las ordenes dentro del delivery, corespondientes al mismo, trabajos tomados
                break;
            case 4:
                System.out.println("Mis datos : ");
                System.out.println(delivery.toString());
                break;
            case 5:
                 delivery.editClient();
                break;
            default:
                break;
        }
    }

    static void showMenuClient(Client client) throws Exception {
        clearScreen();
        boolean back = false;
        while (back != true) {
            System.out.println("\nCliente Menu : ");
            System.out.println("Ingrese una nueva opcion:");
            System.out.println("1 - Realizar nuevo pedido");
            System.out.println("2 - Listar pedidos realizados");
            System.out.println("3 - Modificar mis datos");
            System.out.println("4 - Ver mis datos");
            System.out.println("9 - Login page");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            if (select == 9) {
                back = true;
            }
            clientOptionSelection(select, client);
        }
    }

    private static void clientOptionSelection(int pValue, Client client) throws Exception {
        switch (pValue) {
            case 1:
                orderController.createOrder(client);
                break;
            case 2:
                orderController.showOrders();
                break;
            case 3:
                client.editClient();
                break;
            case 4:
                System.out.println("Mis datos : ");
                System.out.println(client.toString());
                break;
            default:
                break;

        }
    }

    static void showMenuMarket(Market m) {
        clearScreen();
        boolean back = false;
        while (!back) {
            System.out.println("Market menu : ");
            System.out.println("1 - Cargar nuevo producto");
            System.out.println("2 - Modificar stock");
            System.out.println("3 - Ver productos");
            System.out.println("4 - Ver mis datos");
            System.out.println("5 - Modificar mis datos");
            System.out.println("9 - Volver al login");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese seleccion : ");
            int resp = scanner.nextInt();
            if (resp == 9) {
                back = true;
            }
            marketOptionSelection(resp, m);

        }

    }

    private static void marketOptionSelection(int pValue, Market market) {
        switch (pValue) {
            case 1:
                market.addNewProduct();
                break;
            case 2:
                market.stockHandler();
                break;
            case 3:
                market.showProducts();
                break;
            case 4:
                System.out.println(market.toString());
                break;
            case 5:
                market.editMarket();
                break;
            default:
                break;

        }
    }
}
