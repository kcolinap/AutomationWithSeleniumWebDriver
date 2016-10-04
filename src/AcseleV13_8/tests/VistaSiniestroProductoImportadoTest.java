package AcseleV13_8.tests;

import AcseleV13_8.beans.SiniestroProductoImportadoBean;
import AcseleV13_8.main.controller.SiniestroProductoImportado;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 27/09/2016.
 */
public class VistaSiniestroProductoImportadoTest {

    /**
     * Antes de ejecutar esta prueba se debe cumplir con los siguientes pasos:
     * 1. Ejecutar la prueba ExportarImportarProducto
     * 2. acceder al modulo de seguridad de ACSELE http://qa:7001/security/ (de forma manual) para asociar
     * el nuevo producto al usuario.
     * 3. Ejecutar la prueba: Emisiones con el producto importado, de la compañera Adriana Azuaje
     * 4. Obtener el numero de poliza de la prueba anterior y colocarlo en el xml, especificamente en el campo NUMERO_POLIZA
     */

    private final static Logger log = Logger.getLogger(VistaSiniestroProductoImportadoTest.class);

    @Test
    public void mainTest() throws SQLException {

      ArrayList siniestroProductoImportado = SiniestroProductoImportadoBean.getSiniestroProductoImportado();

        for (int i = 0; i < siniestroProductoImportado.size(); i++) {
            SiniestroProductoImportadoBean siniestroProductoImportadoBean = (SiniestroProductoImportadoBean) siniestroProductoImportado.get(i);
            SiniestroProductoImportado a = new SiniestroProductoImportado();


            try {
                a.testLink(siniestroProductoImportadoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

   /*     DataSetManager.createPartialDataSet("SELECT PRUEBA, ORDENAR_POR, PRODUCTO, ESTADOS_CICLO_VIDA ,CONTRATANTE, ASEGURADO ,ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL_POLIZA, NUMERO_POLIZA, FECHA_EMISION, MONEDA_POLIZA, TIPO_MONEDA_POLIZA ,TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENTO_ANTERIOR, FECHA_PROXIMA_GENERACION_PRIMA, FECHA_PROXIMA_FACTURACION, TIPO_POLIZA, NUMERO_COTIZACION, NUMERO_PROPUESTA, FECHA_OCURRENCIA_SINIESTRO, SUCURSAL_SINIESTROS, HORA_OCURRENCIA, FECHA_AVISO_COMPANIA, HORA_NOTIFICACION, FECHA_OPER_CONST_SINIESTRO, FECHA_RECL_FORMALIZACION, FECHA_INTERRUPCION_TERMINOS, DOCUMENTO_IDENT_RECLAMANTE, RECLAMANTE, CAUSA_GENERAL_MUERTE, CAUSALES_ESPECIF_COBERT_MUERTE, DEPARTAMENTO, CIUDAD, GENERO_ASEGURADO, PROFESION_ASEGURADO, ACTIVIDAD_SINIESTRO, FECHA_ACTIVIDAD, OBSERVACIONES_SINIESTRO, CERTIFICADO, OBJETOS_ASEGURADOS, COBERTURA_AFECTADA, PAGO_MAXIMO, MONEDA_SINIESTRO, FECHA_COMPROMISO, FECHA_INICIAL, FECHA_FINAL, RAZON, ESTADO, TIPO, MONTO_SINIESTRO FROM SINIESTROS_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC",
                "SINIESTROS_PRODUCTO_IMPORTADO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/siniestrosProductoImportado_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, ORDENAR_POR, PRODUCTO, ESTADOS_CICLO_VIDA ,CONTRATANTE, ASEGURADO ,ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL_POLIZA, NUMERO_POLIZA, FECHA_EMISION, MONEDA_POLIZA, TIPO_MONEDA_POLIZA ,TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENTO_ANTERIOR, FECHA_PROXIMA_GENERACION_PRIMA, FECHA_PROXIMA_FACTURACION, TIPO_POLIZA, NUMERO_COTIZACION, NUMERO_PROPUESTA, FECHA_OCURRENCIA_SINIESTRO, SUCURSAL_SINIESTROS, HORA_OCURRENCIA, FECHA_AVISO_COMPANIA, HORA_NOTIFICACION, FECHA_OPER_CONST_SINIESTRO, FECHA_RECL_FORMALIZACION, FECHA_INTERRUPCION_TERMINOS, DOCUMENTO_IDENT_RECLAMANTE, RECLAMANTE, CAUSA_GENERAL_MUERTE, CAUSALES_ESPECIF_COBERT_MUERTE, DEPARTAMENTO, CIUDAD, GENERO_ASEGURADO, PROFESION_ASEGURADO, ACTIVIDAD_SINIESTRO, FECHA_ACTIVIDAD, OBSERVACIONES_SINIESTRO, CERTIFICADO, OBJETOS_ASEGURADOS, COBERTURA_AFECTADA, PAGO_MAXIMO, MONEDA_SINIESTRO, FECHA_COMPROMISO, FECHA_INICIAL, FECHA_FINAL, RAZON, ESTADO, TIPO, MONTO_SINIESTRO FROM SINIESTROS_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC",
                "SINIESTROS_PRODUCTO_IMPORTADO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/siniestrosProductoImportado_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/siniestrosProductoImportado_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/siniestrosProductoImportado_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
