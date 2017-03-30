package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_BusquedaAvanzadaPolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_BusquedaAvanzadaPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 27/03/2017.
 */
public class VistaAsesuisa_BusquedaAvanzadaPolizaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_BusquedaAvanzadaPolizaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Asesuisa_BusquedaAvanzadaPolizaBean.getAsesuisa_BusquedaAvanzadaPoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_BusquedaAvanzadaPolizaBean bean = (Asesuisa_BusquedaAvanzadaPolizaBean) poliza.get(j);
            Asesuisa_BusquedaAvanzadaPoliza a = new Asesuisa_BusquedaAvanzadaPoliza();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_BUSQUEDA_AVANZADA_POLIZA ORDER BY PRUEBA ASC",
                "ASE_BUSQUEDA_AVANZADA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaAvanzadaPoliza_dataset" +  ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_BUSQUEDA_AVANZADA_POLIZA ORDER BY PRUEBA ASC",
                "ASE_BUSQUEDA_AVANZADA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaAvanzadaPoliza_dataset" +  ".xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaAvanzadaPoliza_dataset" + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaAvanzadaPoliza_dataset" + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
