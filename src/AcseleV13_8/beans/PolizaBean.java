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
    private String tipoTomador1;
    private String tipoDocumentoIdentidad1;
    private String numeroDocumentoIdentidad1;
    private String tipoTerceroTomador;
    private String tomadorNombre1;
    private String tomadorNombre2;
    private String tomadorApellido1;
    private String tomadorApellido2;
    private String porcentajeParticipacionTomador;
    private String nuevoPorcentajeParticipacionTomador;

    private String tipoTomador2;
    private String tipoDocumentoIdentidad2;
    private String numeroDocumentoIdentidad2;
    private String tomador2Nombre1;
    private String tomador2Nombre2;
    private String tomador2Apellido1;
    private String tomador2Apellido2;
    private String porcentajeParticipacionTomador2;
    private String nuevoPorcentajeParticipacionTomador2;


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

    private String numeroUnidadRiesgo2;
    private String numeroCredito2;
    private String montoAsegurado2;
    private String factorVida2;
    private String valorSeguroPrima2;
    private String fechaDesembolso2;
    private String valorPrestamo2;
    private String cuotasPactadas2;
    private String saldoCapital2;
    private String estadoCredito2;
    private String cuotasMora2;
    private String fechaProceso2;
    private String fechaPago2;
    private String cuotaPagada2;
    private String fechaMora2;
    private String porcentajeFacultativo2;

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

    private String NumeroObjetoAseg2;
    private String AseguradoPrimario2;
    private String PorcentajeExtraPrima2;
    private String PorcentajeDescuento2;
    private String EdadAsegurado2;
    private String NombreCompletoAsegurado2;
    private String NombreCompletoBeneficiario2;
    private String NumeroObjetosAseguradosContenidosUnidadRiesgo2;
    private String DocumentoIdentidadAsegurado2;
    private String FechaNacimientoAsegurado2;
    private String DireccionAsegurado2;
    private String TelefonoFijo2;
    private String Departamento2;
    private String Ciudad2;

    // Asegurado Vida
    private String aseguradoVidaNombre1;
    private String aseguradoVidaNombre2;
    private String aseguradoVidaApellido1;
    private String aseguradoVidaApellido2;
    private String porcentajeParticipacionAseguradoVida;
    private String nuevoPorcentajeParticipacionAseguradoVida;

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
    private String nuevoTipoBeneficiario;
    private String nuevoBeneficiarioIrrevocable;
    private String nuevoPorcentajeParticipacionBeneficiarioNatural;
    private String nuevoCodigoBeneficiario;
    private String nuevoParentesco;

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

    public String getTipoTomador1() {
        return tipoTomador1;
    }
    public void setTipoTomador1(String tipoTomador1) {
        this.tipoTomador1 = tipoTomador1;
    }

    public String getTipoDocumentoIdentidad1() {
        return tipoDocumentoIdentidad1;
    }
    public void setTipoDocumentoIdentidad1(String tipoDocumentoIdentidad1) {
        this.tipoDocumentoIdentidad1 = tipoDocumentoIdentidad1;
    }

    public String getNumeroDocumentoIdentidad1() {
        return numeroDocumentoIdentidad1;
    }
    public void setNumeroDocumentoIdentidad1(String numeroDocumentoIdentidad1) {
        this.numeroDocumentoIdentidad1 = numeroDocumentoIdentidad1;
    }

    public String getTipoTerceroTomador() {
        return tipoTerceroTomador;
    }
    public void setTipoTerceroTomador(String tipoTerceroTomador) {
        this.tipoTerceroTomador = tipoTerceroTomador;
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

    public String getNuevoPorcentajeParticipacionTomador() {
        return nuevoPorcentajeParticipacionTomador;
    }
    public void setNuevoPorcentajeParticipacionTomador(String nuevoPorcentajeParticipacionTomador) {
        this.nuevoPorcentajeParticipacionTomador = nuevoPorcentajeParticipacionTomador;
    }

    public String getTipoTomador2() {
        return tipoTomador2;
    }
    public void setTipoTomador2(String tipoTomador2) {
        this.tipoTomador2 = tipoTomador2;
    }

    public String getTipoDocumentoIdentidad2() {
        return tipoDocumentoIdentidad2;
    }
    public void setTipoDocumentoIdentidad2(String tipoDocumentoIdentidad2) {
        this.tipoDocumentoIdentidad2 = tipoDocumentoIdentidad2;
    }

    public String getNumeroDocumentoIdentidad2() {
        return numeroDocumentoIdentidad2;
    }
    public void setNumeroDocumentoIdentidad2(String numeroDocumentoIdentidad2) {
        this.numeroDocumentoIdentidad2 = numeroDocumentoIdentidad2;
    }

    public String getTomador2Nombre1() {
        return tomador2Nombre1;
    }
    public void setTomador2Nombre1(String tomador2Nombre1) {
        this.tomador2Nombre1 = tomador2Nombre1;
    }

    public String getTomador2Nombre2() {
        return tomador2Nombre2;
    }
    public void setTomador2Nombre2(String tomador2Nombre2) {
        this.tomador2Nombre2 = tomador2Nombre2;
    }

    public String getTomador2Apellido1() {
        return tomador2Apellido1;
    }
    public void setTomador2Apellido1(String tomador2Apellido1) {
        this.tomador2Apellido1 = tomador2Apellido1;
    }

    public String getTomador2Apellido2() {
        return tomador2Apellido2;
    }
    public void setTomador2Apellido2(String tomador2Apellido2) {
        this.tomador2Apellido2 = tomador2Apellido2;
    }

    public String getPorcentajeParticipacionTomador2() {
        return porcentajeParticipacionTomador2;
    }
    public void setPorcentajeParticipacionTomador2(String porcentajeParticipacionTomador2) {
        this.porcentajeParticipacionTomador2 = porcentajeParticipacionTomador2;
    }

    public String getNuevoPorcentajeParticipacionTomador2() {
        return nuevoPorcentajeParticipacionTomador2;
    }
    public void setNuevoPorcentajeParticipacionTomador2(String nuevoPorcentajeParticipacionTomador2) {
        this.nuevoPorcentajeParticipacionTomador2 = nuevoPorcentajeParticipacionTomador2;
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

    public String getNumeroUnidadRiesgo2() {
        return numeroUnidadRiesgo2;
    }

    public void setNumeroUnidadRiesgo2(String numeroUnidadRiesgo2) {
        this.numeroUnidadRiesgo2 = numeroUnidadRiesgo2;
    }

    public String getNumeroCredito2() {
        return numeroCredito2;
    }

    public void setNumeroCredito2(String numeroCredito2) {
        this.numeroCredito2 = numeroCredito2;
    }

    public String getMontoAsegurado2() {
        return montoAsegurado2;
    }

    public void setMontoAsegurado2(String montoAsegurado2) {
        this.montoAsegurado2 = montoAsegurado2;
    }

    public String getFactorVida2() {
        return factorVida2;
    }

    public void setFactorVida2(String factorVida2) {
        this.factorVida2 = factorVida2;
    }

    public String getValorSeguroPrima2() {
        return valorSeguroPrima2;
    }

    public void setValorSeguroPrima2(String valorSeguroPrima2) {
        this.valorSeguroPrima2 = valorSeguroPrima2;
    }

    public String getFechaDesembolso2() {
        return fechaDesembolso2;
    }

    public void setFechaDesembolso2(String fechaDesembolso2) {
        this.fechaDesembolso2 = fechaDesembolso2;
    }

    public String getValorPrestamo2() {
        return valorPrestamo2;
    }

    public void setValorPrestamo2(String valorPrestamo2) {
        this.valorPrestamo2 = valorPrestamo2;
    }

    public String getCuotasPactadas2() {
        return cuotasPactadas2;
    }

    public void setCuotasPactadas2(String cuotasPactadas2) {
        this.cuotasPactadas2 = cuotasPactadas2;
    }

    public String getSaldoCapital2() {
        return saldoCapital2;
    }

    public void setSaldoCapital2(String saldoCapital2) {
        this.saldoCapital2 = saldoCapital2;
    }

    public String getEstadoCredito2() {
        return estadoCredito2;
    }

    public void setEstadoCredito2(String estadoCredito2) {
        this.estadoCredito2 = estadoCredito2;
    }

    public String getCuotasMora2() {
        return cuotasMora2;
    }

    public void setCuotasMora2(String cuotasMora2) {
        this.cuotasMora2 = cuotasMora2;
    }

    public String getFechaProceso2() {
        return fechaProceso2;
    }

    public void setFechaProceso2(String fechaProceso2) {
        this.fechaProceso2 = fechaProceso2;
    }

    public String getFechaPago2() {
        return fechaPago2;
    }

    public void setFechaPago2(String fechaPago2) {
        this.fechaPago2 = fechaPago2;
    }

    public String getCuotaPagada2() {
        return cuotaPagada2;
    }

    public void setCuotaPagada2(String cuotaPagada2) {
        this.cuotaPagada2 = cuotaPagada2;
    }

    public String getFechaMora2() {
        return fechaMora2;
    }

    public void setFechaMora2(String fechaMora2) {
        this.fechaMora2 = fechaMora2;
    }

    public String getPorcentajeFacultativo2() {
        return porcentajeFacultativo2;
    }

    public void setPorcentajeFacultativo2(String porcentajeFacultativo2) {
        this.porcentajeFacultativo2 = porcentajeFacultativo2;
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


    public String getNumeroObjetoAseg2() {
        return NumeroObjetoAseg2;
    }

    public void setNumeroObjetoAseg2(String numeroObjetoAseg2) {
        NumeroObjetoAseg2 = numeroObjetoAseg2;
    }

    public String getAseguradoPrimario2() {
        return AseguradoPrimario2;
    }

    public void setAseguradoPrimario2(String aseguradoPrimario2) {
        AseguradoPrimario2 = aseguradoPrimario2;
    }

    public String getPorcentajeExtraPrima2() {
        return PorcentajeExtraPrima2;
    }

    public void setPorcentajeExtraPrima2(String porcentajeExtraPrima2) {
        PorcentajeExtraPrima2 = porcentajeExtraPrima2;
    }

    public String getPorcentajeDescuento2() {
        return PorcentajeDescuento2;
    }

    public void setPorcentajeDescuento2(String porcentajeDescuento2) {
        PorcentajeDescuento2 = porcentajeDescuento2;
    }

    public String getEdadAsegurado2() {
        return EdadAsegurado2;
    }

    public void setEdadAsegurado2(String edadAsegurado2) {
        EdadAsegurado2 = edadAsegurado2;
    }

    public String getNombreCompletoAsegurado2() {
        return NombreCompletoAsegurado2;
    }

    public void setNombreCompletoAsegurado2(String nombreCompletoAsegurado2) {
        NombreCompletoAsegurado2 = nombreCompletoAsegurado2;
    }

    public String getNombreCompletoBeneficiario2() {
        return NombreCompletoBeneficiario2;
    }

    public void setNombreCompletoBeneficiario2(String nombreCompletoBeneficiario2) {
        NombreCompletoBeneficiario2 = nombreCompletoBeneficiario2;
    }

    public String getNumeroObjetosAseguradosContenidosUnidadRiesgo2() {
        return NumeroObjetosAseguradosContenidosUnidadRiesgo2;
    }

    public void setNumeroObjetosAseguradosContenidosUnidadRiesgo2(String numeroObjetosAseguradosContenidosUnidadRiesgo2) {
        NumeroObjetosAseguradosContenidosUnidadRiesgo2 = numeroObjetosAseguradosContenidosUnidadRiesgo2;
    }

    public String getDocumentoIdentidadAsegurado2() {
        return DocumentoIdentidadAsegurado2;
    }

    public void setDocumentoIdentidadAsegurado2(String documentoIdentidadAsegurado2) {
        DocumentoIdentidadAsegurado2 = documentoIdentidadAsegurado2;
    }

    public String getFechaNacimientoAsegurado2() {
        return FechaNacimientoAsegurado2;
    }

    public void setFechaNacimientoAsegurado2(String fechaNacimientoAsegurado2) {
        FechaNacimientoAsegurado2 = fechaNacimientoAsegurado2;
    }

    public String getDireccionAsegurado2() {
        return DireccionAsegurado2;
    }

    public void setDireccionAsegurado2(String direccionAsegurado2) {
        DireccionAsegurado2 = direccionAsegurado2;
    }

    public String getTelefonoFijo2() {
        return TelefonoFijo2;
    }

    public void setTelefonoFijo2(String telefonoFijo2) {
        TelefonoFijo2 = telefonoFijo2;
    }

    public String getDepartamento2() {
        return Departamento2;
    }

    public void setDepartamento2(String departamento2) {
        Departamento2 = departamento2;
    }

    public String getCiudad2() {
        return Ciudad2;
    }

    public void setCiudad2(String ciudad2) {
        Ciudad2 = ciudad2;
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

    public String getNuevoPorcentajeParticipacionAseguradoVida() {
        return nuevoPorcentajeParticipacionAseguradoVida;
    }
    public void setNuevoPorcentajeParticipacionAseguradoVida(String nuevoPorcentajeParticipacionAseguradoVida) {
        this.nuevoPorcentajeParticipacionAseguradoVida = nuevoPorcentajeParticipacionAseguradoVida;
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

    public String getNuevoTipoBeneficiario() {
        return nuevoTipoBeneficiario;
    }
    public void setNuevoTipoBeneficiario(String nuevoTipoBeneficiario) {
        this.nuevoTipoBeneficiario = nuevoTipoBeneficiario;
    }

    public String getNuevoBeneficiarioIrrevocable() {
        return nuevoBeneficiarioIrrevocable;
    }
    public void setNuevoBeneficiarioIrrevocable(String nuevoBeneficiarioIrrevocable) {
        this.nuevoBeneficiarioIrrevocable = nuevoBeneficiarioIrrevocable;
    }

    public String getNuevoPorcentajeParticipacionBeneficiarioNatural() {
        return nuevoPorcentajeParticipacionBeneficiarioNatural;
    }
    public void setNuevoPorcentajeParticipacionBeneficiarioNatural(String nuevoPorcentajeParticipacionBeneficiarioNatural) {
        this.nuevoPorcentajeParticipacionBeneficiarioNatural = nuevoPorcentajeParticipacionBeneficiarioNatural;
    }

    public String getNuevoCodigoBeneficiario() {
        return nuevoCodigoBeneficiario;
    }
    public void setNuevoCodigoBeneficiario(String nuevoCodigoBeneficiario) {
        this.nuevoCodigoBeneficiario = nuevoCodigoBeneficiario;
    }

    public String getNuevoParentesco() {
        return nuevoParentesco;
    }
    public void setNuevoParentesco(String nuevoParentesco) {
        this.nuevoParentesco = nuevoParentesco;
    }


}
