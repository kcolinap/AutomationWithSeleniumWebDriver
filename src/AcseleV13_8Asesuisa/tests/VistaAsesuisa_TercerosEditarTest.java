package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCrearBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosEditarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosEditar;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 17/04/2017.
 */
public class VistaAsesuisa_TercerosEditarTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosEditarTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_TercerosEditarBean.getAsesuisa_TercerosEditar();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_TercerosEditarBean bean = (Asesuisa_TercerosEditarBean) terceros.get(j);
            Asesuisa_TercerosEditar a = new Asesuisa_TercerosEditar();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_EDITAR ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_EDITAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditar_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_EDITAR ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_EDITAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditar_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditar_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditar_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
