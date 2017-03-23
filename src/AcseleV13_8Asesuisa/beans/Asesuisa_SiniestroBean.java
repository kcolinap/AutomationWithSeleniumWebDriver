package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;

/**
 * Created by kcolina on 15/03/2017.
 */
public class Asesuisa_SiniestroBean {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestroBean.class);


    //Informacion del siniestro
    private String ordenarPor;
    private String nroSiniestro;
    private String nroPoliza;
    private String fechaOcurrencia;
    private String producto;
    private String eventoSiniestro;

    /****************************************
     * Campos para busqueda avanzada
     ****************************************/
    //Informacion de la poliza
    private String oficina;
    private String nroCotizacion;
    private String nroPropuesta;
    private String fechaEmision;
    private String canalVenta;
    private String frecuenciaPago;
    private String fechaEventoAnterior;
    private String proximaGeneracionPrima;
    private String proximaFacturacion;
    private String flagSuspension;
    private String fechaSuspension;
    private String nombreArchivoTramas;
    private String nroPlan;
    private String periodoDiasSuspension;
    private String fechaInicioSuspension;
    private String procedeSuspension;
    private String montoPrimaArchivoTrama;
    private String fechaEmisionAcsele;

    //informacion de tercero
    private String tipoTercero;
    private String actividadEconomica;
    private String correo1;
    private String correo2;
    private String correo3;
    private String twitterId;
    private String facebookId;
    private String yahooId;
    private String skypeId;
    private String origenTerceroId;
    private String codigoIdentificador;
    private String userLogin;
    private String codigoInterno;
    private String rol;

    //Informacion unidad de riesgo
    private String nroUnidadRiesgo;

    //Informacion Objeto Asegurado
    private String tipoObjetoAsegurado;
    private String nroObjetoAsegurado;
    private String nombreAsegurado;
    private String nombreBeneficiario;

    //Getters and setters


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

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public String getNroCotizacion() {
        return nroCotizacion;
    }

    public void setNroCotizacion(String nroCotizacion) {
        this.nroCotizacion = nroCotizacion;
    }

    public String getNroPropuesta() {
        return nroPropuesta;
    }

    public void setNroPropuesta(String nroPropuesta) {
        this.nroPropuesta = nroPropuesta;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
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

    public String getFechaEventoAnterior() {
        return fechaEventoAnterior;
    }

    public void setFechaEventoAnterior(String fechaEventoAnterior) {
        this.fechaEventoAnterior = fechaEventoAnterior;
    }

    public String getProximaGeneracionPrima() {
        return proximaGeneracionPrima;
    }

    public void setProximaGeneracionPrima(String proximaGeneracionPrima) {
        this.proximaGeneracionPrima = proximaGeneracionPrima;
    }

    public String getProximaFacturacion() {
        return proximaFacturacion;
    }

    public void setProximaFacturacion(String proximaFacturacion) {
        this.proximaFacturacion = proximaFacturacion;
    }

    public String getFlagSuspension() {
        return flagSuspension;
    }

    public void setFlagSuspension(String flagSuspension) {
        this.flagSuspension = flagSuspension;
    }

    public String getFechaSuspension() {
        return fechaSuspension;
    }

    public void setFechaSuspension(String fechaSuspension) {
        this.fechaSuspension = fechaSuspension;
    }

    public String getNombreArchivoTramas() {
        return nombreArchivoTramas;
    }

    public void setNombreArchivoTramas(String nombreArchivoTramas) {
        this.nombreArchivoTramas = nombreArchivoTramas;
    }

    public String getNroPlan() {
        return nroPlan;
    }

    public void setNroPlan(String nroPlan) {
        this.nroPlan = nroPlan;
    }

    public String getPeriodoDiasSuspension() {
        return periodoDiasSuspension;
    }

    public void setPeriodoDiasSuspension(String periodoDiasSuspension) {
        this.periodoDiasSuspension = periodoDiasSuspension;
    }

    public String getFechaInicioSuspension() {
        return fechaInicioSuspension;
    }

    public void setFechaInicioSuspension(String fechaInicioSuspension) {
        this.fechaInicioSuspension = fechaInicioSuspension;
    }

    public String getProcedeSuspension() {
        return procedeSuspension;
    }

    public void setProcedeSuspension(String procedeSuspension) {
        this.procedeSuspension = procedeSuspension;
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

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getActividadEconomica() {
        return actividadEconomica;
    }

    public void setActividadEconomica(String actividadEconomica) {
        this.actividadEconomica = actividadEconomica;
    }

    public String getCorreo1() {
        return correo1;
    }

    public void setCorreo1(String correo1) {
        this.correo1 = correo1;
    }

    public String getCorreo2() {
        return correo2;
    }

    public void setCorreo2(String correo2) {
        this.correo2 = correo2;
    }

    public String getCorreo3() {
        return correo3;
    }

    public void setCorreo3(String correo3) {
        this.correo3 = correo3;
    }

    public String getTwitterId() {
        return twitterId;
    }

    public void setTwitterId(String twitterId) {
        this.twitterId = twitterId;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getYahooId() {
        return yahooId;
    }

    public void setYahooId(String yahooId) {
        this.yahooId = yahooId;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getOrigenTerceroId() {
        return origenTerceroId;
    }

    public void setOrigenTerceroId(String origenTerceroId) {
        this.origenTerceroId = origenTerceroId;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
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
}
