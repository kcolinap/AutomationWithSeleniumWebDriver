package tests;

import beans.TercerosUpdateRolesBean;
import main.controller.TercerosUpdateRoles;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 23/06/2016.
 */
public class VistaTercerosUpdateRolesTest {

    private final static Logger log = Logger.getLogger(VistaTercerosUpdateRolesTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = TercerosUpdateRolesBean.getTercerosUpdateRoles();

        for (int i = 0; i < terceros.size(); i++) {
            TercerosUpdateRolesBean tercerosUpdateRolesBean = (TercerosUpdateRolesBean) terceros.get(i);
            TercerosUpdateRoles a = new TercerosUpdateRoles();

            try {
                a.testLink(tercerosUpdateRolesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - Terceros Informacion Financiera - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, GENERO, FECHA_NAC, AUD_FECHA_DESDE, AUD_FECHA_HASTA FROM TERCEROS_UPDATE_ROL ORDER BY PRUEBA ASC",
                "TERCEROS_UPDATE_ROL",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/tercerosUpdateRoles_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, GENERO, FECHA_NAC, AUD_FECHA_DESDE, AUD_FECHA_HASTA FROM TERCEROS_UPDATE_ROL ORDER BY PRUEBA ASC",
                "TERCEROS_UPDATE_ROL",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/tercerosUpdateRoles_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/tercerosUpdateRoles_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/tercerosUpdateRoles_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
