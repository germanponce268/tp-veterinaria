package DAO;

import Entidades.Mascota;

import java.util.List;

public interface MascotaDAO {

    void insertarMascota(Mascota mascota);

    Mascota obtenerMascota(Integer idMascota);

    Mascota actualizarMascota(Mascota mascota);

    void eliminarMascota(Integer id);

    List<Mascota> obtenerMascotas();

}
