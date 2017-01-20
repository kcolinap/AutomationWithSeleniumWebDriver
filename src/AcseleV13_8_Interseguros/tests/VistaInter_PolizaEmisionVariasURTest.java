package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_PolizaEmisionVariasURBean;
import AcseleV13_8_Interseguros.main.controller.Inter_PolizaEmisionVariasUR;
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
 * Created by agil on 04/12/2016.
 */
public class VistaInter_PolizaEmisionVariasURTest {

    private final static Logger log = Logger.getLogger(VistaInter_PolizaEmisionVariosOADotalSimpleTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Inter_PolizaEmisionVariasURBean.getInter_PolizaEmisionVariasUR();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Inter_PolizaEmisionVariasURBean interPolizaEmisionVariasURBean = (Inter_PolizaEmisionVariasURBean) poliza.get(j);
            Inter_PolizaEmisionVariasUR a = new Inter_PolizaEmisionVariasUR();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interPolizaEmisionVariasURBean, j, horaC);
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

/*        DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_VARIAS_UR_INTER ORDER BY PRUEBA ASC",
                "POLIZA_VARIAS_UR_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariasURDotalSimple_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_VARIAS_UR_INTER ORDER BY PRUEBA ASC",
                "POLIZA_VARIAS_UR_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariasURDotalSimple_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariasURDotalSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaEmisionVariasURDotalSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
