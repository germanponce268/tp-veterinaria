package Servicios;

import jakarta.persistence.criteria.CriteriaBuilder;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class UIService {

    private Scanner consola;
    private MascotaService mascotaService;
    private TurnoService turnoService;

    public UIService(){
        this.consola = new Scanner(System.in);
        this.mascotaService = new MascotaService();
        this.turnoService = new TurnoService();
    }

    public void menuTurnos(){
        System.out.println("------------------------MENU--------------------------");
        System.out.println("1 - AGREGAR TURNO ");
        System.out.println("2 - MODIFICAR TURNO");
        System.out.println("3 - VER TURNO");
        System.out.println("4 - VER TODOS LOS TURNOS");
        System.out.println("4 - ELIMINAR TURNO");
        System.out.println("Ingresa un numero del 1 al 4");
        int seleccion = this.consola.nextInt();
        switch (seleccion){
            case 1:
                this.turnoService.agregarTurno();
                break;
            case 2:
                this.turnoService.modificarTurno();
                break;
            case 3:
                this.turnoService.obtenerTurno();
                break;
            case 4:
                this.turnoService.obtenerTurnos();
                break;
            case 5:
                this.turnoService.eliminarTurno();
            default:
                System.out.println("Numero incorrecto.");
                break;
        }
    }

    public void menuMascota(){
        System.out.println("------------------------MENU--------------------------");
        System.out.println("1 - AGREGAR MASCOTA");
        System.out.println("2 - MODIFICAR MASCOTA");
        System.out.println("3 - VER MASCOTA");
        System.out.println("4 - VER TODAS LAS MASCOTAS");
        System.out.println("5 - ELIMINAR MASCOTA");
        System.out.println("6 - MASCOTA MAS AFIEBRADA");
        System.out.println("Ingresa un numero del 1 al 5");
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
                this.mascotaService.obtenerMascotas();
                break;
            case 5:
                this.mascotaService.eliminarMascota();
                break;
            case 6:
                this.mascotaService.obtenerMascotaMasAfiebrada();
                break;
            default:
                System.out.println("Numero incorrecto.");
                break;
        }
    }
}
