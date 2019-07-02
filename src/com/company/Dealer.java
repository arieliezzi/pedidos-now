package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealer extends Person {

    private Vector2 actualCoords;
    private boolean available;
    private OrderController orderController;

    public Dealer(OrderController order, String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, ArrayList<Order> orders, Vector2 actualCoords, boolean available) {
        super(userName, pass, email, lastName, name, direction, telphone, orders);
        this.setActualCoords(actualCoords);
        this.setAvailable(available);
        this.orderController = order;
    }

    public Dealer(String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, Vector2 actualCoords, boolean available) {
        super(userName, pass, email, lastName, name, direction, telphone);
        this.setActualCoords(actualCoords);
        this.setAvailable(available);
    }

    public Vector2 getActualCoords() {
        return actualCoords;
    }

    public void setActualCoords(Vector2 actualCoords) {
        this.actualCoords = actualCoords;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void asignOrder(OrderController orderController, Dealer dealer) { //retorna el index en el array original de ese pedido

        orderController.showOrders(); //muestro todas las ordenes

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese orden a tomar : ");
        int select = scanner.nextInt();

        Order selectedOrder = orderController.getOrdersList().get(select); //capturo la orden
        if (selectedOrder.getState() != true) { //Si no fue tomada por otro delivery

            this.getOrders().add(selectedOrder); //AGREGA A LA LISTA DE ORDERS DEL DELIVERY

            int index = -1; //para almacenar el index del array original, correspondiente a la orden que tomamos
            for (Order o : orderController.getOrdersList()) {
                if (o.equals(selectedOrder)) {
                    index = orderController.getOrdersList().indexOf(o); //guardo el index para luego poder cambiar su estado
                }
            }
            if (index != -1) {

                orderController.getOrdersList().get(index).setState(true); //cambio el estado de la orden a true para saber que alguien la tomo
                orderController.getOrdersList().get(index).setDealer(dealer); //asigno el dealer a esa orden
                System.out.println("ORDEN TOMADA , A REPARTIR!");
                System.out.println("Order data! : ");
                selectedOrder.showFullOrder();

            }
        } else System.out.println("Error! Orden ya tomada");
    }

    public void deliverOrder() {
        System.out.println("Pedidos pendientes : ");
        super.showOrdersName(); //Muestro las ordenes correspondientes al delivery
        System.out.println("\nIngrese orden a entregar : ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt(); //Me guardo el index de la orden a entregar
        Order toDelete = this.getOrders().get(index); //Guardo la orden ya entregada para luego usarla y borrar la oden de orderController

        this.getOrders().remove(index); //elimino del array del delivery el pedido entregado
        orderController.getOrdersList().remove(toDelete); //Borro la orden entregada de orderController
        orderController.getOrdersList().get(index).getMarket().stockHandler(toDelete); //Actualiza el stock / descuenta todo lo de la orden entregada
        System.out.println("\n\nOrden entregada exitosamente! Keep up the good work!");

    }
}
