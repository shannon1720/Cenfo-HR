/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.DriverManager;
import Entities.Pagos;
import java.util.ArrayList;
/**
 *
 * @author franciscosandoval
 */
public class PagosMapper extends SqlConnection {
    
    //Lista de horas registradas en el sistema, agrupada por mes y anho
    private static ArrayList<Pagos> lstPagos = new ArrayList<Pagos>();

    public ArrayList<Pagos> obtenerHorasLaborasPorFecha(String id_persona) {
        String consulta = "{Call dbo.obtener_horas_laboradas ('" + id_persona + "')}";
        Pagos tmpPago;
        int totalHoras = 0;
        String mes = "";
        int anho = 0;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            while (rs.next()) {
                totalHoras = rs.getInt("TOTAL_HOURS");
                mes = rs.getString("MonthName");
                anho = rs.getInt("ANHO");
                tmpPago = new Pagos(totalHoras,mes,anho);
                //Output de prueba, para validar los datos estan siendo obtenidos correctamente
                System.out.println("Fecha >> "+ "MES:" + tmpPago.getMes() + " ANHO:" + tmpPago.getAnho());
                System.out.println("Horas laboradas: " + tmpPago.getTotalHorasPorMes());
                lstPagos.add(tmpPago);
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

        return lstPagos;

    }

}
