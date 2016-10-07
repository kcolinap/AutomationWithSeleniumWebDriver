package AcseleV13_8.tests;

import AcseleV13_8.beans.ImportExportTablasDinamicasBean;
import AcseleV13_8.main.controller.ImportExportTablasDinamicas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 13/08/2016.
 */
public class VistaImportExportTablasDinamicasTest {

    private final static Logger log = Logger.getLogger(VistaImportExportTablasDinamicasTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emision = ImportExportTablasDinamicasBean.getImportExportTablasDinamicas();

        for (int i = 0; i < emision.size(); i++){
            ImportExportTablasDinamicasBean importExportTablasDinamicasBean = (ImportExportTablasDinamicasBean) emision.get(i);
            ImportExportTablasDinamicas a = new ImportExportTablasDinamicas();

            try {
                a.testLink(importExportTablasDinamicasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, FORMATO, RUTA_TABLA_DINAMICA FROM IMPORT_EXPORT_TABLA_DINAMICA ORDER BY PRUEBA ASC",
                "IMPORT_EXPORT_TABLA_DINAMICA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/imporExportTablasDinamicas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, FORMATO, RUTA_TABLA_DINAMICA FROM IMPORT_EXPORT_TABLA_DINAMICA ORDER BY PRUEBA ASC",
                "IMPORT_EXPORT_TABLA_DINAMICA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/imporExportTablasDinamicas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/imporExportTablasDinamicas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/imporExportTablasDinamicas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
    
}
