package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestroBusquedaAvanzadaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_SiniestroBusquedaAvanzada;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 18/05/2017.
 */
public class VistaAsesuisa_SiniestroBusquedaAvanzadaTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_SiniestroBusquedaAvanzadaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList asesuisaSiniestroBusquedaAvanzada = null;

        try{
            asesuisaSiniestroBusquedaAvanzada = Asesuisa_SiniestroBusquedaAvanzadaBean.getSiniestroBusquedaAvanzada();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaSiniestroBusquedaAvanzada.size(); j++){
            Asesuisa_SiniestroBusquedaAvanzadaBean bean = (Asesuisa_SiniestroBusquedaAvanzadaBean)asesuisaSiniestroBusquedaAvanzada.get(j);
            Asesuisa_SiniestroBusquedaAvanzada a = new Asesuisa_SiniestroBusquedaAvanzada();
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

    @Before
    public void setUp(String num) throws Exception {


       /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTRO_BAVANZADA ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTRO_BAVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaAvanzada_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTRO_BAVANZADA ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTRO_BAVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaAvanzada_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaAvanzada_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaSiniestroBusquedaAvanzada_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
