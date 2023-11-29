package Entidades;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Perro extends Mascota{


    public String ladrar(){
        return "Guau Guau!";
    }

}
