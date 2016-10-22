package AcseleV13_8LBC.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 23/08/2016.
 */
public class CrearOpenItemsBean {

    private final static Logger log = Logger.getLogger(CrearOpenItemsBean.class);

    private String tercero;
    private String tipoTercero;
    private String rol1;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String primerNombre;
    private String segundoNombre;
    private String tercerNombre;
    private String apellidoCasada;
    private String tipoDocIdent;
    private String numDocIdent;
    private String extensionDocIdent;
    private String complementoDocIdent;
    private String sexo;
    private String estadoCivil;
    private String nombreConyuge;
    private String numDocConyuge;
    private String nivelEducacional;
    private String nit;
    private String facturarCiNit;
    private String direccCorrespondencia;
    private String nacionalidad;
    private String fechaNacimiento;
    private String profesion;
    private String ocupacionPrincipal;
    private String tipoTrabajador;
    private String lugarTrabajoActual;
    private String fechaIngresoTrabajo;
    private String cargo;
    private String ingresosMensuales;
    private String referencias;
    private String telefonoFijo;
    private String telefonoCelular;
    private String telefonoContacto;
    private String telefonoEmpleador;
    private String telefonoCobranza1;
    private String telefonoCobranza2;
    private String paginaWeb;
    private String email;
    private String login;
    private String predeterminedname;
    private String codIdentificador;
    private String idiomaOmision;
    private String idioma;
    private String identificadorIV;
    private String rol2;
    private String conceptoCuenta;
    private String fechaMov;
    private String fechaVencimiento;
    private String moneda;
    private String monto;
    private String numPoliza;
    private String tipoRef;



    public String getTercero() {return tercero; }
    public void setTercero(String tercero) {
        this.tercero = tercero;
    }
    public String getTipoTercero() {return tipoTercero; }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }
    public String getRol1() {return rol1; }
    public void setRol1(String rol1) {
        this.rol1 = rol1;
    }
    public String getApellidoPaterno() {return apellidoPaterno; }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {return apellidoMaterno; }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getPrimerNombre() {return primerNombre; }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public String getSegundoNombre() {return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public String getTercerNombre() {return tercerNombre; }
    public void setTercerNombre(String tercerNombre) {
        this.tercerNombre = tercerNombre;
    }
    public String getApellidoCasada() {return apellidoCasada; }
    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }
    public String getTipoDocIdent() {return tipoDocIdent; }
    public void setTipoDocIdent(String tipoDocIdent) {
        this.tipoDocIdent = tipoDocIdent;
    }
    public String getNumDocIdent() {return numDocIdent; }
    public void setNumDocIdent(String numDocIdent) {
        this.numDocIdent = numDocIdent;
    }
    public String getExtensionDocIdent() {return extensionDocIdent; }
    public void setExtensionDocIdent(String extensionDocIdent) {
        this.extensionDocIdent = extensionDocIdent;
    }
    public String getComplementoDocIdent() {return complementoDocIdent; }
    public void setComplementoDocIdent(String complementoDocIdent) {
        this.complementoDocIdent = complementoDocIdent;
    }
    public String getsexo() {return sexo; }
    public void setsexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadoCivil() {return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getNombreConyuge() {return nombreConyuge; }
    public void setNombreConyuge(String nombreConyuge) {
        this.nombreConyuge = nombreConyuge;
    }
    public String getNumDocConyuge() {return numDocConyuge; }
    public void setNumDocConyuge(String numDocConyuge) {
        this.numDocConyuge = numDocConyuge;
    }
    public String getNivelEducacional() {return nivelEducacional; }
    public void setNivelEducacional(String nivelEducacional) {
        this.nivelEducacional = nivelEducacional;
    }
    public String getNit() {return nit; }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getFacturarCiNit() {return facturarCiNit; }
    public void setFacturarCiNit(String facturarCiNit) {
        this.facturarCiNit = facturarCiNit;
    }
    public String getdireccCorrespondencia() {return direccCorrespondencia; }
    public void setdireccCorrespondencia(String direccCorrespondencia) {this.direccCorrespondencia = direccCorrespondencia;}
    public String getNacionalidad() {return nacionalidad; }
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
    public String getGradoInstruccion() {return gradoInstruccion; }
    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }
    public String getOcupacion() {return ocupacion; }
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    public String getRecibirInfXCorreo() {return recibirInfXCorreo; }
    public void setRecibirInfXCorreo(String recibirInfXCorreo) {
        this.recibirInfXCorreo = recibirInfXCorreo;
    }
    public String getRecibirInfXTlf() {return recibirInfXTlf; }
    public void setRecibirInfXTlf(String recibirInfXTlf) {
        this.recibirInfXTlf = recibirInfXTlf;
    }
    public String getFechaInclusion() {return fechaInclusion; }
    public void setFechaInclusion(String fechaInclusion) { this.fechaInclusion = fechaInclusion;    }
    public String getCodigoInterno() {return codigoInterno; }
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }
    public String getCodigoIdentificador() {return codigoIdentificador; }
    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }
    public String getTarjetaIdentidad() {return tarjetaIdentidad; }
    public void setTarjetaIdentidad(String tarjetaIdentidad) {
        this.tarjetaIdentidad = tarjetaIdentidad;
    }
    public String getRegistroCivil() {return registroCivil; }
    public void setRegistroCivil(String registroCivil) {
        this.registroCivil = registroCivil;
    }
    public String getTarjetaExtranjería() {return tarjetaExtranjería; }
    public void setTarjetaExtranjería(String tarjetaExtranjería) {
        this.tarjetaExtranjería = tarjetaExtranjería;
    }
    public String getCédulaExtranjería() {return cédulaExtranjería; }
    public void setCédulaExtranjería(String cédulaExtranjería) {
        this.cédulaExtranjería = cédulaExtranjería;
    }
    public String getDocumentoExtranjero() {return documentoExtranjero; }
    public void setDocumentoExtranjero(String documentoExtranjero) {
        this.documentoExtranjero = documentoExtranjero;
    }

    public String getRolOpenItem() {return rolOpenItem; }
    public void setRolOpenItem(String rolOpenItem) {
        this.rolOpenItem = rolOpenItem;
    }
    public String getConceptoCta() {return conceptoCta; }
    public void setConceptoCta(String conceptoCta) {
        this.conceptoCta = conceptoCta;
    }
    public String getFechaMov() {return fechaMov; }
    public void setFechaMov(String fechaMov) {
        this.fechaMov = fechaMov;
    }
    public String getFechaVen() {return fechaVen; }
    public void setFechaVen(String fechaVen) {
        this.fechaVen = fechaVen;
    }
    public String getMoneda() {return moneda; }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public String getMonto() {return monto; }
    public void setMonto(String monto) {
        this.monto = monto;
    }
    public String getNumPolizaItem() {return numPolizaItem; }
    public void setNumPolizaItem(String numPolizaItem) {
        this.numPolizaItem = numPolizaItem;
    }
    public String getTipoRef() {return tipoRef; }
    public void setTipoRef(String tipoRef) {
        this.tipoRef = tipoRef;
    }

    public static ArrayList getCrearOpenItems() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList item = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA,ROL1,TIPO_TERCERO,ROL2,TIPO_DOCUMENTO,PASAPORTE,NUM_DOCUMENTO,INDICATIVO1,PRIMER_NOMBRE,TELEFONO_FIJO,SEGUNDO_NOMBRE,TLF_FIJO_COMPLETO,PRIMER_APELLIDO,INDICATIVO2,SEGUNDO_APELLIDO,TLF_OFICINA,NOMBRE_APELLIDO,EXTENSION,ESTADO_CIVIL,TLF_OFICINA_COMPLETO,EMAIL_1,TLF_CELULAR,EMAIL_2,AUTORIZA_USO_DATOS_PERSONALES,GRADO_INSTRUCCION,OCUPACION,RECIBIR_INF_X_TLF,RECIBIR_INF_X_CORREO,FECHA_INCLUSION,CODIGO_IDENTIFICADOR,CODIGO_INTERNO,TARJETA_IDENTIDAD,REGISTRO_CIVIL,TARJETA_EXTRANJERÍA,CÉDULA_EXTRANJERÍA,DOCUMENTO_EXTRANJERO,ROL_OPEN_ITEM,CONCEPTO_CTA,FECHA_MOV,FECHA_VEN,MONEDA,MONTO,NUM_POLIZA_ITEM,TIPO_REF FROM CREAR_OPEN_ITEMS ORDER BY PRUEBA ASC");
        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CrearOpenItemsBean crearOpenItemsBean = new CrearOpenItemsBean();
                crearOpenItemsBean.setRol1(rs.getString("ROL1"));
                crearOpenItemsBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                crearOpenItemsBean.setRol2(rs.getString("ROL2"));
                crearOpenItemsBean.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                crearOpenItemsBean.setPasaporte(rs.getString("PASAPORTE"));
                crearOpenItemsBean.setNumDocumento(rs.getString("NUM_DOCUMENTO"));
                crearOpenItemsBean.setIndicativo1(rs.getString("INDICATIVO1"));
                crearOpenItemsBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                crearOpenItemsBean.setTlfOficina(rs.getString("TELEFONO_FIJO"));
                crearOpenItemsBean.setSegundoNombre(rs.getString("SEGUNDO_NOMBRE"));
                crearOpenItemsBean.setTlfFijoCompleto(rs.getString("TLF_FIJO_COMPLETO"));
                crearOpenItemsBean.setPrimerApellido(rs.getString("PRIMER_APELLIDO"));
                crearOpenItemsBean.setIndicativo2(rs.getString("INDICATIVO2"));
                crearOpenItemsBean.setSegundoApellido(rs.getString("SEGUNDO_APELLIDO"));
                crearOpenItemsBean.setTlfOficina(rs.getString("TLF_OFICINA"));
                crearOpenItemsBean.setNombreApellido(rs.getString("NOMBRE_APELLIDO"));
                crearOpenItemsBean.setExtension(rs.getString("EXTENSION"));
                crearOpenItemsBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                crearOpenItemsBean.setTlfOficinaComp(rs.getString("TLF_OFICINA_COMPLETO"));
                crearOpenItemsBean.setEmail1(rs.getString("EMAIL_1"));
                crearOpenItemsBean.setTlfCelular(rs.getString("TLF_CELULAR"));
                crearOpenItemsBean.setEmail2(rs.getString("EMAIL_2"));
                crearOpenItemsBean.setAutorizaUsoDatosPersonales(rs.getString("AUTORIZA_USO_DATOS_PERSONALES"));
                crearOpenItemsBean.setGradoInstruccion(rs.getString("GRADO_INSTRUCCION"));
                crearOpenItemsBean.setOcupacion(rs.getString("OCUPACION"));
                crearOpenItemsBean.setRecibirInfXTlf(rs.getString("RECIBIR_INF_X_TLF"));
                crearOpenItemsBean.setRecibirInfXCorreo(rs.getString("RECIBIR_INF_X_CORREO"));
                crearOpenItemsBean.setFechaInclusion(rs.getString("FECHA_INCLUSION"));
                crearOpenItemsBean.setCodigoInterno(rs.getString("CODIGO_INTERNO"));
                crearOpenItemsBean.setCodigoIdentificador(rs.getString("CODIGO_IDENTIFICADOR"));
                crearOpenItemsBean.setTarjetaIdentidad(rs.getString("TARJETA_IDENTIDAD"));
                crearOpenItemsBean.setRegistroCivil(rs.getString("REGISTRO_CIVIL"));
                crearOpenItemsBean.setTarjetaExtranjería(rs.getString("TARJETA_EXTRANJERÍA"));
                crearOpenItemsBean.setDocumentoExtranjero(rs.getString("DOCUMENTO_EXTRANJERO"));
                crearOpenItemsBean.setRolOpenItem(rs.getString("ROL_OPEN_ITEM"));
                crearOpenItemsBean.setConceptoCta(rs.getString("CONCEPTO_CTA"));
                crearOpenItemsBean.setFechaMov(rs.getString("FECHA_MOV"));
                crearOpenItemsBean.setFechaVen(rs.getString("FECHA_VEN"));
                crearOpenItemsBean.setMoneda(rs.getString("MONEDA"));
                crearOpenItemsBean.setMonto(rs.getString("MONTO"));
                crearOpenItemsBean.setNumPolizaItem(rs.getString("NUM_POLIZA_ITEM"));
                crearOpenItemsBean.setTipoRef(rs.getString("TIPO_REF"));
                item.add(crearOpenItemsBean);
            }

        }catch(SQLException e){

            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return item;
    }

}


