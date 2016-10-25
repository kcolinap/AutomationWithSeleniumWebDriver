package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_EstadoCuentasBean;
import AcseleV13_8LBC.main.controller.LBC_EstadoCuentas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 11/10/2016.
 */
public class VistaLBC_EstadoCuentasTest {

    private final static Logger log = Logger.getLogger(VistaLBC_EstadoCuentasTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList estadoCuentasLBC = LBC_EstadoCuentasBean.getEstadoCuentasLBC();

        for (int i = 0; i < estadoCuentasLBC.size(); i++) {

            LBC_EstadoCuentasBean lbcEstadoCuentasBean = (LBC_EstadoCuentasBean) estadoCuentasLBC.get(i);
            LBC_EstadoCuentas a = new LBC_EstadoCuentas();

            try {
                a.testLink(lbcEstadoCuentasBean, i);
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

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTAS_LBC",
                "ESTADO_CUENTAS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/estadoCuentasLBC_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, NUM_DOCUMENTO_IDENTIFICACION, PRIMER_NOMBRE, PRIMER_APELLIDO, NUM_POLIZA, MONEDA, PRODUCTO FROM ESTADO_CUENTAS_LBC",
                "ESTADO_CUENTAS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/estadoCuentasLBC_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/estadoCuentasLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/estadoCuentasLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
