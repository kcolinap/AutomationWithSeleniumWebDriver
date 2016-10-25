package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.LBC_CumulosTerceroBean;

import AcseleV13_8LBC.main.controller.LBC_CumulosTercero;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 18/10/2016.
 */
public class VistaLBC_CumulosTerceroTest {
    private final static Logger log = Logger.getLogger(VistaLBC_CumulosTerceroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosTercerosLBC = LBC_CumulosTerceroBean.getCumulosTercerosLBC();

        for (int j = 0; j< cumulosTercerosLBC.size(); j++) {
            LBC_CumulosTerceroBean lbcCumulosTerceroBean = (LBC_CumulosTerceroBean) cumulosTercerosLBC.get(j);
            LBC_CumulosTercero a = new LBC_CumulosTercero();

            try {
                a.testLink(lbcCumulosTerceroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion,Moneda from CUMULOS_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/cumulosTerceroLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion,Moneda from CUMULOS_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/cumulosTerceroLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosTerceroLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosTerceroLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
