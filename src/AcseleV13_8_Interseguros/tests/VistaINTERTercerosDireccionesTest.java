package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_TercerosDireccionesBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TercerosDirecciones;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 16/12/2016.
 */
public class VistaINTERTercerosDireccionesTest {
    private final static Logger log = Logger.getLogger(VistaINTERTercerosDireccionesTest.class);

    @Test
    public void mainTest() {

        ArrayList dirTerceros = null;

        try {
            dirTerceros = INTER_TercerosDireccionesBean.getTercerodDirecciones();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < dirTerceros.size(); i++) {

            INTER_TercerosDireccionesBean intertercerosDireccionesBean = (INTER_TercerosDireccionesBean) dirTerceros.get(i);
            INTER_TercerosDirecciones a = new INTER_TercerosDirecciones();

            try {
                a.testLink(intertercerosDireccionesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
