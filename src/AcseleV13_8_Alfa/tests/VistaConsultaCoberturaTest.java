package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.ConsultaCoberturaBean;
import AcseleV13_8_Alfa.main.controller.ConsultaCobertura;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yalvarez on 28/09/2016.
 */
public class VistaConsultaCoberturaTest {

    private final static Logger log = Logger.getLogger(VistaCancelarPagosTest.class);

    @Test
    public void mainTest() {

        ArrayList consultaCobertura = null;
        try{
            consultaCobertura = ConsultaCoberturaBean.getConsultaCobertura();
        } catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < consultaCobertura.size(); i++) {
            ConsultaCoberturaBean consultaCoberturaBean = (ConsultaCoberturaBean) consultaCobertura.get(i);
            ConsultaCobertura a = new ConsultaCobertura();

            try {
                a.testLink(consultaCoberturaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }



    @Before //preparacion de la prueba para crear el xml
    public void setUp() throws Exception {


   /*     DataSetManager.createPartialDataSet("\n" +
                        "SELECT PRUEBA, PRODUCTO,  ESTADOS_VIDA, CONTRATANTE, ASEGURADO, ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL, NUM_POLIZA, FECHA_EMISION, MONEDA, TIPO_MONEDA, TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENT_ANT, FECHA_PROX_GEN_PRI, FECHA_PROX_FACT, TIPO_POL, NUM_COT, NUM_PRO  FROM ConsultaCobertura ORDER BY PRUEBA ASC",
                "ConsultaCobertura",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xmls/consulta_Cobertura_dataset.xml");

        DataSetManager.createPartialDataSet("\n" +
                        "SELECT PRUEBA, PRODUCTO,  ESTADOS_VIDA, CONTRATANTE, ASEGURADO, ID_POLIZA, FECHA_DESDE, FECHA_HASTA, SUCURSAL, NUM_POLIZA, FECHA_EMISION, MONEDA, TIPO_MONEDA, TIPO_PRODUCCION, TIPO_VIGENCIA, VIGENCIA, CANAL_VENTA, FRECUENCIA_PAGO, FECHA_EVENT_ANT, FECHA_PROX_GEN_PRI, FECHA_PROX_FACT, TIPO_POL, NUM_COT, NUM_PRO  FROM ConsultaCobertura ORDER BY PRUEBA ASC",
                "ConsultaCobertura",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Alfa/tests/xmls/consulta_Cobertura_dataset.xml");

   */     DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/consulta_Cobertura_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/consulta_Cobertura_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
