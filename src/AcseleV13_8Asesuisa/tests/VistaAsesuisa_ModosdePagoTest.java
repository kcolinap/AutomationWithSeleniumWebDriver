package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModosdePagoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ModosdePago;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 29/03/2017.
 */
public class VistaAsesuisa_ModosdePagoTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_ModosdePagoTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList modoPago = null;

        try {
            modoPago = Asesuisa_ModosdePagoBean.getAsesuisa_ModoPago();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < modoPago.size(); j++) {
            Asesuisa_ModosdePagoBean bean =(Asesuisa_ModosdePagoBean) modoPago.get(j);

            Asesuisa_ModosdePago a = new Asesuisa_ModosdePago();
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

         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MODODEPAGO ORDER BY PRUEBA ASC",
                "ASESUISA_MODODEPAGO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaModosPago_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MODODEPAGO ORDER BY PRUEBA ASC",
                "ASESUISA_MODODEPAGO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaModosPago_dataset"+ num + ".xml");


*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaModosPago_dataset" + num +  ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaModosPago_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
