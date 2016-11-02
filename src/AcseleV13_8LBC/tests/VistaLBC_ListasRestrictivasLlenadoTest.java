package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_ListasRestrictivasLlenadoBean;
import AcseleV13_8LBC.main.controller.LBC_ListasRestrictivasLlenado;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 25/10/2016.
 */
public class VistaLBC_ListasRestrictivasLlenadoTest {

    private final static Logger log = Logger.getLogger(VistaLBC_ListasRestrictivasLlenadoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList listaRestrictiva = null;

        try {
            listaRestrictiva = LBC_ListasRestrictivasLlenadoBean.getLBC_CrearListaRestrictivaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < listaRestrictiva.size(); j++) {
            LBC_ListasRestrictivasLlenadoBean lbcCrearCajaBean = (LBC_ListasRestrictivasLlenadoBean) listaRestrictiva.get(j);
            LBC_ListasRestrictivasLlenado a = new LBC_ListasRestrictivasLlenado();

            try {
                a.testLink(lbcCrearCajaBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO, NOMBRE FROM CREAR_LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC",
                "CREAR_LISTA_RESTRICTIVA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasLlenado_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO, NOMBRE FROM CREAR_LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC",
                "CREAR_LISTA_RESTRICTIVA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasLlenado_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasLlenado_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasLlenado_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
