package tests;


import beans.BusquedaPolizaAvanzadaBean;
import beans.EdicionTercerosBean;
import main.controller.PoolCreacionTerceros;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 07/06/2016.
 */
public class VistaEdicionTercerosTest {

    @Test
    //@Transactional
    public void mainTest() {

//        BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = BusquedaPolizaAvanzadaBean.getBusquedaPolizaAvanzada();
//        ConsultaPolizaAvanzada a = new ConsultaPolizaAvanzada();
//        try {
//            a.testLink(busquedaPolizaAvanzadaBean);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /***/
        ArrayList terceros = EdicionTercerosBean.getTercerosEdicion();
        //login

        for(int i = 0; i < terceros.size(); i++) {

            EdicionTercerosBean edicionTercerosBean = (EdicionTercerosBean) terceros.get(i);
            PoolCreacionTerceros a = new PoolCreacionTerceros();
            try {
                a.testLink(edicionTercerosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/edicionTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/edicionTerceros_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/edicionTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/edicionTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
