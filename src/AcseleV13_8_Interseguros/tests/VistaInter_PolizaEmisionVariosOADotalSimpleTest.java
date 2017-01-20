package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_PolizaEmisionVariosOABean;
import AcseleV13_8_Interseguros.main.controller.Inter_PolizaEmisionVariosOA;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 29/11/2016.
 */
public class VistaInter_PolizaEmisionVariosOADotalSimpleTest {

    private final static Logger log = Logger.getLogger(VistaInter_PolizaEmisionVariosOADotalSimpleTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Inter_PolizaEmisionVariosOABean.getInter_PolizaEmisionVariosOA();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Inter_PolizaEmisionVariosOABean interPolizaEmisionVariosOABean = (Inter_PolizaEmisionVariosOABean) poliza.get(j);
            Inter_PolizaEmisionVariosOA a = new Inter_PolizaEmisionVariosOA();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interPolizaEmisionVariosOABean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
                // Para mandar a imprimir en el .log
                //e.printStackTrace();
                //log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
                /*e.printStackTrace();
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                sw.toString(); // stack trace as a string
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + sw.toString());*/
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_VARIOS_OA_INTER ORDER BY PRUEBA ASC",
                "POLIZA_VARIOS_OA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariosOADotalSimple_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_VARIOS_OA_INTER ORDER BY PRUEBA ASC",
                "POLIZA_VARIOS_OA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariosOADotalSimple_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariosOADotalSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariosOADotalSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
