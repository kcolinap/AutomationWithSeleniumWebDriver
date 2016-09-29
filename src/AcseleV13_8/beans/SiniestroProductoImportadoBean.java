package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kzambrano on 27/09/2016.
 */
public class SiniestroProductoImportadoBean implements Serializable{

    private final static Logger log = Logger.getLogger(SiniestroProductoImportadoBean.class);
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

    public static ArrayList getSiniestroProductoImportado() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList siniestroProductoImportado = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, ORDENAR_POR, PRODUCTO, ESTADOS_CICLO_VIDA ,CONTRATANTE, ASEGURADO ,ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL_POLIZA, NUMERO_POLIZA, FECHA_EMISION, MONEDA_POLIZA, TIPO_MONEDA_POLIZA ,TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENTO_ANTERIOR, FECHA_PROXIMA_GENERACION_PRIMA, FECHA_PROXIMA_FACTURACION, TIPO_POLIZA, NUMERO_COTIZACION, NUMERO_PROPUESTA, FECHA_OCURRENCIA_SINIESTRO, SUCURSAL_SINIESTROS, HORA_OCURRENCIA, FECHA_AVISO_COMPANIA, HORA_NOTIFICACION, FECHA_OPER_CONST_SINIESTRO, FECHA_RECL_FORMALIZACION, FECHA_INTERRUPCION_TERMINOS, DOCUMENTO_IDENT_RECLAMANTE, RECLAMANTE, CAUSA_GENERAL_MUERTE, CAUSALES_ESPECIF_COBERT_MUERTE, DEPARTAMENTO, CIUDAD, GENERO_ASEGURADO, PROFESION_ASEGURADO, ACTIVIDAD_SINIESTRO, FECHA_ACTIVIDAD, OBSERVACIONES_SINIESTRO, CERTIFICADO, OBJETOS_ASEGURADOS, COBERTURA_AFECTADA, PAGO_MAXIMO, MONEDA_SINIESTRO, FECHA_COMPROMISO, FECHA_INICIAL, FECHA_FINAL, RAZON, ESTADO, TIPO, MONTO_SINIESTRO FROM SINIESTROS_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                SiniestroProductoImportadoBean siniestroProductoImportadoBean = new SiniestroProductoImportadoBean();

                siniestroProductoImportadoBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                siniestroProductoImportadoBean.setProducto(rs.getString("PRODUCTO"));
                siniestroProductoImportadoBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                siniestroProductoImportadoBean.setContratante(rs.getString("CONTRATANTE"));
                siniestroProductoImportadoBean.setAsegurado(rs.getString("ASEGURADO"));
                siniestroProductoImportadoBean.setIdPoliza(rs.getString("ID_POLIZA"));
                siniestroProductoImportadoBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                siniestroProductoImportadoBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                siniestroProductoImportadoBean.setSucursalPoliza(rs.getString("SUCURSAL_POLIZA"));
                siniestroProductoImportadoBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                siniestroProductoImportadoBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                siniestroProductoImportadoBean.setMonedaPoliza(rs.getString("MONEDA_POLIZA"));
                siniestroProductoImportadoBean.setMonedaPoliza(rs.getString("TIPO_MONEDA_POLIZA"));
                siniestroProductoImportadoBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                siniestroProductoImportadoBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                siniestroProductoImportadoBean.setVigencia(rs.getString("VIGENCIA"));
                siniestroProductoImportadoBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                siniestroProductoImportadoBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                siniestroProductoImportadoBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                siniestroProductoImportadoBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                siniestroProductoImportadoBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                siniestroProductoImportadoBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                siniestroProductoImportadoBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                siniestroProductoImportadoBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                siniestroProductoImportadoBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                siniestroProductoImportadoBean.setSucursalSiniestros(rs.getString("SUCURSAL_SINIESTROS"));
                siniestroProductoImportadoBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                siniestroProductoImportadoBean.setFechaAvisoCompania(rs.getString("FECHA_AVISO_COMPANIA"));
                siniestroProductoImportadoBean.setHoraNotificacion(rs.getString("HORA_NOTIFICACION"));
                siniestroProductoImportadoBean.setFechaOperConstSiniestro(rs.getString("FECHA_OPER_CONST_SINIESTRO"));
                siniestroProductoImportadoBean.setFechaReclFormalizacion(rs.getString("FECHA_RECL_FORMALIZACION"));
                siniestroProductoImportadoBean.setFechaInterrupcionTerminos(rs.getString("FECHA_INTERRUPCION_TERMINOS"));
                siniestroProductoImportadoBean.setDocumentoIdentReclamante(rs.getString("DOCUMENTO_IDENT_RECLAMANTE"));
                siniestroProductoImportadoBean.setReclamante(rs.getString("RECLAMANTE"));
                siniestroProductoImportadoBean.setCausaGeneralMuerte(rs.getString("CAUSA_GENERAL_MUERTE"));
                siniestroProductoImportadoBean.setCausalesEspecifCobertMuerte(rs.getString("CAUSALES_ESPECIF_COBERT_MUERTE"));
                siniestroProductoImportadoBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                siniestroProductoImportadoBean.setCiudad(rs.getString("CIUDAD"));
                siniestroProductoImportadoBean.setGeneroAsegurado(rs.getString("GENERO_ASEGURADO"));
                siniestroProductoImportadoBean.setProfesionAsegurado(rs.getString("PROFESION_ASEGURADO"));
                siniestroProductoImportadoBean.setActividadSiniestro(rs.getString("ACTIVIDAD_SINIESTRO"));
                siniestroProductoImportadoBean.setFechaActividad(rs.getString("FECHA_ACTIVIDAD"));
                siniestroProductoImportadoBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                siniestroProductoImportadoBean.setCertificado(rs.getString("CERTIFICADO"));
                siniestroProductoImportadoBean.setObjetosAsegurados(rs.getString("OBJETOS_ASEGURADOS"));
                siniestroProductoImportadoBean.setCoberturaAfectada(rs.getString("COBERTURA_AFECTADA"));
                siniestroProductoImportadoBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                siniestroProductoImportadoBean.setMonedaSiniestro(rs.getString("MONEDA_SINIESTRO"));
                siniestroProductoImportadoBean.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                siniestroProductoImportadoBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                siniestroProductoImportadoBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                siniestroProductoImportadoBean.setRazon(rs.getString("RAZON"));
                siniestroProductoImportadoBean.setEstado(rs.getString("ESTADO"));
                siniestroProductoImportadoBean.setTipo(rs.getString("TIPO"));
                siniestroProductoImportadoBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));

                siniestroProductoImportado.add(siniestroProductoImportadoBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }


        return siniestroProductoImportado;
    }

}




