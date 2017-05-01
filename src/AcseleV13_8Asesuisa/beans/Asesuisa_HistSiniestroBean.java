package AcseleV13_8Asesuisa.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by cortiz on 01/04/2017.
 */
public class Asesuisa_HistSiniestroBean implements Serializable {

    private final static Logger log = Logger.getLogger(Asesuisa_HistSiniestroBean.class);

    private String nSiniestro;

    public String getnSiniestro() {
        return nSiniestro;
    }

    public void setnSiniestro(String nSiniestro) {
        this.nSiniestro = nSiniestro;
    }




    public static ArrayList getAsesuisa_histSiniestro() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList histSiniestro = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                Asesuisa_HistSiniestroBean histSiniestroBean = new Asesuisa_HistSiniestroBean();

                histSiniestroBean.setnSiniestro(rs.getString("NSINIESTRO"));


                histSiniestro.add(histSiniestroBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return histSiniestro;
    }
}
