package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaListaRestrictivaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaListaRestrictiva;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 18/01/2017.
 */
public class VistaINTER_ConsultaListaRestrictivaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaCuentaTecnicaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interConsultaLista = INTER_ConsultaListaRestrictivaBean.getINTER_ConsultaListaRestrictiva();

        for (int j = 0; j< interConsultaLista.size(); j++) {
            INTER_ConsultaListaRestrictivaBean inter_consultaListaRestrictivaBean = (INTER_ConsultaListaRestrictivaBean) interConsultaLista.get(j);
            INTER_ConsultaListaRestrictiva a = new INTER_ConsultaListaRestrictiva();

            try {
                a.testLink(inter_consultaListaRestrictivaBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,lista, nombre,apellido FROM INTER_CONSULTA_LISTA ORDER BY PRUEBA ASC",
                "INTER_CONSULTA_LISTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interConsultaListaRestrictiva_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,lista, nombre,apellido FROM INTER_CONSULTA_LISTA ORDER BY PRUEBA ASC",
                "INTER_CONSULTA_LISTA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interConsultaListaRestrictiva_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaListaRestrictiva_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaListaRestrictiva_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
