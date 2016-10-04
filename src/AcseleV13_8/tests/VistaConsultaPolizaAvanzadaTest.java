package AcseleV13_8.tests;

import AcseleV13_8.beans.ConsultaPolizaAvanzadaBean;
import AcseleV13_8.main.controller.ConsultaPolizaAvanzada;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 26/05/2016.
 */
public class VistaConsultaPolizaAvanzadaTest {

    private final static Logger log = Logger.getLogger(VistaConsultaPolizaAvanzadaTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException{

        ArrayList consultaPolizas = null;
        try {
            consultaPolizas = ConsultaPolizaAvanzadaBean.getConsultaPolizasAvanzadas();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < consultaPolizas.size(); i++) {

            ConsultaPolizaAvanzadaBean consultaPolizaAvanzadaBean = (ConsultaPolizaAvanzadaBean) consultaPolizas.get(i);
            ConsultaPolizaAvanzada a = new ConsultaPolizaAvanzada();

            try {
                a.testLink(consultaPolizaAvanzadaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, FECHA_EMISION, NUM_POLIZA, TIPO_TERCERO, PRIMER_NOMBRE, PRIMER_APELLIDO, EDO_CICLO_VIDA, NUM_DOCUMENTO_IDENTIFICACION, PASAPORTE, TELEFONO_FIJO, TIPO_DOC_IDENTIFICACION, EMAIL_1, TELEFONO_CELULAR FROM BUSQUEDA_POLIZA ORDER BY PRUEBA ASC",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, FECHA_EMISION, NUM_POLIZA, TIPO_TERCERO, PRIMER_NOMBRE, PRIMER_APELLIDO, EDO_CICLO_VIDA, NUM_DOCUMENTO_IDENTIFICACION, PASAPORTE, TELEFONO_FIJO, TIPO_DOC_IDENTIFICACION, EMAIL_1, TELEFONO_CELULAR FROM BUSQUEDA_POLIZA ORDER BY PRUEBA ASC",
                "BUSQUEDA_POLIZA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaPolizaAvanzada_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
