package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_TercerosDireccionesBean;
import AcseleV13_8LBC.main.controller.LBC_TercerosDirecciones;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 10/06/2016.
 */
public class VistaLBC_TercerosDireccionesTest {

    private final static Logger log = Logger.getLogger(VistaLBC_TercerosDireccionesTest.class);

    @Test
    public void mainTest() {

        ArrayList dirTerceros = null;

        try {
            dirTerceros = LBC_TercerosDireccionesBean.getLBC_TercerosDireccionesBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < dirTerceros.size(); i++) {

            LBC_TercerosDireccionesBean lbcTercerosDireccionesBean = (LBC_TercerosDireccionesBean) dirTerceros.get(i);
            LBC_TercerosDirecciones a = new LBC_TercerosDirecciones();

            try {
                a.testLink(lbcTercerosDireccionesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/tercerosDirecciones_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/tercerosDirecciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosDirecciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/tercerosDirecciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
