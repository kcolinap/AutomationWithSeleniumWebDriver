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
 * Created by aazuaje on 15/08/2016.
 */
public class EditarSiniestrosBean implements Serializable {

    private final static Logger log = Logger.getLogger(EditarSiniestrosBean.class);
    private String ordenarPor;
    private String numSiniestro;
    private String numPoliza;
    private String fechaOcurrenciaSiniestro;
    private String producto;
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

    public String getNumSiniestro() {
        return numSiniestro;
    }
    public void setNumSiniestro(String numSiniestro) {this.numSiniestro = numSiniestro;}

    public String getNumPoliza() {
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getFechaOcurrenciaSiniestro() {
        return fechaOcurrenciaSiniestro;
    }
    public void setFechaOcurrenciaSiniestro(String fechaOcurrenciaSiniestro) {
        this.fechaOcurrenciaSiniestro = fechaOcurrenciaSiniestro;}

    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
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

    public static ArrayList getEditarSiniestros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList edicion = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro, Fecha_Compromiso, Fecha_Inicial, Fecha_Final, Razon,  Estado, Tipo, Monto_Siniestro from EDITAR_SINIESTRO ORDER BY PRUEBA ASC");

        try{

            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EditarSiniestrosBean editarSiniestrosBean = new EditarSiniestrosBean();

                editarSiniestrosBean.setOrdenarPor(rs.getString("ORDENAR_POR"));
                editarSiniestrosBean.setNumSiniestro(rs.getString("NUM_SINIESTRO"));
                editarSiniestrosBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                editarSiniestrosBean.setFechaOcurrenciaSiniestro(rs.getString("FECHA_OCURRENCIA_SINIESTRO"));
                editarSiniestrosBean.setProducto(rs.getString("PRODUCTO"));
                editarSiniestrosBean.setHoraOcurrencia(rs.getString("HORA_OCURRENCIA"));
                editarSiniestrosBean.setFechaAvisoCompania(rs.getString("FECHA_AVISO_COMPANIA"));
                editarSiniestrosBean.setHoraNotificacion(rs.getString("HORA_NOTIFICACION"));
                editarSiniestrosBean.setFechaOperConstSiniestro(rs.getString("FECHA_OPER_CONST_SINIESTRO"));
                editarSiniestrosBean.setFechaReclFormalizacion(rs.getString("FECHA_RECL_FORMALIZACION"));
                editarSiniestrosBean.setFechaInterrupcionTerminos(rs.getString("FECHA_INTERRUPCION_TERMINOS"));
                editarSiniestrosBean.setDocumentoIdentReclamante(rs.getString("DOCUMENTO_IDENT_RECLAMANTE"));
                editarSiniestrosBean.setReclamante(rs.getString("RECLAMANTE"));
                editarSiniestrosBean.setCausaGeneralMuerte(rs.getString("CAUSA_GENERAL_MUERTE"));
                editarSiniestrosBean.setCausalesEspecifCobertMuerte(rs.getString("CAUSALES_ESPECIF_COBERT_MUERTE"));
                editarSiniestrosBean.setDepartamento(rs.getString("DEPARTAMENTO"));
                editarSiniestrosBean.setCiudad(rs.getString("CIUDAD"));
                editarSiniestrosBean.setGeneroAsegurado(rs.getString("GENERO_ASEGURADO"));
                editarSiniestrosBean.setProfesionAsegurado(rs.getString("PROFESION_ASEGURADO"));
                editarSiniestrosBean.setActividadSiniestro(rs.getString("ACTIVIDAD_SINIESTRO"));
                editarSiniestrosBean.setFechaActividad(rs.getString("FECHA_ACTIVIDAD"));
                editarSiniestrosBean.setObservacionesSiniestro(rs.getString("OBSERVACIONES_SINIESTRO"));
                editarSiniestrosBean.setCertificado(rs.getString("CERTIFICADO"));
                editarSiniestrosBean.setObjetosAsegurados(rs.getString("OBJETOS_ASEGURADOS"));
                editarSiniestrosBean.setCoberturaAfectada(rs.getString("COBERTURA_AFECTADA"));
                editarSiniestrosBean.setPagoMaximo(rs.getString("PAGO_MAXIMO"));
                editarSiniestrosBean.setMonedaSiniestro(rs.getString("MONEDA_SINIESTRO"));
                editarSiniestrosBean.setFechaCompromiso(rs.getString("FECHA_COMPROMISO"));
                editarSiniestrosBean.setFechaInicial(rs.getString("FECHA_INICIAL"));
                editarSiniestrosBean.setFechaFinal(rs.getString("FECHA_FINAL"));
                editarSiniestrosBean.setRazon(rs.getString("RAZON"));
                editarSiniestrosBean.setEstado(rs.getString("ESTADO"));
                editarSiniestrosBean.setTipo(rs.getString("TIPO"));
                editarSiniestrosBean.setMontoSiniestro(rs.getString("MONTO_SINIESTRO"));

                edicion.add(editarSiniestrosBean);

            }


        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }

        return edicion;

    }

}
