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
 * Created by kzambrano on 10/08/2016.
 */
public class RechazarPagoSiniestrosBean implements Serializable{

    private final static Logger log = Logger.getLogger(RechazarPagoSiniestrosBean.class);
    private String numeroSiniestro;
    private String numeroPoliza;
    private String fechaSiniestro;
    private String producto;
    private String ordenarPor;
    private String fechaCompromiso;
    private String fechaInicial;
    private String fechaFinal;
    private String razon;
    private String tipo;
    private String montoSiniestro;
    private String seleccioneAccion;
    private String sucursal;


    public String getNumeroSiniestro() {
        return numeroSiniestro;
    }
    public void setNumeroSiniestro (String numeroSiniestro) {
        this.numeroSiniestro = numeroSiniestro;
    }

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza (String numeroPoliza) {this.numeroPoliza = numeroPoliza; }

    public String getFechaSiniestro() {return fechaSiniestro;}
    public void setFechaSiniestro (String fechaSiniestro) {this.fechaSiniestro = fechaSiniestro; }


    public String getProducto() {return producto;}
    public void setProducto (String producto) {this.producto = producto; }

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor (String ordenarPor) {this.ordenarPor = ordenarPor; }

    public String getFechaCompromiso() {return fechaCompromiso;}
    public void setFechaCompromiso (String fechaCompromiso) {this.fechaCompromiso = fechaCompromiso; }

    public String getFechaInicial() {return fechaInicial;}
    public void setFechaInicial (String fechaInicial) {this.fechaInicial = fechaInicial; }

    public String getFechaFinal() {return fechaFinal;}
    public void setFechaFinal (String fechaFinal) {this.fechaFinal = fechaFinal; }

    public String getRazon() {return razon;}
    public void setRazon (String razon) {this.razon = razon; }

    public String getTipo() {return tipo;}
    public void setTipo (String tipo) {this.tipo = tipo; }

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro (String montoSiniestro) {this.montoSiniestro = montoSiniestro; }

    public String getSeleccioneAccion() {return seleccioneAccion;}
    public void setSeleccioneAccion (String seleccioneAccion) {this.seleccioneAccion = seleccioneAccion; }

    public String getSucursal() {return sucursal;}
    public void setSucursal (String sucursal) {this.sucursal = sucursal; }

    public static ArrayList getAprobarPagoSiniestros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList aprobarPago = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal FROM APROBAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean = new RechazarPagoSiniestrosBean();


                rechazarPagoSiniestrosBean.setNumeroSiniestro(rs.getString("NUMEROSINIESTRO"));
                rechazarPagoSiniestrosBean.setNumeroPoliza(rs.getString("NUMEROPOLIZA"));
                rechazarPagoSiniestrosBean.setFechaSiniestro(rs.getString("FECHASINIESTRO"));
                rechazarPagoSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                rechazarPagoSiniestrosBean.setOrdenarPor(rs.getString("ORDENARPOR"));
                rechazarPagoSiniestrosBean.setFechaCompromiso(rs.getString("FECHACOMPROMISO"));
                rechazarPagoSiniestrosBean.setFechaInicial(rs.getString("FECHAINICIAL"));
                rechazarPagoSiniestrosBean.setFechaFinal(rs.getString("FECHAFINAL"));
                rechazarPagoSiniestrosBean.setRazon(rs.getString("RAZON"));
                rechazarPagoSiniestrosBean.setTipo(rs.getString("TIPO"));
                rechazarPagoSiniestrosBean.setMontoSiniestro(rs.getString("MONTOSINIESTRO"));
                rechazarPagoSiniestrosBean.setSeleccioneAccion(rs.getString("SELECCIONEACCION"));
                rechazarPagoSiniestrosBean.setSucursal(rs.getString("SUCURSAL"));

                aprobarPago.add(rechazarPagoSiniestrosBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }


        return aprobarPago;

    }

}




