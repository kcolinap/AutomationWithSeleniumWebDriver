package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAVidaIntegralBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionVariosOAVidaIntegral;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 21/02/2017.
 */
public class VistaAsesuisa_PolizaEmisionVariosOAVidaIntegralTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_PolizaEmisionVariosOAVidaIntegralTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Asesuisa_PolizaEmisionVariosOAVidaIntegralBean.getAsesuisa_PolizaEmisionVariosOAVidaIntegral();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_PolizaEmisionVariosOAVidaIntegralBean asesuisaPolizaEmisionVariosOAVidaIntegralBean = (Asesuisa_PolizaEmisionVariosOAVidaIntegralBean) poliza.get(j);
            Asesuisa_PolizaEmisionVariosOAVidaIntegral a = new Asesuisa_PolizaEmisionVariosOAVidaIntegral();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(asesuisaPolizaEmisionVariosOAVidaIntegralBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLIZAEMISION_OA_VID_INTE ORDER BY PRUEBA ASC",
                "ASE_POLIZAEMISION_OA_VID_INTE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosOAVidaIntegral_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLIZAEMISION_OA_VID_INTE ORDER BY PRUEBA ASC",
                "ASE_POLIZAEMISION_OA_VID_INTE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosOAVidaIntegral_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosOAVidaIntegral_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisa_PolizaEmisionVariosOAVidaIntegral_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
