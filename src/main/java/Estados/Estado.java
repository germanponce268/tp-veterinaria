package Estados;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.xml.sax.HandlerBase;
@Entity
public abstract class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public abstract void mostrarEstado();
}
