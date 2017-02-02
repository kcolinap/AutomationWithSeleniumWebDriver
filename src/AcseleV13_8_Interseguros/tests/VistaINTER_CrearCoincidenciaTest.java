package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CrearCoincidenciaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CrearCoincidencia;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 31/01/2017.
 */
public class VistaINTER_CrearCoincidenciaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CrearCoincidenciaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interCrearCoincidencia = null;

        try {
            interCrearCoincidencia = INTER_CrearCoincidenciaBean.getINTER_CrearCoincidencia();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interCrearCoincidencia.size(); j++) {
            INTER_CrearCoincidenciaBean inter_crearCoincidenciaBean = (INTER_CrearCoincidenciaBean) interCrearCoincidencia.get(j);
            INTER_CrearCoincidencia a = new INTER_CrearCoincidencia();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_crearCoincidenciaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,nombre_lista, tipo_coincidencia FROM INTER_COINCIDENCIAS ORDER BY PRUEBA ASC",
                "INTER_COINCIDENCIAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCrearCoincidencia_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,nombre_lista, tipo_coincidencia FROM INTER_COINCIDENCIAS ORDER BY PRUEBA ASC",
                "INTER_COINCIDENCIAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCrearCoincidencia_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCrearCoincidencia_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCrearCoincidencia_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
