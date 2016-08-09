package AcseleV13_8.tests;

import AcseleV13_8.beans.ConsultaTercerosBean;
import AcseleV13_8.main.controller.ConsultaTerceros;
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
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/consultaTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/consultaTerceros_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
