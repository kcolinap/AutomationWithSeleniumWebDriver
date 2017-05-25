package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionBeneficiarioBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionBeneficiario;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 17/05/2017.
 */
public class VistaAsesuisa_PolizaEmisionBeneficiarioTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PolizaEmisionBeneficiarioTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList poliza = null;

        try {
            poliza = Asesuisa_PolizaEmisionBeneficiarioBean.getAsesuisa_PolizaEmisionBeneficiario();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_PolizaEmisionBeneficiarioBean bean = (Asesuisa_PolizaEmisionBeneficiarioBean) poliza.get(j);
            Asesuisa_PolizaEmisionBeneficiario a = new Asesuisa_PolizaEmisionBeneficiario();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp(String num) throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_BENEFICIARIO ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_BENEFICIARIO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaBeneficiario_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_BENEFICIARIO ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_BENEFICIARIO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaBeneficiario_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaBeneficiario_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaBeneficiario_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
