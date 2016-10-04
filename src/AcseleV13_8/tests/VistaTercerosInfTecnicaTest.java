package AcseleV13_8.tests;

import AcseleV13_8.beans.TercerosInfTecnicaBean;
import AcseleV13_8.main.controller.TercerosInformacionTecnica;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 14/06/2016.
 */
public class VistaTercerosInfTecnicaTest {

    private final static Logger log = Logger.getLogger(VistaTercerosInfTecnicaTest.class);

    @Test
    public void mainTest() {

        ArrayList terceros = null;

        try {
            terceros = TercerosInfTecnicaBean.getConsultaTercerosInfTecnica();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < terceros.size(); i++) {

            TercerosInfTecnicaBean tercerosInfTecnicaBean = (TercerosInfTecnicaBean) terceros.get(i);
            TercerosInformacionTecnica a = new TercerosInformacionTecnica();

            try {
                a.testLink(tercerosInfTecnicaBean, i);
            }catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/tercerosInformacionTecnica_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/tercerosInformacionTecnica_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosInformacionTecnica_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosInformacionTecnica_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
