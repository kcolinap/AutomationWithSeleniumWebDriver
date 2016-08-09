package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaInclusionTomadoresBean;
import AcseleV13_8.main.controller.EmisionPolizaInclusionTomadores;
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

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaInclusionTomadoresTest.class);

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

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2 FROM POLIZA_INCLUSION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_INCLUSION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/emisionPolizaInclusionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO1, TIPO_DOC_IDENTIDAD1, CEDULA1, NOMBRE1, APELLIDO1, PORCENTAJE_TOMADOR1, TIPO_TERCERO2, TIPO_DOC_IDENTIDAD2, CEDULA2, NOMBRE2, APELLIDO2, PORCENTAJE_TOMADOR2 FROM POLIZA_INCLUSION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_INCLUSION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/emisionPolizaInclusionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
