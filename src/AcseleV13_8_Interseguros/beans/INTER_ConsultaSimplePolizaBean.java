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
 * Created by rmontilla on 26/12/2016.
 */
public class INTER_ConsultaSimplePolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_ConsultaSimplePolizaBean.class);

    private String numPoliza;
    private String contratante;
    private String asegurado;


    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getContratante() {return contratante;}
    public void setContratante(String contratante) {this.contratante = contratante;}

    public String getAsegurado() {return asegurado;}
    public void setAsegurado(String asegurado) {this.asegurado = asegurado;}

    public static ArrayList getConsultaSimplePolizaBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,NUM_POLIZA,CONTRATANTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_ConsultaSimplePolizaBean inter_consultaSimplePolizaBean = new INTER_ConsultaSimplePolizaBean();

                inter_consultaSimplePolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                inter_consultaSimplePolizaBean.setContratante(rs.getString("CONTRATANTE"));
                inter_consultaSimplePolizaBean.setAsegurado(rs.getString("ASEGURADO"));

                consultaPoliza.add(inter_consultaSimplePolizaBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return consultaPoliza;

    }

}
