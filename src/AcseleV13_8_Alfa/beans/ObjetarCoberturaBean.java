package AcseleV13_8_Alfa.beans;

import AcseleV13_8.beans.CreacionSiniestrosBean;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 * Created by aazuaje on 03/08/2016.
 */
public class ObjetarCoberturaBean implements Serializable {

    private final static Logger log = Logger.getLogger(CreacionSiniestrosBean.class);
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
    private String motivosObjecion;
    private String fechaObjecion;
    private String comentariosSiniestro;

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
        return fechaInterrupcionTerminos;
    }
    public void setFechaInterrupcionTerminos(String fechaInterrupcionTerminos) {
        this.fechaInterrupcionTerminos = fechaInterrupcionTerminos;}

    public String getDocumentoIdentReclamante() {
        return documentoIdentReclamante;
    }
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

    public String getMotivosObjecion() {
        return motivosObjecion;
    }
    public void setMotivosObjecion(String motivosObjecion) {
        this.motivosObjecion = motivosObjecion;
    }

    public String getFechaObjecion() {
        return fechaObjecion;
    }
    public void setFechaObjecion(String fechaObjecion) {
        this.fechaObjecion = fechaObjecion;
    }

    public String getComentariosSiniestro() {
        return comentariosSiniestro;
    }
    public void setComentariosSiniestro(String comentariosSiniestro) {
        this.comentariosSiniestro = comentariosSiniestro;}


    public static ArrayList getObjetarCobertura() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList cobertura = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por, Producto, Estados_Ciclo_Vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Fecha_Ocurrencia_Siniestro,Sucursal_Siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro,Motivos_Objecion, Fecha_Objecion, Comentarios_Siniestro from CREAC_SINI_OBJET_COB ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ObjetarCoberturaBean objetarCoberturaBean = new ObjetarCoberturaBean();

                objetarCoberturaBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                objetarCoberturaBean.setProducto(rs.getString("PRODUCTO"));
                objetarCoberturaBean.setEstadosCicloVida(rs.getString("ESTADOS_CICLO_VIDA"));
                objetarCoberturaBean.setContratante(rs.getString("CONTRATANTE"));
                objetarCoberturaBean.setAsegurado(rs.getString("ASEGURADO"));
                objetarCoberturaBean.setIdPoliza(rs.getString("ID_POLIZA"));
                objetarCoberturaBean.setFechaDesde(rs.getString("FECHA_DESDE"));
                objetarCoberturaBean.setFechaHasta(rs.getString("FECHA_HASTA"));
                objetarCoberturaBean.setSucursalPoliza(rs.getString("SUCURSAL_POLIZA"));
                objetarCoberturaBean.setNumeroPoliza(rs.getString("NUMERO_POLIZA"));
                objetarCoberturaBean.setFechaEmision(rs.getString("FECHA_EMISION"));
                objetarCoberturaBean.setMonedaPoliza(rs.getString("MONEDA_POLIZA"));
                objetarCoberturaBean.setTipoMonedaPoliza(rs.getString("TIPO_MONEDA_POLIZA"));
                objetarCoberturaBean.setTipoProduccion(rs.getString("TIPO_PRODUCCION"));
                objetarCoberturaBean.setTipoVigencia(rs.getString("TIPO_VIGENCIA"));
                objetarCoberturaBean.setVigencia(rs.getString("VIGENCIA"));
                objetarCoberturaBean.setCanalVenta(rs.getString("CANAL_VENTA"));
                objetarCoberturaBean.setFrecuenciaPago(rs.getString("FRECUENCIA_PAGO"));
                objetarCoberturaBean.setFechaEventoAnterior(rs.getString("FECHA_EVENTO_ANTERIOR"));
                objetarCoberturaBean.setFechaProximaGeneracionPrima(rs.getString("FECHA_PROXIMA_GENERACION_PRIMA"));
                objetarCoberturaBean.setFechaProximaFacturacion(rs.getString("FECHA_PROXIMA_FACTURACION"));
                objetarCoberturaBean.setTipoPoliza(rs.getString("TIPO_POLIZA"));
                objetarCoberturaBean.setNumeroCotizacion(rs.getString("NUMERO_COTIZACION"));
                objetarCoberturaBean.setNumeroPropuesta(rs.getString("NUMERO_PROPUESTA"));
                objetarCoberturaBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                objetarCoberturaBean.setSucursalSiniestros(rs.getString("SUCURSAL_SINIESTROS"));
                objetarCoberturaBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                objetarCoberturaBean.setFechaAvisoCompania(rs.getString("FECHA_AVISO_COMPANIA"));
                objetarCoberturaBean.setHoraNotificacion(rs.getString("HORA_NOTIFICACION"));
                objetarCoberturaBean.setFechaOperConstSiniestro(rs.getString("FECHA_OPER_CONST_SINIESTRO"));
                objetarCoberturaBean.setFechaReclFormalizacion(rs.getString("FECHA_RECL_FORMALIZACION"));
                objetarCoberturaBean.setFechaInterrupcionTerminos(rs.getString("FECHA_INTERRUPCION_TERMINOS"));
                objetarCoberturaBean.setDocumentoIdentReclamante(rs.getString("DOCUMENTO_IDENT_RECLAMANTE"));
                objetarCoberturaBean.setReclamante(rs.getString("RECLAMANTE"));
                objetarCoberturaBean.setCausaGeneralMuerte(rs.getString("CAUSA_GENERAL_MUERTE"));
                objetarCoberturaBean.setCausalesEspecifCobertMuerte(rs.getString("CAUSALES_ESPECIFIC_COBERT_MUERTE"));
                objetarCoberturaBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                objetarCoberturaBean.setCiudad(rs.getString("CIUDAD"));
                objetarCoberturaBean.setGeneroAsegurado(rs.getString("GENERO_ASEGURADO"));
                objetarCoberturaBean.setProfesionAsegurado(rs.getString("PROFESION_ASEGURADO"));
                objetarCoberturaBean.setActividadSiniestro(rs.getString("ACTIVIDAD_SINIESTRO"));
                objetarCoberturaBean.setFechaActividad(rs.getString("FECHA_ACTIVIDAD"));
                objetarCoberturaBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                objetarCoberturaBean.setCertificado(rs.getString("CERTIFICADO"));
                objetarCoberturaBean.setObjetosAsegurados(rs.getString("OBJETOS_ASEGURADOS"));
                objetarCoberturaBean.setCoberturaAfectada(rs.getString("COBERTURA_AFECTADA"));
                objetarCoberturaBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                objetarCoberturaBean.setMonedaSiniestro(rs.getString("MONEDA_SINIESTRO"));
                objetarCoberturaBean.setMotivosObjecion(rs.getString("MOTIVOS_OBEJECION"));
                objetarCoberturaBean.setFechaObjecion(rs.getString("FECHA_OBJECION"));
                objetarCoberturaBean.setComentariosSiniestro(rs.getString("COMENTARIOS_SINIESTRO"));

                cobertura.add(objetarCoberturaBean);

        }

     }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return cobertura;
    }

}