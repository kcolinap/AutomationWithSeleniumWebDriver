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
 * Created by agil on 07/09/2016.
 */
public class JobListasResctrictivasEjecucionBean implements Serializable {

    private final static Logger log = Logger.getLogger(JobListasResctrictivasEjecucionBean.class);

    private String busqTareaNumCita;
    private String busqTareaEstatus;
    private String busqTareaPeriodicidad;
    private String busqTareaDesde;
    private String busqTareaHasta;
    private String busqTareaDescripcion;

    public String getBusqTareaNumCita(){
        return busqTareaNumCita;
    }
    public void setBusqTareaNumCita(String busqTareaNumCita){
        this.busqTareaNumCita = busqTareaNumCita;
    }

    public String getBusqTareaEstatus(){
        return busqTareaEstatus;
    }
    public void setBusqTareaEstatus(String busqTareaEstatus){
        this.busqTareaEstatus = busqTareaEstatus;
    }

    public String getBusqTareaPeriodicidad(){
        return busqTareaPeriodicidad;
    }
    public void setBusqTareaPeriodicidad(String busqTareaPeriodicidad){
        this.busqTareaPeriodicidad = busqTareaPeriodicidad;
    }

    public String getBusqTareaDesde(){
        return busqTareaDesde;
    }
    public void setBusqTareaDesde(String busqTareaDesde){
        this.busqTareaDesde = busqTareaDesde;
    }

    public String getBusqTareaHasta(){
        return busqTareaHasta;
    }
    public void setBusqTareaHasta(String busqTareaHasta){
        this.busqTareaHasta = busqTareaHasta;
    }

    public String getBusqTareaDescripcion(){
        return busqTareaDescripcion;
    }
    public void setBusqTareaDescripcion(String busqTareaDescripcion){
        this.busqTareaDescripcion = busqTareaDescripcion;
    }

    public static ArrayList getJobsListasRestrictivasEjecucion() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList jobsEjecucion = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOB_LIST_RESTRICTIVE_EJECUTION ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                JobListasResctrictivasEjecucionBean jobListasResctrictivasEjecucionBean = new JobListasResctrictivasEjecucionBean();

                jobListasResctrictivasEjecucionBean.setBusqTareaNumCita(rs.getString("BUSQ_TAREA_NUM_CITA"));
                jobListasResctrictivasEjecucionBean.setBusqTareaEstatus(rs.getString("BUSQ_TAREA_ESTATUS"));
                jobListasResctrictivasEjecucionBean.setBusqTareaPeriodicidad(rs.getString("BUSQ_TAREA_PERIODICIDAD"));
                jobListasResctrictivasEjecucionBean.setBusqTareaDesde(rs.getString("BUSQ_TAREA_DESDE"));
                jobListasResctrictivasEjecucionBean.setBusqTareaHasta(rs.getString("BUSQ_TAREA_HASTA"));
                jobListasResctrictivasEjecucionBean.setBusqTareaDescripcion(rs.getString("BUSQ_TAREA_DESCRIPCION"));


                jobsEjecucion.add(jobListasResctrictivasEjecucionBean);
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
