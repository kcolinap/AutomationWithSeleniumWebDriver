package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CrearListaRestrictivaBean;
import AcseleV13_8LBC.main.controller.LBC_CrearListaRestrictiva;
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
public class VistaLBC_CrearListaRestrictivaTest {

    private final static Logger log = Logger.getLogger(VistaLBC_CrearListaRestrictivaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList listaRestrictiva = null;

        try {
            listaRestrictiva = LBC_CrearListaRestrictivaBean.getLBC_CrearListaRestrictivaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < listaRestrictiva.size(); j++) {
            LBC_CrearListaRestrictivaBean lbcCrearCajaBean = (LBC_CrearListaRestrictivaBean) listaRestrictiva.get(j);
            LBC_CrearListaRestrictiva a = new LBC_CrearListaRestrictiva();

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
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCrearListaRestrictiva_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO, NOMBRE FROM CREAR_LISTA_RESTRICTIVA_LBC ORDER BY PRUEBA ASC",
                "CREAR_LISTA_RESTRICTIVA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCrearListaRestrictiva_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCrearListaRestrictiva_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCrearListaRestrictiva_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
