package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_TercerosCrearBean;
import AcseleV13_8_Interseguros.main.controller.Inter_TercerosCrear;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 17/11/2016.
 */
public class VistaInter_TercerosCrearTest {

    private final static Logger log = Logger.getLogger(VistaInter_TercerosCrearTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tercero = null;

        try {
            tercero = Inter_TercerosCrearBean.getInter_TercerosCrear();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < tercero.size(); j++) {
            Inter_TercerosCrearBean interTercerosCrearBean = (Inter_TercerosCrearBean) tercero.get(j);
            Inter_TercerosCrear a = new Inter_TercerosCrear();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interTercerosCrearBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT * FROM CREACION_TERCEROS_INTER ORDER BY PRUEBA ASC",
                "CREACION_TERCEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTerceroCrear_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM CREACION_TERCEROS_INTER ORDER BY PRUEBA ASC",
                "CREACION_TERCEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTerceroCrear_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTerceroCrear_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTerceroCrear_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
