package AcseleV13_8.tests;

import AcseleV13_8.beans.TrazaDetalleAuditoriaCajaBean;
import AcseleV13_8.main.controller.TrazaDetalleAuditoriaCaja;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 21/09/2016.
 */
public class VistaTrazaDetalleAuditoriaCajaTest {


    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList trazaDetalleAuditoriaCaja = TrazaDetalleAuditoriaCajaBean.getTrazaDetalleAuditoriaCaja();

        for (int i = 0; i < trazaDetalleAuditoriaCaja.size(); i++) {
            TrazaDetalleAuditoriaCajaBean trazaDetalleAuditoriaCajaBean = (TrazaDetalleAuditoriaCajaBean) trazaDetalleAuditoriaCaja.get(i);
            TrazaDetalleAuditoriaCaja  a = new TrazaDetalleAuditoriaCaja();


            try {
                a.testLink(trazaDetalleAuditoriaCajaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

    /*    DataSetManager.createPartialDataSet("SELECT PRUEBA, Nro_Caja, Tipo_Traza,  Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Apertura_Caja_Traza ORDER BY PRUEBA ASC",
                "Apertura_Caja_Traza",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/aperturaCajaTraza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, Nro_Caja, Tipo_Traza,  Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Apertura_Caja_Traza ORDER BY PRUEBA ASC",
                "Apertura_Caja_Traza",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/aperturaCajaTraza_dataset.xml");
    */
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/aperturaCajaTraza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/aperturaCajaTraza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
