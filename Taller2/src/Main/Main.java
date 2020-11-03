package Main;

import java.sql.*;
import Modelo.*;
import Vista.*;
import Controlador.*;

public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Conexion con = new Conexion();
        InicioSesion inicioSesion = new InicioSesion();
        Usuario usuario = new Usuario();
        InicioSesionInterfaz isi = new InicioSesionInterfaz();
        InicioSesionControlador isc = new InicioSesionControlador(usuario,inicioSesion, isi);
        isc.iniciar();
        isi.setVisible(true);
        //System.out.println(operacionesEquipo.BuscarTodo());
    }
}