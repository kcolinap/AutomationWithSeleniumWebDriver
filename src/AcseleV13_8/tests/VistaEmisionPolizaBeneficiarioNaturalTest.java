package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaBeneficiarioNaturalBean;
import AcseleV13_8.main.controller.EmisionPolizaBeneficiarioNatural;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 02/08/2016.
 */

/**
 * Emisión de póliza con Beneficiario Natural,
 * Edición del Beneficiario Natural
 * y Eliminación del Beneficiario Natural
 */
public class VistaEmisionPolizaBeneficiarioNaturalTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaInclusionTomadoresTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emision = null;

        try {
            emision = EmisionPolizaBeneficiarioNaturalBean.getEmisionPolizaBeneficiarioNatural();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaBeneficiarioNaturalBean emisionPolizaInclusionBeneficiarioNaturalBean = (EmisionPolizaBeneficiarioNaturalBean) emision.get(i);
            EmisionPolizaBeneficiarioNatural a = new EmisionPolizaBeneficiarioNatural();

            try {
                a.testLink(emisionPolizaInclusionBeneficiarioNaturalBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, ASEGURADO_VIDA_NOMBRE1, ASEGURADO_VIDA_NOMBRE2, ASEGURADO_VIDA_APELLIDO1, ASEGURADO_VIDA_APELLIDO2, PORCEN_PARTICIPA_ASEG_VIDA, BENEFICIARIO_NATURAL_NOMBRE1, BENEFICIARIO_NATURAL_NOMBRE2, BENEFICIARIO_NATURAL_APELLIDO1, BENEFICIARIO_NATURAL_APELLIDO2, TIPO_BENEFICIARIO, BENEFICIARIO_IRREVOCABLE, PORCEN_PARTICIP_BENEF_NATURAL, CODIGO_BENEFICIARIO, PARENTESCO, nuevo_tipo_Beneficiario, nuevo_beneficiario_Irrevocable, nuevo_porcen_Parti_Benef_Natur, nuevo_codigo_Beneficiario, nuevo_parentesco FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC",
                "POLIZA_BENEFICIARIO_NATURAL",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaBeneficiarioNatural_dataset2.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR_NOMBRE1, TOMADOR_NOMBRE2, TOMADOR_APELLIDO1, TOMADOR_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, NUMERO_UNIDAD_RIESGO, NUMERO_CREDITO, MONTO_ASEGURADO, FACTOR_VIDA, VALOR_SEGURO_PRIMA, FECHA_DESEMBOLSO, VALOR_PRESTAMO, CUOTAS_PACTADAS, SALDO_CAPITAL, ESTADO_CREDITO, CUOTAS_MORA, FECHA_PROCESO, FECHA_PAGO, CUOTA_PAGADA, FECHA_MORA, PORCENTAJE_FACULTATIVO, NUMERO_OBJETO_ASEG, ASEGURADO_PRIMARIO, PORCENTAJE_EXTRA_PRIMA, PORCENTAJE_DESCUENTO, EDAD_ASEGURADO, NOMBRE_COMPLETO_ASEGURADO, NOMBRE_COMPLETO_BENEFICIARIO, NUM_OBJ_ASEG_CONTENIDOS_UR, DOCUMENTO_IDENTIDAD_ASEGURADO, FECHA_NACIMIENTO_ASEGURADO, DIRECCION_ASEGURADO, TELEFONO_FIJO, DEPARTAMENTO, CIUDAD, ASEGURADO_VIDA_NOMBRE1, ASEGURADO_VIDA_NOMBRE2, ASEGURADO_VIDA_APELLIDO1, ASEGURADO_VIDA_APELLIDO2, PORCEN_PARTICIPA_ASEG_VIDA, BENEFICIARIO_NATURAL_NOMBRE1, BENEFICIARIO_NATURAL_NOMBRE2, BENEFICIARIO_NATURAL_APELLIDO1, BENEFICIARIO_NATURAL_APELLIDO2, TIPO_BENEFICIARIO, BENEFICIARIO_IRREVOCABLE, PORCEN_PARTICIP_BENEF_NATURAL, CODIGO_BENEFICIARIO, PARENTESCO, nuevo_tipo_Beneficiario, nuevo_beneficiario_Irrevocable, nuevo_porcen_Parti_Benef_Natur, nuevo_codigo_Beneficiario, nuevo_parentesco FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC",
                "POLIZA_BENEFICIARIO_NATURAL",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaBeneficiarioNatural_dataset2.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaBeneficiarioNatural_dataset2.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaBeneficiarioNatural_dataset2.xml", DataSetManager.DELETE_OPERATION);
    }
}
