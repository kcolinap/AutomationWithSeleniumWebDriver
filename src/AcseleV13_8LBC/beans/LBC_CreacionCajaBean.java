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
public class LBC_CreacionCajaBean extends LBC_Caja implements Serializable {

    private final static Logger log = Logger.getLogger(LBC_CreacionCajaBean.class);

    public static ArrayList getLBC_CrearCajaBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList poliza = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, descripcion, ubicacion, sucursal FROM CREACION_CAJAS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                LBC_CreacionCajaBean lbcCrearCajaBean = new LBC_CreacionCajaBean();

                lbcCrearCajaBean.setDescripcion(rs.getString("descripcion"));
                lbcCrearCajaBean.setUbicacion(rs.getString("ubicacion"));
                lbcCrearCajaBean.setSucursal(rs.getString("sucursal"));

                poliza.add(lbcCrearCajaBean);
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
