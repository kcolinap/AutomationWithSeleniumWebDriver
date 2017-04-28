package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosDireccionesBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosDirecciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 03/03/2017.
 */
public class VistaAsesuisa_TercerosDireccionesTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosDireccionesTest.class);

    @Before
    public void setUp(String num) throws Exception{
/*

        DataSetManager.createPartialDataSet("select * from asesuisa_terceros_dir ORDER BY PRUEBA ASC",
                "asesuisa_terceros_dir",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDirecciones_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("select * from asesuisa_terceros_dir ORDER BY PRUEBA ASC",
                "asesuisa_terceros_dir",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDirecciones_dataset" + num + ".xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDirecciones_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaTercerosDirecciones = null;

        try{
            asesuisaTercerosDirecciones = Asesuisa_TercerosDireccionesBean.getAsesuisa_TercerosDireccionesBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosDirecciones.size(); j++){
            Asesuisa_TercerosDireccionesBean asesuisaTercerosDireccionesBean = (Asesuisa_TercerosDireccionesBean)asesuisaTercerosDirecciones.get(j);
            Asesuisa_TercerosDirecciones a = new Asesuisa_TercerosDirecciones();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try {
                a.testLink(asesuisaTercerosDireccionesBean,j,horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown(String num) throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosDirecciones_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
