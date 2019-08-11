/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;
/**
 *
 * @author Alriosa
 */
public class Personal {

    private String identificacion;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String genero;
    private String contrasenna;
    private int rol;
    private int grado_academico;
    private MediaPersonal miMedia;
    private static Personal mipersonal = null;

    public Personal() {
    }

    public Personal(String identificacion, String nombre, String apellidoUno, String apellidoDos, Date fechaNacimiento, Date fechaIngreso, String genero, String contrasenna, int rol, int grado_academico, MediaPersonal miMedia) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.genero = genero;
        this.contrasenna = contrasenna;
        this.rol = rol;
        this.grado_academico = grado_academico;
        this.miMedia = miMedia;
    }

    public static Personal getPersonal(Personal miPersonalSinglethon) {
        if (mipersonal == null) {
            mipersonal = miPersonalSinglethon;
        }
        return mipersonal;
    }

    public static Personal getMipersonal() {
        return mipersonal;
    }

    public static void setMipersonal(Entities.Personal mipersonal) {
        mipersonal = null;
    }

    public int getGrado_academico() {
        return grado_academico;
    }

    public void setGrado_academico(int grado_academico) {
        this.grado_academico = grado_academico;
    }

    public MediaPersonal getMiMedia() {
        return miMedia;
    }

    public void setMiMedia(MediaPersonal miMedia) {
        this.miMedia = miMedia;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
}