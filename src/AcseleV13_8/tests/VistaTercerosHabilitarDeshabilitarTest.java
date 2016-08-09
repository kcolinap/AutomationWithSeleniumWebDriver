package AcseleV13_8.tests;

import AcseleV13_8.beans.TercerosHabilitarDeshabilitarBean;
import AcseleV13_8.main.controller.TercerosHabilitarDeshabilitar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 12/07/2016.
 */
public class VistaTercerosHabilitarDeshabilitarTest {

    private final static Logger log = Logger.getLogger(VistaTercerosHabilitarDeshabilitarTest.class);

    @Test
    public void mainTest(){

        ArrayList tercerosHabDes = TercerosHabilitarDeshabilitarBean.getTerceroHabilitarDeshabilitar();

        for (int i = 0; i < tercerosHabDes.size(); i++){
            TercerosHabilitarDeshabilitarBean tercerosHabilitarDeshabilitarBean = (TercerosHabilitarDeshabilitarBean) tercerosHabDes.get(i);
            TercerosHabilitarDeshabilitar a = new TercerosHabilitarDeshabilitar();

            try {
                a.testLink(tercerosHabilitarDeshabilitarBean, i);
            } catch (Exception e){
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC",
                "TERCERO_HABILITAR_DESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/tercerosHabilitarDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO FROM TERCERO_HABILITAR_DESHABILITAR  ORDER BY PRUEBA ASC",
                "TERCERO_HABILITAR_DESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/tercerosHabilitarDeshabilitar_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
