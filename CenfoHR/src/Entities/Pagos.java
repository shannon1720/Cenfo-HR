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
    private String mesAnho;
    private int montoPagoPorHora;
    private int totalAPagar;

    public Pagos() {
    }

    public Pagos(int totalHorasPorMes, String mesAnho) {
        this.totalHorasPorMes = totalHorasPorMes;
        this.mesAnho = mesAnho;
    }

    public int getTotalHorasPorMes() {
        return totalHorasPorMes;
    }

    public void setTotalHorasPorMes(int totalHorasPorMes) {
        this.totalHorasPorMes = totalHorasPorMes;
    }

    public String getMesAnho() {
        return mesAnho;
    }

    public void setMesAnho(String mesAnho) {
        this.mesAnho = mesAnho;
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
        return "Pagos{" + "totalHorasPorMes=" + totalHorasPorMes + ", mesAnho=" + mesAnho + ", montoPagoPorHora=" + montoPagoPorHora + ", totalAPagar=" + totalAPagar + '}';
    }
    
}
