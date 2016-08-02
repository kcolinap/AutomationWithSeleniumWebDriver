package tests;

import beans.EmisionPolizaEliminacionTomadoresBean;
import main.controller.EmisionPolizaEliminacionTomadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 01/08/2016.
 */
public class VistaEmisionPolizaEliminacionTomadoresTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaEliminacionTomadoresTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = EmisionPolizaEliminacionTomadoresBean.getEmisionPolizaEliminacionTomadores();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaEliminacionTomadoresBean emisionPolizaEdicionTomadoresBean = (EmisionPolizaEliminacionTomadoresBean) emision.get(i);
            EmisionPolizaEliminacionTomadores a = new EmisionPolizaEliminacionTomadores();

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

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_ELIMINACION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaEliminacionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_ELIMINACION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaEliminacionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/emisionPolizaEliminacionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaEliminacionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
