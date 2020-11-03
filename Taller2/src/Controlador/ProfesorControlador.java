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
import Controlador.InicioSesionControlador;
/**
 *
 * @author cristian
 */
public class ProfesorControlador implements ActionListener{
    private Sala sala;
    private OperacionesSala os;
    private Equipo equipo;
    private OperacionesEquipo oe;
    private ProfesorInterfaz pi;
    InicioSesionControlador isc;
    Usuario usuario;
    
    public ProfesorControlador(Usuario usuario, Sala sala, OperacionesSala os, Equipo equipo, OperacionesEquipo oe, ProfesorInterfaz pi){
       this.sala = sala;
       this.os = os;
       this.equipo = equipo;
       this.oe = oe;
       this.pi = pi;
       this.usuario = usuario;
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
            sala.setIdSala(Integer.parseInt(pi.idSalaCuadro.getText()));
            sala.setIdUsuarioReserva(Integer.parseInt(pi.idUsuarioCuadro.getText()));
            if(os.ReservarSala(sala)){
                JOptionPane.showMessageDialog(null, "Sala reservada");
            }else{
                JOptionPane.showMessageDialog(null, "Error al reservar, sala y/o usuario no existe");
            }
        }
    }
}
