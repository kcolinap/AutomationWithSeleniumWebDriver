package AcseleV13_8.tests;

import AcseleV13_8.beans.AnulacionPolizaBean;
import AcseleV13_8.main.controller.AnulacionPolizas;
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
public class VistaAnulacionPolizasTest {

    private final static Logger log = Logger.getLogger(VistaAnulacionPolizasTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList anulacionPoliza = AnulacionPolizaBean.getAnulacionPoliza();

        for (int i = 0; i < anulacionPoliza.size(); i++) {

            AnulacionPolizaBean anulacionPolizaBean = (AnulacionPolizaBean) anulacionPoliza.get(i);
            AnulacionPolizas a = new AnulacionPolizas();

            try {
                a.testLink(anulacionPolizaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS ORDER BY PRUEBA ASC",
                "ANULACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS ORDER BY PRUEBA ASC",
                "ANULACION_POLIZAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/anulacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
