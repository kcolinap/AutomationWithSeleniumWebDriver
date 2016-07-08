package tests;

import beans.ConsultaTercerosBean;
import beans.CreacionTercerosBean;
import main.controller.ConsultaTerceros;
import main.controller.CreacionTerceros;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 30/05/2016.
 */
public class VistaCreacionTercerosTest {

    @Test
    //@Transactional
    public void mainTest() {

        CreacionTercerosBean creacionTercerosBean = CreacionTercerosBean.getCreacionTerceros();
        CreacionTerceros a = new CreacionTerceros();
        try {
            a.testLink(creacionTercerosBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM CREACION_TERCEROS WHERE PRUEBA = 1",
                "CREACION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/creacionTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM CREACION_TERCEROS WHERE PRUEBA = 1",
                "CREACION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/creacionTerceros_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/creacionTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/creacionTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
