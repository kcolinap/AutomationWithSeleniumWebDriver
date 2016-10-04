package AcseleV13_8.tests;

import AcseleV13_8.beans.CreacionEdicionTercerosBean;
import AcseleV13_8.main.controller.CreacionEdicionTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 07/06/2016.
 */
public class VistaCreacionEdicionTercerosTest {

    private final static Logger log = Logger.getLogger(VistaCreacionEdicionTercerosTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList terceros = CreacionEdicionTercerosBean.getTercerosEdicion();

        for(int i = 0; i < terceros.size(); i++) {

            CreacionEdicionTercerosBean creacionEdicionTercerosBean = (CreacionEdicionTercerosBean) terceros.get(i);
            CreacionEdicionTerceros a = new CreacionEdicionTerceros();

            try {
                a.testLink(creacionEdicionTercerosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/creacionEdicionTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/creacionEdicionTerceros_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/creacionEdicionTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/creacionEdicionTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
