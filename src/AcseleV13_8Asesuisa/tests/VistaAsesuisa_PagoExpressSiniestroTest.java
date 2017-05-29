package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ValidacionOperacionSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 09/05/2017.
 */
public class VistaAsesuisa_PagoExpressSiniestroTest {
    private final static Logger Log = Logger.getLogger(VistaAsesuisa_PagoExpressSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList operacionSiniestro = null;

        try{
            operacionSiniestro = Asesuisa_ValidacionOperacionSiniestroBean.getOperacionSiniestroBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<operacionSiniestro.size(); j++){
            Asesuisa_ValidacionOperacionSiniestroBean bean = (Asesuisa_ValidacionOperacionSiniestroBean)operacionSiniestro.get(j);
            Asesuisa_ValidacionOperacionSiniestro a = new Asesuisa_ValidacionOperacionSiniestro();
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


       /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaValidaSiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MANTENIMIENTOSIN ORDER BY PRUEBA ASC",
                "ASESUISA_MANTENIMIENTOSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaValidaSiniestro_dataset" + num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaValidaSiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaValidaSiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}

