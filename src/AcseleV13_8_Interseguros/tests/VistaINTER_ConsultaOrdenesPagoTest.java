package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaOrdenesPagosBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaOrdenesPagos;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 05/01/2017.
 */
public class VistaINTER_ConsultaOrdenesPagoTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaOrdenesPagoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList inter_consultaOrdenesPagos = null;

        try {
            inter_consultaOrdenesPagos = INTER_ConsultaOrdenesPagosBean.getINTER_ConsultaOrdenesPagos();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< inter_consultaOrdenesPagos.size(); j++) {
            INTER_ConsultaOrdenesPagosBean inter_consultaOrdenesPagosBean = (INTER_ConsultaOrdenesPagosBean) inter_consultaOrdenesPagos.get(j);
            INTER_ConsultaOrdenesPagos a = new INTER_ConsultaOrdenesPagos();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_consultaOrdenesPagosBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select * from INTER_CONSULTA_ORDEN_PAGO ORDER BY PRUEBA ASC",
                "INTER_CONSULTA_ORDEN_PAGO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interConsultaOrdenesPagos_dataset.xml");

        DataSetManager.createPartialDataSet("select * from INTER_CONSULTA_ORDEN_PAGO ORDER BY PRUEBA ASC",
                "INTER_EDITAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interConsultaOrdenesPagos_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaOrdenesPagos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaOrdenesPagos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }




}
