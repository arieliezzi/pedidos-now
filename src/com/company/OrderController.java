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
        List<Market> marketsList = new ArrayList<Market>();

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
        if (marketsNear != null) {
            for (Market m : marketsNear) {
                int index = marketsNear.indexOf(m);
                System.out.println("\nMarket N° : " + index);
                System.out.println(m.toString());
                System.out.println(m.getProducts().toString());
            }
        }
    }


    //Recordatorio la idea es una funcion que devuelva el market elegido por el usuario para dsps hacer una funcion que seleccione
    //lo que va a pedir tipo carrito de compra

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

    public int createOrder(Client pCliente, Market market) {
        List<Market> marketsNear = this.getMarketsClose(pCliente);
        Market selectedMarket = this.marketSelector(pCliente); //Aqui se muestran los mercados y se da a seleccionar uno, retorno el usuario
        for (Market m : marketsNear) { //Recorro el arreglo de markets para coincidir con el elegido
            if (m.getUserName() == selectedMarket.getUserName()) {
                m.showProducts(); //Mostramos los productos
            }
        }

        ArrayList<Product> shopCart = new ArrayList<>(); //Creando el carrito de compras
        Scanner scanner = new Scanner(System.in);
        int articulo = -1;
        while (articulo != 9) {
            System.out.println("\n\nSeleccione articulo : ");
            articulo = scanner.nextInt(); //Almaceno el index del articulo a agregar
            Product newProduct = selectedMarket.getProducts().get(articulo); //Guardo el producto
            shopCart.add(newProduct); //Agrego el producto al carrito
        }
        Vector2 vector = new Vector2(); //Creo el vector q solicita la orden de compra
        Date date = new Date(); //creo la fecha actual
        Dealer position = new Dealer(pCliente.getUserName(), pCliente.getPass(), pCliente.getEmail(), pCliente.getLastName(), pCliente.getName()
                , pCliente.getDirection(), pCliente.getTel(), vector, true); //Creo el dealer
        Order newOrder = new Order(shopCart, 0, selectedMarket, position, pCliente, date); //Creo la orden con los datos recopilados anteriormente
        System.out.println("\n\nOrden registrada : \n" + newOrder.toString());
        System.out.println("\n\nConfirmar pedido : ");
        Scanner scanner3 = new Scanner(System.in);
        String resp = scanner3.nextLine();
        if (resp.equals("s")) {
            this.addOrder(newOrder); //agrego la orden a la cola de ordenes
            System.out.println("\n\nPedido registrado exitosamente !!");
            return 1;
        } else {
            System.out.println("\n\nPedido cancelado !!");
            return 0;
        }
    }

    public void addOrder(Order order) {
        if (order != null) {
            this.getOrdersList().add(order);
        }

    }


}
