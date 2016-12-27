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
 * Created by aazuaje on 27/12/2016.
 */
public class INTER_HistorialReclamoBean implements Serializable {

    private final static Logger log = Logger.getLogger(INTER_HistorialReclamoBean.class);

    private String numReclamo;

    public String getNumReclamo() {return numReclamo;}
    public void setNumReclamo(String numReclamo) {this.numReclamo = numReclamo;}

    public static ArrayList getInter_HistorialReclamo() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList inter_historialReclamos = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("select Prueba, Num_Reclamo from INTER_HISTORIAL_RECLAMO ORDER BY PRUEBA ASC");


        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                INTER_HistorialReclamoBean inter_historialReclamoBean = new INTER_HistorialReclamoBean();
                inter_historialReclamoBean.setNumReclamo(rs.getString("NUM_RECLAMO"));
                inter_historialReclamos.add(inter_historialReclamoBean);
            }

        }catch(SQLException e){
            log.error(e);
        }finally{
            if (conn != null) {
                conn.close();
            }
        }
        return inter_historialReclamos;
    }



}
