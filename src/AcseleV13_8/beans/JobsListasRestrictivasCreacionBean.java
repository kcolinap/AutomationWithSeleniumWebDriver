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

    private String jobDescripcion;
    private String jobPrograma;
    private String jobTipo;
    private String jobNombrePantalla;
    private String jobDiasFeriados;
    private String tareaDescripcion;
    private String tareaFechaEjecucion;
    private String tareaHoraEjecucion;
    private String tareaMinutoEjecucion;
    private String tareaPeriodicidad;
    private String tareaServidor;
    private String tareaActividades;
    private String tareaNotificarEjecucion;
    private String tareaEjecutaExclusivamente;
    private String tareaEmailResponsable;
    private String busqTareaNumCita;
    private String busqTareaEstatus;
    private String busqTareaPeriodicidad;
    private String busqTareaDesde;
    private String busqTareaHasta;
    private String busqTareaDescripcion;

    public String getJobDescripcion(){
        return jobDescripcion;
    }
    public void setJobDescripcion(String jobDescripcion){
        this.jobDescripcion = jobDescripcion;
    }

    public String getJobPrograma(){
        return jobPrograma;
    }
    public void setJobPrograma(String jobPrograma){
        this.jobPrograma = jobPrograma;
    }

    public String getJobTipo(){
        return jobTipo;
    }
    public void setJobTipo(String jobTipo){
        this.jobTipo = jobTipo;
    }

    public String getJobNombrePantalla(){
        return jobNombrePantalla;
    }
    public void setJobNombrePantalla(String jobNombrePantalla){
        this.jobNombrePantalla = jobNombrePantalla;
    }

    public String getJobDiasFeriados(){
        return jobDiasFeriados;
    }
    public void setJobDiasFeriados(String jobDiasFeriados){
        this.jobDiasFeriados = jobDiasFeriados;
    }

    public String getTareaDescripcion(){
        return tareaDescripcion;
    }
    public void setTareaDescripcion(String tareaDescripcion){
        this.tareaDescripcion = tareaDescripcion;
    }

    public String getTareaFechaEjecucion(){
        return tareaFechaEjecucion;
    }
    public void setTareaFechaEjecucion(String tareaFechaEjecucion){
        this.tareaFechaEjecucion = tareaFechaEjecucion;
    }

    public String getTareaHoraEjecucion(){
        return tareaHoraEjecucion;
    }
    public void setTareaHoraEjecucion(String tareaHoraEjecucion){
        this.tareaHoraEjecucion = tareaHoraEjecucion;
    }

    public String getTareaMinutoEjecucion(){
        return tareaMinutoEjecucion;
    }
    public void setTareaMinutoEjecucion(String tareaMinutoEjecucion){
        this.tareaMinutoEjecucion = tareaMinutoEjecucion;
    }

    public String getTareaPeriodicidad(){
        return tareaPeriodicidad;
    }
    public void setTareaPeriodicidad(String tareaPeriodicidad){
        this.tareaPeriodicidad = tareaPeriodicidad;
    }

    public String getTareaServidor(){
        return tareaServidor;
    }
    public void setTareaServidor(String tareaServidor){
        this.tareaServidor = tareaServidor;
    }

    public String getTareaActividades(){
        return tareaActividades;
    }
    public void setTareaActividades(String tareaActividades){
        this.tareaActividades = tareaActividades;
    }

    public String getTareaNotificarEjecucion(){
        return tareaNotificarEjecucion;
    }
    public void setTareaNotificarEjecucion(String tareaNotificarEjecucion){
        this.tareaNotificarEjecucion = tareaNotificarEjecucion;
    }

    public String getTareaEjecutaExclusivamente(){
        return tareaEjecutaExclusivamente;
    }
    public void setTareaEjecutaExclusivamente(String tareaEjecutaExclusivamente){
        this.tareaEjecutaExclusivamente = tareaEjecutaExclusivamente;
    }

    public String getTareaEmailResponsable(){
        return tareaEmailResponsable;
    }
    public void setTareaEmailResponsable(String tareaEmailResponsable){
        this.tareaEmailResponsable = tareaEmailResponsable;
    }

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

    public static ArrayList getJobsListasRestrictivasCreacion() throws SQLException {

        Connection conn = null;
        Statement stmt;
        ResultSet rs;
        ArrayList jobsCreacion = new ArrayList();

        StringBuilder queryLoad = new StringBuilder();
        queryLoad.append("SELECT PRUEBA, JOB_DESCRIPCION, JOB_PROGRAMA, JOB_TIPO, JOB_NOMBRE_PANTALLA, JOB_DIAS_FERIADOS, TAREA_DESCRIPCION, TAREA_FECHA_EJECUCION, TAREA_HORA_EJECUCION, TAREA_MINUTO_EJECUCION, TAREA_PERIODICIDAD, TAREA_SERVIDOR, TAREA_ACTIVIDADES, TAREA_NOTIFICAR_EJECUCION, TAREA_EJECUT_EXCLUSIVA, TAREA_EMAIL_RESPONSABLE, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOBS_LIST_RESTRICTIVE_CREATION ORDER BY PRUEBA ASC");

        try {
            conn = DBUnitConnectionManager.getSeleniumDataSource().getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(queryLoad.toString());

            while (rs.next()) {
                JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean = new JobsListasRestrictivasCreacionBean();

                jobsListasRestrictivasCreacionBean.setJobDescripcion(rs.getString("JOB_DESCRIPCION"));
                jobsListasRestrictivasCreacionBean.setJobPrograma(rs.getString("JOB_PROGRAMA"));
                jobsListasRestrictivasCreacionBean.setJobTipo(rs.getString("JOB_TIPO"));
                jobsListasRestrictivasCreacionBean.setJobNombrePantalla(rs.getString("JOB_NOMBRE_PANTALLA"));
                jobsListasRestrictivasCreacionBean.setJobDiasFeriados(rs.getString("JOB_DIAS_FERIADOS"));
                jobsListasRestrictivasCreacionBean.setTareaDescripcion(rs.getString("TAREA_DESCRIPCION"));
                jobsListasRestrictivasCreacionBean.setTareaFechaEjecucion(rs.getString("TAREA_FECHA_EJECUCION"));
                jobsListasRestrictivasCreacionBean.setTareaHoraEjecucion(rs.getString("TAREA_HORA_EJECUCION"));
                jobsListasRestrictivasCreacionBean.setTareaMinutoEjecucion(rs.getString("TAREA_MINUTO_EJECUCION"));
                jobsListasRestrictivasCreacionBean.setTareaPeriodicidad(rs.getString("TAREA_PERIODICIDAD"));
                jobsListasRestrictivasCreacionBean.setTareaServidor(rs.getString("TAREA_SERVIDOR"));
                jobsListasRestrictivasCreacionBean.setTareaActividades(rs.getString("TAREA_ACTIVIDADES"));
                jobsListasRestrictivasCreacionBean.setTareaNotificarEjecucion(rs.getString("TAREA_NOTIFICAR_EJECUCION"));
                jobsListasRestrictivasCreacionBean.setTareaEjecutaExclusivamente(rs.getString("TAREA_EJECUT_EXCLUSIVA"));
                jobsListasRestrictivasCreacionBean.setTareaEmailResponsable(rs.getString("TAREA_EMAIL_RESPONSABLE"));
                jobsListasRestrictivasCreacionBean.setBusqTareaNumCita(rs.getString("BUSQ_TAREA_NUM_CITA"));
                jobsListasRestrictivasCreacionBean.setBusqTareaEstatus(rs.getString("BUSQ_TAREA_ESTATUS"));
                jobsListasRestrictivasCreacionBean.setBusqTareaPeriodicidad(rs.getString("BUSQ_TAREA_PERIODICIDAD"));
                jobsListasRestrictivasCreacionBean.setBusqTareaDesde(rs.getString("BUSQ_TAREA_DESDE"));
                jobsListasRestrictivasCreacionBean.setBusqTareaHasta(rs.getString("BUSQ_TAREA_HASTA"));
                jobsListasRestrictivasCreacionBean.setBusqTareaDescripcion(rs.getString("BUSQ_TAREA_DESCRIPCION"));

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

