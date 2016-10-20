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
 * Created by agil on 20/10/2016.
 */
public class LBC_CajaCierreBean extends LBC_CajaBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_CajaCierreBean.class);

    public static ArrayList getLBC_CajaCierreBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_CAJA FROM CERRAR_CAJA_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_CajaCierreBean lbcCajaCierreBean = new LBC_CajaCierreBean();

                lbcCajaCierreBean.setNumeroCaja(rs.getString("NUM_CAJA"));

                poliza.add(lbcCajaCierreBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return poliza;
    }
}
