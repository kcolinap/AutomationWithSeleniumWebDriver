package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaVariosOABean;
import AcseleV13_8.main.controller.EmisionPolizaVariosOA;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/07/2016.
 */
public class VistaEmisionPolizaVariosOATest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaVariosOATest.class);

    @Test
    public void mainTest() {

        ArrayList emision = null;

        try {
            emision = EmisionPolizaVariosOABean.getEmisionPolizaVariosOA();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaVariosOABean emisionPolizaVariosOABean = (EmisionPolizaVariosOABean) emision.get(i);
            EmisionPolizaVariosOA a = new EmisionPolizaVariosOA();

            try {
                a.testLink(emisionPolizaVariosOABean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, NUMERO_OBJETO_ASEG2, ASEGURADO_PRIMARIO2, PORCENTAJE_EXTRA_PRIMA2, PORCENTAJE_DESCUENTO2, EDAD_ASEGURADO2, NOMBRE_COMPLETO_ASEGURADO2, NOMBRE_COMPLETO_BENEFICIARIO2, NUM_OBJ_ASEG_CONTENIDOS_UR2, DOCUMENTO_IDENTIDAD_ASEGURADO2, FECHA_NACIMIENTO_ASEGURADO2, DIRECCION_ASEGURADO2, TELEFONO_FIJO2, DEPARTAMENTO2, CIUDAD2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC",
                "POLIZA_OBJETOS_ASEGURADOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaVariosOA_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, NUMERO_OBJETO_ASEG2, ASEGURADO_PRIMARIO2, PORCENTAJE_EXTRA_PRIMA2, PORCENTAJE_DESCUENTO2, EDAD_ASEGURADO2, NOMBRE_COMPLETO_ASEGURADO2, NOMBRE_COMPLETO_BENEFICIARIO2, NUM_OBJ_ASEG_CONTENIDOS_UR2, DOCUMENTO_IDENTIDAD_ASEGURADO2, FECHA_NACIMIENTO_ASEGURADO2, DIRECCION_ASEGURADO2, TELEFONO_FIJO2, DEPARTAMENTO2, CIUDAD2 FROM POLIZA_OBJETOS_ASEGURADOS ORDER BY PRUEBA ASC",
                "POLIZA_OBJETOS_ASEGURADOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaVariosOA_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaVariosOA_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaVariosOA_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
