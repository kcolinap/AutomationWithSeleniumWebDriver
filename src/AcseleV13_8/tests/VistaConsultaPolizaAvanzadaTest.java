package AcseleV13_8.tests;

import AcseleV13_8.beans.BusquedaPolizaAvanzadaBean;
import AcseleV13_8.main.controller.ConsultaPolizaAvanzada;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 26/05/2016.
 */
public class VistaConsultaPolizaAvanzadaTest {

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
        ArrayList polizas = BusquedaPolizaAvanzadaBean.getBusquedaPolizasAvanzadas();
        //login

        for(int i = 0; i < polizas.size(); i++) {

            BusquedaPolizaAvanzadaBean busquedaPolizaAvanzadaBean = (BusquedaPolizaAvanzadaBean) polizas.get(i);
            ConsultaPolizaAvanzada a = new ConsultaPolizaAvanzada();
            try {
                a.testLink(busquedaPolizaAvanzadaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //Logout

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, FECHA_EMISION, NUM_POLIZA, TIPO_TERCERO, PRIMER_NOMBRE, PRIMER_APELLIDO, EDO_CICLO_VIDA, NUM_DOCUMENTO_IDENTIFICACION, PASAPORTE, TELEFONO_FIJO, TIPO_DOC_IDENTIFICACION, EMAIL_1, TELEFONO_CELULAR FROM BUSQUEDA_POLIZA ORDER BY PRUEBA ASC",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/consultaPolizaAvanzada_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, FECHA_EMISION, NUM_POLIZA, TIPO_TERCERO, PRIMER_NOMBRE, PRIMER_APELLIDO, EDO_CICLO_VIDA, NUM_DOCUMENTO_IDENTIFICACION, PASAPORTE, TELEFONO_FIJO, TIPO_DOC_IDENTIFICACION, EMAIL_1, TELEFONO_CELULAR FROM BUSQUEDA_POLIZA ORDER BY PRUEBA ASC",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/consultaPolizaAvanzada_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
