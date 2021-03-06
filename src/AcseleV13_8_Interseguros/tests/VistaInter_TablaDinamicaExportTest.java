package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.Inter_TablaDinamicaExportBean;
import AcseleV13_8_Interseguros.main.controller.Inter_TablaDinamicaExport;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 07/02/2017.
 */
public class VistaInter_TablaDinamicaExportTest {

    private final static Logger log = Logger.getLogger(VistaInter_TablaDinamicaExportTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tabla = null;

        try {
            tabla = Inter_TablaDinamicaExportBean.getInter_TablaDinamicaExport();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < tabla.size(); j++) {
            Inter_TablaDinamicaExportBean interTablaDinamicaExportBean = (Inter_TablaDinamicaExportBean) tabla.get(j);
            Inter_TablaDinamicaExport a = new Inter_TablaDinamicaExport();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interTablaDinamicaExportBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT * FROM INTER_TABLA_DINAMICA_EXPORT ORDER BY PRUEBA ASC",
                "INTER_TABLA_DINAMICA_EXPORT",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTablaDinamicaExport_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM INTER_TABLA_DINAMICA_EXPORT ORDER BY PRUEBA ASC",
                "INTER_TABLA_DINAMICA_EXPORT",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTablaDinamicaExport_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTablaDinamicaExport_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTablaDinamicaExport_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
