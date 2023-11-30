package Controladores;

import Entidades.Mascota;
import Entidades.Turno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

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

    public Turno actualizarTurno(Turno turno){
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        Turno turnoDB  = this.entityManager.find(Turno.class, turno.getId());
        turnoDB.setId(turno.getId());
        turnoDB.setFecha(turno.getFecha());
        turnoDB.setMedico(turno.getMedico());
        this.entityManager.merge(turnoDB);
        this.entityManager.getTransaction().commit();
        return turnoDB;
    }

    public void eliminarTurno(Integer id){
        this.entityManager = this.entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
        Turno turno = this.entityManager.find(Turno.class, id);
        this.entityManager.remove(turno);
        this.entityManager.close();

    }

    public List<Turno> obtenerTurnos(){
        this.entityManager = this.entityManagerFactory.createEntityManager();
        CriteriaQuery<Turno> criteriaQuery =  this.entityManager.getCriteriaBuilder().createQuery(Turno.class);
        Root<Turno> root = criteriaQuery.from(Turno.class);
        criteriaQuery.select(root);
        List<Turno> listadoTurnos = this.entityManager.createQuery(criteriaQuery).getResultList();
        return listadoTurnos;
    }
}
