package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {


    private ArrayList<User> usersList;

    public UserController() {
        this.usersList = new ArrayList<User>();
    }


    public void addNewUser(User pValue) {
        this.usersList.add(pValue);
    }

    public void createClient() {
        Scanner scan = new Scanner(System.in);

        String user;
        String pass;
        String mail;
        String nombre;
        String apellido;


        System.out.println("Creando nuevo cliente");
        System.out.println("Nombre de usuario:");
        user = scan.nextLine();

        System.out.println("Contraseña:");
        pass = scan.nextLine();

        System.out.println("Mail:");
        mail = scan.nextLine();

        System.out.println("Nombre:");
        nombre = scan.nextLine();

        System.out.println("Apellido:");
        apellido = scan.nextLine();


        System.out.println("Calle:");
        String calle = scan.nextLine();

        System.out.println("Altura:");
        int altura = scan.nextInt();

        System.out.println("Piso (0 si no posee):");
        int piso = scan.nextInt();
        System.out.println("Departamento (0 si no posee):");


        char depto = scan.nextLine().toCharArray()[0];

        Direction direccion = new Direction(new Vector2(1, altura), calle, altura, piso, depto);

        System.out.println("Telefono:");
        int telefono = scan.nextInt();

        Client cliente = new Client(user, pass, mail, apellido, nombre, direccion, telefono);

        addNewUser(cliente);
    }


    public void createMarket() {
        Scanner scan = new Scanner(System.in);

        String user;
        String pass;
        String mail;
        String nombre;

        System.out.println("Creando nuevo cliente");
        System.out.println("Nombre de usuario:");
        user = scan.nextLine();

        System.out.println("Contraseña:");
        pass = scan.nextLine();

        System.out.println("Mail:");
        mail = scan.nextLine();

        System.out.println("Nombre:");
        nombre = scan.nextLine();

        System.out.println("Calle:");
        String calle = scan.nextLine();

        System.out.println("Altura:");
        int altura = scan.nextInt();

        System.out.println("Piso (0 si no posee):");
        int piso = scan.nextInt();
        System.out.println("Departamento (0 si no posee):");
        char depto = scan.nextLine().toCharArray()[0];

        Direction direccion = new Direction(new Vector2(1, altura), calle, altura, piso, depto);


        Market market = new Market(user, pass, mail, direccion, nombre);

        addNewUser(market);
    }


    public void createDealer() {
        Scanner scan = new Scanner(System.in);

        String user;
        String pass;
        String mail;
        String nombre;
        String apellido;


        System.out.println("Creando nuevo cliente");
        System.out.println("Nombre de usuario:");
        user = scan.nextLine();

        System.out.println("Contraseña:");
        pass = scan.nextLine();

        System.out.println("Mail:");
        mail = scan.nextLine();

        System.out.println("Nombre:");
        nombre = scan.nextLine();

        System.out.println("Apellido:");
        apellido = scan.nextLine();

        System.out.println("Calle:");
        String calle = scan.nextLine();

        System.out.println("Altura:");
        int altura = scan.nextInt();

        System.out.println("Piso (0 si no posee):");
        int piso = scan.nextInt();
        System.out.println("Departamento (0 si no posee):");
        char depto = scan.nextLine().toCharArray()[0];

        Direction direccion = new Direction(new Vector2(1, altura), calle, altura, piso, depto);

        System.out.println("Telefono:");
        int telefono = scan.nextInt();

        Dealer dealer = new Dealer(user, pass, mail, nombre, apellido, direccion, telefono, new Vector2(2, altura), true);

        addNewUser(dealer);
    }

    public void deleteUser(User pUser) {
        if (usersList.contains(pUser))
            usersList.remove(pUser);
    }

    public User loguin(String pUserName, String pPass) {
        //ACA HAY QUE USAR TRY CATCH PARA LOS TIPOS DE ERRORES (SI ENCUENTRA USER
        //SI NO COINCIDE EL PASS

        User user = null;

        boolean exist = false;

        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getUserName().equals(pUserName)) {
                if (usersList.get(i).getPass().equals(pPass)) {
                    exist = true;
                    user = usersList.get(i);
                }
            }
        }
        return user;
    }


    public ArrayList<User> getUsersList() {
        return usersList;
    }
}
