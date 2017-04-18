package AcseleV13_8Asesuisa.tests;


import AcseleV13_8Asesuisa.beans.Asesuisa_GenerarTrazaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_GenerarTraza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 31/03/2017.
 */
public class VistaAsesuisa_GenerarTrazaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_GenerarTrazaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {


            ArrayList generarTraza = Asesuisa_GenerarTrazaBean.getGenerarTraza();


        for (int j = 0; j < generarTraza.size(); j++) {
            Asesuisa_GenerarTrazaBean bean =(Asesuisa_GenerarTrazaBean) generarTraza.get(j);

            Asesuisa_GenerarTraza a = new Asesuisa_GenerarTraza();
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

    /*     DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_GENERARTRAZA ORDER BY PRUEBA ASC",
                "ASESUISA_GENERARTRAZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaGenerarTraza_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_GENERARTRAZA ORDER BY PRUEBA ASC",
                "ASESUISA_GENERARTRAZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaGenerarTraza_dataset" + num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaGenerarTraza_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);


    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaGenerarTraza_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);

    }
}
