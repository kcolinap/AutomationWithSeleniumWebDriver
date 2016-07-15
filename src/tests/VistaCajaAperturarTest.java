package tests;

import beans.CajaAperturarBean;
import main.controller.CajaAperturar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 15/07/2016.
 */
public class VistaCajaAperturarTest {

    private final static Logger log = Logger.getLogger(VistaCajaAperturarTest.class);

    @Test
    public void mainTest(){

        ArrayList cajaAperturar = CajaAperturarBean.getCajaApertura();

        for (int i = 0; i < cajaAperturar.size(); i++){
            CajaAperturarBean cajaAperturarBean = (CajaAperturarBean) cajaAperturar.get(i);
            CajaAperturar a = new CajaAperturar();

            try {
                a.testLink(cajaAperturarBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 28 - " + a.nombreAutomatizacion + " -  " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/cajaAperturar_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/cajaAperturar_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/cajaAperturar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/cajaAperturar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
