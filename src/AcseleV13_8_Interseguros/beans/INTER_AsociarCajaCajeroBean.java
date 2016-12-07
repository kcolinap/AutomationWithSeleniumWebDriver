package AcseleV13_8_Interseguros.beans;

import AcseleV13_8_Interseguros.main.controller.INTER_AsociarCajaCajero;
import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by mchurion on 07/12/2016.
 */
public class INTER_AsociarCajaCajeroBean extends INTER_AsociarCajaCajero {
    private final static Logger log = Logger.getLogger(INTER_AsociarCajaCajeroBean.class);

    public static ArrayList getINTER_AsociarCajaCajeroBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, CAJERO, NUM_CAJA, NOMBRE_CAJERO, APELLIDO_CAJERO FROM ASOCIAR_CAJAS_CAJEROS_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_AsociarCajaCajeroBean interAsociarCajaCajeroBean = new INTER_AsociarCajaCajeroBean();

                interAsociarCajaCajeroBean.setCajero(rs.getString("CAJERO"));
                interAsociarCajaCajeroBean.setNumeroCaja(rs.getString("NUM_CAJA"));
                interAsociarCajaCajeroBean.setNombreCajero(rs.getString("NOMBRE_CAJERO"));
                interAsociarCajaCajeroBean.setApellidoCajero(rs.getString("APELLIDO_CAJERO"));

                poliza.add(interAsociarCajaCajeroBean);
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
