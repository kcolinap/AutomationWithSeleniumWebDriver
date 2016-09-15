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
 * Created by kzambrano on 13/09/2016.
 */
public class PagoPorConceptosBean implements Serializable {

    private final static Logger log = Logger.getLogger(PagoPorConceptosBean.class);

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
    public void setNumeroSiniestro (String numeroSiniestro) {this.numeroSiniestro = numeroSiniestro;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza (String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getFechaOcurrenciaSin() {return fechaOcurrenciaSin;}
    public void setFechaOcurrenciaSin (String fechaOcurrenciaSin) {this.fechaOcurrenciaSin = fechaOcurrenciaSin;}

    public String getProducto() {return producto;}
    public void setProducto (String producto) {this.producto = producto;}

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor (String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getCobertura() {return cobertura;}
    public void setCobertura (String cobertura) {this.cobertura = cobertura;}

    public String getMontoReserva() {return montoReserva;}
    public void setMontoReserva (String montoReserva) {this.montoReserva = montoReserva;}

    public String getNumeroDocIdent() {return numeroDocIdent;}
    public void setNumeroDocIdent (String numeroDocIdent) {this.numeroDocIdent = numeroDocIdent;}

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro (String montoSiniestro) {this.montoSiniestro = montoSiniestro;}

    public String getSeleccioneAccion() {return seleccioneAccion;}
    public void setSeleccioneAccion (String seleccioneAccion) {this.seleccioneAccion = seleccioneAccion;}



    public static ArrayList getPagoPorConceptos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList pagoPorConceptos = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUMEROSINIESTRO, NumeroPoliza, FechaOcurrenciaSin,Producto, OrdenarPor, Cobertura, MontoReserva, NumeroDocIdent, MontoSiniestro, SeleccioneAccion FROM PAGO_POR_CONCEPTOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                PagoPorConceptosBean pagoPorConceptosBean = new PagoPorConceptosBean();

                pagoPorConceptosBean.setNumeroSiniestro(rs.getString("NUMEROSINIESTRO"));
                pagoPorConceptosBean.setNumeroPoliza(rs.getString("NumeroPoliza"));
                pagoPorConceptosBean.setFechaOcurrenciaSin(rs.getString("FechaOcurrenciaSin"));
                pagoPorConceptosBean.setProducto(rs.getString("Producto"));
                pagoPorConceptosBean.setOrdenarPor(rs.getString("OrdenarPor"));
                pagoPorConceptosBean.setCobertura(rs.getString("Cobertura"));
                pagoPorConceptosBean.setMontoReserva(rs.getString("MontoReserva"));
                pagoPorConceptosBean.setNumeroDocIdent(rs.getString("NumeroDocIdent"));
                pagoPorConceptosBean.setMontoSiniestro(rs.getString("MontoSiniestro"));
                pagoPorConceptosBean.setSeleccioneAccion(rs.getString("SELECCIONEACCION"));


                pagoPorConceptos.add(pagoPorConceptosBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return pagoPorConceptos;

    }








}
