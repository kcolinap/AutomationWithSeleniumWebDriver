package tests;

import beans.CajaAsociarBean;
import main.controller.CajaAsociar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 15/07/2016.
 */
public class VistaCajaAsociarTest {

    private final static Logger log = Logger.getLogger(VistaCajaAsociarTest.class);

    @Test
    public void mainTest(){

        ArrayList cajaAsociar = CajaAsociarBean.getCajaAsociar();

        for (int i = 0; i < cajaAsociar.size(); i++){
            CajaAsociarBean cajaAsociarBean = (CajaAsociarBean) cajaAsociar.get(i);
            CajaAsociar a = new CajaAsociar();

            try {
                a.testLink(cajaAsociarBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 27 - " + a.nombreAutomatizacion + " -  " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJERO, NUM_CAJA FROM ASOCIAR_CAJA ORDER BY PRUEBA ASC",
                "ASOCIAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/cajaAsociar_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJERO, NUM_CAJA FROM ASOCIAR_CAJA ORDER BY PRUEBA ASC",
                "ASOCIAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/cajaAsociar_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/cajaAsociar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/cajaAsociar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
