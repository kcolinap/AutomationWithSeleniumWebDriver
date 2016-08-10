package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 07/06/2016.
 */
public class EdicionTercerosBean implements Serializable {

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

    public static EdicionTercerosBean getEdicionTerceros(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        EdicionTercerosBean edicionTercerosBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                edicionTercerosBean = new EdicionTercerosBean();
                edicionTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                edicionTercerosBean.setTipoDocIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                edicionTercerosBean.setCedula(rs.getString("CEDULA"));
                edicionTercerosBean.setNombre(rs.getString("NOMBRE"));
                edicionTercerosBean.setApellido(rs.getString("APELLIDO"));
                /***/
                edicionTercerosBean.setTipoTerceroNuevo(rs.getString("TIPO_TERCERO_NUEVO"));
                edicionTercerosBean.setTipoDocIdentidadNuevo(rs.getString("TIPO_DOC_IDENTIDAD_NUEVO"));
                edicionTercerosBean.setCedulaNuevo(rs.getString("CEDULA_NUEVO"));
                edicionTercerosBean.setNombreNuevo(rs.getString("NOMBRE_NUEVO"));
                edicionTercerosBean.setApellidoNuevo(rs.getString("APELLIDO_NUEVO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return edicionTercerosBean;
    }

    public static ArrayList getTercerosEdicion(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EdicionTercerosBean edicionTercerosBean = new EdicionTercerosBean();
                //, , , ,
                //, ,, ,
                edicionTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                edicionTercerosBean.setTipoDocIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                edicionTercerosBean.setCedula(rs.getString("CEDULA"));
                edicionTercerosBean.setNombre(rs.getString("NOMBRE"));
                edicionTercerosBean.setApellido(rs.getString("APELLIDO"));
                edicionTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO_NUEVO"));
                edicionTercerosBean.setTipoDocIdentidadNuevo(rs.getString("TIPO_DOC_IDENTIDAD_NUEVO"));
                edicionTercerosBean.setCedulaNuevo(rs.getString("CEDULA_NUEVO"));
                edicionTercerosBean.setNombreNuevo(rs.getString("NOMBRE_NUEVO"));
                edicionTercerosBean.setApellidoNuevo(rs.getString("APELLIDO_NUEVO"));
                terceros.add(edicionTercerosBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }
}
