package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_HistorialReclamoBean;
import AcseleV13_8_Interseguros.main.controller.INTER_HistorialReclamo;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 27/12/2016.
 */
public class VistaINTER_HistorialReclamoTest {

    private final static Logger log = Logger.getLogger(VistaINTER_HistorialReclamoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList inter_historialReclamos = INTER_HistorialReclamoBean.getInter_HistorialReclamo();

        for (int j = 0; j< inter_historialReclamos.size(); j++) {
            INTER_HistorialReclamoBean inter_historialReclamoBean = (INTER_HistorialReclamoBean) inter_historialReclamos.get(j);
            INTER_HistorialReclamo a = new INTER_HistorialReclamo();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_historialReclamoBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba, Num_Reclamo from INTER_HISTORIAL_RECLAMO ORDER BY PRUEBA ASC",
                "INTER_HISTORIAL_RECLAMO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interHistorialReclamo_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba, Num_Reclamo from INTER_HISTORIAL_RECLAMO ORDER BY PRUEBA ASC",
                "INTER_HISTORIAL_RECLAMO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interHistorialReclamo_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interHistorialReclamo_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interHistorialReclamo_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
