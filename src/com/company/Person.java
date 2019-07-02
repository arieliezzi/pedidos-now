package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Person extends User {

    private String lastName;
    private String name;
    private Direction direction;
    private int tel; //cambie el nombre porq tiraba warning
    private ArrayList<Order> orders;

public String toString(){
    return "Name : "+this.getName()+"\nLast Name : "+this.getLastName()+"\nTel : "+this.getTel()+"\nDireccion : "+this.getDirection().toString();
}
    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int tel, ArrayList<Order> orders) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTel(tel);
        this.setOrders(orders);
    }

    public Person(String userName, String pass, String email, String lastName, String name, Direction direction, int tel) {
        super(userName, pass, email);
        this.setLastName(lastName);
        this.setName(name);
        this.setDirection(direction);
        this.setTel(tel);

        orders = new ArrayList<Order>();
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void showOrdersName() { //creo para listar a la hora de editar o buscar
        if (this.getOrders() != null) {
            for (int i = 0; i < this.getOrders().size(); i++) {
                System.out.println("Order nro : " + i);
                System.out.println("\n\n" + i + " " + this.getOrders().get(i).getMarket().getName()); //Solo muestro el nombre para seleccionar
                System.out.println("Direccion a entregar : " + this.getOrders().get(i).getClient().getDirection().
                        getStreet() + " " + this.getOrders().get(i).getClient().getDirection().getNumber());
            }
        } else System.out.println("\nNo hay ordenes para mostrar, intente mas tarde");

    }

    public Order getSpecificOrder() { //Permite seleccionar el market y retorna la orden
        System.out.println("\nChoose a Market : ");
        this.showOrdersName();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese seleccion : ");
        int resp = scanner.nextInt();
        return this.getOrders().get(resp);
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
        Scanner scanner2 = new Scanner(System.in);
        switch (res) {
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                this.setName(scanner2.nextLine());
                System.out.println("Datos modificados exitosamente");
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                this.setLastName(scanner2.nextLine());
                System.out.println("Datos modificados exitosamente");
                break;
            case 3:
                System.out.println("Ingrese el nuevo telefono : ");
                this.setTel(scanner2.nextInt());
                System.out.println("Datos modificados exitosamente");
                break;
            case 4:
                System.out.println("Edicion de direccion : ");
               this.getDirection().editDirection();
                System.out.println("Datos modificados exitosamente");
                break;
            case 5:
                System.out.println("Edicion de pedidos: ");

                Order selectedOrder = this.getSpecificOrder(); //Esto me permite capturar la orden
                int index = this.getOrders().indexOf(selectedOrder); //Capturo el index de esa orden
                this.getOrders().get(index).editOrder(); // edito la orden
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
        }


    }
}