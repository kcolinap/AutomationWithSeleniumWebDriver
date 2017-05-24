package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_EdicionModificacionSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_EdicionModificacionSiniestro;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ValidacionOperacionSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 19/05/2017.
 */
public class VistaAsesuisa_EdicionModificacionSiniestroTest {
    private final static Logger Log = Logger.getLogger(VistaAsesuisa_EdicionModificacionSiniestroTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList edicionSiniestro = null;

        try{
            edicionSiniestro = Asesuisa_EdicionModificacionSiniestroBean.getEdicionSiniestroBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<edicionSiniestro.size(); j++){
            Asesuisa_EdicionModificacionSiniestroBean bean = (Asesuisa_EdicionModificacionSiniestroBean)edicionSiniestro.get(j);
            Asesuisa_EdicionModificacionSiniestro a = new Asesuisa_EdicionModificacionSiniestro();
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


     /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_EDICIONSINIESTRO ORDER BY PRUEBA ASC",
                "ASESUISA_EDICIONSINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEdicionSiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_EDICIONSINIESTRO ORDER BY PRUEBA ASC",
                "ASESUISA_EDICIONSINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaEdicionSiniestro_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEdicionSiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaEdicionSiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}

