package Main;

import Servicios.UIService;

import java.sql.SQLOutput;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        UIService uiService = new UIService();
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese un numero del 1 al 3");
        System.out.println("1 - Turnos");
        System.out.println("2 - Mascotas");
        System.out.println("3 - Salir");
        Integer opcion = consola.nextInt();

        switch (opcion){
            case 1:
                uiService.menuTurnos();
                break;
            case 2:
                uiService.menuMascota();
                break;
            case 3:
                break;
            default:
                System.out.println("Ingresa un numero valido");
                break;
        }
    }
}
