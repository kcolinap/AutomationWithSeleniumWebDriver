package tests;

import beans.AnulacionPolizaBean;
import beans.RenovacionPolizaBean;
import main.controller.AnulacionPolizas;
import main.controller.RenovacionPolizas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 27/05/2016.
 */
public class VistaRenovacionPolizasTest {

    @Test
    //@Transactional
    public void mainTest() {

        RenovacionPolizaBean renovacionPolizaBean = RenovacionPolizaBean.getRenovacionPoliza();
        RenovacionPolizas a = new RenovacionPolizas();
        try {
            a.testLink(renovacionPolizaBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT NUM_POLIZA FROM RENOVACION_POLIZAS",
                "RENOVACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/renovacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT NUM_POLIZA FROM RENOVACION_POLIZAS",
                "RENOVACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/renovacionPoliza_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/renovacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        //DataSetManager.loadDataSet("/tests/renovacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
