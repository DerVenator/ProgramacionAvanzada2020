package Controlador;
import java.awt.event.ActionListener;
import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class AdministradorControlador implements ActionListener{
    private Equipo equipo;
    private OperacionesEquipo oe;
    private Usuario usuario;
    private OperacionesUsuario ou;
    private AdministradorInterfaz ai;

    public AdministradorControlador(Equipo equipo, OperacionesEquipo oe, Usuario usuario, OperacionesUsuario ou, AdministradorInterfaz ai) {
        this.equipo = equipo;
        this.oe = oe;
        this.usuario = usuario;
        this.ou = ou;
        this.ai = ai;
        this.ai.actualizarBtn.addActionListener(this);
        this.ai.buscarEquipoBtn.addActionListener(this);
        this.ai.buscarUsuarioBtn.addActionListener(this);
        this.ai.crearBtn.addActionListener(this);
        this.ai.eliminarUsuarioBtn.addActionListener(this);
        this.ai.verEquiposBtn.addActionListener(this);
        this.ai.verUsuariosBtn.addActionListener(this);
    }
    
    public void iniciar() {
        ai.setTitle("Bienvenido Administrador");
        ai.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ai.crearBtn){
            usuario.setNombre(ai.nombreCuadro.getText());
            usuario.setClave(Integer.parseInt(ai.claveCuadro.getText()));
            usuario.setIdUsuario(Integer.parseInt(ai.idUsuarioCuadro.getText()));
            usuario.setRol(ai.rolCuadro.getText());
            if (ou.Registrar(usuario)){
                JOptionPane.showMessageDialog(null, "Usuario Creado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Crear");
            }
        }
        if (e.getSource() == ai.actualizarBtn){
            usuario.setNombre(ai.nombreCuadro.getText());
            usuario.setClave(Integer.parseInt(ai.claveCuadro.getText()));
            usuario.setIdUsuario(Integer.parseInt(ai.idUsuarioCuadro.getText()));
            usuario.setRol(ai.rolCuadro.getText());
            if(ou.Modificar(usuario)){
                JOptionPane.showMessageDialog(null, "Usuario Actualizado");
            }else {
                JOptionPane.showMessageDialog(null, "Error al Actualizar Usuario");
            }
        }
        if (e.getSource() == ai.eliminarUsuarioBtn){
            usuario.setIdUsuario(Integer.parseInt(ai.buscarCuadro.getText()));
            if (ou.Eliminar(usuario)){
                JOptionPane.showMessageDialog(null, "Usuario Eliminado");
            }else{
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario");
            }
        }
        if (e.getSource() == ai.buscarUsuarioBtn){
            usuario.setIdUsuario(Integer.parseInt(ai.buscarCuadro.getText()));
            if (ou.Buscar(usuario)){
                
            }else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado y/o no existente");
            }
        }
        if (e.getSource() == ai.buscarEquipoBtn){
            equipo.setSerie(Integer.parseInt(ai.serieCuadro.getText()));
            if (oe.Buscar(equipo)){
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos");
            }
        }
        
    }
    
}
