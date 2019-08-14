/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccess.ProyectosMapper;
import Entities.Proyecto;
import java.util.ArrayList;

/**
 *
 * @author Tremi
 */
public class ProyectoLogica implements Fabrica {

    private ProyectosMapper proMapper = new ProyectosMapper();

    @Override
    public Object crearObjeto(Object miObjeto) {
        return proMapper.crearProyecto((Proyecto) miObjeto);
    }

    @Override
    public Object modificarObjeto(Object miObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscarObjeto(Object miObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
