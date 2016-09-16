package AcseleV13_8.tests;

import AcseleV13_8.beans.PagoPorConceptosBean;
import AcseleV13_8.main.controller.PagoPorConceptos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 13/09/2016.
 */
public class VistaPagoPorConceptosTest {

    private final static Logger log = Logger.getLogger(VistaPagoPorConceptosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList pagoPorConceptos = PagoPorConceptosBean.getPagoPorConceptos();

        for (int i = 0; i < pagoPorConceptos.size(); i++) {
            PagoPorConceptosBean pagoPorConceptosBean = (PagoPorConceptosBean) pagoPorConceptos.get(i);
            PagoPorConceptos a = new PagoPorConceptos();


            try {
                a.testLink(pagoPorConceptosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

    /*  DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaOcurrenciaSin,Producto, OrdenarPor, Cobertura, MontoReserva, NumeroDocIdent, MontoSiniestro, SeleccioneAccion FROM PAGO_POR_CONCEPTOS ORDER BY PRUEBA ASC",
                "PAGO_POR_CONCEPTOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/pagoPorConceptos_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NumeroSiniestro, NumeroPoliza, FechaOcurrenciaSin,Producto, OrdenarPor, Cobertura, MontoReserva, NumeroDocIdent, MontoSiniestro, SeleccioneAccion FROM PAGO_POR_CONCEPTOS ORDER BY PRUEBA ASC",
                "PAGO_POR_CONCEPTOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/pagoPorConceptos_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/pagoPorConceptos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/pagoPorConceptos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
