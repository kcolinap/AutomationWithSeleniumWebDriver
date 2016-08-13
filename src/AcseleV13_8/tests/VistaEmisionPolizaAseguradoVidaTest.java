package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaAseguradoVidaBean;
import AcseleV13_8.main.controller.EmisionPolizaAseguradoVida;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 11/08/2016.
 */
public class VistaEmisionPolizaAseguradoVidaTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaAseguradoVidaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emision = EmisionPolizaAseguradoVidaBean.getEmisionPolizaAseguradoVida();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean = (EmisionPolizaAseguradoVidaBean) emision.get(i);
            EmisionPolizaAseguradoVida a = new EmisionPolizaAseguradoVida();

            try {
                a.testLink(emisionPolizaAseguradoVidaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO, HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV, TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_T, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_AV, TIPO_DOC_ID_AV, NUM_DOCUMENTO_ID_AV, NOMBRE_AV, APELLIDO_AV, PORCENTAJE_AV, NUEVO_PORCENTAJE_AV FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC",
                "POLIZA_ASEGURADO_VIDA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLI_EV, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUM_POLIZA, TIPO_PRODUCCION, PERIODO_GRACIA_DIAS, LINEA_CREDITO, HORA_INI_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERM_MANEJO_CTA_PROV, TIPO_TERCERO_T, TIPO_DOC_ID_T, NUM_DOCUMENTO_ID_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_T, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, ASEGURADO_PRIMARIO, PORCETAJE_EXTRA_PRIMA, PORCETAJE_DESCUENTO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, TIPO_TERCERO_AV, TIPO_DOC_ID_AV, NUM_DOCUMENTO_ID_AV, NOMBRE_AV, APELLIDO_AV, PORCENTAJE_AV, NUEVO_PORCENTAJE_AV FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC",
                "POLIZA_ASEGURADO_VIDA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
