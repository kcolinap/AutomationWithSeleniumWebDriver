package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_RenovacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_RenovacionPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 11/04/2017.
 */
public class VistaAsesuisa_RenovacionPolizaTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_RenovacionPolizaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList asesuisaRenovacionPoliza = null;

        try {
            asesuisaRenovacionPoliza = Asesuisa_RenovacionPolizaBean.getRenovacionPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < asesuisaRenovacionPoliza.size(); j++) {
            Asesuisa_RenovacionPolizaBean bean = (Asesuisa_RenovacionPolizaBean) asesuisaRenovacionPoliza.get(j);
            Asesuisa_RenovacionPoliza a = new Asesuisa_RenovacionPoliza();
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

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASE_RENOVACION_POLIZA ORDER BY PRUEBA ASC",
                "ASE_RENOVACION_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaRenovacionPoliza_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_RENOVACION_POLIZA ORDER BY PRUEBA ASC",
                "ASE_RENOVACION_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaRenovacionPoliza_dataset"+num+".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaRenovacionPoliza_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaRenovacionPoliza_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
    }

}
