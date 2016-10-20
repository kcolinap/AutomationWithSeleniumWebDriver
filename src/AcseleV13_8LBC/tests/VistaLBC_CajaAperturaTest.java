package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CajaAperturaBean;
import AcseleV13_8LBC.main.controller.LBC_CajaApertura;
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
public class VistaLBC_CajaAperturaTest {

    private final static Logger log = Logger.getLogger(VistaLBC_CajaAperturaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = LBC_CajaAperturaBean.getLBC_CajaAperturaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            LBC_CajaAperturaBean lbcCajaAperturaBean = (LBC_CajaAperturaBean) caja.get(j);
            LBC_CajaApertura a = new LBC_CajaApertura();

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

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA_LBC ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCajaApertura_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA_LBC ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCajaApertura_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCajaApertura_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCajaApertura_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
