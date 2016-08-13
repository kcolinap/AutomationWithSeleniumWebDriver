package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.BuscarSiniestroSimpleBean;
import AcseleV13_8_Alfa.main.controller.BuscarSiniestroSimple;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/08/2016.
 */
public class VistaBuscarSiniestroSimpleTest {

    private final static Logger log = Logger.getLogger(VistaBuscarSiniestroSimpleTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = BuscarSiniestroSimpleBean.getBuscarSiniestroSimple();

        for (int i = 0; i < caja.size(); i++) {
            BuscarSiniestroSimpleBean buscarSiniestroSimpleBean = (BuscarSiniestroSimpleBean) caja.get(i);
            BuscarSiniestroSimple a = new BuscarSiniestroSimple();

            try {
                a.testLink(buscarSiniestroSimpleBean, i);
            } catch (Exception e) {
                e.printStackTrace();
    //                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
    }
}

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDEN,NUM_SINIESTRO,NUM_POLIZA,FECHA,PRODUCTO FROM BUSCAR_SINIESTRO_SIMPLE ORDER BY PRUEBA ASC",
                "BUSCAR_SINIESTRO_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xlms/buscarSiniestroSimple_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDEN,NUM_SINIESTRO,NUM_POLIZA,FECHA,PRODUCTO FROM BUSCAR_SINIESTRO_SIMPLE ORDER BY PRUEBA ASC",
                "BUSCAR_SINIESTRO_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Alfa/tests/xlms/buscarSiniestroSimple_dataset.xml");*/

        //DataSetManager.loadDataSet("C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xlms/buscarSiniestroSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xlms/buscarSiniestroSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xlms/buscarSiniestroSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
