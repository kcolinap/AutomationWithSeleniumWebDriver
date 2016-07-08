package tests;

import beans.BusquedaPolizaAvanzadaBean;
import beans.TercerosDireccionesBean;
import main.controller.ConsultaPolizaAvanzada;
import main.controller.TercerosDirecciones;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 10/06/2016.
 */
public class VistaTercerosDireccionesTest {

    @Test
    //@Transactional
    public void mainTest() {

//        BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = BusquedaPolizaAvanzadaBean.getBusquedaPolizaAvanzada();
//        ConsultaPolizaAvanzada a = new ConsultaPolizaAvanzada();
//        try {
//            a.testLink(busquedaPolizaAvanzadaBean);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        /***/
        ArrayList dirTerceros = TercerosDireccionesBean.getTercerodDirecciones();
        //login

        for(int i = 0; i < dirTerceros.size(); i++) {

            TercerosDireccionesBean tercerosDireccionesBean = (TercerosDireccionesBean) dirTerceros.get(i);
            TercerosDirecciones a = new TercerosDirecciones();
            try {
                a.testLink(tercerosDireccionesBean, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/tercerosDirecciones_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, TIPO_DIRECCION, TIPO_VIA, NUM_NOMBRE_VIA_PPAL, PREFIJO_BIS_VIA_PPAL, LETRA_NUM_PREF_VIA_PPAL,CUADRANTE_VIA_PPAL, NUM_VIA_GENERADORA, PAIS, DEPARTAMENTO, CIUDAD FROM TERCEROS_DIRECCIONES ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/tercerosDirecciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/tercerosDirecciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/tercerosDirecciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
