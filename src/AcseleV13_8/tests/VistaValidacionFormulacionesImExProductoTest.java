package AcseleV13_8.tests;

import AcseleV13_8.beans.ValidacionFormulacionesImExProductoBean;
import AcseleV13_8.main.controller.ValidacionFormulacionesImExProducto;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 22/08/2016.
 */
public class VistaValidacionFormulacionesImExProductoTest {

    private final static Logger log = Logger.getLogger(VistaUsoTablasDinamicasImportadasTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tablasDinamicas = ValidacionFormulacionesImExProductoBean.getValidacionFormulacionesImExProducto();

        for (int i = 0; i < tablasDinamicas.size(); i++){
            ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean = (ValidacionFormulacionesImExProductoBean) tablasDinamicas.get(i);
            ValidacionFormulacionesImExProducto a = new ValidacionFormulacionesImExProducto();

            try {
                a.testLink(validacionFormulacionesImExProductoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, FORMULA FROM VALIDACION_FORMULACIONES ORDER BY PRUEBA ASC",
                "VALIDACION_FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/validacionFormulaciones_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, FORMULA FROM VALIDACION_FORMULACIONES ORDER BY PRUEBA ASC",
                "VALIDACION_FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/validacionFormulaciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/validacionFormulaciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/validacionFormulaciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
