package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_CajaAperturaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CajaApertura;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 12/12/2016.
 */
public class VistaINTER_CajaAperturaTest {
    private final static Logger log = Logger.getLogger(VistaINTER_CajaAperturaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = INTER_CajaAperturaBean.getINTER_CajaAperturaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            INTER_CajaAperturaBean interCajaAperturaBean = (INTER_CajaAperturaBean) caja.get(j);
            INTER_CajaApertura a = new INTER_CajaApertura();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interCajaAperturaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA_INTER ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCajaApertura_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_CAJA FROM APERTURAR_CAJA_INTER ORDER BY PRUEBA ASC",
                "APERTURAR_CAJA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCajaApertura_dataset.xml");*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCajaApertura_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCajaApertura_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
