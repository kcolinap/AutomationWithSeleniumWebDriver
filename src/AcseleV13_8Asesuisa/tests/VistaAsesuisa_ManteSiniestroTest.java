package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_ManteSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ManteSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 01/05/2017.
 */
public class VistaAsesuisa_ManteSiniestroTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_ManteSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList siniestro = null;

        try {
            siniestro = Asesuisa_ManteSiniestroBean.getAsesuisa_siniestro();
        } catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < siniestro.size(); j++) {
            Asesuisa_ManteSiniestroBean bean = (Asesuisa_ManteSiniestroBean) siniestro.get(j);

            Asesuisa_ManteSiniestro a = new Asesuisa_ManteSiniestro();
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



/*
        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaMantsini_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaMantsini_dataset"+ num + ".xml");*/




        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaMantsini_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaMantsini_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }

}


