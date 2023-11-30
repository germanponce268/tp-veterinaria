package Servicios;

import DAO.MascotaDAO;
import Entidades.Gato;
import Entidades.Mascota;
import Entidades.Perro;
import Estados.Enfermo;
import Estados.Saludable;
import Repositorios.MascotaRepository;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MascotaService {

    public static final String ESTADO_TRISTE = "Triste";
    public static final String ESTADO_FELIZ = "Feliz";
    private Scanner consola = new Scanner(System.in);

    MascotaDAO mascotaDAO;

    public MascotaService(){
        this.mascotaDAO = new MascotaRepository();
    }

    public void agregarMascota(){

        System.out.println("Ingrese 1 si es un Perro o 2 si es un Gato");
        Integer opcion = this.consola.nextInt();
        switch (opcion){
            case 1:
            Mascota perro = new Perro();
            ingresarDatos(perro, this.consola);
            this.mascotaDAO.insertarMascota(perro);
            break;
            case 2:
                Mascota gato = new Gato();
                ingresarDatos(gato, this.consola);
                this.mascotaDAO.insertarMascota(gato);
                break;
            default:
                System.out.println("Ingrese un numero valido");
                break;
        }
    }

    public void modificarMascota() {

        System.out.println("Ingrese 1 si es un Perro o 2 si es un Gato");
        Integer opcion = this.consola.nextInt();
        switch (opcion){
            case 1:
                Mascota perro = new Perro();
                ingresarDatos(perro);
                this.mascotaDAO.actualizarMascota(perro);
                break;
            case 2:
                Mascota gato = new Gato();
                ingresarDatos(gato);
                this.mascotaDAO.actualizarMascota(gato);
        }

    }

    private Mascota ingresarDatos(Mascota mascota, Scanner consola){
        System.out.println("Ingrese el nombre de la mascota");
        String nombre = consola.next();
        System.out.println("Ingrese la temperatura de la mascota separando los decimales con una ','(coma)");
        Double temperatura = consola.nextDouble();
        System.out.println("Ingrese el peso de la mascota separando los decimales con una ','(coma)");
        Double peso = consola.nextDouble();
        System.out.println("Ingrese el estado de animo de la mascota indicando si esta 'Feliz' o 'Triste'");
        String estadoAnimo = consola.next();
        mascota.setNombre(nombre);
        mascota.setTemperatura(temperatura);
        mascota.setPeso(peso);
        if(estadoAnimo.equalsIgnoreCase(ESTADO_FELIZ)){
            mascota.setEstadoSalud(new Saludable());
        }
        if (estadoAnimo.equalsIgnoreCase(ESTADO_TRISTE)){
            mascota.setEstadoSalud(new Enfermo());
        }
        return mascota;
    }

    private Mascota ingresarDatos(Mascota mascota){
        System.out.println("Ingrese el Id de la mascota que desea actualizar");
        Integer id = this.consola.nextInt();
        System.out.println("Ingrese el nuevo nombre de la mascota");
        String nuevoNombre = this.consola.next();
        System.out.println("Ingrese la nueva temperatura de la mascota separando los decimales con una ','(coma)");
        Double nuevaTemperatura = this.consola.nextDouble();
        System.out.println("Ingrese el nuevo peso de la mascota separando los decimales con una ','(coma)");
        Double nuevoPeso = this.consola.nextDouble();
        System.out.println("Ingrese el nuevo estado de animo de la mascota, indicando si esta 'Feliz' o 'Triste'");
        String estadoAnimo = consola.next();
        mascota.setId(id);
        mascota.setNombre(nuevoNombre);
        mascota.setTemperatura(nuevaTemperatura);
        mascota.setPeso(nuevoPeso);
        if(estadoAnimo.equalsIgnoreCase(ESTADO_FELIZ)){
            mascota.setEstadoSalud(new Saludable());
        }
        if (estadoAnimo.equalsIgnoreCase(ESTADO_TRISTE)){
            mascota.setEstadoSalud(new Enfermo());
        }
        return mascota;
    }

    public void obtenerMascota() {
        System.out.println("Ingrese el id de la mascota que desea ver");
        Integer id = this.consola.nextInt();
        Mascota mascota = this.mascotaDAO.obtenerMascota(id);
        System.out.println(mascota.getNombre() + " \n Peso : " + mascota.getPeso() + " \n Temperatura : " + mascota.getTemperatura() + " \n Estado de animo :" + mascota.getEstadoSalud());

    }

    public void eliminarMascota() {
        System.out.println("Ingrese el id de la mascota que desea eliminar");
        Integer id = this.consola.nextInt();
        this.mascotaDAO.eliminarMascota(id);
        System.out.println("Se elimino la mascota!4");
    }

    public void obtenerMascotas(){
        List<Mascota> listadoMascotas = this.mascotaDAO.obtenerMascotas();
        listadoMascotas.forEach(mascota -> {
            System.out.println(mascota.getNombre() + " \n Id: " + mascota.getId() + " \n Peso: " + mascota.getPeso() + " \n Estado de animo:" + mascota.getEstadoSalud());
        });
    }

    public void obtenerMascotaMasAfiebrada(){
        List<Mascota> listadoMascotas = this.mascotaDAO.obtenerMascotas();
        Optional<Mascota> maxTemp = listadoMascotas.stream()
                .max(Comparator.comparingDouble(Mascota::getTemperatura));
        System.out.println("La mascota con mas temperatura es " + maxTemp.get().getNombre() + " con " + maxTemp.get().getTemperatura() + "° ");
    }
}
