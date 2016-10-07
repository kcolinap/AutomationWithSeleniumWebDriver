package AcseleV13_8.tests;

import AcseleV13_8.beans.AprobarEnviarPagoSiniestrosBean;
import AcseleV13_8.main.controller.AprobarEnviarPagoSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 15/08/2016.
 */
public class VistaAprobarEnviarPagoSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList aprobarEnviarPago = AprobarEnviarPagoSiniestrosBean.getAprobarEnviarPagoSiniestros();

        for (int i = 0; i < aprobarEnviarPago.size(); i++) {
            AprobarEnviarPagoSiniestrosBean aprobarEnviarPagoSiniestrosBean = (AprobarEnviarPagoSiniestrosBean) aprobarEnviarPago.get(i);
            AprobarEnviarPagoSiniestros a = new AprobarEnviarPagoSiniestros();


            try {
                a.testLink(aprobarEnviarPagoSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal, Moneda FROM APROBAR_ENVIAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC",
                "APROBAR_ENVIAR_PAGO_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/aprobarEnviarPagoSiniestros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal, Moneda FROM APROBAR_ENVIAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC",
                "APROBAR_ENVIAR_PAGO_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/aprobarEnviarPagoSiniestros_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/aprobarEnviarPagoSiniestros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/aprobarEnviarPagoSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
