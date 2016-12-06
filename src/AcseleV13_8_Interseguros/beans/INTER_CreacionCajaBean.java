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
 * Created by mchurion on 25/11/2016.
 */
public class INTER_CreacionCajaBean extends INTER_CajaBean implements Serializable{

    private final static Logger log = Logger.getLogger(INTER_CreacionCajaBean.class);

    public static ArrayList getINTER_CreacionCajaBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, DESCRIPCION, UBICACION, SUCURSAL FROM CREAR_CAJA_INTER ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_CreacionCajaBean interCreacionCajaBean = new INTER_CreacionCajaBean();

                interCreacionCajaBean.setDescripcion(rs.getString("descripcion"));
                interCreacionCajaBean.setUbicacion(rs.getString("ubicacion"));
                interCreacionCajaBean.setSucursal(rs.getString("sucursal"));

                poliza.add(interCreacionCajaBean);
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
