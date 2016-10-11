package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.GeneracionDocumentosSiniestrosBean;
import AcseleV13_8_Alfa.main.controller.GeneracionDocumentosSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 23/09/2016.
 */
public class VistaGeneracionDocumentosSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaAjustesReservasSiniestrosTest.class);

    @Test
    public void mainTest() {

        ArrayList conPago = null;

        try {
            conPago = GeneracionDocumentosSiniestrosBean.getGeneracionDocumentosSiniestros();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < conPago.size(); i++) {

            GeneracionDocumentosSiniestrosBean generacionDocumentosSiniestrosBean = (GeneracionDocumentosSiniestrosBean) conPago.get(i);
            GeneracionDocumentosSiniestros a = new GeneracionDocumentosSiniestros();

            try {
                 a.testLink(generacionDocumentosSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO FROM DOCUMENTOS_SINIESTROS ORDER BY PRUEBA ASC",
                "DOCUMENTOS_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele2/src/AcseleV13_8_Alfa/tests/xmls/generacionDocumentosSiniestros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, FECHA_OCURRENCIA_SINIESTRO, NUM_POLIZA, NUM_SINIESTRO, ORDENAR_POR, PRODUCTO FROM DOCUMENTOS_SINIESTROS ORDER BY PRUEBA ASC",
                "DOCUMENTOS_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele2/target/classes/AcseleV13_8_Alfa/tests/xmls/generacionDocumentosSiniestros_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/generacionDocumentosSiniestros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/generacionDocumentosSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
