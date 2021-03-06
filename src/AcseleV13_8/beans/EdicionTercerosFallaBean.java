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
 * Created by agil on 31/05/2016.
 */
public class EdicionTercerosFallaBean implements Serializable {

    private final static Logger log = Logger.getLogger(EdicionTercerosFallaBean.class);

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

    public static ArrayList getEdicionTercerosFalla() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList edicionTercerosFalla = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                EdicionTercerosFallaBean edicionTercerosFallaBean = new EdicionTercerosFallaBean();

                edicionTercerosFallaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                edicionTercerosFallaBean.setTipoDocIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                edicionTercerosFallaBean.setCedula(rs.getString("CEDULA"));
                edicionTercerosFallaBean.setNombre(rs.getString("NOMBRE"));
                edicionTercerosFallaBean.setApellido(rs.getString("APELLIDO"));
                edicionTercerosFallaBean.setTipoTerceroNuevo(rs.getString("TIPO_TERCERO_NUEVO"));
                edicionTercerosFallaBean.setTipoDocIdentidadNuevo(rs.getString("TIPO_DOC_IDENTIDAD_NUEVO"));
                edicionTercerosFallaBean.setCedulaNuevo(rs.getString("CEDULA_NUEVO"));
                edicionTercerosFallaBean.setNombreNuevo(rs.getString("NOMBRE_NUEVO"));
                edicionTercerosFallaBean.setApellidoNuevo(rs.getString("APELLIDO_NUEVO"));

                edicionTercerosFalla.add(edicionTercerosFallaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return edicionTercerosFalla;
    }
}
