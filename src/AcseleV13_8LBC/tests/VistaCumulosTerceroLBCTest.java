package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.CumulosTerceroLBCBean;

import AcseleV13_8LBC.main.controller.CumulosTerceroLBC;
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
public class VistaCumulosTerceroLBCTest {
    private final static Logger log = Logger.getLogger(VistaCumulosTerceroLBCTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosTercerosLBC = CumulosTerceroLBCBean.getCumulosTercerosLBC();

        for (int j = 0; j< cumulosTercerosLBC.size(); j++) {
            CumulosTerceroLBCBean cumulosTerceroLBCBean = (CumulosTerceroLBCBean) cumulosTercerosLBC.get(j);
            CumulosTerceroLBC a = new CumulosTerceroLBC();

            try {
                a.testLink(cumulosTerceroLBCBean, j);
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
