package AcseleV13_8Asesuisa.tests;

/**
 * Created by kcolina on 22/05/2017.
 */

import AcseleV13_8Asesuisa.beans.Asesuisa_TablaDinamicaExportBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TablaDinamicaExport;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.*;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


public class VistaAsesuisa_TablaDinamicaExportTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TablaDinamicaExportTest.class);

    @Before
    public void setUp(String num) throws Exception {


    /*    DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TDINAMICA_EXPORT ORDER BY PRUEBA ASC",
                "ASESUISA_TDINAMICA_EXPORT",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTablaDinamicaExport_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_TDINAMICA_EXPORT ORDER BY PRUEBA ASC",
                "ASESUISA_TDINAMICA_EXPORT",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTablaDinamicaExport_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTablaDinamicaExport_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList asesuisaTablaDinamicaExport = null;

        try{
            asesuisaTablaDinamicaExport = Asesuisa_TablaDinamicaExportBean.getTablaDinamicaExport();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTablaDinamicaExport.size(); j++){
            Asesuisa_TablaDinamicaExportBean bean = (Asesuisa_TablaDinamicaExportBean)asesuisaTablaDinamicaExport.get(j);
            Asesuisa_TablaDinamicaExport a = new Asesuisa_TablaDinamicaExport();
            Metodos m = new Metodos();
            String horaC = m.horaCarpeta();

            try{
                a.TestLink(bean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTablaDinamicaExport_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
