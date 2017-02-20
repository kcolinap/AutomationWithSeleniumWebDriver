package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_BusquedaSiniestroSimpleBean;
import AcseleV13_8_Interseguros.main.controller.INTER_BusquedaSiniestroSimple;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 23/01/2017.
 */
public class VistaINTER_BusquedaSiniestroSimpleTest {

    private final static Logger log = Logger.getLogger(VistaINTER_BusquedaSiniestroSimpleTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interBusquedaSiniestroSimple = null;

        try {
            interBusquedaSiniestroSimple = INTER_BusquedaSiniestroSimpleBean.getINTER_BusquedaSiniestroSimple();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interBusquedaSiniestroSimple.size(); j++) {
            INTER_BusquedaSiniestroSimpleBean inter_busquedaSiniestroSimpleBean = (INTER_BusquedaSiniestroSimpleBean) interBusquedaSiniestroSimple.get(j);
            INTER_BusquedaSiniestroSimple a = new INTER_BusquedaSiniestroSimple();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_busquedaSiniestroSimpleBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por FROM INTER_BUSQUEDA_SIN_SIMPLE ORDER BY PRUEBA ASC",
                "INTER_BUSQUEDA_SIN_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroSimple_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por FROM INTER_BUSQUEDA_SIN_SIMPLE ORDER BY PRUEBA ASC",
                "INTER_BUSQUEDA_SIN_SIMPLE",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroSimple_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroSimple_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroSimple_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
