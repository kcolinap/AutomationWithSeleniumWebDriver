package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 21/01/2017.
 */
public class INTER_RechazarPagoSiniestroBean {

    private final static Logger log = Logger.getLogger(INTER_RechazarPagoSiniestroBean.class);

    private String numeroSiniestro;
    private String numeroPoliza;
    private String fechaOcurrenciaSin;
    private String producto;
    private String ordenarPor;
    private String fechaCompromiso;
    private String fechaInicial;
    private String fechaFinal;
    private String razon;
    private String tipo;
    private String montoSiniestro;
    private String sucursal;
    private String cobertura;
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

    public String getFechaCompromiso() {return fechaCompromiso;}
    public void setFechaCompromiso(String fechaCompromiso) {this.fechaCompromiso = fechaCompromiso;}

    public String getFechaInicial() {return fechaInicial;}
    public void setFechaInicial(String fechaInicial) {this.fechaInicial = fechaInicial;}

    public String getFechaFinal() {return fechaFinal;}
    public void setFechaFinal(String fechaFinal) {this.fechaFinal = fechaFinal;}

    public String getRazon() {return razon;}
    public void setRazon(String razon) {this.razon = razon;}

    public String getTipo() {return tipo;}
    public void setTipo(String tipo) {this.tipo = tipo;}

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro(String montoSiniestro) {this.montoSiniestro = montoSiniestro;}

    public String getSucursal() {return sucursal;}
    public void setSucursal(String sucursal) {this.sucursal = sucursal;}

    public String getCobertura() {return cobertura;}
    public void setCobertura(String cobertura) {this.cobertura = cobertura;}

    public String getSeleccioneAccion() {return seleccioneAccion;}
    public void setSeleccioneAccion(String seleccioneAccion) {this.seleccioneAccion = seleccioneAccion;}


    public static ArrayList getINTER_RechazarPagoSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interRechazarPagoSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por, fecha_Compromiso, fecha_Inicial, fecha_Final, razon,tipo, sucursal, cobertura, seleccione_Accion, monto_Siniestro FROM INTER_RECHAZAR_PAGO_SINIESTRO ORDER BY PRUEBA ASC");

        try {

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean= new INTER_RechazarPagoSiniestroBean();

                inter_rechazarPagoSiniestroBean.setNumeroSiniestro(rs.getString("NUMERO_SINIESTRO"));
                inter_rechazarPagoSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_rechazarPagoSiniestroBean.setFechaOcurrenciaSin(rs.getString("FECHA_OCURRENCIA_SIN"));
                inter_rechazarPagoSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_rechazarPagoSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_rechazarPagoSiniestroBean.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                inter_rechazarPagoSiniestroBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                inter_rechazarPagoSiniestroBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                inter_rechazarPagoSiniestroBean.setRazon(rs.getString("RAZON"));
                inter_rechazarPagoSiniestroBean.setTipo(rs.getString("TIPO"));
                inter_rechazarPagoSiniestroBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));
                inter_rechazarPagoSiniestroBean.setSucursal(rs.getString("SUCURSAL"));
                inter_rechazarPagoSiniestroBean.setCobertura(rs.getString("COBERTURA"));
                inter_rechazarPagoSiniestroBean.setSeleccioneAccion(rs.getString("SELECCIONE_ACCION"));

                interRechazarPagoSiniestro.add(inter_rechazarPagoSiniestroBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interRechazarPagoSiniestro;

    }


}
