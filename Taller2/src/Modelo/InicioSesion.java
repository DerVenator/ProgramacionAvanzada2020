package Modelo;
import java.sql.*;
import Vista.*;
import Controlador.*;
import javax.swing.JOptionPane;

public class InicioSesion extends Conexion{
    Connection con = getConexion();
    //ProfesorInterfaz profesorInterfaz = new ProfesorInterfaz();
    
    public boolean InicioSesion(Usuario usuario)throws ClassNotFoundException, SQLException{
        boolean inicio = false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nombre, clave, rol, idusuario FROM usuarios WHERE nombre=? AND clave=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getNombre());
            ps.setInt(2,usuario.getClave());
            rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("inicio exitoso");
                String nombre = rs.getString("nombre");
                int clave = rs.getInt("clave");
                int idUsuario = rs.getInt("idusuario");
                String rol = rs.getString("rol");
                usuario.setRol(rol);
                usuario.setClave(clave);
                usuario.setNombre(nombre);
                usuario.setIdUsuario(idUsuario);
                inicio = true;
                switch (rol){
                    case "Administrador":
                        AdministradorInterfaz ai = new AdministradorInterfaz();
                        Equipo equipoA = new Equipo();
                        OperacionesEquipo oea = new OperacionesEquipo();
                        Usuario usuarioA = new Usuario();
                        OperacionesUsuario oua = new OperacionesUsuario();
                        AdministradorControlador ac = new AdministradorControlador(equipoA,oea,usuarioA,oua,ai);
                        ac.iniciar();
                        ai.setVisible(true);
                        break;
                    case "Encargado":
                        EncargadoInterfaz ei = new EncargadoInterfaz();
                        Equipo equipoE = new Equipo();
                        OperacionesEquipo oee = new OperacionesEquipo();
                        EncargadoControlador ec = new EncargadoControlador(equipoE,oee,ei);
                        ec.iniciar();
                        ei.setVisible(true);
                        break;
                    case "Profesor":
                        ProfesorInterfaz pi = new ProfesorInterfaz();
                        Sala sala = new Sala();
                        OperacionesSala os = new OperacionesSala();
                        Equipo equipoP = new Equipo();
                        OperacionesEquipo oe= new OperacionesEquipo();
                        ProfesorControlador pc = new ProfesorControlador(usuario,sala, os, equipoP, oe, pi);
                        pc.iniciar();
                        pi.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Usuario tiene un rol desconocido, porfavor contacte con el administrador");
                }
            }
        } catch(SQLException e){
            System.err.println(e);
            inicio = false;
        } finally{
            try{
                con.close();
            } catch (SQLException e){
                System.err.println(e);
            }
        }
        return inicio;
    }
}
