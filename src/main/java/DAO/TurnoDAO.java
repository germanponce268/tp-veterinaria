package DAO;

import Entidades.Turno;

import java.util.List;

public interface TurnoDAO {

    void insertarTurno(Turno turno);
    Turno obtenerTurno(Integer id);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(Integer id);
    List<Turno> obtenerTurnos();

}
