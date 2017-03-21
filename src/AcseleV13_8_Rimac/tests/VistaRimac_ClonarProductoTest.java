package AcseleV13_8_Rimac.tests;

import AcseleV13_8_Rimac.main.controller.Rimac_ClonarProducto;
import AcseleV13_8_Rimac.beans.Rimac_ClonarProductoBean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 20/03/2017.
 */
public class VistaRimac_ClonarProductoTest {
    private final static Logger Log = Logger.getLogger(VistaRimac_ClonarProductoTest.class);

    @Before
    public void setUp() throws Exception{

        /*DataSetManager.createPartialDataSet("SELECT * FROM RIMAC_CLONARPRODUCTO ORDER BY prueba ASC",
                "RIMAC_CLONARPRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Rimac/tests/xmls/rimacClonarProducto_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM RIMAC_CLONARPRODUCTO ORDER BY prueba ASC",
                "RIMAC_CLONARPRODUCTO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Rimac/tests/xmls/rimacClonarProducto_dataset.xml");
       */ DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacClonarProducto_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{
        ArrayList rimacClonarProducto = null;

        try{
            rimacClonarProducto = Rimac_ClonarProductoBean.getClonarProductoBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<rimacClonarProducto.size(); j++){
            Rimac_ClonarProductoBean rimacClonarProductoBean = (Rimac_ClonarProductoBean)rimacClonarProducto.get(j);
            Rimac_ClonarProducto a = new Rimac_ClonarProducto();
            Metodos rimacMetodos = new Metodos();
            String horaC = rimacMetodos.horaCarpeta();

            try {
                a.testLink(rimacClonarProductoBean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown() throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacClonarProducto_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
