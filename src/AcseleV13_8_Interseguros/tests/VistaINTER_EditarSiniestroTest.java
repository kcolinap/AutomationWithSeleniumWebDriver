package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_EditarSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_EditarSiniestro;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 29/12/2016.
 */
public class VistaINTER_EditarSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_EditarSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interEditarSiniestro = INTER_EditarSiniestroBean.getINTER_EditarSiniestro();

        for (int j = 0; j< interEditarSiniestro.size(); j++) {
            INTER_EditarSiniestroBean inter_editarSiniestroBean = (INTER_EditarSiniestroBean) interEditarSiniestro.get(j);
            INTER_EditarSiniestro a = new INTER_EditarSiniestro();

            try {
                a.testLink(inter_editarSiniestroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from INTER_EDITAR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_EDITAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interEditarSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_EDITAR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_EDITAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interEditarSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interEditarSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interEditarSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
