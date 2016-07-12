package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 12/07/2016.
 */
public class TercerosHabilitarDeshabilitarBean implements Serializable {

    // PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA,
    // EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO
    private String tipTercer;
    private String tipDcID;
    private String cedulaID;
    private String nombreT;
    private String apellidoT;
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String sucursal;
    private String tipoProduccion;
    private String lineaCredito;
    private String unidadNegocio;
    private String canalVenta;
    private String tipoValorAsegurado;

    public String getTipTercer(){
        return tipTercer;
    }
    public void setTipTercer(String tipTercer){
        this.tipTercer = tipTercer;
    }

    public String getTipDcID(){
        return tipDcID;
    }
    public void setTipDcID(String tipDcID){
        this.tipDcID = tipDcID;
    }

    public String getCedulaID(){
        return cedulaID;
    }
    public void setCedulaID(String cedulaID){
        this.cedulaID = cedulaID;
    }

    public String getNombreT(){
        return nombreT;
    }
    public void setNombreT(String nombreT){
        this.nombreT = nombreT;
    }

    public String getApellidoT(){
        return apellidoT;
    }
    public void setApellidoT(String apellidoT){
        this.apellidoT = apellidoT;
    }

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

    public static ArrayList getTerceroHabilitarDeshabilitar(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList tercerosHD = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean = new TercerosHabilitarDeshabilitarBean();
                tercerosHabilitarDeshabilitarBean.setTipTercer(rs.getString("TIPO_TERCERO"));
                tercerosHabilitarDeshabilitarBean.setTipDcID(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosHabilitarDeshabilitarBean.setCedulaID(rs.getString("CEDULA"));
                tercerosHabilitarDeshabilitarBean.setNombreT(rs.getString("NOMBRE"));
                tercerosHabilitarDeshabilitarBean.setApellidoT(rs.getString("APELLIDO"));
                tercerosHabilitarDeshabilitarBean.setProducto(rs.getString("PRODUCTO"));
                tercerosHabilitarDeshabilitarBean.setVigencia(rs.getString("VIGENCIA"));
                tercerosHabilitarDeshabilitarBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                tercerosHabilitarDeshabilitarBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                tercerosHabilitarDeshabilitarBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                tercerosHabilitarDeshabilitarBean.setSucursal(rs.getString("SUCURSAL"));
                tercerosHabilitarDeshabilitarBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                tercerosHabilitarDeshabilitarBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                tercerosHabilitarDeshabilitarBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                tercerosHabilitarDeshabilitarBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                tercerosHabilitarDeshabilitarBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                tercerosHD.add(tercerosHabilitarDeshabilitarBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return tercerosHD;
    }
}
