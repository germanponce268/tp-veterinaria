package Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Perro extends Mascota{

    public String ladrar(){
        return "Guau Guau!";
    }

}
