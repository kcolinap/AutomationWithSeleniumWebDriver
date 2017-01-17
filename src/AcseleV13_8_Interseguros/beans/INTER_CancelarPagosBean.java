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
 * Created by aazuaje on 16/01/2017.
 */
public class INTER_CancelarPagosBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_CancelarPagosBean.class);


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
    private String sexo;
    private String pagoMaximo;
    private String montoSiniestro;
    private String razon;
    private String cancelar;
    private String aprobar;


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

    public String getSexo() {return sexo;}
    public void setSexo(String sexo) {this.sexo = sexo;}

    public String getPagoMaximo() {return pagoMaximo;}
    public void setPagoMaximo(String pagoMaximo) {this.pagoMaximo = pagoMaximo;}

    public String getMontoSiniestro() {return montoSiniestro;}
    public void setMontoSiniestro(String montoSiniestro) {this.montoSiniestro = montoSiniestro;}

    public String getRazon() {return razon;}
    public void setRazon(String razon) {this.razon = razon;}

    public String getCancelar() {return cancelar;}
    public void setCancelar(String cancelar) {this.cancelar = cancelar;}

    public String getAprobar() {return aprobar;}
    public void setAprobar(String aprobar) {this.aprobar = aprobar;}

    public static ArrayList getINTER_CancelarPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList interCancelarPagos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select *  from INTER_CANCELAR_PAGO ORDER BY PRUEBA ASC");


        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CancelarPagosBean inter_cancelarPagosBean = new INTER_CancelarPagosBean();

                inter_cancelarPagosBean.setOrdenarPor(rs.getString("ORDENARPOR"));
                inter_cancelarPagosBean.setProducto(rs.getString("PRODUCTO"));
                inter_cancelarPagosBean.setEstadosCicloVida(rs.getString("ESTADOSCICLOVIDA"));
                inter_cancelarPagosBean.setContratante(rs.getString("CONTRATANTE"));
                inter_cancelarPagosBean.setAseguradoEstipulante(rs.getString("ASEGURADOESTIPULANTE"));
                inter_cancelarPagosBean.setIdPoliza(rs.getString("IDPOLIZA"));
                inter_cancelarPagosBean.setFechaDesde(rs.getString("FECHADESDE"));
                inter_cancelarPagosBean.setFechaHasta(rs.getString("FECHAHASTA"));
                inter_cancelarPagosBean.setOficina(rs.getString("OFICINA"));
                inter_cancelarPagosBean.setNumeroCotizacion(rs.getString("NUMEROCOTIZACION"));
                inter_cancelarPagosBean.setNumeroPropuesta(rs.getString("NUMEROPROPUESTA"));
                inter_cancelarPagosBean.setNumeroPoliza(rs.getString("NUMEROPOLIZA"));
                inter_cancelarPagosBean.setFechaEmision(rs.getString("FECHAEMISION"));
                inter_cancelarPagosBean.setMoneda(rs.getString("MONEDA"));
                inter_cancelarPagosBean.setTipoProduccion(rs.getString("TIPOPRODUCCION"));
                inter_cancelarPagosBean.setRenovacionAutomatica(rs.getString("RENOVACIONAUTOMATICA"));
                inter_cancelarPagosBean.setTipoMoneda(rs.getString("TIPOMONEDA"));
                inter_cancelarPagosBean.setTipoVigencia(rs.getString("TIPOVIGENCIA"));
                inter_cancelarPagosBean.setVigencia(rs.getString("VIGENCIA"));
                inter_cancelarPagosBean.setCanalVenta(rs.getString("CANALVENTA"));
                inter_cancelarPagosBean.setFrecuenciaPago(rs.getString("FRECUENCIAPAGO"));
                inter_cancelarPagosBean.setFechaEventoAnterior(rs.getString("FECHAEVENTOANTERIOR"));
                inter_cancelarPagosBean.setFechaProximaGeneracionPrima(rs.getString("FECHAPROXIMAGENERACIONPRIMA"));
                inter_cancelarPagosBean.setFechaProximaFacturacion(rs.getString("FECHAPROXIMAFACTURACION"));
                inter_cancelarPagosBean.setTipoPoliza(rs.getString("TIPOPOLIZA"));
                inter_cancelarPagosBean.setNumeroPolizaAs(rs.getString("NUMEROPOLIZAAS"));
                inter_cancelarPagosBean.setFlagSuspensionCancelacion(rs.getString("FLAGSUSPENSIONCANCELACION"));
                inter_cancelarPagosBean.setFechaSuspensionCancelacon(rs.getString("FECHASUSPENSIONCANCELACON"));
                inter_cancelarPagosBean.setCodigoSuperintendencia(rs.getString("CODIGOSUPERINTENDENCIA"));
                inter_cancelarPagosBean.setNombreArchivoTramas(rs.getString("NOMBREARCHIVOTRAMAS"));
                inter_cancelarPagosBean.setNúmeroPlan(rs.getString("NÚMEROPLAN"));
                inter_cancelarPagosBean.setFechaInicialPolizaMatriz(rs.getString("FECHAINICIALPOLIZAMATRIZ"));
                inter_cancelarPagosBean.setFechaFinalPolizaMatriz(rs.getString("FECHAFINALPOLIZAMATRIZ"));
                inter_cancelarPagosBean.setNombreAsegurado(rs.getString("NOMBREASEGURADO"));
                inter_cancelarPagosBean.setNombreBeneficiario(rs.getString("NOMBREBENEFICIARIO"));
                inter_cancelarPagosBean.setPeriodoSuspensionCancelacion(rs.getString("PERIODOSUSPENSIONCANCELACION"));
                inter_cancelarPagosBean.setFechaInicioSuspCanc(rs.getString("FECHAINICIOSUSPCANC"));
                inter_cancelarPagosBean.setProcSuspensionCancelacion(rs.getString("PROCSUSPENSIONCANCELACION"));
                inter_cancelarPagosBean.setMontoPrimaArchivoTrama(rs.getString("MONTOPRIMAARCHIVOTRAMA"));
                inter_cancelarPagosBean.setFechaEmisionAcsele(rs.getString("FECHAEMISIONACSELE"));
                inter_cancelarPagosBean.setNumeroSolicitud(rs.getString("NUMEROSOLICITUD"));
                inter_cancelarPagosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHAOCURRENCIASINIESTRO"));
                inter_cancelarPagosBean.setSucursal(rs.getString("SUCURSAL"));
                inter_cancelarPagosBean.setNumeroCaso(rs.getString("NUMEROCASO"));
                inter_cancelarPagosBean.setFechaNotificacion(rs.getString("FECHANOTIFICACION"));
                inter_cancelarPagosBean.setFechaRecepcionReclamo(rs.getString("FECHARECEPCIONRECLAMO"));
                inter_cancelarPagosBean.setFechaOcurrencia(rs.getString("FECHAOCURRENCIA"));
                inter_cancelarPagosBean.setLugarOcurrenciaSiniestro(rs.getString("LUGAROCURRENCIASINIESTRO"));
                inter_cancelarPagosBean.setHoraOcurrencia(rs.getString("HORAOCURRENCIA"));
                inter_cancelarPagosBean.setObservacionesSiniestro(rs.getString("OBSERVACIONESSINIESTRO"));
                inter_cancelarPagosBean.setNombresApellidos(rs.getString("NOMBRESAPELLIDOS"));
                inter_cancelarPagosBean.setDireccion(rs.getString("DIRECCION"));
                inter_cancelarPagosBean.setTelefonos(rs.getString("TELEFONOS"));
                inter_cancelarPagosBean.setCorreoElectronico(rs.getString("CORREOELECTRONICO"));
                inter_cancelarPagosBean.setEnvioComunicacionesSiniestro(rs.getString("ENVIOCOMUNICACIONESSINIESTRO"));
                inter_cancelarPagosBean.setCorreoElectronicoSiniestro(rs.getString("CORREOELECTRONICOSINIESTRO"));
                inter_cancelarPagosBean.setSexo(rs.getString("SEXO"));
                inter_cancelarPagosBean.setPagoMaximo(rs.getString("PAGOMAXIMO"));
                inter_cancelarPagosBean.setMontoSiniestro(rs.getString("MONTOSINIESTRO"));
                inter_cancelarPagosBean.setRazon(rs.getString("RAZON"));
                inter_cancelarPagosBean.setCancelar(rs.getString("CANCELAR"));
                inter_cancelarPagosBean.setAprobar(rs.getString("APROBAR"));

                interCancelarPagos.add(inter_cancelarPagosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return interCancelarPagos;
    }
}
