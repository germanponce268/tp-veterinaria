package Estados;

import jakarta.persistence.Entity;
@Entity
public class Saludable extends Estado{
    private String estadoAnimo;

    public Saludable(){
        this.estadoAnimo = "Feliz";
    }

}
