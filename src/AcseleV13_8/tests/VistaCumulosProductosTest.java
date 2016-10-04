package AcseleV13_8.tests;

import AcseleV13_8.beans.CumulosProductosBean;
import AcseleV13_8.main.controller.CumulosProductos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by aazuaje on 17/08/2016.
 */
public class VistaCumulosProductosTest {

    private final static Logger log = Logger.getLogger(VistaCumulosProductosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosProductos = CumulosProductosBean.getCumulosProductos();

        for (int i = 0; i < cumulosProductos.size(); i++) {
            CumulosProductosBean cumulosProductosBean = (CumulosProductosBean) cumulosProductos.get(i);
            CumulosProductos a = new CumulosProductos();

            try {
                a.testLink(cumulosProductosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS ORDER BY PRUEBA ASC",
                "CUMULOS_PRODUCTOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/cumulosProductos_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Producto, Moneda FROM CUMULOS_PRODUCTOS ORDER BY PRUEBA ASC",
                "CUMULOS_PRODUCTOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/cumulosProductos_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosProductos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosProductos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
