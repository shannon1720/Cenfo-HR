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

    public Object buscarNotificacion(int id) {
       PermisoSalida minotificacion = null;
       String consulta = "{Call dbo.buscarNotificacionPermiso('"+id+"')}";
       Object buscarNotificacion = null;
  
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            
           
            while (rs.next()) {
                buscarNotificacion =new Object();
                minotificacion = new PermisoSalida();
                minotificacion.setId(rs.getInt("ID_PERMIT"));
                minotificacion.setFechaentrada(rs.getDate("ENTRANCE_DATE"));
                minotificacion.setFechasalida(rs.getDate("FINAL_DATE"));
                minotificacion.setDescripcion(rs.getString("DESCRIPTION"));
                minotificacion.setTipoNotificacion(rs.getString("TYPE_PERMIT"));
                minotificacion.setEstado(rs.getBoolean("STATE"));
                minotificacion.setIdNotificacion(rs.getInt("ID_NOTIFICATION"));
               
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

    public String cambiarEstado(int id,String estado) {
        String consulta = "{Call dbo.cambiarEstadoPermiso ('" +id+ "','"+estado+"')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);
            resultado = "Su acción ha sido registrada.";

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

    public String EliminarEstado(int id) {
       String consulta = "{Call dbo.eliminarNotificacionPermiso('" + id + "')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);

            resultado = "La eliminado correctamente del sistema.";

        } catch (Exception error) {
            resultado = "No se pudo eliminar la notificacion, intentelo de nuevo " + error.getMessage();

        } finally {

            if (stmt != null) {
                try {
                    stmt.close();
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

        return resultado;  }
}
