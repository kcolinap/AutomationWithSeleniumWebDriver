package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CancelacionPolizaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CancelacionPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 26/12/2016.
 */
public class VistaINTER_CancelacionPolizaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CancelacionPolizaTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList anulacionPoliza = null;

        try {
            anulacionPoliza = INTER_CancelacionPolizaBean.getAnulacionPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < anulacionPoliza.size(); i++) {

            INTER_CancelacionPolizaBean inter_cancelacionPolizaBean = (INTER_CancelacionPolizaBean) anulacionPoliza.get(i);
            INTER_CancelacionPoliza a = new INTER_CancelacionPoliza();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_cancelacionPolizaBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {
/*
        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS_INTER ORDER BY PRUEBA ASC",
                "ANULACION_POLIZAS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interanulacionPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NUM_POLIZA, CONTRATANTE, ASEGURADO, OPCION, FECHA_APLICACION_EVENTO, MOTIVO_ANULACION, OBSERVACION FROM ANULACION_POLIZAS_INTER ORDER BY PRUEBA ASC",
                "ANULACION_POLIZAS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interanulacionPoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interanulacionPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interanulacionPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
