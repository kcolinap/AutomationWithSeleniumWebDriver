package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 11/08/2016.
 */
public class EmisionPolizaAseguradoVidaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaAseguradoVidaBean.class);

    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String fechaMovimiento;
    private String fechaEfectivaApliEv;
    private String planFinanciamiento;
    private String moneda;
    private String sucursal;
    private String numPoliza;
    private String tipoProduccion;
    private String periodoGraciaDias;
    private String lineaCredito;
    private String horaIniVencimiento;
    private String unidadNegocio;
    private String canalVenta;
    private String frecuencuaPago;
    private String tipoPoliza;
    private String tipoValorAsegurado;
    private String nivelAgrupaReaseguro;
    private String permManejoCtaProv;
    private String tipoTerceroT;
    private String tipoDocIdT;
    private String numDocIdT;
    private String nombreT;
    private String apellidoT;
    private String porcentajeT;
    private String numUnidadRiesgo;
    private String numCredito;
    private String montoAsegurado;
    private String factorVida;
    private String valorSeguroPrima;
    private String fechaDesembolso;
    private String valorPrestamo;
    private String cuotasPactadas;
    private String saldoCapital;
    private String edoCredito;
    private String cuotasMora;
    private String fechaProceso;
    private String fechaPago;
    private String cuotaPagada;
    private String fechaMora;
    private String porcFacultativo;
    private String aseguradoPrimario;
    private String porcExtraPrima;
    private String porcDescuento;
    private String docIdAsegurado;
    private String fechaNacAsegurado;
    private String direccionAsegurado;
    private String telefonoFijo;
    private String departamento;
    private String ciudad;
    private String tipoTerceroAV;
    private String tipoDocIdAV;
    private String numDocIdAV;
    private String nombreAV;
    private String apellidoAV;
    private String porcentajeAV;
    private String nuevoPorcentajeAV;



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

    public String getFechaMovimiento(){
        return fechaMovimiento;
    }
    public void setFechaMovimiento(String fechaMovimiento){
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getFechaEfectivaApliEv(){
        return fechaEfectivaApliEv;
    }
    public void setFechaEfectivaApliEv(String fechaEfectivaApliEv){
        this.fechaEfectivaApliEv = fechaEfectivaApliEv;
    }

    public String getPlanFinanciamiento(){
        return planFinanciamiento;
    }
    public void setPlanFinanciamiento(String planFinanciamiento){
        this.planFinanciamiento = planFinanciamiento;
    }

    public String getMoneda(){
        return moneda;
    }
    public void setMoneda(String moneda){
        this.moneda = moneda;
    }

    public String getSucursal(){
        return sucursal;
    }
    public void setSucursal(String sucursal){
        this.sucursal = sucursal;
    }

    public String getNumPoliza(){
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza){
        this.numPoliza = numPoliza;
    }

    public String getTipoProduccion(){
        return tipoProduccion;
    }
    public void setTipoProduccion(String tipoProduccion){
        this.tipoProduccion = tipoProduccion;
    }

    public String getPeriodoGraciaDias(){
        return periodoGraciaDias;
    }
    public void setPeriodoGraciaDias(String periodoGraciaDias){
        this.periodoGraciaDias = periodoGraciaDias;
    }

    public String getLineaCredito(){
        return lineaCredito;
    }
    public void setLineaCredito(String lineaCredito){
        this.lineaCredito = lineaCredito;
    }

    public String getHoraIniVencimiento(){
        return horaIniVencimiento;
    }
    public void setHoraIniVencimiento(String horaIniVencimiento){
        this.horaIniVencimiento = horaIniVencimiento;
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

    public String getFrecuencuaPago(){
        return frecuencuaPago;
    }
    public void setFrecuencuaPago(String frecuencuaPago){
        this.frecuencuaPago = frecuencuaPago;
    }

    public String getTipoPoliza(){
        return tipoPoliza;
    }
    public void setTipoPoliza(String tipoPoliza){
        this.tipoPoliza = tipoPoliza;
    }

    public String getTipoValorAsegurado(){
        return tipoValorAsegurado;
    }
    public void setTipoValorAsegurado(String tipoValorAsegurado){
        this.tipoValorAsegurado = tipoValorAsegurado;
    }

    public String getNivelAgrupaReaseguro(){
        return nivelAgrupaReaseguro;
    }
    public void setNivelAgrupaReaseguro(String nivelAgrupaReaseguro){
        this.nivelAgrupaReaseguro = nivelAgrupaReaseguro;
    }

    public String getPermManejoCtaProv(){
        return permManejoCtaProv;
    }
    public void setPermManejoCtaProv(String permManejoCtaProv){
        this.permManejoCtaProv = permManejoCtaProv;
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

    public String getNumDocIdT(){
        return numDocIdT;
    }
    public void setNumDocIdT(String numDocIdT){
        this.numDocIdT = numDocIdT;
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

    public String getPorcentajeT(){
        return porcentajeT;
    }
    public void setPorcentajeT(String porcentajeT){
        this.porcentajeT = porcentajeT;
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

    public String getFactorVida(){
        return factorVida;
    }
    public void setFactorVida(String factorVida){
        this.factorVida = factorVida;
    }

    public String getValorSeguroPrima(){
        return valorSeguroPrima;
    }
    public void setValorSeguroPrima(String valorSeguroPrima){
        this.valorSeguroPrima = valorSeguroPrima;
    }

    public String getFechaDesembolso(){
        return fechaDesembolso;
    }
    public void setFechaDesembolso(String fechaDesembolso){
        this.fechaDesembolso = fechaDesembolso;
    }

    public String getValorPrestamo(){
        return valorPrestamo;
    }
    public void setValorPrestamo(String valorPrestamo){
        this.valorPrestamo = valorPrestamo;
    }

    public String getCuotasPactadas(){
        return cuotasPactadas;
    }
    public void setCuotasPactadas(String cuotasPactadas){
        this.cuotasPactadas = cuotasPactadas;
    }

    public String getSaldoCapital(){
        return saldoCapital;
    }
    public void setSaldoCapital(String saldoCapital){
        this.saldoCapital = saldoCapital;
    }

    public String getEdoCredito(){
        return edoCredito;
    }
    public void setEdoCredito(String edoCredito){
        this.edoCredito = edoCredito;
    }

    public String getCuotasMora(){
        return cuotasMora;
    }
    public void setCuotasMora(String cuotasMora){
        this.cuotasMora = cuotasMora;
    }

    public String getFechaProceso(){
        return fechaProceso;
    }
    public void setFechaProceso(String fechaProceso){
        this.fechaProceso = fechaProceso;
    }

    public String getFechaPago(){
        return fechaPago;
    }
    public void setFechaPago(String fechaPago){
        this.fechaPago = fechaPago;
    }

    public String getCuotaPagada(){
        return cuotaPagada;
    }
    public void setCuotaPagada(String cuotaPagada){
        this.cuotaPagada = cuotaPagada;
    }

    public String getFechaMora(){
        return fechaMora;
    }
    public void setFechaMora(String fechaMora){
        this.fechaMora = fechaMora;
    }

    public String getPorcFacultativo(){
        return porcFacultativo;
    }
    public void setPorcFacultativo(String porcFacultativo){
        this.porcFacultativo = porcFacultativo;
    }

    public String getAseguradoPrimario(){
        return aseguradoPrimario;
    }
    public void setAseguradoPrimario(String aseguradoPrimario){
        this.aseguradoPrimario = aseguradoPrimario;
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

    public String getDocIdAsegurado(){
        return docIdAsegurado;
    }
    public void setDocIdAsegurado(String docIdAsegurado){
        this.docIdAsegurado = docIdAsegurado;
    }

    public String getFechaNacAsegurado(){
        return fechaNacAsegurado;
    }
    public void setFechaNacAsegurado(String fechaNacAsegurado){
        this.fechaNacAsegurado = fechaNacAsegurado;
    }

    public String getDireccionAsegurado(){
        return direccionAsegurado;
    }
    public void setDireccionAsegurado(String direccionAsegurado){
        this.direccionAsegurado = direccionAsegurado;
    }

    public String getTelefonoFijo(){
        return telefonoFijo;
    }
    public void setTelefonoFijo(String telefonoFijo){
        this.telefonoFijo = telefonoFijo;
    }

    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    public String getCiudad(){
        return ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getTipoTerceroAV(){
        return tipoTerceroAV;
    }
    public void setTipoTerceroAV(String tipoTerceroAV){
        this.tipoTerceroAV = tipoTerceroAV;
    }

    public String getTipoDocIdAV(){
        return tipoDocIdAV;
    }
    public void setTipoDocIdAV(String tipoDocIdAV){
        this.tipoDocIdAV = tipoDocIdAV;
    }

    public String getNumDocIdAV(){
        return numDocIdAV;
    }
    public void setNumDocIdAV(String numDocIdAV){
        this.numDocIdAV = numDocIdAV;
    }

    public String getNombreAV(){
        return nombreAV;
    }
    public void setNombreAV(String nombreAV){
        this.nombreAV = nombreAV;
    }

    public String getApellidoAV(){
        return apellidoAV;
    }
    public void setApellidoAV(String apellidoAV){
        this.apellidoAV = apellidoAV;
    }

    public String getPorcentajeAV(){
        return porcentajeAV;
    }
    public void setPorcentajeAV(String porcentajeAV){
        this.porcentajeAV = porcentajeAV;
    }

    public String getNuevoPorcentajeAV(){
        return nuevoPorcentajeAV;
    }
    public void setNuevoPorcentajeAV(String nuevoPorcentajeAV){
        this.nuevoPorcentajeAV = nuevoPorcentajeAV;
    }

    public static ArrayList getEmisionPolizaAseguradoVida() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO, HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV, TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_T, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_AV, TIPO_DOC_ID_AV, NUM_DOCUMENTO_ID_AV, NOMBRE_AV, APELLIDO_AV, PORCENTAJE_AV, NUEVO_PORCENTAJE_AV FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean = new EmisionPolizaAseguradoVidaBean();

                emisionPolizaAseguradoVidaBean.setProducto(rs.getString("PRODUCTO"));
                emisionPolizaAseguradoVidaBean.setVigencia(rs.getString("VIGENCIA"));
                emisionPolizaAseguradoVidaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                emisionPolizaAseguradoVidaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                emisionPolizaAseguradoVidaBean.setEventoAplicar(rs.getString("EVENTO_APLICAR"));
                emisionPolizaAseguradoVidaBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                emisionPolizaAseguradoVidaBean.setFechaEfectivaApliEv(rs.getString("FECHA_EFECTIVA_APLI_EV"));
                emisionPolizaAseguradoVidaBean.setPlanFinanciamiento(rs.getString("PLAN_FINANCIAMIENTO"));
                emisionPolizaAseguradoVidaBean.setMoneda(rs.getString("MONEDA"));
                emisionPolizaAseguradoVidaBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaAseguradoVidaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                emisionPolizaAseguradoVidaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaAseguradoVidaBean.setPeriodoGraciaDias(rs.getString("PERIODO_GRACIA_DIAS"));
                emisionPolizaAseguradoVidaBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaAseguradoVidaBean.setHoraIniVencimiento(rs.getString("HORA_INI_VENCIMIENTO"));
                emisionPolizaAseguradoVidaBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaAseguradoVidaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaAseguradoVidaBean.setFrecuencuaPago(rs.getString("FRECUENCIA_PAGO"));
                emisionPolizaAseguradoVidaBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                emisionPolizaAseguradoVidaBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaAseguradoVidaBean.setNivelAgrupaReaseguro(rs.getString("NIVEL_AGRUPAMIENTO_REASEGURO"));
                emisionPolizaAseguradoVidaBean.setPermManejoCtaProv(rs.getString("PERM_MANEJO_CTA_PROV"));
                emisionPolizaAseguradoVidaBean.setTipoTerceroT(rs.getString("TIPO_TERCERO_T"));
                emisionPolizaAseguradoVidaBean.setTipoDocIdT(rs.getString("TIPO_DOC_ID_T"));
                emisionPolizaAseguradoVidaBean.setNumDocIdT(rs.getString("NUM_DOCUMENTO_ID_T"));
                emisionPolizaAseguradoVidaBean.setNombreT(rs.getString("NOMBRE_T"));
                emisionPolizaAseguradoVidaBean.setApellidoT(rs.getString("APELLIDO_T"));
                emisionPolizaAseguradoVidaBean.setPorcentajeT(rs.getString("PORCENTAJE_T"));
                emisionPolizaAseguradoVidaBean.setNumUnidadRiesgo(rs.getString("NUM_UNIDAD_RIESGO"));
                emisionPolizaAseguradoVidaBean.setNumCredito(rs.getString("NUM_CREDITO"));
                emisionPolizaAseguradoVidaBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                emisionPolizaAseguradoVidaBean.setFactorVida(rs.getString("FACTOR_VIDA"));
                emisionPolizaAseguradoVidaBean.setValorSeguroPrima(rs.getString("VALOR_SEGURO_PRIMA"));
                emisionPolizaAseguradoVidaBean.setFechaDesembolso(rs.getString("FECHA_DESEMBOLSO"));
                emisionPolizaAseguradoVidaBean.setValorPrestamo(rs.getString("VALOR_PRESTAMO"));
                emisionPolizaAseguradoVidaBean.setCuotasPactadas(rs.getString("CUOTAS_PACTADAS"));
                emisionPolizaAseguradoVidaBean.setSaldoCapital(rs.getString("SALDO_CAPITAL"));
                emisionPolizaAseguradoVidaBean.setEdoCredito(rs.getString("ESTADO_CREDITO"));
                emisionPolizaAseguradoVidaBean.setCuotasMora(rs.getString("CUOTAS_MORA"));
                emisionPolizaAseguradoVidaBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                emisionPolizaAseguradoVidaBean.setFechaPago(rs.getString("FECHA_PAGO"));
                emisionPolizaAseguradoVidaBean.setCuotaPagada(rs.getString("CUOTA_PAGADA"));
                emisionPolizaAseguradoVidaBean.setFechaMora(rs.getString("FECHA_MORA"));
                emisionPolizaAseguradoVidaBean.setPorcFacultativo(rs.getString("PORCENTAJE_FACULTATIVO"));
                emisionPolizaAseguradoVidaBean.setAseguradoPrimario(rs.getString("ASEGURADO_PRIMARIO"));
                emisionPolizaAseguradoVidaBean.setPorcExtraPrima(rs.getString("PORCETAJE_EXTRA_PRIMA"));
                emisionPolizaAseguradoVidaBean.setPorcDescuento(rs.getString("PORCETAJE_DESCUENTO"));
                emisionPolizaAseguradoVidaBean.setDocIdAsegurado(rs.getString("DOC_ID_ASEGURADO"));
                emisionPolizaAseguradoVidaBean.setFechaNacAsegurado(rs.getString("FECHA_NAC_ASEGURADO"));
                emisionPolizaAseguradoVidaBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                emisionPolizaAseguradoVidaBean.setTelefonoFijo(rs.getString("TELEFONO_FIJO"));
                emisionPolizaAseguradoVidaBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                emisionPolizaAseguradoVidaBean.setCiudad(rs.getString("CIUDAD"));
                emisionPolizaAseguradoVidaBean.setTipoTerceroAV(rs.getString("TIPO_TERCERO_AV"));
                emisionPolizaAseguradoVidaBean.setTipoDocIdAV(rs.getString("TIPO_DOC_ID_AV"));
                emisionPolizaAseguradoVidaBean.setNumDocIdAV(rs.getString("NUM_DOCUMENTO_ID_AV"));
                emisionPolizaAseguradoVidaBean.setNombreAV(rs.getString("NOMBRE_AV"));
                emisionPolizaAseguradoVidaBean.setApellidoAV(rs.getString("APELLIDO_AV"));
                emisionPolizaAseguradoVidaBean.setPorcentajeAV(rs.getString("PORCENTAJE_AV"));
                emisionPolizaAseguradoVidaBean.setNuevoPorcentajeAV(rs.getString("NUEVO_PORCENTAJE_AV"));

                emision.add(emisionPolizaAseguradoVidaBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return emision;
    }
}
