package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_CreacionCajaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_CreacionCaja;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by mchurion on 25/11/2016.
 */
public class VistaINTER_CreacionCajaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_CreacionCajaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = INTER_CreacionCajaBean.getINTER_CreacionCajaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            INTER_CreacionCajaBean interCreacionCajaBean = (INTER_CreacionCajaBean) caja.get(j);
            INTER_CreacionCaja a = new INTER_CreacionCaja();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interCreacionCajaBean, j, horaC);
            } catch (Exception e) {
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA,DESCRIPCION,UBICACION,SUCURSAL FROM CREAR_CAJA_INTER ORDER BY PRUEBA ASC",
                "CREAR_CAJA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCreacionCaja_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,DESCRIPCION,UBICACION,SUCURSAL FROM CREAR_CAJA_INTER ORDER BY PRUEBA ASC",
                "CREAR_CAJA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCreacionCaja_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionCaja_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCreacionCaja_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
