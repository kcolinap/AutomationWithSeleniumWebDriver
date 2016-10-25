package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.TercerosInfTecnicaLBCBean;
import AcseleV13_8LBC.main.controller.TercerosInfTecnicaLBC;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 21/10/2016.
 */
public class VistaTercerosInfTecnicaLBCTest {

    private final static Logger log = Logger.getLogger(VistaTercerosInfTecnicaLBCTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList TercerosInfTecnicaLBC = TercerosInfTecnicaLBCBean.getTercerosInfTecnicaLBC();

        for (int j = 0; j< TercerosInfTecnicaLBC.size(); j++) {
            TercerosInfTecnicaLBCBean tercerosInfTecnicaLBCBean = (TercerosInfTecnicaLBCBean) TercerosInfTecnicaLBC.get(j);
            TercerosInfTecnicaLBC a = new TercerosInfTecnicaLBC();

            try {
                a.testLink(tercerosInfTecnicaLBCBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_LBC ORDER BY PRUEBA ASC",
                "TERCEROS_INF_TECNICA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/tercerosInfTecnicaLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_LBC ORDER BY PRUEBA ASC",
                "TERCEROS_INF_TECNICA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/tercerosInfTecnicaLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfTecnicaLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfTecnicaLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
