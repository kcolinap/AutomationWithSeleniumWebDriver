package tests;

import beans.EmisionPolizaVariosOABean;
import main.controller.EmisionPolizaVariosOA;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 20/07/2016.
 */
public class VistaEmisionPolizaVariosOATest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaVariosOATest.class);

    @Test
    public void mainTest() {

        ArrayList emision = EmisionPolizaVariosOABean.getEmisionPolizaVariosOA();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaVariosOABean emisionPolizaVariosOABean = (EmisionPolizaVariosOABean) emision.get(i);
            EmisionPolizaVariosOA a = new EmisionPolizaVariosOA();

            try {
                a.testLink(emisionPolizaVariosOABean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 26 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2, PORCETAJE_DESCUENTO_2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC",
                "POLIZA_OBJETOS_ASEGURADOS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaVariosOA_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, PORCETAJE_EXTRA_PRIMA_1, PORCETAJE_DESCUENTO_1, PORCETAJE_EXTRA_PRIMA_2, PORCETAJE_DESCUENTO_2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC",
                "POLIZA_OBJETOS_ASEGURADOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaVariosOA_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/emisionPolizaVariosOA_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaVariosOA_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
