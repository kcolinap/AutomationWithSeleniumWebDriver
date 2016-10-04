package AcseleV13_8.tests;

import AcseleV13_8.beans.CerrarSiniestrosBean;
import AcseleV13_8.main.controller.CerrarSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 13/09/2016.
 */
public class VistaCerrarSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaCerrarSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cerrarSiniestros = CerrarSiniestrosBean.getCerrarSiestros();

        for (int j = 0; j< cerrarSiniestros.size(); j++) {
            CerrarSiniestrosBean cerrarSiniestrosBean = (CerrarSiniestrosBean) cerrarSiniestros.get(j);
            CerrarSiniestros a = new CerrarSiniestros();

            try {
                a.testLink(cerrarSiniestrosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre from CERRAR_SINIESTRO ORDER BY PRUEBA ASC",
                "CERRAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/cerrarSiniestros_dataset_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Motivo_Cierre from CERRAR_SINIESTRO ORDER BY PRUEBA ASC",
                "CERRAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/cerrarSiniestros_dataset_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cerrarSiniestros_dataset_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cerrarSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
