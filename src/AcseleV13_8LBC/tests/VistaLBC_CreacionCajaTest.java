package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CreacionCajaBean;
import AcseleV13_8LBC.main.controller.LBC_CreacionCaja;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 19/10/2016.
 */
public class VistaLBC_CreacionCajaTest {

    private final static Logger log = Logger.getLogger(VistaLBC_ConsultaSimplePolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = LBC_CreacionCajaBean.getLBC_CrearCajaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            LBC_CreacionCajaBean lbcCrearCajaBean = (LBC_CreacionCajaBean) caja.get(j);
            LBC_CreacionCaja a = new LBC_CreacionCaja();

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

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, descripcion, ubicacion, sucursal FROM CREACION_CAJAS_LBC ORDER BY PRUEBA ASC",
                "CREACION_CAJAS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCreacionCaja_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, descripcion, ubicacion, sucursal FROM CREACION_CAJAS_LBC ORDER BY PRUEBA ASC",
                "CREACION_CAJAS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCreacionCaja_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCreacionCaja_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCreacionCaja_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
