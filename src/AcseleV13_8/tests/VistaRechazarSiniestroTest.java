package AcseleV13_8.tests;

import AcseleV13_8.beans.RechazarSiniestroBean;
import AcseleV13_8.main.controller.RechazarSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 22/09/2016.
 */
public class VistaRechazarSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaRechazarSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList rechazarSiniestros = RechazarSiniestroBean.getRechazarSiestros();

        for (int j = 0; j< rechazarSiniestros.size(); j++) {
            RechazarSiniestroBean rechazarSiniestroBean = (RechazarSiniestroBean) rechazarSiniestros.get(j);
            RechazarSiniestros a = new RechazarSiniestros();

            try {
                a.testLink(rechazarSiniestroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Objecion,Fecha_Objecion,Comentario_Siniestro  from RECHAZAR_SINIESTRO ORDER BY PRUEBA ASC",
                "RECHAZAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/rechazarSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Objecion,Fecha_Objecion,Comentario_Siniestro  from RECHAZAR_SINIESTRO ORDER BY PRUEBA ASC",
                "RECHAZAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/rechazarSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/rechazarSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/rechazarSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
