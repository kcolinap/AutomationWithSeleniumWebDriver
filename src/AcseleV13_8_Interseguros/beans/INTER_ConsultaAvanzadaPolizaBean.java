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
 * Created by mchurion on 15/11/2016.
 */
public class INTER_ConsultaAvanzadaPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaAvanzadaPolizaBean.class);

    private String ordenarPor;
    private String buscarPor;
    private String infoPoliza;
    private String conPrimaDeposito;
    private String producto;
    private String edoCicloVida;
    private String motivoEdoCicloVida;
    private String oficina;
    private String numPropuesta;
    private String fechaEmision;
    private String frecuenciaPago;
    private String fechaGeneracionPrima;
    private String flagSuspCancel;
    private String nombreArchivoTramas;
    private String periodoSuspensionCancel;
    private String procedeSuspensionCancel;
    private String fechaEmisionAcsele;
    private String numCotizacion;
    private String numPoliza;
    private String canalVenta;
    private String fechaEventoAnterior;
    private String fechaProximaFacturacion;
    private String fechaSuspensionCancel;
    private String numPlan;
    private String fechaInicioSuspenCancel;
    private String montoPrimaEnvArchTrama;
    private String infoParticipacion;
    private String via;
    private String subvia;
    private String modoPago;
    private String infoTerceros;
    private String tipoTerceros;
    private String participacion;
    private String actividadEconomica;
    private String email2;
    private String twitterId;
    private String yahooId;
    private String idOrigenTercero;
    private String userLogin;
    private String codigoInterno;
    private String email1;
    private String email3;
    private String facebookId;
    private String skypeId;
    private String codigoIdentificador;
    private String rol;
    private String infoUr;
    private String numUr;
    private String infoOa;
    private String tipoObjetoAsegurado;
    private String numObjetoAsegurado;
    private String nombreBeneficiario;
    private String nombreAsegurado;


    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getBuscarPor() {return buscarPor;}
    public void setBuscarPor(String buscarPor) {this.buscarPor = buscarPor;}

    public String getConPrimaDeposito() {return conPrimaDeposito;}
    public void setConPrimaDeposito(String conPrimaDeposito) {this.conPrimaDeposito = conPrimaDeposito;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getEdoCicloVida() {return edoCicloVida;}
    public void setEdoCicloVida(String edoCicloVida) {this.edoCicloVida = edoCicloVida;}

    public String getMotivoEdoCicloVida() {return motivoEdoCicloVida;}
    public void setMotivoEdoCicloVida(String motivoEdoCicloVida) {this.motivoEdoCicloVida = motivoEdoCicloVida;}

    public String getOficina() {return oficina;}
    public void setOficina(String oficina) {this.oficina = oficina;}

    public String getNumPropuesta() {return numPropuesta;}
    public void setNumPropuesta(String numPropuesta) {this.numPropuesta = numPropuesta;}

    public String getFechaEmision() {return fechaEmision;}
    public void setFechaEmision(String fechaEmision) {this.fechaEmision = fechaEmision;}

    public String getFrecuenciaPago() {return frecuenciaPago;}
    public void setFrecuenciaPago(String frecuenciaPago) {this.frecuenciaPago = frecuenciaPago;}

    public String getFechaGeneracionPrima() {return fechaGeneracionPrima;}
    public void setFechaGeneracionPrima(String fechaGeneracionPrima) {this.fechaGeneracionPrima = fechaGeneracionPrima;}

    public String getFlagSuspCancel() {return flagSuspCancel;}
    public void setFlagSuspCancel(String flagSuspCancel) {this.flagSuspCancel = flagSuspCancel;}

    public String getNombreArchivoTramas() {return nombreArchivoTramas;}
    public void setNombreArchivoTramas(String nombreArchivoTramas) {this.nombreArchivoTramas = nombreArchivoTramas;}

    public String getPeriodoSuspensionCancel() {return periodoSuspensionCancel;}
    public void setPeriodoSuspensionCancel(String periodoSuspensionCancel) {this.periodoSuspensionCancel = periodoSuspensionCancel;}

    public String getProcedeSuspensionCancel() {return procedeSuspensionCancel;}
    public void setProcedeSuspensionCancel(String procedeSuspensionCancel) {this.procedeSuspensionCancel = procedeSuspensionCancel;}

    public String getFechaEmisionAcsele() {return fechaEmisionAcsele;}
    public void setFechaEmisionAcsele(String fechaEmisionAcsele) {this.fechaEmisionAcsele = fechaEmisionAcsele;}

    public String getNumCotizacion() {return numCotizacion;}
    public void setNumCotizacion(String numCotizacion) {this.numCotizacion = numCotizacion;}

    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getCanalVenta() {return canalVenta;}
    public void setCanalVenta(String canalVenta) {this.canalVenta = canalVenta;}

    public String getFechaEventoAnterior() {return fechaEventoAnterior;}
    public void setFechaEventoAnterior(String fechaEventoAnterior) {this.fechaEventoAnterior = fechaEventoAnterior;}

    public String getFechaProximaFacturacion() {return fechaProximaFacturacion;}
    public void setFechaProximaFacturacion(String fechaProximaFacturacion) {this.fechaProximaFacturacion = fechaProximaFacturacion;}

    public String getFechaSuspensionCancel() {return fechaSuspensionCancel;}
    public void setFechaSuspensionCancel(String fechaSuspensionCancel) {this.fechaSuspensionCancel = fechaSuspensionCancel;}

    public String getNumPlan() {return numPlan;}
    public void setNumPlan(String numPlan) {this.numPlan = numPlan;}

    public String getFechaInicioSuspenCancel() {return fechaInicioSuspenCancel;}
    public void setFechaInicioSuspenCancel(String fechaInicioSuspenCancel) {this.fechaInicioSuspenCancel = fechaInicioSuspenCancel;}

    public String getMontoPrimaEnvArchTrama() {return montoPrimaEnvArchTrama;}
    public void setMontoPrimaEnvArchTrama(String montoPrimaEnvArchTrama) {this.montoPrimaEnvArchTrama = montoPrimaEnvArchTrama;}

    public String getInfoParticipacion() {return infoParticipacion;}
    public void setInfoParticipacion(String infoParticipacion) {this.infoParticipacion = infoParticipacion;}

    public String getVia() {return via;}
    public void setVia(String via) {this.via = via;}

    public String getSubvia() {return subvia;}
    public void setSubvia(String subvia) {this.subvia = subvia;}

    public String getModoPago() {return modoPago;}
    public void setModoPago(String modoPago) {this.modoPago = modoPago;}

    public String getInfoTerceros() {return infoTerceros;}
    public void setInfoTerceros(String infoTerceros) {this.infoTerceros = infoTerceros;}

    public String getTipoTerceros() {return tipoTerceros;}
    public void setTipoTerceros(String tipoTerceros) {this.tipoTerceros = tipoTerceros;}

    public String getParticipacion() {return participacion;}
    public void setParticipacion(String participacion) {this.participacion = participacion;}

    public String getActividadEconomica() {return actividadEconomica;}
    public void setActividadEconomica(String actividadEconomica) {this.actividadEconomica = actividadEconomica;}

    public String getEmail2() {return email2;}
    public void setEmail2(String email2) {this.email2 = email2;}

    public String getTwitterId() {return twitterId;}
    public void setTwitterId(String twitterId) {this.twitterId = twitterId;}

    public String getYahooId() {return yahooId;}
    public void setYahooId(String yahooId) {this.yahooId = yahooId;}

    public String getIdOrigenTercero() {return subvia;}
    public void setIdOrigenTercero(String idOrigenTercero) {this.idOrigenTercero = idOrigenTercero;}

    public String getUserLogin() {return userLogin;}
    public void setUserLogin(String userLogin) {this.userLogin = userLogin;}

    public String getCodigoInterno() {return codigoInterno;}
    public void setCodigoInterno(String codigoInterno) {this.codigoInterno = codigoInterno;}

    public String getEmail1() {return email1;}
    public void setEmail1(String email1) {this.email1 = email1;}

    public String getEmail3() {return email3;}
    public void setEmail3(String email3) {this.email3 = email3;}

    public String getFacebookId() {return facebookId;}
    public void setFacebookId(String facebookId) {this.facebookId = facebookId;}

    public String getSkypeId() {return skypeId;}
    public void setSkypeId(String skypeId) {this.skypeId = skypeId;}

    public String getCodigoIdentificador() {return codigoIdentificador;}
    public void setCodigoIdentificador(String codigoIdentificador) {this.codigoIdentificador = codigoIdentificador;}

    public String getRol() {return rol;}
    public void setRol(String rol) {this.rol = rol;}

    public String getInfoUr() {return infoUr;}
    public void setInfoUr(String infoUr) {this.infoUr = infoUr;}

    public String getNumUr() {return numUr;}
    public void setNumUr(String numUr) {this.numUr = numUr;}

    public String getInfoOa() {return infoOa;}
    public void setInfoOa(String infoOa) {this.infoOa = infoOa;}

    public String getTipoObjetoAsegurado() {return tipoObjetoAsegurado;}
    public void setTipoObjetoAsegurado(String tipoObjetoAsegurado) {this.tipoObjetoAsegurado = tipoObjetoAsegurado;}

    public String getNumObjetoAsegurado() {return numObjetoAsegurado;}
    public void setNumObjetoAsegurado(String numObjetoAsegurado) {this.numObjetoAsegurado = numObjetoAsegurado;}

    public String getNombreBeneficiario() {return nombreBeneficiario;}
    public void setNombreBeneficiario(String nombreBeneficiario) {this.nombreBeneficiario = nombreBeneficiario;}

    public String getNombreAsegurado() {return nombreAsegurado;}
    public void setNombreAsegurado(String nombreAsegurado) {this.nombreAsegurado = nombreAsegurado;}


    public static ArrayList getConsultaAvanzadaPolizaBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaAvanzada = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,ORDENAR_POR,BUSCAR_POR,CON_PRIMA_DEPOSITO,PRODUCTO,EDO_CICLO_VIDA,MOTIVO_EDO_CICLO_VIDA,OFICINA,NUM_PROPUESTA,FECHA_EMISION,FRECUENCIA_PAGO,FECHA_GENERACION_PRIMA,FLAG_SUSP_CANCEL,NOMBRE_ARCHIVO_TRAMAS,PERIODO_SUSPENSION_CANCEL,PROCEDE_SUSPENSION_CANCEL,FECHA_EMISION_ACSELE,NUM_COTIZACION,NUM_POLIZA,CANAL_VENTA,FECHA_EVENTO_ANTERIOR,FECHA_PROXIMA_FACTURACION,FECHA_SUSPENSION_CANCEL,NUM_PLAN,FECHA_INICIO_SUSPEN_CANCEL,MONTO_PRIMA_ENV_ARCH_TRAMA,INFO_PARTICIPACION,VIA,SUBVIA,MODO_PAGO,INFO_TERCEROS,TIPO_TERCEROS,PARTICIPACION,ACTIVIDAD_ECONOMICA,EMAIL_2,TWITTER_ID,YAHOO_ID,ID_ORIGEN_TERCERO,USER_LOGIN,CODIGO_INTERNO,EMAIL_1,EMAIL_3,FACEBOOK_ID,SKYPE_ID,CÓDIGO_IDENTIFICADOR,ROL,INFO_UR,NUM_UR,INFO_OA,TIPO_OBJETO_ASEGURADO,NUM_OBJETO_ASEGURADO,NOMBRE_BENEFICIARIO,NOMBRE_ASEGURADO FROM CONSULTA_POLIZA_AVANZADA_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaAvanzadaPolizaBean inter_ConsultaAvanzadaPolizaBean = new INTER_ConsultaAvanzadaPolizaBean();

                inter_ConsultaAvanzadaPolizaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_ConsultaAvanzadaPolizaBean.setBuscarPor(rs.getString("BUSCAR_POR"));
                inter_ConsultaAvanzadaPolizaBean.setConPrimaDeposito(rs.getString("CON_PRIMA_DEPOSITO"));
                inter_ConsultaAvanzadaPolizaBean.setProducto(rs.getString("PRODUCTO"));
                inter_ConsultaAvanzadaPolizaBean.setEdoCicloVida(rs.getString("EDO_CICLO_VIDA"));
                inter_ConsultaAvanzadaPolizaBean.setMotivoEdoCicloVida(rs.getString("MOTIVO_EDO_CICLO_VIDA"));
                inter_ConsultaAvanzadaPolizaBean.setOficina(rs.getString("OFICINA"));
                inter_ConsultaAvanzadaPolizaBean.setNumPropuesta(rs.getString("NUM_PROPUESTA"));
                inter_ConsultaAvanzadaPolizaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                inter_ConsultaAvanzadaPolizaBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                inter_ConsultaAvanzadaPolizaBean.setFechaGeneracionPrima(rs.getString("FECHA_GENERACION_PRIMA"));
                inter_ConsultaAvanzadaPolizaBean.setFlagSuspCancel(rs.getString("FLAG_SUSP_CANCEL"));
                inter_ConsultaAvanzadaPolizaBean.setNombreArchivoTramas(rs.getString("NOMBRE_ARCHIVO_TRAMAS"));
                inter_ConsultaAvanzadaPolizaBean.setPeriodoSuspensionCancel(rs.getString("PERIODO_SUSPENSION_CANCEL"));
                inter_ConsultaAvanzadaPolizaBean.setProcedeSuspensionCancel(rs.getString("PROCEDE_SUSPENSION_CANCEL"));
                inter_ConsultaAvanzadaPolizaBean.setFechaEmisionAcsele(rs.getString("FECHA_EMISION_ACSELE"));
                inter_ConsultaAvanzadaPolizaBean.setNumCotizacion(rs.getString("NUM_COTIZACION"));
                inter_ConsultaAvanzadaPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                inter_ConsultaAvanzadaPolizaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                inter_ConsultaAvanzadaPolizaBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                inter_ConsultaAvanzadaPolizaBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                inter_ConsultaAvanzadaPolizaBean.setFechaSuspensionCancel(rs.getString("FECHA_SUSPENSION_CANCEL"));
                inter_ConsultaAvanzadaPolizaBean.setNumPlan(rs.getString("NUM_PLAN"));
                inter_ConsultaAvanzadaPolizaBean.setFechaInicioSuspenCancel(rs.getString("FECHA_INICIO_SUSPEN_CANCEL"));
                inter_ConsultaAvanzadaPolizaBean.setMontoPrimaEnvArchTrama(rs.getString("MONTO_PRIMA_ENV_ARCH_TRAMA"));
                inter_ConsultaAvanzadaPolizaBean.setInfoParticipacion(rs.getString("INFO_PARTICIPACION"));
                inter_ConsultaAvanzadaPolizaBean.setVia(rs.getString("VIA"));
                inter_ConsultaAvanzadaPolizaBean.setSubvia(rs.getString("SUBVIA"));
                inter_ConsultaAvanzadaPolizaBean.setModoPago(rs.getString("MODO_PAGO"));
                inter_ConsultaAvanzadaPolizaBean.setInfoTerceros(rs.getString("INFO_TERCEROS"));
                inter_ConsultaAvanzadaPolizaBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                inter_ConsultaAvanzadaPolizaBean.setParticipacion(rs.getString("PARTICIPACION"));
                inter_ConsultaAvanzadaPolizaBean.setActividadEconomica(rs.getString("ACTIVIDAD_ECONOMICA"));
                inter_ConsultaAvanzadaPolizaBean.setEmail2(rs.getString("EMAIL_2"));
                inter_ConsultaAvanzadaPolizaBean.setTwitterId(rs.getString("TWITTER_ID"));
                inter_ConsultaAvanzadaPolizaBean.setYahooId(rs.getString("YAHOO_ID"));
                inter_ConsultaAvanzadaPolizaBean.setIdOrigenTercero(rs.getString("ID_ORIGEN_TERCERO"));
                inter_ConsultaAvanzadaPolizaBean.setUserLogin(rs.getString("USER_LOGIN"));
                inter_ConsultaAvanzadaPolizaBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                inter_ConsultaAvanzadaPolizaBean.setEmail1(rs.getString("EMAIL_1"));
                inter_ConsultaAvanzadaPolizaBean.setEmail3(rs.getString("EMAIL_3"));
                inter_ConsultaAvanzadaPolizaBean.setFacebookId(rs.getString("FACEBOOK_ID"));
                inter_ConsultaAvanzadaPolizaBean.setSkypeId(rs.getString("SKYPE_ID"));
                inter_ConsultaAvanzadaPolizaBean.setCodigoIdentificador(rs.getString("CÓDIGO_IDENTIFICADOR"));
                inter_ConsultaAvanzadaPolizaBean.setRol(rs.getString("ROL"));
                inter_ConsultaAvanzadaPolizaBean.setInfoUr(rs.getString("INFO_UR"));
                inter_ConsultaAvanzadaPolizaBean.setNumUr(rs.getString("NUM_UR"));
                inter_ConsultaAvanzadaPolizaBean.setInfoOa(rs.getString("INFO_OA"));
                inter_ConsultaAvanzadaPolizaBean.setTipoObjetoAsegurado(rs.getString("TIPO_OBJETO_ASEGURADO"));
                inter_ConsultaAvanzadaPolizaBean.setNumObjetoAsegurado(rs.getString("NUM_OBJETO_ASEGURADO"));
                inter_ConsultaAvanzadaPolizaBean.setNombreBeneficiario(rs.getString("NOMBRE_BENEFICIARIO"));
                inter_ConsultaAvanzadaPolizaBean.setNombreAsegurado(rs.getString("NOMBRE_ASEGURADO"));

                consultaAvanzada.add(inter_ConsultaAvanzadaPolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaAvanzada;

    }
}
