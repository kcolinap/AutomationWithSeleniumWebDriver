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


    //Getters and Setters

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
}
