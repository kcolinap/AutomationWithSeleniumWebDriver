package AcseleV13_8.tests;

import AcseleV13_8.beans.TercerosRolesBean;
import AcseleV13_8.main.controller.TercerosRoles;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 16/06/2016.
 */
public class VistasTercerosRolesTest {

    private final static Logger log = Logger.getLogger(VistasTercerosRolesTest.class);

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
        ArrayList terceros = TercerosRolesBean.getTercerosRoles();
        //login

        for(int i = 0; i < terceros.size(); i++) {

            TercerosRolesBean tercerosRolesBean = (TercerosRolesBean) terceros.get(i);
            TercerosRoles a = new TercerosRoles();

            try {
                a.testLink(tercerosRolesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 22 - LBC_Terceros Asociacion de Roles - " + e);

            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, ROL, ENTIDAD_BANCARIA, TIPO_CUENTA_BANCARIA, NUM_CUENTA_BANCARIA FROM TERCEROS_ROLES ORDER BY PRUEBA ASC",
                "TERCEROS_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/tercerosRoles_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, ROL, ENTIDAD_BANCARIA, TIPO_CUENTA_BANCARIA, NUM_CUENTA_BANCARIA FROM TERCEROS_ROLES ORDER BY PRUEBA ASC",
                "TERCEROS_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/tercerosRoles_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosRoles_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosRoles_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
