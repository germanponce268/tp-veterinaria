package Controladores;

import Entidades.Mascota;
import Entidades.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TurnoControlador {
    public static final String UNIDAD_PERSISTENCIA = "PersistenciaVeterinaria";

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public TurnoControlador(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory(UNIDAD_PERSISTENCIA);
    }

    public void agregarTurno(Turno turno){
        this.entityManager= entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(turno);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();

    }
    public Turno obtenerTurno(Integer idTurno) {
        this.entityManager= entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        Turno turno = this.entityManager.find(Turno.class, idTurno);
        this.entityManager.getTransaction().commit();
        return turno;
    }


}
