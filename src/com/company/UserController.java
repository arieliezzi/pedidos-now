package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserController {


    private ArrayList usersList;

    public UserController() {
        this.usersList = new ArrayList();
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


        String depto = scan.nextLine();

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
        String depto = scan.nextLine();

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

        clearScreen();
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
        String depto = scan.nextLine();

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
        clearScreen();
        User user = null;

        boolean exist = false;

        for (int i = 0; i < usersList.size(); i++) {
            User newUser = (User) usersList.get(i);
            if (newUser.getUserName().equals(pUserName)) {
                if (newUser.getPass().equals(pPass)) {
                    user = newUser;
                }
            }
        }
        return user;
    }


    public ArrayList<User> getUsersList() {
        return usersList;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
