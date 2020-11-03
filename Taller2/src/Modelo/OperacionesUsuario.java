/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class OperacionesUsuario extends Conexion{
    public boolean Registrar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuarios (idusuario,nombre,clave,rol) VALUES (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setInt(3, usuario.getClave());
            ps.setString(4, usuario.getRol());
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
 
    public boolean Modificar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE usuarios SET nombre=?, clave=?, rol=? WHERE idusuario=?";
        try {
            ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getNombre());
            ps.setInt(3, usuario.getClave());
            ps.setString(4, usuario.getRol());
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
    public boolean Eliminar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM usuarios WHERE idusuario = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
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
    public boolean Buscar(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuarios WHERE idusuario = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getIdUsuario());
            rs = ps.executeQuery();
            if (rs.next())
            {
               usuario.setIdUsuario(rs.getInt("idusuario"));
               usuario.setNombre(rs.getString("nombre"));
               usuario.setClave(rs.getInt("clave"));
               usuario.setRol(rs.getString("rol"));
               JOptionPane.showMessageDialog(null,usuario.getIdUsuario() + "  " + usuario.getNombre() + "  " 
               + usuario.getClave() + "  "+ usuario.getRol());
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

}
