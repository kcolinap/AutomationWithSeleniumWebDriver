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
 * Created by agil on 19/10/2016.
 */
public class LBC_AsociarCajaCajeroBean extends LBC_CajaBean implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_AsociarCajaCajeroBean.class);

    public static ArrayList getLBC_AsociarCajaCajeroBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, CAJERO, NUM_CAJA, NOMBRE_CAJERO, APELLIDO_CAJERO FROM ASOCIAR_CAJAS_CAJEROS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_AsociarCajaCajeroBean lbcAsociarCajaCajeroBean = new LBC_AsociarCajaCajeroBean();

                lbcAsociarCajaCajeroBean.setCajero(rs.getString("CAJERO"));
                lbcAsociarCajaCajeroBean.setNumeroCaja(rs.getString("NUM_CAJA"));
                lbcAsociarCajaCajeroBean.setNombreCajero(rs.getString("NOMBRE_CAJERO"));
                lbcAsociarCajaCajeroBean.setApellidoCajero(rs.getString("APELLIDO_CAJERO"));

                poliza.add(lbcAsociarCajaCajeroBean);
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
