package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.main.controller.Asesuisa_CoberturasSiniestro;
import AcseleV13_8Asesuisa.beans.Asesuisa_CoberturasSiniestroBean;
import metodo.Metodos;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 05/05/2017.
 */
public class VistaAsesuisa_CoberturasSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CoberturasSiniestroTest.class);

    @org.junit.Test
    public void mainTest(){ //throws SQLException

        ArrayList asesuisaCoberturasSiniestro = null;

        try {
            asesuisaCoberturasSiniestro = Asesuisa_CoberturasSiniestroBean.getCoberturasSiniestro();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < asesuisaCoberturasSiniestro.size(); j++) {
            Asesuisa_CoberturasSiniestroBean bean = (Asesuisa_CoberturasSiniestroBean) asesuisaCoberturasSiniestro.get(j);
            Asesuisa_CoberturasSiniestro a = new Asesuisa_CoberturasSiniestro();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

        //Asesuisa_CoberturasSiniestro a = new Asesuisa_CoberturasSiniestro();
        //a.testLink();

    }

    @Before
    public void setUp(String num) throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_COBERTURA_SINIESTRO ORDER BY PRUEBA ASC",
                "ASESUISA_COBERTURA_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCoberturasSiniestro_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_COBERTURA_SINIESTRO ORDER BY PRUEBA ASC",
                "ASESUISA_COBERTURA_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCoberturasSiniestro_dataset"+num+".xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCoberturasSiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);


    //System.out.println("setUp");
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCoberturasSiniestro_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
        //System.out.println("tearDown");
    }
}
