package AcseleV13_8LBC.tests;
import AcseleV13_8LBC.beans.ConsultaTercerosLBCBean;
import AcseleV13_8LBC.main.controller.ConsultaTercerosLBC;
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
public class VistaConsultaTercerosLBCTest {
    private final static Logger log = Logger.getLogger(VistaConsultaTercerosLBCTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consutaTerceroLBC = ConsultaTercerosLBCBean.getConsutaTercerosLBCBean();

        for (int j = 0; j< consutaTerceroLBC.size(); j++) {
            ConsultaTercerosLBCBean consultaAvanzadaPolizaBean = (ConsultaTercerosLBCBean) consutaTerceroLBC.get(j);
            ConsultaTercerosLBC a = new ConsultaTercerosLBC();

            try {
                //a.testLink(consutaTerceroLBCBean, j);
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
