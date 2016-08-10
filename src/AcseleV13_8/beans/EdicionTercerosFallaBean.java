package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by agil on 31/05/2016.
 */
public class EdicionTercerosFallaBean {

    //TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO
    //TIPO_TERCERO_NUEVO, TIPO_DOC_IDENTIDAD_NUEVO,CEDULA_NUEVO, NOMBRE_NUEVO, APELLIDO_NUEVO
    private String tipoTercero;
    private String tipoDocIdentidad;
    private String cedula;
    private String nombre;
    private String apellido;
    private String tipoTerceroNuevo;
    private String tipoDocIdentidadNuevo;
    private String cedulaNuevo;
    private String nombreNuevo;
    private String apellidoNuevo;

    public String getTipoTercero() {
        return tipoTercero;
    }

    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocIdentidad(){
        return tipoDocIdentidad;
    }

    public  void setTipoDocIdentidad(String tipoDocIdentidad){
        this.tipoDocIdentidad = tipoDocIdentidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /***/
    public String getTipoTerceroNuevo() {
        return tipoTerceroNuevo;
    }

    public void setTipoTerceroNuevo(String tipoTerceroNuevo) {
        this.tipoTerceroNuevo = tipoTerceroNuevo;
    }

    public String getTipoDocIdentidadNuevo(){
        return tipoDocIdentidadNuevo;
    }

    public  void setTipoDocIdentidadNuevo(String tipoDocIdentidadNuevo){
        this.tipoDocIdentidadNuevo = tipoDocIdentidadNuevo;
    }

    public String getCedulaNuevo() {
        return cedulaNuevo;
    }

    public void setCedulaNuevo(String cedulaNuevo) {
        this.cedulaNuevo = cedulaNuevo;
    }

    public String getNombreNuevo() {
        return nombreNuevo;
    }

    public void setNombreNuevo(String nombreNuevo) {
        this.nombreNuevo = nombreNuevo;
    }

    public String getApellidoNuevo() {
        return apellidoNuevo;
    }

    public void setApellidoNuevo(String apellidoNuevo) {
        this.apellidoNuevo = apellidoNuevo;
    }

    public static EdicionTercerosFallaBean getEdicionTercerosFalla() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        EdicionTercerosFallaBean edicionTercerosFallaBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select * from EDICION_TERCEROS where prueba = 2");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                edicionTercerosFallaBean = new EdicionTercerosFallaBean();
                edicionTercerosFallaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                edicionTercerosFallaBean.setTipoDocIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                edicionTercerosFallaBean.setCedula(rs.getString("CEDULA"));
                edicionTercerosFallaBean.setNombre(rs.getString("NOMBRE"));
                edicionTercerosFallaBean.setApellido(rs.getString("APELLIDO"));
                /***/
                edicionTercerosFallaBean.setTipoTerceroNuevo(rs.getString("TIPO_TERCERO_NUEVO"));
                edicionTercerosFallaBean.setTipoDocIdentidadNuevo(rs.getString("TIPO_DOC_IDENTIDAD_NUEVO"));
                edicionTercerosFallaBean.setCedulaNuevo(rs.getString("CEDULA_NUEVO"));
                edicionTercerosFallaBean.setNombreNuevo(rs.getString("NOMBRE_NUEVO"));
                edicionTercerosFallaBean.setApellidoNuevo(rs.getString("APELLIDO_NUEVO"));

            }
        } catch (SQLException e) {
            //log.error(e);
            //conn.close();
        }
        return edicionTercerosFallaBean;
    }
}
