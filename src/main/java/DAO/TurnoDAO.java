package DAO;

import Entidades.Turno;

public interface TurnoDAO {

    void insertarTurno(Turno turno);
    Turno obtenerTurno(Integer id);
    Turno actualizarTurno(Turno turno);
    void eliminarTurno(Integer id);

}
