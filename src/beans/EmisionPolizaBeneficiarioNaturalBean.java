package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 02/08/2016.
 */
public class EmisionPolizaBeneficiarioNaturalBean implements Serializable {

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
    private String tipoTerceroT;
    private String tipoDocIdT;
    private String cedulaT;
    private String nombreT;
    private String apellidoT;
    private String porcentajeTomador;
    private String numUnidadRiesgo;
    private String numCredito;
    private String montoAsegurado;
    private String tipoTerceroAsegVida1;
    private String tipoDocIdAsegVida1;
    private String cedulaAsegVida1;
    private String nombreAsegVida1;
    private String apellidoAsegVida1;
    private String porcentajeAsegVida1;
    private String tipoTerceroAsegVida2;
    private String tipoDocIdAsegVida2;
    private String cedulaAsegVida2;
    private String nombreAsegVida2;
    private String apellidoAsegVida2;
    private String porcentajeAsegVida2;
    private String nuevoPorcentajeAsegVida1;

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

    public String getTipoTerceroT(){
        return tipoTerceroT;
    }
    public void setTipoTerceroT(String tipoTerceroT){
        this.tipoTerceroT = tipoTerceroT;
    }

    public String getTipoDocIdT(){
        return tipoDocIdT;
    }
    public void setTipoDocIdT(String tipoDocIdT){
        this.tipoDocIdT = tipoDocIdT;
    }

    public String getCedulaT(){
        return cedulaT;
    }
    public void setCedulaT(String cedulaT){
        this.cedulaT = cedulaT;
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

    public String getPorcentajeTomador(){
        return porcentajeTomador;
    }
    public void setPorcentajeTomador(String porcentajeTomador){
        this.porcentajeTomador = porcentajeTomador;
    }

    public String getNumUnidadRiesgo(){
        return numUnidadRiesgo;
    }
    public void setNumUnidadRiesgo(String numUnidadRiesgo){
        this.numUnidadRiesgo = numUnidadRiesgo;
    }

    public String getNumCredito(){
        return numCredito;
    }
    public void setNumCredito(String numCredito){
        this.numCredito = numCredito;
    }

    public String getMontoAsegurado(){
        return montoAsegurado;
    }
    public void setMontoAsegurado(String montoAsegurado){
        this.montoAsegurado = montoAsegurado;
    }

    public String getTipoTerceroAsegVida1(){
        return tipoTerceroAsegVida1;
    }
    public void setTipoTerceroAsegVida1(String tipoTerceroAsegVida1){
        this.tipoTerceroAsegVida1 = tipoTerceroAsegVida1;
    }

    public String getTipoDocIdAsegVida1(){
        return tipoDocIdAsegVida1;
    }
    public void setTipoDocIdAsegVida1(String tipoDocIdAsegVida1){
        this.tipoDocIdAsegVida1 = tipoDocIdAsegVida1;
    }

    public String getCedulaAsegVida1(){
        return cedulaAsegVida1;
    }
    public void setCedulaAsegVida1(String cedulaAsegVida1){
        this.cedulaAsegVida1 = cedulaAsegVida1;
    }

    public String getNombreAsegVida1(){
        return nombreAsegVida1;
    }
    public void setNombreAsegVida1(String nombreAsegVida1){
        this.nombreAsegVida1 = nombreAsegVida1;
    }

    public String getApellidoAsegVida1(){
        return apellidoAsegVida1;
    }
    public void setApellidoAsegVida1(String apellidoAsegVida1){
        this.apellidoAsegVida1 = apellidoAsegVida1;
    }

    public String getPorcentajeAsegVida1(){
        return porcentajeAsegVida1;
    }
    public void setPorcentajeAsegVida1(String porcentajeAsegVida1){
        this.porcentajeAsegVida1 = porcentajeAsegVida1;
    }

    public String getTipoTerceroAsegVida2(){
        return tipoTerceroAsegVida2;
    }
    public void setTipoTerceroAsegVida2(String tipoTerceroAsegVida2){
        this.tipoTerceroAsegVida2 = tipoTerceroAsegVida2;
    }

    public String getTipoDocIdAsegVida2(){
        return tipoDocIdAsegVida2;
    }
    public void setTipoDocIdAsegVida2(String tipoDocIdAsegVida2){
        this.tipoDocIdAsegVida2 = tipoDocIdAsegVida2;
    }

    public String getCedulaAsegVida2(){
        return cedulaAsegVida2;
    }
    public void setCedulaAsegVida2(String cedulaAsegVida2){
        this.cedulaAsegVida2 = cedulaAsegVida2;
    }

    public String getNombreAsegVida2(){
        return nombreAsegVida2;
    }
    public void setNombreAsegVida2(String nombreAsegVida2){
        this.nombreAsegVida2 = nombreAsegVida2;
    }

    public String getApellidoAsegVida2(){
        return apellidoAsegVida2;
    }
    public void setApellidoAsegVida2(String apellidoAsegVida2){
        this.apellidoAsegVida2 = apellidoAsegVida2;
    }

    public String getPorcentajeAsegVida2(){
        return porcentajeAsegVida2;
    }
    public void setPorcentajeAsegVida2(String porcentajeAsegVida2){
        this.porcentajeAsegVida2 = porcentajeAsegVida2;
    }

    public String getNuevoPorcentajeAsegVida1(){
        return nuevoPorcentajeAsegVida1;
    }
    public void setNuevoPorcentajeAsegVida1(String nuevoPorcentajeAsegVida1){
        this.nuevoPorcentajeAsegVida1 = nuevoPorcentajeAsegVida1;
    }

    public static ArrayList getEmisionPolizaBeneficiarioNatural(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO_T, TIPO_DOC_IDENTIDAD_T, CEDULA_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, TIPO_TERCERO_ASEG_VIDA_1, TIPO_DOC_IDENTIDAD_ASEG_VIDA_1, CEDULA_ASEG_VIDA_1, NOMBRE_ASEG_VIDA_1, APELLIDO_ASEG_VIDA_1, PORCENTAJE_ASEG_VIDA_1, TIPO_TERCERO_ASEG_VIDA_2, TIPO_DOC_IDENTIDAD_ASEG_VIDA_2, CEDULA_ASEG_VIDA_2, NOMBRE_ASEG_VIDA_2, APELLIDO_ASEG_VIDA_2, PORCENTAJE_ASEG_VIDA_2, NUEVO_PORCENTAJE_ASEG_VIDA_1 FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaBeneficiarioNaturalBean emisionPolizaBeneficiarioNaturalBean = new EmisionPolizaBeneficiarioNaturalBean();

                emisionPolizaBeneficiarioNaturalBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaBeneficiarioNaturalBean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaBeneficiarioNaturalBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaBeneficiarioNaturalBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaBeneficiarioNaturalBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaBeneficiarioNaturalBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaBeneficiarioNaturalBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaBeneficiarioNaturalBean.setPeriodoGracia(rs.getString("PERIODO_GRACIA"));
                emisionPolizaBeneficiarioNaturalBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaBeneficiarioNaturalBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaBeneficiarioNaturalBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaBeneficiarioNaturalBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setTasa(rs.getString("TASA"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTasa(rs.getString("TIPO_TASA"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTerceroT(rs.getString("TIPO_TERCERO_T"));
                emisionPolizaBeneficiarioNaturalBean.setTipoDocIdT(rs.getString("TIPO_DOC_IDENTIDAD_T"));
                emisionPolizaBeneficiarioNaturalBean.setCedulaT(rs.getString("CEDULA_T"));
                emisionPolizaBeneficiarioNaturalBean.setNombreT(rs.getString("NOMBRE_T"));
                emisionPolizaBeneficiarioNaturalBean.setApellidoT(rs.getString("APELLIDO_T"));
                emisionPolizaBeneficiarioNaturalBean.setPorcentajeTomador(rs.getString("PORCENTAJE_TOMADOR"));
                emisionPolizaBeneficiarioNaturalBean.setNumUnidadRiesgo(rs.getString("NUM_UNIDAD_RIESGO"));
                emisionPolizaBeneficiarioNaturalBean.setNumCredito(rs.getString("NUM_CREDITO"));
                emisionPolizaBeneficiarioNaturalBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTerceroAsegVida1(rs.getString("TIPO_TERCERO_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setTipoDocIdAsegVida1(rs.getString("TIPO_DOC_IDENTIDAD_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setCedulaAsegVida1(rs.getString("CEDULA_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setNombreAsegVida1(rs.getString("NOMBRE_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setApellidoAsegVida1(rs.getString("APELLIDO_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setPorcentajeAsegVida1(rs.getString("PORCENTAJE_ASEG_VIDA_1"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTerceroAsegVida2(rs.getString("TIPO_TERCERO_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setTipoDocIdAsegVida2(rs.getString("TIPO_DOC_IDENTIDAD_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setCedulaAsegVida2(rs.getString("CEDULA_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setNombreAsegVida2(rs.getString("NOMBRE_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setApellidoAsegVida2(rs.getString("APELLIDO_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setPorcentajeAsegVida2(rs.getString("PORCENTAJE_ASEG_VIDA_2"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoPorcentajeAsegVida1(rs.getString("NUEVO_PORCENTAJE_ASEG_VIDA_1"));
                emision.add(emisionPolizaBeneficiarioNaturalBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return emision;
    }
}

// PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR,
// SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO,
// CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO_T, TIPO_DOC_IDENTIDAD_T,
// CEDULA_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO,
// MONTO_ASEGURADO, TIPO_TERCERO_ASEG_VIDA_1, TIPO_DOC_IDENTIDAD_ASEG_VIDA_1, CEDULA_ASEG_VIDA_1,
// NOMBRE_ASEG_VIDA_1, APELLIDO_ASEG_VIDA_1, PORCENTAJE_ASEG_VIDA_1, TIPO_TERCERO_ASEG_VIDA_2,
// TIPO_DOC_IDENTIDAD_ASEG_VIDA_2, CEDULA_ASEG_VIDA_2, NOMBRE_ASEG_VIDA_2, APELLIDO_ASEG_VIDA_2,
// PORCENTAJE_ASEG_VIDA_2, NUEVO_PORCENTAJE_ASEG_VIDA_1
