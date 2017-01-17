package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_CancelarPagosBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CancelarPagos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 16/01/2017.
 */
public class VistaINTER_CancelarPagosTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CancelarPagosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interCancelarPagos = INTER_CancelarPagosBean.getINTER_CancelarPagos();

        for (int j = 0; j< interCancelarPagos.size(); j++) {
            INTER_CancelarPagosBean inter_cancelarPagosBean  = (INTER_CancelarPagosBean) interCancelarPagos.get(j);
            INTER_CancelarPagos a = new INTER_CancelarPagos();

            try {
                a.testLink(inter_cancelarPagosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from INTER_CANCELAR_PAGO ORDER BY PRUEBA ASC",
                "INTER_CANCELAR_PAGO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCancelarPago_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_CANCELAR_PAGO ORDER BY PRUEBA ASC",
                "INTER_CANCELAR_PAGO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCancelarPago_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCancelarPago_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCancelarPago_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
