package AcseleV13_8.tests;

import AcseleV13_8.beans.CumulosTercerosBean;
import AcseleV13_8.main.controller.CumulosTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 17/08/2016.
 */
public class VistaCumulosTercerosTest {

    private final static Logger log = Logger.getLogger(VistaCumulosTercerosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList cumulosTerceros = CumulosTercerosBean.getCumulosTerceros();

        for (int i = 0; i < cumulosTerceros.size(); i++) {
            CumulosTercerosBean cumulosTercerosBean = (CumulosTercerosBean) cumulosTerceros.get(i);
            CumulosTerceros a = new CumulosTerceros();

            try {
                a.testLink(cumulosTercerosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Rol,Tipo_Doc_Identificacion, Pasaporte, Num_Doc_Identificacion,Primer_Nombre,Telefono_Oficina,Primer_Apellido, Moneda,Moneda2 from CUMULOS_TERCEROS ORDER BY PRUEBA ASC",
                "CUMULOS_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/cumulosTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Rol,Tipo_Doc_Identificacion, Pasaporte, Num_Doc_Identificacion,Primer_Nombre,Telefono_Oficina,Primer_Apellido, Moneda,Moneda2 from CUMULOS_TERCEROS ORDER BY PRUEBA ASC",
                "CUMULOS_TERCEROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/cumulosTerceros_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/cumulosTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
