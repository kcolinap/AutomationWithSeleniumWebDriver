package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by aandrade on 13/05/2017.
 */
public class Asesuisa_SiniestrosPagosBean {

    private final static Logger log = Logger.getLogger(Asesuisa_SiniestrosPagosBean.class);

    private String poliza;

    public String getPoliza() {
        return poliza;
    }

    public void setPoliza(String poliza) {
        this.poliza = poliza;
    }


    public static ArrayList getAsesuisa_SiniestrosPagos() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList siniestroPago = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_SINIESTROS_PAGOS ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_SiniestrosPagosBean siniestrosPagosBean = new Asesuisa_SiniestrosPagosBean();

                siniestrosPagosBean.setPoliza(rs.getString("POLIZA"));

                siniestroPago.add(siniestrosPagosBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return siniestroPago;
    }

}
