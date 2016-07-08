package tests;

import beans.TercerosDocumentosBean;
import main.controller.TercerosDocumentos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 14/06/2016.
 */
public class VistaTercerosDocumentosTest {



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
        ArrayList terceros = TercerosDocumentosBean.getTercerosDocumentos();
        //login

        for(int i = 0; i < terceros.size(); i++) {

            TercerosDocumentosBean tercerosDocumentosBean = (TercerosDocumentosBean) terceros.get(i);
            TercerosDocumentos a = new TercerosDocumentos();

            try {
                a.testLink(tercerosDocumentosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/tercerosDocumentos_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM CONSULTA_TERCEROS ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/tercerosDocumentos_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/tercerosDocumentos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/tercerosDocumentos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
