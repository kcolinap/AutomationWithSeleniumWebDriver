package AcseleV13_8.tests;

import AcseleV13_8.beans.EdicionTercerosFallaBean;
import AcseleV13_8.main.controller.EdicionTerceroFalla;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 31/05/2016.
 */
public class VistaEdicionTercerosFallaTest {

    private final static Logger log = Logger.getLogger(VistaEdicionTercerosFallaTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList edicionTercerosFalla = null;

        try {
            edicionTercerosFalla = EdicionTercerosFallaBean.getEdicionTercerosFalla();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < edicionTercerosFalla.size(); i++) {

            EdicionTercerosFallaBean edicionTercerosFallaBean = (EdicionTercerosFallaBean) edicionTercerosFalla.get(i);
            EdicionTerceroFalla a = new EdicionTerceroFalla();

            try {
                a.testLink(edicionTercerosFallaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, CEDULA_NUEVO from EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/edicionTercerosFalla_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, CEDULA_NUEVO from EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/edicionTercerosFalla_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/edicionTercerosFalla_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/edicionTercerosFalla_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
