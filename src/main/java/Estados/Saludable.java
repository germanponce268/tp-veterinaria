package Estados;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Saludable extends Estado{
    private String estadoAnimo;

    public Saludable(){
        this.estadoAnimo = "Feliz";
    }


    @Override
    public void mostrarEstado() {
        System.out.println(this.estadoAnimo);
    }
}
