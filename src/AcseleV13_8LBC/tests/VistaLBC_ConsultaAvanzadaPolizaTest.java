package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.LBC_ConsultaAvanzadaPolizaBean;
import AcseleV13_8LBC.main.controller.LBC_ConsultaAvanzadaPoliza;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 11/10/2016.
 */
public class VistaLBC_ConsultaAvanzadaPolizaTest {

        private final static Logger log = Logger.getLogger(VistaLBC_ConsultaAvanzadaPolizaTest.class);

        @Test
        public void mainTest() throws SQLException {

            ArrayList consultaAvanzada = LBC_ConsultaAvanzadaPolizaBean.getConsultaAvanzadaPolizaBean();

            for (int j = 0; j< consultaAvanzada.size(); j++) {
                LBC_ConsultaAvanzadaPolizaBean lbcConsultaAvanzadaPolizaBean = (LBC_ConsultaAvanzadaPolizaBean) consultaAvanzada.get(j);
                LBC_ConsultaAvanzadaPoliza a = new LBC_ConsultaAvanzadaPoliza();

                try {
                    a.testLink(lbcConsultaAvanzadaPolizaBean, j);
                } catch (Exception e) {
                    e.printStackTrace();
//                log.info(e);
                    log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
                }
            }

        }

        @Before
        public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA,ORDENAR_POR,BUSCAR_POR,PRODUCTO,EDO_CICLO_VIDA, NUM_POLIZA, NUM_PROPUESTA,FECHA_EMISION from CONSULTA_POLIZA_AVANZADA ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_AVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/consultaAvanzadaPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,ORDENAR_POR,BUSCAR_POR,PRODUCTO,EDO_CICLO_VIDA, NUM_POLIZA, NUM_PROPUESTA,FECHA_EMISION from CONSULTA_POLIZA_AVANZADA ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_AVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/consultaAvanzadaPoliza_dataset.xml");
*/
            DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaAvanzadaPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
        }

        @After
        public void tearDown() throws Exception {

            DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaAvanzadaPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
        }

}




