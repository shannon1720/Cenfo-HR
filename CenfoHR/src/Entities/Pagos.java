/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author franciscosandoval
 */
public class Pagos {

    private String mes;
    private Integer anho;
    private Integer totalHorasPorMes;
    private Integer montoPagoPorHora = 3000;
    private Integer totalAPagar;

    public Pagos() {
    }

    public Pagos(String mes, Integer anho, Integer totalHorasPorMes) {
        this.mes = mes;
        this.anho = anho;
        this.totalHorasPorMes = totalHorasPorMes;
    }

    public Integer getTotalHorasPorMes() {
        return totalHorasPorMes;
    }

    public void setTotalHorasPorMes(Integer totalHorasPorMes) {
        this.totalHorasPorMes = totalHorasPorMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Integer getMontoPagoPorHora() {
        return montoPagoPorHora;
    }

    public void setMontoPagoPorHora(Integer montoPagoPorHora) {
        this.montoPagoPorHora = montoPagoPorHora;
    }

    public Integer getTotalAPagar() {
        return this.montoPagoPorHora*this.totalHorasPorMes;
    }

    public void setTotalAPagar(Integer totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    @Override
    public String toString() {
        return "Pagos{" + "totalHorasPorMes=" + totalHorasPorMes + ", mes=" + mes + ", anho=" + anho + ", montoPagoPorHora=" + montoPagoPorHora + ", totalAPagar=" + totalAPagar + '}';
    }

}
