package beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by agil on 27/05/2016.
 */
public class RenovacionPolizaBean implements Serializable {

    private String numPoliza;

    public String getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(String numPoliza) {
        this.numPoliza = numPoliza;
    }

    public static RenovacionPolizaBean getRenovacionPoliza(){

        Connection conn;
        Statement stmt;
        ResultSet rs;
        RenovacionPolizaBean renovacionPolizaBean = null;

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT NUM_POLIZA FROM RENOVACION_POLIZAS");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                renovacionPolizaBean = new RenovacionPolizaBean();
                renovacionPolizaBean.setNumPoliza(rs.getString("NUM_POLIZA"));
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return renovacionPolizaBean;

    }
}
