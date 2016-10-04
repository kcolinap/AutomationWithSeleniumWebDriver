package AcseleV13_8.beans;

import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 15/07/2016.
 */
public class CajaAsociarBean implements Serializable {

    private String cajero;
    private String numCaja;

    public String getCajero() {
        return cajero;
    }
    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getNumCaja() {
        return numCaja;
    }
    public void setNumCaja(String numCaja) {
        this.numCaja = numCaja;
    }

    public static ArrayList getCajaAsociar() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList asociarCaja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, CAJERO, NUM_CAJA FROM ASOCIAR_CAJA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CajaAsociarBean cajaAsociarBean = new CajaAsociarBean();
                cajaAsociarBean.setCajero(rs.getString("CAJERO"));
                cajaAsociarBean.setNumCaja(rs.getString("NUM_CAJA"));
                asociarCaja.add(cajaAsociarBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return asociarCaja;
    }
}
