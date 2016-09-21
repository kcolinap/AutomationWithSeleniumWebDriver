package AcseleV13_8_Alfa.beans;

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

    private String rol1;
    private String tipoTercero;
    private String rol2;
    private String tipoDocumento;
    private String pasaporte;
    private String numDocumento;
    private String indicativo1;
    private String primerNombre;
    private String telefonoFijo;
    private String segundoNombre;
    private String tlfFijoCompleto;
    private String primerApellido;
    private String indicativo2;
    private String segundoApellido;
    private String tlfOficina;
    private String nombreApellido;
    private String extension;
    private String estadoCivil;
    private String tlfOficinaComp;
    private String email1;
    private String tlfCelular;
    private String email2;
    private String autorizaUsoDatosPersonales;
    private String gradoInstruccion;
    private String ocupacion;
    private String recibirInfXCorreo;
    private String recibirInfXTlf;
    private String fechaInclusion;
    private String codigoInterno;
    private String codigoIdentificador;
    private String tarjetaIdentidad;
    private String registroCivil;
    private String tarjetaExtranjería;
    private String cédulaExtranjería;
    private String documentoExtranjero;
    private String rolOpenItem;
    private String conceptoCta;
    private String fechaMov;
    private String fechaVen;
    private String moneda;
    private String monto;
    private String numPolizaItem;
    private String tipoRef;


    public String getRol1() {return rol1; }
    public void setRol1(String rol1) {
        this.rol1 = rol1;
    }
    public String getTipoTercero() {return tipoTercero; }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }
    public String getRol2() {return rol2; }
    public void setRol2(String rol2) {
        this.rol2 = rol2;
    }
    public String getTipoDocumento() {return tipoDocumento; }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getPasaporte() {return pasaporte; }
    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }
    public String getNumDocumento() {return numDocumento; }
    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getIndicativo1() {return indicativo1; }
    public void setIndicativo1(String indicativo1) {
        this.indicativo1 = indicativo1;
    }
    public String getPrimerNombre() {return primerNombre; }
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }
    public String getTelefonoFijo() {return telefonoFijo; }
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    public String getSegundoNombre() {return segundoNombre; }
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }
    public String getTlfFijoCompleto() {return tlfFijoCompleto; }
    public void setTlfFijoCompleto(String tlfFijoCompleto) {
        this.tlfFijoCompleto = tlfFijoCompleto;
    }
    public String getPrimerApellido() {return primerApellido; }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getIndicativo2() {return indicativo2; }
    public void setIndicativo2(String indicativo2) {
        this.indicativo2 = indicativo2;
    }
    public String getSegundoApellido() {return segundoApellido; }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public String getTlfOficina() {return tlfOficina; }
    public void setTlfOficina(String tlfOficina) {
        this.tlfOficina = tlfOficina;
    }
    public String getNombreApellido() {return nombreApellido; }
    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }
    public String getExtension() {return extension; }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getEstadoCivil() {return estadoCivil; }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getTlfOficinaComp() {return tlfOficinaComp; }
    public void setTlfOficinaComp(String tlfOficinaComp) {
        this.tlfOficinaComp = tlfOficinaComp;
    }
    public String getEmail1() {return email1; }
    public void setEmail1(String email1) {
        this.email1 = email1;
    }
    public String getTlfCelular() {return tlfCelular; }
    public void setTlfCelular(String tlfCelular) {
        this.tlfCelular = tlfCelular;
    }
    public String getEmail2() {return email2; }
    public void setEmail2(String email2) {
        this.email2 = email2;
    }
    public String getAutorizaUsoDatosPersonales() {return autorizaUsoDatosPersonales; }
    public void setAutorizaUsoDatosPersonales(String autorizaUsoDatosPersonales) {
        this.autorizaUsoDatosPersonales = autorizaUsoDatosPersonales;
    }
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


