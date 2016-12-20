package AcseleV13_8_Interseguros.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 16/12/2016.
 */
public class INTER_TercerosDireccionesBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosDireccionesBean.class);

    private String tipoTerceros;
    private String numDocIdentidad;
    private String numCarnetExtranjeria;
    private String numPartidaNacimiento;
    private String numRucPersonaNatural;
    private String numCarnetFuerzasArmadas;
    private String indicadorColaborador;
    private String apellidoPaterno;
    private String primerNombre;
    private String autorizarEnviosEmail;
    private String autorizarEnviosLlamadas;
    private String autorizarTratamientoDatos;
    private String profesion;
    private String codigoAfp;
    private String estadoCivil;
    private String fechaFallecimiento;
    private String sexo;
    private String tlfCelular1;
    private String tlfCelular3;
    private String email2;
    private String twitterId;
    private String yahooId;
    private String comunicacionesGenerales;
    private String actividadEconomica;
    private String idOrigenTercero;
    private String codIdentificador;
    private String codigoInterno;
    private String numPasaporte;
    private String numCarnetMinTrabajo;
    private String numCarnetIdentidadPolicia;
    private String libretaMilitar;
    private String carnetDiplomatico;
    private String codigoColaboradorIs;
    private String apellidoMaterno;
    private String segundoNombre;
    private String autorizarEnviosSms;
    private String autorizarComercializacion;
    private String autorizarAccesoDatos;
    private String nacionalidad;
    private String fechaNacimiento;
    private String fechaMatrimonio;
    private String esFumador;
    private String tlfCelular2;
    private String email1;
    private String email3;
    private String facebookId;
    private String skypeId;
    private String indicadorPep;
    private String centroTrabajoAsegurado;
    private String cargoAsegurado;
    private String userLogin;


    public String getTipoTerceros(){
        return tipoTerceros;
    }
    public void setTipoTerceros(String tipoTerceros){
        this.tipoTerceros = tipoTerceros;
    }

    public String getNumDocIdentidad() {
        return numDocIdentidad;
    }
    public void setNumDocIdentidad(String numDocIdentidad) {
        this.numDocIdentidad = numDocIdentidad;
    }

    public String getNumCarnetExtranjeria() {
        return numCarnetExtranjeria;
    }
    public void setNumCarnetExtranjeria(String numCarnetExtranjeria) {
        this.numCarnetExtranjeria = numCarnetExtranjeria;
    }

    public String getNumPartidaNacimiento() {
        return numPartidaNacimiento;
    }
    public void setNumPartidaNacimiento(String numPartidaNacimiento) {
        this.numPartidaNacimiento = numPartidaNacimiento;
    }

    public String getNumRucPersonaNatural(){
        return numRucPersonaNatural;
    }
    public void setNumRucPersonaNatural(String numRucPersonaNatural){
        this.numRucPersonaNatural = numRucPersonaNatural;
    }

    public String getNumCarnetFuerzasArmadas(){
        return numCarnetFuerzasArmadas;
    }
    public void setNumCarnetFuerzasArmadas(String numCarnetFuerzasArmadas){
        this.numCarnetFuerzasArmadas= numCarnetFuerzasArmadas;
    }

    public String getIndicadorColaborador(){
        return  indicadorColaborador;
    }
    public void setIndicadorColaborador(String indicadorColaborador){
        this.indicadorColaborador = indicadorColaborador;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getPrimerNombre(){
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }

    public String getAutorizarEnviosEmail(){
        return autorizarEnviosEmail;
    }
    public void setAutorizarEnviosEmail(String autorizarEnviosEmail){
        this.autorizarEnviosEmail = autorizarEnviosEmail;
    }

    public String getAutorizarEnviosLlamadas(){
        return autorizarEnviosLlamadas;
    }
    public void setAutorizarEnviosLlamadas(String autorizarEnviosLlamadas){
        this.autorizarEnviosLlamadas = autorizarEnviosLlamadas;
    }

    public String getAutorizarTratamientoDatos(){
        return autorizarTratamientoDatos;
    }
    public void setAutorizarTratamientoDatos(String autorizarTratamientoDatos){
        this.autorizarTratamientoDatos = autorizarTratamientoDatos;
    }

    public String getProfesion(){
        return profesion;
    }
    public void setProfesion(String profesion){
        this.profesion = profesion;
    }

    public String getCodigoAfp(){
        return codigoAfp;
    }
    public void setCodigoAfp(String codigoAfp){
        this.codigoAfp = codigoAfp;
    }

    public String getEstadoCivil(){
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public String getFechaFallecimiento(){
        return fechaFallecimiento;
    }
    public void setFechaFallecimiento(String fechaFallecimiento){
        this.fechaFallecimiento= fechaFallecimiento;
    }

    public String getSexo(){
        return  sexo;
    }
    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public String getTlfCelular1(){
        return tlfCelular1;
    }
    public void setTlfCelular1(String tlfCelular1){
        this.tlfCelular1 = tlfCelular1;
    }

    public String getTlfCelular3(){
        return tlfCelular3;
    }
    public void setTlfCelular3(String tlfCelular3){
        this.tlfCelular3 = tlfCelular3;
    }

    public String getEmail2(){
        return email2;
    }
    public void setEmail2(String email2){
        this.email2 = email2;
    }

    public String getTwitterId(){
        return twitterId;
    }
    public void setTwitterId(String twitterId){
        this.twitterId = twitterId;
    }

    public String getYahooId(){
        return yahooId;
    }
    public void setYahooId(String yahooId){
        this.yahooId = yahooId;
    }

    public String getComunicacionesGenerales(){
        return comunicacionesGenerales;
    }
    public void setComunicacionesGenerales(String comunicacionesGenerales){
        this.comunicacionesGenerales = comunicacionesGenerales;
    }

    public String getIdOrigenTercero(){
        return idOrigenTercero;
    }
    public void setIdOrigenTercero(String idOrigenTercero){
        this.idOrigenTercero = idOrigenTercero;
    }

    public String getCodigoInterno(){
        return codigoInterno;
    }
    public void setCodigoInterno(String codigoInterno){
        this.codigoInterno = codigoInterno;
    }

    public String getCodIdentificador() {
        return codIdentificador;
    }
    public void setCodIdentificador(String codIdentificador) {
        this.codIdentificador = codIdentificador;
    }

    public String getNumPasaporte() {
        return numPasaporte;
    }
    public void setNumPasaporte(String numPasaporte) {
        this.numPasaporte = numPasaporte;
    }

    public String getNumCarnetMinTrabajo() {
        return numCarnetMinTrabajo;
    }
    public void setNumCarnetMinTrabajo(String numCarnetMinTrabajo) {
        this.numCarnetMinTrabajo = numCarnetMinTrabajo;
    }

    public String getNumCarnetIdentidadPolicia(){
        return numCarnetIdentidadPolicia;
    }
    public void setNumCarnetIdentidadPolicia(String numCarnetIdentidadPolicia){
        this.numCarnetIdentidadPolicia = numCarnetIdentidadPolicia;
    }

    public String getLibretaMilitar() {
        return libretaMilitar;
    }
    public void setLibretaMilitar(String libretaMilitar) {
        this.libretaMilitar = libretaMilitar;
    }

    public String getCarnetDiplomatico() {
        return carnetDiplomatico;
    }
    public void setCarnetDiplomatico(String carnetDiplomatico) {
        this.carnetDiplomatico = carnetDiplomatico;
    }

    public String getCodigoColaboradorIs() {
        return codigoColaboradorIs;
    }
    public void setCodigoColaboradorIs(String codigoColaboradorIs) {
        this.codigoColaboradorIs = codigoColaboradorIs;
    }

    public String getApellidoMaterno(){
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno){
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getAutorizarEnviosSms() {
        return autorizarEnviosSms;
    }
    public void setAutorizarEnviosSms(String autorizarEnviosSms) {
        this.autorizarEnviosSms = autorizarEnviosSms;
    }

    public String getAutorizarComercializacion() {
        return autorizarComercializacion;
    }
    public void setAutorizarComercializacion(String autorizarComercializacion) {
        this.autorizarComercializacion = autorizarComercializacion;
    }

    public String getAutorizarAccesoDatos(){
        return autorizarAccesoDatos;
    }
    public void setAutorizarAccesoDatos(String autorizarAccesoDatos){
        this.autorizarAccesoDatos = autorizarAccesoDatos;
    }

    public String getActividadEconomica(){
        return actividadEconomica;
    }
    public void setActividadEconomica(String actividadEconomica){
        this.actividadEconomica= actividadEconomica;
    }

    public String getNacionalidad(){
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad){
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaMatrimonio() {
        return fechaMatrimonio;
    }
    public void setFechaMatrimonio(String fechaMatrimonio) {
        this.fechaMatrimonio = fechaMatrimonio;
    }

    public String getEsFumador() {
        return esFumador;
    }
    public void setEsFumador(String esFumador) {
        this.esFumador = esFumador;
    }

    public String getTlfCelular2(){
        return tlfCelular2;
    }
    public void setTlfCelular2(String tlfCelular2){
        this.tlfCelular2 = tlfCelular2;
    }

    public String getEmail1() {
        return email1;
    }
    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail3() {
        return email3;
    }
    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getFacebookId() {
        return facebookId;
    }
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getSkypeId(){
        return skypeId;
    }
    public void setSkypeId(String skypeId){
        this.skypeId = skypeId;
    }

    public String getIndicadorPep(){
        return indicadorPep;
    }
    public void setIndicadorPep(String indicadorPep){
        this.indicadorPep= indicadorPep;
    }

    public String getCentroTrabajoAsegurado(){
        return  centroTrabajoAsegurado;
    }
    public void setCentroTrabajoAsegurado(String centroTrabajoAsegurado){
        this.centroTrabajoAsegurado = centroTrabajoAsegurado;
    }

    public String getCargoAsegurado(){
        return cargoAsegurado;
    }
    public void setCargoAsegurado(String cargoAsegurado){
        this.cargoAsegurado = cargoAsegurado;
    }

    public String getUserLogin(){
        return userLogin;
    }
    public void setUserLogin(String userLogin){
        this.userLogin = userLogin;
    }

    public static ArrayList getTercerodDirecciones() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList direcciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_TercerosDireccionesBean interTercerosDireccionesBean = new INTER_TercerosDireccionesBean();
                interTercerosDireccionesBean.setTipoTerceros(rs.getString("TIPO_TERCERO"));
                interTercerosDireccionesBean.setNumDocIdentidad(rs.getString("NUM_DOC_IDENTIDAD"));
                interTercerosDireccionesBean.setNumCarnetExtranjeria(rs.getString("NUM_CARNET_EXTRANJERIA"));
                interTercerosDireccionesBean.setNumPartidaNacimiento(rs.getString("NUM_PARTIDA_NACIMIENTO"));
                interTercerosDireccionesBean.setNumRucPersonaNatural(rs.getString("NUM_RUC_PERSONA_NATURAL"));
                interTercerosDireccionesBean.setNumCarnetFuerzasArmadas(rs.getString("NUM_CARNET_FUERZAS_ARMADAS"));
                interTercerosDireccionesBean.setIndicadorColaborador(rs.getString("INDICADOR_COLABORADOR"));
                interTercerosDireccionesBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                interTercerosDireccionesBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                interTercerosDireccionesBean.setAutorizarEnviosEmail(rs.getString("AUTORIZAR_ENVIOS_EMAIL"));
                interTercerosDireccionesBean.setAutorizarEnviosLlamadas(rs.getString("AUTORIZAR_ENVIOS_LLAMADAS"));
                interTercerosDireccionesBean.setAutorizarTratamientoDatos(rs.getString("AUTORIZAR_TRATAMIENTO_DATOS"));
                interTercerosDireccionesBean.setProfesion(rs.getString("PROFESION"));
                interTercerosDireccionesBean.setCodigoAfp(rs.getString("CODIGO_AFP"));
                interTercerosDireccionesBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                interTercerosDireccionesBean.setFechaFallecimiento(rs.getString("FECHA_FALLECIMIENTO"));
                interTercerosDireccionesBean.setSexo(rs.getString("SEXO"));
                interTercerosDireccionesBean.setTlfCelular1(rs.getString("TLF_CELULAR1"));
                interTercerosDireccionesBean.setTlfCelular3(rs.getString("TLF_CELULAR3"));
                interTercerosDireccionesBean.setEmail2(rs.getString("EMAIL2"));
                interTercerosDireccionesBean.setTwitterId(rs.getString("TWITTER_ID"));
                interTercerosDireccionesBean.setYahooId(rs.getString("YAHOO_ID"));
                interTercerosDireccionesBean.setComunicacionesGenerales(rs.getString("COMUNICACIONES_GENERALES"));
                interTercerosDireccionesBean.setActividadEconomica(rs.getString("ACTIVIDAD_ECONOMICA"));
                interTercerosDireccionesBean.setIdOrigenTercero(rs.getString("ID_ORIGEN_TERCERO"));
                interTercerosDireccionesBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                interTercerosDireccionesBean.setCodIdentificador(rs.getString("COD_IDENTIFICADOR"));
                interTercerosDireccionesBean.setNumPasaporte(rs.getString("NUM_PASAPORTE"));
                interTercerosDireccionesBean.setNumCarnetMinTrabajo(rs.getString("NUM_CARNET_MIN_TRABAJO"));
                interTercerosDireccionesBean.setNumCarnetIdentidadPolicia(rs.getString("NUM_CARNET_IDENTIDAD_POLICIA"));
                interTercerosDireccionesBean.setLibretaMilitar(rs.getString("LIBRETA_MILITAR"));
                interTercerosDireccionesBean.setCarnetDiplomatico(rs.getString("CARNET_DIPLOMATICO"));
                interTercerosDireccionesBean.setCodigoColaboradorIs(rs.getString("CODIGO_COLABORADOR_IS"));
                interTercerosDireccionesBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                interTercerosDireccionesBean.setSegundoNombre(rs.getString("SEGUNDO_NOMBRE"));
                interTercerosDireccionesBean.setAutorizarEnviosSms(rs.getString("AUTORIZAR_ENVIOS_SMS"));
                interTercerosDireccionesBean.setAutorizarComercializacion(rs.getString("AUTORIZAR_COMERCIALIZACION"));
                interTercerosDireccionesBean.setAutorizarAccesoDatos(rs.getString("AUTORIZAR_ACCESO_DATOS"));
                interTercerosDireccionesBean.setNacionalidad(rs.getString("NACIONALIDAD"));
                interTercerosDireccionesBean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                interTercerosDireccionesBean.setFechaMatrimonio(rs.getString("FECHA_MATRIMONIO"));
                interTercerosDireccionesBean.setEsFumador(rs.getString("ES_FUMADOR"));
                interTercerosDireccionesBean.setTlfCelular2(rs.getString("TLF_CELULAR2"));
                interTercerosDireccionesBean.setEmail1(rs.getString("EMAIL1"));
                interTercerosDireccionesBean.setEmail3(rs.getString("EMAIL3"));
                interTercerosDireccionesBean.setFacebookId(rs.getString("FACEBOOK_ID"));
                interTercerosDireccionesBean.setSkypeId(rs.getString("SKYPE_ID"));
                interTercerosDireccionesBean.setIndicadorPep(rs.getString("INDICADOR_PEP"));
                interTercerosDireccionesBean.setCentroTrabajoAsegurado(rs.getString("CENTRO_TRABAJO_ASEGURADO"));
                interTercerosDireccionesBean.setCargoAsegurado(rs.getString("CARGO_ASEGURADO"));
                interTercerosDireccionesBean.setUserLogin(rs.getString("USER_LOGIN"));
                direcciones.add(interTercerosDireccionesBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return direcciones;
    }
}
