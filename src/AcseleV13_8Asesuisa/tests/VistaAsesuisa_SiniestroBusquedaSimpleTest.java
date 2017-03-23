package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosEditarNombreApellidoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosEditarNombreApellido;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 23/03/2017.
 */
public class VistaAsesuisa_SiniestroBusquedaSimpleTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosEditarNombreApellidoTest.class);

    @Before
    public void setUp() throws Exception{
        /*DataSetManager.createPartialDataSet("select * from asesuisa_terceros_edit_nomape ORDER BY PRUEBA ASC",
            "asesuisa_terceros_edit_nomape",
            "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditarNombreApellido_dataset.xml");
        DataSetManager.createPartialDataSet("select * from asesuisa_terceros_edit_nomape ORDER BY PRUEBA ASC",
             "asesuisa_terceros_edit_nomape",
             "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditarNombreApellido_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditarNombreApellido_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @Test
    public void mainTest() throws SQLException{

        ArrayList asesuisaTercerosEditarNombreApellido = null;

        try{
            asesuisaTercerosEditarNombreApellido = Asesuisa_TercerosEditarNombreApellidoBean.getAsesuisa_TercerosEditarNombreApellido();
        }catch (Exception e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaTercerosEditarNombreApellido.size(); j++){

            Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean = (Asesuisa_TercerosEditarNombreApellidoBean)asesuisaTercerosEditarNombreApellido.get(j);
            Asesuisa_TercerosEditarNombreApellido a = new Asesuisa_TercerosEditarNombreApellido();
            Metodos m = new Metodos();
            String horaC = m.horaCarpeta();

            try{
                a.testLink(asesuisaTercerosEditarNombreApellidoBean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosEditarNombreApellido_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
