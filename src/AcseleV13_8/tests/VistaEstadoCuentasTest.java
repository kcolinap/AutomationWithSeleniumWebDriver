package AcseleV13_8.tests;

import AcseleV13_8.beans.EstadoCuentasBean;
import AcseleV13_8.main.controller.EstadoCuentas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 27/05/2016.
 */
public class VistaEstadoCuentasTest {

    @Test
    //@Transactional
    public void mainTest() {

        EstadoCuentasBean estadoCuentasBean = EstadoCuentasBean.getEstadoCuentas();
        EstadoCuentas a = new EstadoCuentas();
        try {
            a.testLink(estadoCuentasBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA",
                "ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA",
                "ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/estadoCuentas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        //DataSetManager.loadDataSet("/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
