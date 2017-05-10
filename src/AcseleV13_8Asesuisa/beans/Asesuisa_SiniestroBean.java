package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;

/**
 * Created by kcolina on 30/04/2017.
 */
public class Asesuisa_SiniestroBean {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBean.class);


    //Informacion del siniestro
    private String ordenarPor;
    private String nroSiniestro;
    private String nroPoliza;
    private String fechaOcurrencia;
    private String producto;


    /****************************************
     * Campos para busqueda avanzada
     ****************************************/

    //Informacion de sieniestro
    private String eventoSiniestro;

    //Informacion de la poliza
    private String sucursal;
    private String nroCotizacion;
    private String fechaEmision;
    private String tipoPoliza;
    private String codigoRamo;
    private String clasePoliza;
    private String tipoProduccion;
    private String primaACeder;
    private String primaARetener;
    private String comisonCorredor;
    private String canalVenta;
    private String proximaGeneracionPrima;
    private String comisionNegociable;
    private String porcentajeComisionNeg;
    private String nivelAgrupacionReaseguro;
    private String unidadComercial;
    private String proyectoDependencia;
    private String nombreDP;
    private String codigoAgrupador;
    private String observacionesSuscripcion;
    private String observacionesPoliza;


    //informacion de tercero
    private String tipoTercero;
    private String codigoIdentificador;
    private String login;
    private String rol;

    //Informacion unidad de riesgo
    private String nroUnidadRiesgo;

    //Informacion Objeto Asegurado
    private String tipoObjetoAsegurado;
    private String nroObjetoAsegurado;

    //Atributos para la creacion
    //private String ordenarPor;
    //private String producto;
    private String estadosCicloVida;
    private String contratante;
    private String aseguradoEstipulante;
    private String idPoliza;
    private String fechaDesde;
    private String fechaHasta;
    private String oficina;
    private String numeroCotizacion;
    private String numeroPropuesta;
    private String numeroPoliza;
    //private String fechaEmision;
    private String moneda;
   // private String tipoProduccion;
    private String renovacionAutomatica;
    private String tipoMoneda;
    private String tipoVigencia;
    private String vigencia;
    //private String canalVenta;
    private String frecuenciaPago;
    private String fechaEventoAnterior;
    private String fechaProximaGeneracionPrima;
    private String fechaProximaFacturacion;
    //private String tipoPoliza;
    private String numeroPolizaAs;
    private String flagSuspensionCancelacion;
    private String fechaSuspensionCancelacon;
    private String codigoSuperintendencia;
    private String nombreArchivoTramas;
    private String númeroPlan;
    private String fechaInicialPolizaMatriz;
    private String fechaFinalPolizaMatriz;
    private String nombreAsegurado;
    private String nombreBeneficiario;
    private String periodoSuspensionCancelacion;
    private String fechaInicioSuspCanc;
    private String procSuspensionCancelacion;
    private String montoPrimaArchivoTrama;
    private String fechaEmisionAcsele;
    private String numeroSolicitud;
    private String fechaOcurrenciaSiniestro;
    //private String sucursal;
    private String numeroCaso;
    private String fechaNotificacion;
    private String fechaRecepcionReclamo;
    //private String fechaOcurrencia;
    private String lugarOcurrenciaSiniestro;
    private String horaOcurrencia;
    private String observacionesSiniestro;
    private String nombresApellidos;
    private String direccion;
    private String telefonos;
    private String correoElectronico;
    private String envioComunicacionesSiniestro;
    private String correoElectronicoSiniestro;
    private String pagoMaximo;
    private String montoSiniestro;
    private String razon;

    //Campos para agregar objeto afectado
    private String reporter;
    private String tlfReporter;
    private String tlfAsegurado;
    private String mailAsegurado;
    private String mailReporter;
    private String lugarOcurrencia;




    //Getters and Setters


    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getTlfReporter() {
        return tlfReporter;
    }

    public void setTlfReporter(String tlfReporter) {
        this.tlfReporter = tlfReporter;
    }

    public String getTlfAsegurado() {
        return tlfAsegurado;
    }

    public void setTlfAsegurado(String tlfAsegurado) {
        this.tlfAsegurado = tlfAsegurado;
    }

    public String getMailAsegurado() {
        return mailAsegurado;
    }

    public void setMailAsegurado(String mailAsegurado) {
        this.mailAsegurado = mailAsegurado;
    }

    public String getMailReporter() {
        return mailReporter;
    }

    public void setMailReporter(String mailReporter) {
        this.mailReporter = mailReporter;
    }

    public String getLugarOcurrencia() {
        return lugarOcurrencia;
    }

    public void setLugarOcurrencia(String lugarOcurrencia) {
        this.lugarOcurrencia = lugarOcurrencia;
    }

    public String getOrdenarPor() {
        return ordenarPor;
    }

    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getNroSiniestro() {
        return nroSiniestro;
    }

    public void setNroSiniestro(String nroSiniestro) {
        this.nroSiniestro = nroSiniestro;
    }

    public String getNroPoliza() {
        return nroPoliza;
    }

    public void setNroPoliza(String nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public String getFechaOcurrencia() {
        return fechaOcurrencia;
    }

    public void setFechaOcurrencia(String fechaOcurrencia) {
        this.fechaOcurrencia = fechaOcurrencia;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEventoSiniestro() {
        return eventoSiniestro;
    }

    public void setEventoSiniestro(String eventoSiniestro) {
        this.eventoSiniestro = eventoSiniestro;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNroCotizacion() {
        return nroCotizacion;
    }

    public void setNroCotizacion(String nroCotizacion) {
        this.nroCotizacion = nroCotizacion;
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

    public String getTipoProduccion() {
        return tipoProduccion;
    }

    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
    }

    public String getPrimaACeder() {
        return primaACeder;
    }

    public void setPrimaACeder(String primaACeder) {
        this.primaACeder = primaACeder;
    }

    public String getPrimaARetener() {
        return primaARetener;
    }

    public void setPrimaARetener(String primaARetener) {
        this.primaARetener = primaARetener;
    }

    public String getComisonCorredor() {
        return comisonCorredor;
    }

    public void setComisonCorredor(String comisonCorredor) {
        this.comisonCorredor = comisonCorredor;
    }

    public String getCanalVenta() {
        return canalVenta;
    }

    public void setCanalVenta(String canalVenta) {
        this.canalVenta = canalVenta;
    }

    public String getProximaGeneracionPrima() {
        return proximaGeneracionPrima;
    }

    public void setProximaGeneracionPrima(String proximaGeneracionPrima) {
        this.proximaGeneracionPrima = proximaGeneracionPrima;
    }

    public String getComisionNegociable() {
        return comisionNegociable;
    }

    public void setComisionNegociable(String comisionNegociable) {
        this.comisionNegociable = comisionNegociable;
    }

    public String getPorcentajeComisionNeg() {
        return porcentajeComisionNeg;
    }

    public void setPorcentajeComisionNeg(String porcentajeComisionNeg) {
        this.porcentajeComisionNeg = porcentajeComisionNeg;
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

    public String getNombreDP() {
        return nombreDP;
    }

    public void setNombreDP(String nombreDP) {
        this.nombreDP = nombreDP;
    }

    public String getCodigoAgrupador() {
        return codigoAgrupador;
    }

    public void setCodigoAgrupador(String codigoAgrupador) {
        this.codigoAgrupador = codigoAgrupador;
    }

    public String getObservacionesSuscripcion() {
        return observacionesSuscripcion;
    }

    public void setObservacionesSuscripcion(String observacionesSuscripcion) {
        this.observacionesSuscripcion = observacionesSuscripcion;
    }

    public String getObservacionesPoliza() {
        return observacionesPoliza;
    }

    public void setObservacionesPoliza(String observacionesPoliza) {
        this.observacionesPoliza = observacionesPoliza;
    }

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNroUnidadRiesgo() {
        return nroUnidadRiesgo;
    }

    public void setNroUnidadRiesgo(String nroUnidadRiesgo) {
        this.nroUnidadRiesgo = nroUnidadRiesgo;
    }

    public String getTipoObjetoAsegurado() {
        return tipoObjetoAsegurado;
    }

    public void setTipoObjetoAsegurado(String tipoObjetoAsegurado) {
        this.tipoObjetoAsegurado = tipoObjetoAsegurado;
    }

    public String getNroObjetoAsegurado() {
        return nroObjetoAsegurado;
    }

    public void setNroObjetoAsegurado(String nroObjetoAsegurado) {
        this.nroObjetoAsegurado = nroObjetoAsegurado;
    }

    public String getEstadosCicloVida() {
        return estadosCicloVida;
    }

    public void setEstadosCicloVida(String estadosCicloVida) {
        this.estadosCicloVida = estadosCicloVida;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAseguradoEstipulante() {
        return aseguradoEstipulante;
    }

    public void setAseguradoEstipulante(String aseguradoEstipulante) {
        this.aseguradoEstipulante = aseguradoEstipulante;
    }

    public String getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(String idPoliza) {
        this.idPoliza = idPoliza;
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

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNumeroCotizacion() {
        return numeroCotizacion;
    }

    public void setNumeroCotizacion(String numeroCotizacion) {
        this.numeroCotizacion = numeroCotizacion;
    }

    public String getNumeroPropuesta() {
        return numeroPropuesta;
    }

    public void setNumeroPropuesta(String numeroPropuesta) {
        this.numeroPropuesta = numeroPropuesta;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getRenovacionAutomatica() {
        return renovacionAutomatica;
    }

    public void setRenovacionAutomatica(String renovacionAutomatica) {
        this.renovacionAutomatica = renovacionAutomatica;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String getTipoVigencia() {
        return tipoVigencia;
    }

    public void setTipoVigencia(String tipoVigencia) {
        this.tipoVigencia = tipoVigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    public void setFrecuenciaPago(String frecuenciaPago) {
        this.frecuenciaPago = frecuenciaPago;
    }

    public String getFechaEventoAnterior() {
        return fechaEventoAnterior;
    }

    public void setFechaEventoAnterior(String fechaEventoAnterior) {
        this.fechaEventoAnterior = fechaEventoAnterior;
    }

    public String getFechaProximaGeneracionPrima() {
        return fechaProximaGeneracionPrima;
    }

    public void setFechaProximaGeneracionPrima(String fechaProximaGeneracionPrima) {
        this.fechaProximaGeneracionPrima = fechaProximaGeneracionPrima;
    }

    public String getFechaProximaFacturacion() {
        return fechaProximaFacturacion;
    }

    public void setFechaProximaFacturacion(String fechaProximaFacturacion) {
        this.fechaProximaFacturacion = fechaProximaFacturacion;
    }

    public String getNumeroPolizaAs() {
        return numeroPolizaAs;
    }

    public void setNumeroPolizaAs(String numeroPolizaAs) {
        this.numeroPolizaAs = numeroPolizaAs;
    }

    public String getFlagSuspensionCancelacion() {
        return flagSuspensionCancelacion;
    }

    public void setFlagSuspensionCancelacion(String flagSuspensionCancelacion) {
        this.flagSuspensionCancelacion = flagSuspensionCancelacion;
    }

    public String getFechaSuspensionCancelacon() {
        return fechaSuspensionCancelacon;
    }

    public void setFechaSuspensionCancelacon(String fechaSuspensionCancelacon) {
        this.fechaSuspensionCancelacon = fechaSuspensionCancelacon;
    }

    public String getCodigoSuperintendencia() {
        return codigoSuperintendencia;
    }

    public void setCodigoSuperintendencia(String codigoSuperintendencia) {
        this.codigoSuperintendencia = codigoSuperintendencia;
    }

    public String getNombreArchivoTramas() {
        return nombreArchivoTramas;
    }

    public void setNombreArchivoTramas(String nombreArchivoTramas) {
        this.nombreArchivoTramas = nombreArchivoTramas;
    }

    public String getNúmeroPlan() {
        return númeroPlan;
    }

    public void setNúmeroPlan(String númeroPlan) {
        this.númeroPlan = númeroPlan;
    }

    public String getFechaInicialPolizaMatriz() {
        return fechaInicialPolizaMatriz;
    }

    public void setFechaInicialPolizaMatriz(String fechaInicialPolizaMatriz) {
        this.fechaInicialPolizaMatriz = fechaInicialPolizaMatriz;
    }

    public String getFechaFinalPolizaMatriz() {
        return fechaFinalPolizaMatriz;
    }

    public void setFechaFinalPolizaMatriz(String fechaFinalPolizaMatriz) {
        this.fechaFinalPolizaMatriz = fechaFinalPolizaMatriz;
    }

    public String getNombreAsegurado() {
        return nombreAsegurado;
    }

    public void setNombreAsegurado(String nombreAsegurado) {
        this.nombreAsegurado = nombreAsegurado;
    }

    public String getNombreBeneficiario() {
        return nombreBeneficiario;
    }

    public void setNombreBeneficiario(String nombreBeneficiario) {
        this.nombreBeneficiario = nombreBeneficiario;
    }

    public String getPeriodoSuspensionCancelacion() {
        return periodoSuspensionCancelacion;
    }

    public void setPeriodoSuspensionCancelacion(String periodoSuspensionCancelacion) {
        this.periodoSuspensionCancelacion = periodoSuspensionCancelacion;
    }

    public String getFechaInicioSuspCanc() {
        return fechaInicioSuspCanc;
    }

    public void setFechaInicioSuspCanc(String fechaInicioSuspCanc) {
        this.fechaInicioSuspCanc = fechaInicioSuspCanc;
    }

    public String getProcSuspensionCancelacion() {
        return procSuspensionCancelacion;
    }

    public void setProcSuspensionCancelacion(String procSuspensionCancelacion) {
        this.procSuspensionCancelacion = procSuspensionCancelacion;
    }

    public String getMontoPrimaArchivoTrama() {
        return montoPrimaArchivoTrama;
    }

    public void setMontoPrimaArchivoTrama(String montoPrimaArchivoTrama) {
        this.montoPrimaArchivoTrama = montoPrimaArchivoTrama;
    }

    public String getFechaEmisionAcsele() {
        return fechaEmisionAcsele;
    }

    public void setFechaEmisionAcsele(String fechaEmisionAcsele) {
        this.fechaEmisionAcsele = fechaEmisionAcsele;
    }

    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getFechaOcurrenciaSiniestro() {
        return fechaOcurrenciaSiniestro;
    }

    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {
        this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;
    }

    public String getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(String numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public String getFechaNotificacion() {
        return fechaNotificacion;
    }

    public void setFechaNotificacion(String fechaNotificacion) {
        this.fechaNotificacion = fechaNotificacion;
    }

    public String getFechaRecepcionReclamo() {
        return fechaRecepcionReclamo;
    }

    public void setFechaRecepcionReclamo(String fechaRecepcionReclamo) {
        this.fechaRecepcionReclamo = fechaRecepcionReclamo;
    }

    public String getLugarOcurrenciaSiniestro() {
        return lugarOcurrenciaSiniestro;
    }

    public void setLugarOcurrenciaSiniestro(String lugarOcurrenciaSiniestro) {
        this.lugarOcurrenciaSiniestro = lugarOcurrenciaSiniestro;
    }

    public String getHoraOcurrencia() {
        return horaOcurrencia;
    }

    public void setHoraOcurrencia(String horaOcurrencia) {
        this.horaOcurrencia = horaOcurrencia;
    }

    public String getObservacionesSiniestro() {
        return observacionesSiniestro;
    }

    public void setObservacionesSiniestro(String observacionesSiniestro) {
        this.observacionesSiniestro = observacionesSiniestro;
    }

    public String getNombresApellidos() {
        return nombresApellidos;
    }

    public void setNombresApellidos(String nombresApellidos) {
        this.nombresApellidos = nombresApellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEnvioComunicacionesSiniestro() {
        return envioComunicacionesSiniestro;
    }

    public void setEnvioComunicacionesSiniestro(String envioComunicacionesSiniestro) {
        this.envioComunicacionesSiniestro = envioComunicacionesSiniestro;
    }

    public String getCorreoElectronicoSiniestro() {
        return correoElectronicoSiniestro;
    }

    public void setCorreoElectronicoSiniestro(String correoElectronicoSiniestro) {
        this.correoElectronicoSiniestro = correoElectronicoSiniestro;
    }

    public String getPagoMaximo() {
        return pagoMaximo;
    }

    public void setPagoMaximo(String pagoMaximo) {
        this.pagoMaximo = pagoMaximo;
    }

    public String getMontoSiniestro() {
        return montoSiniestro;
    }

    public void setMontoSiniestro(String montoSiniestro) {
        this.montoSiniestro = montoSiniestro;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
}
