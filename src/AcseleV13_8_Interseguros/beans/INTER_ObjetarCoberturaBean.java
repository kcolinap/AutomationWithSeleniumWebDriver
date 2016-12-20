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
 * Created by aazuaje on 16/12/2016.
 */
public class INTER_ObjetarCoberturaBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_ObjetarCoberturaBean.class);

    private String ordenarPor;
    private String producto;
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
    private String fechaEmision;
    private String moneda;
    private String tipoProduccion;
    private String renovacionAutomatica;
    private String tipoMoneda;
    private String tipoVigencia;
    private String vigencia;
    private String canalVenta;
    private String frecuenciaPago;
    private String fechaEventoAnterior;
    private String fechaProximaGeneracionPrima;
    private String fechaProximaFacturacion;
    private String tipoPoliza;
    private String numeroPolizaAs;
    private String flagSuspensionCancelacion;
    private String fechaSuspensionCancelacon;
    private String codigoSuperintendencia;
    private String nombreArchivoTramas;
    private String numeroPlan;
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
    private String sucursal;
    private String numeroCaso;
    private String fechaNotificacion;
    private String fechaRecepcionReclamo;
    private String fechaOcurrencia;
    private String lugarOcurrenciaSiniestro;
    private String horaOcurrencia;
    private String observacionesSiniestro;
    private String nombresApellidos;
    private String direccion;
    private String telefonos;
    private String correoElectronico;
    private String envioComunicacionesSiniestro;
    private String correoElectronicoSiniestro;
    private String sexo;
    private String pagoMaximo;
    private String motivoRechazo;
    private String comentariosSiniestro;
    private String nombreBeneficiarioObjetar;
    private String direcciónBeneficiario;

    public String getOrdenarPor() {return ordenarPor;}
    public void setOrdenarPor(String ordenarPor) {this.ordenarPor = ordenarPor;}

    public String getProducto() {return producto;}
    public void setProducto(String producto) {this.producto = producto;}

    public String getEstadosCicloVida() {return estadosCicloVida;}
    public void setEstadosCicloVida(String estadosCicloVida) {this.estadosCicloVida = estadosCicloVida;}

    public String getContratante() {return contratante;}
    public void setContratante(String contratante) {this.contratante = contratante;}

    public String getAseguradoEstipulante() {return aseguradoEstipulante;}
    public void setAseguradoEstipulante(String aseguradoEstipulante) {this.aseguradoEstipulante = aseguradoEstipulante;}

    public String getIdPoliza() {return idPoliza;}
    public void setIdPoliza(String idPoliza) {this.idPoliza = idPoliza;}

    public String getFechaDesde() {return fechaDesde;}
    public void setFechaDesde(String fechaDesde) {this.fechaDesde = fechaDesde;}

    public String getFechaHasta() {return fechaHasta;}
    public void setFechaHasta(String fechaHasta) {this.fechaHasta = fechaHasta;}

    public String getOficina() {return oficina;}
    public void setOficina(String oficina) {this.oficina = oficina;}

    public String getNumeroCotizacion() {return numeroCotizacion;}
    public void setNumeroCotizacion(String numeroCotizacion) {this.numeroCotizacion = numeroCotizacion;}

    public String getNumeroPropuesta() {return numeroPropuesta;}
    public void setNumeroPropuesta(String numeroPropuesta) {this.numeroPropuesta = numeroPropuesta;}

    public String getNumeroPoliza() {return numeroPoliza;}
    public void setNumeroPoliza(String numeroPoliza) {this.numeroPoliza = numeroPoliza;}

    public String getFechaEmision() {return fechaEmision;}
    public void setFechaEmision(String fechaEmision) {this.fechaEmision = fechaEmision;}

    public String getMoneda() {return moneda;}
    public void setMoneda(String moneda) {this.moneda = moneda;}

    public String getTipoProduccion() {return tipoProduccion;}
    public void setTipoProduccion(String tipoProduccion) {this.tipoProduccion = tipoProduccion;}

    public String getRenovacionAutomatica() {return renovacionAutomatica;}
    public void setRenovacionAutomatica(String renovacionAutomatica) {this.renovacionAutomatica = renovacionAutomatica;}

    public String getTipoMoneda() {return tipoMoneda;}
    public void setTipoMoneda(String tipoMoneda) {this.tipoMoneda = tipoMoneda;}

    public String getTipoVigencia() {return tipoVigencia;}
    public void setTipoVigencia(String tipoVigencia) {this.tipoVigencia = tipoVigencia;}

    public String getVigencia() {return vigencia;}
    public void setVigencia(String vigencia) {this.vigencia = vigencia;}

    public String getCanalVenta() {return canalVenta;}
    public void setCanalVenta(String canalVenta) {this.canalVenta = canalVenta;}


    public String getFrecuenciaPago() {return frecuenciaPago;}
    public void setFrecuenciaPago(String frecuenciaPago) {this.frecuenciaPago = frecuenciaPago;}

    public String getFechaEventoAnterior() {return fechaEventoAnterior;}
    public void setFechaEventoAnterior(String fechaEventoAnterior) {this.fechaEventoAnterior = fechaEventoAnterior;}

    public String getFechaProximaGeneracionPrima() {return fechaProximaGeneracionPrima;}
    public void setFechaProximaGeneracionPrima(String fechaProximaGeneracionPrima) {this.fechaProximaGeneracionPrima = fechaProximaGeneracionPrima;}

    public String getFechaProximaFacturacion() {return fechaProximaFacturacion;}
    public void setFechaProximaFacturacion(String fechaProximaFacturacion) {this.fechaProximaFacturacion = fechaProximaFacturacion;}

    public String getTipoPoliza() {return tipoPoliza;}
    public void setTipoPoliza(String tipoPoliza) {this.tipoPoliza = tipoPoliza;}

    public String getNumeroPolizaAs() {return numeroPolizaAs;}
    public void setNumeroPolizaAs(String numeroPolizaAs) {this.numeroPolizaAs = numeroPolizaAs;}

    public String getFlagSuspensionCancelacion() {return flagSuspensionCancelacion;}
    public void setFlagSuspensionCancelacion(String flagSuspensionCancelacion) {this.flagSuspensionCancelacion = flagSuspensionCancelacion;}

    public String getFechaSuspensionCancelacon() {return fechaSuspensionCancelacon;}
    public void setFechaSuspensionCancelacon(String fechaSuspensionCancelacon) {this.fechaSuspensionCancelacon = fechaSuspensionCancelacon;}

    public String getCodigoSuperintendencia() {return codigoSuperintendencia;}
    public void setCodigoSuperintendencia(String codigoSuperintendencia) {this.codigoSuperintendencia = codigoSuperintendencia;}

    public String getNombreArchivoTramas() {return nombreArchivoTramas;}
    public void setNombreArchivoTramas(String nombreArchivoTramas) {this.nombreArchivoTramas = nombreArchivoTramas;}

    public String getNumeroPlan() {return numeroPlan;}
    public void setNumeroPlan(String numeroPlan) {this.numeroPlan = numeroPlan;}

    public String getFechaInicialPolizaMatriz() {return fechaInicialPolizaMatriz;}
    public void setFechaInicialPolizaMatriz(String fechaInicialPolizaMatriz) {this.fechaInicialPolizaMatriz = fechaInicialPolizaMatriz;}

    public String getFechaFinalPolizaMatriz() {return fechaFinalPolizaMatriz;}
    public void setFechaFinalPolizaMatriz(String fechaFinalPolizaMatriz) {this.fechaFinalPolizaMatriz = fechaFinalPolizaMatriz;}

    public String getNombreAsegurado() {return nombreAsegurado;}
    public void setNombreAsegurado(String nombreAsegurado) {this.nombreAsegurado = nombreAsegurado;}

    public String getNombreBeneficiario() {return nombreBeneficiario;}
    public void setNombreBeneficiario(String nombreBeneficiario) {this.nombreBeneficiario = nombreBeneficiario;}

    public String getPeriodoSuspensionCancelacion() {return periodoSuspensionCancelacion;}
    public void setPeriodoSuspensionCancelacion(String periodoSuspensionCancelacion) {this.periodoSuspensionCancelacion = periodoSuspensionCancelacion;}

    public String getFechaInicioSuspCanc() {return fechaInicioSuspCanc;}
    public void setFechaInicioSuspCanc(String fechaInicioSuspCanc) {this.fechaInicioSuspCanc = fechaInicioSuspCanc;}

    public String getProcSuspensionCancelacion() {return procSuspensionCancelacion;}
    public void setProcSuspensionCancelacion(String procSuspensionCancelacion) {this.procSuspensionCancelacion = procSuspensionCancelacion;}

    public String getMontoPrimaArchivoTrama() {return montoPrimaArchivoTrama;}
    public void setMontoPrimaArchivoTrama(String montoPrimaArchivoTrama) {this.montoPrimaArchivoTrama = montoPrimaArchivoTrama;}

    public String getFechaEmisionAcsele() {return fechaEmisionAcsele;}
    public void setFechaEmisionAcsele(String fechaEmisionAcsele) {this.fechaEmisionAcsele = fechaEmisionAcsele;}

    public String getNumeroSolicitud() {return numeroSolicitud;}
    public void setNumeroSolicitud(String numeroSolicitud) {this.numeroSolicitud = numeroSolicitud;}

    public String getFechaOcurrenciaSiniestro() {return fechaOcurrenciaSiniestro;}
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getSucursal() {return sucursal;}
    public void setSucursal(String sucursal) {this.sucursal = sucursal;}

    public String getNumeroCaso() {return numeroCaso;}
    public void setNumeroCaso(String numeroCaso) {this.numeroCaso = numeroCaso;}

    public String getFechaNotificacion() {return fechaNotificacion;}
    public void setFechaNotificacion(String fechaNotificacion) {this.fechaNotificacion = fechaNotificacion;}

    public String getFechaRecepcionReclamo() {return fechaRecepcionReclamo;}
    public void setFechaRecepcionReclamo(String fechaRecepcionReclamo) {this.fechaRecepcionReclamo = fechaRecepcionReclamo;}

    public String getFechaOcurrencia() {return fechaOcurrencia;}
    public void setFechaOcurrencia(String fechaOcurrencia) {this.fechaOcurrencia = fechaOcurrencia;}

    public String getLugarOcurrenciaSiniestro() {return lugarOcurrenciaSiniestro;}
    public void setLugarOcurrenciaSiniestro(String lugarOcurrenciaSiniestro) {this.lugarOcurrenciaSiniestro = lugarOcurrenciaSiniestro;}

    public String getHoraOcurrencia() {return horaOcurrencia;}
    public void setHoraOcurrencia(String horaOcurrencia) {this.horaOcurrencia = horaOcurrencia;}

    public String getObservacionesSiniestro() {return observacionesSiniestro;}
    public void setObservacionesSiniestro(String observacionesSiniestro) {this.observacionesSiniestro = observacionesSiniestro;}

    public String getNombresApellidos() {return nombresApellidos;}
    public void setNombresApellidos(String nombresApellidos) {this.nombresApellidos = nombresApellidos;}

    public String getDireccion() {return direccion;}
    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getTelefonos() {return telefonos;}
    public void setTelefonos(String telefonos) {this.telefonos = telefonos;}

    public String getCorreoElectronico() {return correoElectronico;}
    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}

    public String getEnvioComunicacionesSiniestro() {return envioComunicacionesSiniestro;}
    public void setEnvioComunicacionesSiniestro(String envioComunicacionesSiniestro) {this.envioComunicacionesSiniestro = envioComunicacionesSiniestro;}

    public String getCorreoElectronicoSiniestro() {return correoElectronicoSiniestro;}
    public void setCorreoElectronicoSiniestro(String correoElectronicoSiniestro) {this.correoElectronicoSiniestro = correoElectronicoSiniestro;}

    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getPagoMaximo() {return pagoMaximo;}
    public void setPagoMaximo(String pagoMaximo) {this.pagoMaximo = pagoMaximo;}

    public String getMotivoRechazo() {return motivoRechazo;}
    public void setMotivoRechazo(String motivoRechazo) {this.motivoRechazo = motivoRechazo;}

    public String getComentariosSiniestro() {return comentariosSiniestro;}
    public void setComentariosSiniestro(String comentariosSiniestro) {this.comentariosSiniestro = comentariosSiniestro;}

    public String getNombreBeneficiarioObjetar() {return nombreBeneficiarioObjetar;}
    public void setNombreBeneficiarioObjetar(String nombreBeneficiarioObjetar) {this.nombreBeneficiarioObjetar = nombreBeneficiarioObjetar;}

    public String getDirecciónBeneficiario() {return direcciónBeneficiario;}
    public void setDirecciónBeneficiario(String direcciónBeneficiario) {this.direcciónBeneficiario = direcciónBeneficiario;}


    public static ArrayList getInter_ObjetarCobertura() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList InterObjetarCobertura = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * FROM INTER_OBJETAR_COBERTURA  ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ObjetarCoberturaBean inter_objetarCoberturaBean = new INTER_ObjetarCoberturaBean();

                inter_objetarCoberturaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_objetarCoberturaBean.setProducto(rs.getString("PRODUCTO"));
                inter_objetarCoberturaBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                inter_objetarCoberturaBean.setContratante(rs.getString("CONTRATANTE"));
                inter_objetarCoberturaBean.setAseguradoEstipulante(rs.getString("ASEGURADO_ESTIPULANTE"));
                inter_objetarCoberturaBean.setIdPoliza(rs.getString("ID_POLIZA"));
                inter_objetarCoberturaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                inter_objetarCoberturaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                inter_objetarCoberturaBean.setOficina(rs.getString("OFICINA"));
                inter_objetarCoberturaBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                inter_objetarCoberturaBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                inter_objetarCoberturaBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_objetarCoberturaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                inter_objetarCoberturaBean.setMoneda(rs.getString("MONEDA"));
                inter_objetarCoberturaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                inter_objetarCoberturaBean.setRenovacionAutomatica(rs.getString("RENOVACION_AUTOMATICA"));
                inter_objetarCoberturaBean.setTipoMoneda(rs.getString("TIPO_MONEDA"));
                inter_objetarCoberturaBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                inter_objetarCoberturaBean.setVigencia(rs.getString("VIGENCIA"));
                inter_objetarCoberturaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                inter_objetarCoberturaBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                inter_objetarCoberturaBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                inter_objetarCoberturaBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                inter_objetarCoberturaBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                inter_objetarCoberturaBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                inter_objetarCoberturaBean.setNumeroPolizaAs(rs.getString("NUMERO_POLIZA_AS"));
                inter_objetarCoberturaBean.setFlagSuspensionCancelacion(rs.getString("FLAG_SUSPENSION_CANCELACION"));
                inter_objetarCoberturaBean.setFechaSuspensionCancelacon(rs.getString("FECHA_SUSPENSION_CANCELACON"));
                inter_objetarCoberturaBean.setCodigoSuperintendencia(rs.getString("CODIGO_SUPERINTENDENCIA"));
                inter_objetarCoberturaBean.setNombreArchivoTramas(rs.getString("NOMBRE_ARCHIVO_TRAMAS"));
                inter_objetarCoberturaBean.setNumeroPlan(rs.getString("NUMERO_PLAN"));
                inter_objetarCoberturaBean.setFechaInicialPolizaMatriz(rs.getString("FECHA_INICIAL_POLIZA_MATRIZ"));
                inter_objetarCoberturaBean.setFechaFinalPolizaMatriz(rs.getString("FECHA_FINAL_POLIZA_MATRIZ"));
                inter_objetarCoberturaBean.setNombreAsegurado(rs.getString("NOMBRE_ASEGURADO"));
                inter_objetarCoberturaBean.setNombreBeneficiario(rs.getString("NOMBRE_BENEFICIARIO"));
                inter_objetarCoberturaBean.setPeriodoSuspensionCancelacion(rs.getString("PERIODO_SUSPENSION_CANCELACION"));
                inter_objetarCoberturaBean.setFechaInicioSuspCanc(rs.getString("FECHA_INICIO_SUSP_CANC"));
                inter_objetarCoberturaBean.setProcSuspensionCancelacion(rs.getString("PROC_SUSPENSION_CANCELACION"));
                inter_objetarCoberturaBean.setMontoPrimaArchivoTrama(rs.getString("MONTO_PRIMA_ARCHIVO_TRAMA"));
                inter_objetarCoberturaBean.setFechaEmisionAcsele(rs.getString("FECHA_EMISION_ACSELE"));
                inter_objetarCoberturaBean.setNumeroSolicitud(rs.getString("NUMERO_SOLICITUD"));
                inter_objetarCoberturaBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_objetarCoberturaBean.setSucursal(rs.getString("SUCURSAL"));
                inter_objetarCoberturaBean.setNumeroCaso(rs.getString("NUMERO_CASO"));
                inter_objetarCoberturaBean.setFechaNotificacion(rs.getString("FECHA_NOTIFICACION"));
                inter_objetarCoberturaBean.setFechaRecepcionReclamo(rs.getString("FECHA_RECEPCION_RECLAMO"));
                inter_objetarCoberturaBean.setFechaOcurrencia(rs.getString("FECHA_OCURRENCIA"));
                inter_objetarCoberturaBean.setLugarOcurrenciaSiniestro(rs.getString("LUGAR_OCURRENCIA_SINIESTRO"));
                inter_objetarCoberturaBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                inter_objetarCoberturaBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                inter_objetarCoberturaBean.setNombresApellidos(rs.getString("NOMBRES_APELLIDOS"));
                inter_objetarCoberturaBean.setDireccion(rs.getString("DIRECCION"));
                inter_objetarCoberturaBean.setTelefonos(rs.getString("TELEFONOS"));
                inter_objetarCoberturaBean.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                inter_objetarCoberturaBean.setEnvioComunicacionesSiniestro(rs.getString("ENVIO_COMUNICACIONES_SINIESTRO"));
                inter_objetarCoberturaBean.setCorreoElectronicoSiniestro(rs.getString("CORREO_ELECTRONICO_SINIESTRO"));
                inter_objetarCoberturaBean.setSexo(rs.getString("SEXO"));
                inter_objetarCoberturaBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                inter_objetarCoberturaBean.setMotivoRechazo(rs.getString("MOTIVO_RECHAZO"));
                inter_objetarCoberturaBean.setComentariosSiniestro(rs.getString("COMENTARIOS_SINIESTRO"));
                inter_objetarCoberturaBean.setNombreBeneficiarioObjetar(rs.getString("NOMBRE_BENEFICIARIO_OBJETAR"));
                inter_objetarCoberturaBean.setDirecciónBeneficiario(rs.getString("DIRECCIÓN_BENEFICIARIO"));

                InterObjetarCobertura.add(inter_objetarCoberturaBean);

            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return InterObjetarCobertura;
    }

}
