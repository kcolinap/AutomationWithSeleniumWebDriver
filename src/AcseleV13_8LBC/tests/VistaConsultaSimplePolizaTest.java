package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.ConsultaSimplePolizaBean;
import AcseleV13_8LBC.main.controller.ConsultaSimplePoliza;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 10/10/2016.
 */
public class VistaConsultaSimplePolizaTest {

    private final static Logger log = Logger.getLogger(VistaConsultaSimplePolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consultaPoliza = null;

        try {
            consultaPoliza = ConsultaSimplePolizaBean.getConsultaSimplePolizaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< consultaPoliza.size(); j++) {
            ConsultaSimplePolizaBean consultaSimplePolizaBean = (ConsultaSimplePolizaBean) consultaPoliza.get(j);
            ConsultaSimplePoliza a = new ConsultaSimplePoliza();

            try {
                a.testLink(consultaSimplePolizaBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA,NUM_POLIZA,CLIENTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/consultaSimplePoliza_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,NUM_POLIZA,CLIENTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/consultaSimplePoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaSimplePoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaSimplePoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
