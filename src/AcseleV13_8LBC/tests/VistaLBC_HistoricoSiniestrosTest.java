package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_HistoricoSiniestrosBean;
import AcseleV13_8LBC.main.controller.LBC_HistoricoSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 22/10/2016.
 */
public class VistaLBC_HistoricoSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaLBC_HistoricoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList historicoSiniestrosLBC = LBC_HistoricoSiniestrosBean.getHistoricoSiniestrosLBCBean();

        for (int j = 0; j< historicoSiniestrosLBC.size(); j++) {
            LBC_HistoricoSiniestrosBean lbcHistoricoSiniestrosBean = (LBC_HistoricoSiniestrosBean) historicoSiniestrosLBC.get(j);
            LBC_HistoricoSiniestros a = new LBC_HistoricoSiniestros();

            try {
                a.testLink(lbcHistoricoSiniestrosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba, Numero_Reclamo from HIST_RECLAMOS_LBC ORDER BY PRUEBA ASC",
                "HIST_RECLAMOS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/historicoSiniestrosLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba, Numero_Reclamo from HIST_RECLAMOS_LBC ORDER BY PRUEBA ASC",
                "HIST_RECLAMOS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/historicoSiniestrosLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/historicoSiniestrosLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/historicoSiniestrosLBC.xml", DataSetManager.DELETE_OPERATION);
    }


}
