package AcseleV13_8.tests;

import AcseleV13_8.beans.RenovacionPolizaBean;
import AcseleV13_8.main.controller.RenovacionPolizas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 27/05/2016.
 */
public class VistaRenovacionPolizasTest {

    private final static Logger log = Logger.getLogger(VistaRenovacionPolizasTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList renovacionPoliza = RenovacionPolizaBean.getRenovacionPoliza();

        for (int i = 0; i < renovacionPoliza.size(); i++) {

            RenovacionPolizaBean renovacionPolizaBean = (RenovacionPolizaBean) renovacionPoliza.get(i);
            RenovacionPolizas a = new RenovacionPolizas();

            try {
                a.testLink(renovacionPolizaBean);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA FROM RENOVACION_POLIZAS ORDER BY PRUEBA ASC",
                "RENOVACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/renovacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA FROM RENOVACION_POLIZAS ORDER BY PRUEBA ASC",
                "RENOVACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/renovacionPoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/renovacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/renovacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
