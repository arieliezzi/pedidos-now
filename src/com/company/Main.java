package com.company;
import java.util.Scanner;

public class Main {

    private static UserController userController;
    private static OrderController orderController;

    public static void main(String[] args) {

        userController = new UserController();
        orderController = new OrderController(userController);
        init();
    }

    private static void init()
    {
        Direction dir1 = new Direction(new Vector2(1,1),"Alem",123,0,'0');
        Direction dir2 = new Direction(new Vector2(15,20),"Cordoba",123,0,'0');
        Direction dir3 = new Direction(new Vector2(75,80),"Jara",321,0,'0');

        Client client1 = new Client("client1","asd123","client1@hotmail.com","Benitez","Martin",dir1,123234);
        userController.addNewUser(client1);
        Client client2 = new Client("client2","asd123","client2@hotmail.com","Perez","Pablo",dir2,1553234);
        userController.addNewUser(client2);
        Client client3 = new Client("client3","asd123","client3@hotmail.com","Campaña","Martin",dir3,863234);
        userController.addNewUser(client3);

        Direction dir4 = new Direction(new Vector2(1,6),"Alem",123,0,'0');
        Direction dir5 = new Direction(new Vector2(25,10),"Cordoba",123,0,'0');
        Direction dir6 = new Direction(new Vector2(39,63),"Jara",321,0,'0');

        Market market1 = new Market("market1","market1","macdonalds@yahoo.com",dir4,"McDonalds");
        Market market2 = new Market("market2","market2","baum@yahoo.com",dir5,"Baum");
        Market market3 = new Market("market3","market3","Cheverry@yahoo.com",dir6,"Cheverry");

        ShowOptions();
    }

    private static void ShowOptions()
    {
        clearScreen();
        Scanner scan = new Scanner (System.in);

        System.out.println("Bienvenide!");
        System.out.println("Seleccione una opcion");
        System.out.println("1 - Login");
        System.out.println("2 - Crear nuevo cliente");
        System.out.println("3 - Crear nuevo delivery");
        System.out.println("4 - Crear nuevo negocio");

        int result = scan.nextInt();

        optionSelection(result);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void optionSelection(int pValue)
    {
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
            default:
                System.out.println("Dato ingresado no valido");
                ShowOptions();
                break;
        }
    }


    static void loginUi() {
        Scanner scan = new Scanner(System.in);

        String user;
        String pass;

        System.out.println("Usuario:");

        user = scan.nextLine();

        System.out.println("Contraseña:");

        pass = scan.nextLine();

        User u = userController.loguin(user,pass);

        if(u == null) {
            System.out.println("Nombre de usuario o contraseña incorrecto");
            loginUi();
        }
        else {
            if (u instanceof Client)
                showMenuClient();
            else if (u instanceof Dealer)
                showMenuDealer();
            else if (u instanceof Market)
                showMenuMarket();
        }
    }


    static void showMenuClient()
    {
        System.out.println("");
        System.out.println("Ingrese una nueva opcion:");
        System.out.println("1 - Realizar nuevo pedido");
        System.out.println("2 - Listar pedidos realizados");
    }


    private static void clientOptionSelection(int pValue)
    {
        switch (pValue) {
            case 1:
                break;
            case 2:
                break;
            default:
                break;

        }
    }

    static void showMenuDealer()
    {

    }

    static void showMenuMarket()
    {
        System.out.println("");
        System.out.println("Ingrese una nueva opcion:");
        System.out.println("1 - Cargar nuevo producto");
        System.out.println("1 - Modificar stock");
    }
}
