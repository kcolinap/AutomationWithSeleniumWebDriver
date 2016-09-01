package AcseleV13_8.tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 01/09/2016.
 */
public class VistaCreacionListaTemplateTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

    /*    ArrayList listasRestrictivas = ListasRestrictivasBean.getListasRestrictivas();

        for (int i = 0; i < listasRestrictivas.size(); i++) {
            ListasRestrictivasBean listasRestrictivasBean = (ListasRestrictivasBean) listasRestrictivas.get(i);
            ListasRestrictivas a = new ListasRestrictivas();


            try {
                a.testLink(listasRestrictivasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }
*/
    }

    @Before
    public void setUp() throws Exception {

  /*    DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBREPLANTILLA FROM LISTAS_RESTRICTIVAS_TEMPLATE ORDER BY PRUEBA ASC",
                "LISTAS_RESTRICTIVAS_TEMPLATE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/listasRestrictivasTemplate_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBREPLANTILLA FROM LISTAS_RESTRICTIVAS_TEMPLATE ORDER BY PRUEBA ASC",
                "LISTAS_RESTRICTIVAS_TEMPLATE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/listasRestrictivasTemplate_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/listasRestrictivasTemplate_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/listasRestrictivasTemplate_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}






