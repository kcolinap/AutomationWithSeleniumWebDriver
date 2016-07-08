package tests;

import beans.EstadoCuentasBean;
import beans.RenovacionPolizaBean;
import main.controller.EstadoCuentas;
import main.controller.RenovacionPolizas;
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
                "C:/AcseleTests/AutomationTestAcsele/src/tests/estadoCuentas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA",
                "ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/estadoCuentas_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/estadoCuentas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        //DataSetManager.loadDataSet("/tests/estadoCuentas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
