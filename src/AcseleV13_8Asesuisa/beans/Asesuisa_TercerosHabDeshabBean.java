package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 25/04/2017.
 */
public class Asesuisa_TercerosHabDeshabBean extends Asesuisa_TercerosBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_TercerosHabDeshabBean.class);

    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String fechaMovimiento;
    private String planFinanciamento;
    private String monedas;
    private String sucursal;
    private String funcionamientoPoliza;
    private String canalVenta;
    private String comisionNegociable;
    private String unidadComercial;
    private String giro;
    private String giroActividadEconomica;
    private String sumaAsegurada;
    private String tipoPoliza;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
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

    public String getEventoAplicar() {
        return eventoAplicar;
    }

    public void setEventoAplicar(String eventoAplicar) {
        this.eventoAplicar = eventoAplicar;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getPlanFinanciamento() {
        return planFinanciamento;
    }

    public void setPlanFinanciamento(String planFinanciamento) {
        this.planFinanciamento = planFinanciamento;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getFuncionamientoPoliza() {
        return funcionamientoPoliza;
    }

    public void setFuncionamientoPoliza(String funcionamientoPoliza) {
        this.funcionamientoPoliza = funcionamientoPoliza;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getComisionNegociable() {
        return comisionNegociable;
    }

    public void setComisionNegociable(String comisionNegociable) {
        this.comisionNegociable = comisionNegociable;
    }

    public String getUnidadComercial() {
        return unidadComercial;
    }

    public void setUnidadComercial(String unidadComercial) {
        this.unidadComercial = unidadComercial;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    public String getGiroActividadEconomica() {
        return giroActividadEconomica;
    }

    public void setGiroActividadEconomica(String giroActividadEconomica) {
        this.giroActividadEconomica = giroActividadEconomica;
    }

    public String getSumaAsegurada() {
        return sumaAsegurada;
    }

    public void setSumaAsegurada(String sumaAsegurada) {
        this.sumaAsegurada = sumaAsegurada;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public static ArrayList getAsesuisa_TercerosHabDeshab() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList tercero = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_TERCERO_HAB_DES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_TercerosHabDeshabBean bean = new Asesuisa_TercerosHabDeshabBean();

                bean.setPrimerNombre(rs.getString("TERCERO_NOMBRE_1"));
                bean.setSegundoNombre(rs.getString("TERCERO_NOMBRE_2"));
                bean.setPrimerApellido(rs.getString("TERCERO_APELLIDO_1"));
                bean.setSegundoApellido(rs.getString("TERCERO_APELLIDO_2"));
                bean.setNumeroNIT(rs.getString("TERCERO_NIT"));
                bean.setNumeroDUI(rs.getString("TERCERO_DUI"));
                bean.setTipoDocumentoIdentificacion(rs.getString("TIPO_DOCUMENTO"));
                bean.setNumeroDocumentoIdentificacion(rs.getString("NUM_DOC_ID"));
                bean.setProducto(rs.getString("PRODUCTO"));
                bean.setVigencia(rs.getString("VIGENCIA"));
                bean.setFechaDesde(rs.getString("FECHA_DESDE"));
                bean.setFechaHasta(rs.getString("FEHCA_HASTA"));
                bean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                bean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                bean.setPlanFinanciamento(rs.getString("PLAN_FINANCIEMIENTO"));
                bean.setMonedas(rs.getString("MONEDAS"));
                bean.setSucursal(rs.getString("SUCURSAL"));
                bean.setFuncionamientoPoliza(rs.getString("FUNCIONAMIENTO_POLIZA"));
                bean.setCanalVenta(rs.getString("CANAL_VENTA"));
                bean.setComisionNegociable(rs.getString("COMISION_NEGOCIABLE"));
                bean.setUnidadComercial(rs.getString("UNIDAD_COMERCIAL"));
                bean.setGiro(rs.getString("GIRO"));
                bean.setGiroActividadEconomica(rs.getString("GIRO_ACTIV_ECONOMICA"));
                bean.setSumaAsegurada(rs.getString("SUMA_ASEGURADA"));
                bean.setTipoPoliza(rs.getString("TIPO_POLIZA"));

                tercero.add(bean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return tercero;
    }
}
