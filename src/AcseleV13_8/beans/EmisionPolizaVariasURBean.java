package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 18/07/2016.
 */
public class EmisionPolizaVariasURBean implements Serializable {

    // PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL,
    // TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA,
    // TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD,
    // CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO,
    // MONTO_ASEGURADO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO
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
    private String tipoDocId;
    private String cedula;
    private String nombre;
    private String apellido;
    private String porcentajeTomador;
    private String numUnidadRiesgo1;
    private String numCredito1;
    private String montoAsegurado1;
    private String numUnidadRiesgo2;
    private String numCredito2;
    private String montoAsegurado2;
    private String porcExtraPrima;
    private String porcDescuento;

    public String getProducto(){
        return producto;
    }
    public void setProducto(String producto){
        this.producto = producto;
    }

    public String getVigencia(){
        return vigencia;
    }
    public void setVigencia(String vigencia){
        this.vigencia = vigencia;
    }

    public String getFechaDesde(){
        return fechaDesde;
    }
    public void setFechaDesde(String fechaDesde){
        this.fechaDesde = fechaDesde;
    }

    public String getFechaHasta(){
        return fechaHasta;
    }
    public void setFechaHasta(String fechaHasta){
        this.fechaHasta = fechaHasta;
    }

    public String getEventoAplicar(){
        return eventoAplicar;
    }
    public void setEventoAplicar(String eventoAplicar){
        this.eventoAplicar = eventoAplicar;
    }

    public String getSucursal(){
        return sucursal;
    }
    public void setSucursal(String sucursal){
        this.sucursal = sucursal;
    }

    public String getTipoProduccion(){
        return tipoProduccion;
    }
    public void setTipoProduccion(String tipoProduccion){
        this.tipoProduccion = tipoProduccion;
    }

    public String getPeriodoGracia(){
        return periodoGracia;
    }
    public void setPeriodoGracia(String periodoGracia){
        this.periodoGracia = periodoGracia;
    }

    public String getLineaCredito(){
        return lineaCredito;
    }
    public void setLineaCredito(String lineaCredito){
        this.lineaCredito = lineaCredito;
    }

    public String getUnidadNegocio(){
        return unidadNegocio;
    }
    public void setUnidadNegocio(String unidadNegocio){
        this.unidadNegocio = unidadNegocio;
    }

    public String getCanalVenta(){
        return canalVenta;
    }
    public void setCanalVenta(String canalVenta){
        this.canalVenta = canalVenta;
    }

    public String getTipoValorAsegurado(){
        return tipoValorAsegurado;
    }
    public void setTipoValorAsegurado(String tipoValorAsegurado){
        this.tipoValorAsegurado = tipoValorAsegurado;
    }

    public String getTasa(){
        return tasa;
    }
    public void setTasa(String tasa){
        this.tasa = tasa;
    }

    public String getTipoTasa(){
        return tipoTasa;
    }
    public void setTipoTasa(String tipoTasa){
        this.tipoTasa = tipoTasa;
    }

    public String getTipoTercero(){
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero){
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId(){
        return tipoDocId;
    }
    public void setTipoDocId(String tipoDocId){
        this.tipoDocId = tipoDocId;
    }

    public String getCedula(){
        return cedula;
    }
    public void setCedula(String cedula){
        this.cedula = cedula;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getPorcentajeTomador(){
        return porcentajeTomador;
    }
    public void setPorcentajeTomador(String porcentajeTomador){
        this.porcentajeTomador = porcentajeTomador;
    }



    public String getNumUnidadRiesgo1(){
        return numUnidadRiesgo1;
    }
    public void setNumUnidadRiesgo1(String numUnidadRiesgo1){
        this.numUnidadRiesgo1 = numUnidadRiesgo1;
    }

    public String getNumCredito1(){
        return numCredito1;
    }
    public void setNumCredito1(String numCredito1){
        this.numCredito1 = numCredito1;
    }

    public String getMontoAsegurado1(){
        return montoAsegurado1;
    }
    public void setMontoAsegurado1(String montoAsegurado1){
        this.montoAsegurado1 = montoAsegurado1;
    }

    public String getNumUnidadRiesgo2(){
        return numUnidadRiesgo2;
    }
    public void setNumUnidadRiesgo2(String numUnidadRiesgo2){
        this.numUnidadRiesgo2 = numUnidadRiesgo2;
    }

    public String getNumCredito2(){
        return numCredito2;
    }
    public void setNumCredito2(String numCredito2){
        this.numCredito2 = numCredito2;
    }

    public String getMontoAsegurado2(){
        return montoAsegurado2;
    }
    public void setMontoAsegurado2(String montoAsegurado2){
        this.montoAsegurado2 = montoAsegurado2;
    }



    public String getPorcExtraPrima(){
        return porcExtraPrima;
    }
    public void setPorcExtraPrima(String porcExtraPrima){
        this.porcExtraPrima = porcExtraPrima;
    }

    public String getPorcDescuento(){
        return porcDescuento;
    }
    public void setPorcDescuento(String porcDescuento){
        this.porcDescuento = porcDescuento;
    }

    public static ArrayList getEmisionPolizaVariasUR(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO1, NUM_CREDITO1, MONTO_ASEGURADO1, NUM_UNIDAD_RIESGO2, NUM_CREDITO2, MONTO_ASEGURADO2,  PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaVariasURBean emisionPolizaVariasURBean = new EmisionPolizaVariasURBean();
                emisionPolizaVariasURBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaVariasURBean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaVariasURBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaVariasURBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaVariasURBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaVariasURBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaVariasURBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaVariasURBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                emisionPolizaVariasURBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaVariasURBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaVariasURBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaVariasURBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaVariasURBean.setTasa(rs.getString("TASA"));
                emisionPolizaVariasURBean.setTipoTasa(rs.getString("TIPO_TASA"));
                emisionPolizaVariasURBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                emisionPolizaVariasURBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                emisionPolizaVariasURBean.setCedula(rs.getString("CEDULA"));
                emisionPolizaVariasURBean.setNombre(rs.getString("NOMBRE"));
                emisionPolizaVariasURBean.setApellido(rs.getString("APELLIDO"));
                emisionPolizaVariasURBean.setPorcentajeTomador(rs.getString("PORCENTAJE_TOMADOR"));

                emisionPolizaVariasURBean.setNumUnidadRiesgo1(rs.getString("NUM_UNIDAD_RIESGO1"));
                emisionPolizaVariasURBean.setNumCredito1(rs.getString("NUM_CREDITO1"));
                emisionPolizaVariasURBean.setMontoAsegurado1(rs.getString("MONTO_ASEGURADO1"));
                emisionPolizaVariasURBean.setNumUnidadRiesgo2(rs.getString("NUM_UNIDAD_RIESGO2"));
                emisionPolizaVariasURBean.setNumCredito2(rs.getString("NUM_CREDITO2"));
                emisionPolizaVariasURBean.setMontoAsegurado2(rs.getString("MONTO_ASEGURADO2"));

                emisionPolizaVariasURBean.setPorcExtraPrima(rs.getString("PORCETAJE_EXTRA_PRIMA"));
                emisionPolizaVariasURBean.setPorcDescuento(rs.getString("PORCETAJE_DESCUENTO"));
                poliza.add(emisionPolizaVariasURBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return poliza;
    }
}
