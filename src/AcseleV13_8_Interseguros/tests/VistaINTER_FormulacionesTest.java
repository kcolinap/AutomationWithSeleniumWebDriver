package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_FormulacionesBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Formulaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 27/01/2017.
 */
public class VistaINTER_FormulacionesTest {

    private final static Logger log = Logger.getLogger(VistaINTER_FormulacionesTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interFormulaciones = null;

        try {
            interFormulaciones = INTER_FormulacionesBean.getINTER_Formulaciones();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interFormulaciones.size(); j++) {
            INTER_FormulacionesBean inter_formulacionesBean = (INTER_FormulacionesBean) interFormulaciones.get(j);
            INTER_Formulaciones a = new INTER_Formulaciones();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_formulacionesBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,regla, descripcion_formula,buscar FROM INTER_FORMULACIONES ORDER BY PRUEBA ASC",
                "INTER_FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interFormulaciones_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,regla, descripcion_formula,buscar FROM INTER_FORMULACIONES ORDER BY PRUEBA ASC",
                "INTER_FORMULACIONES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interFormulaciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interFormulaciones_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interFormulaciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
