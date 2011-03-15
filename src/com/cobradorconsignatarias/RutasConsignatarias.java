/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cobradorconsignatarias;

import java.util.Vector;
import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

/**
 *
 * @author Admin
 */
public class RutasConsignatarias {
    
    private String Message;

    private Vector VectorRutas;


    public RutasConsignatarias(String sJSON) {
        JSONStringToObject(sJSON);
    }

    public RutasConsignatarias() {
    }


    public String GetMessage() {
        return this.Message;
    }

    public void SetMessage(String message) {
        this.Message = message;
    }


    public Vector GetVectorRutas() {
        return this.VectorRutas;
    }

    public void SetVectorRutas(Vector vectorrutas) {
        this.VectorRutas = vectorrutas;
    }


    public void JSONStringToObject(String sJSONin) {
        try {
            JSONObject main = new JSONObject(sJSONin);
            if (main != null) {
                JSONArray jaRutas = main.getJSONArray("rutasconsignatarias");
                Vector vRutas = new Vector();
                if (jaRutas != null) {
                    for (int i = 0; i < jaRutas.length(); i++) {
                        JSONObject joRuta = jaRutas.getJSONObject(i);

                        JSONArray jaRazonesSociales = joRuta.getJSONArray("razonessociales");
                        Vector vRazonesSociales = new Vector();
                        if (jaRazonesSociales != null) {
                            for (int m = 0; m < jaRazonesSociales.length(); m++) {
                                JSONObject joRazonSocial = jaRazonesSociales.getJSONObject(m);

                                JSONArray jaFacturas = joRazonSocial.getJSONArray("facturas");
                                Vector vFacturas = new Vector();
                                if (jaFacturas != null) {
                                    //Vector vExpendios = new Vector();
                                    for (int j = 0; j < jaFacturas.length(); j++) {
                                        JSONObject joFactura = jaFacturas.getJSONObject(j);

                                        JSONArray jaFechas = joFactura.getJSONArray("fechas");
                                        Vector vFechas = new Vector();
                                        if (jaFechas != null) {
                                            //Vector vFechas = new Vector();
                                            for (int k = 0; k < jaFechas.length(); k++) {
                                                JSONObject joFecha = jaFechas.getJSONObject(k);

                                                FechaConsignatarias fechaconsignatarias = new FechaConsignatarias();

                                                String sFecha = joFecha.getString("FECHA");
                                                fechaconsignatarias.SetFecha(sFecha);

                                                int iEntregados = 0;
                                                //String sEntregados = (String) joFecha.get("ENTREGADOS");
                                                iEntregados = joFecha.getInt("ENTR");
                                                //if (!(sEntregados == null) && !(sEntregados.equalsIgnoreCase(""))) {
                                                //iEntregados = Integer.parseInt(sEntregados);
                                                //}
                                                fechaconsignatarias.SetEntregados(iEntregados);

                                                int iDevueltos = 0;
                                                //String sDevueltos = (String) joFecha.get("DEVUELTOS");
                                                iDevueltos = joFecha.getInt("DEVOL");
                                                //if (!(sDevueltos == null) && !(sDevueltos.equalsIgnoreCase(""))) {
                                                //iDevueltos = Integer.parseInt(sDevueltos);
                                                //}
                                                fechaconsignatarias.SetDevueltos(iDevueltos);

                                                int iEjemVend = 0;
                                                //String sDevueltos = (String) joFecha.get("DEVUELTOS");
                                                iEjemVend = joFecha.getInt("EJEMVEND");
                                                //if (!(sDevueltos == null) && !(sDevueltos.equalsIgnoreCase(""))) {
                                                //iDevueltos = Integer.parseInt(sDevueltos);
                                                //}
                                                fechaconsignatarias.SetEjemVend(iEjemVend);

                                                fechaconsignatarias.SetFaltantes(joFecha.getInt("FALTANTES"));

                                                fechaconsignatarias.SetSobrantes(joFecha.getInt("SOBRANTES"));

                                                int iValorUnitario = 0;
                                                //String sFaltantes = (String) joFecha.get("VALOR UNITARIO");
                                                iValorUnitario = joFecha.getInt("VALORUNITARIO");
                                                //if (!(sFaltantes == null) && !(sFaltantes.equalsIgnoreCase(""))) {
                                                //iFaltantes = Integer.parseInt(sFaltantes);
                                                //}
                                                fechaconsignatarias.SetValorUnitario(iValorUnitario);

                                                int iValorTotal = 0;
                                                //String sValor = (String) joFecha.get("VALOR");
                                                iValorTotal = joFecha.getInt("VALORTOTAL");
                                                //if (!(sValor == null) && !(sValor.equalsIgnoreCase(""))) {
                                                //iValor = Integer.parseInt(sValor);
                                                //}
                                                fechaconsignatarias.SetValorTotal(iValorTotal);

                                                fechaconsignatarias.SetVisitado(joFecha.getInt("VISITADO"));

                                                fechaconsignatarias.SetCobrado(joFecha.getInt("COBRADO"));

                                                vFechas.addElement(fechaconsignatarias);
                                            }
                                        }

                                        FacturaConsignatarias facturaconsignatarias = new FacturaConsignatarias();

                                        String sNoFactura = joFactura.getString("NOFACTURA");
                                        facturaconsignatarias.SetNoFactura(sNoFactura);

                                        String sFePago = joFactura.getString("FEPAGO");
                                        facturaconsignatarias.SetFechaPago(sFePago);

                                        int iTotal = joFactura.getInt("TOTAL");
                                        facturaconsignatarias.SetTotal(iTotal);

                                        facturaconsignatarias.SetVisitado(joFactura.getInt("VISITADO"));

                                        facturaconsignatarias.SetCompendio(joFactura.getInt("COMPENDIO"));

                                        facturaconsignatarias.SetVectorFechas(vFechas);

                                        vFacturas.addElement(facturaconsignatarias);
                                    }
                                }

                                RazonSocialConsignatarias razonsocialconsignatarias = new RazonSocialConsignatarias();

                                String sZona = joRazonSocial.getString("ZONA");
                                razonsocialconsignatarias.SetZona(sZona);

                                String sNombreRuta = joRazonSocial.getString("NOMBRERUTA");
                                razonsocialconsignatarias.SetNombreRuta(sNombreRuta);

                                String sConsignataria = joRazonSocial.getString("CONSIGNATARIA");
                                razonsocialconsignatarias.SetConsignataria(sConsignataria);

                                String sCodigo = joRazonSocial.getString("CODIGO");
                                razonsocialconsignatarias.SetCodigo(sCodigo);

                                String sAgencia = joRazonSocial.getString("AGENCIA");
                                razonsocialconsignatarias.SetAgencia(sAgencia);

                                razonsocialconsignatarias.SetVisitado(joRazonSocial.getInt("VISITADO"));

                                razonsocialconsignatarias.SetVectorFacturas(vFacturas);

                                //vRazonesSociales.add(razonsocialconsignatarias);
                                vRazonesSociales.addElement(razonsocialconsignatarias);
                            }
                        }

                        RutaConsignatarias rutaconsignatarias = new RutaConsignatarias();

                        String sFecha = joRuta.getString("FECHA");
                        rutaconsignatarias.SetFecha(sFecha);

                        String sCobrador = joRuta.getString("COBRADOR");
                        rutaconsignatarias.SetCobrador(sCobrador);

                        String sProducto = joRuta.getString("PRODUCTO");
                        rutaconsignatarias.SetProducto(sProducto);

                        rutaconsignatarias.SetVectorRazonSocial(vRazonesSociales);

                        vRutas.addElement(rutaconsignatarias);
                    }
                }

                SetVectorRutas(vRutas);
            }

            SetMessage("[*] JSONStringToObject() executed.");
        } catch (JSONException jsonex) {
            SetMessage(jsonex.toString());
            jsonex.printStackTrace();
        } catch (Exception ex) {
            SetMessage(ex.toString());
            ex.printStackTrace();
        }
    }


    public String JSONObjectToString() {
        JSONObject main = new JSONObject();

        try {

            JSONArray jaRutas = new JSONArray();
            for (int i = 0; i < GetVectorRutas().size(); i++) {
                RutaConsignatarias rutaconsignatarias = (RutaConsignatarias) GetVectorRutas().elementAt(i);
                JSONObject joRuta = new JSONObject();
                joRuta.put("COBRADOR", rutaconsignatarias.GetCobrador());
                joRuta.put("PRODUCTO", rutaconsignatarias.GetProducto());
                joRuta.put("FECHA", rutaconsignatarias.GetFecha());

                JSONArray jaRazonesSociales = new JSONArray();
                for (int m = 0; m < rutaconsignatarias.GetVectorRazonSocial().size(); m++) {
                    RazonSocialConsignatarias razonsocialconsignatarias = (RazonSocialConsignatarias) rutaconsignatarias.GetVectorRazonSocial().elementAt(m);
                    JSONObject joRazonSocial = new JSONObject();
                    joRazonSocial.put("ZONA", razonsocialconsignatarias.GetZona());
                    joRazonSocial.put("NOMBRERUTA", razonsocialconsignatarias.GetNombreRuta());
                    joRazonSocial.put("CONSIGNATARIA", razonsocialconsignatarias.GetConsignataria());
                    joRazonSocial.put("CODIGO", razonsocialconsignatarias.GetCodigo());
                    joRazonSocial.put("AGENCIA", razonsocialconsignatarias.GetAgencia());
                    joRazonSocial.put("VISITADO", razonsocialconsignatarias.GetVisitado());

                    JSONArray jaFacturas = new JSONArray();
                    for (int j = 0; j < razonsocialconsignatarias.GetVectorFacturas().size(); j++) {
                        FacturaConsignatarias facturaconsignatarias = (FacturaConsignatarias) razonsocialconsignatarias.GetVectorFacturas().elementAt(j);
                        JSONObject joFactura = new JSONObject();
                        joFactura.put("NOFACTURA", facturaconsignatarias.GetNoFactura());
                        joFactura.put("FEPAGO", facturaconsignatarias.GetFechaPago());
                        joFactura.put("TOTAL", facturaconsignatarias.GetTotal());
                        joFactura.put("VISITADO", facturaconsignatarias.GetVisitado());
                        joFactura.put("COMPENDIO", facturaconsignatarias.GetCompendio());

                        JSONArray jaFechas = new JSONArray();
                        for (int k = 0; k < facturaconsignatarias.GetVectorFechas().size(); k++) {
                            FechaConsignatarias fechaconsignatarias = (FechaConsignatarias) facturaconsignatarias.GetVectorFechas().elementAt(k);
                            JSONObject joFecha = new JSONObject();
                            joFecha.put("FECHA", fechaconsignatarias.GetFecha());
                            joFecha.put("ENTR", fechaconsignatarias.GetEntregados());
                            joFecha.put("DEVOL", fechaconsignatarias.GetDevueltos());
                            joFecha.put("EJEMVEND", fechaconsignatarias.GetEjemVend());
                            joFecha.put("FALTANTES", fechaconsignatarias.GetFaltantes());
                            joFecha.put("SOBRANTES", fechaconsignatarias.GetSobrantes());
                            joFecha.put("VALORUNITARIO", fechaconsignatarias.GetValorUnitario());
                            joFecha.put("VALORTOTAL", fechaconsignatarias.GetValorTotal());
                            joFecha.put("VISITADO", fechaconsignatarias.GetVisitado());
                            joFecha.put("COBRADO", fechaconsignatarias.GetCobrado());

                            jaFechas.put(joFecha);
                        }

                        joFactura.put("fechas", jaFechas);
                        jaFacturas.put(joFactura);
                    }

                    joRazonSocial.put("facturas", jaFacturas);
                    jaRazonesSociales.put(joRazonSocial);
                }

                joRuta.put("razonessociales", jaRazonesSociales);
                jaRutas.put(joRuta);
            }

            main.put("rutasconsignatarias", jaRutas);

            //System.out.println(main.toString());
        } catch (JSONException jsonex) {
            SetMessage(jsonex.toString());
            jsonex.printStackTrace();
        } catch (Exception ex) {
            SetMessage(ex.toString());
            ex.printStackTrace();
        }

        return main.toString();
    }

}
