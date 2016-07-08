package tests;

import beans.PolizaBean;

import main.controller.ConsultaPolizaSimple;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

/**
 * Created by agil on 19/05/2016.
 */
public class VistaConsultaPolizaSimpleTest {

    //private static final AcseleLogger log = AcseleLogger.getLogger(Appointment.class);

    @Test
    //@Transactional
    public void mainTest() {

        PolizaBean polizaBean = PolizaBean.getPoliza();
        ConsultaPolizaSimple a = new ConsultaPolizaSimple();
        try {
           a.testLink(polizaBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from BUSQUEDA_POLIZA_SIMPLE", "BUSQUEDA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/consultaPolizaSimple_dataset.xml");
        DataSetManager.createPartialDataSet("select * from BUSQUEDA_POLIZA_SIMPLE", "BUSQUEDA_POLIZA_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/consultaPolizaSimple_dataset.xml");*/
        DataSetManager.loadDataSet("/tests/consultaPolizaSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }


    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/consultaPolizaSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
