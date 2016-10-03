package AcseleV13_8.tests;

import AcseleV13_8.beans.ValidacionSimbolosBean;
import AcseleV13_8.main.controller.ReabrirSiniestro;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 03/10/2016.
 */
public class VistaValidacionSimbolosTest {

    private final static Logger log = Logger.getLogger(VistaValidacionSimbolosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList validarSimbolos = ValidacionSimbolosBean.getValidarSimbolos();


        for (int j = 0; j< validarSimbolos.size(); j++) {
            ValidacionSimbolosBean validacionSimbolosBean = (ValidacionSimbolosBean) validarSimbolos.get(j);
            ValidacionSimbolos a = new ValidacionSimbolos();

            try {
                //a.testLink(validacionSimbolosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("select PRUEBA,PRODUCTO from VALIDACION_SIMBOLOS ORDER BY PRUEBA ASC;",
                "VALIDACION_SIMBOLOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/validacionSimbolos_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,PRODUCTO from VALIDACION_SIMBOLOS ORDER BY PRUEBA ASC;",
                "VALIDACION_SIMBOLOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/validacionSimbolos_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/validacionSimbolos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/validacionSimbolos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
