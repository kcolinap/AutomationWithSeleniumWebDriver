package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaCrearBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_CajaCrear;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 29/03/2017.
 */
public class VistaAsesuisa_CajaCrearTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaCrearTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaCrearBean.getAsesuisa_CajaCrear();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaCrearBean bean =(Asesuisa_CajaCrearBean) caja.get(j);

            Asesuisa_CajaCrear a = new Asesuisa_CajaCrear();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_CREAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_CREAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCrear_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_CREAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_CREAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCrear_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCrear_dataset" +  ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCrear_dataset" + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
