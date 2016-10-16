package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.EdicionTercerosFallaLBCBean;
import AcseleV13_8LBC.main.controller.EdicionTercerosFallaLBC;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 15/10/2016.
 */
public class VistaEdicionTercerosFallaLBCTest {
    private final static Logger log = Logger.getLogger(VistaEdicionTercerosFallaLBCTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList edicionTercerosFallaLBC = EdicionTercerosFallaLBCBean.getEdicionTercerosFallaLBCBean();

        for (int j = 0; j< edicionTercerosFallaLBC.size(); j++) {
            EdicionTercerosFallaLBCBean edicionTercerosFallaLBCBean = (EdicionTercerosFallaLBCBean) edicionTercerosFallaLBC.get(j);
            EdicionTercerosFallaLBC a = new EdicionTercerosFallaLBC();

            try {
                a.testLink(edicionTercerosFallaLBCBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID,TIPO_TERCERO_NUEVO, APELLIDO_NUEVO,NOMBRE_NUEVO, TIPO_DOC_ID_NUEVO, NUM_DOC_ID_NUEVO from EDICION_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/edicionTercerosFallaLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID,TIPO_TERCERO_NUEVO, APELLIDO_NUEVO,NOMBRE_NUEVO, TIPO_DOC_ID_NUEVO, NUM_DOC_ID_NUEVO from EDICION_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/edicionTercerosFallaLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/edicionTercerosFallaLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/edicionTercerosFallaLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
