package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosHabilitarDeshabilitar;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 24/02/2017.
 */
public class VistaAsesuisa_TercerosHabilitarDeshabilitarTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosHabilitarDeshabilitarTest.class);

    @Before
    public void setUp() throws Exception{

/*

        DataSetManager.createPartialDataSet("select * from ASESUISA_TERCEROS_habdes ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_habdes",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabilitarDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("select * from ASESUISA_TERCEROS_habdes ORDER BY PRUEBA ASC",
                "ASESUISA_TERCEROS_habdes",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabilitarDeshabilitar_dataset.xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosHabilitarDeshabilitar = null;

        try{
            asesuisaTercerosHabilitarDeshabilitar = Asesuisa_TercerosHabilitarDeshabilitarBean.getTecerosHabilitarDeshabilitarBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosHabilitarDeshabilitar.size(); j++){
            Asesuisa_TercerosHabilitarDeshabilitarBean asesuisaTercerosHabilitarDeshabilitarBean = (Asesuisa_TercerosHabilitarDeshabilitarBean)asesuisaTercerosHabilitarDeshabilitar.get(j);
            Asesuisa_TercerosHabilitarDeshabilitar a = new Asesuisa_TercerosHabilitarDeshabilitar();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
                a.testLink(asesuisaTercerosHabilitarDeshabilitarBean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown() throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
