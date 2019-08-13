
package Entities;

import java.util.Date;

/**
 *
 * @author Tremi
 */
public class Proyecto {
    private String nombre;
    private int codigo;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private int estado;

    public Proyecto() {
    }

    public Proyecto(String nombre, int codigo, Date fechaInicio, Date fechaFin, String descripcion, int estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public enum Estado{
    ACTIVO(1), 
    INACTIVO(2), 
    SUSPENDIDO(3), 
    CANCELADO(4);
    
    public final int id;
 
    private Estado(int id) {
        this.id = id;
    }
    
}
}

