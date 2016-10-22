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
 * Created by aazuaje on 22/10/2016.
 */
public class HistoricoSiniestrosLBCBean implements Serializable {

    private final static Logger log = Logger.getLogger(HistoricoSiniestrosLBCBean.class);

    private String numeroReclamo;

    public String getNumeroReclamo() {return numeroReclamo;}
    public void setNumeroReclamo(String numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }

    public static ArrayList getHistoricoSiniestrosLBCBean() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList historicoSiniestrosLBC = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Numero_Reclamo from HIST_RECLAMOS_LBC ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                HistoricoSiniestrosLBCBean historicoSiniestrosLBCBean = new HistoricoSiniestrosLBCBean();
                historicoSiniestrosLBCBean.setNumeroReclamo(rs.getString("NUMERO_RECLAMO"));

                historicoSiniestrosLBC.add(historicoSiniestrosLBCBean);
            }
        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }
        return historicoSiniestrosLBC;

    }

}
