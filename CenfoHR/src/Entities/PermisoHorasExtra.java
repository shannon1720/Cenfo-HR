/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import BusinessLayer.NotificacionesEnviar;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PermisoHorasExtra  {
    private int horasExtra;
    private boolean estado;
    private int id;
    private final String tipoNotificacion="Horas extra";
    public PermisoHorasExtra(int horasExtra, boolean estado, int id) {
        this.horasExtra = horasExtra;
        this.estado = estado;
        this.id = id;
    
    }

    public PermisoHorasExtra(Date fechaNotificacion, String asunto, String remitente, int horasExtra) {
        this.horasExtra = horasExtra;
        this.estado = false;

    }

    public PermisoHorasExtra() {
    }
    public String getTipoNotificacion() {
        return tipoNotificacion;
    }
    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
}
