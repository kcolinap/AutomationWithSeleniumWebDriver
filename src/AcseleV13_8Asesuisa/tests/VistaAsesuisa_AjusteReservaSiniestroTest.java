package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_AjusteReservaSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.ASesuisa_AjusteReservaSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 12/05/2017.
 */
public class VistaAsesuisa_AjusteReservaSiniestroTest {
    private final static Logger log = Logger.getLogger(VistaAsesuisa_AjusteReservaSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList areserva = null;

        try {
            areserva =Asesuisa_AjusteReservaSiniestroBean.getAsesuisa_AjusteReserva();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < areserva.size(); j++) {
            Asesuisa_AjusteReservaSiniestroBean bean =(Asesuisa_AjusteReservaSiniestroBean) areserva.get(j);
            ASesuisa_AjusteReservaSiniestro a = new ASesuisa_AjusteReservaSiniestro();
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

       /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_AJUSTERESERVASINI ORDER BY PRUEBA ASC",
                "ASESUISA_AJUSTERESERVASINI",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaAjustersiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_AJUSTERESERVASINI ORDER BY PRUEBA ASC",
                "ASESUISA_AJUSTERESERVASINI",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaAjustersiniestro_dataset"+ num + ".xml");
*/




        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaAjustersiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaAjustersiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }

}
