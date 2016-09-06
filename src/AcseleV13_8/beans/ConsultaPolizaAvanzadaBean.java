package AcseleV13_8.beans;


import org.apache.log4j.Logger;
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
public class ConsultaPolizaAvanzadaBean implements Serializable{

    private final static Logger log = Logger.getLogger(ConsultaPolizaAvanzadaBean.class);

    private String numPoliza;
    private String fechaEmision;
    private String producto;
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
/*    public static BusquedaPolizaAvanzadaBean getBusquedaPolizaAvanzada(){

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
*/
    public static ArrayList getConsultaPolizasAvanzadas() throws SQLException {

        Connection conn = null;
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
                ConsultaPolizaAvanzadaBean consultaPolizaAvanzadaBean = new ConsultaPolizaAvanzadaBean();
                consultaPolizaAvanzadaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                consultaPolizaAvanzadaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                consultaPolizaAvanzadaBean.setProducto(rs.getString("PRODUCTO"));
                consultaPolizaAvanzadaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                consultaPolizaAvanzadaBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                consultaPolizaAvanzadaBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                consultaPolizaAvanzadaBean.setEdoCicloVida(rs.getString("EDO_CICLO_VIDA"));
                consultaPolizaAvanzadaBean.setNumDocIdent(rs.getString("NUM_DOCUMENTO_IDENTIFICACION"));
                consultaPolizaAvanzadaBean.setPasaporte(rs.getString("PASAPORTE"));
                consultaPolizaAvanzadaBean.setTelFijo(rs.getString("TELEFONO_FIJO"));
                consultaPolizaAvanzadaBean.setTipoDocIdent(rs.getString("TIPO_DOC_IDENTIFICACION"));
                consultaPolizaAvanzadaBean.setEmail1(rs.getString("EMAIL_1"));
                consultaPolizaAvanzadaBean.setTelCelular(rs.getString("TELEFONO_CELULAR"));
                polizas.add(consultaPolizaAvanzadaBean);
            }
        }catch(SQLException e){
            log.error(e);
            //conn.close();
        }finally{
        if (conn != null) {
            conn.close();
        }
    }
        return polizas;
    }
}
