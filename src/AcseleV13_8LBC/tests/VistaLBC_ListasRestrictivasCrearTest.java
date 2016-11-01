package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_ListasRestrictivasCrearBean;
import AcseleV13_8LBC.main.controller.LBC_CrearListaRestrictiva;
import AcseleV13_8LBC.main.controller.LBC_ListasRestrictivasCrear;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 31/10/2016.
 */
public class VistaLBC_ListasRestrictivasCrearTest {

    private final static Logger log = Logger.getLogger(VistaLBC_ListasRestrictivasCrearTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList listaRestrictiva = null;

        try {
            listaRestrictiva = LBC_ListasRestrictivasCrearBean.getLBC_ListasRestrictivasCrearBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < listaRestrictiva.size(); i++) {
            LBC_ListasRestrictivasCrearBean lbcListasRestrictivasCrearBean = (LBC_ListasRestrictivasCrearBean) listaRestrictiva.get(i);
            LBC_ListasRestrictivasCrear a = new LBC_ListasRestrictivasCrear();

            try {
                a.testLink(lbcListasRestrictivasCrearBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO, NOMBRE FROM LISTA_RESTRICTIVA_CREAR_LBC ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA_CREAR_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasCrear_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO, NOMBRE FROM LISTA_RESTRICTIVA_CREAR_LBC ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA_CREAR_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasCrear_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasCrear_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcListasRestrictivasCrear_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
