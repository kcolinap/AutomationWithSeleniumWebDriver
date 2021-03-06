package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CumulosAseguradoBean;
import AcseleV13_8LBC.main.controller.LBC_CumulosAsegurado;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 17/10/2016.
 */
public class VistaLBC_CumulosAseguradoTest {

    private final static Logger log = Logger.getLogger(VistaLBC_CumulosAseguradoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosAseguradoLBC = LBC_CumulosAseguradoBean.getCumulosAseguradoLBC();

        for (int i = 0; i < cumulosAseguradoLBC.size(); i++) {
            LBC_CumulosAseguradoBean lbcCumulosAseguradoBean = (LBC_CumulosAseguradoBean) cumulosAseguradoLBC.get(i);
            LBC_CumulosAsegurado a = new LBC_CumulosAsegurado();

            try {
                a.testLink(lbcCumulosAseguradoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion,Num_Doc_Identificacion FROM CUMULOS_ASEGURADO_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_ASEGURADO_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/cumulosAseguradoLBC_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Tipo_Doc_Identificacion,Num_Doc_Identificacion FROM CUMULOS_ASEGURADO_LBC ORDER BY PRUEBA ASC",
                "CUMULOS_ASEGURADO_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/cumulosAseguradoLBC_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosAseguradoLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/cumulosAseguradoLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
