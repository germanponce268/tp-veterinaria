package Controladores;

import Entidades.Mascota;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MascotaControlador {

    public static final String UNIDAD_PERSISTENCIA = "PersistenciaVeterinaria";

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public MascotaControlador (){
        entityManagerFactory = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }

    public void agregarMascota(Mascota mascota){
        this.entityManager= entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(mascota);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
