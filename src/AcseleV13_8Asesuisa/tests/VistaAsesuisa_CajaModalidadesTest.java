package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaModalidadesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_CajaModalidades;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 12/04/2017.
 */
public class VistaAsesuisa_CajaModalidadesTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaModalidadesTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaModalidadesBean.getAsesuisa_CajaModalidades();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaModalidadesBean bean =(Asesuisa_CajaModalidadesBean) caja.get(j);

            Asesuisa_CajaModalidades a = new Asesuisa_CajaModalidades();
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
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_MODALIDADES ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_MODALIDADES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaModalidades_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_MODALIDADES ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_MODALIDADES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaModalidades_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaModalidades_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaModalidades_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
