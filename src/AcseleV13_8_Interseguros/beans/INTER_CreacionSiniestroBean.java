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
 * Created by aazuaje on 12/12/2016.
 */
public class INTER_CreacionSiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_CreacionSiniestroBean.class);


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
    private String pagoMaximo;
    private String montoSiniestro;
    private String razon;

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

    public String getNúmeroPlan() {return númeroPlan;}
    public void setNúmeroPlan(String númeroPlan) {this.númeroPlan = númeroPlan;}

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

    public String getPagoMaximo() {return pagoMaximo;}
    public void setPagoMaximo(String pagoMaximo) {this.pagoMaximo = pagoMaximo;}

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro(String montoSiniestro) {this.montoSiniestro = montoSiniestro;}

    public String getRazon() {return razon;}
    public void setRazon(String razon) {this.razon = razon;}


    public static ArrayList getINTER_CreacionSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList creacionSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_por,Producto,Estados_ciclo_vida,Contratante,Asegurado_Estipulante,ID_Poliza,Fecha_Desde,Fecha_Hasta,Oficina,Numero_Cotizacion,\n" +
                "        Numero_Propuesta,Numero_Poliza,Fecha_Emision,Moneda,Tipo_Produccion,Renovacion_Automatica,Tipo_Moneda,Tipo_Vigencia,Vigencia,Canal_Venta, \n" +
                "        Frecuencia_Pago,Fecha_Evento_Anterior,Fecha_Proxima_Generacion_Prima,Fecha_Proxima_Facturacion,Tipo_Poliza,Numero_Poliza_AS,Flag_Suspension_Cancelacion,\n" +
                "         Fecha_Suspension_Cancelacon,Codigo_Superintendencia,Nombre_Archivo_Tramas,Número_Plan,Fecha_Inicial_Poliza_Matriz,Fecha_Final_Poliza_Matriz,\n" +
                "         Nombre_Asegurado,Nombre_Beneficiario,Periodo_suspension_cancelacion,Fecha_Inicio_Susp_Canc,Proc_Suspension_Cancelacion,\n" +
                "         Monto_Prima_Archivo_Trama,Fecha_Emision_Acsele,Numero_Solicitud,fecha_ocurrencia_siniestro,Sucursal,Numero_Caso,Fecha_Notificacion,\n" +
                "         Fecha_Recepcion_Reclamo,Fecha_Ocurrencia,Lugar_Ocurrencia_Siniestro,Hora_Ocurrencia,Observaciones_Siniestro,Nombres_Apellidos,Direccion,Telefonos,\n" +
                "         Correo_Electronico ,Envio_Comunicaciones_Siniestro,Correo_Electronico_Siniestro,Pago_Maximo,Monto_Siniestro,Razon FROM INTER_CREACION_SINIESTRO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CreacionSiniestroBean inter_creacionSiniestroBean = new INTER_CreacionSiniestroBean();

                inter_creacionSiniestroBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                inter_creacionSiniestroBean.setProducto(rs.getString("PRODUCTO"));
                inter_creacionSiniestroBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                inter_creacionSiniestroBean.setContratante(rs.getString("CONTRATANTE"));
                inter_creacionSiniestroBean.setAseguradoEstipulante(rs.getString("ASEGURADO_ESTIPULANTE"));
                inter_creacionSiniestroBean.setIdPoliza(rs.getString("ID_POLIZA"));
                inter_creacionSiniestroBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                inter_creacionSiniestroBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                inter_creacionSiniestroBean.setOficina(rs.getString("OFICINA"));
                inter_creacionSiniestroBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                inter_creacionSiniestroBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                inter_creacionSiniestroBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                inter_creacionSiniestroBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                inter_creacionSiniestroBean.setMoneda(rs.getString("MONEDA"));
                inter_creacionSiniestroBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                inter_creacionSiniestroBean.setRenovacionAutomatica(rs.getString("RENOVACION_AUTOMATICA"));
                inter_creacionSiniestroBean.setTipoMoneda(rs.getString("TIPO_MONEDA"));
                inter_creacionSiniestroBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                inter_creacionSiniestroBean.setVigencia(rs.getString("VIGENCIA"));
                inter_creacionSiniestroBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                inter_creacionSiniestroBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                inter_creacionSiniestroBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                inter_creacionSiniestroBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                inter_creacionSiniestroBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                inter_creacionSiniestroBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                inter_creacionSiniestroBean.setNumeroPolizaAs(rs.getString("NUMERO_POLIZA_AS"));
                inter_creacionSiniestroBean.setFlagSuspensionCancelacion(rs.getString("FLAG_SUSPENSION_CANCELACION"));
                inter_creacionSiniestroBean.setFechaSuspensionCancelacon(rs.getString("FECHA_SUSPENSION_CANCELACON"));
                inter_creacionSiniestroBean.setCodigoSuperintendencia(rs.getString("CODIGO_SUPERINTENDENCIA"));
                inter_creacionSiniestroBean.setNombreArchivoTramas(rs.getString("NOMBRE_ARCHIVO_TRAMAS"));
                inter_creacionSiniestroBean.setNúmeroPlan(rs.getString("NÚMERO_PLAN"));
                inter_creacionSiniestroBean.setFechaInicialPolizaMatriz(rs.getString("FECHA_INICIAL_POLIZA_MATRIZ"));
                inter_creacionSiniestroBean.setFechaFinalPolizaMatriz(rs.getString("FECHA_FINAL_POLIZA_MATRIZ"));
                inter_creacionSiniestroBean.setNombreAsegurado(rs.getString("NOMBRE_ASEGURADO"));
                inter_creacionSiniestroBean.setNombreBeneficiario(rs.getString("NOMBRE_BENEFICIARIO"));
                inter_creacionSiniestroBean.setPeriodoSuspensionCancelacion(rs.getString("PERIODO_SUSPENSION_CANCELACION"));
                inter_creacionSiniestroBean.setFechaInicioSuspCanc(rs.getString("FECHA_INICIO_SUSP_CANC"));
                inter_creacionSiniestroBean.setProcSuspensionCancelacion(rs.getString("PROC_SUSPENSION_CANCELACION"));
                inter_creacionSiniestroBean.setMontoPrimaArchivoTrama(rs.getString("MONTO_PRIMA_ARCHIVO_TRAMA"));
                inter_creacionSiniestroBean.setFechaEmisionAcsele(rs.getString("FECHA_EMISION_ACSELE"));
                inter_creacionSiniestroBean.setNumeroSolicitud(rs.getString("NUMERO_SOLICITUD"));
                inter_creacionSiniestroBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                inter_creacionSiniestroBean.setSucursal(rs.getString("SUCURSAL"));
                inter_creacionSiniestroBean.setNumeroCaso(rs.getString("NUMERO_CASO"));
                inter_creacionSiniestroBean.setFechaNotificacion(rs.getString("FECHA_NOTIFICACION"));
                inter_creacionSiniestroBean.setFechaRecepcionReclamo(rs.getString("FECHA_RECEPCION_RECLAMO"));
                inter_creacionSiniestroBean.setFechaOcurrencia(rs.getString("FECHA_OCURRENCIA"));
                inter_creacionSiniestroBean.setLugarOcurrenciaSiniestro(rs.getString("LUGAR_OCURRENCIA_SINIESTRO"));
                inter_creacionSiniestroBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                inter_creacionSiniestroBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                inter_creacionSiniestroBean.setNombresApellidos(rs.getString("NOMBRES_APELLIDOS"));
                inter_creacionSiniestroBean.setDireccion(rs.getString("DIRECCION"));
                inter_creacionSiniestroBean.setTelefonos(rs.getString("TELEFONOS"));
                inter_creacionSiniestroBean.setCorreoElectronico(rs.getString("CORREO_ELECTRONICO"));
                inter_creacionSiniestroBean.setEnvioComunicacionesSiniestro(rs.getString("ENVIO_COMUNICACIONES_SINIESTRO"));
                inter_creacionSiniestroBean.setCorreoElectronicoSiniestro(rs.getString("CORREO_ELECTRONICO_SINIESTRO"));
                inter_creacionSiniestroBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                inter_creacionSiniestroBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));
                inter_creacionSiniestroBean.setRazon(rs.getString("RAZON"));

                creacionSiniestro.add(inter_creacionSiniestroBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return creacionSiniestro;
    }



















            }
