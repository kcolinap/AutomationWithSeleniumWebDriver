package AcseleV13_8.tests;

import AcseleV13_8.beans.TransformadoresBean;
import AcseleV13_8.main.controller.Transformadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 20/08/2016.
 */
public class VistaTransformadoresTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList transformadores = TransformadoresBean.getTransformadores();

        for (int i = 0; i < transformadores.size(); i++) {
            TransformadoresBean transformadoresBean = (TransformadoresBean) transformadores.get(i);
            Transformadores a = new Transformadores();


            try {
                a.testLink(transformadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM TRANSFORMADORES ORDER BY PRUEBA ASC",
                "TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/transformadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, BUSCAR, VALORDEFECTO, VALORPROPIEDAD FROM TRANSFORMADORES ORDER BY PRUEBA ASC",
                "TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/transformadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/transformadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/transformadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}


