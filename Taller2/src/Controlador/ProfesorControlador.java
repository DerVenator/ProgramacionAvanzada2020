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
public class ProfesorControlador implements ActionListener{
    private Sala sala;
    private Equipo equipo;
    private OperacionesEquipo oe;
    private ProfesorInterfaz pi;
    
    public ProfesorControlador(Sala sala, Equipo equipo, OperacionesEquipo oe, ProfesorInterfaz pi){
       this.sala = sala;
       this.equipo = equipo;
       this.oe = oe;
       this.pi = pi;
       //this.pi.verEquiposBtn.addActionListener(this);
       this.pi.buscarEquipoBtn.addActionListener(this);
       this.pi.reservarBtn.addActionListener(this);
    }
    
    public void iniciar(){
        pi.setTitle("Bienvenido Profesor");
        pi.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == pi.buscarEquipoBtn){
            equipo.setSerie(Integer.parseInt(pi.serieEquipoCuadro.getText()));
            if (oe.Buscar(equipo)){
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }
        }
        
        if (e.getSource() == pi.reservarBtn){

        }
    }
}
