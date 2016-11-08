package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_ModosPagoTerceroBean;
import AcseleV13_8LBC.main.controller.LBC_ModosPagoTercero;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 03/11/2016.
 */
public class VistaLBC_ModosPagoTerceroTest {

    private final static Logger log = Logger.getLogger(VistaLBC_ConsultaTercerosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList ModosPagoTerceroBean = LBC_ModosPagoTerceroBean.getLBC_ModosPagoTerceroBean();

        for (int j = 0; j< ModosPagoTerceroBean.size(); j++) {
            LBC_ModosPagoTerceroBean lbc_ModosPagoTerceroBean = (LBC_ModosPagoTerceroBean) ModosPagoTerceroBean.get(j);
            LBC_ModosPagoTercero a = new LBC_ModosPagoTercero();

            try {
                a.testLink(lbc_ModosPagoTerceroBean, j);
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
        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID  from LBC_MODOS_PAGO_TERCERO ORDER BY PRUEBA ASC",
                "LBC_MODOS_PAGO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/LBC_Modos_Pago_Tercero_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID  from LBC_MODOS_PAGO_TERCERO ORDER BY PRUEBA ASC",
                "LBC_MODOS_PAGO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/LBC_Modos_Pago_Tercero_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_Modos_Pago_Tercero_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_Modos_Pago_Tercero_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
