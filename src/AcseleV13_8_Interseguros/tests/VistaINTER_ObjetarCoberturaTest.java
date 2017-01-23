package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ObjetarCoberturaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ObjetarCobertura;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 19/12/2016.
 */
public class VistaINTER_ObjetarCoberturaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ObjetarCoberturaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList InterObjetarCobertura = null;

        try {
            InterObjetarCobertura = INTER_ObjetarCoberturaBean.getInter_ObjetarCobertura();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< InterObjetarCobertura.size(); j++) {
            INTER_ObjetarCoberturaBean inter_objetarCoberturaBean = (INTER_ObjetarCoberturaBean) InterObjetarCobertura.get(j);
            INTER_ObjetarCobertura a = new INTER_ObjetarCobertura();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_objetarCoberturaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * FROM INTER_OBJETAR_COBERTURA  ORDER BY PRUEBA ASC",
                "INTER_OBJETAR_COBERTURA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interObjetarSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select * FROM INTER_OBJETAR_COBERTURA  ORDER BY PRUEBA ASC",
                "INTER_OBJETAR_COBERTURA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interObjetarSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interObjetarSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interObjetarSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
