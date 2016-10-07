package AcseleV13_8.tests;

import AcseleV13_8.beans.TercerosLineaCreditoGarantiaBean;
import AcseleV13_8.main.controller.TercerosLineaCreditoGarantia;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 04/07/2016.
 */
public class VistaTercerosLineaCreditoGarantiaTest {

    private final static Logger log = Logger.getLogger(VistaTercerosLineaCreditoGarantiaTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = null;

        try {
            terceros = TercerosLineaCreditoGarantiaBean.getTercerosLinaCreditoGarantia();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < terceros.size(); i++){

            TercerosLineaCreditoGarantiaBean tercerosLineaCreditoGarantiaBean = (TercerosLineaCreditoGarantiaBean) terceros.get(i);
            TercerosLineaCreditoGarantia a = new TercerosLineaCreditoGarantia();

            try {
                a.testLink(tercerosLineaCreditoGarantiaBean, i);
            }catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, TIPOS, MONTOS, DESCRIPCION, FECHA_DESDE, FECHA_HASTA FROM TERCERO_LINEA_CREDITO_GARANTIA ORDER BY PRUEBA ASC",
                "TERCERO_LINEA_CREDITO_GARANTIA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/tercerosLineaCreditoGarantia_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, TIPOS, MONTOS, DESCRIPCION, FECHA_DESDE, FECHA_HASTA FROM TERCERO_LINEA_CREDITO_GARANTIA ORDER BY PRUEBA ASC",
                "TERCERO_LINEA_CREDITO_GARANTIA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/tercerosLineaCreditoGarantia_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosLineaCreditoGarantia_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosLineaCreditoGarantia_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
