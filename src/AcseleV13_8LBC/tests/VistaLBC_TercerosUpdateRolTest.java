package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_TercerosUpdateRolBean;
import AcseleV13_8LBC.main.controller.LBC_TercerosUpdateRol;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 24/10/2016.
 */
public class VistaLBC_TercerosUpdateRolTest {

    private final static Logger log = Logger.getLogger(VistaLBC_TercerosUpdateRolTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tercerosRolLBC = LBC_TercerosUpdateRolBean.getLbcTercerosUpdateRol();

        for (int j = 0; j< tercerosRolLBC.size(); j++) {
            LBC_TercerosUpdateRolBean lbc_tercerosUpdateRolBean = (LBC_TercerosUpdateRolBean) tercerosRolLBC.get(j);
            LBC_TercerosUpdateRol a = new LBC_TercerosUpdateRol();

            try {
                a.testLink(lbc_tercerosUpdateRolBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion,Num_Doc_Identificacion, Genero, Fecha_Nac,aud_Fecha_Desde,aud_Fecha_Hasta FROM TERCEROS_MOD_ROLES ORDER BY PRUEBA ASC",
                "TERCEROS_MOD_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/tercerosRolLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion,Num_Doc_Identificacion, Genero, Fecha_Nac,aud_Fecha_Desde,aud_Fecha_Hasta FROM TERCEROS_MOD_ROLES ORDER BY PRUEBA ASC",
                "TERCEROS_MOD_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/tercerosRolLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosRolLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosRolLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
