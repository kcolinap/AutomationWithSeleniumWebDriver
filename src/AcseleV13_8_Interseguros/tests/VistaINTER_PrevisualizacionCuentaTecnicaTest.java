package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_PrevisualizacionCuentaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_PrevisualizacionCuentaTecnica;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 09/12/2016.
 */
public class VistaINTER_PrevisualizacionCuentaTecnicaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_PrevisualizacionCuentaTecnicaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interPrevisualizacionCuentaTecnica = INTER_PrevisualizacionCuentaTecnicaBean.getInterPrevisualizacionCuentaTecnica();

        for (int j = 0; j< interPrevisualizacionCuentaTecnica.size(); j++) {
            INTER_PrevisualizacionCuentaTecnicaBean inter_previsualizacionCuentaTecnicaBean = (INTER_PrevisualizacionCuentaTecnicaBean) interPrevisualizacionCuentaTecnica.get(j);
            INTER_PrevisualizacionCuentaTecnica a = new INTER_PrevisualizacionCuentaTecnica();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_previsualizacionCuentaTecnicaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Fecha_Desde,Fecha_Hasta FROM PREVI_CUENTA_TECNICA ORDER BY PRUEBA ASC",
                "PREVI_CUENTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interPrevisualizacionCuentaTecnica_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Fecha_Desde,Fecha_Hasta FROM PREVI_CUENTA_TECNICA ORDER BY PRUEBA ASC",
                "PREVI_CUENTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interPrevisualizacionCuentaTecnica_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPrevisualizacionCuentaTecnica_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPrevisualizacionCuentaTecnica_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
