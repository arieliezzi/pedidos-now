package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Client extends Person {

    private ArrayList<Direction> frequentsDirections;


    public Client(String userName, String pass, String email, String lastName, String name, Direction direction, int tel, ArrayList<Order> orders, ArrayList<Direction> frequentsDirections) {
        super(userName, pass, email, lastName, name, direction, tel, orders);
        this.setFrequentsDirections(frequentsDirections);
    }

    public Client(String userName, String pass, String email, String lastName, String name, Direction direction, int tel) {
        super(userName, pass, email, lastName, name, direction, tel);
        this.frequentsDirections = new ArrayList<Direction>();
    }

    public ArrayList<Direction> getFrequentsDirections() {
        return frequentsDirections;
    }

    public void setFrequentsDirections(ArrayList<Direction> frequentsDirections) {
        this.frequentsDirections = frequentsDirections;
    }

    public void addNewFrequentDirection(Direction pDirection) {
        frequentsDirections.add(pDirection);
    }

    public void editClient() throws Exception {
        Scanner scan = new Scanner(System.in);


        System.out.println("Edicion del cliente : ");


        System.out.println("Que campo va a modificar?");
        System.out.println("1 - Nombre");
        System.out.println("2 - Apellido");
        System.out.println("3 - Telefono");
        System.out.println("4 - Direccion");
        System.out.println("5 - Pedido");

        System.out.println("\n\n Ingrese seleccion : ");
        int res = scan.nextInt();

        switch (res) {
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                super.setName(scan.nextLine());
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                super.setLastName(scan.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el nuevo telefono : ");
                super.setTel(scan.nextInt());
                break;
            case 4:
                System.out.println("Edicion de direccion : ");
                super.getDirection().editDirection();
                break;
            case 5:
                System.out.println("Edicion de pedidos: ");

                Order selectedOrder = super.getSpecificOrder(); //Esto me permite capturar la orden
                int index = super.getOrders().indexOf(selectedOrder); //Capturo el index de esa orden
                super.getOrders().get(index).editOrder(); // edito la orden
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }


    }
}
