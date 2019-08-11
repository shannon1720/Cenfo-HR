/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import Entities.*;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class NotificacionesEnviar  {
        public abstract int crearNotificaciones(Notificacion miNotificacion);
	public abstract String crearNotificacionesPermiso(PermisoSalida miPermiso);
        public abstract String crearNotificacionesHoras(PermisoHorasExtra miHorasExtra);
        public abstract ArrayList<Notificacion> listarNotificaciones(String code);
        public abstract Notificacion buscarNotificacione(String code);
        public abstract Notificacion CambiarEstado(String code);

}
