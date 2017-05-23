package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaSimpleBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_SiniestroBusquedaSimple;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 19/05/2017.
 */
public class VistaAsesuisa_SiniestroBusquedaSimpleTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_SiniestroBusquedaSimpleTest.class);

    @Before
    public void setUp(String num) throws Exception{

       /* DataSetManager.createPartialDataSet("select * from ASESUISA_SINIESTRO_BSIMPLE ORDER BY PRUEBA ASC",
            "ASESUISA_SINIESTRO_BSIMPLE",
            "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaSimple_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("select * from ASESUISA_SINIESTRO_BSIMPLE ORDER BY PRUEBA ASC",
             "ASESUISA_SINIESTRO_BSIMPLE",
             "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaSimple_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaSimple_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @org.junit.Test
    public void mainTest() throws SQLException{

        ArrayList asesuisaSiniestroBusquedaSimple = null;

        try{
            asesuisaSiniestroBusquedaSimple = Asesuisa_SiniestroBusquedaSimpleBean.getSiniestroBusquedaSimpleBean();
        }catch (Exception e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaSiniestroBusquedaSimple.size(); j++){

            Asesuisa_SiniestroBusquedaSimpleBean bean = (Asesuisa_SiniestroBusquedaSimpleBean)asesuisaSiniestroBusquedaSimple.get(j);
            Asesuisa_SiniestroBusquedaSimple a = new Asesuisa_SiniestroBusquedaSimple();
            Metodos m = new Metodos();
            String horaC = m.horaCarpeta();

            try{
                a.TestLink(bean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown(String num) throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaSimple_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
