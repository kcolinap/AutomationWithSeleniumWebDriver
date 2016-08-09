package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 16/06/2016.
 */
public class TercerosRolesBean implements Serializable {


    private String tipoTercero;
    private String tipoDocId;
    private String cedula;
    private String nombre;
    private String apellido;
    private String rol;
    private String entBancaria;
    private String tipoCtaBanc;
    private String numCtaBanc;


    public String getTipoTercero() {
        return tipoTercero;
    }
    public void setTipoTercero(String tipoTercero) {
        this.tipoTercero = tipoTercero;
    }

    public String getTipoDocId() {
        return tipoDocId;
    }
    public void setTipoDocId(String tipoDocId) {
        this.tipoDocId = tipoDocId;
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

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEntBancaria() {
        return entBancaria;
    }
    public void setEntBancaria(String entBancaria) {
        this.entBancaria = entBancaria;
    }

    public String getTipoCtaBanc() {
        return tipoCtaBanc;
    }
    public void setTipoCtaBanc(String tipoCtaBanc) {
        this.tipoCtaBanc = tipoCtaBanc;
    }

    public String getNumCtaBanc() {
        return numCtaBanc;
    }
    public void setNumCtaBanc(String numCtaBanc) {
        this.numCtaBanc = numCtaBanc;
    }

    public static ArrayList getTercerosRoles(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM TERCEROS_ROLES ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosRolesBean tercerosRolesBean = new TercerosRolesBean();
                tercerosRolesBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                tercerosRolesBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosRolesBean.setCedula(rs.getString("CEDULA"));
                tercerosRolesBean.setNombre(rs.getString("NOMBRE"));
                tercerosRolesBean.setApellido(rs.getString("APELLIDO"));
                tercerosRolesBean.setRol(rs.getString("ROL"));
                tercerosRolesBean.setEntBancaria(rs.getString("ENTIDAD_BANCARIA"));
                tercerosRolesBean.setTipoCtaBanc(rs.getString("TIPO_CUENTA_BANCARIA"));
                tercerosRolesBean.setNumCtaBanc(rs.getString("NUM_CUENTA_BANCARIA"));
                terceros.add(tercerosRolesBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }

}
