package Repositorios;

import Controladores.MascotaControlador;
import DAO.MascotaDAO;
import Entidades.Mascota;

public class MascotaRepository implements MascotaDAO {

    private MascotaControlador mascotaControlador;

    public MascotaRepository(){
        this.mascotaControlador = new MascotaControlador();
    }
    @Override
    public void insertarMascota(Mascota mascota) {
        this.mascotaControlador.agregarMascota(mascota);
    }

    @Override
    public Mascota obtenerMascota(Integer idMascota) {
        return this.mascotaControlador.obtenerMascota(idMascota);
    }

    @Override
    public Mascota actualizarMascota(Mascota mascota) {
        return this.mascotaControlador.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(Integer id) {
        this.mascotaControlador.eliminarMascota(id);
    }
}
