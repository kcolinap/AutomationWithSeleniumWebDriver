package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_DistribucionReaseguroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_DistribucionReaseguro;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 25/01/2017.
 */
public class VistaINTER_DistribucionReaseguroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_DistribucionReaseguroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interDistribucionReaseguro = null;

        try {
            interDistribucionReaseguro = INTER_DistribucionReaseguroBean.getINTER_DistribucionReaseguro();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interDistribucionReaseguro.size(); j++) {
            INTER_DistribucionReaseguroBean inter_distribucionReaseguroBean = (INTER_DistribucionReaseguroBean) interDistribucionReaseguro.get(j);
            INTER_DistribucionReaseguro a = new INTER_DistribucionReaseguro();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_distribucionReaseguroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Tercero, Nombre_Empresa,Sucursal FROM INTER_DISTRI_REASEGURO ORDER BY PRUEBA ASC",
                "INTER_DISTRI_REASEGURO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interDistribucionReaseguro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Tercero, Nombre_Empresa,Sucursal FROM INTER_DISTRI_REASEGURO ORDER BY PRUEBA ASC",
                "INTER_DISTRI_REASEGURO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interDistribucionReaseguro_dataset.xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interDistribucionReaseguro_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interDistribucionReaseguro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
