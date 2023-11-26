package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static String DB = "";
    private static String username = "postgres";
    private static String password = "L4D3d10s";
    private static String url = "jdbc:postgresql://localhost:5432/postgres";

    Connection conn = null;

    public Conexion(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
            if (conn!=null){
                System.out.println("Exito en la conexion a la Base de Datos");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
