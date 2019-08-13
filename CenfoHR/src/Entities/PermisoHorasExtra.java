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
    private String estado;
    private int idnotificacion;
    private int id;
    private Date fecha_horaExtra;
    private final String tipoNotificacion="Horas extra";
    private String nombreProyecto;
    public PermisoHorasExtra() {
    }

    public PermisoHorasExtra(int horasExtra,int idnotificacion,Date fecha_horaExtra,String nombreProyecto) {
        this.idnotificacion=idnotificacion;
        this.horasExtra = horasExtra;
        this.estado ="False";
        this.fecha_horaExtra=fecha_horaExtra;
        this.nombreProyecto=nombreProyecto;
    }

    public int getIdnotificacion() {
        return idnotificacion;
    }

    public void setIdnotificacion(int idnotificacion) {
        this.idnotificacion = idnotificacion;
    }

    public Date getFecha_horaExtra() {
        return fecha_horaExtra;
    }

    public void setFecha_horaExtra(Date fecha_horaExtra) {
        this.fecha_horaExtra = fecha_horaExtra;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        if(estado){
         this.estado = "Aceptado";
        }else{ this.estado = "Rechazado";}
        
    }
    
     public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
    
    
}
