package tests;

import beans.EmisionPolizaInclusionTomadoresBean;
import main.controller.EmisionPolizaInclusionTomadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 28/07/2016.
 */
public class VistaEmisionPolizaInclusionTomadoresTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaVariasURTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = EmisionPolizaInclusionTomadoresBean.getEmisionPolizaInclusionTomadores();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaInclusionTomadoresBean emisionPolizaInclusionTomadoresBean = (EmisionPolizaInclusionTomadoresBean) emision.get(i);
            EmisionPolizaInclusionTomadores a = new EmisionPolizaInclusionTomadores();

            try {
                a.testLink(emisionPolizaInclusionTomadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR FROM POLIZA_INCLUION_TOMADOR ORDER BY PRUEBA ASC",
                "POLIZA_INCLUION_TOMADOR",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaInclusionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, PORCENTAJE_TOMADOR FROM POLIZA_INCLUION_TOMADOR ORDER BY PRUEBA ASC",
                "POLIZA_INCLUION_TOMADOR",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaInclusionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
