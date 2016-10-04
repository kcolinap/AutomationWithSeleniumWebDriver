package AcseleV13_8.tests;

import AcseleV13_8.beans.ReabrirSiniestroBean;
import AcseleV13_8.main.controller.ReabrirSiniestro;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 23/09/2016.
 */
public class VistaReabrirSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaReabrirSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList reabrirSiniestros = ReabrirSiniestroBean.getReabrirSiestros();


        for (int j = 0; j< reabrirSiniestros.size(); j++) {
            ReabrirSiniestroBean reabrirSiniestroBean = (ReabrirSiniestroBean) reabrirSiniestros.get(j);
            ReabrirSiniestro a = new ReabrirSiniestro();

            try {
                a.testLink(reabrirSiniestroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Reapertura,Comentario_Siniestro  from REABRIR_SINIESTRO ORDER BY PRUEBA ASC",
                "REABRIR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/reabrirSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Reapertura,Comentario_Siniestro  from REABRIR_SINIESTRO ORDER BY PRUEBA ASC",
                "REABRIR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/reabrirSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/reabrirSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/reabrirSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
