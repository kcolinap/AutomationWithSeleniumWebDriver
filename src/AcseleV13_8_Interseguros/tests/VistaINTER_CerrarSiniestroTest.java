package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CerrarSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CerrarSiniestro;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 28/12/2016.
 */
public class VistaINTER_CerrarSiniestroTest {

        private final static Logger log = Logger.getLogger(VistaINTER_CerrarSiniestroTest.class);

        @Test
        public void mainTest() throws SQLException {

            ArrayList interCerrarSiniestro = INTER_CerrarSiniestroBean.getINTER_CerrarSiniestro();

            for (int j = 0; j< interCerrarSiniestro.size(); j++) {
                INTER_CerrarSiniestroBean inter_cerrarSiniestroBean = (INTER_CerrarSiniestroBean) interCerrarSiniestro.get(j);
                INTER_CerrarSiniestro a = new INTER_CerrarSiniestro();

                try {
                    //a.testLink(inter_cerrarSiniestroBean, j);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
                }
            }

        }

        @Before
        public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Numero_Poliza,Numero_Siniestro,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre, Comentarios_Siniestro from INTER_CERRAR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_CERRAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCerrarSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Numero_Poliza,Numero_Siniestro,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre, Comentarios_Siniestro from INTER_CERRAR_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_CERRAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCerrarSiniestro_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCerrarSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);

        }

        @After
        public void tearDown() throws Exception {

            DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCerrarSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
        }

}
