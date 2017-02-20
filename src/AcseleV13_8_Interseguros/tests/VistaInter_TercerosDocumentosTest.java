package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_TercerosDocumentosBean;
import AcseleV13_8_Interseguros.main.controller.Inter_TercerosDocumentos;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 26/01/2017.
 */
public class VistaInter_TercerosDocumentosTest {

    private final static Logger log = Logger.getLogger(VistaInter_TercerosDocumentosTest.class);

    @Test
    public void mainTest() {

        ArrayList dirTerceros = null;

        try {
            dirTerceros = Inter_TercerosDocumentosBean.getInter_TercerosDocumentos();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < dirTerceros.size(); i++) {

            Inter_TercerosDocumentosBean interTercerosDocumentosBean = (Inter_TercerosDocumentosBean) dirTerceros.get(i);
            Inter_TercerosDocumentos a = new Inter_TercerosDocumentos();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interTercerosDocumentosBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM INTER_TERCEROS_DOCUMENTOS ORDER BY PRUEBA ASC",
                "INTER_TERCEROS_DOCUMENTOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosDocumentos_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM INTER_TERCEROS_DOCUMENTOS ORDER BY PRUEBA ASC",
                "INTER_TERCEROS_DOCUMENTOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosDocumentos_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDocumentos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDocumentos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
