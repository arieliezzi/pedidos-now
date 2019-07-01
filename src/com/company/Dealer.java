package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealer extends Person {

    private Vector2 actualCoords;
    private boolean available;
    private OrderController orderController;

    public Dealer(OrderController order,String userName, String pass, String email, String lastName, String name, Direction direction, int telphone, ArrayList<Order> orders, Vector2 actualCoords, boolean available) {
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

    public void asignOrder(OrderController orderController){
        ArrayList<Order> ordenesValidas = new ArrayList();
        for (int i=0; i<orderController.getOrdersList().size(); i++){ //recorre el array
            if (orderController.getOrdersList().get(i).getState()){ //Compara los estados
                Order newValidOrder = orderController.getOrdersList().get(i); //crea nueva orden si el estado es true
                ordenesValidas.add(newValidOrder); //Agrega a validas
            }
        }
        int i=0;
        for (Order o: ordenesValidas){
            System.out.println("\nOrdenes disponibles : ");
            System.out.println("Orden nro: "+i);
            o.showFullOrder();
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese orden a tomar : ");
        int select = scanner.nextInt();

        Order selectedOrder = ordenesValidas.get(select);
        this.getOrders().add(selectedOrder); //AGREGA A LA LISTA DE ORDERS DEL DELIVERY
        int index=-1 ; //para almacenar el index del array original, correspondiente a la orden que tomamos
        for (Order o: orderController.getOrdersList()){
            if (o.equals(selectedOrder)){
                index = orderController.getOrdersList().indexOf(o); //guardo el index para luego poder cambiar su estado
            }
        }
        if (index!=-1){
            orderController.getOrdersList().get(index).setState(true); //cambio el estado de la orden a true para saber que alguien la tomo
        }
    }

}
