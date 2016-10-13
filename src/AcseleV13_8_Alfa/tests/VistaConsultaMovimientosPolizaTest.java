package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.ConsultaMovimientosPolizaBean;
import AcseleV13_8_Alfa.main.controller.ConsultaMovimientosPoliza;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 28/09/2016.
 */
public class VistaConsultaMovimientosPolizaTest {

    private final static Logger log = Logger.getLogger(VistaAjustesReservasSiniestrosTest.class);

    @Test
    public void mainTest() {

        ArrayList consulta = null;

        try {
            consulta = ConsultaMovimientosPolizaBean.getConsultaMovimientosPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < consulta.size(); i++) {

            ConsultaMovimientosPolizaBean consultaMovimientosPolizaBean = (ConsultaMovimientosPolizaBean) consulta.get(i);
            ConsultaMovimientosPoliza a = new ConsultaMovimientosPoliza();

            try {
                a.testLink(consultaMovimientosPolizaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, ORDENAR_POR, PRODUCTO, ESTADOS_VIDA, CONTRATANTE, ASEGURADO, ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL, NUM_POLIZA, FECHA_EMISION, MONEDA, TIPO_MONEDA, TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENT_ANT, FECHA_PROX_GEN_PRI, FECHA_PROX_FACT, TIPO_POL, NUM_COT, NUM_PRO FROM CONSULTA_MOV_POL ORDER BY PRUEBA ASC",
                "CONSULTA_MOV_POL",
                "C:/AcseleTests/AutomationTestAcsele2/src/AcseleV13_8_Alfa/tests/xmls/consultaMovimientosPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, ORDENAR_POR, PRODUCTO, ESTADOS_VIDA, CONTRATANTE, ASEGURADO, ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL, NUM_POLIZA, FECHA_EMISION, MONEDA, TIPO_MONEDA, TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENT_ANT, FECHA_PROX_GEN_PRI, FECHA_PROX_FACT, TIPO_POL, NUM_COT, NUM_PRO FROM CONSULTA_MOV_POL ORDER BY PRUEBA ASC",
                "CONSULTA_MOV_POL",
                "C:/AcseleTests/AutomationTestAcsele2/target/classes/AcseleV13_8_Alfa/tests/xmls/consultaMovimientosPoliza_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/consultaMovimientosPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/consultaMovimientosPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
