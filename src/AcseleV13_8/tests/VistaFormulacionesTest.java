package AcseleV13_8.tests;

import AcseleV13_8.beans.FormulacionesBean;
import AcseleV13_8.main.controller.Formulaciones;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 23/08/2016.
 */
public class VistaFormulacionesTest {

    private final static Logger log = Logger.getLogger(VistaFormulacionesTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList formulaciones = FormulacionesBean.getFormulaciones();

        for (int i = 0; i < formulaciones.size(); i++) {
            FormulacionesBean formulacionesBean = (FormulacionesBean) formulaciones.get(i);
            Formulaciones a = new Formulaciones();

            try {
                a.testLink(formulacionesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba, Regla, Descripcion_Formula, Buscar  from FORMULACIONES ORDER BY PRUEBA ASC",
                "FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/formulaciones_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba, Regla, Descripcion_Formula, Buscar  from FORMULACIONES ORDER BY PRUEBA ASC",
                "FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/formulaciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/formulaciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/formulaciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
