package AcseleV13_8.beans;

import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created by agil on 16/09/2016.
 */
public class PolizaBean implements Serializable{

    private final static Logger log = Logger.getLogger(PolizaBean.class);

    // Pre-Poliza
    private String producto;
    private String vigencia;
    private String fechaDesde;
    private String fechaHasta;
    private String eventoAplicar;
    private String fechaMovimiento;
    private String fechaEfectivaAplicacionEvento;

    // Informacion de la Poliza
    private String planFinanciamiento;
    private String moneda;
    private String sucursal;
    private String numeroPoliza;
    private String fechaEmision;
    private String tipoProduccion;
    private String periodoGracia;
    private String lineaCredito;
    private String horaIniciacionVencimiento;
    private String unidadNegocio;
    private String canalVenta;
    private String frecuenciaPago;
    private String tipoPoliza;
    private String tipoValorAsegurado;
    private String nivelAgrupamientoReaseguro;
    private String permiteManejoCuentasProvisionales;
    private String mesProvisional;
    private String anioProvisional;

    // Tomador
    private String tomadorNombre1;
    private String tomadorNombre2;
    private String tomadorApellido1;
    private String tomadorApellido2;
    private String porcentajeParticipacionTomador;

    // Unidades de Riesgo
    private String numeroUnidadRiesgo;
    private String numeroCredito;
    private String montoAsegurado;
    private String factorVida;
    private String valorSeguroPrima;
    private String fechaDesembolso;
    private String valorPrestamo;
    private String cuotasPactadas;
    private String saldoCapital;
    private String estadoCredito;
    private String cuotasMora;
    private String fechaProceso;
    private String fechaPago;
    private String cuotaPagada;
    private String fechaMora;
    private String porcentajeFacultativo;

    // Objetos Asegurados
    private String numeroObjetoAseg;
    private String aseguradoPrimario;
    private String porcentajeExtraPrima;
    private String porcentajeDescuento;
    private String edadAsegurado;
    private String nombreCompletoAsegurado;
    private String nombreCompletoBeneficiario;
    private String numeroObjetosAseguradosContenidosUnidadRiesgo;
    private String documentoIdentidadAsegurado;
    private String fechaNacimientoAsegurado;
    private String direccionAsegurado;
    private String telefonoFijo;
    private String departamento;
    private String ciudad;

    // Asegurado Vida
    private String aseguradoVidaNombre1;
    private String aseguradoVidaNombre2;
    private String aseguradoVidaApellido1;
    private String aseguradoVidaApellido2;
    private String porcentajeParticipacionAseguradoVida;

    // Beneficiario Natural
    private String beneficiarioNaturalNombre1;
    private String beneficiarioNaturalNombre2;
    private String beneficiarioNaturalApellido1;
    private String beneficiarioNaturalApellido2;
    private String tipoBeneficiario;
    private String beneficiarioIrrevocable;
    private String porcentajeParticipacionBeneficiarioNatural;
    private String codigoBeneficiario;
    private String parentesco;

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

    public String getFechaEfectivaAplicacionEvento() {
        return fechaEfectivaAplicacionEvento;
    }

    public void setFechaEfectivaAplicacionEvento(String fechaEfectivaAplicacionEvento) {
        this.fechaEfectivaAplicacionEvento = fechaEfectivaAplicacionEvento;
    }

    public String getPlanFinanciamiento() {
        return planFinanciamiento;
    }

    public void setPlanFinanciamiento(String planFinanciamiento) {
        this.planFinanciamiento = planFinanciamiento;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
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

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public String getPeriodoGracia() {
        return periodoGracia;
    }

    public void setPeriodoGracia(String periodoGracia) {
        this.periodoGracia = periodoGracia;
    }

    public String getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(String lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public String getHoraIniciacionVencimiento() {
        return horaIniciacionVencimiento;
    }

    public void setHoraIniciacionVencimiento(String horaIniciacionVencimiento) {
        this.horaIniciacionVencimiento = horaIniciacionVencimiento;
    }

    public String getUnidadNegocio() {
        return unidadNegocio;
    }

    public void setUnidadNegocio(String unidadNegocio) {
        this.unidadNegocio = unidadNegocio;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public String getTipoValorAsegurado() {
        return tipoValorAsegurado;
    }

    public void setTipoValorAsegurado(String tipoValorAsegurado) {
        this.tipoValorAsegurado = tipoValorAsegurado;
    }

    public String getNivelAgrupamientoReaseguro() {
        return nivelAgrupamientoReaseguro;
    }

    public void setNivelAgrupamientoReaseguro(String nivelAgrupamientoReaseguro) {
        this.nivelAgrupamientoReaseguro = nivelAgrupamientoReaseguro;
    }

    public String getPermiteManejoCuentasProvisionales() {
        return permiteManejoCuentasProvisionales;
    }

    public void setPermiteManejoCuentasProvisionales(String permiteManejoCuentasProvisionales) {
        this.permiteManejoCuentasProvisionales = permiteManejoCuentasProvisionales;
    }

    public String getMesProvisional() {
        return mesProvisional;
    }

    public void setMesProvisional(String mesProvisional) {
        this.mesProvisional = mesProvisional;
    }

    public String getAnioProvisional() {
        return anioProvisional;
    }

    public void setAnioProvisional(String anioProvisional) {
        this.anioProvisional = anioProvisional;
    }

    public String getTomadorNombre1() {
        return tomadorNombre1;
    }

    public void setTomadorNombre1(String tomadorNombre1) {
        this.tomadorNombre1 = tomadorNombre1;
    }

    public String getTomadorNombre2() {
        return tomadorNombre2;
    }

    public void setTomadorNombre2(String tomadorNombre2) {
        this.tomadorNombre2 = tomadorNombre2;
    }

    public String getTomadorApellido1() {
        return tomadorApellido1;
    }

    public void setTomadorApellido1(String tomadorApellido1) {
        this.tomadorApellido1 = tomadorApellido1;
    }

    public String getTomadorApellido2() {
        return tomadorApellido2;
    }

    public void setTomadorApellido2(String tomadorApellido2) {
        this.tomadorApellido2 = tomadorApellido2;
    }

    public String getPorcentajeParticipacionTomador() {
        return porcentajeParticipacionTomador;
    }

    public void setPorcentajeParticipacionTomador(String porcentajeParticipacionTomador) {
        this.porcentajeParticipacionTomador = porcentajeParticipacionTomador;
    }

    public String getNumeroUnidadRiesgo() {
        return numeroUnidadRiesgo;
    }

    public void setNumeroUnidadRiesgo(String numeroUnidadRiesgo) {
        this.numeroUnidadRiesgo = numeroUnidadRiesgo;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public void setNumeroCredito(String numeroCredito) {
        this.numeroCredito = numeroCredito;
    }

    public String getMontoAsegurado() {
        return montoAsegurado;
    }

    public void setMontoAsegurado(String montoAsegurado) {
        this.montoAsegurado = montoAsegurado;
    }

    public String getFactorVida() {
        return factorVida;
    }

    public void setFactorVida(String factorVida) {
        this.factorVida = factorVida;
    }

    public String getValorSeguroPrima() {
        return valorSeguroPrima;
    }

    public void setValorSeguroPrima(String valorSeguroPrima) {
        this.valorSeguroPrima = valorSeguroPrima;
    }

    public String getFechaDesembolso() {
        return fechaDesembolso;
    }

    public void setFechaDesembolso(String fechaDesembolso) {
        this.fechaDesembolso = fechaDesembolso;
    }

    public String getValorPrestamo() {
        return valorPrestamo;
    }

    public void setValorPrestamo(String valorPrestamo) {
        this.valorPrestamo = valorPrestamo;
    }

    public String getCuotasPactadas() {
        return cuotasPactadas;
    }

    public void setCuotasPactadas(String cuotasPactadas) {
        this.cuotasPactadas = cuotasPactadas;
    }

    public String getSaldoCapital() {
        return saldoCapital;
    }

    public void setSaldoCapital(String saldoCapital) {
        this.saldoCapital = saldoCapital;
    }

    public String getEstadoCredito() {
        return estadoCredito;
    }

    public void setEstadoCredito(String estadoCredito) {
        this.estadoCredito = estadoCredito;
    }

    public String getCuotasMora() {
        return cuotasMora;
    }

    public void setCuotasMora(String cuotasMora) {
        this.cuotasMora = cuotasMora;
    }

    public String getFechaProceso() {
        return fechaProceso;
    }

    public void setFechaProceso(String fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getCuotaPagada() {
        return cuotaPagada;
    }

    public void setCuotaPagada(String cuotaPagada) {
        this.cuotaPagada = cuotaPagada;
    }

    public String getFechaMora() {
        return fechaMora;
    }

    public void setFechaMora(String fechaMora) {
        this.fechaMora = fechaMora;
    }

    public String getPorcentajeFacultativo() {
        return porcentajeFacultativo;
    }

    public void setPorcentajeFacultativo(String porcentajeFacultativo) {
        this.porcentajeFacultativo = porcentajeFacultativo;
    }

    public String getNumeroObjetoAseg() {
        return numeroObjetoAseg;
    }

    public void setNumeroObjetoAseg(String numeroObjetoAseg) {
        this.numeroObjetoAseg = numeroObjetoAseg;
    }

    public String getAseguradoPrimario() {
        return aseguradoPrimario;
    }

    public void setAseguradoPrimario(String aseguradoPrimario) {
        this.aseguradoPrimario = aseguradoPrimario;
    }

    public String getPorcentajeExtraPrima() {
        return porcentajeExtraPrima;
    }

    public void setPorcentajeExtraPrima(String porcentajeExtraPrima) {
        this.porcentajeExtraPrima = porcentajeExtraPrima;
    }

    public String getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(String porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public String getEdadAsegurado() {
        return edadAsegurado;
    }

    public void setEdadAsegurado(String edadAsegurado) {
        this.edadAsegurado = edadAsegurado;
    }

    public String getNombreCompletoAsegurado() {
        return nombreCompletoAsegurado;
    }

    public void setNombreCompletoAsegurado(String nombreCompletoAsegurado) {
        this.nombreCompletoAsegurado = nombreCompletoAsegurado;
    }

    public String getNombreCompletoBeneficiario() {
        return nombreCompletoBeneficiario;
    }

    public void setNombreCompletoBeneficiario(String nombreCompletoBeneficiario) {
        this.nombreCompletoBeneficiario = nombreCompletoBeneficiario;
    }

    public String getNumeroObjetosAseguradosContenidosUnidadRiesgo() {
        return numeroObjetosAseguradosContenidosUnidadRiesgo;
    }

    public void setNumeroObjetosAseguradosContenidosUnidadRiesgo(String numeroObjetosAseguradosContenidosUnidadRiesgo) {
        this.numeroObjetosAseguradosContenidosUnidadRiesgo = numeroObjetosAseguradosContenidosUnidadRiesgo;
    }

    public String getDocumentoIdentidadAsegurado() {
        return documentoIdentidadAsegurado;
    }

    public void setDocumentoIdentidadAsegurado(String documentoIdentidadAsegurado) {
        this.documentoIdentidadAsegurado = documentoIdentidadAsegurado;
    }

    public String getFechaNacimientoAsegurado() {
        return fechaNacimientoAsegurado;
    }

    public void setFechaNacimientoAsegurado(String fechaNacimientoAsegurado) {
        this.fechaNacimientoAsegurado = fechaNacimientoAsegurado;
    }

    public String getDireccionAsegurado() {
        return direccionAsegurado;
    }

    public void setDireccionAsegurado(String direccionAsegurado) {
        this.direccionAsegurado = direccionAsegurado;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAseguradoVidaNombre1() {
        return aseguradoVidaNombre1;
    }

    public void setAseguradoVidaNombre1(String aseguradoVidaNombre1) {
        this.aseguradoVidaNombre1 = aseguradoVidaNombre1;
    }

    public String getAseguradoVidaNombre2() {
        return aseguradoVidaNombre2;
    }

    public void setAseguradoVidaNombre2(String aseguradoVidaNombre2) {
        this.aseguradoVidaNombre2 = aseguradoVidaNombre2;
    }

    public String getAseguradoVidaApellido1() {
        return aseguradoVidaApellido1;
    }

    public void setAseguradoVidaApellido1(String aseguradoVidaApellido1) {
        this.aseguradoVidaApellido1 = aseguradoVidaApellido1;
    }

    public String getAseguradoVidaApellido2() {
        return aseguradoVidaApellido2;
    }

    public void setAseguradoVidaApellido2(String aseguradoVidaApellido2) {
        this.aseguradoVidaApellido2 = aseguradoVidaApellido2;
    }

    public String getPorcentajeParticipacionAseguradoVida() {
        return porcentajeParticipacionAseguradoVida;
    }

    public void setPorcentajeParticipacionAseguradoVida(String porcentajeParticipacionAseguradoVida) {
        this.porcentajeParticipacionAseguradoVida = porcentajeParticipacionAseguradoVida;
    }

    public String getBeneficiarioNaturalNombre1() {
        return beneficiarioNaturalNombre1;
    }

    public void setBeneficiarioNaturalNombre1(String beneficiarioNaturalNombre1) {
        this.beneficiarioNaturalNombre1 = beneficiarioNaturalNombre1;
    }

    public String getBeneficiarioNaturalNombre2() {
        return beneficiarioNaturalNombre2;
    }

    public void setBeneficiarioNaturalNombre2(String beneficiarioNaturalNombre2) {
        this.beneficiarioNaturalNombre2 = beneficiarioNaturalNombre2;
    }

    public String getBeneficiarioNaturalApellido1() {
        return beneficiarioNaturalApellido1;
    }

    public void setBeneficiarioNaturalApellido1(String beneficiarioNaturalApellido1) {
        this.beneficiarioNaturalApellido1 = beneficiarioNaturalApellido1;
    }

    public String getBeneficiarioNaturalApellido2() {
        return beneficiarioNaturalApellido2;
    }

    public void setBeneficiarioNaturalApellido2(String beneficiarioNaturalApellido2) {
        this.beneficiarioNaturalApellido2 = beneficiarioNaturalApellido2;
    }

    public String getTipoBeneficiario() {
        return tipoBeneficiario;
    }

    public void setTipoBeneficiario(String tipoBeneficiario) {
        this.tipoBeneficiario = tipoBeneficiario;
    }

    public String getBeneficiarioIrrevocable() {
        return beneficiarioIrrevocable;
    }

    public void setBeneficiarioIrrevocable(String beneficiarioIrrevocable) {
        this.beneficiarioIrrevocable = beneficiarioIrrevocable;
    }

    public String getPorcentajeParticipacionBeneficiarioNatural() {
        return porcentajeParticipacionBeneficiarioNatural;
    }

    public void setPorcentajeParticipacionBeneficiarioNatural(String porcentajeParticipacionBeneficiarioNatural) {
        this.porcentajeParticipacionBeneficiarioNatural = porcentajeParticipacionBeneficiarioNatural;
    }

    public String getCodigoBeneficiario() {
        return codigoBeneficiario;
    }

    public void setCodigoBeneficiario(String codigoBeneficiario) {
        this.codigoBeneficiario = codigoBeneficiario;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }




}
