package AcseleV13_8LBC.beans;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aazuaje on 10/10/2016.
 */
public class LBC_ConsultaSimplePolizaBean implements Serializable{

    private final static Logger log = Logger.getLogger(LBC_ConsultaSimplePolizaBean.class);

    private String numPoliza;
    private String cliente;
    private String asegurado;


    public String getNumPoliza() {return numPoliza;}
    public void setNumPoliza(String numPoliza) {this.numPoliza = numPoliza;}

    public String getCliente() {return cliente;}
    public void setCliente(String cliente) {this.cliente = cliente;}

    public String getAsegurado() {return asegurado;}
    public void setAsegurado(String asegurado) {this.asegurado = asegurado;}

    public static ArrayList getConsultaSimplePolizaBean() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList consultaPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select PRUEBA,NUM_POLIZA,CLIENTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_ConsultaSimplePolizaBean lbcConsultaSimplePolizaBean = new LBC_ConsultaSimplePolizaBean();

                lbcConsultaSimplePolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
                lbcConsultaSimplePolizaBean.setCliente(rs.getString("CLIENTE"));
                lbcConsultaSimplePolizaBean.setAsegurado(rs.getString("ASEGURADO"));

                consultaPoliza.add(lbcConsultaSimplePolizaBean);
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
