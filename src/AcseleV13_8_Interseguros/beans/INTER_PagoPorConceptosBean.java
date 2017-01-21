package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 19/01/2017.
 */
public class INTER_PagoPorConceptosBean {

    private final static Logger log = Logger.getLogger(INTER_PagoPorConceptosBean.class);

    private String numeroSiniestro;
    private String numeroPoliza;
    private String fechaOcurrenciaSin;
    private String producto;
    private String ordenarPor;
    private String cobertura;
    private String montoReserva;
    private String numeroDocIdent;
    private String montoSiniestro;
    private String seleccioneAccion;

    public String getNumeroSiniestro() {return numeroSiniestro;}
    public void setNumeroSiniestro(String numeroSiniestro) {this.numeroSiniestro = numeroSiniestro;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza(String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getFechaOcurrenciaSin() {return fechaOcurrenciaSin;}
    public void setFechaOcurrenciaSin(String fechaOcurrenciaSin) {this.fechaOcurrenciaSin = fechaOcurrenciaSin;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getCobertura() {return cobertura;}
    public void setCobertura(String cobertura) {this.cobertura = cobertura;}

    public String getMontoReserva() {return montoReserva;}
    public void setMontoReserva(String montoReserva) {this.montoReserva = montoReserva;}

    public String getNumeroDocIdent() {return numeroDocIdent;}
    public void setNumeroDocIdent(String numeroDocIdent) {this.numeroDocIdent = numeroDocIdent;}

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro(String montoSiniestro) {this.montoSiniestro = montoSiniestro;}

    public String getSeleccioneAccion() {return seleccioneAccion;}
    public void setSeleccioneAccion(String seleccioneAccion) {this.seleccioneAccion = seleccioneAccion;}


    public static ArrayList getINTER_PagoPorConceptos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interPagoConceptos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,numero_Siniestro, numero_Poliza,fecha_Ocurrencia_Sin,producto,ordenar_Por,cobertura,monto_Reserva,numero_Doc_Ident,monto_Siniestro,seleccione_Accion FROM INTER_PAGO_CONCEPTOS ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_PagoPorConceptosBean inter_pagoPorConceptosBean= new INTER_PagoPorConceptosBean();

                inter_pagoPorConceptosBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_pagoPorConceptosBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_pagoPorConceptosBean.setFechaOcurrenciaSin(rs.getString("NUMERO_POLIZA"));
                inter_pagoPorConceptosBean.setProducto(rs.getString("PRODUCTO"));
                inter_pagoPorConceptosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_pagoPorConceptosBean.setCobertura(rs.getString("COBERTURA"));
                inter_pagoPorConceptosBean.setMontoReserva(rs.getString("MONTO_RESERVA"));
                inter_pagoPorConceptosBean.setNumeroDocIdent(rs.getString("NUMERO_DOC_IDENT"));
                inter_pagoPorConceptosBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));
                inter_pagoPorConceptosBean.setSeleccioneAccion(rs.getString("SELECCIONE_ACCION"));

                interPagoConceptos.add(inter_pagoPorConceptosBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interPagoConceptos;

    }
}
