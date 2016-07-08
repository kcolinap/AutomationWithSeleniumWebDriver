package tests;

import beans.BusquedaPolizaAvanzadaBean;
import beans.ConsultaTercerosBean;
import main.controller.ConsultaPolizaAvanzada;
import main.controller.ConsultaTerceros;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 30/05/2016.
 */
public class VistaConsultaTercerosTest {

    @Test
    //@Transactional
    public void mainTest() {

        ConsultaTercerosBean consultaTercerosBean = ConsultaTercerosBean.getConsultaTerceros();
        ConsultaTerceros a = new ConsultaTerceros();
        try {
            a.testLink(consultaTercerosBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/consultaTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/consultaTerceros_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/consultaTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/consultaTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
