package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderController {

    UserController userController;
    List<Order> ordersList;

    final float MIN_DISTANCE_BETWEEN_MARKET = 30.0f;

    public OrderController(UserController userController) {
        this.userController = userController;
        ordersList = new ArrayList<Order>();
    }

    public UserController getUserController() {
        return userController;
    }

    public List<Order> getOrdersList() {
        return ordersList;
    }

    public List<Market> getMarketsClose(Client pCliente) {
        List<Market> marketsList = new ArrayList();

        for (User u : userController.getUsersList()) {
            if (u instanceof Market) {
                if (((Market) u).getDirectionMarket().getCoords().Distance(pCliente.getDirection().getCoords()) < MIN_DISTANCE_BETWEEN_MARKET) {
                    marketsList.add((Market) u);

                }
            }
        }
        return marketsList;
    }

    public void showMarketsNear(Client pCliente) {
        List<Market> marketsNear = this.getMarketsClose(pCliente);
        System.out.println("\nListing Markets Near : ");
        if (marketsNear != null) {
            System.out.println("\nNULL PASEDD!");
            for (int i = 0; i < marketsNear.size(); i++) {

                System.out.println("\nMarket N° : " + i);
                System.out.println(marketsNear.get(i).toString());
            }
        } else System.out.println("\nNo markets near");
    }


    public Market marketSelector(Client pCliente) {//Selecciona un market y lo retorna
        List<Market> marketsNear = this.getMarketsClose(pCliente); //Traigo el Array de markets
        int selection; //creo variable para guardar el indice del market seleccionado
        showMarketsNear(pCliente); // Muestro los Markets
        System.out.println("\n\nChoose market number: ");
        Scanner scanner = new Scanner(System.in); //Guardo seleccion
        selection = scanner.nextInt();
        Market selectedMarket = marketsNear.get(selection); // Guardo el market para retornarlo
        return selectedMarket;
    }

    public int createOrder(Client pCliente) {
        Market selectedMarket = this.marketSelector(pCliente); //Aqui se muestran los mercados y se da a seleccionar uno, retorno el usuario
        System.out.println("\nBuscando productos.....\n");
        selectedMarket.showProducts();
        int articulo = -1;
        System.out.println("\n9. Terminar pedido  ----------------->");

        ArrayList<Product> shopCart = new ArrayList<>(); //Creando el carrito de compras
        Scanner scanner = new Scanner(System.in);


        while (articulo != 9) {

            System.out.println("\n\nSeleccione nuevo articulo : ");
            articulo = scanner.nextInt(); //Almaceno el index del articulo a agregar
            if (articulo != 9) {
                Product newProduct = selectedMarket.getProducts().get(articulo); //Guardo el producto
                if (newProduct != null) {
                    shopCart.add(newProduct); //Agrego el producto al carrito
                    System.out.println("Articulo agregado al carrito! ");
                    selectedMarket.getProducts().get(articulo).setStock(selectedMarket.getProducts().get(articulo).getStock() - 1); //Actualiza el stock
                    System.out.println("Stock Actualizado...");
                } else System.out.println("\nArticulo invalido, reingrese valores");
            } else {
                System.out.println("\nOrden completada : ");

            }
        }

        Vector2 vector = new Vector2(); //Creo el vector q solicita la orden de compra

        Date date = new Date(); //creo la fecha actual

        Order newOrder = new Order(shopCart, 0, selectedMarket, pCliente, date); //Creo la orden con los datos recopilados anteriormente
        if (newOrder != null) {
            System.out.println("\nOrden registrada reconfirmacion : \n");
            newOrder.showFullOrder();

            System.out.println("\n\nConfirmar pedido s/n: ");
            Scanner scanner3 = new Scanner(System.in);
            String resp = scanner3.nextLine();

            if (resp.equals("s")) {
                this.addOrder(newOrder); //agrego la orden a la cola de ordenes

                System.out.println("\n\nPedido registrado exitosamente !! El delivery ya esta en camino!\nRegresando al menu principal....");
                return 1;
            } else {
                System.out.println("\n\nPedido cancelado !!");
                return 0;
            }
        } else System.out.println("Pedido vacio, intente nuevamente!");
        return 1;
    }


    public void addOrder(Order order) {
        if (order != null) {
            this.getOrdersList().add(order);

        }

    }

    public void showOrders() {
        int i = 1;
        System.out.println("\nListado de ordenes : ");
        for (Order o : this.getOrdersList()) {
            System.out.println("Orden nro : " + i);
            o.showFullOrder();
            i++;
        }

    }
}