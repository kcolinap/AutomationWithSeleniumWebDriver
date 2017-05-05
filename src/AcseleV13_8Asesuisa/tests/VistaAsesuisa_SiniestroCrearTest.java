package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroCrearBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_SiniestroCrear;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 02/05/2017.
 */
public class VistaAsesuisa_SiniestroCrearTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_SiniestroCrearTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList asesuisaSiniestroCrear = null;

        try{
            asesuisaSiniestroCrear = Asesuisa_SiniestroCrearBean.getSiniestroCrearBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaSiniestroCrear.size(); j++){
            Asesuisa_SiniestroCrearBean bean = (Asesuisa_SiniestroCrearBean)asesuisaSiniestroCrear.get(j);
            Asesuisa_SiniestroCrear a = new Asesuisa_SiniestroCrear();
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


        /*DataSetManager.createPartialDataSet("SELECT * FROM Asesuisa_Siniestro_Crear ORDER BY PRUEBA ASC",
                "Asesuisa_Siniestro_Crear",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroCrear_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM Asesuisa_Siniestro_Crear ORDER BY PRUEBA ASC",
                "Asesuisa_Siniestro_Crear",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroCrear_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroCrear_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroCrear_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
