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
 * Created by agil on 02/08/2016.
 */
public class EmisionPolizaBeneficiarioNaturalBean implements Serializable {

    private final static Logger log = Logger.getLogger(EmisionPolizaBeneficiarioNaturalBean.class);

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
    private String tipoTerceroBN;
    private String tipoDocIdBN;
    private String numDocIdBN;
    private String nombreBN;
    private String apellidoBN;
    private String tipoBeneficiario;
    private String beneficiarioIrrevocable;
    private String porcBeneficiario;
    private String codBeneficiario;
    private String parentezco;
    private String nuevoTipoBeneficiario;
    private String nuevoBeneficiarioIrrevocable;
    private String nuevoPorcBeneficiario;
    private String nuevoCodBeneficiario;
    private String nuevoParentezco;


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

    public String getTipoTerceroBN(){
        return tipoTerceroBN;
    }
    public void setTipoTerceroBN(String tipoTerceroBN){
        this.tipoTerceroBN = tipoTerceroBN;
    }

    public String getTipoDocIdBN(){
        return tipoDocIdBN;
    }
    public void setTipoDocIdBN(String tipoDocIdBN){
        this.tipoDocIdBN = tipoDocIdBN;
    }

    public String getNumDocIdBN(){
        return numDocIdBN;
    }
    public void setNumDocIdBN(String numDocIdBN){
        this.numDocIdBN = numDocIdBN;
    }

    public String getNombreBN(){
        return nombreBN;
    }
    public void setNombreBN(String nombreBN){
        this.nombreBN = nombreBN;
    }

    public String getApellidoBN(){
        return apellidoBN;
    }
    public void setApellidoBN(String apellidoBN){
        this.apellidoBN = apellidoBN;
    }

    public String getTipoBeneficiario(){
        return tipoBeneficiario;
    }
    public void setTipoBeneficiario(String tipoBeneficiario){
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getBeneficiarioIrrevocable(){
        return beneficiarioIrrevocable;
    }
    public void setBeneficiarioIrrevocable(String beneficiarioIrrevocable){
        this.beneficiarioIrrevocable = beneficiarioIrrevocable;
    }

    public String getPorcBeneficiario(){
        return porcBeneficiario;
    }
    public void setPorcBeneficiario(String porcBeneficiario){
        this.porcBeneficiario = porcBeneficiario;
    }

    public String getCodBeneficiario(){
        return codBeneficiario;
    }
    public void setCodBeneficiario(String codBeneficiario){
        this.codBeneficiario = codBeneficiario;
    }

    public String getParentezco(){
        return parentezco;
    }
    public void setParentezco(String parentezco){
        this.parentezco = parentezco;
    }

    public String getNuevoTipoBeneficiario(){
        return nuevoTipoBeneficiario;
    }
    public void setNuevoTipoBeneficiario(String nuevoTipoBeneficiario){
        this.nuevoTipoBeneficiario = nuevoTipoBeneficiario;
    }

    public String getNuevoBeneficiarioIrrevocable(){
        return nuevoBeneficiarioIrrevocable;
    }
    public void setNuevoBeneficiarioIrrevocable(String nuevoBeneficiarioIrrevocable){
        this.nuevoBeneficiarioIrrevocable = nuevoBeneficiarioIrrevocable;
    }

    public String getNuevoPorcBeneficiario(){
        return nuevoPorcBeneficiario;
    }
    public void setNuevoPorcBeneficiario(String nuevoPorcBeneficiario){
        this.nuevoPorcBeneficiario = nuevoPorcBeneficiario;
    }

    public String getNuevoCodBeneficiario(){
        return nuevoCodBeneficiario;
    }
    public void setNuevoCodBeneficiario(String nuevoCodBeneficiario){
        this.nuevoCodBeneficiario = nuevoCodBeneficiario;
    }

    public String getNuevoParentezco(){
        return nuevoParentezco;
    }
    public void setNuevoParentezco(String nuevoParentezco){
        this.nuevoParentezco = nuevoParentezco;
    }

    public static ArrayList getEmisionPolizaBeneficiarioNatural() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList emision = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO, HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV, TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_T, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_BN, TIPO_DOC_ID_BN, NUM_DOCUMENTO_ID_BN, NOMBRE_BN, APELLIDO_BN, TIPO_DEBENIFICARIO, BENEFICIARIO_IRREVOCABLE, PORCENTAJE_BENEFICIARIO, CODIGO_BENEFICIARIO, PARENTEZCO, NUEVO_TIPO_DEBENIFICARIO, NUEVO_BENEFICIARIO_IRREVOCABLE, NUEVO_PORCENTAJE_BENEFICIARIO, NUEVO_CODIGO_BENEFICIARIO, NUEVO_PARENTEZCO FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC");

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
                emisionPolizaBeneficiarioNaturalBean.setFechaMovimiento(rs.getString("FECHA_MOVIMIENTO"));
                emisionPolizaBeneficiarioNaturalBean.setFechaEfectivaApliEv(rs.getString("FECHA_EFECTIVA_APLI_EV"));
                emisionPolizaBeneficiarioNaturalBean.setPlanFinanciamiento(rs.getString("PLAN_FINANCIAMIENTO"));
                emisionPolizaBeneficiarioNaturalBean.setMoneda(rs.getString("MONEDA"));
                emisionPolizaBeneficiarioNaturalBean.setSucursal(rs.getString("SUCURSAL"));
                emisionPolizaBeneficiarioNaturalBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                emisionPolizaBeneficiarioNaturalBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                emisionPolizaBeneficiarioNaturalBean.setPeriodoGraciaDias(rs.getString("PERIODO_GRACIA_DIAS"));
                emisionPolizaBeneficiarioNaturalBean.setLineaCredito(rs.getString("LINEA_CREDITO"));
                emisionPolizaBeneficiarioNaturalBean.setHoraIniVencimiento(rs.getString("HORA_INI_VENCIMIENTO"));
                emisionPolizaBeneficiarioNaturalBean.setUnidadNegocio(rs.getString("UNIDAD_NEGOCIO"));
                emisionPolizaBeneficiarioNaturalBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                emisionPolizaBeneficiarioNaturalBean.setFrecuencuaPago(rs.getString("FRECUENCIA_PAGO"));
                emisionPolizaBeneficiarioNaturalBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                emisionPolizaBeneficiarioNaturalBean.setTipoValorAsegurado(rs.getString("TIPO_VALOR_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setNivelAgrupaReaseguro(rs.getString("NIVEL_AGRUPAMIENTO_REASEGURO"));
                emisionPolizaBeneficiarioNaturalBean.setPermManejoCtaProv(rs.getString("PERM_MANEJO_CTA_PROV"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTerceroT(rs.getString("TIPO_TERCERO_T"));
                emisionPolizaBeneficiarioNaturalBean.setTipoDocIdT(rs.getString("TIPO_DOC_ID_T"));
                emisionPolizaBeneficiarioNaturalBean.setNumDocIdT(rs.getString("NUM_DOCUMENTO_ID_T"));
                emisionPolizaBeneficiarioNaturalBean.setNombreT(rs.getString("NOMBRE_T"));
                emisionPolizaBeneficiarioNaturalBean.setApellidoT(rs.getString("APELLIDO_T"));
                emisionPolizaBeneficiarioNaturalBean.setPorcentajeT(rs.getString("PORCENTAJE_T"));
                emisionPolizaBeneficiarioNaturalBean.setNumUnidadRiesgo(rs.getString("NUM_UNIDAD_RIESGO"));
                emisionPolizaBeneficiarioNaturalBean.setNumCredito(rs.getString("NUM_CREDITO"));
                emisionPolizaBeneficiarioNaturalBean.setMontoAsegurado(rs.getString("MONTO_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setFactorVida(rs.getString("FACTOR_VIDA"));
                emisionPolizaBeneficiarioNaturalBean.setValorSeguroPrima(rs.getString("VALOR_SEGURO_PRIMA"));
                emisionPolizaBeneficiarioNaturalBean.setFechaDesembolso(rs.getString("FECHA_DESEMBOLSO"));
                emisionPolizaBeneficiarioNaturalBean.setValorPrestamo(rs.getString("VALOR_PRESTAMO"));
                emisionPolizaBeneficiarioNaturalBean.setCuotasPactadas(rs.getString("CUOTAS_PACTADAS"));
                emisionPolizaBeneficiarioNaturalBean.setSaldoCapital(rs.getString("SALDO_CAPITAL"));
                emisionPolizaBeneficiarioNaturalBean.setEdoCredito(rs.getString("ESTADO_CREDITO"));
                emisionPolizaBeneficiarioNaturalBean.setCuotasMora(rs.getString("CUOTAS_MORA"));
                emisionPolizaBeneficiarioNaturalBean.setFechaProceso(rs.getString("FECHA_PROCESO"));
                emisionPolizaBeneficiarioNaturalBean.setFechaPago(rs.getString("FECHA_PAGO"));
                emisionPolizaBeneficiarioNaturalBean.setCuotaPagada(rs.getString("CUOTA_PAGADA"));
                emisionPolizaBeneficiarioNaturalBean.setFechaMora(rs.getString("FECHA_MORA"));
                emisionPolizaBeneficiarioNaturalBean.setPorcFacultativo(rs.getString("PORCENTAJE_FACULTATIVO"));
                emisionPolizaBeneficiarioNaturalBean.setAseguradoPrimario(rs.getString("ASEGURADO_PRIMARIO"));
                emisionPolizaBeneficiarioNaturalBean.setPorcExtraPrima(rs.getString("PORCETAJE_EXTRA_PRIMA"));
                emisionPolizaBeneficiarioNaturalBean.setPorcDescuento(rs.getString("PORCETAJE_DESCUENTO"));
                emisionPolizaBeneficiarioNaturalBean.setDocIdAsegurado(rs.getString("DOC_ID_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setFechaNacAsegurado(rs.getString("FECHA_NAC_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setDireccionAsegurado(rs.getString("DIRECCION_ASEGURADO"));
                emisionPolizaBeneficiarioNaturalBean.setTelefonoFijo(rs.getString("TELEFONO_FIJO"));
                emisionPolizaBeneficiarioNaturalBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                emisionPolizaBeneficiarioNaturalBean.setCiudad(rs.getString("CIUDAD"));
                emisionPolizaBeneficiarioNaturalBean.setTipoTerceroBN(rs.getString("TIPO_TERCERO_BN"));
                emisionPolizaBeneficiarioNaturalBean.setTipoDocIdBN(rs.getString("TIPO_DOC_ID_BN"));
                emisionPolizaBeneficiarioNaturalBean.setNumDocIdBN(rs.getString("NUM_DOCUMENTO_ID_BN"));
                emisionPolizaBeneficiarioNaturalBean.setNombreBN(rs.getString("NOMBRE_BN"));
                emisionPolizaBeneficiarioNaturalBean.setApellidoBN(rs.getString("APELLIDO_BN"));
                emisionPolizaBeneficiarioNaturalBean.setTipoBeneficiario(rs.getString("TIPO_DEBENIFICARIO"));
                emisionPolizaBeneficiarioNaturalBean.setBeneficiarioIrrevocable(rs.getString("BENEFICIARIO_IRREVOCABLE"));
                emisionPolizaBeneficiarioNaturalBean.setPorcBeneficiario(rs.getString("PORCENTAJE_BENEFICIARIO"));
                emisionPolizaBeneficiarioNaturalBean.setCodBeneficiario(rs.getString("CODIGO_BENEFICIARIO"));
                emisionPolizaBeneficiarioNaturalBean.setParentezco(rs.getString("PARENTEZCO"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoTipoBeneficiario(rs.getString("NUEVO_TIPO_DEBENIFICARIO"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoBeneficiarioIrrevocable(rs.getString("NUEVO_BENEFICIARIO_IRREVOCABLE"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoPorcBeneficiario(rs.getString("NUEVO_PORCENTAJE_BENEFICIARIO"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoCodBeneficiario(rs.getString("NUEVO_CODIGO_BENEFICIARIO"));
                emisionPolizaBeneficiarioNaturalBean.setNuevoParentezco(rs.getString("NUEVO_PARENTEZCO"));

                emision.add(emisionPolizaBeneficiarioNaturalBean);
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

// PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA,
// EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV,
// PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION,
// PERIODO_GRACIA_DIAS, LINEA_CREDITO, HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO,
// CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO,
// NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV, TIPO_TERCERO_T,
// TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_T, NUM_UNIDAD_RIESGO,
// NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO,
// VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA,
// FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO,
// ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO,
// FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD,
// TIPO_TERCERO_BN, TIPO_DOC_ID_BN, NUM_DOCUMENTO_ID_BN, NOMBRE_BN, APELLIDO_BN,
// TIPO_DEBENIFICARIO, BENEFICIARIO_IRREVOCABLE, PORCENTAJE_BENEFICIARIO, CODIGO_BENEFICIARIO,
// PARENTEZCO, NUEVO_TIPO_DEBENIFICARIO, NUEVO_BENEFICIARIO_IRREVOCABLE,
// NUEVO_PORCENTAJE_BENEFICIARIO, NUEVO_CODIGO_BENEFICIARIO, NUEVO_PARENTEZCO
