/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Usuario
 */
public class Observable implements Observador {

   @Override
    public String alertaNotificacion(int notificacion) {
        
       return "Usted tiene "+notificacion+" notificacion(es) pendientes.";
    }

    @Override
    public String alertaNotificacionDesicion(int notificacion) {
    return "Usted tiene "+notificacion+" notificacion(es) respondidas.";
    }
    
}
