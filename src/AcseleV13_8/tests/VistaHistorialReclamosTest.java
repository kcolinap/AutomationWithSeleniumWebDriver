package AcseleV13_8.tests;

import AcseleV13_8.beans.HistorialReclamosBean;
import AcseleV13_8.main.controller.HistorialReclamos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;
/**
 * Created by aazuaje on 02/08/2016.
 */
public class VistaHistorialReclamosTest {
    private final static Logger log = Logger.getLogger(VistaHistorialReclamosTest.class);

    @Test
    public void mainTest() {

        ArrayList historialReclamos = HistorialReclamosBean.getHistorialReclamos();

        for (int i = 0; i < historialReclamos.size(); i++) {
            HistorialReclamosBean historialReclamosBean = (HistorialReclamosBean) historialReclamos.get(i);
            HistorialReclamos a = new HistorialReclamos();

            try {
                  a.testLink(historialReclamosBean,i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba, Numero_Reclamo from HIST_RECLAMOS ORDER BY PRUEBA ASC",
                "HIST_RECLAMOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.AcseleV13_8_Alfa.tests.xmls/historialReclamos_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Numero_Reclamo from HIST_RECLAMOS ORDER BY PRUEBA ASC",
                "HIST_RECLAMOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.AcseleV13_8_Alfa.tests.xmls/historialReclamos_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/historialReclamos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }


    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/historialReclamos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}


