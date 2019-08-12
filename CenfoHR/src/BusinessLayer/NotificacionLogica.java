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
    private PermisoHorasExtraMapper horasExtra=new PermisoHorasExtraMapper();
    public NotificacionLogica() {
    }

    public ArrayList<Notificacion> listarNotificaciones() {
        return miNoti.listarNotificaciones();
    }

    public Notificacion buscarNotificacione(String code) {
        return miNoti.buscarNotificacione(code);
    }

    public Notificacion CambiarEstado(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Notificacion minotiAlerta = new Notificacion();
        int alertas = 0;
        for (Notificacion minotiFicaciones : listarNotificaciones()) {
            if (Personal.getMipersonal().getIdentificacion().equals(minotiFicaciones.getPara()) && 
                minotiFicaciones.getEstado().equals("No visto")) {
                alertas++;
            }

        }

        return minotiAlerta.alertaNotificacion(alertas);
    }

}
