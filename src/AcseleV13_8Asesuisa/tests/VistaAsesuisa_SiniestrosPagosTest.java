package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_SiniestrosPagosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_SiniestrosPagos;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 13/05/2017.
 */
public class VistaAsesuisa_SiniestrosPagosTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_SiniestrosPagosTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_SiniestrosPagosBean.getAsesuisa_SiniestrosPagos();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_SiniestrosPagosBean bean =(Asesuisa_SiniestrosPagosBean) caja.get(j);

            Asesuisa_SiniestrosPagos a = new Asesuisa_SiniestrosPagos();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                //a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {
//
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTROS_PAGOS ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTROS_PAGOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAnularFactura_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_SINIESTROS_PAGOS ORDER BY PRUEBA ASC",
                "ASESUISA_SINIESTROS_PAGOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAnularFactura_dataset" + num + ".xml");
//
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAnularFactura_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAnularFactura_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
