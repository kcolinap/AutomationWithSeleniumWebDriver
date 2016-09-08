package AcseleV13_8.beans;

import org.apache.log4j.Logger;
import util.DBUnitConnectionManager;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by agil on 25/08/2016.
 */
public class JobsListasRestrictivasEjecucionBean implements Serializable {

    private final static Logger log = Logger.getLogger(JobsListasRestrictivasEjecucionBean.class);

    private String nombreTablaDinamica;

    public String getNombreTablaDinamica(){
        return nombreTablaDinamica;
    }
    public void setNombreTablaDinamica(String nombreTablaDinamica){
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public static ArrayList getJobsListasRestrictivasEjecucion() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList jobsEjecucion = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                JobsListasRestrictivasEjecucionBean jobsListasRestrictivasEjecucionBean= new JobsListasRestrictivasEjecucionBean();

                jobsListasRestrictivasEjecucionBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));

                jobsEjecucion.add(jobsListasRestrictivasEjecucionBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return jobsEjecucion;
    }
}
