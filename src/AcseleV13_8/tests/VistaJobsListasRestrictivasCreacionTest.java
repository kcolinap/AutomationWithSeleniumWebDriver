package AcseleV13_8.tests;

import AcseleV13_8.beans.JobsListasRestrictivasCreacionBean;
import AcseleV13_8.main.controller.JobsListasRestrictivasCreacion;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 25/08/2016.
 */
public class VistaJobsListasRestrictivasCreacionTest {

    private final static Logger log = Logger.getLogger(VistaJobsListasRestrictivasCreacionTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList jobsCreacion = JobsListasRestrictivasCreacionBean.getJobsListasRestrictivasCreacion();

        for (int i = 0; i < jobsCreacion.size(); i++){
            JobsListasRestrictivasCreacionBean jobsListasRestrictivasCreacionBean = (JobsListasRestrictivasCreacionBean) jobsCreacion.get(i);
            JobsListasRestrictivasCreacion a = new JobsListasRestrictivasCreacion();

            try {
                a.testLink(jobsListasRestrictivasCreacionBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, JOB_DESCRIPCION, JOB_PROGRAMA, JOB_TIPO, JOB_NOMBRE_PANTALLA, JOB_DIAS_FERIADOS, TAREA_DESCRIPCION, TAREA_FECHA_EJECUCION, TAREA_HORA_EJECUCION, TAREA_MINUTO_EJECUCION, TAREA_PERIODICIDAD, TAREA_SERVIDOR, TAREA_ACTIVIDADES, TAREA_NOTIFICAR_EJECUCION, TAREA_EJECUT_EXCLUSIVA, TAREA_EMAIL_RESPONSABLE, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOBS_LIST_RESTRICTIVE_CREATION ORDER BY PRUEBA ASC",
                "JOBS_LIST_RESTRICTIVE_CREATION",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, JOB_DESCRIPCION, JOB_PROGRAMA, JOB_TIPO, JOB_NOMBRE_PANTALLA, JOB_DIAS_FERIADOS, TAREA_DESCRIPCION, TAREA_FECHA_EJECUCION, TAREA_HORA_EJECUCION, TAREA_MINUTO_EJECUCION, TAREA_PERIODICIDAD, TAREA_SERVIDOR, TAREA_ACTIVIDADES, TAREA_NOTIFICAR_EJECUCION, TAREA_EJECUT_EXCLUSIVA, TAREA_EMAIL_RESPONSABLE, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOBS_LIST_RESTRICTIVE_CREATION ORDER BY PRUEBA ASC",
                "JOBS_LIST_RESTRICTIVE_CREATION",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
