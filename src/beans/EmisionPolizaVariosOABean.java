package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 20/07/2016.
 */
public class EmisionPolizaVariosOABean implements Serializable {

    private String productoOA;
    private String vigenciaOA;
    private String fechaDesdeOA;
    private String fechaHastaOA;
    private String eventoAplicarOA;
    private String sucursalOA;
    private String tipoProduccionOA;
    private String periodoGraciaOA;
    private String lineaCreditoOA;
    private String unidadNegocioOA;
    private String canalVentaOA;
    private String tipoValorAseguradoOA;
    private String tasaOA;
    private String tipoTasaOA;
    private String tipoTerceroOA;
    private String tipoDocIdOA;
    private String cedulaOA;
    private String nombreOA;
    private String apellidoOA;
    private String porcenTomadorOA;
    private String numUnidRiesgoOA;
    private String numCreditoOA;
    private String montoAsegOA;
    private String porcenExtraPrima1OA;
    private String porcenDescuento1OA;
    private String porcenExtraPrima2OA;
    private String porcenDescuento2OA;

    public String getProductoOA(){
        return productoOA;
    }
    public void setProductoOA(String productoOA){
        this.productoOA = productoOA;
    }

    public String getVigenciaOA(){
        return vigenciaOA;
    }
    public void setVigenciaOA(String vigenciaOA){
        this.vigenciaOA = vigenciaOA;
    }

    public String getFechaDesdeOA(){
        return fechaDesdeOA;
    }
    public void setFechaDesdeOA(String fechaDesdeOA){
        this.fechaDesdeOA = fechaDesdeOA;
    }

    public String getFechaHastaOA(){
        return fechaHastaOA;
    }
    public void setFechaHastaOA(String fechaHastaOA){
        this.fechaHastaOA = fechaHastaOA;
    }

    public String getEventoAplicarOA(){
        return eventoAplicarOA;
    }
    public void setEventoAplicarOA(String eventoAplicarOA){
        this.eventoAplicarOA = eventoAplicarOA;
    }

    public String getSucursalOA(){
        return sucursalOA;
    }
    public void setSucursalOA(String sucursalOA){
        this.sucursalOA = sucursalOA;
    }

    public String getTipoProduccionOA(){
        return tipoProduccionOA;
    }
    public void setTipoProduccionOA(String tipoProduccionOA){
        this.tipoProduccionOA = tipoProduccionOA;
    }

    public String getPeriodoGraciaOA(){
        return periodoGraciaOA;
    }
    public void setPeriodoGraciaOA(String periodoGraciaOA){
        this.periodoGraciaOA = periodoGraciaOA;
    }

    public String getLineaCreditoOA(){
        return lineaCreditoOA;
    }
    public void setLineaCreditoOA(String lineaCreditoOA){
        this.lineaCreditoOA = lineaCreditoOA;
    }

    public String getUnidadNegocioOA(){
        return unidadNegocioOA;
    }
    public void setUnidadNegocioOA(String unidadNegocioOA){
        this.unidadNegocioOA = unidadNegocioOA;
    }

    public String getCanalVentaOA(){
        return canalVentaOA;
    }
    public void setCanalVentaOA(String canalVentaOA){
        this.canalVentaOA = canalVentaOA;
    }

    public String getTipoValorAseguradoOA(){
        return tipoValorAseguradoOA;
    }
    public void setTipoValorAseguradoOA(String tipoValorAseguradoOA){
        this.tipoValorAseguradoOA = tipoValorAseguradoOA;
    }

    public String getTasaOA(){
        return tasaOA;
    }
    public void setTasaOA(String tasaOA){
        this.tasaOA = tasaOA;
    }

    public String getTipoTasaOA(){
        return tipoTasaOA;
    }
    public void setTipoTasaOA(String tipoTasaOA){
        this.tipoTasaOA = tipoTasaOA;
    }

    public String getTipoTerceroOA(){
        return tipoTerceroOA;
    }
    public void setTipoTerceroOA(String tipoTerceroOA){
        this.tipoTerceroOA = tipoTerceroOA;
    }

    public String getTipoDocIdOA(){
        return tipoDocIdOA;
    }
    public void setTipoDocIdOA(String tipoDocIdOA){
        this.tipoDocIdOA = tipoDocIdOA;
    }

    public String getCedulaOA(){
        return cedulaOA;
    }
    public void setCedulaOA(String cedulaOA){
        this.cedulaOA = cedulaOA;
    }

    public String getNombreOA(){
        return nombreOA;
    }
    public void setNombreOA(String nombreOA){
        this.nombreOA = nombreOA;
    }

    public String getApellidoOA(){
        return apellidoOA;
    }
    public void setApellidoOA(String apellidoOA){
        this.apellidoOA = apellidoOA;
    }

    public String getPorcenTomadorOA(){
        return porcenTomadorOA;
    }
    public void setPorcenTomadorOA(String porcenTomadorOA){
        this.porcenTomadorOA = porcenTomadorOA;
    }

    public String getNumUnidRiesgoOA(){
        return numUnidRiesgoOA;
    }
    public void setNumUnidRiesgoOA(String numUnidRiesgoOA){
        this.numUnidRiesgoOA = numUnidRiesgoOA;
    }

    public String getNumCreditoOA(){
        return numCreditoOA;
    }
    public void setNumCreditoOA(String numCreditoOA){
        this.numCreditoOA = numCreditoOA;
    }

    public String getMontoAsegOA(){
        return montoAsegOA;
    }
    public void setMontoAsegOA(String montoAsegOA){
        this.montoAsegOA = montoAsegOA;
    }

    public String getPorcenExtraPrima1OA(){
        return porcenExtraPrima1OA;
    }
    public void setPorcenExtraPrima1OA(String porcenExtraPrima1OA){
        this.porcenExtraPrima1OA = porcenExtraPrima1OA;
    }

    public String getPorcenDescuento1OA(){
        return porcenDescuento1OA;
    }
    public void setPorcenDescuento1OA(String porcenDescuento1OA){
        this.porcenDescuento1OA = porcenDescuento1OA;
    }

    public String getPorcenExtraPrima2OA(){
        return porcenExtraPrima2OA;
    }
    public void setPorcenExtraPrima2OA(String porcenExtraPrima2OA){
        this.porcenExtraPrima2OA = porcenExtraPrima2OA;
    }

    public String getPorcenDescuento2OA(){
        return porcenDescuento2OA;
    }
    public void setPorcenDescuento2OA(String porcenDescuento2OA){
        this.porcenDescuento2OA = porcenDescuento2OA;
    }

    public static ArrayList getEmisionPolizaVariosOA(){
        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2, PORCETAJE_DESCUENTO_2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaVariosOABean emisionPolizaVariosOABean = new EmisionPolizaVariosOABean();
                // , PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA,
                // EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA,
                // LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO,
                // TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE,
                // APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO,
                // PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2,
                // PORCETAJE_DESCUENTO_2
                emisionPolizaVariosOABean.setProductoOA(rs.getString("PRODUCTO"));
                poliza.add(emisionPolizaVariosOABean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return poliza;
    }
}
