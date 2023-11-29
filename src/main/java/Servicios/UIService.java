package Servicios;

import java.util.Scanner;

public class UIService {

    private Scanner consola;
    private MascotaService mascotaService;

    public UIService(){
        this.consola = new Scanner(System.in);
        this.mascotaService = new MascotaService();
    }

    public void menuTurnos(){
        System.out.println("------------------------MENU--------------------------");
        System.out.println("1 - AGREGAR ");
        System.out.println("2 - MODIFICAR ");
        System.out.println("3 - VER");
        System.out.println("4 - ELIMINAR ");
        System.out.println("Ingresa un numero del 1 al 4");
        int seleccion = this.consola.nextInt();
        switch (seleccion){
            case 1:
                this.mascotaService.agregarMascota();
                break;
            case 2:
                this.mascotaService.modificarMascota();
                break;
            case 3:
                this.mascotaService.obtenerMascota();
                break;
            case 4:
                this.mascotaService.eliminarMascota();
                break;
            default:
                System.out.println("Numero incorrecto.");
                break;
        }
    }

    public void menuMascota(){
        System.out.println("------------------------MENU--------------------------");
        System.out.println("1 - AGREGAR ");
        System.out.println("2 - MODIFICAR ");
        System.out.println("3 - VER");
        System.out.println("4 - ELIMINAR ");
        System.out.println("Ingresa un numero del 1 al 4");
        int seleccion = this.consola.nextInt();
        switch (seleccion){
            case 1:
                this.mascotaService.agregarMascota();
                break;
            case 2:
                this.mascotaService.modificarMascota();
                break;
            case 3:
                this.mascotaService.obtenerMascota();
                break;
            case 4:
                this.mascotaService.eliminarMascota();
                break;
            default:
                System.out.println("Numero incorrecto.");
                break;
        }
    }
}
