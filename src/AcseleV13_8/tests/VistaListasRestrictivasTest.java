package AcseleV13_8.tests;

import AcseleV13_8.beans.ListasRestrictivasBean;
//import AcseleV13_8.main.controller.ListasRestrictivas;
import AcseleV13_8.main.controller.ListasRestrictivas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 25/08/2016.
 */
public class VistaListasRestrictivasTest {

    /**
     *El import del archivo con extension xlsx se realiza usando el programa AutoIT
     * se creo un sript que contiene las siguientes especificaciones:

     * ControlFocus("Abrir", "", "Edit1")
     * ControlSetText("Abrir", "", "Edit1", "C:\Program Files (x86)\Google\Chrome\Application\52.0.2743.116\PruebaAutomatizacion.xlsx")
     * ControlClick("Abrir", "", "Button1")

     *una vez creado el archivo se guarda en cualquier ruta para que sea llamado por selenium, preferiblemente en la carpeta del proyecto
     * se debe compilar el mismo para que genere un .exe
     * mas informacion de este proceso en el link http://www.guru99.com/use-autoit-selenium.html

     */

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList listasRestrictivas = ListasRestrictivasBean.getListasRestrictivas();

        for (int i = 0; i < listasRestrictivas.size(); i++) {
            ListasRestrictivasBean listasRestrictivasBean = (ListasRestrictivasBean) listasRestrictivas.get(i);
            ListasRestrictivas a = new ListasRestrictivas();


            try {
                a.testLink(listasRestrictivasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

    /*  DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPOLISTA, NOMBRELISTA, ARCHIVO, LISTANOMBRE, TIPOCOINCIDENCIA, PRODUCTO, VIGENCIA, FECHADESDE, EVENTOAPLICAR, NUMPOLIZA, LINEACREDITO, UNIDADNEGOCIO, CANALVENTA, TIPOVALORASEGURADO, TOMADORNOMBRE, NUMCREDITO, FECHAPROCESO, MONTOASEGURADO, DOCIDASEGURADO, FECHANACASEGURADO, DIRECCIONASEGURADO, DEPARTAMENTOASEGURADO , CIUDADASEGURADO, ASEGURADO, FechaDesdeTraza, FechaHastaTraza, valorPrestamo, valorSeguro, valorVida FROM LISTAS_RESTRICTIVAS ORDER BY PRUEBA ASC",
                "LISTAS_RESTRICTIVAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/listasRestrictivas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPOLISTA, NOMBRELISTA, ARCHIVO, LISTANOMBRE, TIPOCOINCIDENCIA, PRODUCTO, VIGENCIA, FECHADESDE, EVENTOAPLICAR, NUMPOLIZA, LINEACREDITO, UNIDADNEGOCIO, CANALVENTA, TIPOVALORASEGURADO, TOMADORNOMBRE, NUMCREDITO, FECHAPROCESO, MONTOASEGURADO, DOCIDASEGURADO, FECHANACASEGURADO, DIRECCIONASEGURADO, DEPARTAMENTOASEGURADO , CIUDADASEGURADO, ASEGURADO, FechaDesdeTraza, FechaHastaTraza, valorPrestamo, valorSeguro, valorVida FROM LISTAS_RESTRICTIVAS ORDER BY PRUEBA ASC",
                "LISTAS_RESTRICTIVAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/listasRestrictivas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/listasRestrictivas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/listasRestrictivas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}




