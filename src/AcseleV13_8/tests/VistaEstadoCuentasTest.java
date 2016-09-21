package AcseleV13_8.tests;

import AcseleV13_8.beans.EstadoCuentasBean;
import AcseleV13_8.main.controller.EstadoCuentas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 27/05/2016.
 */
public class VistaEstadoCuentasTest {

    private final static Logger log = Logger.getLogger(VistaEstadoCuentasTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList estadoCuentas = EstadoCuentasBean.getEstadoCuentas();

        for (int i = 0; i < estadoCuentas.size(); i++) {

            EstadoCuentasBean estadoCuentasBean = (EstadoCuentasBean) estadoCuentas.get(i);
            EstadoCuentas a = new EstadoCuentas();

            try {
                a.testLink(estadoCuentasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

/*        EstadoCuentasBean estadoCuentasBean = EstadoCuentasBean.getEstadoCuentas();
        EstadoCuentas a = new EstadoCuentas();
        try {
            a.testLink(estadoCuentasBean, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA",
                "ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTA",
                "ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/estadoCuentas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        //DataSetManager.loadDataSet("/AcseleV13_8.tests.xmls/estadoCuentas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
