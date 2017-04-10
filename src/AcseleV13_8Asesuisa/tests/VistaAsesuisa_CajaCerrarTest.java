package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaCerrarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_CajaCerrar;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 03/04/2017.
 */
public class VistaAsesuisa_CajaCerrarTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaCerrarTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaCerrarBean.getAsesuisa_CajaCerrar();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaCerrarBean bean =(Asesuisa_CajaCerrarBean) caja.get(j);

            Asesuisa_CajaCerrar a = new Asesuisa_CajaCerrar();
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
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_APERTURAR_CERRAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_APERTURAR_CERRAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCerrar_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_APERTURAR_CERRAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_APERTURAR_CERRAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCerrar_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCerrar_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaCerrar_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
