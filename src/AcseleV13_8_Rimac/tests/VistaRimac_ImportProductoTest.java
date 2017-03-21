package AcseleV13_8_Rimac.tests;

import AcseleV13_8_Rimac.beans.Rimac_ImportProductoBean;
import AcseleV13_8_Rimac.main.controller.Rimac_ImportProducto;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 20/03/2017.
 */
public class VistaRimac_ImportProductoTest {

    private final static Logger log = Logger.getLogger(VistaRimac_ImportProductoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList producto = null;

        try {
            producto = Rimac_ImportProductoBean.getRimac_ImportProducto();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < producto.size(); j++) {
            Rimac_ImportProductoBean importProductoBean = (Rimac_ImportProductoBean) producto.get(j);
            Rimac_ImportProducto a = new Rimac_ImportProducto();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(importProductoBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Rimac/tests/xmls/rimacImportProducto_dataset.xml");

        DataSetManager.createPartialDataSet("",
                "",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Rimac/tests/xmls/rimacImportProducto_dataset.xml");
        
        DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacImportProducto_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Rimac/tests/xmls/rimacImportProducto_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
