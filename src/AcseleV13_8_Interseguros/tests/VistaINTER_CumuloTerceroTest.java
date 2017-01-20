package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_CumuloTerceroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CumuloTercero;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 06/01/2017.
 */
public class VistaINTER_CumuloTerceroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CumuloTerceroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interCumuloTercero = INTER_CumuloTerceroBean.getINTER_CumuloTercero();

        for (int j = 0; j< interCumuloTercero.size(); j++) {
            INTER_CumuloTerceroBean inter_cumuloTerceroBean = (INTER_CumuloTerceroBean) interCumuloTercero.get(j);
            INTER_CumuloTercero a = new INTER_CumuloTercero();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_cumuloTerceroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from INTER_CUMULO_TERCERO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCumulosTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_CUMULO_TERCERO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCumulosTerceros_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
