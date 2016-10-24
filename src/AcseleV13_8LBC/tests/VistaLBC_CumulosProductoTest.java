package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CumulosProductoBean;

import AcseleV13_8LBC.main.controller.LBC_CumulosProducto;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 17/10/2016.
 */
public class VistaLBC_CumulosProductoTest {
    private final static Logger log = Logger.getLogger(VistaLBC_CumulosProductoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosProductoLBC = LBC_CumulosProductoBean.getLBC_CumulosProductoBean();

        for (int j = 0; j< cumulosProductoLBC.size(); j++) {
            LBC_CumulosProductoBean lbcCumulosProductoBean = (LBC_CumulosProductoBean) cumulosProductoLBC.get(j);
            LBC_CumulosProducto a = new LBC_CumulosProducto();

            try {
                a.testLink(lbcCumulosProductoBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

       /* DataSetManager.createPartialDataSet("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_PRODUCTOS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/cumulosProductoLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_PRODUCTOS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/cumulosProductoLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosProductoLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosProductoLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
