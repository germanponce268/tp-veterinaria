package Estados;

import Entidades.Mascota;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enfermo extends Estado{

    private String estadoAnimo;

    public Enfermo(){
        this.estadoAnimo = "Triste";
    }


    @Override
    public void mostrarEstado() {
        System.out.println(this.estadoAnimo);
    }
}
