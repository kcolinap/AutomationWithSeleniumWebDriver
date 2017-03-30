package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_CancelacionAnulacionPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_CancelacionAnulacionPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 29/03/2017.
 */
public class VistaAsesuisa_CancelacionAnulacionPolizaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CancelacionAnulacionPolizaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList asesuisaCancelacionAnulacionPoliza = null;

        try {
            asesuisaCancelacionAnulacionPoliza = Asesuisa_CancelacionAnulacionPolizaBean.getCancelacionAnulacionPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < asesuisaCancelacionAnulacionPoliza.size(); j++) {
            Asesuisa_CancelacionAnulacionPolizaBean bean = (Asesuisa_CancelacionAnulacionPolizaBean) asesuisaCancelacionAnulacionPoliza.get(j);
            Asesuisa_CancelacionAnulacionPoliza a = new Asesuisa_CancelacionAnulacionPoliza();
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
    public void setUp(int num) throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASE_CANCEL_ANULA_POLIZA ORDER BY PRUEBA ASC",
                "ASE_CANCEL_ANULA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCancelacionAnulacionPoliza_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_CANCEL_ANULA_POLIZA ORDER BY PRUEBA ASC",
                "ASE_CANCEL_ANULA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCancelacionAnulacionPoliza_dataset"+num+".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCancelacionAnulacionPoliza_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(int num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCancelacionAnulacionPoliza_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
    }
}
