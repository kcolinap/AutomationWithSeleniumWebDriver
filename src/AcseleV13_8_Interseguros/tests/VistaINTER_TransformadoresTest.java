package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_TransformadoresBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Transformadores;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 03/02/2017.
 */
public class VistaINTER_TransformadoresTest {

    private final static Logger log = Logger.getLogger(VistaINTER_TransformadoresTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interTransformadores = null;

        try {
            interTransformadores = INTER_TransformadoresBean.getINTER_Transformadores();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interTransformadores.size(); j++) {
            INTER_TransformadoresBean inter_transformadoresBean = (INTER_TransformadoresBean) interTransformadores.get(j);
            INTER_Transformadores a = new INTER_Transformadores();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_transformadoresBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,buscar, valor_Defecto, valor_Propiedad FROM INTER_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "INTER_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTransformadores_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,buscar, valor_Defecto, valor_Propiedad FROM INTER_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "INTER_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTransformadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTransformadores_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTransformadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
