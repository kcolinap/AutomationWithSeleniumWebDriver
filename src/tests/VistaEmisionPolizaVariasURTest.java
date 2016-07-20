package tests;

import beans.EmisionPolizaVariasURBean;
import main.controller.EmisionPolizaVariasUR;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 18/07/2016.
 */
public class VistaEmisionPolizaVariasURTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaVariasURTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = EmisionPolizaVariasURBean.getEmisionPolizaVariasUR();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaVariasURBean emisionPolizaVariasURBean = (EmisionPolizaVariasURBean) emision.get(i);
            EmisionPolizaVariasUR a = new EmisionPolizaVariasUR();

            try {
                a.testLink(emisionPolizaVariasURBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO1, NUM_CREDITO1, MONTO_ASEGURADO1, NUM_UNIDAD_RIESGO2, NUM_CREDITO2, MONTO_ASEGURADO2,  PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC",
                "POLIZA_UNIDADES_RIESGO",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaVariasUR_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO1, NUM_CREDITO1, MONTO_ASEGURADO1, NUM_UNIDAD_RIESGO2, NUM_CREDITO2, MONTO_ASEGURADO2,  PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC",
                "POLIZA_UNIDADES_RIESGO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaVariasUR_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/emisionPolizaVariasUR_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaVariasUR_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
