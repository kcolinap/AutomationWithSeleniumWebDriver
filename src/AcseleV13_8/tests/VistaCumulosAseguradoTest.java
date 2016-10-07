package AcseleV13_8.tests;

import AcseleV13_8.beans.CumulosAseguradoBean;
import AcseleV13_8.main.controller.CumulosAsegurado;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 18/08/2016.
 */
public class VistaCumulosAseguradoTest {

    private final static Logger log = Logger.getLogger(VistaCumulosAseguradoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosAsegurado = CumulosAseguradoBean.getCumulosAsegurado();

        for (int i = 0; i < cumulosAsegurado.size(); i++) {
            CumulosAseguradoBean cumulosAseguradoBean = (CumulosAseguradoBean) cumulosAsegurado.get(i);
            CumulosAsegurado a = new CumulosAsegurado();

            try {
                a.testLink(cumulosAseguradoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Tipo_Doc_Identificacion,Pasaporte,Num_Doc_Identificacion, Primer_Nombre, Primer_Apellido, Estado_Civil, Email_1 FROM CUMULOS_ASEGURADO ORDER BY PRUEBA ASC",
                "CUMULOS_ASEGURADO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/cumulosAsegurado_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Tipo_Doc_Identificacion,Pasaporte,Num_Doc_Identificacion, Primer_Nombre, Primer_Apellido, Estado_Civil, Email_1 FROM CUMULOS_ASEGURADO ORDER BY PRUEBA ASC",
                "CUMULOS_ASEGURADO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/cumulosAsegurado_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosAsegurado_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosAsegurado_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
