/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import BusinessLayer.Fabrica;
import Entities.MediaPersonal;
import Entities.Personal;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersonalMapper extends SqlConnection implements Fabrica {

    @Override
    public Object crearObjeto(Object miObjeto) {
        Personal miPersonal = (Personal) miObjeto;
        String consulta = "{Call dbo.crear_personal('" + miPersonal.getIdentificacion() + "','" + miPersonal.getNombre() + "','" + miPersonal.getApellidoUno() + "','" + miPersonal.getApellidoDos() + "','" + miPersonal.getFechaNacimiento()
                + "','" + miPersonal.getFechaIngreso() + "','" + miPersonal.getGenero() + "','" + miPersonal.getContrasenna() + "','" + miPersonal.getGrado_academico() + "','" + miPersonal.getRol() + "','" + miPersonal.getMiMedia().getUrl() + "','" + miPersonal.getMiMedia().getTipo() + "')}";
        String resultado = "";
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);

            resultado = "La persona se registró correctamente en el sistema.";

        } catch (Exception error) {
            resultado = "No se pudo registrar la persona, intentelo de nuevo " + error.getMessage();

        } finally {

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
        return resultado;
    }

    @Override
    public Object modificarObjeto(Object miObjeto) {
        Personal miPersonal = (Personal) miObjeto;
        
        System.out.println("Id "+ miPersonal.getIdentificacion());
        System.out.println("Nombre "+ miPersonal.getNombre());
        System.out.println("Apellido 1 "+ miPersonal.getApellidoUno());
        System.out.println("Apellido 2 "+ miPersonal.getApellidoDos());
        System.out.println("Cumple "+ miPersonal.getFechaNacimiento());
        System.out.println("Fecha "+ miPersonal.getFechaIngreso());
        System.out.println("Gen "+ miPersonal.getGenero());
        System.out.println("Pass "+ miPersonal.getContrasenna());
        System.out.println("Grado "+ miPersonal.getGrado_academico());
        System.out.println("Rol "+ miPersonal.getRol());
        
        String consulta = "{Call dbo.modificar_personal('" + miPersonal.getIdentificacion() + "','" + miPersonal.getNombre() 
                + "','" + miPersonal.getApellidoUno() + "','" + miPersonal.getApellidoDos()
                + "','" + miPersonal.getGenero() + "','" + miPersonal.getContrasenna()
                + "')}";
        String resultado = "";
        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            stmt.execute(consulta);

            resultado = "La persona se modifico correctamente en el sistema.";

        } catch (Exception error) {
            resultado = "No se pudo modificar la persona, intentelo de nuevo " + error.getMessage();

        } finally {

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
        return resultado;
    }

    @Override
    public Object buscarObjeto(Object miObjeto) {
        Personal miPersonal = null, miPersonal2 = (Personal) miObjeto;
        String consulta = "{Call dbo.buscarPersonal('" + miPersonal2.getIdentificacion() + "','" + miPersonal2.getContrasenna() + "')}";
        Object buscarPersonal = null;

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);
            buscarPersonal = new Object();

            while (rs.next()) {
                miPersonal = new Personal();
                miPersonal.setIdentificacion(rs.getString("ID"));
                miPersonal.setNombre(rs.getString("NAME"));
                miPersonal.setApellidoUno(rs.getString("LAST_NAME_1"));
                miPersonal.setApellidoDos(rs.getString("LAST_NAME_2"));
                miPersonal.setRol(rs.getInt("ID_ROL"));
                miPersonal.setGenero(rs.getString("SEX"));
                miPersonal.setGrado_academico(rs.getInt("ID_ACADEMIC_DEGREE"));
                miPersonal.setFechaIngreso(rs.getDate("ADMISSION_DATE"));
                miPersonal.setFechaNacimiento(rs.getDate("BIRTHDAY"));
                MediaPersonal mimedia = new MediaPersonal(rs.getInt("ID_MEDIA"));
                miPersonal.setMiMedia(mimedia);
                buscarPersonal = miPersonal;
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
        return buscarPersonal;
    }

    @Override
    public ArrayList<Object> listarObjeto() {
        Personal miPersonal = null;
        String consulta = "{Call dbo.listar_personal()}";
        ArrayList<Object> listaPersonal = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(connectionUrl);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                miPersonal = new Personal();
                miPersonal.setIdentificacion(rs.getString("ID"));
                miPersonal.setNombre(rs.getString("NAME"));
                miPersonal.setApellidoUno(rs.getString("LAST_NAME_1"));
                miPersonal.setApellidoDos(rs.getString("LAST_NAME_2"));
                miPersonal.setRol(rs.getInt("ID_ROL"));
                miPersonal.setGenero(rs.getString("SEX"));
                miPersonal.setGrado_academico(rs.getInt("ID_ACADEMIC_DEGREE"));
                miPersonal.setFechaIngreso(rs.getDate("ADMISSION_DATE"));
                miPersonal.setFechaNacimiento(rs.getDate("BIRTHDAY"));
                MediaPersonal mimedia = new MediaPersonal(rs.getInt("ID_MEDIA"));
                miPersonal.setMiMedia(mimedia);
                listaPersonal.add(miPersonal);
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
        return listaPersonal;
    }

    @Override
    public String eliminarObjeto(Object miOnjeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
