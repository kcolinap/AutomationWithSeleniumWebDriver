package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ValidarOpenItemBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ValidarOpenItem;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kcolina on 26/01/2017.
 */
public class VistaINTER_ValidarOpenItemTest {

    private final static Logger Log = Logger.getLogger(VistaINTER_ValidarOpenItemTest.class);

    @Test
    public void mainTest() throws SQLException{

        ArrayList interValidarOpenItem = null;

        try{

            interValidarOpenItem = INTER_ValidarOpenItemBean.getInter_ValidarOpenItem();
        }catch (SQLException e){
            e.printStackTrace();
            Log.error(e);
        }

        for (int j=0; j<=interValidarOpenItem.size(); j++){

            INTER_ValidarOpenItemBean inter_validarOpenItemBean = (INTER_ValidarOpenItemBean) interValidarOpenItem.get(j);
            INTER_ValidarOpenItem a = new INTER_ValidarOpenItem();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try{
                a.testLink(inter_validarOpenItemBean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception{

        /* DataSetManager.createPartialDataSet("select * from INTER_VALIDAR_OPEN_ITEM ORDER BY PRUEBA ASC",
                    "INTER_VALIDAR_OPEN_ITEM",
                    "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interValidarOpenItem_dataset.xml");
            DataSetManager.createPartialDataSet("select * from INTER_VALIDAR_OPEN_ITEM ORDER BY PRUEBA ASC",
                    "INTER_VALIDAR_OPEN_ITEM",
                    "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interValidarOpenItem_dataset.xml");
        */
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interValidarOpenItem_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interValidarOpenItem_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
