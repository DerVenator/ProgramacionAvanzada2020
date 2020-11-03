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
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class EncargadoControlador implements ActionListener{
    private Equipo equipo;
    private OperacionesEquipo oe;
    private EncargadoInterfaz ei;

    public EncargadoControlador(Equipo equipo, OperacionesEquipo oe, EncargadoInterfaz ei) {
        this.equipo = equipo;
        this.oe = oe;
        this.ei = ei;
        this.ei.actualizarEquipoBtn.addActionListener(this);
        this.ei.buscarEquipoBtn.addActionListener(this);
        this.ei.crearEquipoBtn.addActionListener(this);
        this.ei.eliminarEquipoBtn.addActionListener(this);
        this.ei.verEquiposBtn.addActionListener(this);
        
    }
    
    public void iniciar(){
        ei.setTitle("Bienvenido Encargado");
        ei.setLocationRelativeTo(null);
    }
    
    public void actionPerformed (ActionEvent e){
        if(e.getSource() == ei.crearEquipoBtn){
            equipo.setSerie(Integer.parseInt(ei.serieCuadro.getText()));
            equipo.setAño(Integer.parseInt(ei.añoCuadro.getText()));
            equipo.setMarca(ei.marcaCuadro.getText());
            equipo.setEquipo(ei.equipoCuadro.getText());
            equipo.setEstado(CambioABoolean(ei.estadoCuadro.getText()));
            equipo.setSede(ei.sedeCuadro.getText());
            equipo.setIdSala(Integer.parseInt(ei.idSalaCuadro.getText()));
            if (oe.Registrar(equipo)){
                JOptionPane.showMessageDialog(null, "Equipo Creado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Crear");
            }
        }
        
        if(e.getSource() == ei.actualizarEquipoBtn){
            equipo.setSerie(Integer.parseInt(ei.serieCuadro.getText()));
            equipo.setAño(Integer.parseInt(ei.añoCuadro.getText()));
            equipo.setMarca(ei.marcaCuadro.getText());
            equipo.setEquipo(ei.equipoCuadro.getText());
            equipo.setEstado(CambioABoolean(ei.estadoCuadro.getText()));
            equipo.setSede(ei.sedeCuadro.getText());
            equipo.setIdSala(Integer.parseInt(ei.idSalaCuadro.getText()));
            if (oe.Modificar(equipo)){
                JOptionPane.showMessageDialog(null, "Equipo Actualizado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Actualizar");
            }
        }
        if (e.getSource() == ei.buscarEquipoBtn){
            equipo.setSerie(Integer.parseInt(ei.serieEquipoCuadro.getText()));
            if (oe.Buscar(equipo)){
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }
        }
        if (e.getSource() == ei.eliminarEquipoBtn){
            equipo.setSerie(Integer.parseInt(ei.serieEquipoCuadro.getText()));
            if (oe.Eliminar(equipo)){
                JOptionPane.showMessageDialog(null, "Equipo Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "No es posible Eliminar equipo");
            }
        }
    }
    
    public boolean CambioABoolean(String texto){
        boolean retorno;
        if(texto.toLowerCase() == "operativo".toLowerCase()){
            retorno = true;
        }else{
            retorno = false;
        }
        return retorno;
    }
}