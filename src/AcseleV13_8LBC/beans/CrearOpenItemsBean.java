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
    private String chequeoUnicidad;
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
    public String getSexo() {return sexo; }
    public void setSexo(String sexo) {
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
    public String getDireccCorrespondencia() {return direccCorrespondencia; }
    public void setDireccCorrespondencia(String direccCorrespondencia) {this.direccCorrespondencia = direccCorrespondencia;}
    public String getNacionalidad() {return nacionalidad; }
    public void setNacionalidad(String nacionalidad) {this.nacionalidad = nacionalidad;}
    public String getFechaNacimiento() {return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getProfesion() {return profesion; }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public String getoOcupacionPrincipal() {return ocupacionPrincipal; }
    public void setOcupacionPrincipal(String ocupacionPrincipal) {
        this.ocupacionPrincipal = ocupacionPrincipal;
    }
    public String getTipoTrabajador() {return tipoTrabajador; }
    public void setTipoTrabajador(String tipoTrabajador) {
        this.tipoTrabajador = tipoTrabajador;
    }
    public String getLugarTrabajoActual() {return lugarTrabajoActual; }
    public void setLugarTrabajoActual(String lugarTrabajoActual) { this.lugarTrabajoActual = lugarTrabajoActual;    }
    public String getFechaIngresoTrabajo() {return fechaIngresoTrabajo; }
    public void setFechaIngresoTrabajo(String fechaIngresoTrabajo) {
        this.fechaIngresoTrabajo = fechaIngresoTrabajo;
    }
    public String getCargo() {return cargo; }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getIngresosMensuales() {return ingresosMensuales; }
    public void setIngresosMensuales(String ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }
    public String getReferencias() {return referencias; }
    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    public String getTelefonoFijo() {return telefonoFijo; }
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    public String getTelefonoCelular() {return telefonoCelular; }
    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }
    public String getTelefonoContacto() {return telefonoContacto; }
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    public String getTelefonoEmpleador() {return telefonoEmpleador; }
    public void setTelefonoEmpleador(String telefonoEmpleador) {
        this.telefonoEmpleador = telefonoEmpleador;
    }
    public String getTelefonoCobranza1() {return telefonoCobranza1; }
    public void setTelefonoCobranza1(String telefonoCobranza1) {
        this.telefonoCobranza1 = telefonoCobranza1;
    }
    public String getTelefonoCobranza2() {return telefonoCobranza2; }
    public void setTelefonoCobranza2(String telefonoCobranza2) {
        this.telefonoCobranza2 = telefonoCobranza2;
    }
    public String getPaginaWeb() {return paginaWeb; }
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    public String getEmail() {return email; }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLogin() {return login; }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPredeterminedname() {return predeterminedname; }
    public void setPredeterminedname(String predeterminedname) {
        this.predeterminedname = predeterminedname;
    }
    public String getMonto() {return monto; }
    public void setMonto(String monto) {
        this.monto = monto;
    }
    public String getCodIdentificador() {return codIdentificador; }
    public void setCodIdentificador(String codIdentificador) {
        this.codIdentificador = codIdentificador;
    }
    public String getIdiomaOmision() {return idiomaOmision; }
    public void setIdiomaOmision(String idiomaOmision) {
        this.idiomaOmision = idiomaOmision;
    }
    public String getIdioma() {return idioma; }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getIdentificadorIV() {return identificadorIV; }
    public void setIdentificadorIV(String identificadorIV) {
        this.identificadorIV = identificadorIV;
    }
    public String getChequeoUnicidad() {return chequeoUnicidad; }
    public void setChequeoUnicidad(String chequeoUnicidad) {
        this.chequeoUnicidad = chequeoUnicidad;
    }
    public String getRol2() {return rol2; }
    public void setRol2(String rol2) {
        this.rol2 = rol2;
    }
    public String getConceptoCuenta() {return conceptoCuenta; }
    public void setConceptoCuenta(String conceptoCuenta) {
        this.conceptoCuenta = conceptoCuenta;
    }
    public String getFechaMov() {return fechaMov; }
    public void setFechaMov(String fechaMov) {
        this.fechaMov = fechaMov;
    }
    public String getFechaVencimiento() {return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
    public String getMoneda() {return moneda; }
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    public String getNumPoliza() {return numPoliza; }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
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
        queryLoad.append("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,APELLIDO_CASADA,TIPO_DOC_IDENT,NUM_DOC_IDENT,EXTENSION_DOC_IDENT,COMPLEMENTO_DOC_IDENT,SEXO,ESTADO_CIVIL,NOMBRE_CONYUGE,NUM_DOC_CONYUGE,NIVEL_EDUCACIONAL,NIT,FACTURAR_CI_NIT,DIRECC_CORRESPONDENCIA,NACIONALIDAD,FECHA_NACIMIENTO,PROFESION,OCUPACION_PRINCIPAL,TIPO_TRABAJADOR,LUGAR_TRABAJO_ACTUAL,FECHA_INGRESO_TRABAJO,CARGO,INGRESOS_MENSUALES,REFERENCIAS,TELEFONO_FIJO,TELEFONO_CELULAR,TELEFONO_CONTACTO,TELEFONO_EMPLEADOR,TELEFONO_COBRANZA_1,TELEFONO_COBRANZA_2,PAGINA_WEB,EMAIL,LOGIN,PREDETERMINEDNAME,COD_IDENTIFICADOR,CHEQUEO_UNICIDAD,IDIOMA_X_OMISION,IDIOMA,IDENTIFICADOR_IV,ROL2,CONCEPTO_CUENTA,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_LBC ORDER BY PRUEBA ASC");
        try{
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CrearOpenItemsBean crearOpenItemsBean = new CrearOpenItemsBean();
                crearOpenItemsBean.setTercero(rs.getString("TERCERO"));
                crearOpenItemsBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                crearOpenItemsBean.setRol1(rs.getString("ROL1"));
                crearOpenItemsBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                crearOpenItemsBean.setApellidoMaterno(rs.getString("APELLIDO_MATERNO"));
                crearOpenItemsBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                crearOpenItemsBean.setSegundoNombre(rs.getString("SEGUNDO_NOMBRE"));
                crearOpenItemsBean.setTercerNombre(rs.getString("TERCER_NOMBRE"));
                crearOpenItemsBean.setApellidoCasada(rs.getString("APELLIDO_CASADA"));
                crearOpenItemsBean.setTipoDocIdent(rs.getString("TIPO_DOC_IDENT"));
                crearOpenItemsBean.setNumDocIdent(rs.getString("NUM_DOC_IDENT"));
                crearOpenItemsBean.setExtensionDocIdent(rs.getString("EXTENSION_DOC_IDENT"));
                crearOpenItemsBean.setComplementoDocIdent(rs.getString("COMPLEMENTO_DOC_IDENT"));
                crearOpenItemsBean.setSexo(rs.getString("SEXO"));
                crearOpenItemsBean.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                crearOpenItemsBean.setNombreConyuge(rs.getString("NOMBRE_CONYUGE"));
                crearOpenItemsBean.setNumDocConyuge(rs.getString("NUM_DOC_CONYUGE"));
                crearOpenItemsBean.setNivelEducacional(rs.getString("NIVEL_EDUCACIONAL"));
                crearOpenItemsBean.setNit(rs.getString("NIT"));
                crearOpenItemsBean.setFacturarCiNit(rs.getString("FACTURAR_CI_NIT"));
                crearOpenItemsBean.setDireccCorrespondencia(rs.getString("DIRECC_CORRESPONDENCIA"));
                crearOpenItemsBean.setNacionalidad(rs.getString("NACIONALIDAD"));
                crearOpenItemsBean.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
                crearOpenItemsBean.setProfesion(rs.getString("PROFESION"));
                crearOpenItemsBean.setOcupacionPrincipal(rs.getString("OCUPACION_PRINCIPAL"));
                crearOpenItemsBean.setTipoTrabajador(rs.getString("TIPO_TRABAJADOR"));
                crearOpenItemsBean.setLugarTrabajoActual(rs.getString("LUGAR_TRABAJO_ACTUAL"));
                crearOpenItemsBean.setFechaIngresoTrabajo(rs.getString("FECHA_INGRESO_TRABAJO"));
                crearOpenItemsBean.setCargo(rs.getString("CARGO"));
                crearOpenItemsBean.setIngresosMensuales(rs.getString("INGRESOS_MENSUALES"));
                crearOpenItemsBean.setReferencias(rs.getString("REFERENCIAS"));
                crearOpenItemsBean.setTelefonoFijo(rs.getString("TELEFONO_FIJO"));
                crearOpenItemsBean.setTelefonoCelular(rs.getString("TELEFONO_CELULAR"));
                crearOpenItemsBean.setTelefonoContacto(rs.getString("TELEFONO_CONTACTO"));
                crearOpenItemsBean.setTelefonoEmpleador(rs.getString("TELEFONO_EMPLEADOR"));
                crearOpenItemsBean.setTelefonoCobranza1(rs.getString("TELEFONO_COBRANZA_1"));
                crearOpenItemsBean.setTelefonoCobranza2(rs.getString("TELEFONO_COBRANZA_2"));
                crearOpenItemsBean.setPaginaWeb(rs.getString("PAGINA_WEB"));
                crearOpenItemsBean.setEmail(rs.getString("EMAIL"));
                crearOpenItemsBean.setLogin(rs.getString("LOGIN"));
                crearOpenItemsBean.setPredeterminedname(rs.getString("PREDETERMINEDNAME"));
                crearOpenItemsBean.setCodIdentificador(rs.getString("COD_IDENTIFICADOR"));
                crearOpenItemsBean.setChequeoUnicidad(rs.getString("CHEQUEO_UNICIDAD"));
                crearOpenItemsBean.setIdiomaOmision(rs.getString("IDIOMA_X_OMISION"));
                crearOpenItemsBean.setIdioma(rs.getString("IDIOMA"));
                crearOpenItemsBean.setIdentificadorIV(rs.getString("IDENTIFICADOR_IV"));
                crearOpenItemsBean.setRol2(rs.getString("ROL2"));
                crearOpenItemsBean.setConceptoCuenta(rs.getString("CONCEPTO_CUENTA"));
                crearOpenItemsBean.setFechaMov(rs.getString("FECHA_MOV"));
                crearOpenItemsBean.setFechaVencimiento(rs.getString("FECHA_VENCIMIENTO"));
                crearOpenItemsBean.setMoneda(rs.getString("MONEDA"));
                crearOpenItemsBean.setMonto(rs.getString("MONTO"));
                crearOpenItemsBean.setNumPoliza(rs.getString("NUM_POLIZA"));
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


