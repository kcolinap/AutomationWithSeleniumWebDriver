package AcseleV13_8.tests;

import AcseleV13_8.beans.ConsultaPolizaSimpleBean;

import AcseleV13_8.main.controller.ConsultaPolizaSimple;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 19/05/2016.
 */
public class VistaConsultaPolizaSimpleTest {

    private final static Logger log = Logger.getLogger(VistaConsultaPolizaSimpleTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList poliza = ConsultaPolizaSimpleBean.getConsultaPolizaSimple();
        try {
            poliza = ConsultaPolizaSimpleBean.getConsultaPolizaSimple();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < poliza.size(); i++) {

            ConsultaPolizaSimpleBean consultaPolizaSimpleBean = (ConsultaPolizaSimpleBean) poliza.get(i);
            ConsultaPolizaSimple a = new ConsultaPolizaSimple();

            try {
                a.testLink(consultaPolizaSimpleBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from BUSQUEDA_POLIZA_SIMPLE",
                "BUSQUEDA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/consultaPolizaSimple_dataset.xml");

        DataSetManager.createPartialDataSet("select * from BUSQUEDA_POLIZA_SIMPLE",
                "BUSQUEDA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/consultaPolizaSimple_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }


    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
