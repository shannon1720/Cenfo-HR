/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccess.NotifficacionesMapper;
import DataAccess.PermisoSalidaMapper;
import Entities.Notificacion;
import Entities.PermisoHorasExtra;
import Entities.PermisoSalida;
import java.util.ArrayList;

/**
 *
 * @author franciscosandoval
 */
public class NotificacionLogica extends NotificacionesEnviar {

    private static ArrayList<Notificacion> lstNotificacion = new ArrayList<Notificacion>();
    private NotifficacionesMapper miNoti=new NotifficacionesMapper();
    private PermisoSalidaMapper miPermisoM= new PermisoSalidaMapper();
    public NotificacionLogica() {
    }

    @Override
    public ArrayList<Notificacion> listarNotificaciones(String code) {
  
      return miNoti.listarNotificaciones(code);
    }

    @Override
    public Notificacion buscarNotificacione(String code) {
        return null;
    }

    @Override
    public Notificacion CambiarEstado(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.


    }

    @Override
    public int crearNotificaciones(Notificacion miNotificacion) {
       miNoti.crearNotificaciones(miNotificacion);
      return miNoti.obtenerUltimaNotificacion();
    }

    @Override
    public String crearNotificacionesPermiso(PermisoSalida miPermiso) {
        return miPermisoM.crearNotificaciones(miPermiso);
    }

    @Override
    public String crearNotificacionesHoras(PermisoHorasExtra miHorasExtra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
