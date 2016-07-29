package beans;

import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 28/07/2016.
 */
public class EmisionPolizaInclusionTomadoresBean {

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


    public static ArrayList getEmisionPolizaInclusionTomadores(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR FROM POLIZA_INCLUION_TOMADOR ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaInclusionTomadoresBean emisionPolizaInclusionTomadoresBean = new EmisionPolizaInclusionTomadoresBean();

                emisionPolizaInclusionTomadoresBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaInclusionTomadoresBean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaInclusionTomadoresBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaInclusionTomadoresBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaInclusionTomadoresBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaInclusionTomadoresBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaInclusionTomadoresBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaInclusionTomadoresBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                emisionPolizaInclusionTomadoresBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaInclusionTomadoresBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaInclusionTomadoresBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaInclusionTomadoresBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaInclusionTomadoresBean.setTasa(rs.getString("TASA"));
                emisionPolizaInclusionTomadoresBean.setTipoTasa(rs.getString("TIPO_TASA"));
                emisionPolizaInclusionTomadoresBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                emisionPolizaInclusionTomadoresBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                emisionPolizaInclusionTomadoresBean.setCedula(rs.getString("CEDULA"));
                emisionPolizaInclusionTomadoresBean.setNombre(rs.getString("NOMBRE"));
                emisionPolizaInclusionTomadoresBean.setApellido(rs.getString("APELLIDO"));
                emisionPolizaInclusionTomadoresBean.setPorcentajeTomador(rs.getString("PORCENTAJE_TOMADOR"));
                poliza.add(emisionPolizaInclusionTomadoresBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return poliza;
    }

}
// PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA,
// EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA,
// LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO,
// TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE,
// APELLIDO, PORCENTAJE_TOMADOR