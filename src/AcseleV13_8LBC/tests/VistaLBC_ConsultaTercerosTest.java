package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.LBC_ConsultaTercerosBean;
import AcseleV13_8LBC.main.controller.LBC_ConsultaTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 14/10/2016.
 */
public class VistaLBC_ConsultaTercerosTest {
    private final static Logger log = Logger.getLogger(VistaLBC_ConsultaTercerosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consutaTerceroLBC = LBC_ConsultaTercerosBean.getLBC_ConsultaTercerosBean();

        for (int j = 0; j< consutaTerceroLBC.size(); j++) {
            LBC_ConsultaTercerosBean lbcConsultaTercerosBean = (LBC_ConsultaTercerosBean) consutaTerceroLBC.get(j);
            LBC_ConsultaTerceros a = new LBC_ConsultaTerceros();

            try {
                a.testLink(lbcConsultaTercerosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID  from CONSULTA_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/consultaTercerosLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, TIPO_DOC_ID, NUM_DOC_ID  from CONSULTA_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/consultaTercerosLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaTercerosLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/consultaTercerosLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
