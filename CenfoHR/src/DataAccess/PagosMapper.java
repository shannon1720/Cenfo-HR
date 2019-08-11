/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.DriverManager;

/**
 *
 * @author franciscosandoval
 */
public class PagosMapper extends SqlConnection {

    public int obtenerHorasLaborasPorFecha(String id_persona) {
        String consulta = "{Call dbo.obtener_horas_laboradas ('" + id_persona + "')}";
        int resultado = 0;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                resultado = rs.getInt("TOTAL_HOURS");
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

}
