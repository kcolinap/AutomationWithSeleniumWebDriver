package AcseleV13_8.beans;


import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by agil on 26/05/2016.
 */
public class BusquedaPolizaAvanzadaBean implements Serializable{

    private String numPoliza;
    private String fechaEmision;
    private String producto;
    /***/
    private String tipoTercero;
    private String primerNombre;
    private String primerApellido;
    private String edoCicloVida;
    private String numDocIdent;
    private String pasaporte;
    private String telFijo;
    private String tipoDocIdent;
    private String email1;
    private String telCelular;

    /***/
    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    /**/
    public String getTipoTercero(){return tipoTercero;}
    public void setTipoTercero(String tipoTercero){this.tipoTercero = tipoTercero;}

    public String getPrimerNombre(){ return primerNombre;}
    public void setPrimerNombre(String primerNombre){this.primerNombre = primerNombre;}

    public String getPrimerApellido(){return primerApellido;}
    public void setPrimerApellido(String primerApellido){this.primerApellido = primerApellido;}

    public String getEdoCicloVida(){return  edoCicloVida;}
    public void setEdoCicloVida(String edoCicloVida){this.edoCicloVida = edoCicloVida;}

    public String getNumDocIdent(){return numDocIdent;}
    public void setNumDocIdent(String numDocIdent){this.numDocIdent = numDocIdent;}

    public String getPasaporte(){return pasaporte;}
    public void setPasaporte(String pasaporte){this.pasaporte = pasaporte;}

    public String getTelFijo(){return telFijo;}
    public void setTelFijo(String telFijo){this.telFijo = telFijo;}

    public String getTipoDocIdent(){return tipoDocIdent;}
    public void setTipoDocIdent(String tipoDocIdent){this.tipoDocIdent = tipoDocIdent;}

    public String getEmail1(){return email1;}
    public void setEmail1(String email1){this.email1 = email1;}

    public String getTelCelular(){return telCelular;}
    public void setTelCelular(String telCelular){this.telCelular = telCelular;}

    /***/
    public static BusquedaPolizaAvanzadaBean getBusquedaPolizaAvanzada(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select NUM_POLIZA, FECHA_EMISION, PRODUCTO from BUSQUEDA_POLIZA");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                busquedaPolizaAvanzadaBean = new BusquedaPolizaAvanzadaBean();
                busquedaPolizaAvanzadaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                busquedaPolizaAvanzadaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                busquedaPolizaAvanzadaBean.setProducto(rs.getString("PRODUCTO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return busquedaPolizaAvanzadaBean;
    }

    public static ArrayList getBusquedaPolizasAvanzadas(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList polizas = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM BUSQUEDA_POLIZA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = new BusquedaPolizaAvanzadaBean();
                busquedaPolizaAvanzadaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                busquedaPolizaAvanzadaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                busquedaPolizaAvanzadaBean.setProducto(rs.getString("PRODUCTO"));
                busquedaPolizaAvanzadaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                busquedaPolizaAvanzadaBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                busquedaPolizaAvanzadaBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                busquedaPolizaAvanzadaBean.setEdoCicloVida(rs.getString("EDO_CICLO_VIDA"));
                busquedaPolizaAvanzadaBean.setNumDocIdent(rs.getString("NUM_DOCUMENTO_IDENTIFICACION"));
                busquedaPolizaAvanzadaBean.setPasaporte(rs.getString("PASAPORTE"));
                busquedaPolizaAvanzadaBean.setTelFijo(rs.getString("TELEFONO_FIJO"));
                busquedaPolizaAvanzadaBean.setTipoDocIdent(rs.getString("TIPO_DOC_IDENTIFICACION"));
                busquedaPolizaAvanzadaBean.setEmail1(rs.getString("EMAIL_1"));
                busquedaPolizaAvanzadaBean.setTelCelular(rs.getString("TELEFONO_CELULAR"));
                polizas.add(busquedaPolizaAvanzadaBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return polizas;
    }
}
