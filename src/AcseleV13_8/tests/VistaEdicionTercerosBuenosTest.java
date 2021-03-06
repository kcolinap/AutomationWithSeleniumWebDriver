package AcseleV13_8.tests;

import AcseleV13_8.beans.EdicionTercerosBuenosBean;
import AcseleV13_8.main.controller.EdicionTerceroBueno;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 31/05/2016.
 */
public class VistaEdicionTercerosBuenosTest {

    private final static Logger log = Logger.getLogger(VistaEdicionTercerosBuenosTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList edicionTercerosBuenos = null;

        try {
            edicionTercerosBuenos = EdicionTercerosBuenosBean.getEdicionTercerosBuenos();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < edicionTercerosBuenos.size(); i++) {

            EdicionTercerosBuenosBean edicionTercerosBuenosBean = (EdicionTercerosBuenosBean) edicionTercerosBuenos.get(i);
            EdicionTerceroBueno a = new EdicionTerceroBueno();

            try {
                a.testLink(edicionTercerosBuenosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, NOMBRE_NUEVO, APELLIDO_NUEVO from EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/edicionTercerosBuenos_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, NOMBRE_NUEVO, APELLIDO_NUEVO from EDICION_TERCEROS ORDER BY PRUEBA ASC",
                "EDICION_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/edicionTercerosBuenos_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/edicionTercerosBuenos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/edicionTercerosBuenos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
