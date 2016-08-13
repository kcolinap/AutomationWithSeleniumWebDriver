package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.RechazarPagoSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.RechazarPagoSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 10/08/2016.
 */
public class VistaRechazarPagoSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList aprobarPago = RechazarPagoSiniestrosBean.getAprobarPagoSiniestros();

        for (int i = 0; i < aprobarPago.size(); i++) {
            RechazarPagoSiniestrosBean rechazarPagoSiniestrosBean = (RechazarPagoSiniestrosBean) aprobarPago.get(i);
            RechazarPagoSiniestros a = new RechazarPagoSiniestros();

            try {
                a.testLink(rechazarPagoSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }


    @Before
    public void setUp() throws Exception {

/*     DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal FROM APROBAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC",
                "APROBAR_PAGO_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xmls/aprobarPagoSiniestros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaSiniestro, Producto, OrdenarPor, FechaCompromiso, FechaInicial, FechaFinal, Razon, Tipo, MontoSiniestro, SeleccioneAccion, Sucursal FROM APROBAR_PAGO_SINIESTROS ORDER BY PRUEBA ASC",
                "APROBAR_PAGO_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Alfa/tests/xmls/aprobarPagoSiniestros_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/aprobarPagoSiniestros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/aprobarPagoSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}

