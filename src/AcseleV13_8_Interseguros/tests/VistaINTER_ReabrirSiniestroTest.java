package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_ReabrirSiniestroBean;

import AcseleV13_8_Interseguros.main.controller.INTER_ReabrirSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 21/12/2016.
 */
public class VistaINTER_ReabrirSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ReabrirSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interReabrirSiniestro = null;

        try {
            interReabrirSiniestro = INTER_ReabrirSiniestroBean.getINTER_ReabrirSiniestro();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interReabrirSiniestro.size(); j++) {
            INTER_ReabrirSiniestroBean inter_reabrirSiniestroBean = (INTER_ReabrirSiniestroBean) interReabrirSiniestro.get(j);
            INTER_ReabrirSiniestro a = new INTER_ReabrirSiniestro();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_reabrirSiniestroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * FROM INTER_REABRIR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_REABRIR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interReabrirSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select * FROM INTER_REABRIR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_REABRIR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interReabrirSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interReabrirSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interReabrirSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
