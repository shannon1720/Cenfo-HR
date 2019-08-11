/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;
import java.sql.*;
/**
 *
 * @author Alriosa
 */
public class SqlConnection {
    String connectionUrl = "jdbc:sqlserver://SHANNON1720;DatabaseName=DB_CENFO_HR;integratedsecurity = true";
    
    //String de connecion de Daniela >> String connectionUrl = "jdbc:sqlserver://SHANNON1720;DatabaseName=DB_CENFO_HR;integratedsecurity = true";
    //String de connecion de Francisco >> "jdbc:sqlserver://localhost:1433;databaseName=DBPrueba;user=sa;password=reallyStrongPwd123";
    
    protected Connection conn = null;
    protected Statement stmt = null;
    protected ResultSet rs = null;
    protected CallableStatement cst =null;
     
     
}
