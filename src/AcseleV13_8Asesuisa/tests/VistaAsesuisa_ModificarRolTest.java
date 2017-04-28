package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_ModificarRolBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ModificarRol;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 17/04/2017.
 */
public class VistaAsesuisa_ModificarRolTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_ModificarRolTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {
        ArrayList terceros = null;

        try {
            terceros = Asesuisa_ModificarRolBean.getAsesuisa_TercerosEditar();
        } catch (SQLException e) {
            Log.error(e);
        }

        for (int j = 0; j < terceros.size(); j++) {
            Asesuisa_ModificarRolBean bean = (Asesuisa_ModificarRolBean) terceros.get(j);
            Asesuisa_ModificarRol a = new Asesuisa_ModificarRol();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
               a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp(String num) throws Exception {

       /*DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MODIFICARROL ORDER BY PRUEBA ASC",
                "ASESUISA_MODIFICARROL",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosModificarRol_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_MODIFICARROL ORDER BY PRUEBA ASC",
                "ASESUISA_MODIFICARROL",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosModificarRol_dataset" + num + ".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosModificarRol_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);

    }


    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosModificarRol_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
