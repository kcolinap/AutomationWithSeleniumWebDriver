package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionPolizaEliminacionTomadoresBean;
import AcseleV13_8.main.controller.EmisionPolizaEliminacionTomadores;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 01/08/2016.
 */
public class VistaEmisionPolizaEliminacionTomadoresTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaEliminacionTomadoresTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emision = null;

        try {
            emision = EmisionPolizaEliminacionTomadoresBean.getEmisionPolizaEliminacionTomadores();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaEliminacionTomadoresBean emisionPolizaEdicionTomadoresBean = (EmisionPolizaEliminacionTomadoresBean) emision.get(i);
            EmisionPolizaEliminacionTomadores a = new EmisionPolizaEliminacionTomadores();

            try {
                a.testLink(emisionPolizaEdicionTomadoresBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR1_NOMBRE1, TOMADOR1_NOMBRE2, TOMADOR1_APELLIDO1, TOMADOR1_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, TOMADOR2_NOMBRE1, TOMADOR2_NOMBRE2, TOMADOR2_APELLIDO1, TOMADOR2_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_ELIMINACION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionPolizaEliminacionTomadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, FECHA_MOVIMIENTO, FECHA_EFECTIVA_APLICA_EVENTO, PLAN_FINANCIAMIENTO, MONEDA, SUCURSAL, NUMERO_POLIZA, FECHA_EMISION, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, HORA_INICIACION_VENCIMIENTO, UNIDAD_NEGOCIO, CANAL_VENTA, FRECUENCIA_PAGO, TIPO_POLIZA, TIPO_VALOR_ASEGURADO, NIVEL_AGRUPAMIENTO_REASEGURO, PERMITE_MANEJO_CTA_PROVI, MES_PROVISIONAL, ANIO_PROVISIONAL, TOMADOR1_NOMBRE1, TOMADOR1_NOMBRE2, TOMADOR1_APELLIDO1, TOMADOR1_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR, TOMADOR2_NOMBRE1, TOMADOR2_NOMBRE2, TOMADOR2_APELLIDO1, TOMADOR2_APELLIDO2, PORCENTAJE_PARTICIPA_TOMADOR2, NUEVO_PORCENTAJE_TOMADOR1 FROM POLIZA_ELIMINACION_TOMADORES ORDER BY PRUEBA ASC",
                "POLIZA_ELIMINACION_TOMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionPolizaEliminacionTomadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaEliminacionTomadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionPolizaEliminacionTomadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
