package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosInformacionFinancieraBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosInformacionFinanciera;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by cortiz on 26/04/2017.
 */
public class VistaAsesuisa_TercerosInformacionFinancieraTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosInformacionFinancieraTest.class);

    @Before
    public void setUp(String num) throws Exception{

      /*  DataSetManager.createPartialDataSet("select * from ASESUISA_TERCEROS_INFFIN ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_INFFIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionFinan_dataset"+ num + ".xml");

        DataSetManager.createPartialDataSet("select * from ASESUISA_TERCEROS_INFFIN ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_INFFIN",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionFinan_dataset"+ num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionFinan_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosInformacionFinanciera = null;

        try{
            asesuisaTercerosInformacionFinanciera = Asesuisa_TercerosInformacionFinancieraBean.getTercerosInformacionFinancieraBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosInformacionFinanciera.size(); j++){
            Asesuisa_TercerosInformacionFinancieraBean asesuisaTercerosInformacionFinancieraBean = (Asesuisa_TercerosInformacionFinancieraBean) asesuisaTercerosInformacionFinanciera.get(j);
            Asesuisa_TercerosInformacionFinanciera a = new Asesuisa_TercerosInformacionFinanciera();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
                a.testLink(asesuisaTercerosInformacionFinancieraBean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown(String num) throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosInformacionFinan_dataset"  + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
