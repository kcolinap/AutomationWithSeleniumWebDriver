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
 * Created by agil on 30/05/2016.
 */
public class ConsultaTercerosBean implements Serializable{

    private final static Logger log = Logger.getLogger(ConsultaTercerosBean.class);

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


    public static ArrayList getConsultaTerceros() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaTerceros = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultaTercerosBean consultaTercerosBean = new ConsultaTercerosBean();

                consultaTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                consultaTercerosBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                consultaTercerosBean.setCedula(rs.getString("CEDULA"));
                consultaTercerosBean.setNombre(rs.getString("NOMBRE"));
                consultaTercerosBean.setApellido(rs.getString("APELLIDO"));

                consultaTerceros.add(consultaTercerosBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaTerceros;

    }



/*    public static ConsultaTercerosBean getConsultaTerceros(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ConsultaTercerosBean consultaTercerosBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                consultaTercerosBean = new ConsultaTercerosBean();
                consultaTercerosBean.setTipoTercero(rs.getString("TIPO_TERCERO"));
                consultaTercerosBean.setTipoDocId(rs.getString("TIPO_DOC_IDENTIDAD"));
                consultaTercerosBean.setCedula(rs.getString("CEDULA"));
                consultaTercerosBean.setNombre(rs.getString("NOMBRE"));
                consultaTercerosBean.setApellido(rs.getString("APELLIDO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return consultaTercerosBean;
    }*/
}
