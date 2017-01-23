package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_AsociarCajaCajeroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_AsociarCajaCajero;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 07/12/2016.
 */
public class VistaINTER_AsociarCajaCajeroTest {
    private final static Logger log = Logger.getLogger(VistaINTER_AsociarCajaCajeroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = INTER_AsociarCajaCajeroBean.getINTER_AsociarCajaCajeroBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            INTER_AsociarCajaCajeroBean interAsociarCajaCajeroBean = (INTER_AsociarCajaCajeroBean) caja.get(j);
            INTER_AsociarCajaCajero a = new INTER_AsociarCajaCajero();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interAsociarCajaCajeroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJERO, NUM_CAJA, NOMBRE_CAJERO, APELLIDO_CAJERO FROM ASOCIAR_CAJAS_CAJEROS_INTER ORDER BY PRUEBA ASC",
                "ASOCIAR_CAJAS_CAJEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interAsociarCajaCajero_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, CAJERO, NUM_CAJA, NOMBRE_CAJERO, APELLIDO_CAJERO FROM ASOCIAR_CAJAS_CAJEROS_INTER ORDER BY PRUEBA ASC",
                "ASOCIAR_CAJAS_CAJEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interAsociarCajaCajero_dataset.xml");*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interAsociarCajaCajero_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interAsociarCajaCajero_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
