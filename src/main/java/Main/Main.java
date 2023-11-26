package Main;

import Conexion.Conexion;
import DAO.MascoctaDAO;
import Entidades.Mascota;
import Entidades.Perro;
import Estados.Enfermo;
import Estados.Estado;
import Repositorios.MascotaRepositoy;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.getConnection();
        Mascota perro1 = new Perro();
        perro1.setNombre("Chiquito2");
        perro1.setTemperatura(35.5);
        perro1.setPeso(30.2);
        Estado estado = new Enfermo();
        perro1.setEstadoSalud(estado);

        MascotaRepositoy mascotaRepositoy = new MascotaRepositoy();
        mascotaRepositoy.insertarMascota(perro1);

    }
}
