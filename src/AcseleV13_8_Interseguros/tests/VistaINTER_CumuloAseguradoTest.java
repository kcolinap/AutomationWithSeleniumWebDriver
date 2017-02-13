package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CumuloAseguradoBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CumuloAsegurado;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 11/01/2017.
 */
public class VistaINTER_CumuloAseguradoTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CumuloAseguradoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interCumuloAsegurado = null;

        try {
            interCumuloAsegurado = INTER_CumuloAseguradoBean.getINTER_CumuloAsegurado();
        }
        catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interCumuloAsegurado.size(); j++) {
            INTER_CumuloAseguradoBean inter_cumuloAseguradoBean = (INTER_CumuloAseguradoBean) interCumuloAsegurado.get(j);
            INTER_CumuloAsegurado a = new INTER_CumuloAsegurado();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_cumuloAseguradoBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
/*

        DataSetManager.createPartialDataSet("select * from INTER_CUMULO_ASEGURADO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_ASEGURADO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCumulosAsegurado_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_CUMULO_ASEGURADO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_ASEGURADO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCumulosAsegurado_dataset.xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosAsegurado_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosAsegurado_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
