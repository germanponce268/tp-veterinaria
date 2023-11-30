package Repositorios;

import Controladores.TurnoControlador;
import DAO.TurnoDAO;
import Entidades.Turno;

import java.util.List;

public class TurnoRepository implements TurnoDAO {

    TurnoControlador turnoControlador;
    public TurnoRepository(){
        this.turnoControlador = new TurnoControlador();
    }
    @Override
    public void insertarTurno(Turno turno) {
        this.turnoControlador.agregarTurno(turno);
    }

    @Override
    public Turno obtenerTurno(Integer id) {
        return this.turnoControlador.obtenerTurno(id);
    }

    @Override
    public Turno actualizarTurno(Turno turno) {
        return this.turnoControlador.actualizarTurno(turno);
    }

    @Override
    public void eliminarTurno(Integer id) {
        this.turnoControlador.eliminarTurno(id);
    }

    @Override
    public List<Turno> obtenerTurnos() {
        return this.turnoControlador.obtenerTurnos();
    }


}
