package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 03/04/2017.
 */
public class Asesuisa_CajaCerrarBean {
    private final static Logger log = Logger.getLogger(Asesuisa_CajaCerrarBean.class);

    private String nrocaja;

    public String getNrocaja() {
        return nrocaja;
    }

    public void setNrocaja(String nrocaja) {
        this.nrocaja = nrocaja;
    }

    public static ArrayList getAsesuisa_CajaCerrar() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_APERTURAR_CERRAR ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaCerrarBean cajaCerrarBean = new Asesuisa_CajaCerrarBean();

                cajaCerrarBean.setNrocaja(rs.getString("NROCAJA"));

                caja.add(cajaCerrarBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return caja;
    }

}
