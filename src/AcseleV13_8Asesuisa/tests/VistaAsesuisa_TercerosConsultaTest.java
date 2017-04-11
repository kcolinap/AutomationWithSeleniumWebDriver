package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosConsultaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosConsulta;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 21/02/2017.
 */
public class VistaAsesuisa_TercerosConsultaTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosConsultaTest.class);

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosConsulta = null;

        try{
            asesuisaTercerosConsulta = Asesuisa_TercerosConsultaBean.getTecerosConsultaBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosConsulta.size(); j++){
            Asesuisa_TercerosConsultaBean asesuisaTercerosConsultaBean = (Asesuisa_TercerosConsultaBean)asesuisaTercerosConsulta.get(j);
            Asesuisa_TercerosConsulta a = new Asesuisa_TercerosConsulta();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try{
                a.testLink(asesuisaTercerosConsultaBean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }
    @Before
    public void setUp(String num) throws Exception {


        /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCEROS_CONSULTA ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_CONSULTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosConsulta_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TERCEROS_CONSULTA ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_CONSULTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosConsulta_dataset" + num + ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosConsulta_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosConsulta_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
