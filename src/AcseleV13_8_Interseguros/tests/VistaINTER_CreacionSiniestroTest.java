package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CreacionSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CreacionSiniestro;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 13/12/2016.
 */
public class VistaINTER_CreacionSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CreacionSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList creacionSiniestro = null;

        try {
            creacionSiniestro = INTER_CreacionSiniestroBean.getINTER_CreacionSiniestro();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< creacionSiniestro.size(); j++) {
            INTER_CreacionSiniestroBean inter_creacionSiniestroBean = (INTER_CreacionSiniestroBean) creacionSiniestro.get(j);
            INTER_CreacionSiniestro a = new INTER_CreacionSiniestro();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_creacionSiniestroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * FROM INTER_CREACION_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_CREACION_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCreacionSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select * FROM INTER_CREACION_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_CREACION_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCreacionSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
