package Modelo;
import java.sql.*;
public class Conexion {
    private String timezone = "?useTimezone=true&serverTimezone=UTC";
    private String user = "root";
    private String password = "cris8059xD";
    private String url = "jdbc:mysql://localhost:3306/equipos";
    private Connection con = null;

    public Connection getConexion() {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url + this.timezone, this.user, this.password);
            System.out.println("Conectado");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error en la conexión a la BBDD");
        }
        return con;
    }
}