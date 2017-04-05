package AcseleV13_8Asesuisa.tests;
import AcseleV13_8.beans.TrazaDetalleAuditoriaCajaBean;
import AcseleV13_8.main.controller.TrazaDetalleAuditoriaCaja;
import AcseleV13_8.tests.VistaRechazarPagoSiniestrosTest;
import AcseleV13_8Asesuisa.beans.TrazaDetalleAuditoriaBean;
import AcseleV13_8Asesuisa.main.controller.TrazaDetalleAuditoria;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 29/03/2017.
 */
public class VistaTrazaDetalleAuditoriaTest {

    private final static Logger log = Logger.getLogger(VistaTrazaDetalleAuditoriaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList trazaDetalleAuditoria = TrazaDetalleAuditoriaBean.getTrazaDetalleAuditoria();

        for (int i = 0; i < trazaDetalleAuditoria.size(); i++) {
            TrazaDetalleAuditoriaBean trazaDetalleAuditoriaBean = (TrazaDetalleAuditoriaBean) trazaDetalleAuditoria.get(i);
            TrazaDetalleAuditoria a = new TrazaDetalleAuditoria();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
               a.testLink(trazaDetalleAuditoriaBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp(String num) throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_DETALLE_TRAZA ORDER BY PRUEBA ASC",
                "ASESUISA_DETALLE_TRAZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTrazaDetalleAuditoria_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_DETALLE_TRAZA ORDER BY PRUEBA ASC",
                "ASESUISA_DETALLE_TRAZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTrazaDetalleAuditoria_dataset"+num+".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTrazaDetalleAuditoria_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTrazaDetalleAuditoria_dataset"+ num + ".xml", DataSetManager.DELETE_OPERATION);
    }

}
