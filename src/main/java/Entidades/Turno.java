package Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.StandardException;

import java.util.Date;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fecha;
    private String medico;
}
