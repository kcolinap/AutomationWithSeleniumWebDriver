package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 14/06/2016.
 */
public class TercerosInfTecnicaBean implements Serializable {

    private String tipoTercero;
    private String tipoDocId;
    private String cedula;
    private String nombre;
    private String apellido;


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

    public static ArrayList getConsultaTercerosInfTecnica(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList terceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM CONSULTA_TERCEROS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                TercerosInfTecnicaBean tercerosInfTecnicaBean = new TercerosInfTecnicaBean();
                tercerosInfTecnicaBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                tercerosInfTecnicaBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                tercerosInfTecnicaBean.setCedula(rs.getString("CEDULA"));
                tercerosInfTecnicaBean.setNombre(rs.getString("NOMBRE"));
                tercerosInfTecnicaBean.setApellido(rs.getString("APELLIDO"));
                terceros.add(tercerosInfTecnicaBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return terceros;
    }
}
