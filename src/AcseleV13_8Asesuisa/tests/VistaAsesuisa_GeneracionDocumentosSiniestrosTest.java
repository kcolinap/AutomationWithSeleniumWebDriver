package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_GeneracionDocumentosSiniestrosBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_GeneracionDocumentosSiniestros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ValidacionOperacionSiniestro;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 17/05/2017.
 */
public class VistaAsesuisa_GeneracionDocumentosSiniestrosTest {
    private final static Logger Log = Logger.getLogger(VistaAsesuisa_GeneracionDocumentosSiniestrosTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList docSiniestro = null;

        try{
            docSiniestro = Asesuisa_GeneracionDocumentosSiniestrosBean.getDocumentoSiniestroBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<docSiniestro.size(); j++){
            Asesuisa_GeneracionDocumentosSiniestrosBean bean = (Asesuisa_GeneracionDocumentosSiniestrosBean)docSiniestro.get(j);
            Asesuisa_GeneracionDocumentosSiniestros a = new Asesuisa_GeneracionDocumentosSiniestros();
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


       /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_GENERADOCSIN ORDER BY PRUEBA ASC",
                "ASESUISA_GENERADOCSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaGeneradocSiniestro_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_GENERADOCSIN ORDER BY PRUEBA ASC",
                "ASESUISA_GENERADOCSIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaGeneradocSiniestro_dataset" + num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaGeneradocSiniestro_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaGeneradocSiniestro_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}

