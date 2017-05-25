package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionTomadoresBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionTomadores;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 16/05/2017.
 */
public class VistaAsesuisa_PolizaEmisionTomadoresTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PolizaEmisionTomadoresTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList poliza = null;

        try {
            poliza = Asesuisa_PolizaEmisionTomadoresBean.getAsesuisa_PolizaEmisionTomadores();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_PolizaEmisionTomadoresBean bean = (Asesuisa_PolizaEmisionTomadoresBean) poliza.get(j);
            Asesuisa_PolizaEmisionTomadores a = new Asesuisa_PolizaEmisionTomadores();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_TOMADORES ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaTomadores_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_TOMADORES ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaTomadores_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaTomadores_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaTomadores_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
