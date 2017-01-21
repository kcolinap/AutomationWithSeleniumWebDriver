package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_RechazarPagoSiniestroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_RechazarPagoSiniestro;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 21/01/2017.
 */
public class VistaINTER_RechazarPagoSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_RechazarPagoSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interRechazarPagoSiniestro = null;

        try {
            interRechazarPagoSiniestro =  INTER_RechazarPagoSiniestroBean.getINTER_RechazarPagoSiniestro();

        } catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interRechazarPagoSiniestro.size(); j++) {
            INTER_RechazarPagoSiniestroBean inter_rechazarPagoSiniestroBean = (INTER_RechazarPagoSiniestroBean) interRechazarPagoSiniestro.get(j);
            INTER_RechazarPagoSiniestro a = new INTER_RechazarPagoSiniestro();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            //String horaC = intersegurosMetodos.horaCarpeta ();

            try {
                a.testLink(inter_rechazarPagoSiniestroBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }


    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por, fecha_Compromiso, fecha_Inicial, fecha_Final, razon ,tipo, sucursal, cobertura, seleccione_Accion, monto_Siniestro FROM INTER_RECHAZAR_PAGO_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_RECHAZAR_PAGO_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interRechazarPagoSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,numero_Siniestro, numero_Poliza, fecha_Ocurrencia_Sin, producto, ordenar_Por, fecha_Compromiso, fecha_Inicial, fecha_Final, razon ,tipo, sucursal, cobertura, seleccione_Accion, monto_Siniestro FROM INTER_RECHAZAR_PAGO_SINIESTRO ORDER BY PRUEBA ASC",
                "INTER_RECHAZAR_PAGO_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interRechazarPagoSiniestro_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interRechazarPagoSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interRechazarPagoSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
