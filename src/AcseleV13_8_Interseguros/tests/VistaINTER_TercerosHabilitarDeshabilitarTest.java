package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TercerosHabilitarDeshabilitar;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 07/02/2017.
 */
public class VistaINTER_TercerosHabilitarDeshabilitarTest {

    private final static Logger Log = Logger.getLogger(VistaINTER_TercerosEditarNombreApellidoTest.class);

    @Test
    public void mainTest() throws SQLException{

        ArrayList interTercerosHabilitarDeshabilitar = null;

        try{
            interTercerosHabilitarDeshabilitar = INTER_TercerosHabilitarDeshabilitarBean.getINTER_TercerosHabilitarDeshabilitar();
        }catch (SQLException e){
            Log.error(e);
        }

        for(int j = 0; j < interTercerosHabilitarDeshabilitar.size(); j++){
            INTER_TercerosHabilitarDeshabilitarBean inter_tercerosHabilitarDeshabilitarBean = (INTER_TercerosHabilitarDeshabilitarBean) interTercerosHabilitarDeshabilitar.get(j);
            INTER_TercerosHabilitarDeshabilitar a = new INTER_TercerosHabilitarDeshabilitar();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try{
                a.testLink(inter_tercerosHabilitarDeshabilitarBean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception{

/*

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO, NUM_DOC_IDENTIFICACION, APELLIDO, NOMBRE from INTER_TERCEROS_HABIL_DESHABIL ORDER BY PRUEBA ASC",
                "INTER_TERCEROS_HABIL_DESHABIL",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosHabilitarDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO, NUM_DOC_IDENTIFICACION, APELLIDO, NOMBRE from INTER_TERCEROS_HABIL_DESHABIL ORDER BY PRUEBA ASC",
                "INTER_TERCEROS_HABIL_DESHABIL",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosHabilitarDeshabilitar_dataset.xml");
*/


        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosHabilitarDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
