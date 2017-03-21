package AcseleV13_8_Rimac.tests;

import AcseleV13_8_Rimac.beans.Rimac_ExportProductoBean;
import AcseleV13_8_Rimac.main.controller.Rimac_ExportProducto;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/03/2017.
 */
public class VistaRimac_ExportProductoBeanTest {

    private final static Logger log = Logger.getLogger(VistaRimac_ImportProductoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList producto = null;

        try {
            producto = Rimac_ExportProductoBean.getRimac_ExportProducto();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < producto.size(); j++) {
            Rimac_ExportProductoBean exportProductoBean = (Rimac_ExportProductoBean) producto.get(0);
            Rimac_ExportProducto a = new Rimac_ExportProducto();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(exportProductoBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM IMPORT_PRODUCTO_RIMAC ORDER BY PRUEBA ASC",
                "IMPORT_PRODUCTO_RIMAC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Rimac/tests/xmls/rimacExportProducto_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM IMPORT_PRODUCTO_RIMAC ORDER BY PRUEBA ASC",
                "IMPORT_PRODUCTO_RIMAC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Rimac/tests/xmls/rimacExportProducto_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacExportProducto_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacExportProducto_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
