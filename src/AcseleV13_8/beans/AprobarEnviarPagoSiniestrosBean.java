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
 * Created by kzambrano on 15/08/2016.
 */
public class AprobarEnviarPagoSiniestrosBean implements Serializable {

    private final static Logger log = Logger.getLogger(AprobarEnviarPagoSiniestrosBean.class);
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
    private String moneda;

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

    public String getMoneda() {return moneda;}
    public void setMoneda (String sucursal) {this.moneda = moneda; }


    public static ArrayList getAprobarEnviarPagoSiniestros() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList aprobarEnviarPago = new ArrayList();


        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal, Moneda FROM APROBAR_ENVIAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean = new AprobarEnviarPagoSiniestrosBean();

                aprobarEnviarPagoSiniestrosBean.setNumeroSiniestro(rs.getString("NUMEROSINIESTRO"));
                aprobarEnviarPagoSiniestrosBean.setNumeroPoliza(rs.getString("NUMEROPOLIZA"));
                aprobarEnviarPagoSiniestrosBean.setFechaSiniestro(rs.getString("FECHASINIESTRO"));
                aprobarEnviarPagoSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                aprobarEnviarPagoSiniestrosBean.setOrdenarPor(rs.getString("ORDENARPOR"));
                aprobarEnviarPagoSiniestrosBean.setFechaCompromiso(rs.getString("FECHACOMPROMISO"));
                aprobarEnviarPagoSiniestrosBean.setFechaInicial(rs.getString("FECHAINICIAL"));
                aprobarEnviarPagoSiniestrosBean.setFechaFinal(rs.getString("FECHAFINAL"));
                aprobarEnviarPagoSiniestrosBean.setRazon(rs.getString("RAZON"));
                aprobarEnviarPagoSiniestrosBean.setTipo(rs.getString("TIPO"));
                aprobarEnviarPagoSiniestrosBean.setMontoSiniestro(rs.getString("MONTOSINIESTRO"));
                aprobarEnviarPagoSiniestrosBean.setSeleccioneAccion(rs.getString("SELECCIONEACCION"));
                aprobarEnviarPagoSiniestrosBean.setSucursal(rs.getString("SUCURSAL"));
                aprobarEnviarPagoSiniestrosBean.setMoneda(rs.getString("MONEDA"));

                aprobarEnviarPago.add(aprobarEnviarPagoSiniestrosBean);

            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return aprobarEnviarPago;

    }

}
