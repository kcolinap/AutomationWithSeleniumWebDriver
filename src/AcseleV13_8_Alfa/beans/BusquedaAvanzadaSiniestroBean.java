package AcseleV13_8_Alfa.beans;


import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/08/2016.
 */
public class BusquedaAvanzadaSiniestroBean {

    private final static Logger log = Logger.getLogger(BusquedaAvanzadaSiniestroBean.class);

    private String ordenar;
    private String producto;
    private String evento;
    private String sucursal;
    private String numPoliza;
    private String emision;
    private String tipoProduccion;
    private String canalVenta;
    private String frecuenciaPago;
    private String tipoPoliza;
    private String tipoTercero;
    private String tipoDocumento;
    private String numDocumento;
    private String nombreApellido;
    private String fechaInclusion;
    private String tlfOficina;
    private String extension;
    private String tlfOficinaComp;
    private String email1;
    private String email2;
    private String codigoInterno;
    private String codigoIdentificador;
    private String indicativo;
    private String rol;
    private String numUnidadRiesgo;
    private String tipoObjAsegurado;
    private String numObjAsegurado;
    private String nombreAsegurado;
    private String nombreBeneficiario;

    public String getOrdenar() {
        return ordenar;
    }
    public void setOrdenar(String ordenar) {
        this.ordenar = ordenar;
    }

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getEvento(){
        return evento;
    }
    public void setEvento(String evento){
        this.evento = evento;
    }

    public String getSucursal(){
        return sucursal;
    }
    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getEmision() {
        return emision;
    }
    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getTipoProduccion() {return tipoProduccion;}
    public void setTipoProduccion(String tipoProduccion) {this.tipoProduccion = tipoProduccion;}

    public String getCanalVenta(){return canalVenta;}
    public void setCanalVenta(String canalVenta){this.evento = canalVenta;}

    public String getFrecuenciaPago(){
        return frecuenciaPago;
    }
    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getTipoPoliza(){
        return tipoPoliza;
    }
    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocumento() {return tipoDocumento;}
    public void setTipoDocumento(String tipoDocumento) {this.tipoDocumento = tipoDocumento;}

    public String getNumDocumento(){
        return numDocumento;
    }
    public void setNumDocumento(String numDocumento){
        this.numDocumento = numDocumento;
    }

    public String getNombreApellido(){
        return nombreApellido;
    }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getFechaInclusion(){
        return fechaInclusion;
    }
    public void setFechaInclusion(String fechaInclusion) {
        this.fechaInclusion = fechaInclusion;
    }

    public String getTlfOficina() {
        return tlfOficina;
    }
    public void setTlfOficina(String tlfOficina) {
        this.tlfOficina = tlfOficina;
    }

    public String getExtension() {return extension;}
    public void setExtension(String extension) {this.extension = extension;}

    public String getTlfOficinaComp(){return tlfOficinaComp;}
    public void setTlfOficinaComp(String tlfOficinaComp){this.tlfOficinaComp = tlfOficinaComp;}

    public String getEmail1(){
        return email1;
    }
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2(){
        return email2;
    }
    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getCodigoIdentificador() {return codigoIdentificador;}
    public void setCodigoIdentificador(String codigoIdentificador) {this.codigoIdentificador = codigoIdentificador;}

    public String getIndicativo(){
        return indicativo;
    }
    public void setIndicativo(String indicativo){
        this.indicativo = indicativo;
    }

    public String getRol(){
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNumUnidadRiesgo(){
        return numUnidadRiesgo;
    }
    public void setNumUnidadRiesgo(String numUnidadRiesgo) {
        this.numUnidadRiesgo = numUnidadRiesgo;
    }

    public String getTipoObjAsegurado() {
        return tipoObjAsegurado;
    }
    public void setTipoObjAsegurado(String tipoObjAsegurado) {
        this.tipoObjAsegurado = tipoObjAsegurado;
    }

    public String getNumObjAsegurado() {return numObjAsegurado;}
    public void setNumObjAsegurado(String numObjAsegurado) {this.numObjAsegurado = numObjAsegurado;}

    public String getNombreAsegurado(){return nombreAsegurado;}
    public void setNombreAsegurado(String nombreAsegurado){this.nombreAsegurado = nombreAsegurado;}

    public String getNombreBeneficiario(){return nombreBeneficiario;}
    public void setNombreBeneficiario(String nombreBeneficiario){this.nombreBeneficiario = nombreBeneficiario;}

    public static ArrayList getBusquedaAvanzadaSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,ORDEN,PRODUCTO,EVENTO,SUCURSAL,NUM_POLIZA,EMISION,TIPO_PRODUCCION,CANAL_VENTA,FRECUENCIA_PAGO,TIPO_POLIZA,TIPO_TERCERO,TIPO_DOCUMENTO,NUM_DOCUMENTO,NOMBRE_APELLIDO,FECHA_INCLUSION,TLF_OFICINA,EXTENSION,TLF_OFICINA_COMPLETO,EMAIL_1,EMAIL_2,CODIGO_INTERNO,CODIGO_IDENTIFICADOR,INDICATIVO,ROL,NUM_UNIDAD_RIESGO,TIPO_OBJ_ASEGURADO,NUM_OBJ_ASEGURADO,NOMBRE_ASEGURADO,NOMBRE_BENEFICIARIO FROM BUSQUEDA_AVANZADA_SINIESTRO ORDER BY PRUEBA ASC");

        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean = new BusquedaAvanzadaSiniestroBean();
                busquedaAvanzadaSiniestroBean.setOrdenar(rs.getString("ORDEN"));
                busquedaAvanzadaSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                busquedaAvanzadaSiniestroBean.setEvento(rs.getString("EVENTO"));
                busquedaAvanzadaSiniestroBean.setSucursal(rs.getString("SUCURSAL"));
                busquedaAvanzadaSiniestroBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                busquedaAvanzadaSiniestroBean.setEmision(rs.getString("EMISION"));
                busquedaAvanzadaSiniestroBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                busquedaAvanzadaSiniestroBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                busquedaAvanzadaSiniestroBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                busquedaAvanzadaSiniestroBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                busquedaAvanzadaSiniestroBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                busquedaAvanzadaSiniestroBean.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                busquedaAvanzadaSiniestroBean.setNumDocumento(rs.getString("NUM_DOCUMENTO"));
                busquedaAvanzadaSiniestroBean.setNombreApellido(rs.getString("NOMBRE_APELLIDO"));
                busquedaAvanzadaSiniestroBean.setFechaInclusion(rs.getString("FECHA_INCLUSION"));
                busquedaAvanzadaSiniestroBean.setTlfOficina(rs.getString("TLF_OFICINA"));
                busquedaAvanzadaSiniestroBean.setExtension(rs.getString("EXTENSION"));
                busquedaAvanzadaSiniestroBean.setTlfOficinaComp(rs.getString("TLF_OFICINA_COMPLETO"));
                busquedaAvanzadaSiniestroBean.setEmail1(rs.getString("EMAIL_1"));
                busquedaAvanzadaSiniestroBean.setEmail2(rs.getString("EMAIL_2"));
                busquedaAvanzadaSiniestroBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                busquedaAvanzadaSiniestroBean.setCodigoIdentificador(rs.getString("CODIGO_IDENTIFICADOR"));
                busquedaAvanzadaSiniestroBean.setIndicativo(rs.getString("INDICATIVO"));
                busquedaAvanzadaSiniestroBean.setRol(rs.getString("ROL"));
                busquedaAvanzadaSiniestroBean.setNumUnidadRiesgo(rs.getString("NUM_UNIDAD_RIESGO"));
                busquedaAvanzadaSiniestroBean.setTipoObjAsegurado(rs.getString("TIPO_OBJ_ASEGURADO"));
                busquedaAvanzadaSiniestroBean.setNumObjAsegurado(rs.getString("NUM_OBJ_ASEGURADO"));
                busquedaAvanzadaSiniestroBean.setNombreAsegurado(rs.getString("NOMBRE_ASEGURADO"));
                busquedaAvanzadaSiniestroBean.setNombreBeneficiario(rs.getString("NOMBRE_BENEFICIARIO"));
                caja.add(busquedaAvanzadaSiniestroBean);
            }

        }catch(SQLException e){

            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return caja;
    }
}
