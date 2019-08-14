/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface Fabrica {
   
    public Object crearObjeto(Object miObjeto);
    public Object buscarObjeto(Object miObjeto);
    public Object modificarObjeto(Object miObjeto);
    public ArrayList<Object> listarObjeto();
    public String eliminarObjeto(Object miOnjeto);
    
}
