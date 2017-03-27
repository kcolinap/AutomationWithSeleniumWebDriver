package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_BusquedaSimplePolizaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_BusquedaSimplePoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 23/03/2017.
 */
public class VistaAsesuisa_BusquedaSimplePolizaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_BusquedaSimplePolizaTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Asesuisa_BusquedaSimplePolizaBean.getAsesuisa_BusquedaSimplePoliza();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_BusquedaSimplePolizaBean bean = (Asesuisa_BusquedaSimplePolizaBean) poliza.get(j);
            Asesuisa_BusquedaSimplePoliza a = new Asesuisa_BusquedaSimplePoliza();
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
    public void setUp(int num) throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM ASE_BUSQUEDA_SIMPLE_POLIZA ORDER BY PRUEBA ASC",
                "ASE_BUSQUEDA_SIMPLE_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaSimplePoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_BUSQUEDA_SIMPLE_POLIZA ORDER BY PRUEBA ASC",
                "ASE_BUSQUEDA_SIMPLE_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaSimplePoliza_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaSimplePoliza_dataset" + num +".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(int num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaBusquedaSimplePoliza_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
    }
}
