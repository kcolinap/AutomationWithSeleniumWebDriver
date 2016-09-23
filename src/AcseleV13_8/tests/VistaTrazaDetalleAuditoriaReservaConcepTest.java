package AcseleV13_8.tests;

import AcseleV13_8.beans.TrazaDetalleAuditoriaReservaConcepBean;
import AcseleV13_8.main.controller.TrazaDetalleAuditoriaReservaConcep;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kzambrano on 22/09/2016.
 */
public class VistaTrazaDetalleAuditoriaReservaConcepTest {

    private final static Logger log = Logger.getLogger(VistaRechazarPagoSiniestrosTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList trazaDetalleReservaConceptos = TrazaDetalleAuditoriaReservaConcepBean.getTrazaDetalleReservaConceptos();

        for (int i = 0; i < trazaDetalleReservaConceptos.size(); i++) {
            TrazaDetalleAuditoriaReservaConcepBean trazaDetalleAuditoriaReservaConcepBean = (TrazaDetalleAuditoriaReservaConcepBean) trazaDetalleReservaConceptos.get(i);
            TrazaDetalleAuditoriaReservaConcep a = new TrazaDetalleAuditoriaReservaConcep();


            try {
                a.testLink(trazaDetalleAuditoriaReservaConcepBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, Nro_Siniestro, Nro_Poliza,  Fecha_siniestro, Producto, Ordenar_Por, Cobertura, Monto_Reserva, Tipo_Traza, Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Reserva_Conceptos_Traza ORDER BY PRUEBA ASC",
                "Reserva_Conceptos_Traza",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/reserva_Conceptos_Traza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, Nro_Siniestro, Nro_Poliza,  Fecha_siniestro, Producto, Ordenar_Por, Cobertura, Monto_Reserva, Tipo_Traza, Fecha_Desde, Fecha_hasta, Categoria_Traza FROM Reserva_Conceptos_Traza ORDER BY PRUEBA ASC",
                "Reserva_Conceptos_Traza",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/reserva_Conceptos_Traza_dataset.xml");

     */    DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/reserva_Conceptos_Traza_dataset.xml", DataSetManager.REFRESH_OPERATION);
   }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/reserva_Conceptos_Traza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
