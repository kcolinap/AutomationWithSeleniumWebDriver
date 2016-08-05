package tests;

import beans.EmisionPolizaEdicionTomadoresBean;
import main.controller.EmisionPolizaEdicionTomadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 29/07/2016.
 */
public class VistaEmisionPolizaEdicionTomadoresTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaEdicionTomadoresTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = EmisionPolizaEdicionTomadoresBean.getEmisionPolizaEdicionTomadores();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaEdicionTomadoresBean emisionPolizaEdicionTomadoresBean = (EmisionPolizaEdicionTomadoresBean) emision.get(i);
            EmisionPolizaEdicionTomadores a = new EmisionPolizaEdicionTomadores();

            try {
                a.testLink(emisionPolizaEdicionTomadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1, NUEVO_PORCENTAJE_TOMADOR2 FROM POLIZA_EDICION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_EDICION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaEdicionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1, NUEVO_PORCENTAJE_TOMADOR2 FROM POLIZA_EDICION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_EDICION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaEdicionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/emisionPolizaEdicionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaEdicionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
