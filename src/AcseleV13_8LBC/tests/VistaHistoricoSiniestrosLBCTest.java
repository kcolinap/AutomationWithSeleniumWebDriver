package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.HistoricoSiniestrosLBCBean;
import AcseleV13_8LBC.main.controller.HistoricoSiniestrosLBC;
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
public class VistaHistoricoSiniestrosLBCTest {

    private final static Logger log = Logger.getLogger(VistaHistoricoSiniestrosLBCTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList historicoSiniestrosLBC = HistoricoSiniestrosLBCBean.getHistoricoSiniestrosLBCBean();

        for (int j = 0; j< historicoSiniestrosLBC.size(); j++) {
            HistoricoSiniestrosLBCBean historicoSiniestrosLBCBean = (HistoricoSiniestrosLBCBean) historicoSiniestrosLBC.get(j);
            HistoricoSiniestrosLBC a = new HistoricoSiniestrosLBC();

            try {
                a.testLink(historicoSiniestrosLBCBean, j);
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
