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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nombre;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "estado_id")
    protected Estado estadoSalud;
    protected double temperatura;
    protected Double peso;

}
