package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaVariasURBean;
import AcseleV13_8.main.controller.EmisionPolizaVariasUR;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 18/07/2016.
 */
public class VistaEmisionPolizaVariasURTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaVariasURTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = null;

        try {
            emision = EmisionPolizaVariasURBean.getEmisionPolizaVariasUR();
        }catch (SQLException e) {
            log.error(e);
        }

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

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_UNIDAD_RIESGO2, NUMERO_CREDITO2, MONTO_ASEGURADO2, FACTOR_VIDA2, VALOR_SEGURO_PRIMA2, FECHA_DESEMBOLSO2, VALOR_PRESTAMO2, CUOTAS_PACTADAS2, SALDO_CAPITAL2, ESTADO_CREDITO2, CUOTAS_MORA2, FECHA_PROCESO2, FECHA_PAGO2, CUOTA_PAGADA2, FECHA_MORA2, PORCENTAJE_FACULTATIVO2 FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC",
                "POLIZA_UNIDADES_RIESGO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaVariasUR_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_UNIDAD_RIESGO2, NUMERO_CREDITO2, MONTO_ASEGURADO2, FACTOR_VIDA2, VALOR_SEGURO_PRIMA2, FECHA_DESEMBOLSO2, VALOR_PRESTAMO2, CUOTAS_PACTADAS2, SALDO_CAPITAL2, ESTADO_CREDITO2, CUOTAS_MORA2, FECHA_PROCESO2, FECHA_PAGO2, CUOTA_PAGADA2, FECHA_MORA2, PORCENTAJE_FACULTATIVO2 FROM POLIZA_UNIDADES_RIESGO ORDER BY PRUEBA ASC",
                "POLIZA_UNIDADES_RIESGO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaVariasUR_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaVariasUR_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaVariasUR_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
