/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccess.ProyectosMapper;
import Entities.Proyecto;
import java.sql.SQLException;
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

    
  
    public Object buscarProy(Object miObjeto) throws SQLException {
        return proMapper.buscarProyecto(miObjeto);
    }


    public ArrayList<Proyecto> listarProyectos(String pObj) throws SQLException {
        return  proMapper.listarProyectos(pObj);
    }

    @Override
    public String eliminarObjeto(Object miOnjeto) {
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

}
