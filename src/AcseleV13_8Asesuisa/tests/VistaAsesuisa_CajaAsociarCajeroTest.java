package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAsociarCajeroBean;
import AcseleV13_8Asesuisa.main.controller.polizaEmision.Asesuisa_CajaAsociarCajero;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 30/03/2017.
 */
public class VistaAsesuisa_CajaAsociarCajeroTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaAsociarCajeroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaAsociarCajeroBean.getAsesuisa_CajaAsociarCajero();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaAsociarCajeroBean bean =(Asesuisa_CajaAsociarCajeroBean) caja.get(j);

            Asesuisa_CajaAsociarCajero a = new Asesuisa_CajaAsociarCajero();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {
/*
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_ASOCIAR_CAJERO ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_ASOCIAR_CAJERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset1.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_ASOCIAR_CAJERO ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_ASOCIAR_CAJERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset1.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
