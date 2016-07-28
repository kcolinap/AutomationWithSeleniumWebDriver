package beans;

import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 27/07/2016.
 */
public class EmisionPolizaVariosOABean {


    // PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2, PORCETAJE_DESCUENTO_2

    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String sucursal;
    private String tipoProduccion;
    private String periodoGracia;
    private String lineaCredito;
    private String unidadNegocio;
    private String canalVenta;
    private String tipoValorAsegurado;
    private String tasa;
    private String tipoTasa;
    private String tipoTercero;
    private String tipoDicIdentidad;
    private String cedula;
    private String nombre;
    private String apellido;
    private String porcentajeTomador;
    private String numUnidRiesgo;
    private String numCredito;
    private String montoAsgurado;
    private String porcExtraPrima1;
    private String porcDescuento1;
    private String porcExtraPrima2;
    private String porcDescuento2;

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

    public String getSucursal() {
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }
    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public String getPeriodoGracia() {
        return periodoGracia;
    }
    public void setPeriodoGracia(String periodoGracia) {
        this.periodoGracia = periodoGracia;
    }

    public String getLineaCredito() {
        return lineaCredito;
    }
    public void setLineaCredito(String lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
    }
    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getCanalVenta() {
        return canalVenta;
    }
    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getTipoValorAsegurado() {
        return tipoValorAsegurado;
    }
    public void setTipoValorAsegurado(String tipoValorAsegurado) {
        this.tipoValorAsegurado = tipoValorAsegurado;
    }

    public String getTasa() {
        return tasa;
    }
    public void setTasa(String tasa) {
        this.tasa = tasa;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }
    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDicIdentidad() {
        return tipoDicIdentidad;
    }
    public void setTipoDicIdentidad(String tipoDicIdentidad) {
        this.tipoDicIdentidad = tipoDicIdentidad;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPorcentajeTomador() {
        return porcentajeTomador;
    }
    public void setPorcentajeTomador(String porcentajeTomador) {
        this.porcentajeTomador = porcentajeTomador;
    }

    public String getNumUnidRiesgo() {
        return numUnidRiesgo;
    }
    public void setNumUnidRiesgo(String numUnidRiesgo) {
        this.numUnidRiesgo = numUnidRiesgo;
    }

    public String getNumCredito() {
        return numCredito;
    }
    public void setNumCredito(String numCredito) {
        this.numCredito = numCredito;
    }

    public String getMontoAsgurado() {
        return montoAsgurado;
    }
    public void setMontoAsgurado(String montoAsgurado) {
        this.montoAsgurado = montoAsgurado;
    }

    public String getPorcExtraPrima1() {
        return porcExtraPrima1;
    }
    public void setPorcExtraPrima1(String porcExtraPrima1) {
        this.porcExtraPrima1 = porcExtraPrima1;
    }

    public String getPorcDescuento1() {
        return porcDescuento1;
    }
    public void setPorcDescuento1(String porcDescuento1) {
        this.porcDescuento1 = porcDescuento1;
    }

    public String getPorcExtraPrima2() {
        return porcExtraPrima2;
    }
    public void setPorcExtraPrima2(String porcExtraPrima2) {
        this.porcExtraPrima2 = porcExtraPrima2;
    }

    public String getPorcDescuento2() {
        return porcDescuento2;
    }
    public void setPorcDescuento2(String porcDescuento2) {
        this.porcDescuento2 = porcDescuento2;
    }

    public static ArrayList getEmisionPolizaVariosOA() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2, PORCETAJE_DESCUENTO_2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaVariosOABean emisionPolizaVariosOABean = new EmisionPolizaVariosOABean();
                emisionPolizaVariosOABean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaVariosOABean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaVariosOABean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaVariosOABean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaVariosOABean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaVariosOABean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaVariosOABean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaVariosOABean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                emisionPolizaVariosOABean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaVariosOABean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaVariosOABean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaVariosOABean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaVariosOABean.setTasa(rs.getString("TASA"));
                emisionPolizaVariosOABean.setTipoTasa(rs.getString("TIPO_TASA"));
                emisionPolizaVariosOABean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                emisionPolizaVariosOABean.setTipoDicIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                emisionPolizaVariosOABean.setCedula(rs.getString("CEDULA"));
                emisionPolizaVariosOABean.setNombre(rs.getString("NOMBRE"));
                emisionPolizaVariosOABean.setApellido(rs.getString("APELLIDO"));
                emisionPolizaVariosOABean.setPorcentajeTomador(rs.getString("PORCENTAJE_TOMADOR"));
                emisionPolizaVariosOABean.setNumUnidRiesgo(rs.getString("NUM_UNIDAD_RIESGO"));
                emisionPolizaVariosOABean.setNumCredito(rs.getString("NUM_CREDITO"));
                emisionPolizaVariosOABean.setMontoAsgurado(rs.getString("MONTO_ASEGURADO"));
                emisionPolizaVariosOABean.setPorcExtraPrima1(rs.getString("PORCETAJE_EXTRA_PRIMA_1"));
                emisionPolizaVariosOABean.setPorcDescuento1(rs.getString("PORCETAJE_DESCUENTO_1"));
                emisionPolizaVariosOABean.setPorcExtraPrima2(rs.getString("PORCETAJE_EXTRA_PRIMA_2"));
                emisionPolizaVariosOABean.setPorcDescuento2(rs.getString("PORCETAJE_DESCUENTO_2"));
                emision.add(emisionPolizaVariosOABean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return emision;
    }

}