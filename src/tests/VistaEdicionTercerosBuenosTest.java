package tests;

import beans.ConsultaTercerosBean;
import beans.EdicionTercerosBuenosBean;
import main.controller.ConsultaTerceros;
import main.controller.EdicionTerceroBueno;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 31/05/2016.
 */
public class VistaEdicionTercerosBuenosTest {

    @Test
    //@Transactional
    public void mainTest() {

        EdicionTercerosBuenosBean edicionTercerosBuenosBean = EdicionTercerosBuenosBean.getEdicionTercerosBuenos();
        EdicionTerceroBueno a = new EdicionTerceroBueno();
        try {
            a.testLink(edicionTercerosBuenosBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, NOMBRE_NUEVO, APELLIDO_NUEVO from EDICION_TERCEROS where prueba = 1",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/edicionTercerosBuenos_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, NOMBRE_NUEVO, APELLIDO_NUEVO from EDICION_TERCEROS where prueba = 1",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/edicionTercerosBuenos_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/edicionTercerosBuenos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/edicionTercerosBuenos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
