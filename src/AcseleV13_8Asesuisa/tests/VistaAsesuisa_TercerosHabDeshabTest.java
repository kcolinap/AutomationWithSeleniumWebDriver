package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosHabDeshabBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosHabDeshab;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 25/04/2017.
 */
public class VistaAsesuisa_TercerosHabDeshabTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosHabDeshabTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_TercerosHabDeshabBean.getAsesuisa_TercerosHabDeshab();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_TercerosHabDeshabBean bean = (Asesuisa_TercerosHabDeshabBean) terceros.get(j);
            Asesuisa_TercerosHabDeshab a = new Asesuisa_TercerosHabDeshab();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_HAB_DES ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_HAB_DES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabDeshab_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_HAB_DES ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_HAB_DES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabDeshab_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabDeshab_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabDeshab_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
