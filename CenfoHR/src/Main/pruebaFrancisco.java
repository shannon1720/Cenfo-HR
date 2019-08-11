/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DataAccess.*;

/**
 *
 * @author franciscosandoval
 */
public class pruebaFrancisco {

    /**
     * @param args the command line arguments
     */
    
    private static PagosMapper miMapper=new PagosMapper();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        miMapper.obtenerHorasLaborasPorFecha("114070249");
        
    }
    
}
