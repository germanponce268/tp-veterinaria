package Repositorios;

import Controladores.MascotaControlador;
import DAO.MascoctaDAO;
import Entidades.Mascota;

public class MascotaRepositoy implements MascoctaDAO {

    private MascotaControlador mascotaControlador;

    public MascotaRepositoy(){
        this.mascotaControlador = new MascotaControlador();
    }
    @Override
    public void insertarMascota(Mascota mascota) {
        this.mascotaControlador.agregarMascota(mascota);
    }
}
