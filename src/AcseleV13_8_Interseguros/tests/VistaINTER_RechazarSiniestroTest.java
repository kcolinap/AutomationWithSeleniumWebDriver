package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_RechazarSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_RechazarSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 22/12/2016.
 */
public class VistaINTER_RechazarSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_RechazarSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interRechazarSiniestro = null;

        try {
            interRechazarSiniestro = INTER_RechazarSiniestroBean.getINTER_RechazarSiniestro();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interRechazarSiniestro.size(); j++) {
            INTER_RechazarSiniestroBean inter_rechazarSiniestroBean = (INTER_RechazarSiniestroBean) interRechazarSiniestro.get(j);
            INTER_RechazarSiniestro a = new INTER_RechazarSiniestro();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_rechazarSiniestroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * FROM INTER_RECHAZAR_SINIESTRO  ORDER BY PRUEBA ASC",
                "INTER_RECHAZAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interRechazarSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select * FROM INTER_RECHAZAR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_RECHAZAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interRechazarSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interRechazarSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interRechazarSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
