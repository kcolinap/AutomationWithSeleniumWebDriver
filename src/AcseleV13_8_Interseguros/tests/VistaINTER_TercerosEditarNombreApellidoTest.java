package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_TercerosEditarNombreApellidoBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TercerosEditarNombreApellido;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 20/01/2017.
 */
public class VistaINTER_TercerosEditarNombreApellidoTest {

    private final static Logger Log = Logger.getLogger(VistaINTER_TercerosEditarNombreApellidoTest.class);

    @Test
    public void mainTest() throws SQLException{

        ArrayList interTercerosEditarNombreApellido = null;

        try{
            interTercerosEditarNombreApellido = INTER_TercerosEditarNombreApellidoBean.getINTER_TercerosEditarNombreApellido();
        }catch (SQLException e){
            Log.error(e);
        }

        for(int j = 0; j < interTercerosEditarNombreApellido.size(); j++){
            INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean = (INTER_TercerosEditarNombreApellidoBean) interTercerosEditarNombreApellido.get(j);
            INTER_TercerosEditarNombreApellido a = new INTER_TercerosEditarNombreApellido();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            //String horaC = intersegurosMetodos.horaCarpeta();

            try{
                a.testLink(inter_tercerosEditarNombreApellidoBean, j);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception{

            DataSetManager.createPartialDataSet("select Prueba,Tipo_Tercero, Num_Doc_Identificacion, Apellido, Nombre from INTER_TERCEROS_EDITAR_NOM_APE ORDER BY PRUEBA ASC",
                    "INTER_TERCEROS_EDITAR_NOM_APE",
                    "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosEditarNombreApellido_dataset_dataset.xml");

            DataSetManager.createPartialDataSet("select Prueba,Tipo_Tercero, Num_Doc_Identificacion, Apellido, Nombre from INTER_TERCEROS_EDITAR_NOM_APE ORDER BY PRUEBA ASC",
                    "INTER_TERCEROS_EDITAR_NOM_APE",
                    "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosEditarNombreApellido_dataset_dataset.xml");

        //DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosEditarNombreApellido_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosEditarNombreApellido_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
