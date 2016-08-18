package AcseleV13_8.tests;

import AcseleV13_8.beans.ExportarImportarProductoBean;
import AcseleV13_8.main.controller.ExportarImportarProducto;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 17/08/2016.
 */
public class VistaExportarImportarProductoTest {

    private final static Logger log = Logger.getLogger(VistaExportarImportarProductoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList exportarImportarProducto = ExportarImportarProductoBean.getExportarImportarProducto();

        for (int i = 0; i < exportarImportarProducto.size(); i++) {
            ExportarImportarProductoBean exportarImportarProductoBean = (ExportarImportarProductoBean) exportarImportarProducto.get(i);
            ExportarImportarProducto a = new ExportarImportarProducto();


            try {
                a.testLink(exportarImportarProductoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }



    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, RUTA FROM EXPORTAR_IMPORTAR_PRODUCTO ORDER BY PRUEBA ASC",
                "EXPORTAR_IMPORTAR_PRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/exportarImportarProducto_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, RUTA FROM EXPORTAR_IMPORTAR_PRODUCTO ORDER BY PRUEBA ASC",
                "EXPORTAR_IMPORTAR_PRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/exportarImportarProducto_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/exportarImportarProducto_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }


    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/exportarImportarProducto_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}

