/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Entities.PermisoSalida;
import Entities.Personal;
import Entities.Proyecto;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tremi
 */
public class ProyectosMapper extends SqlConnection {

    public String crearProyecto(Object pObj) {
        Proyecto pProy = (Proyecto) pObj;
        String consulta = "{Call dbo.crear_proyecto ('" + pProy.getCodigo() + "','"
                + pProy.getNombre() + "','" + pProy.getFechaInicio() + "','"
                + pProy.getFechaFin() + "','" + pProy.getDescripcion() + "','"
                + pProy.getEstado() + "')}";
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
    
        public Proyecto buscarProyecto(Object pObj) throws SQLException {
        Proyecto pProy = (Proyecto)pObj;
        String consulta = "{Call dbo.buscarProyecto ('" + pProy.getCodigo()+ "')}";
        
        conn = DriverManager.getConnection(connectionUrl);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(consulta);
        Proyecto foundProy =  null;
        while (rs.next()) {
            foundProy = new Proyecto();
            foundProy.setCodigo(rs.getInt("ID_PROYECT"));
            foundProy.setNombre(rs.getString("NOMBRE"));
            foundProy.setFechaInicio(rs.getDate("START_DATE"));
            foundProy.setFechaFin(rs.getDate("FINAL_DATE"));
            foundProy.setDescripcion(rs.getString("DESCRIPTION"));
            foundProy.setEstado(rs.getInt("STATE"));

        }
        return foundProy;
    }

    public ArrayList<Proyecto> listarProyectos(String pObj) throws SQLException {
        String consulta = "{Call dbo.listarproyectos ('" +pObj +"')}";
        Proyecto proy = null ;
        ArrayList<Proyecto> lstProy = new ArrayList<>();

        conn = DriverManager.getConnection(connectionUrl);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(consulta);

        while (rs.next()) {
            proy = new Proyecto();
            proy.setCodigo(rs.getInt("ID_PROYECT"));
            proy.setNombre(rs.getString("NOMBRE"));
            proy.setFechaInicio(rs.getDate("START_DATE"));
            proy.setFechaFin(rs.getDate("FINAL_DATE"));
            proy.setDescripcion(rs.getString("DESCRIPTION"));
            proy.setEstado(rs.getInt("STATE"));

            lstProy.add(proy);
        }
        return lstProy;
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
