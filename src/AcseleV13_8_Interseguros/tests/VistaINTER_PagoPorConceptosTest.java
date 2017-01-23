package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_PagoPorConceptosBean;
import AcseleV13_8_Interseguros.main.controller.INTER_PagoPorConceptos;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 19/01/2017.
 */
public class VistaINTER_PagoPorConceptosTest {

    private final static Logger log = Logger.getLogger(VistaINTER_PagoPorConceptosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interPagoConceptos = null;

        try {
            interPagoConceptos =  INTER_PagoPorConceptosBean.getINTER_PagoPorConceptos();

        } catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interPagoConceptos.size(); j++) {
            INTER_PagoPorConceptosBean inter_pagoPorConceptosBean = (INTER_PagoPorConceptosBean) interPagoConceptos.get(j);
            INTER_PagoPorConceptos a = new INTER_PagoPorConceptos();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta ();

            try {
                a.testLink(inter_pagoPorConceptosBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }


    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza,fecha_Ocurrencia_Sin,producto,ordenar_Por,cobertura,monto_Reserva,numero_Doc_Ident,monto_Siniestro,seleccione_Accion FROM INTER_PAGO_CONCEPTOS ORDER BY PRUEBA ASC",
                "INTER_PAGO_CONCEPTOS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interPagoPorConceptos_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza,fecha_Ocurrencia_Sin,producto,ordenar_Por,cobertura,monto_Reserva,numero_Doc_Ident,monto_Siniestro,seleccione_Accion FROM INTER_PAGO_CONCEPTOS ORDER BY PRUEBA ASC",
                "INTER_PAGO_CONCEPTOS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interPagoPorConceptos_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPagoPorConceptos_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interPagoPorConceptos_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
