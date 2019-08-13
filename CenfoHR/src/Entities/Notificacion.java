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
 * @author franciscosandoval
 */
public class Notificacion{
    private int id;
    private Date fechaNotificacion;
    private String asunto;
    private String estado;
    private String remitente;
    private String para;

   
    public Notificacion() {
    }
    public Notificacion(String asunto,String remitente) {
        this.fechaNotificacion = new Date();
        this.asunto = asunto;
        this.estado = "False";
        this.remitente = remitente;
    }
    public String getPara() {
        return para;
    }
    public void setPara(String para) {
        this.para = para;
    }
    public Date getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(Date fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        
        if(estado){
         this.estado = "Visto";
        }else{ this.estado = "No visto";}
        
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Notificacion{" + "fechaNotificacion=" + fechaNotificacion + ", asunto=" + asunto + ", estado=" + estado + ", remitente=" + remitente + '}';
    }
    
     
}
