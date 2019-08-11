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
    
    private int totalHorasPorMes;
    private String mes;
    private int anho;
    private int montoPagoPorHora;
    private int totalAPagar;

    public Pagos() {
    }

    public Pagos(int totalHorasPorMes, String mes, int anho) {
        this.totalHorasPorMes = totalHorasPorMes;
        this.mes = mes;
        this.anho = anho;
    }

    public int getTotalHorasPorMes() {
        return totalHorasPorMes;
    }

    public void setTotalHorasPorMes(int totalHorasPorMes) {
        this.totalHorasPorMes = totalHorasPorMes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public int getMontoPagoPorHora() {
        return montoPagoPorHora;
    }

    public void setMontoPagoPorHora(int montoPagoPorHora) {
        this.montoPagoPorHora = montoPagoPorHora;
    }

    public int getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(int totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    @Override
    public String toString() {
        return "Pagos{" + "totalHorasPorMes=" + totalHorasPorMes + ", mes=" + mes + ", anho=" + anho + ", montoPagoPorHora=" + montoPagoPorHora + ", totalAPagar=" + totalAPagar + '}';
    }

}
