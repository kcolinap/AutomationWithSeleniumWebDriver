package AcseleV13_8_Alfa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by aazuaje on 10/08/2016.
 */
public class CancelarPagosBean implements Serializable {

    private final static Logger log = Logger.getLogger(CancelarPagosBean.class);
    private String ordenarPor;
    private String producto;
    private String estadosCicloVida;
    private String contratante;
    private String asegurado;
    private String idPoliza;
    private String fechaDesde;
    private String fechaHasta;
    private String sucursalPoliza;
    private String numeroPoliza;
    private String fechaEmision;
    private String monedaPoliza;
    private String tipoMonedaPoliza;
    private String tipoProduccion;
    private String tipoVigencia;
    private String vigencia;
    private String canalVenta;
    private String frecuenciaPago;
    private String fechaEventoAnterior;
    private String fechaProximaGeneracionPrima;
    private String fechaProximaFacturacion;
    private String tipoPoliza;
    private String numeroCotizacion;
    private String numeroPropuesta;
    private String fechaOcurrenciaSiniestro;
    private String sucursalSiniestros;
    private String horaOcurrencia;
    private String fechaAvisoCompania;
    private String horaNotificacion;
    private String fechaOperConstSiniestro;
    private String fechaReclFormalizacion;
    private String fechaInterrupcionTerminos;
    private String documentoIdentReclamante;
    private String reclamante;
    private String causaGeneralMuerte;
    private String causalesEspecifCobertMuerte;
    private String departamento;
    private String ciudad;
    private String generoAsegurado;
    private String profesionAsegurado;
    private String actividadSiniestro;
    private String fechaActividad;
    private String observacionesSiniestro;
    private String certificado;
    private String objetosAsegurados;
    private String coberturaAfectada;
    private String pagoMaximo;
    private String monedaSiniestro;
    private String fechaCompromiso;
    private String fechaInicial;
    private String fechaFinal;
    private String razon;
    private String estado;
    private String tipo;
    private String montoSiniestro;
    private String cancelar;
    private String aprobar;


    public String getOrdenarPor() {
        return ordenarPor;
    }
    public void setOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
    }

    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getEstadosCicloVida() {
        return estadosCicloVida;
    }
    public void setEstadosCicloVida(String estadosCicloVida) {this.estadosCicloVida = estadosCicloVida;}

    public String getContratante() {
        return contratante;
    }
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAsegurado() {
        return asegurado;
    }
    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
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

    public String getSucursalPoliza() {
        return sucursalPoliza;
    }
    public void setSucursalPoliza(String sucursalPoliza) {
        this.sucursalPoliza = sucursalPoliza;
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

    public String getMonedaPoliza() {
        return monedaPoliza;
    }
    public void setMonedaPoliza(String monedaPoliza) {
        this.monedaPoliza = monedaPoliza;
    }

    public String getTipoMonedaPoliza() {
        return tipoMonedaPoliza;
    }
    public void setTipoMonedaPoliza(String tipoMonedaPoliza) {
        this.tipoMonedaPoliza = tipoMonedaPoliza;
    }

    public String getTipoProduccion() {
        return tipoProduccion;
    }
    public void setTipoProduccion(String tipoProduccion) {
        this.tipoProduccion = tipoProduccion;
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

    public String getFechaProximaGeneracionPrima() {
        return fechaProximaGeneracionPrima;
    }
    public void setFechaProximaGeneracionPrima(String fechaProximaGeneracionPrima) {
        this.fechaProximaGeneracionPrima = fechaProximaGeneracionPrima;}

    public String getFechaProximaFacturacion() {
        return fechaProximaFacturacion;
    }
    public void setFechaProximaFacturacion(String fechaProximaFacturacion) {
        this.fechaProximaFacturacion = fechaProximaFacturacion;}

    public String getTipoPoliza() {
        return tipoPoliza;
    }
    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
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

    public String getFechaOcurrenciaSiniestro() {
        return fechaOcurrenciaSiniestro;
    }
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {
        this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getSucursalSiniestros() {
        return sucursalSiniestros;
    }
    public void setSucursalSiniestros(String sucursalSiniestros) {
        this.sucursalSiniestros = sucursalSiniestros;
    }

    public String getHoraOcurrencia() {
        return horaOcurrencia;
    }
    public void setHoraOcurrencia(String horaOcurrencia) {
        this.horaOcurrencia = horaOcurrencia;
    }

    public String getFechaAvisoCompania() {
        return fechaAvisoCompania;
    }
    public void setFechaAvisoCompania(String fechaAvisoCompania) {
        this.fechaAvisoCompania = fechaAvisoCompania;
    }

    public String getHoraNotificacion() {
        return horaNotificacion;
    }
    public void setHoraNotificacion(String horaNotificacion) {
        this.horaNotificacion= horaNotificacion;
    }

    public String getFechaOperConstSiniestro() {
        return fechaOperConstSiniestro;
    }
    public void setFechaOperConstSiniestro(String fechaOperConstSiniestro) {
        this.fechaOperConstSiniestro= fechaOperConstSiniestro;}


    public String getFechaReclFormalizacion() {
        return fechaReclFormalizacion;
    }
    public void setFechaReclFormalizacion(String fechaReclFormalizacion) {
        this.fechaReclFormalizacion = fechaReclFormalizacion;}

    public String getFechaInterrupcionTerminos() {
        return fechaInterrupcionTerminos;}
    public void setFechaInterrupcionTerminos(String fechaInterrupcionTerminos) {
        this.fechaInterrupcionTerminos = fechaInterrupcionTerminos;}

    public String getDocumentoIdentReclamante() {return documentoIdentReclamante;}
    public void setDocumentoIdentReclamante(String documentoIdentReclamante) {
        this.documentoIdentReclamante = documentoIdentReclamante;}

    public String getReclamante() {
        return reclamante;
    }
    public void setReclamante(String reclamante) {
        this.reclamante = reclamante;
    }

    public String getCausaGeneralMuerte() {
        return causaGeneralMuerte;
    }
    public void setCausaGeneralMuerte(String causaGeneralMuerte) {
        this.causaGeneralMuerte = causaGeneralMuerte;
    }

    public String getCausalesEspecifCobertMuerte() {
        return causalesEspecifCobertMuerte;
    }
    public void setCausalesEspecifCobertMuerte(String causalesEspecifCobertMuerte) {
        this.causalesEspecifCobertMuerte = causalesEspecifCobertMuerte;}

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

    public String getGeneroAsegurado() {
        return generoAsegurado;
    }
    public void setGeneroAsegurado(String generoAsegurado) {
        this.generoAsegurado = generoAsegurado;
    }

    public String getProfesionAsegurado() {
        return profesionAsegurado;
    }
    public void setProfesionAsegurado(String profesionAsegurado) {
        this.profesionAsegurado = profesionAsegurado;
    }

    public String getActividadSiniestro() {
        return actividadSiniestro;
    }
    public void setActividadSiniestro(String actividadSiniestro) {
        this.actividadSiniestro = actividadSiniestro;
    }

    public String getFechaActividad() {
        return fechaActividad;
    }
    public void setFechaActividad(String fechaActividad) {
        this.fechaActividad = fechaActividad;
    }

    public String getObservacionesSiniestro() {
        return observacionesSiniestro;
    }
    public void setObservacionesSiniestro(String observacionesSiniestro) {
        this.observacionesSiniestro = observacionesSiniestro;}

    public String getCertificado() {
        return certificado;
    }
    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getObjetosAsegurados() {
        return objetosAsegurados;
    }
    public void setObjetosAsegurados(String objetosAsegurados) {
        this.objetosAsegurados = objetosAsegurados;
    }

    public String getCoberturaAfectada() {
        return coberturaAfectada;
    }
    public void setCoberturaAfectada(String coberturaAfectada) {
        this.coberturaAfectada = coberturaAfectada;
    }

    public String getPagoMaximo() {
        return pagoMaximo;
    }
    public void setPagoMaximo(String pagoMaximo) {
        this.pagoMaximo = pagoMaximo;
    }

    public String getMonedaSiniestro() {
        return monedaSiniestro;
    }
    public void setMonedaSiniestro(String monedaSiniestro) {
        this.monedaSiniestro = monedaSiniestro;
    }

    public String getFechaCompromiso() {
        return fechaCompromiso;
    }
    public void setFechaCompromiso(String fechaCompromiso) {
        this.fechaCompromiso = fechaCompromiso;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }
    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getRazon() {
        return razon;
    }
    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMontoSiniestro() {
        return montoSiniestro;
    }
    public void setMontoSiniestro(String montoSiniestro) {
        this.montoSiniestro = montoSiniestro;
    }

    public String getCancelar() {
        return cancelar;
    }
    public void setCancelar(String cancelar) {
        this.cancelar = cancelar;
    }

    public String getAprobar() {
        return aprobar;
    }
    public void setAprobar(String aprobar) {
        this.aprobar = aprobar;
    }



    public static ArrayList getCancelarPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList pagos = new ArrayList();
        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza,Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos,Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Fecha_Compromiso, Fecha_inicial, Fecha_Final, Razon, Estado, Tipo, Monto_Siniestro, Cancelar, Aprobar from CANCELAR_PAGOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CancelarPagosBean cancelarPagosBean = new CancelarPagosBean();

                cancelarPagosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                cancelarPagosBean.setProducto(rs.getString("PRODUCTO"));
                cancelarPagosBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                cancelarPagosBean.setContratante(rs.getString("CONTRATANTE"));
                cancelarPagosBean.setAsegurado(rs.getString("ASEGURADO"));
                cancelarPagosBean.setIdPoliza(rs.getString("ID_POLIZA"));
                cancelarPagosBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                cancelarPagosBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                cancelarPagosBean.setSucursalPoliza(rs.getString("SUCURSAL_POLIZA"));
                cancelarPagosBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                cancelarPagosBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                cancelarPagosBean.setMonedaPoliza(rs.getString("MONEDA_POLIZA"));
                cancelarPagosBean.setMonedaPoliza(rs.getString("TIPO_MONEDA_POLIZA"));
                cancelarPagosBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                cancelarPagosBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                cancelarPagosBean.setVigencia(rs.getString("VIGENCIA"));
                cancelarPagosBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                cancelarPagosBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                cancelarPagosBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                cancelarPagosBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                cancelarPagosBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                cancelarPagosBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                cancelarPagosBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                cancelarPagosBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                cancelarPagosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                cancelarPagosBean.setSucursalSiniestros(rs.getString("SUCURSAL_SINIESTROS"));
                cancelarPagosBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                cancelarPagosBean.setFechaAvisoCompania(rs.getString("FECHA_AVISO_COMPANIA"));
                cancelarPagosBean.setHoraNotificacion(rs.getString("HORA_NOTIFICACION"));
                cancelarPagosBean.setFechaOperConstSiniestro(rs.getString("FECHA_OPER_CONST_SINIESTRO"));
                cancelarPagosBean.setFechaReclFormalizacion(rs.getString("FECHA_RECL_FORMALIZACION"));
                cancelarPagosBean.setFechaInterrupcionTerminos(rs.getString("FECHA_INTERRUPCION_TERMINOS"));
                cancelarPagosBean.setDocumentoIdentReclamante(rs.getString("DOCUMENTO_IDENT_RECLAMANTE"));
                cancelarPagosBean.setReclamante(rs.getString("RECLAMANTE"));
                cancelarPagosBean.setCausaGeneralMuerte(rs.getString("CAUSA_GENERAL_MUERTE"));
                cancelarPagosBean.setCausalesEspecifCobertMuerte(rs.getString("CAUSALES_ESPECIF_COBERT_MUERTE"));
                cancelarPagosBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                cancelarPagosBean.setCiudad(rs.getString("CIUDAD"));
                cancelarPagosBean.setGeneroAsegurado(rs.getString("GENERO_ASEGURADO"));
                cancelarPagosBean.setProfesionAsegurado(rs.getString("PROFESION_ASEGURADO"));
                cancelarPagosBean.setActividadSiniestro(rs.getString("ACTIVIDAD_SINIESTRO"));
                cancelarPagosBean.setFechaActividad(rs.getString("FECHA_ACTIVIDAD"));
                cancelarPagosBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                cancelarPagosBean.setCertificado(rs.getString("CERTIFICADO"));
                cancelarPagosBean.setObjetosAsegurados(rs.getString("OBJETOS_ASEGURADOS"));
                cancelarPagosBean.setCoberturaAfectada(rs.getString("COBERTURA_AFECTADA"));
                cancelarPagosBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                cancelarPagosBean.setMonedaSiniestro(rs.getString("MONEDA_SINIESTRO"));
                cancelarPagosBean.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                cancelarPagosBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                cancelarPagosBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                cancelarPagosBean.setRazon(rs.getString("RAZON"));
                cancelarPagosBean.setEstado(rs.getString("ESTADO"));
                cancelarPagosBean.setTipo(rs.getString("TIPO"));
                cancelarPagosBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));
                cancelarPagosBean.setCancelar(rs.getString("CANCELAR"));
                cancelarPagosBean.setAprobar(rs.getString("APROBAR"));

                pagos.add(cancelarPagosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }


        return pagos;
    }


}

