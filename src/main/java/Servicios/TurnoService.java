package Servicios;

import DAO.TurnoDAO;
import Repositorios.TurnoRepository;

import java.util.Scanner;

public class TurnoService {
    private Scanner consola;
    private TurnoDAO turnoDAO;

    TurnoService(){
        this.consola = new Scanner(System.in);
        this.turnoDAO = new TurnoRepository();
    }
    public void agregarTurno(){
        System.out.println("Ingrese 1 para obtener un turno");
        Integer valor = this.consola.nextInt();
        if(valor==1){
            this.turnoDAO.insertarTurno();
        }

    }
}
