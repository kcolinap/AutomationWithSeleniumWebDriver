package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 01/08/2016.
 */
public class EmisionPolizaEliminacionTomadoresBean implements Serializable{

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
    private String tipoTercero1;
    private String tipoDocId1;
    private String cedula1;
    private String nombre1;
    private String apellido1;
    private String porcentajeTomador1;
    private String tipoTercero2;
    private String tipoDocId2;
    private String cedula2;
    private String nombre2;
    private String apellido2;
    private String porcentajeTomador2;
    private String nuevoPorcentajeTomador1;

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

    public String getTipoTercero1(){
        return tipoTercero1;
    }
    public void setTipoTercero1(String tipoTercero1){
        this.tipoTercero1 = tipoTercero1;
    }

    public String getTipoDocId1(){
        return tipoDocId1;
    }
    public void setTipoDocId1(String tipoDocId1){
        this.tipoDocId1 = tipoDocId1;
    }

    public String getCedula1(){
        return cedula1;
    }
    public void setCedula1(String cedula1){
        this.cedula1 = cedula1;
    }

    public String getNombre1(){
        return nombre1;
    }
    public void setNombre1(String nombre1){
        this.nombre1 = nombre1;
    }

    public String getApellido1(){
        return apellido1;
    }
    public void setApellido1(String apellido1){
        this.apellido1 = apellido1;
    }

    public String getPorcentajeTomador1(){
        return porcentajeTomador1;
    }
    public void setPorcentajeTomador1(String porcentajeTomador1){
        this.porcentajeTomador1 = porcentajeTomador1;
    }

    public String getTipoTercero2(){
        return tipoTercero2;
    }
    public void setTipoTercero2(String tipoTercero2){
        this.tipoTercero2 = tipoTercero2;
    }

    public String getTipoDocId2(){
        return tipoDocId2;
    }
    public void setTipoDocId2(String tipoDocId2){
        this.tipoDocId2 = tipoDocId2;
    }

    public String getCedula2(){
        return cedula2;
    }
    public void setCedula2(String cedula2){
        this.cedula2 = cedula2;
    }

    public String getNombre2(){
        return nombre2;
    }
    public void setNombre2(String nombre2){
        this.nombre2 = nombre2;
    }

    public String getApellido2(){
        return apellido2;
    }
    public void setApellido2(String apellido2){
        this.apellido2 = apellido2;
    }

    public String getPorcentajeTomador2(){
        return porcentajeTomador2;
    }
    public void setPorcentajeTomador2(String porcentajeTomador2){
        this.porcentajeTomador2 = porcentajeTomador2;
    }

    public String getNuevoPorcentajeTomador1(){
        return nuevoPorcentajeTomador1;
    }
    public void setNuevoPorcentajeTomador1(String nuevoPorcentajeTomador1){
        this.nuevoPorcentajeTomador1 = nuevoPorcentajeTomador1;
    }


    public static ArrayList getEmisionPolizaEliminacionTomadores(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaEliminacionTomadoresBean emisionPolizaEliminacionTomadoresBean = new EmisionPolizaEliminacionTomadoresBean();

                emisionPolizaEliminacionTomadoresBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaEliminacionTomadoresBean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaEliminacionTomadoresBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaEliminacionTomadoresBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaEliminacionTomadoresBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaEliminacionTomadoresBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaEliminacionTomadoresBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaEliminacionTomadoresBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                emisionPolizaEliminacionTomadoresBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaEliminacionTomadoresBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaEliminacionTomadoresBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaEliminacionTomadoresBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaEliminacionTomadoresBean.setTasa(rs.getString("TASA"));
                emisionPolizaEliminacionTomadoresBean.setTipoTasa(rs.getString("TIPO_TASA"));
                emisionPolizaEliminacionTomadoresBean.setTipoTercero1(rs.getString("TIPO_TERCERO1"));
                emisionPolizaEliminacionTomadoresBean.setTipoDocId1(rs.getString("TIPO_DOC_IDENTIDAD1"));
                emisionPolizaEliminacionTomadoresBean.setCedula1(rs.getString("CEDULA1"));
                emisionPolizaEliminacionTomadoresBean.setNombre1(rs.getString("NOMBRE1"));
                emisionPolizaEliminacionTomadoresBean.setApellido1(rs.getString("APELLIDO1"));
                emisionPolizaEliminacionTomadoresBean.setPorcentajeTomador1(rs.getString("PORCENTAJE_TOMADOR1"));
                emisionPolizaEliminacionTomadoresBean.setTipoTercero2(rs.getString("TIPO_TERCERO2"));
                emisionPolizaEliminacionTomadoresBean.setTipoDocId2(rs.getString("TIPO_DOC_IDENTIDAD2"));
                emisionPolizaEliminacionTomadoresBean.setCedula2(rs.getString("CEDULA2"));
                emisionPolizaEliminacionTomadoresBean.setNombre2(rs.getString("NOMBRE2"));
                emisionPolizaEliminacionTomadoresBean.setApellido2(rs.getString("APELLIDO2"));
                emisionPolizaEliminacionTomadoresBean.setPorcentajeTomador2(rs.getString("PORCENTAJE_TOMADOR2"));
                emisionPolizaEliminacionTomadoresBean.setNuevoPorcentajeTomador1(rs.getString("NUEVO_PORCENTAJE_TOMADOR1"));
                emision.add(emisionPolizaEliminacionTomadoresBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return emision;
    }
}
