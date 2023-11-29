package Entidades;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Gato extends Mascota{



    public String maullar(){
        return "Miau Miau!";
    }
}
