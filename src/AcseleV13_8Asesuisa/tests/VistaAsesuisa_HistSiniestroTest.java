package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_HistSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_HistSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 01/04/2017.
 */
public class VistaAsesuisa_HistSiniestroTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_HistSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList hsiniestro = null;

        try {
            hsiniestro = Asesuisa_HistSiniestroBean.getAsesuisa_histSiniestro();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < hsiniestro.size(); j++) {
            Asesuisa_HistSiniestroBean bean =(Asesuisa_HistSiniestroBean) hsiniestro.get(j);

            Asesuisa_HistSiniestro a = new Asesuisa_HistSiniestro();
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




       /*  DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaHsiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaHsiniestro_dataset"+ num + ".xml");
*/



        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaHsiniestro_dataset" + num +  ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaHsiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
