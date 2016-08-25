package AcseleV13_8.tests;

import AcseleV13_8.beans.JobsListasRestrictivasEjecucionBean;
import AcseleV13_8.main.controller.JobsListasRestrictivasEjecucion;
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
public class VistaJobsListasRestrictivasEjecucionTest {

    private final static Logger log = Logger.getLogger(VistaJobsListasRestrictivasEjecucionTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList jobsEjecucion = JobsListasRestrictivasEjecucionBean.getJobsListasRestrictivasEjecucion();

        for (int i = 0; i < jobsEjecucion.size(); i++){
            JobsListasRestrictivasEjecucionBean jobsListasRestrictivasEjecucionBean = (JobsListasRestrictivasEjecucionBean) jobsEjecucion.get(i);
            JobsListasRestrictivasEjecucion a = new JobsListasRestrictivasEjecucion();

            try {
                a.testLink(jobsListasRestrictivasEjecucionBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml");

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/jobsListasRestrictivasCreacion_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
