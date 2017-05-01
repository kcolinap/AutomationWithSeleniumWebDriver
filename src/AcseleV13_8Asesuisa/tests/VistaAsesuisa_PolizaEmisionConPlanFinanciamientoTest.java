package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionConPlanFinanciamientoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionConPlanFinanciamiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 28/04/2017.
 */
public class VistaAsesuisa_PolizaEmisionConPlanFinanciamientoTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PolizaEmisionConPlanFinanciamientoTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_PolizaEmisionConPlanFinanciamientoBean.getAsesuisa_PolizaEmisionConPlanFinanciamiento();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_PolizaEmisionConPlanFinanciamientoBean bean = (Asesuisa_PolizaEmisionConPlanFinanciamientoBean) terceros.get(j);
            Asesuisa_PolizaEmisionConPlanFinanciamiento a = new Asesuisa_PolizaEmisionConPlanFinanciamiento();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_CON_PLAN_FIN ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_CON_PLAN_FIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaConPlanFinanciamiento_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_CON_PLAN_FIN ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_CON_PLAN_FIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaConPlanFinanciamiento_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaConPlanFinanciamiento_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaConPlanFinanciamiento_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
