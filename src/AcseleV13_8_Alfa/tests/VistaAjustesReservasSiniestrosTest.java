package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.AjustesReservasSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.AjustesReservasSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 19/09/2016.
 */
public class VistaAjustesReservasSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaAjustesReservasSiniestrosTest.class);

    @Test
    public void mainTest() {

        ArrayList conPago = null;

        try {
            conPago = AjustesReservasSiniestrosBean.getAjustesReservasSiniestros();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < conPago.size(); i++) {

            AjustesReservasSiniestrosBean ajustesReservasSiniestrosBean = (AjustesReservasSiniestrosBean) conPago.get(i);
            AjustesReservasSiniestros a = new AjustesReservasSiniestros();

            try {
                a.testLink(ajustesReservasSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

       /*DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO, TIPO_AJUSTE, RAZON_AJUSTE, MONTO_AJUSTE FROM AJUSTES_RESERVAS_SINIESTROS ORDER BY PRUEBA ASC",
                "AJUSTES_RESERVAS_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele2/src/AcseleV13_8_Alfa/tests/xmls/ajustesReservasSiniestros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO, TIPO_AJUSTE, RAZON_AJUSTE, MONTO_AJUSTE FROM AJUSTES_RESERVAS_SINIESTROS ORDER BY PRUEBA ASC",
                "AJUSTES_RESERVAS_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele2/target/classes/AcseleV13_8_Alfa/tests/xmls/ajustesReservasSiniestros_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/ajustesReservasSiniestros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/ajustesReservasSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
