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
public class JobsListasRestrictivasCreacionBean implements Serializable{

    private final static Logger log = Logger.getLogger(JobsListasRestrictivasCreacionBean.class);

    private String nombreTablaDinamica;

    public String getNombreTablaDinamica(){
        return nombreTablaDinamica;
    }
    public void setNombreTablaDinamica(String nombreTablaDinamica){
        this.nombreTablaDinamica = nombreTablaDinamica;
    }

    public static ArrayList getJobsListasRestrictivasCreacion() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList jobsCreacion = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean = new JobsListasRestrictivasCreacionBean();

                jobsListasRestrictivasCreacionBean.setNombreTablaDinamica(rs.getString("NOMBRE_TABLA_DINAMICA"));

                jobsCreacion.add(jobsListasRestrictivasCreacionBean);
            }
        }catch(SQLException e) {
            log.error(e);
        }finally{
            if (conn != null){
                conn.close();
            }
        }

        return jobsCreacion;
    }
}
