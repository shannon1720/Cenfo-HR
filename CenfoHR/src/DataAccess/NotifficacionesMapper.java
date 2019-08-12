/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.Notificacion;

import java.sql.DriverManager;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class NotifficacionesMapper extends SqlConnection {

    public String crearNotificaciones(Notificacion miNotificacion) {
        java.sql.Date date2 = new java.sql.Date(miNotificacion.getFechaNotificacion().getTime());
        String consulta = "{Call dbo.crear_notificacion ('" + miNotificacion.getAsunto() + "','" + miNotificacion.getRemitente() + "','" + date2 + "', '" + miNotificacion.getEstado() + "')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);

            resultado = "La notificacion se registró correctamente en el sistema.";

        } catch (Exception error) {
            resultado = "No se pudo registrar la notificacion, intentelo de nuevo " + error.getMessage();

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

        return resultado;
    }

    public int obtenerUltimaNotificacion() {

        String consulta = "{Call dbo.obtener_ultimo_id}";
        int resultado = 0;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getInt("ID_NOTIFICATION");
                System.out.println(resultado);
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

        return resultado;
    }

    public ArrayList<Notificacion> listarNotificaciones() {
    ArrayList<Notificacion> listarNotificaciones = null;
    Notificacion miNotificacion = null;
     String consulta = "{Call dbo.listarNotificaciones}";
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            listarNotificaciones =new ArrayList<>();
           
            while (rs.next()) {
                miNotificacion = new Notificacion();
                miNotificacion.setId(rs.getInt("ID_NOTIFICATION"));
                miNotificacion.setAsunto(rs.getString("SUBJECT"));
                miNotificacion.setFechaNotificacion(rs.getDate("DATE_NOTIFICATION"));
                miNotificacion.setRemitente(rs.getString("FROM_PERSONAL"));
                miNotificacion.setEstado(rs.getBoolean("STATE"));
                miNotificacion.setPara(rs.getString("ID_PERSONAL"));
                listarNotificaciones.add(miNotificacion);
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

        return listarNotificaciones;
    }

    public Notificacion buscarNotificacione(String code) {
        return null;
    }

    public String CambiarEstado(int code) {
        String consulta = "{Call dbo.cambiarEstadoNotificacion ('" + code + "')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);

            resultado = "La notificacion se registró correctamente en el sistema.";

        } catch (Exception error) {
            resultado = "No se pudo registrar la notificacion, intentelo de nuevo " + error.getMessage();

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

        return resultado;
    }

    public String eliminarNotificacion(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
