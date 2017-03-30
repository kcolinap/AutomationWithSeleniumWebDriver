package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 30/03/2017.
 */
public class Asesuisa_CajaAsociarCajeroBean {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAsociarCajeroBean.class);

    private String cajero;
    private String nrocaja;
    private String cajeroasoc;

    public String getCajero() {
        return cajero;
    }

    public void setCajero(String cajero) {
        this.cajero = cajero;
    }

    public String getNrocaja() {
        return nrocaja;
    }

    public void setNrocaja(String nrocaja) {
        this.nrocaja = nrocaja;
    }

    public String getCajeroasoc() {
        return cajeroasoc;
    }

    public void setCajeroasoc(String cajeroasoc) {
        this.cajeroasoc = cajeroasoc;
    }

    public static ArrayList getAsesuisa_CajaAsociarCajero() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList caja = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_CAJA_ASOCIAR_CAJERO ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_CajaAsociarCajeroBean cajaAsociarCajeroBean = new Asesuisa_CajaAsociarCajeroBean();

                cajaAsociarCajeroBean.setCajero(rs.getString("CAJERO"));
                cajaAsociarCajeroBean.setNrocaja(rs.getString("NROCAJA"));
                cajaAsociarCajeroBean.setCajeroasoc(rs.getString("CAJEROASOC"));

                caja.add(cajaAsociarCajeroBean);
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
