package tests;

import beans.TercerosHabilitarDeshabilitarBean;
import main.controller.TercerosHabilitarDeshabilitar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 05/07/2016.
 */
public class VistaTercerosHabilitarDeshabilitarTest {

    private final static Logger log = Logger.getLogger(VistaTercerosHabilitarDeshabilitarTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = TercerosHabilitarDeshabilitarBean.getTercerosHabilitarDeshabilitar();

        for (int i = 0; i < terceros.size(); i++){
            TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean = (TercerosHabilitarDeshabilitarBean) terceros.get(i);
            TercerosHabilitarDeshabilitar a = new TercerosHabilitarDeshabilitar();

            try {
                a.testLink(tercerosHabilitarDeshabilitarBean, i);
            } catch (Exception e){
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC",
                "TERCERO_HABILITAR_DESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/tercerosHabilitarDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC",
                "TERCERO_HABILITAR_DESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/tercerosHabilitarDeshabilitar_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/tercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/tercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
