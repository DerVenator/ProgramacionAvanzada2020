/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author cristian
 */
public class Sala {
    int idSala;
    boolean idUsuarioReserva;

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public boolean isIdUsuarioReserva() {
        return idUsuarioReserva;
    }

    public void setIdUsuarioReserva(boolean idUsuarioReserva) {
        this.idUsuarioReserva = idUsuarioReserva;
    }
}