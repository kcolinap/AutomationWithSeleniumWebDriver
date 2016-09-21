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
 * Created by Administrador on 04/05/2016.
 */
public class ConsultaPolizaSimpleBean implements Serializable {

    private final static Logger log = Logger.getLogger(ConsultaPolizaSimpleBean.class);

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

    public static ArrayList getConsultaPolizaSimple() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM BUSQUEDA_POLIZA_SIMPLE");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                ConsultaPolizaSimpleBean consultaPolizaSimpleBean = new ConsultaPolizaSimpleBean();

                consultaPolizaSimpleBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                consultaPolizaSimpleBean.setContratante(rs.getString("CONTRATANTE"));
                consultaPolizaSimpleBean.setAsegurado(rs.getString("ASEGURADO"));

                poliza.add(consultaPolizaSimpleBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return poliza;

    }
/*  public static PolizaBean getPoliza(){

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

    }*/
}
