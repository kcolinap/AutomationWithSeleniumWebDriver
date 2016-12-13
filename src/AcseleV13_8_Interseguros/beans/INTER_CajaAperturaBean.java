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
 * Created by mchurion on 12/12/2016.
 */
public class INTER_CajaAperturaBean extends INTER_CajaBean implements Serializable {
    private final static Logger log = Logger.getLogger(INTER_CajaAperturaBean.class);

    public static ArrayList getINTER_CajaAperturaBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CajaAperturaBean interCajaAperturaBean = new INTER_CajaAperturaBean();

                interCajaAperturaBean.setNumeroCaja(rs.getString("NUM_CAJA"));

                poliza.add(interCajaAperturaBean);
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
