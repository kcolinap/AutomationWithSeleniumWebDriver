package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CajaCierreBean;
import AcseleV13_8LBC.main.controller.LBC_CajaCierre;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/10/2016.
 */
public class VistaLBC_CajaCierreTest {

    private final static Logger log = Logger.getLogger(VistaLBC_CajaCierreTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = LBC_CajaCierreBean.getLBC_CajaCierreBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            LBC_CajaCierreBean lbcCajaAperturaBean = (LBC_CajaCierreBean) caja.get(j);
            LBC_CajaCierre a = new LBC_CajaCierre();

            try {
                a.testLink(lbcCajaAperturaBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM CERRAR_CAJA_LBC ORDER BY PRUEBA ASC",
                "CERRAR_CAJA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCajaCierre_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM CERRAR_CAJA_LBC ORDER BY PRUEBA ASC",
                "CERRAR_CAJA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCajaCierre_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCajaCierre_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCajaCierre_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
