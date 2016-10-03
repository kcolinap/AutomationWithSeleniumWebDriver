package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaInclusionTomadoresBean;
import AcseleV13_8.main.controller.EmisionPolizaInclusionTomadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 28/07/2016.
 */
public class VistaEmisionPolizaInclusionTomadoresTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaInclusionTomadoresTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = null;

        try {
            emision = EmisionPolizaInclusionTomadoresBean.getEmisionPolizaInclusionTomadores();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaInclusionTomadoresBean emisionPolizaInclusionTomadoresBean = (EmisionPolizaInclusionTomadoresBean) emision.get(i);
            EmisionPolizaInclusionTomadores a = new EmisionPolizaInclusionTomadores();

            try {
                a.testLink(emisionPolizaInclusionTomadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR1_NOMBRE1, TOMADOR1_NOMBRE2, TOMADOR1_APELLIDO1, TOMADOR1_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, TOMADOR2_NOMBRE1, TOMADOR2_NOMBRE2, TOMADOR2_APELLIDO1, TOMADOR2_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR2 FROM POLIZA_INCLUSION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_INCLUSION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR1_NOMBRE1, TOMADOR1_NOMBRE2, TOMADOR1_APELLIDO1, TOMADOR1_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, TOMADOR2_NOMBRE1, TOMADOR2_NOMBRE2, TOMADOR2_APELLIDO1, TOMADOR2_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR2 FROM POLIZA_INCLUSION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_INCLUSION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaInclusionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
