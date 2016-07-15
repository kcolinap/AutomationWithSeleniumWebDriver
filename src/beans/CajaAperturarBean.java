package beans;

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
public class CajaAperturarBean implements Serializable {

    private String numCaja;

    public String getNumCaja() {
        return numCaja;
    }
    public void setNumCaja(String numCaja) {
        this.numCaja = numCaja;
    }

    public static ArrayList getCajaApertura() {

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ArrayList aperturarCaja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                CajaAperturarBean cajaAperturarBean= new CajaAperturarBean();
                cajaAperturarBean.setNumCaja(rs.getString("NUM_CAJA"));
                aperturarCaja.add(cajaAperturarBean);
            }
        }catch(SQLException e){
            //log.error(e);
            //conn.close();
        }
        return aperturarCaja;
    }
}
