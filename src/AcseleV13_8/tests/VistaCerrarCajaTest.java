package AcseleV13_8.tests;

import AcseleV13_8.beans.CerrarCajaBean;
import AcseleV13_8.main.controller.CerrarCaja;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by mchurion on 18/07/2016.
 */
public class VistaCerrarCajaTest {

    private final static Logger log = Logger.getLogger(VistaCerrarCajaTest.class);

    @Test
    public void mainTest(){

        ArrayList caja = CerrarCajaBean.getCerrarCaja();

        for (int i = 0; i < caja.size(); i++) {
            CerrarCajaBean cerrarCajaBean = (CerrarCajaBean) caja.get(i);
            CerrarCaja a = new CerrarCaja();

            try {
                a.testLink(cerrarCajaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJA_ABIERTA FROM CERRAR_CAJA ORDER BY PRUEBA ASC",
                "CERRAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/cerrarCaja_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJA_ABIERTA FROM CERRAR_CAJA ORDER BY PRUEBA ASC",
                "CERRAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/cerrarCaja_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cerrarCaja_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cerrarCaja_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
