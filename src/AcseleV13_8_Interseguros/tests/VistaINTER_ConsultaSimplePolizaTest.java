package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaSimplePolizaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaSimplePoliza;
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
public class VistaINTER_ConsultaSimplePolizaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaSimplePolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consultaPoliza = null;

        try {
            consultaPoliza = INTER_ConsultaSimplePolizaBean.getConsultaSimplePolizaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< consultaPoliza.size(); j++) {
            INTER_ConsultaSimplePolizaBean inter_consultaSimplePolizaBean = (INTER_ConsultaSimplePolizaBean) consultaPoliza.get(j);
            INTER_ConsultaSimplePoliza a = new INTER_ConsultaSimplePoliza();

            try {
                a.testLink(inter_consultaSimplePolizaBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
/*
        DataSetManager.createPartialDataSet("select PRUEBA,NUM_POLIZA,CONTRATANTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_SIMPLE_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interconsultaSimplePoliza_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,NUM_POLIZA,CONTRATANTE,ASEGURADO from CONSULTA_POLIZA_SIMPLE_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_SIMPLE_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interconsultaSimplePoliza_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interconsultaSimplePoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interconsultaSimplePoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
