package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CreacionListaRestrictivaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CreacionListaRestrictiva;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 21/11/2016.
 */
public class VistaINTER_CreacionListaRestrictivaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CreacionListaRestrictivaTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList interCreacionListaRestrictiva = INTER_CreacionListaRestrictivaBean.getInterCreacionListaRestrictiva();

        for (int i = 0; i < interCreacionListaRestrictiva.size(); i++) {

            INTER_CreacionListaRestrictivaBean inter_creacionListaRestrictivaBean = (INTER_CreacionListaRestrictivaBean) interCreacionListaRestrictiva.get(i);
            INTER_CreacionListaRestrictiva a = new INTER_CreacionListaRestrictiva();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_creacionListaRestrictivaBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }


    @Before
    public void setUp() throws Exception {

       /* DataSetManager.createPartialDataSet("select Prueba,NOMBRE_PLANTILLA FROM INTER_CREAR_LISTA_RESTRICTIVA ORDER BY PRUEBA ASC",
                "INTER_CREAR_LISTA_RESTRICTIVA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCreacionListaRestrictiva_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,NOMBRE_PLANTILLA FROM INTER_CREAR_LISTA_RESTRICTIVA ORDER BY PRUEBA ASC",
                "INTER_CREAR_LISTA_RESTRICTIVA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCreacionListaRestrictiva_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionListaRestrictiva_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionListaRestrictiva_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
