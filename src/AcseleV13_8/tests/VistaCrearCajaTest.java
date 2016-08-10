package AcseleV13_8.tests;

import AcseleV13_8.beans.CrearCajaBean;
import AcseleV13_8.main.controller.CrearCaja;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by mchurion on 14/07/2016.
 */
public class VistaCrearCajaTest {

    private final static Logger log = Logger.getLogger(VistaCrearCajaTest.class);

    @Test
    public void mainTest(){

        ArrayList caja = CrearCajaBean.getCrearCaja();

        for (int i = 0; i < caja.size(); i++) {
            CrearCajaBean crearCajaBean = (CrearCajaBean) caja.get(i);
            CrearCaja a = new CrearCaja();

            try {
                a.testLink(crearCajaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, DESCRIPCION, UBICACION, SUCURSAL FROM CREAR_CAJA ORDER BY PRUEBA ASC",
                "CREAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/crearCaja_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, DESCRIPCION, UBICACION, SUCURSAL FROM CREAR_CAJA ORDER BY PRUEBA ASC",
                "CREAR_CAJA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/crearCaja_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/crearCaja_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/crearCaja_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}


