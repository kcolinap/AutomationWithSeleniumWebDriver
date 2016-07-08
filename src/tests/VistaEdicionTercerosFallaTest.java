package tests;

import beans.EdicionTercerosFallaBean;
import main.controller.EdicionTerceroFalla;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 31/05/2016.
 */
public class VistaEdicionTercerosFallaTest {

    @Test
    //@Transactional
    public void mainTest() {

        EdicionTercerosFallaBean edicionTercerosFallaBean = EdicionTercerosFallaBean.getEdicionTercerosFalla();
        EdicionTerceroFalla a = new EdicionTerceroFalla();
        try {
            a.testLink(edicionTercerosFallaBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, CEDULA_NUEVO from EDICION_TERCEROS where prueba = 2",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/edicionTercerosFalla_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, CEDULA_NUEVO from EDICION_TERCEROS where prueba = 2",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/edicionTercerosFalla_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/edicionTercerosFalla_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/edicionTercerosFalla_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
