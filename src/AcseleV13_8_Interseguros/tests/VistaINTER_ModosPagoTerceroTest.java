package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ModosPagoTerceroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ModosPagoTercero;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/01/2017.
 */
public class VistaINTER_ModosPagoTerceroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ModosPagoTerceroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList ModosPagoTerceroBean = INTER_ModosPagoTerceroBean.getINTER_ModosPagoTerceroBean();

        for (int j = 0; j< ModosPagoTerceroBean.size(); j++) {
            INTER_ModosPagoTerceroBean interModosPagoTerceroBean = (INTER_ModosPagoTerceroBean) ModosPagoTerceroBean.get(j);
            INTER_ModosPagoTercero a = new INTER_ModosPagoTercero();

            try {
                a.testLink(interModosPagoTerceroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
/*
        DataSetManager.createPartialDataSet("select PRUEBA, NUM_DOC_IDENTIDAD,APELLIDO,NOMBRE,MODO_PAGO,EVALUACION_RIESGO,EMISOR_DE_TARJETA,TIPO_CUENTA,COLECTOR,SUCURSAL,TIPO_TERCERO from MODOS_PAGO_TERCERO_INTER ORDER BY PRUEBA ASC",
                "MODOS_PAGO_TERCERO_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interModosPagoTercero_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, NUM_DOC_IDENTIDAD,APELLIDO,NOMBRE,MODO_PAGO,EVALUACION_RIESGO,EMISOR_DE_TARJETA,TIPO_CUENTA,COLECTOR,SUCURSAL,TIPO_TERCERO from MODOS_PAGO_TERCERO_INTER ORDER BY PRUEBA ASC",
                "MODOS_PAGO_TERCERO_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interModosPagoTercero_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interModosPagoTercero_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interModosPagoTercero_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
