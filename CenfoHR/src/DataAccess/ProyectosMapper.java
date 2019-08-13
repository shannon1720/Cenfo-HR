/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.PermisoSalida;
import Entities.Proyecto;
import java.sql.DriverManager;

/**
 *
 * @author Tremi
 */
public class ProyectosMapper extends SqlConnection {
    
    public String crearProyecto(Object pObj) {
        Proyecto pProy = (Proyecto)pObj;
        String consulta = "{Call dbo.crear_proyecto ('" + pProy.getCodigo() + "','"
                + pProy.getNombre() + "','" + pProy.getFechaInicio() + "','"
                + pProy.getFechaFin() + "','" + pProy.getDescripcion()+ "','"
                + pProy.getEstado() +  "')}";
        String resultado;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);
            resultado = "Proyecto creado con exito.";

        } catch (Exception error) {
            resultado = "Error al crear proyecto, intentelo de nuevo " + error.getMessage();

        } 
        closeConnections();
        return resultado;
    }

    private void closeConnections() {
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
}
