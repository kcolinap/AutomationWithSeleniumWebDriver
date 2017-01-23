package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_PolizaIncluirEditarEliminarContratanteBean;
import AcseleV13_8_Interseguros.main.controller.Inter_PolizaIncluirEditarEliminarContratante;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 23/01/2017.
 */
public class VistaInter_PolizaIncluirEditarEliminarContratanteTest {

    private final static Logger log = Logger.getLogger(VistaInter_PolizaIncluirEditarEliminarContratanteTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Inter_PolizaIncluirEditarEliminarContratanteBean.getInter_PolizaIncluirEditarEliminarContratante();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Inter_PolizaIncluirEditarEliminarContratanteBean inter_polizaIncluirEditarEliminarContratanteBean = (Inter_PolizaIncluirEditarEliminarContratanteBean) poliza.get(j);
            Inter_PolizaIncluirEditarEliminarContratante a = new Inter_PolizaIncluirEditarEliminarContratante();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_polizaIncluirEditarEliminarContratanteBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_EDIT_CONTRATANTES_INTER ORDER BY PRUEBA ASC",
                "POLIZA_EDIT_CONTRATANTES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interPolizaIncluirEditarEliminarContratante_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM POLIZA_EDIT_CONTRATANTES_INTER ORDER BY PRUEBA ASC",
                "POLIZA_EDIT_CONTRATANTES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interPolizaIncluirEditarEliminarContratante_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaIncluirEditarEliminarContratante_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPolizaIncluirEditarEliminarContratante_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
