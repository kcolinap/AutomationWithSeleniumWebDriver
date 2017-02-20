package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_LiquidacionCtaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_LiquidacionCtaTecnica;
import metodo.Metodos;
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
public class VistaINTER_LiquidacionCtaTecnicaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_LiquidacionCtaTecnicaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interLiquidacionCuentaTecnica = null;

        try {
            interLiquidacionCuentaTecnica = INTER_LiquidacionCtaTecnicaBean.getINTER_LiquidacionCtaTecnica();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interLiquidacionCuentaTecnica.size(); j++) {
            INTER_LiquidacionCtaTecnicaBean inter_liquidacionCtaTecnicaBean = (INTER_LiquidacionCtaTecnicaBean) interLiquidacionCuentaTecnica.get(j);
            INTER_LiquidacionCtaTecnica a = new INTER_LiquidacionCtaTecnica();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_liquidacionCtaTecnicaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Lista_cuenta FROM INTER_LIQUIDACION_CTA_TECNICA ORDER BY PRUEBA ASC",
                "INTER_LIQUIDACION_CTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interLiquidacionCtaTecnica_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Lista_cuenta FROM INTER_LIQUIDACION_CTA_TECNICA ORDER BY PRUEBA ASC",
                "INTER_LIQUIDACION_CTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interLiquidacionCtaTecnica_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interLiquidacionCtaTecnica_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interLiquidacionCtaTecnica_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
