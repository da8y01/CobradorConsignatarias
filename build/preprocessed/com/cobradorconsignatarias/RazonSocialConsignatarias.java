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
public class RazonSocialConsignatarias {

    private String Zona;
    private String NombreRuta;
    private String Consignataria;
    private String Codigo;
    private String Agencia;
    private int Visitado;
    private Vector VectorFacturas;
    private String Message;


    public RazonSocialConsignatarias() {
        //JSONStringToObject(sJSON);
    }


    public String GetZona() {
        return this.Zona;
    }

    public void SetZona(String zona) {
        this.Zona = zona;
    }


    public String GetNombreRuta() {
        return this.NombreRuta;
    }

    public void SetNombreRuta(String nombreruta) {
        this.NombreRuta = nombreruta;
    }


    public String GetConsignataria() {
        return this.Consignataria;
    }

    public void SetConsignataria(String consignataria) {
        this.Consignataria = consignataria;
    }


    public String GetCodigo() {
        return this.Codigo;
    }

    public void SetCodigo(String codigo) {
        this.Codigo = codigo;
    }


    public String GetAgencia() {
        return this.Agencia;
    }

    public void SetAgencia(String agencia) {
        this.Agencia = agencia;
    }


    public int GetVisitado() {
        return this.Visitado;
    }

    public void SetVisitado(int visitado) {
        this.Visitado = visitado;
    }


    public Vector GetVectorFacturas() {
        return this.VectorFacturas;
    }

    public void SetVectorFacturas(Vector facturas) {
        this.VectorFacturas = facturas;
    }


    public String GetMessage() {
        return this.Message;
    }

    public void SetMessage(String message) {
        this.Message = message;
    }

}
