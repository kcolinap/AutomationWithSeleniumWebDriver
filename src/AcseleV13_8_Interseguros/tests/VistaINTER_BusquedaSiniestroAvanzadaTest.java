package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_BusquedaSiniestroAvanzadaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_BusquedaSiniestroAvanzada;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
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
public class VistaINTER_BusquedaSiniestroAvanzadaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_BusquedaSiniestroAvanzadaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interBusquedaSiniestroAvanzada = null;

        try {
            interBusquedaSiniestroAvanzada = INTER_BusquedaSiniestroAvanzadaBean.getINTER_BusquedaSiniestroAvanzada();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interBusquedaSiniestroAvanzada.size(); j++) {
            INTER_BusquedaSiniestroAvanzadaBean inter_busquedaSiniestroAvanzadaBean = (INTER_BusquedaSiniestroAvanzadaBean) interBusquedaSiniestroAvanzada.get(j);
            INTER_BusquedaSiniestroAvanzada a = new INTER_BusquedaSiniestroAvanzada();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_busquedaSiniestroAvanzadaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por, producto, Tipo_Tercero, apellido, nombre,Rol, Oficina, Num_Poliza,Num_Propuesta, evento_Siniestro FROM INTER_BUSQUEDA_AVANZADA ORDER BY PRUEBA ASC",
                "INTER_BUSQUEDA_AVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroAvanzada_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por, producto, Tipo_Tercero, apellido, nombre,Rol, Oficina, Num_Poliza,Num_Propuesta, evento_Siniestro FROM INTER_BUSQUEDA_AVANZADA ORDER BY PRUEBA ASC",
                "INTER_BUSQUEDA_AVANZADA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroAvanzada_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroAvanzada_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interBusquedaSiniestroAvanzada_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
