/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.PermisoSalida;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class PermisoSalidaMapper extends SqlConnection {

    public String crearNotificaciones(PermisoSalida miNotificacion) {
        java.sql.Date fechaEntrada = new java.sql.Date(miNotificacion.getFechaentrada().getTime());
        java.sql.Date fechaSalida = new java.sql.Date(miNotificacion.getFechasalida().getTime());
        String consulta = "{Call dbo.crear_notificacion_permiso ('" + fechaEntrada + "','"
                + fechaSalida + "','" + miNotificacion.getDescripcion() + "','"
                + miNotificacion.getTipoNotificacion() + "','" + miNotificacion.getIdNotificacion() + "')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);
            resultado = "La notificacion se ha enviado correctamente en el sistema.";

        } catch (Exception error) {
            resultado = "No se pudo enviar la notificacion, intentelo de nuevo " + error.getMessage();

        } finally {

            if (cst != null) {
                try {
                    cst.close();
                } catch (Exception e) {
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }}

        return resultado;
    }
}
