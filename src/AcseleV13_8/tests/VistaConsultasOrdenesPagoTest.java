package AcseleV13_8.tests;

import AcseleV13_8.beans.ConsultasOrdenesPagoBean;
import AcseleV13_8.main.controller.ConsultasOrdenesPago;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 14/09/2016.
 */
public class VistaConsultasOrdenesPagoTest {

    private final static Logger log = Logger.getLogger(VistaConsultasOrdenesPagoTest.class);

    @Test
    public void mainTest() {

        ArrayList conPago = null;

        try {
            conPago = ConsultasOrdenesPagoBean.getConsultaOrdenesPago();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < conPago.size(); i++) {

            ConsultasOrdenesPagoBean consultasOrdenesPagoBean = (ConsultasOrdenesPagoBean) conPago.get(i);
            ConsultasOrdenesPago a = new ConsultasOrdenesPago();

            try {
               a.testLink(consultasOrdenesPagoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

       /*DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO FROM CONSULTAS_ORDENES_PAGO ORDER BY PRUEBA ASC",
                "CONSULTAS_ORDENES_PAGO",
                "C:/AcseleTests/AutomationTestAcsele2/src/AcseleV13_8/tests/xmls/consultasOrdenesPago_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO FROM CONSULTAS_ORDENES_PAGO ORDER BY PRUEBA ASC",
                "CONSULTAS_ORDENES_PAGO",
                "C:/AcseleTests/AutomationTestAcsele2/target/classes/AcseleV13_8/tests/xmls/consultasOrdenesPago_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultasOrdenesPago_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultasOrdenesPago_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
