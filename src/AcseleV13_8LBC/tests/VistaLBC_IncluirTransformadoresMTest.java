package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_IncluirTransformadoresMBean;
import AcseleV13_8LBC.main.controller.LBC_IncluirTransformadoresM;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 26/10/2016.
 */
public class VistaLBC_IncluirTransformadoresMTest {



    private final static Logger log = Logger.getLogger(VistaLBC_IncluirTransformadoresMTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList lbc_IncluirTransformadoresM = LBC_IncluirTransformadoresMBean.getLBC_IncluirTransformadoresM();

        for (int i = 0; i < lbc_IncluirTransformadoresM.size(); i++) {
            LBC_IncluirTransformadoresMBean lbc_incluirTransformadoresMBean = (LBC_IncluirTransformadoresMBean) lbc_IncluirTransformadoresM.get(i);
            AcseleV13_8LBC.main.controller.LBC_IncluirTransformadoresM a = new LBC_IncluirTransformadoresM();


            try {
                a.testLink(lbc_incluirTransformadoresMBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM LBC_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/LBC_transformadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM LBC_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/LBC_transformadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_transformadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_transformadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
