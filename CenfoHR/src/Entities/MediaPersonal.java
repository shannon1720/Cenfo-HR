/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Usuario
 */
public class MediaPersonal {
    private int id;
    private String url;
    private String tipo;

    public MediaPersonal(int id, String url, String tipo) {
        this.id = id;
        this.url = url;
        this.tipo = tipo;
    }

    public MediaPersonal(int aInt) {
    this.id=aInt;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     
}
