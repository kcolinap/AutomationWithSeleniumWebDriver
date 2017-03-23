package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosURVidaIntegralBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionVariosURVidaIntegral;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 21/03/2017.
 */
public class VistaAsesuisa_PolizaEmisionVariosURVidaIntegralTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_PolizaEmisionVariosURVidaIntegralTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Asesuisa_PolizaEmisionVariosURVidaIntegralBean.getAsesuisa_PolizaEmisionVariosURVidaIntegral();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_PolizaEmisionVariosURVidaIntegralBean bean = (Asesuisa_PolizaEmisionVariosURVidaIntegralBean) poliza.get(j);
            Asesuisa_PolizaEmisionVariosURVidaIntegral a = new Asesuisa_PolizaEmisionVariosURVidaIntegral();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosURVidaIntegral_dataset.xml");

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosURVidaIntegral_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosURVidaIntegral_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosURVidaIntegral_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
