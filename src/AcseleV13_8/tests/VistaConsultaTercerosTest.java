package AcseleV13_8.tests;

import AcseleV13_8.beans.ConsultaTercerosBean;
import AcseleV13_8.main.controller.ConsultaTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 30/05/2016.
 */
public class VistaConsultaTercerosTest {

    private final static Logger log = Logger.getLogger(VistaConsultaTercerosTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList consultaTerceros = null;

        try {
            consultaTerceros = ConsultaTercerosBean.getConsultaTerceros();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < consultaTerceros.size(); i++) {

            ConsultaTercerosBean consultaTercerosBean = (ConsultaTercerosBean) consultaTerceros.get(i);
            ConsultaTerceros a = new ConsultaTerceros();

            try {
                a.testLink(consultaTercerosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO FROM ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO FROM ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
