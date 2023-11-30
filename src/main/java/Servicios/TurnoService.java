package Servicios;

import DAO.TurnoDAO;
import Entidades.Turno;
import Repositorios.TurnoRepository;
import jdk.swing.interop.SwingInterOpUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TurnoService {
    private Scanner consola;
    private TurnoDAO turnoDAO;
    private SimpleDateFormat simpleDateFormat;
    TurnoService(){
        this.consola = new Scanner(System.in);
        this.turnoDAO = new TurnoRepository();
        this.simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    }
    public void agregarTurno(){
        Turno turno = new Turno();
        System.out.println("Ingrese la fecha del turno en formato dd/MM/yyyy");
        String fechaIngresada = this.consola.nextLine();
        try {
            Date fecha = simpleDateFormat.parse(fechaIngresada);
            turno.setFecha(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ingrese el nombre del medico");
        String medico = consola.nextLine();
        turno.setMedico(medico);
        turnoDAO.insertarTurno(turno);
        System.out.println("Se Guardo el turno para el dia " + turno.getFecha());

    }

    public void modificarTurno() {
        Turno turno = new Turno();
        System.out.println("Ingrese el id del turno a modificar");
        Integer id = this.consola.nextInt();
        System.out.println("Ingrese la nueva fecha del turno");
        String fecha = this.consola.nextLine();
        try {
            Date nuevaFecha = this.simpleDateFormat.parse(fecha);
            turno.setFecha(nuevaFecha);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ingrese el nombre del medico");
        String medico = this.consola.nextLine();
        turno.setId(id);
        turno.setMedico(medico);
        this.turnoDAO.actualizarTurno(turno);
    }


    public void obtenerTurno() {
        System.out.println("Ingrese el id del turno que desea ver");
        Integer id = this.consola.nextInt();
        Turno turno = this.turnoDAO.obtenerTurno(id);
        System.out.println("Tiene turno el dia " + turno.getFecha() + " con el profecional: " + turno.getMedico());
    }

    public void eliminarTurno() {
        System.out.println("Ingrese el id del numero que desea borrar");
        Integer id = this.consola.nextInt();
        this.turnoDAO.eliminarTurno(id);
        System.out.println("Se elimino el turno");
    }
}
