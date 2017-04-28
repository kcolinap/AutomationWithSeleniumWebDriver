package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosInformacionTecnicaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosInformacionTecnica;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by kcolina on 06/03/2017.
 */
public class VistaAsesuisa_TercerosInformacionTecnicaTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosInformacionTecnicaTest.class);

    @Before
    public void setUp(String num) throws Exception{

       /* DataSetManager.createPartialDataSet("select * from asesuisa_terceros_inftec ORDER BY PRUEBA ASC",
                "asesuisa_terceros_inftec",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionTecnica_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("select * from asesuisa_terceros_inftec ORDER BY PRUEBA ASC",
                "asesuisa_terceros_inftec",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionTecnica_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionTecnica_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosInformacionTecnica = null;

        try{
            asesuisaTercerosInformacionTecnica = Asesuisa_TercerosInformacionTecnicaBean.getTercerosInformacionTecnicaBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosInformacionTecnica.size(); j++){
            Asesuisa_TercerosInformacionTecnicaBean asesuisaTercerosInformacionTecnicaBean = (Asesuisa_TercerosInformacionTecnicaBean)asesuisaTercerosInformacionTecnica.get(j);
            Asesuisa_TercerosInformacionTecnica a = new Asesuisa_TercerosInformacionTecnica();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
                a.testLink(asesuisaTercerosInformacionTecnicaBean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown(String num) throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionTecnica_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
