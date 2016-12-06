package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_PolizaEmisionBeneficiarioNaturalBean;
import AcseleV13_8_Interseguros.main.controller.INTER_PolizaEmisionBeneficiarioNatural;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 01/12/2016.
 */
public class VistaINTER_PolizaEmisionBeneficiarioNaturalTest {

    private final static Logger log = Logger.getLogger(VistaINTER_PolizaEmisionBeneficiarioNaturalTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList polizaEmisionBeneficiarioNatural = null;

        try {
            polizaEmisionBeneficiarioNatural = INTER_PolizaEmisionBeneficiarioNaturalBean.getInter_PolizaEmisionBeneficiarioNatural();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < polizaEmisionBeneficiarioNatural.size(); j++) {
            INTER_PolizaEmisionBeneficiarioNaturalBean inter_polizaEmisionBeneficiarioNaturalBean = (INTER_PolizaEmisionBeneficiarioNaturalBean) polizaEmisionBeneficiarioNatural.get(j);
            INTER_PolizaEmisionBeneficiarioNatural a = new INTER_PolizaEmisionBeneficiarioNatural();

            try {
                a.testLink(inter_polizaEmisionBeneficiarioNaturalBean, j);
            } catch (Exception e) {
                //e.printStackTrace();
                //log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
                e.printStackTrace();
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                sw.toString(); // stack trace as a string
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + sw.toString());
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * FROM INTER_EMISION_BENEF_NATUR ORDER BY PRUEBA ASC",
                "INTER_EMISION_BENEF_NATUR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/inter_polizaEmisionBeneficiarioNatural_dataset.xml");

        DataSetManager.createPartialDataSet("select * FROM INTER_EMISION_BENEF_NATUR ORDER BY PRUEBA ASC",
                "INTER_EMISION_BENEF_NATUR",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/inter_polizaEmisionBeneficiarioNatural_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/inter_polizaEmisionBeneficiarioNatural_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/inter_polizaEmisionBeneficiarioNatural_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}