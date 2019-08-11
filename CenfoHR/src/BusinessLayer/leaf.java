/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface leaf {
    public Object crearObjeto(Object miObjeto);
    public Object buscarObjeto(Object miObjeto);
    public ArrayList<Object> listarObjeto();
    public String eliminarObjeto(Object miOnjeto);
    
}
