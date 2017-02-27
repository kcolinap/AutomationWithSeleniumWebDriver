package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCrearBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosCrear;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 27/02/2017.
 */
public class VistaAsesuisa_TercerosCrearTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosCrearTest.class);

    @Before
    public void setUp() throws Exception {
/*

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCEROS_CREAR ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_CREAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCrear_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCEROS_CREAR ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_CREAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCrear_dataset.xml");

*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCrear_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException {
        ArrayList asesuisaTercerosCrear = null;

        try {
            asesuisaTercerosCrear = Asesuisa_TercerosCrearBean.getTercerosCrearBean();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < asesuisaTercerosCrear.size(); j++) {
            Asesuisa_TercerosCrearBean asesuisaTercerosCrearBean = (Asesuisa_TercerosCrearBean) asesuisaTercerosCrear.get(j);
            Asesuisa_TercerosCrear a = new Asesuisa_TercerosCrear();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
               a.testLink(asesuisaTercerosCrearBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCrear_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
