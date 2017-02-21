package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;

/**
 * Created by agil on 20/02/2017.
 */
public class Asesuisa_PolizasBean {

    private final static Logger log = Logger.getLogger(Asesuisa_PolizasBean.class);

    // PrePoliza
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String fechaMovimiento;

    // Informacion de la Poliza
    private String planesFinanciamiento;
    private String monedas;
    private String sucursal;
    private String numeroPoliza;
    private String numeroPolizaBlanca;
    private String numeroCotizacion;
    private String fechaEmision;
    private String tipoPoliza;
    private String tipoProduccion;
    private String canalVenta;
    private String codigoRamo;
    private String clasePoliza;
    private String observacionSuscripcion;
    private String comisionNegociable;
    private String nivelAgrupacionReaseguro;
    private String unidadComercial;
    private String proyectoDependencia;
    private String dPDVendedor;
    private String nombreVendedorBancaseguros;
    private String codigoAgenciaVentas;
    private String nombreAgenciaVentas;
    private String ciudadAgenciaBancaria;
    private String canalVentaBancaseguros;
    private String grupoAgencia;
    private String distritoComercial;
    private String distritoOperativo;
    private String supervisorBancaseguros;

    // Tomador
    private String tomador1Nombre1;
    private String tomador1Nombre2;
    private String tomador1Apellido1;
    private String tomador1Apellido2;
    private String porcentajeTomador1;
    private String porcentajeTomador2;

    // Asesor
    private String asesor1Nombre1;
    private String asesor1Nombre2;
    private String asesor1Apellido1;
    private String asesor1Apellido2;
    private String porcentajeAsesor1;
    private String porcentajeAsesor2;

    // Vendedor
    private String vendedor1Nombre1;
    private String vendedor1Nombre2;
    private String vendedor1Apellido1;
    private String vendedor1Apellido2;
    private String porcentajeVendedor1;
    private String porcentajeVendedor2;

    // Unidad de Riesgo
    private String numeroUnidadRiesgo1;
    private String numeroUnidadRiesgo2;

    // Objeto Asegurado
    private String numeroObjetoAsegurado1;
    private String opcionAsegurado1;
    private String prima1;
    private String comision1;
    private String edadEmision1;
    private String rangoEdades1;
    private String codigoPlan1;
    private String nombrePlan1;
    private String numeroObjetoAsegurado2;
    private String opcionAsegurado2;
    private String prima2;
    private String comision2;
    private String edadEmision2;
    private String rangoEdades2;
    private String codigoPlan2;
    private String nombrePlan2;

    // Asegurado
    private String asegurado1Nombre1;
    private String asegurado1Nombre2;
    private String asegurado1Apellido1;
    private String asegurado1Apellido2;
    private String porcentajeAsegurado1;
    private String asegurado2Nombre1;
    private String asegurado2Nombre2;
    private String asegurado2Apellido1;
    private String asegurado2Apellido2;
    private String porcentajeAsegurado2;

    // Beneficiario
    private String beneficiario1Nombre1;
    private String beneficiario1Nombre2;
    private String beneficiario1Apellido1;
    private String beneficiario1Apellido2;
    private String tipoBeneficiario1;
    private String porcentajeBeneficiario1;

    private String beneficiario2Nombre1;
    private String beneficiario2Nombre2;
    private String beneficiario2Apellido1;
    private String beneficiario2Apellido2;
    private String tipoBeneficiario2;
    private String porcentajeBeneficiario2;


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

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getPlanesFinanciamiento() {
        return planesFinanciamiento;
    }

    public void setPlanesFinanciamiento(String planesFinanciamiento) {
        this.planesFinanciamiento = planesFinanciamiento;
    }

    public String getMonedas() {
        return monedas;
    }

    public void setMonedas(String monedas) {
        this.monedas = monedas;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getNumeroPolizaBlanca() {
        return numeroPolizaBlanca;
    }

    public void setNumeroPolizaBlanca(String numeroPolizaBlanca) {
        this.numeroPolizaBlanca = numeroPolizaBlanca;
    }

    public String getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getCodigoRamo() {
        return codigoRamo;
    }

    public void setCodigoRamo(String codigoRamo) {
        this.codigoRamo = codigoRamo;
    }

    public String getClasePoliza() {
        return clasePoliza;
    }

    public void setClasePoliza(String clasePoliza) {
        this.clasePoliza = clasePoliza;
    }

    public String getObservacionSuscripcion() {
        return observacionSuscripcion;
    }

    public void setObservacionSuscripcion(String observacionSuscripcion) {
        this.observacionSuscripcion = observacionSuscripcion;
    }

    public String getComisionNegociable() {
        return comisionNegociable;
    }

    public void setComisionNegociable(String comisionNegociable) {
        this.comisionNegociable = comisionNegociable;
    }

    public String getNivelAgrupacionReaseguro() {
        return nivelAgrupacionReaseguro;
    }

    public void setNivelAgrupacionReaseguro(String nivelAgrupacionReaseguro) {
        this.nivelAgrupacionReaseguro = nivelAgrupacionReaseguro;
    }

    public String getUnidadComercial() {
        return unidadComercial;
    }

    public void setUnidadComercial(String unidadComercial) {
        this.unidadComercial = unidadComercial;
    }

    public String getProyectoDependencia() {
        return proyectoDependencia;
    }

    public void setProyectoDependencia(String proyectoDependencia) {
        this.proyectoDependencia = proyectoDependencia;
    }

    public String getDPDVendedor() {
        return dPDVendedor;
    }

    public void setDPDVendedor(String dPDVendedor) {
        this.dPDVendedor = dPDVendedor;
    }

    public String getNombreVendedorBancaseguros() {
        return nombreVendedorBancaseguros;
    }

    public void setNombreVendedorBancaseguros(String nombreVendedorBancaseguros) {
        this.nombreVendedorBancaseguros = nombreVendedorBancaseguros;
    }

    public String getCodigoAgenciaVentas() {
        return codigoAgenciaVentas;
    }

    public void setCodigoAgenciaVentas(String codigoAgenciaVentas) {
        this.codigoAgenciaVentas = codigoAgenciaVentas;
    }

    public String getNombreAgenciaVentas() {
        return nombreAgenciaVentas;
    }

    public void setNombreAgenciaVentas(String nombreAgenciaVentas) {
        this.nombreAgenciaVentas = nombreAgenciaVentas;
    }

    public String getCiudadAgenciaBancaria() {
        return ciudadAgenciaBancaria;
    }

    public void setCiudadAgenciaBancaria(String ciudadAgenciaBancaria) {
        this.ciudadAgenciaBancaria = ciudadAgenciaBancaria;
    }

    public String getCanalVentaBancaseguros() {
        return canalVentaBancaseguros;
    }

    public void setCanalVentaBancaseguros(String canalVentaBancaseguros) {
        this.canalVentaBancaseguros = canalVentaBancaseguros;
    }

    public String getGrupoAgencia() {
        return grupoAgencia;
    }

    public void setGrupoAgencia(String grupoAgencia) {
        this.grupoAgencia = grupoAgencia;
    }

    public String getDistritoComercial() {
        return distritoComercial;
    }

    public void setDistritoComercial(String distritoComercial) {
        this.distritoComercial = distritoComercial;
    }

    public String getDistritoOperativo() {
        return distritoOperativo;
    }

    public void setDistritoOperativo(String distritoOperativo) {
        this.distritoOperativo = distritoOperativo;
    }

    public String getSupervisorBancaseguros() {
        return supervisorBancaseguros;
    }

    public void setSupervisorBancaseguros(String supervisorBancaseguros) {
        this.supervisorBancaseguros = supervisorBancaseguros;
    }

    public String getTomador1Nombre1() {
        return tomador1Nombre1;
    }

    public void setTomador1Nombre1(String tomador1Nombre1) {
        this.tomador1Nombre1 = tomador1Nombre1;
    }

    public String getTomador1Nombre2() {
        return tomador1Nombre2;
    }

    public void setTomador1Nombre2(String tomador1Nombre2) {
        this.tomador1Nombre2 = tomador1Nombre2;
    }

    public String getTomador1Apellido1() {
        return tomador1Apellido1;
    }

    public void setTomador1Apellido1(String tomador1Apellido1) {
        this.tomador1Apellido1 = tomador1Apellido1;
    }

    public String getTomador1Apellido2() {
        return tomador1Apellido2;
    }

    public void setTomador1Apellido2(String tomador1Apellido2) {
        this.tomador1Apellido2 = tomador1Apellido2;
    }

    public String getPorcentajeTomador1() {
        return porcentajeTomador1;
    }

    public void setPorcentajeTomador1(String porcentajeTomador1) {
        this.porcentajeTomador1 = porcentajeTomador1;
    }

    public String getPorcentajeTomador2() {
        return porcentajeTomador2;
    }

    public void setPorcentajeTomador2(String porcentajeTomador2) {
        this.porcentajeTomador2 = porcentajeTomador2;
    }

    public String getAsesor1Nombre1() {
        return asesor1Nombre1;
    }

    public void setAsesor1Nombre1(String asesor1Nombre1) {
        this.asesor1Nombre1 = asesor1Nombre1;
    }

    public String getAsesor1Nombre2() {
        return asesor1Nombre2;
    }

    public void setAsesor1Nombre2(String asesor1Nombre2) {
        this.asesor1Nombre2 = asesor1Nombre2;
    }

    public String getAsesor1Apellido1() {
        return asesor1Apellido1;
    }

    public void setAsesor1Apellido1(String asesor1Apellido1) {
        this.asesor1Apellido1 = asesor1Apellido1;
    }

    public String getAsesor1Apellido2() {
        return asesor1Apellido2;
    }

    public void setAsesor1Apellido2(String asesor1Apellido2) {
        this.asesor1Apellido2 = asesor1Apellido2;
    }

    public String getPorcentajeAsesor1() {
        return porcentajeAsesor1;
    }

    public void setPorcentajeAsesor1(String porcentajeAsesor1) {
        this.porcentajeAsesor1 = porcentajeAsesor1;
    }

    public String getPorcentajeAsesor2() {
        return porcentajeAsesor2;
    }

    public void setPorcentajeAsesor2(String porcentajeAsesor2) {
        this.porcentajeAsesor2 = porcentajeAsesor2;
    }

    public String getVendedor1Nombre1() {
        return vendedor1Nombre1;
    }

    public void setVendedor1Nombre1(String vendedor1Nombre1) {
        this.vendedor1Nombre1 = vendedor1Nombre1;
    }

    public String getVendedor1Nombre2() {
        return vendedor1Nombre2;
    }

    public void setVendedor1Nombre2(String vendedor1Nombre2) {
        this.vendedor1Nombre2 = vendedor1Nombre2;
    }

    public String getVendedor1Apellido1() {
        return vendedor1Apellido1;
    }

    public void setVendedor1Apellido1(String vendedor1Apellido1) {
        this.vendedor1Apellido1 = vendedor1Apellido1;
    }

    public String getVendedor1Apellido2() {
        return vendedor1Apellido2;
    }

    public void setVendedor1Apellido2(String vendedor1Apellido2) {
        this.vendedor1Apellido2 = vendedor1Apellido2;
    }

    public String getPorcentajeVendedor1() {
        return porcentajeVendedor1;
    }

    public void setPorcentajeVendedor1(String porcentajeVendedor1) {
        this.porcentajeVendedor1 = porcentajeVendedor1;
    }

    public String getPorcentajeVendedor2() {
        return porcentajeVendedor2;
    }

    public void setPorcentajeVendedor2(String porcentajeVendedor2) {
        this.porcentajeVendedor2 = porcentajeVendedor2;
    }

    public String getNumeroUnidadRiesgo1() {
        return numeroUnidadRiesgo1;
    }

    public void setNumeroUnidadRiesgo1(String numeroUnidadRiesgo1) {
        this.numeroUnidadRiesgo1 = numeroUnidadRiesgo1;
    }

    public String getNumeroUnidadRiesgo2() {
        return numeroUnidadRiesgo2;
    }

    public void setNumeroUnidadRiesgo2(String numeroUnidadRiesgo2) {
        this.numeroUnidadRiesgo2 = numeroUnidadRiesgo2;
    }

    public String getNumeroObjetoAsegurado1() {
        return numeroObjetoAsegurado1;
    }

    public void setNumeroObjetoAsegurado1(String numeroObjetoAsegurado1) {
        this.numeroObjetoAsegurado1 = numeroObjetoAsegurado1;
    }

    public String getOpcionAsegurado1() {
        return opcionAsegurado1;
    }

    public void setOpcionAsegurado1(String opcionAsegurado1) {
        this.opcionAsegurado1 = opcionAsegurado1;
    }

    public String getPrima1() {
        return prima1;
    }

    public void setPrima1(String prima1) {
        this.prima1 = prima1;
    }

    public String getComision1() {
        return comision1;
    }

    public void setComision1(String comision1) {
        this.comision1 = comision1;
    }

    public String getEdadEmision1() {
        return edadEmision1;
    }

    public void setEdadEmision1(String edadEmision1) {
        this.edadEmision1 = edadEmision1;
    }

    public String getRangoEdades1() {
        return rangoEdades1;
    }

    public void setRangoEdades1(String rangoEdades1) {
        this.rangoEdades1 = rangoEdades1;
    }

    public String getCodigoPlan1() {
        return codigoPlan1;
    }

    public void setCodigoPlan1(String codigoPlan1) {
        this.codigoPlan1 = codigoPlan1;
    }

    public String getNombrePlan1() {
        return nombrePlan1;
    }

    public void setNombrePlan1(String nombrePlan1) {
        this.nombrePlan1 = nombrePlan1;
    }

    public String getNumeroObjetoAsegurado2() {
        return numeroObjetoAsegurado2;
    }

    public void setNumeroObjetoAsegurado2(String numeroObjetoAsegurado2) {
        this.numeroObjetoAsegurado2 = numeroObjetoAsegurado2;
    }

    public String getOpcionAsegurado2() {
        return opcionAsegurado2;
    }

    public void setOpcionAsegurado2(String opcionAsegurado2) {
        this.opcionAsegurado2 = opcionAsegurado2;
    }

    public String getPrima2() {
        return prima2;
    }

    public void setPrima2(String prima2) {
        this.prima2 = prima2;
    }

    public String getComision2() {
        return comision2;
    }

    public void setComision2(String comision2) {
        this.comision2 = comision2;
    }

    public String getEdadEmision2() {
        return edadEmision2;
    }

    public void setEdadEmision2(String edadEmision2) {
        this.edadEmision2 = edadEmision2;
    }

    public String getRangoEdades2() {
        return rangoEdades2;
    }

    public void setRangoEdades2(String rangoEdades2) {
        this.rangoEdades2 = rangoEdades2;
    }

    public String getCodigoPlan2() {
        return codigoPlan2;
    }

    public void setCodigoPlan2(String codigoPlan2) {
        this.codigoPlan2 = codigoPlan2;
    }

    public String getNombrePlan2() {
        return nombrePlan2;
    }

    public void setNombrePlan2(String nombrePlan2) {
        this.nombrePlan2 = nombrePlan2;
    }

    public String getAsegurado1Nombre1() {
        return asegurado1Nombre1;
    }

    public void setAsegurado1Nombre1(String asegurado1Nombre1) {
        this.asegurado1Nombre1 = asegurado1Nombre1;
    }

    public String getAsegurado1Nombre2() {
        return asegurado1Nombre2;
    }

    public void setAsegurado1Nombre2(String asegurado1Nombre2) {
        this.asegurado1Nombre2 = asegurado1Nombre2;
    }

    public String getAsegurado1Apellido1() {
        return asegurado1Apellido1;
    }

    public void setAsegurado1Apellido1(String asegurado1Apellido1) {
        this.asegurado1Apellido1 = asegurado1Apellido1;
    }

    public String getAsegurado1Apellido2() {
        return asegurado1Apellido2;
    }

    public void setAsegurado1Apellido2(String asegurado1Apellido2) {
        this.asegurado1Apellido2 = asegurado1Apellido2;
    }

    public String getPorcentajeAsegurado1() {
        return porcentajeAsegurado1;
    }

    public void setPorcentajeAsegurado1(String porcentajeAsegurado1) {
        this.porcentajeAsegurado1 = porcentajeAsegurado1;
    }

    public String getAsegurado2Nombre1() {
        return asegurado2Nombre1;
    }

    public void setAsegurado2Nombre1(String asegurado2Nombre1) {
        this.asegurado2Nombre1 = asegurado2Nombre1;
    }

    public String getAsegurado2Nombre2() {
        return asegurado2Nombre2;
    }

    public void setAsegurado2Nombre2(String asegurado2Nombre2) {
        this.asegurado2Nombre2 = asegurado2Nombre2;
    }

    public String getAsegurado2Apellido1() {
        return asegurado2Apellido1;
    }

    public void setAsegurado2Apellido1(String asegurado2Apellido1) {
        this.asegurado2Apellido1 = asegurado2Apellido1;
    }

    public String getAsegurado2Apellido2() {
        return asegurado2Apellido2;
    }

    public void setAsegurado2Apellido2(String asegurado2Apellido2) {
        this.asegurado2Apellido2 = asegurado2Apellido2;
    }

    public String getPorcentajeAsegurado2() {
        return porcentajeAsegurado2;
    }

    public void setPorcentajeAsegurado2(String porcentajeAsegurado2) {
        this.porcentajeAsegurado2 = porcentajeAsegurado2;
    }

    public String getBeneficiario1Nombre1() {
        return beneficiario1Nombre1;
    }

    public void setBeneficiario1Nombre1(String beneficiario1Nombre1) {
        this.beneficiario1Nombre1 = beneficiario1Nombre1;
    }

    public String getBeneficiario1Nombre2() {
        return beneficiario1Nombre2;
    }

    public void setBeneficiario1Nombre2(String beneficiario1Nombre2) {
        this.beneficiario1Nombre2 = beneficiario1Nombre2;
    }

    public String getBeneficiario1Apellido1() {
        return beneficiario1Apellido1;
    }

    public void setBeneficiario1Apellido1(String beneficiario1Apellido1) {
        this.beneficiario1Apellido1 = beneficiario1Apellido1;
    }

    public String getBeneficiario1Apellido2() {
        return beneficiario1Apellido2;
    }

    public void setBeneficiario1Apellido2(String beneficiario1Apellido2) {
        this.beneficiario1Apellido2 = beneficiario1Apellido2;
    }

    public String getTipoBeneficiario1() {
        return tipoBeneficiario1;
    }

    public void setTipoBeneficiario1(String tipoBeneficiario1) {
        this.tipoBeneficiario1 = tipoBeneficiario1;
    }

    public String getPorcentajeBeneficiario1() {
        return porcentajeBeneficiario1;
    }

    public void setPorcentajeBeneficiario1(String porcentajeBeneficiario1) {
        this.porcentajeBeneficiario1 = porcentajeBeneficiario1;
    }

    public String getBeneficiario2Nombre1() {
        return beneficiario2Nombre1;
    }

    public void setBeneficiario2Nombre1(String beneficiario2Nombre1) {
        this.beneficiario2Nombre1 = beneficiario2Nombre1;
    }

    public String getBeneficiario2Nombre2() {
        return beneficiario2Nombre2;
    }

    public void setBeneficiario2Nombre2(String beneficiario2Nombre2) {
        this.beneficiario2Nombre2 = beneficiario2Nombre2;
    }

    public String getBeneficiario2Apellido1() {
        return beneficiario2Apellido1;
    }

    public void setBeneficiario2Apellido1(String beneficiario2Apellido1) {
        this.beneficiario2Apellido1 = beneficiario2Apellido1;
    }

    public String getBeneficiario2Apellido2() {
        return beneficiario2Apellido2;
    }

    public void setBeneficiario2Apellido2(String beneficiario2Apellido2) {
        this.beneficiario2Apellido2 = beneficiario2Apellido2;
    }

    public String getTipoBeneficiario2() {
        return tipoBeneficiario2;
    }

    public void setTipoBeneficiario2(String tipoBeneficiario2) {
        this.tipoBeneficiario2 = tipoBeneficiario2;
    }

    public String getPorcentajeBeneficiario2() {
        return porcentajeBeneficiario2;
    }

    public void setPorcentajeBeneficiario2(String porcentajeBeneficiario2) {
        this.porcentajeBeneficiario2 = porcentajeBeneficiario2;
    }
}
