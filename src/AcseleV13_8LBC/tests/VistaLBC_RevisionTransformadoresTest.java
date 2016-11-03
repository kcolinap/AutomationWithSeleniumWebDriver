package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_RevisionTransformadoresBean;
import AcseleV13_8LBC.main.controller.LBC_RevisionTransformadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 03/11/2016.
 */
public class VistaLBC_RevisionTransformadoresTest {

    private final static Logger log = Logger.getLogger(VistaLBC_RevisionTransformadoresTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList lbc_RevisionTransformadores = LBC_RevisionTransformadoresBean.getLBC_RevisionTransformadores();

        for (int i = 0; i < lbc_RevisionTransformadores.size(); i++) {
            LBC_RevisionTransformadoresBean lbc_RevisionTransformadoresBean = (LBC_RevisionTransformadoresBean) lbc_RevisionTransformadores.get(i);
            LBC_RevisionTransformadores a = new LBC_RevisionTransformadores();


            try {
                a.testLink(lbc_RevisionTransformadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR FROM LBC_REVISION_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_REVISION_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/LBC_revision_transformadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR FROM LBC_REVISION_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_REVISION_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/LBC_revision_transformadores_dataset.xml");
*/
       DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_revision_transformadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_revision_transformadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
