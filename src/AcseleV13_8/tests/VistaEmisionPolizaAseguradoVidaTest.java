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

/**
 * Emisión de póliza con Asegurado Vida,
 * Edición del Asegurado Vida
 * y Eliminación del Asegurado Vida
 */

public class VistaEmisionPolizaAseguradoVidaTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaAseguradoVidaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emision = null;

        try {
            emision = EmisionPolizaAseguradoVidaBean.getEmisionPolizaAseguradoVida();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaAseguradoVidaBean emisionPolizaAseguradoVidaBean = (EmisionPolizaAseguradoVidaBean) emision.get(i);
            EmisionPolizaAseguradoVida a = new EmisionPolizaAseguradoVida();

            try {
                a.testLink(emisionPolizaAseguradoVidaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, fecha_Efectiva_Aplica_Evento, plan_Financiamiento, moneda, sucursal, numero_Poliza, fecha_Emision, tipo_Produccion, periodo_Gracia, linea_Credito, hora_Iniciacion_Vencimiento, unidad_Negocio, canal_Venta, frecuencia_Pago, tipo_Poliza, tipo_Valor_Asegurado, nivel_Agrupamiento_Reaseguro, permite_Manejo_Cta_Provi, mes_Provisional, anio_Provisional, tomador_Nombre1, tomador_Nombre2, tomador_Apellido1, tomador_Apellido2, porcentaje_Participa_Tomador, numero_Unidad_Riesgo, numero_Credito, monto_Asegurado, factor_Vida, valor_Seguro_Prima, fecha_Desembolso, valor_Prestamo, cuotas_Pactadas, saldo_Capital, estado_Credito, cuotas_Mora, fecha_Proceso, fecha_Pago, cuota_Pagada, fecha_Mora, porcentaje_Facultativo, numero_Objeto_Aseg, asegurado_Primario, porcentaje_Extra_Prima, porcentaje_Descuento, edad_Asegurado, nombre_Completo_Asegurado, nombre_Completo_Beneficiario, num_Obj_Aseg_Contenidos_UR, documento_Identidad_Asegurado, fecha_Nacimiento_Asegurado, direccion_Asegurado, telefono_Fijo, departamento, ciudad, asegurado_Vida_Nombre1, asegurado_Vida_Nombre2, asegurado_Vida_Apellido1, asegurado_Vida_Apellido2, porcen_Participa_Aseg_Vida, nuevo_porcen_Partici_Aseg_Vida FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC",
                "POLIZA_ASEGURADO_VIDA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset .xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, fecha_Efectiva_Aplica_Evento, plan_Financiamiento, moneda, sucursal, numero_Poliza, fecha_Emision, tipo_Produccion, periodo_Gracia, linea_Credito, hora_Iniciacion_Vencimiento, unidad_Negocio, canal_Venta, frecuencia_Pago, tipo_Poliza, tipo_Valor_Asegurado, nivel_Agrupamiento_Reaseguro, permite_Manejo_Cta_Provi, mes_Provisional, anio_Provisional, tomador_Nombre1, tomador_Nombre2, tomador_Apellido1, tomador_Apellido2, porcentaje_Participa_Tomador, numero_Unidad_Riesgo, numero_Credito, monto_Asegurado, factor_Vida, valor_Seguro_Prima, fecha_Desembolso, valor_Prestamo, cuotas_Pactadas, saldo_Capital, estado_Credito, cuotas_Mora, fecha_Proceso, fecha_Pago, cuota_Pagada, fecha_Mora, porcentaje_Facultativo, numero_Objeto_Aseg, asegurado_Primario, porcentaje_Extra_Prima, porcentaje_Descuento, edad_Asegurado, nombre_Completo_Asegurado, nombre_Completo_Beneficiario, num_Obj_Aseg_Contenidos_UR, documento_Identidad_Asegurado, fecha_Nacimiento_Asegurado, direccion_Asegurado, telefono_Fijo, departamento, ciudad, asegurado_Vida_Nombre1, asegurado_Vida_Nombre2, asegurado_Vida_Apellido1, asegurado_Vida_Apellido2, porcen_Participa_Aseg_Vida, nuevo_porcen_Partici_Aseg_Vida FROM POLIZA_ASEGURADO_VIDA ORDER BY PRUEBA ASC",
                "POLIZA_ASEGURADO_VIDA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset .xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset .xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaAseguradoVida_dataset .xml", DataSetManager.DELETE_OPERATION);
    }
}
