package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by agil on 30/05/2016.
 */
public class CreacionTercerosBean {

    // TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, FECHA_NAC, ESTADO_CIVIL, SEXO
    private String tipoTercero;
    private String tipoDocIdentidad;
    private String cedula;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private String edoCivil;
    private String sexo;


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

    public String getFechaNac(){
        return fechaNac;
    }

    public void setFechaNac(String fechaNac){
        this.fechaNac = fechaNac;
    }

    public String getEdoCivil(){
        return edoCivil;
    }

    public void setEdoCivil(String edoCivil){
        this.edoCivil = edoCivil;
    }

    public String getSexo(){
        return sexo;
    }

    public void setSexo(String sexo){
        this.sexo = sexo;
    }

    public static CreacionTercerosBean getCreacionTerceros(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        CreacionTercerosBean creacionTercerosBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM CREACION_TERCEROS WHERE PRUEBA = 1");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                creacionTercerosBean = new CreacionTercerosBean();
                creacionTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                creacionTercerosBean.setTipoDocIdentidad(rs.getString("TIPO_DOC_IDENTIDAD"));
                creacionTercerosBean.setCedula(rs.getString("CEDULA"));
                creacionTercerosBean.setNombre(rs.getString("NOMBRE"));
                creacionTercerosBean.setApellido(rs.getString("APELLIDO"));
                creacionTercerosBean.setFechaNac(rs.getString("FECHA_NAC"));
                creacionTercerosBean.setEdoCivil(rs.getString("ESTADO_CIVIL"));
                creacionTercerosBean.setSexo(rs.getString("SEXO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return creacionTercerosBean;
    }
}
