package AcseleV13_8.tests;

import AcseleV13_8.beans.TrazaAuditoriaExportarBean;
import AcseleV13_8.main.controller.TrazaAuditoriaExportar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 23/09/2016.
 */
public class VistaTrazaAuditoriaExportarTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList trazaAuditoriaExportar = TrazaAuditoriaExportarBean.getTrazaAuditoriaExportar();

        for (int i = 0; i < trazaAuditoriaExportar.size(); i++) {
            TrazaAuditoriaExportarBean trazaAuditoriaExportarBean = (TrazaAuditoriaExportarBean) trazaAuditoriaExportar.get(i);
            TrazaAuditoriaExportar a = new TrazaAuditoriaExportar();


            try {
                a.testLink(trazaAuditoriaExportarBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

     /*   DataSetManager.createPartialDataSet("SELECT PRUEBA, Fecha_Desde, Fecha_hasta FROM Export_Documentos_Traza ORDER BY PRUEBA ASC",
                "Export_Documentos_Traza",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/exportDocumentosTraza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, Fecha_Desde, Fecha_hasta FROM Export_Documentos_Traza ORDER BY PRUEBA ASC",
                "Export_Documentos_Traza",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/exportDocumentosTraza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/exportDocumentosTraza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/exportDocumentosTraza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
