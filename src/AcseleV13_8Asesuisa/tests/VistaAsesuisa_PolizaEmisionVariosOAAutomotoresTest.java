package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionVariosOAAutomotoresBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionVariosOAAutomotores;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 10/05/2017.
 */
public class VistaAsesuisa_PolizaEmisionVariosOAAutomotoresTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PolizaEmisionVariosOAAutomotoresTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_PolizaEmisionVariosOAAutomotoresBean.getAsesuisa_PolizaEmisionVariosOAAutomotores();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_PolizaEmisionVariosOAAutomotoresBean bean = (Asesuisa_PolizaEmisionVariosOAAutomotoresBean) terceros.get(j);
            Asesuisa_PolizaEmisionVariosOAAutomotores a = new Asesuisa_PolizaEmisionVariosOAAutomotores();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_VARIOS_OA ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_VARIOS_OA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaVariosOAAutomotores_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLI_EMISION_VARIOS_OA ORDER BY PRUEBA ASC",
                "ASE_POLI_EMISION_VARIOS_OA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaVariosOAAutomotores_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaVariosOAAutomotores_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEmisionPolizaVariosOAAutomotores_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
