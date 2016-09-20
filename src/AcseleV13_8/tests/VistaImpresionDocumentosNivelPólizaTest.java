package AcseleV13_8.tests;

import AcseleV13_8.beans.ImpresionDocumentosNivelPólizaBean;
import AcseleV13_8.main.controller.ImpresionDocumentosNivelPóliza;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 16/09/2016.
 */
public class VistaImpresionDocumentosNivelPólizaTest {

    private final static Logger log = Logger.getLogger(VistaTercerosDocumentosTest.class);

    @Test
    public void mainTest() {

        ArrayList impDocPoliza = null;

        try {
            impDocPoliza = ImpresionDocumentosNivelPólizaBean.getImpresionDocNivelPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for(int i = 0; i < impDocPoliza.size(); i++) {

            ImpresionDocumentosNivelPólizaBean impresionDocumentosNivelPólizaBean = (ImpresionDocumentosNivelPólizaBean) impDocPoliza.get(i);
            ImpresionDocumentosNivelPóliza a = new ImpresionDocumentosNivelPóliza();

            try {
                a.testLink(impresionDocumentosNivelPólizaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/impresionDocumentosNivelPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/impresionDocumentosNivelPoliza_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/impresionDocumentosNivelPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/impresionDocumentosNivelPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
