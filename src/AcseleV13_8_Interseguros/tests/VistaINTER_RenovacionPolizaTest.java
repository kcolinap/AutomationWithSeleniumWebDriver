package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_RenovacionPolizaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_RenovacionPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 27/12/2016.
 */
public class VistaINTER_RenovacionPolizaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_RenovacionPolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList renovacionPoliza = null;

        try {
            renovacionPoliza = INTER_RenovacionPolizaBean.getRenovacionPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < renovacionPoliza.size(); i++) {

            INTER_RenovacionPolizaBean inter_renovacionPolizaBean = (INTER_RenovacionPolizaBean) renovacionPoliza.get(i);
            INTER_RenovacionPoliza a = new INTER_RenovacionPoliza();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_renovacionPolizaBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
/*
        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA FROM RENOVACION_POLIZAS_INTER ORDER BY PRUEBA ASC",
                "RENOVACION_POLIZAS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interrenovacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA FROM RENOVACION_POLIZAS_INTER ORDER BY PRUEBA ASC",
                "RENOVACION_POLIZAS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interrenovacionPoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interrenovacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interrenovacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
