/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.PermisoHorasExtra;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class PermisoHorasExtraMapper extends SqlConnection {

    public String crearNotificaciones(PermisoHorasExtra miHorasExtra) {
        java.sql.Date fecha = new java.sql.Date(miHorasExtra.getFecha_horaExtra().getTime());
        String consulta = "{Call dbo.crear_notificacion_horasExtra ('" + fecha + "','"
                + miHorasExtra.getEstado() + "','"+ miHorasExtra.getIdnotificacion() + "','" 
                + miHorasExtra.getNombreProyecto() + "','"+miHorasExtra.getHorasExtra()+"')}";
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

    public Object horasExtrabuscarNotificacion(int id) {
     PermisoHorasExtra minotificacion = null;
       String consulta = "{Call dbo.buscarNotificacionHorasExtra('"+id+"')}";
       Object buscarNotificacion = null;
  
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            buscarNotificacion =new Object();
           
            while (rs.next()) {
                minotificacion = new PermisoHorasExtra();
                minotificacion.setId(rs.getInt("ID_OVERTIME"));
                minotificacion.setFecha_horaExtra(rs.getDate("DATE"));
                minotificacion.setEstado(rs.getBoolean("STATE"));
                minotificacion.setNombreProyecto(rs.getString("PROYECT"));
                minotificacion.setIdnotificacion(rs.getInt("ID_NOTIFICATION")); 
                 minotificacion.setHorasExtra(rs.getInt("HOURS")); 
                buscarNotificacion=minotificacion;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
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
            }
        }
        return buscarNotificacion;    
    }
    
}
