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
 * Created by mchurion on 16/12/2016.
 */
public class INTER_TercerosDireccionesBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_TercerosDireccionesBean.class);

    private String tipoTerceros;
    private String numDocIdentidad;
    private String refDireccion;
    private String codPais;
    private String descripcionDireccion;
    private String codDepartamento;
    private String numFax;
    private String apellidoPaterno;
    private String primerNombre;
    private String codDistrito;
    private String tlfFijo;
    private String tipoDireccion;
    private String tlfCelular;
    private String email;
    private String userLogin;
    private String codProvincia;

    public String getTipoTerceros(){
        return tipoTerceros;
    }
    public void setTipoTerceros(String tipoTerceros){
        this.tipoTerceros = tipoTerceros;
    }

    public String getNumDocIdentidad() {
        return numDocIdentidad;
    }
    public void setNumDocIdentidad(String numDocIdentidad) {
        this.numDocIdentidad = numDocIdentidad;
    }

    public String getRefDireccion(){
        return refDireccion;
    }
    public void setRefDireccion(String refDireccion){
        this.refDireccion = refDireccion;
    }

    public String getCodPais(){
        return codPais;
    }
    public void setCodPais(String codPais){
        this.codPais= codPais;
    }

    public String getDescripcionDireccion(){
        return  descripcionDireccion;
    }
    public void setDescripcionDireccion(String descripcionDireccion){
        this.descripcionDireccion = descripcionDireccion;
    }

    public String getCodDepartamento(){
        return codDepartamento;
    }
    public void setCodDepartamento(String codDepartamento){
        this.codDepartamento = codDepartamento;
    }

    public String getCodProvincia(){
        return codProvincia;
    }
    public void setCodProvincia(String codProvincia){
        this.codProvincia = codProvincia;
    }

    public String getPrimerNombre(){
        return primerNombre;
    }
    public void setPrimerNombre(String primerNombre){
        this.primerNombre = primerNombre;
    }

    public String getApellidoPaterno(){
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno){
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNumFax(){
        return numFax;
    }
    public void setNumFax(String numFax){
        this.numFax = numFax;
    }

    public String getCodDistrito(){
        return codDistrito;
    }
    public void setCodDistrito(String codDistrito){
        this.codDistrito = codDistrito;
    }

    public String getTlfFijo(){
        return tlfFijo;
    }
    public void setTlfFijo(String tlfFijo){
        this.tlfFijo = tlfFijo;
    }

    public String getTipoDireccion(){
        return tipoDireccion;
    }
    public void setTipoDireccion(String tipoDireccion){
        this.tipoDireccion = tipoDireccion;
    }

    public String getTlfCelular(){
        return tlfCelular;
    }
    public void setTlfCelular(String tlfCelular){
        this.tlfCelular = tlfCelular;
    }

    public String getUserLogin(){
        return userLogin;
    }
    public void setUserLogin(String userLogin){
        this.userLogin= userLogin;
    }

    public String getEmail(){
        return  email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public static ArrayList getTercerodDirecciones() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList direcciones = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_TercerosDireccionesBean interTercerosDireccionesBean = new INTER_TercerosDireccionesBean();
                interTercerosDireccionesBean.setTipoTerceros(rs.getString("TIPO_TERCEROS"));
                interTercerosDireccionesBean.setNumDocIdentidad(rs.getString("NUM_DOC_IDENTIDAD"));
                interTercerosDireccionesBean.setApellidoPaterno(rs.getString("APELLIDO_PATERNO"));
                interTercerosDireccionesBean.setPrimerNombre(rs.getString("PRIMER_NOMBRE"));
                interTercerosDireccionesBean.setRefDireccion(rs.getString("REF_DIRECCION"));
                interTercerosDireccionesBean.setCodPais(rs.getString("COD_PAIS"));
                interTercerosDireccionesBean.setDescripcionDireccion(rs.getString("DESCRIPCION_DIRECCION"));
                interTercerosDireccionesBean.setCodDepartamento(rs.getString("COD_DEPARTAMENTO"));
                interTercerosDireccionesBean.setCodProvincia(rs.getString("COD_PROVINCIA"));
                interTercerosDireccionesBean.setNumFax(rs.getString("NUM_FAX"));
                interTercerosDireccionesBean.setCodDistrito(rs.getString("COD_DISTRITO"));
                interTercerosDireccionesBean.setTipoDireccion(rs.getString("TIPO_DIRECCION"));
                interTercerosDireccionesBean.setTlfFijo(rs.getString("TLF_FIJO"));
                interTercerosDireccionesBean.setUserLogin(rs.getString("USER_LOGIN"));
                interTercerosDireccionesBean.setTlfCelular(rs.getString("TLF_CELULAR"));
                interTercerosDireccionesBean.setEmail(rs.getString("EMAIL"));
                direcciones.add(interTercerosDireccionesBean);
            }
        }catch(SQLException e){
            log.error(e);
        }
        finally{
            if (conn != null){
                conn.close();
            }
        }
        return direcciones;
    }
}
