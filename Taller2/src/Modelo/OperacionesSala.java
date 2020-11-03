/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author cristian
 */
public class OperacionesSala extends Conexion{
    public boolean ReservarSala (Sala sala){
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE salas SET idusuarioreserva=? WHERE  idsala=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sala.getIdUsuarioReserva());
            ps.setInt(2, sala.getIdSala());
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
}
