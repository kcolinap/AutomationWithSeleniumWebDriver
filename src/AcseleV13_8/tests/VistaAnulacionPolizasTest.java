package AcseleV13_8.tests;

import AcseleV13_8.beans.AnulacionPolizaBean;
import AcseleV13_8.main.controller.AnulacionPolizas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 27/05/2016.
 */
public class VistaAnulacionPolizasTest {

    @Test
    //@Transactional
    public void mainTest() {

        AnulacionPolizaBean anulacionPolizaBean = AnulacionPolizaBean.getAnulacionPoliza();
        AnulacionPolizas a = new AnulacionPolizas();
        try {
            a.testLink(anulacionPolizaBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT NUM_POLIZA, OPCION, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS",
                "ANULACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/anulacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT NUM_POLIZA, OPCION, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS",
                "ANULACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/anulacionPoliza_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
