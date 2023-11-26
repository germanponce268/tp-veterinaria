package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Gato extends Mascota{



    public String maullar(){
        return "Miau Miau!";
    }
}
