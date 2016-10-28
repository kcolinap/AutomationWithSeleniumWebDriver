package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_ConsultaListasRestricBean;
import AcseleV13_8LBC.main.controller.LBC_ConsultaListasRestric;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 27/10/2016.
 */
public class VistaLBC_ConsultaListasRestricTest {

    private final static Logger log = Logger.getLogger(VistaLBC_ConsultaAvanzadaPolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList lbcListasRestrictivas = LBC_ConsultaListasRestricBean.getConsultaListasRestric();

        for (int j = 0; j< lbcListasRestrictivas.size(); j++) {
            LBC_ConsultaListasRestricBean lbc_consultaListasRestricBean = (LBC_ConsultaListasRestricBean) lbcListasRestrictivas.get(j);
            LBC_ConsultaListasRestric a = new LBC_ConsultaListasRestric();

            try {
                a.testLink(lbc_consultaListasRestricBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Lista_LBC,Ident_Lista,NomApell_Lista,DocIden_Lista FROM LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcConsultaListasRestric_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Lista_LBC,Ident_Lista,NomApell_Lista,DocIden_Lista FROM LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcConsultaListasRestric_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcConsultaListasRestric_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcConsultaListasRestric_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
