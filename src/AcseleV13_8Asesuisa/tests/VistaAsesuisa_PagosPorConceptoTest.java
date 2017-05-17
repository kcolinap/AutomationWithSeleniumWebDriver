package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.main.controller.Asesuisa_PagosPorConcepto;
import AcseleV13_8Asesuisa.beans.Asesuisa_PagosPorConceptoBean;
import metodo.Metodos;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 16/05/2017.
 */
public class VistaAsesuisa_PagosPorConceptoTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_PagosPorConceptoTest.class);

    @org.junit.Test
    public void mainTest(){ //throws SQLException

        ArrayList asesuisaPagosPorConcepto = null;

        try {
            asesuisaPagosPorConcepto = Asesuisa_PagosPorConceptoBean.getPagosPorConcepto();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < asesuisaPagosPorConcepto.size(); j++) {
            Asesuisa_PagosPorConceptoBean bean = (Asesuisa_PagosPorConceptoBean) asesuisaPagosPorConcepto.get(j);
            Asesuisa_PagosPorConcepto a = new Asesuisa_PagosPorConcepto();
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

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_PAGO_CONCEPTO ORDER BY PRUEBA ASC",
                "ASESUISA_PAGO_CONCEPTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagosPorConcepto_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_PAGO_CONCEPTO ORDER BY PRUEBA ASC",
                "ASESUISA_PAGO_CONCEPTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagosPorConcepto_dataset"+num+".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagosPorConcepto_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);


        //System.out.println("setUp");
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagosPorConcepto_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
        //System.out.println("tearDown");
    }
}
