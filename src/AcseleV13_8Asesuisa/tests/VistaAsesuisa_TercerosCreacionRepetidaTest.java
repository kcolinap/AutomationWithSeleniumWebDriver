package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCreacionRepetidaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosCreacionRepetida;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 14/04/2017.
 */
public class VistaAsesuisa_TercerosCreacionRepetidaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_TercerosCreacionRepetidaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList tercero = null;

        try {
            tercero = Asesuisa_TercerosCreacionRepetidaBean.getAsesuisa_TercerosCreacionRepetida();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < tercero.size(); j++) {
            Asesuisa_TercerosCreacionRepetidaBean bean = (Asesuisa_TercerosCreacionRepetidaBean) tercero.get(j);
            Asesuisa_TercerosCreacionRepetida a = new Asesuisa_TercerosCreacionRepetida();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_TERCERO_CREAR_REPETIDO ORDER BY PRUEBA ASC",
                "ASE_TERCERO_CREAR_REPETIDO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTerceroCreacionRepetida_dataset" + num +  ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_TERCERO_CREAR_REPETIDO ORDER BY PRUEBA ASC",
                "ASE_TERCERO_CREAR_REPETIDO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTerceroCreacionRepetida_dataset" + num +  ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTerceroCreacionRepetida_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTerceroCreacionRepetida_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
