package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_RolesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Roles;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 29/03/2017.
 */
public class VistaAsesuisa_RolesTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_RolesTest.class);

    @org.junit.Test
    public void mainTest(String num) throws SQLException {

        ArrayList rol = null;

        try {
            rol = Asesuisa_RolesBean.getAsesuisa_Rol();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < rol.size(); j++) {
            Asesuisa_RolesBean bean =(Asesuisa_RolesBean) rol.get(j);

            Asesuisa_Roles a = new Asesuisa_Roles();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
             a.testLink(bean, j, horaC,num);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {




 /*        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_ROLES ORDER BY PRUEBA ASC",
                "ASESUISA_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaRoles_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_ROLES ORDER BY PRUEBA ASC",
                "ASESUISA_ROLES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaRoles_dataset"+ num + ".xml");
*/



        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaRoles_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaRoles_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
