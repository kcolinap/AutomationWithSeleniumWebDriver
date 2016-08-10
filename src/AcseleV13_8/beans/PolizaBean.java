package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Administrador on 04/05/2016.
 */
public class PolizaBean implements Serializable {

    private String numPoliza;
    private String contratante;
    private String asegurado;

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public static PolizaBean getPoliza(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        PolizaBean polizaBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM BUSQUEDA_POLIZA_SIMPLE");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                polizaBean = new PolizaBean();
                polizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                polizaBean.setContratante(rs.getString("CONTRATANTE"));
                polizaBean.setAsegurado(rs.getString("ASEGURADO"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return polizaBean;

    }
}
