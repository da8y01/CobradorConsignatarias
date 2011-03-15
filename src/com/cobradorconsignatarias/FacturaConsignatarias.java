/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cobradorconsignatarias;

import java.util.Vector;

/**
 *
 * @author Admin
 */
public class FacturaConsignatarias {

    private String NoFactura;
    private String FechaPago;
    private int Total;
    private int Visitado;
    private int Compendio;
    private Vector VectorFechas;


    public FacturaConsignatarias() {

    }


    public String GetNoFactura() {
        return this.NoFactura;
    }

    public void SetNoFactura(String nofactura) {
        this.NoFactura = nofactura;
    }


    public String GetFechaPago() {
        return this.FechaPago;
    }

    public void SetFechaPago(String fechapago) {
        this.FechaPago = fechapago;
    }


    public int GetTotal() {
        return this.Total;
    }

    public void SetTotal(int total) {
        this.Total = total;
    }


    public int GetVisitado() {
        return this.Visitado;
    }

    public void SetVisitado(int visitado) {
        this.Visitado = visitado;
    }


    public int GetCompendio() {
        return this.Compendio;
    }

    public void SetCompendio(int compendio) {
        this.Compendio = compendio;
    }


    public Vector GetVectorFechas() {
        return this.VectorFechas;
    }

    public void SetVectorFechas(Vector fechas) {
        this.VectorFechas = fechas;
    }

}
