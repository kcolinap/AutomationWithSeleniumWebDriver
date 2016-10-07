package AcseleV13_8.tests;

import AcseleV13_8.beans.JobListasResctrictivasEjecucionBean;
import AcseleV13_8.main.controller.JobListasResctrictivasEjecucion;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 07/09/2016.
 */
public class VistaJobListasResctrictivasEjecucionTest {

    private final static Logger log = Logger.getLogger(VistaJobListasResctrictivasEjecucionTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList jobsCreacion = JobListasResctrictivasEjecucionBean.getJobsListasRestrictivasEjecucion();

        for (int i = 0; i < jobsCreacion.size(); i++){
            JobListasResctrictivasEjecucionBean jobListasResctrictivasEjecucionBean = (JobListasResctrictivasEjecucionBean) jobsCreacion.get(i);
            JobListasResctrictivasEjecucion a = new JobListasResctrictivasEjecucion();

            try {
                a.testLink(jobListasResctrictivasEjecucionBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOB_LIST_RESTRICTIVE_EJECUTION ORDER BY PRUEBA ASC",
                "JOB_LIST_RESTRICTIVE_EJECUTION",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/jobsListasRestrictivasEjecucion_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSQ_TAREA_NUM_CITA, BUSQ_TAREA_ESTATUS, BUSQ_TAREA_PERIODICIDAD, BUSQ_TAREA_DESDE, BUSQ_TAREA_HASTA, BUSQ_TAREA_DESCRIPCION FROM JOB_LIST_RESTRICTIVE_EJECUTION ORDER BY PRUEBA ASC",
                "JOB_LIST_RESTRICTIVE_EJECUTION",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/jobsListasRestrictivasEjecucion_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasEjecucion_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasEjecucion_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
