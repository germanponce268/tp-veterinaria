package Controladores;

import Entidades.Mascota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MascotaControlador {

    public static final String UNIDAD_PERSISTENCIA = "PersistenciaVeterinaria";

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public MascotaControlador (){
        this.entityManagerFactory = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }

    public void agregarMascota(Mascota mascota){
        this.entityManager= entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(mascota);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    public Mascota obtenerMascota(Integer idMascota) {
        this.entityManager= entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
       Mascota mascota = this.entityManager.find(Mascota.class, idMascota);
       this.entityManager.getTransaction().commit();
       return mascota;
    }

    public Mascota actualizarMascota(Mascota mascota) {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        Mascota mascotaDB = this.entityManager.find(Mascota.class , mascota.getId());
        mascotaDB.setNombre(mascota.getNombre());
        mascotaDB.setPeso(mascota.getPeso());
        mascotaDB.setTemperatura(mascota.getTemperatura());
        mascotaDB.setEstadoSalud(mascota.getEstadoSalud());
        Mascota mascotaActualizada = this.entityManager.merge(mascotaDB);
        this.entityManager.getTransaction().commit();
        return mascotaActualizada;


    }

    public void eliminarMascota(Integer id) {
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        Mascota mascota = this.entityManager.find(Mascota.class, id);
        this.entityManager.remove(mascota);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }
}
