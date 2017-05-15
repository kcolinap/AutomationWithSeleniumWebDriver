package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaFactAgrupBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_CajaFactAgrup;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 26/04/2017.
 */
public class VistaAsesuisa_CajaFactAgrupTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaFactAgrupTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaFactAgrupBean.getAsesuisa_CajaFactAgrup();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaFactAgrupBean bean =(Asesuisa_CajaFactAgrupBean) caja.get(j);

            Asesuisa_CajaFactAgrup a = new Asesuisa_CajaFactAgrup();
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
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_FACTAGRUP ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_FACTAGRUP",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaFactAgrup_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_FACTAGRUP ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_FACTAGRUP",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaFactAgrup_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaFactAgrup_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaFactAgrup_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
