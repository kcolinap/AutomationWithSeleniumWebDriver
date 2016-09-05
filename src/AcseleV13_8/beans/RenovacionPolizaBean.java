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
 * Created by agil on 27/05/2016.
 */
public class RenovacionPolizaBean implements Serializable {

    private final static Logger log = Logger.getLogger(RenovacionPolizaBean.class);

    private String numPoliza;

    public String getNumPoliza() {
        return numPoliza;
    }
    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public static ArrayList getRenovacionPoliza() throws SQLException{

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList renovacionPoliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_POLIZA FROM RENOVACION_POLIZAS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                RenovacionPolizaBean renovacionPolizaBean = new RenovacionPolizaBean();

                renovacionPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));

                renovacionPoliza.add(renovacionPoliza);
            }
        }catch(SQLException e){
            log.error(e);
            //conn.close();
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return renovacionPoliza;

    }
}
