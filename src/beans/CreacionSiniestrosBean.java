package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 26/07/2016.
 */
public class CreacionSiniestrosBean implements Serializable {

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
    private String tipoMoneda;
    private String fechaOcurrenciaSiniestro;
    private String sucursalSiniestros;
    private String horaOcurrencia;
    private String fechaAvisoCompania;
    private String horaNotificacion;
    private String fechaReclFormalizacion;
    private String fechaInterrupcionTerminos;
    private String reclamante;
    private String causaMuerte;
    private String causalesCoberturaMuerte;
    private String departamento;
    private String ciudad;
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

    public String getTipoMoneda() {
        return tipoMoneda;
    }
    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
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

    public String getFechaReclFormalizacion() {
        return fechaReclFormalizacion;
    }
    public void setFechaReclFormalizacion(String fechaReclFormalizacion) {
        this.fechaReclFormalizacion = fechaReclFormalizacion;}

    public String getFechaInterrupcionTerminos() {
        return fechaInterrupcionTerminos;
    }
    public void setFechaInterrupcionTerminos(String fechaInterrupcionTerminos) {
        this.fechaInterrupcionTerminos = fechaInterrupcionTerminos;}

    public String getReclamante() {
        return reclamante;
    }
    public void setReclamante(String reclamante) {
        this.reclamante = reclamante;
    }

    public String getCausaMuerte() {
        return causaMuerte;
    }
    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    public String getCausalesCoberturaMuerte() {
        return causalesCoberturaMuerte;
    }
    public void setCausalesCoberturaMuerte(String causalesCoberturaMuerte) {
        this.causalesCoberturaMuerte = causalesCoberturaMuerte;}

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

    public static ArrayList getCreacionSiniestros() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList siniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Tipo_Moneda, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Reclamante, Causa_Muerte, Causales_cobertura_Muerte, Departamento, Ciudad, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Fecha_Compromiso, Fecha_inicial, Fecha_Final, Razon, Estado, Tipo, Monto_Siniestro from CREACION_SINIESTROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CreacionSiniestrosBean creacionSiniestrosBean = new CreacionSiniestrosBean();

                creacionSiniestrosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                creacionSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                creacionSiniestrosBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                creacionSiniestrosBean.setContratante(rs.getString("CONTRATANTE"));
                creacionSiniestrosBean.setAsegurado(rs.getString("ASEGURADO"));
                creacionSiniestrosBean.setIdPoliza(rs.getString("ID_POLIZA"));
                creacionSiniestrosBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                creacionSiniestrosBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                creacionSiniestrosBean.setSucursalPoliza(rs.getString("SUCURSAL_POLIZA"));
                creacionSiniestrosBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                creacionSiniestrosBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                creacionSiniestrosBean.setMonedaPoliza(rs.getString("MONEDA_POLIZA"));
                creacionSiniestrosBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                creacionSiniestrosBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                creacionSiniestrosBean.setVigencia(rs.getString("VIGENCIA"));
                creacionSiniestrosBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                creacionSiniestrosBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                creacionSiniestrosBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                creacionSiniestrosBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                creacionSiniestrosBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                creacionSiniestrosBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                creacionSiniestrosBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                creacionSiniestrosBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                creacionSiniestrosBean.setTipoMoneda(rs.getString("TIPO_MONEDA"));
                creacionSiniestrosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                creacionSiniestrosBean.setSucursalSiniestros(rs.getString("SUCURSAL_SINIESTROS"));
                creacionSiniestrosBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                creacionSiniestrosBean.setFechaAvisoCompania(rs.getString("FECHA_AVISO_COMPANIA"));
                creacionSiniestrosBean.setHoraNotificacion(rs.getString("HORA_NOTIFICACION"));
                creacionSiniestrosBean.setFechaReclFormalizacion(rs.getString("FECHA_RECL_FORMALIZACION"));
                creacionSiniestrosBean.setFechaInterrupcionTerminos(rs.getString("FECHA_INTERRUPCION_TERMINOS"));
                creacionSiniestrosBean.setReclamante(rs.getString("RECLAMANTE"));
                creacionSiniestrosBean.setCausaMuerte(rs.getString("CAUSA_MUERTE"));
                creacionSiniestrosBean.setCausalesCoberturaMuerte(rs.getString("CAUSALES_COBERTURA_MUERTE"));
                creacionSiniestrosBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                creacionSiniestrosBean.setCiudad(rs.getString("CIUDAD"));
                creacionSiniestrosBean.setActividadSiniestro(rs.getString("ACTIVIDAD_SINIESTRO"));
                creacionSiniestrosBean.setFechaActividad(rs.getString("FECHA_ACTIVIDAD"));
                creacionSiniestrosBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                creacionSiniestrosBean.setCertificado(rs.getString("CERTIFICADO"));
                creacionSiniestrosBean.setObjetosAsegurados(rs.getString("OBJETOS_ASEGURADOS"));
                creacionSiniestrosBean.setCoberturaAfectada(rs.getString("COBERTURA_AFECTADA"));
                creacionSiniestrosBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                creacionSiniestrosBean.setMonedaSiniestro(rs.getString("MONEDA_SINIESTRO"));
                creacionSiniestrosBean.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                creacionSiniestrosBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                creacionSiniestrosBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                creacionSiniestrosBean.setRazon(rs.getString("RAZON"));
                creacionSiniestrosBean.setEstado(rs.getString("ESTADO"));
                creacionSiniestrosBean.setTipo(rs.getString("TIPO"));
                creacionSiniestrosBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));

                siniestro.add(creacionSiniestrosBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return siniestro;
    }

}
