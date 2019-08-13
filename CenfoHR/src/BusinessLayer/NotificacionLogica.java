/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccess.NotifficacionesMapper;
import DataAccess.PermisoHorasExtraMapper;
import DataAccess.PermisoSalidaMapper;
import Entities.Notificacion;
import Entities.Observable;
import Entities.PermisoHorasExtra;
import Entities.PermisoSalida;
import Entities.Personal;
import java.util.ArrayList;

/**
 *
 * @author franciscosandoval
 */
public class NotificacionLogica implements NotificacionesEnviar {

    private static ArrayList<Notificacion> lstNotificacion = new ArrayList<Notificacion>();
    private NotifficacionesMapper miNoti = new NotifficacionesMapper();
    private PermisoSalidaMapper miPermisoM = new PermisoSalidaMapper();
    private PermisoHorasExtraMapper horasExtra = new PermisoHorasExtraMapper();

    public NotificacionLogica() {
    }

    public ArrayList<Notificacion> listarNotificaciones() 
    {
            ArrayList<Notificacion> lstNotificaciones=new ArrayList<>();
        for (Notificacion minotiFicaciones : miNoti.listarNotificaciones()) {
            if (Personal.getMipersonal().getIdentificacion().equals(minotiFicaciones.getPara())) {
             lstNotificaciones.add(minotiFicaciones);
            }}
        return lstNotificaciones;
    }

    public Notificacion buscarNotificacione(String code) {
        return miNoti.buscarNotificacione(code);
    }

    public String CambiarEstado(int code) {
        return miNoti.CambiarEstado(code);

    }

    public int crearNotificaciones(Notificacion miNotificacion) {
        miNoti.crearNotificaciones(miNotificacion);
        return miNoti.obtenerUltimaNotificacion();
    }

    public String crearNotificacionesPermiso(PermisoSalida miPermiso) {
        return miPermisoM.crearNotificaciones(miPermiso);
    }

    public String crearNotificacionesHoras(PermisoHorasExtra miHorasExtra) {
        return horasExtra.crearNotificaciones(miHorasExtra);
    }

    @Override
    public String notificarObservador() {
        Observable minotiAlerta = new Observable();
        int alertas = 0;
        for (Notificacion minotiFicaciones : listarNotificaciones()) {
            if (Personal.getMipersonal().getIdentificacion().equals(minotiFicaciones.getPara())
                    && minotiFicaciones.getEstado().equals("No visto")) {
                alertas++;
            }
        }
        return minotiAlerta.alertaNotificacion(alertas);
    }

    @Override
    public String notificardesicionTomada() {
        Observable minotiAlerta = new Observable();
        int alertas = 0;
        for (Notificacion minotiFicaciones : listarNotificaciones()) {
            if (Personal.getMipersonal().getIdentificacion().equals(minotiFicaciones.getPara())
                    && minotiFicaciones.getEstado().equals("Visto")) {
                alertas++;
            }
        }
        return minotiAlerta.alertaNotificacionDesicion(alertas);
    }

    public String eliminarNotificacion(int id) {
        return miNoti.eliminarNotificacion(id);
    }

    public Object ObtenerNotificacion(int id) {
        Object miobjeto = new Object();
        if (miPermisoM.buscarNotificacion(id)!=null) {
         miobjeto = horasExtra.horasExtrabuscarNotificacion(id);
            
        } else {
           miobjeto = miPermisoM.buscarNotificacion(id);
        }

        return miobjeto;
    }

    

}
