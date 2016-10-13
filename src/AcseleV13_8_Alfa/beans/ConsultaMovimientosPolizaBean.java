package AcseleV13_8_Alfa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by rmontilla on 28/09/2016.
 */
public class ConsultaMovimientosPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(ConsultaMovimientosPolizaBean.class);

    private String ordenarPor;
    private String producto;
    private String estadoVida;
    private String contratante;
    private String asegurado;
    private String idPoliza;
    private String fechaDesde;
    private String fechaHasta;
    private String sucursal;
    private String numPoliza;
    private String fechaEmision;
    private String moneda;
    private String tipoMoneda;
    private String tipoProduccion;
    private String tipoVigencia;
    private String vigencia;
    private String canalVenta;
    private String frecuenciaPago;
    private String fechaEventAnt;
    private String fechaProxGenPri;
    private String fechaProxFact;
    private String tipoPol;
    private String numCot;
    private String numPro;

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEstadoVida() {
        return estadoVida;
    }

    public void setEstadoVida(String estadoVida) {
        this.estadoVida = estadoVida;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public String getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(String idPoliza) {
        this.idPoliza = idPoliza;
    }

    public String getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(String fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(String fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

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

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public String getTipoVigencia() {
        return tipoVigencia;
    }

    public void setTipoVigencia(String tipoVigencia) {
        this.tipoVigencia = tipoVigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getFechaEventAnt() {
        return fechaEventAnt;
    }

    public void setFechaEventAnt(String fechaEventAnt) {
        this.fechaEventAnt = fechaEventAnt;
    }

    public String getFechaProxGenPri() {
        return fechaProxGenPri;
    }

    public void setFechaProxGenPri(String fechaProxGenPri) {
        this.fechaProxGenPri = fechaProxGenPri;
    }

    public String getFechaProxFact() {
        return fechaProxFact;
    }

    public void setFechaProxFact(String fechaProxFact) {
        this.fechaProxFact = fechaProxFact;
    }

    public String getTipoPol() {
        return tipoPol;
    }

    public void setTipoPol(String tipoPol) {
        this.tipoPol = tipoPol;
    }

    public String getNumCot() {
        return numCot;
    }

    public void setNumCot(String numCot) {
        this.numCot = numCot;
    }

    public String getNumPro() {
        return numPro;
    }

    public void setNumPro(String numPro) {
        this.numPro = numPro;
    }



    public ConsultaMovimientosPolizaBean() {
    }


    public static ArrayList getConsultaMovimientosPoliza() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consul = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM CONSULTA_MOV_POL ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultaMovimientosPolizaBean consultaMovimientosPolizaBean = new ConsultaMovimientosPolizaBean();

                consultaMovimientosPolizaBean.setEstadoVida(rs.getString("ESTADOS_VIDA"));
                consultaMovimientosPolizaBean.setProducto(rs.getString("PRODUCTO"));
                consultaMovimientosPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                consultaMovimientosPolizaBean.setContratante(rs.getString("CONTRATANTE"));
                consultaMovimientosPolizaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                consultaMovimientosPolizaBean.setAsegurado(rs.getString("ASEGURADO"));
                consultaMovimientosPolizaBean.setIdPoliza(rs.getString("ID_POLIZA"));
                consultaMovimientosPolizaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                consultaMovimientosPolizaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                consultaMovimientosPolizaBean.setSucursal(rs.getString("SUCURSAL"));
                consultaMovimientosPolizaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                consultaMovimientosPolizaBean.setMoneda(rs.getString("MONEDA"));
                consultaMovimientosPolizaBean.setTipoMoneda(rs.getString("TIPO_MONEDA"));
                consultaMovimientosPolizaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                consultaMovimientosPolizaBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                consultaMovimientosPolizaBean.setVigencia(rs.getString("VIGENCIA"));
                consultaMovimientosPolizaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                consultaMovimientosPolizaBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                consultaMovimientosPolizaBean.setFechaEventAnt(rs.getString("FECHA_EVENT_ANT"));
                consultaMovimientosPolizaBean.setFechaProxGenPri(rs.getString("FECHA_PROX_GEN_PRI"));
                consultaMovimientosPolizaBean.setFechaProxFact(rs.getString("FECHA_PROX_FACT"));
                consultaMovimientosPolizaBean.setTipoPol(rs.getString("TIPO_POL"));
                consultaMovimientosPolizaBean.setNumCot(rs.getString("NUM_COT"));
                consultaMovimientosPolizaBean.setNumPro(rs.getString("NUM_PRO"));



                consul.add(consultaMovimientosPolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return consul;
    }

}
