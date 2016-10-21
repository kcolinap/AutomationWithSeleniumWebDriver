package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8LBC.main.controller.LBC_TercerosHabilitarDeshabilitar;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/10/2016.
 */
public class VistaLBC_TercerosHabilitarDeshabilitarTest {

    private final static Logger log = Logger.getLogger(VistaLBC_TercerosHabilitarDeshabilitarTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tercero = null;

        try {
            tercero = LBC_TercerosHabilitarDeshabilitarBean.getLBC_TercerosHabilitarDeshabilitarBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < tercero.size(); j++) {
            LBC_TercerosHabilitarDeshabilitarBean lbcTercerosHabilitarDeshabilitarBean = (LBC_TercerosHabilitarDeshabilitarBean) tercero.get(j);
            LBC_TercerosHabilitarDeshabilitar a = new LBC_TercerosHabilitarDeshabilitar();

            try {
                a.testLink(lbcTercerosHabilitarDeshabilitarBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, APELLIDO_PATERNO, APELLIDO_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, TERCER_NOMBRE, TIPO_DOC_ID, NUM_DOC_ID, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, DIAS_AMPLIACION, PLANES_FINANCIAMIENTO, MONEDAS, TIPO_COASEGURO, OFICINA, NUMERO_POLIZA, NUMERO_PROPUESTA, FECHA_EMISION, TIPO_PRODUCCION, CANAL_VENTA, COMISION_NEGOCIABLE, SEGMENTO, PORCENTAJE_CUOTA_INICIAL, PRIMA_TOTAL, PRIMA_TECNICA_NETA, FECHA_FIN_COTIZACION, OBSERVACIONES_POLIZA, OBSERVACIONES_SUSCRIPCION, VALOR_ASEG_TOTAL_POLIZA_ENDOSO FROM TERCERO_ENABLE_DISABLE_LBC ORDER BY PRUEBA ASC",
                "TERCERO_ENABLE_DISABLE_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcTercerosHabilitarDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, APELLIDO_PATERNO, APELLIDO_MATERNO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, TERCER_NOMBRE, TIPO_DOC_ID, NUM_DOC_ID, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, DIAS_AMPLIACION, PLANES_FINANCIAMIENTO, MONEDAS, TIPO_COASEGURO, OFICINA, NUMERO_POLIZA, NUMERO_PROPUESTA, FECHA_EMISION, TIPO_PRODUCCION, CANAL_VENTA, COMISION_NEGOCIABLE, SEGMENTO, PORCENTAJE_CUOTA_INICIAL, PRIMA_TOTAL, PRIMA_TECNICA_NETA, FECHA_FIN_COTIZACION, OBSERVACIONES_POLIZA, OBSERVACIONES_SUSCRIPCION, VALOR_ASEG_TOTAL_POLIZA_ENDOSO FROM TERCERO_ENABLE_DISABLE_LBC ORDER BY PRUEBA ASC",
                "TERCERO_ENABLE_DISABLE_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcTercerosHabilitarDeshabilitar_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
