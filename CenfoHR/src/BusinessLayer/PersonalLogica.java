/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccess.PersonalMapper;
import Entities.Personal;
import java.util.ArrayList;

/**
 *
 * @author Alriosa
 */
public class PersonalLogica implements leaf{
    ArrayList<Personal> lstPersonal=new ArrayList<>();
    private PersonalMapper miPersona= new PersonalMapper();
    public PersonalLogica() {
    }
    @Override
    public Object crearObjeto(Object miObjeto) {
        return miPersona.crearPersonal(miObjeto);
    }

    @Override
    public Object buscarObjeto(Object miObjeto) {
        return miPersona.buscarPersona(miObjeto);
    }

    @Override
    public ArrayList<Object> listarObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarObjeto(Object miOnjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
