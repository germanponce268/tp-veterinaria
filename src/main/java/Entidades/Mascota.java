package Entidades;

import Estados.Estado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "mascotas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    protected String nombre;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "estado_id")
    protected Estado estadoSalud;
    protected Double temperatura;
    protected Double peso;

}
