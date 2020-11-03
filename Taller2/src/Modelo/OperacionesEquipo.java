package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;

public class OperacionesEquipo extends Conexion{
    
    public boolean Registrar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO equipos (serie,año,marca,equipo,estado,sede,idsala) VALUES (?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getSerie());
            ps.setInt(2, equipo.getAño());
            ps.setString(3, equipo.getMarca());
            ps.setString(4, equipo.getEquipo());
            ps.setBoolean(5, equipo.getEstado());
            ps.setString(6, equipo.getSede());
            ps.setInt(7, equipo.getIdSala());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
 
    public boolean Modificar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE equipos SET año=?, marca=?, equipo=?, estado=?, sede=?, idsala=? WHERE serie=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getAño());
            ps.setString(2, equipo.getMarca());
            ps.setString(3, equipo.getEquipo());
            ps.setBoolean(4, equipo.getEstado());
            ps.setString(5, equipo.getSede());
            ps.setInt(6, equipo.getIdSala());
            ps.setInt(7, equipo.getSerie());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean Eliminar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM equipos WHERE serie = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getSerie());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean Buscar(Equipo equipo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM equipos WHERE serie = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getSerie());
            rs = ps.executeQuery();
            if (rs.next())
            {
               equipo.setSerie(rs.getInt("serie"));
               equipo.setAño(rs.getInt("año"));
               equipo.setMarca(rs.getString("marca"));
               equipo.setEquipo(rs.getString("equipo"));
               equipo.setEstado(rs.getBoolean("estado"));
               equipo.setSede(rs.getString("sede"));
               equipo.setIdSala(rs.getInt("idsala"));
               JOptionPane.showMessageDialog(null,equipo.getSerie() + "  " + equipo.getAño() + "  " + equipo.getMarca() + "  "
                + equipo.getEquipo() + "  " + InterpretacionOperatividad(equipo.getEstado()) + "  " + equipo.getSede() + "  " + equipo.getIdSala() + "  ");
               return true;
            }
            return false;       
        }catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    //deberia buscar todos los equipos
    /*public boolean BuscarTodo(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM equipos";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                int serie = rs.getInt("serie");
                int año = rs.getInt("año");
                String marca = rs.getString("marca");
                String equipo = rs.getString("equipo");
                boolean estado = rs.getBoolean("estado");
                String sede = rs.getString("sede");
                int idSala = rs.getInt("idsala");
                
                System.out.println("serie" + "\t" + "año" + "\t" + "marca" + "\t"
                + "equipo" + "\t" + "       estado" + "\t" + "sede" + "\t" 
                + "      idSala" + "\t");
                
                System.out.println(serie + "\t" + año + "\t" + marca + "\t"
                + equipo + "\t" + estado + "\t" + sede + "\t" + idSala + "\t");
            }
            return true;
        }catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }*/
    
    public String InterpretacionOperatividad(boolean estado){
        String retorno;
        if(estado == true){
            retorno = "Operativo";
        }else{
            retorno = "No Operativo";
        }
        return retorno;
    }
}
