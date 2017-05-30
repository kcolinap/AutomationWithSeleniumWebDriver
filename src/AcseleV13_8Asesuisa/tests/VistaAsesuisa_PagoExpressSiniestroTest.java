package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_PagoExpressSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_PagoExpressSiniestro;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ValidacionOperacionSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 24/05/2017.
 */
public class VistaAsesuisa_PagoExpressSiniestroTest {
    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PagoExpressSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList pagoSiniestro = null;

        try{
            pagoSiniestro = Asesuisa_PagoExpressSiniestroBean.getPagoSiniestroBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<pagoSiniestro.size(); j++){
            Asesuisa_PagoExpressSiniestroBean bean = (Asesuisa_PagoExpressSiniestroBean)pagoSiniestro.get(j);
            Asesuisa_PagoExpressSiniestro a = new Asesuisa_PagoExpressSiniestro();
            Metodos m = new Metodos();
            String horaC = m.horaCarpeta();

            try{
            a.testLink(bean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }
    @Before
    public void setUp(String num) throws Exception {

/*
     DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTRO_PAGOEXPRESS ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTRO_PAGOEXPRESS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagoExpressSiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTRO_PAGOEXPRESS ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTRO_PAGOEXPRESS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagoExpressSiniestro_dataset" + num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagoExpressSiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPagoExpressSiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}

