/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cristian
 */
public class InicioSesionControlador implements ActionListener{
    Usuario usuario;
    InicioSesionInterfaz isi;
    InicioSesion inicioSesion;
    

    
    public InicioSesionControlador (Usuario usuario, InicioSesion inicioSesion, InicioSesionInterfaz isi){
        this.isi = isi;
        this.usuario = usuario;
        this.inicioSesion = inicioSesion;
        this.isi.iniciarSesionBtn.addActionListener(this);
    }
    
    public void iniciar(){
        isi.setTitle("Iniciar Sesion");
        isi.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == isi.iniciarSesionBtn){
            usuario.setNombre(isi.usuarioCuadro.getText());
            usuario.setClave(Integer.parseInt(isi.contraseñaCuadro.getText()));
            try {
                inicioSesion.InicioSesion(usuario);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InicioSesionControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(InicioSesionControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
