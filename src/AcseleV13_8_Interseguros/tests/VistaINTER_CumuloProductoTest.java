package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CumuloProductoBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CumuloProduto;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 12/01/2017.
 */
public class VistaINTER_CumuloProductoTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CumuloProductoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interCumuloProducto = INTER_CumuloProductoBean.getINTER_CumuloProducto();

        for (int j = 0; j< interCumuloProducto.size(); j++) {
            INTER_CumuloProductoBean inter_cumuloProductoBean = (INTER_CumuloProductoBean) interCumuloProducto.get(j);
            INTER_CumuloProduto a = new INTER_CumuloProduto();

            try {
                a.testLink(inter_cumuloProductoBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from INTER_CUMULO_PRODUCTO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_PRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCumulosProducto_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_CUMULO_PRODUCTO ORDER BY PRUEBA ASC",
                "INTER_CUMULO_PRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCumulosProducto_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosProducto_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCumulosProducto_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
