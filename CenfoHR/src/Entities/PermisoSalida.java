/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import java.util.Date;

/**
 *
 * @author Usuario
 */
public class PermisoSalida {

    private boolean estado;
    private Date fechaentrada;
    private Date fechasalida;
    private String descripcion;
    private int id;
    private String tipoNotificacion;
    private int idNotificacion;

    public PermisoSalida() {
    }

    public PermisoSalida(Date fechaentrada, Date fechasalida, String descripcion, String tipoNotificacion, int idNotificacion) {
        this.estado = false;
        this.fechaentrada = fechaentrada;
        this.fechasalida = fechasalida;
        this.descripcion = descripcion;
        this.tipoNotificacion = tipoNotificacion;
        this.idNotificacion = idNotificacion;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Date getFechaentrada() {
        return fechaentrada;
    }

    public void setFechaentrada(Date fechaentrada) {
        this.fechaentrada = fechaentrada;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getTipoNotificacion() {
        return tipoNotificacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}
