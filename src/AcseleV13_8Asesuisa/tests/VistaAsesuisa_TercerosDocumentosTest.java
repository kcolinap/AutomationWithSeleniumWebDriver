package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosDocumentosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosDocumentos;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/04/2017.
 */
public class VistaAsesuisa_TercerosDocumentosTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosDocumentosTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_TercerosDocumentosBean.getAsesuisa_TercerosDocumentos();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_TercerosDocumentosBean bean = (Asesuisa_TercerosDocumentosBean) terceros.get(j);
            Asesuisa_TercerosDocumentos a = new Asesuisa_TercerosDocumentos();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_DOCUMENTO ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_DOCUMENTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDocumentos_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCERO_DOCUMENTO ORDER BY PRUEBA ASC",
                "ASESUISA_TERCERO_DOCUMENTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDocumentos_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDocumentos_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDocumentos_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
