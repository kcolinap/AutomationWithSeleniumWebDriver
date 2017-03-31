package AcseleV13_8Asesuisa.tests;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aandrade on 31/03/2017.
 */
public class VistaAsesuisa_CajaAperturarCerrarTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_CajaAperturarCerrarTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList caja = null;

        try {
            caja = Asesuisa_CajaAperturarCerrarBean.getAsesuisa_CajaAperturarCerrar();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < caja.size(); j++) {
            Asesuisa_CajaAperturarCerrarBean bean =(Asesuisa_CajaAperturarCerrarBean) caja.get(j);

            Asesuisa_CajaAperturarCerrar a = new Asesuisa_CajaAperturarCerrar();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {
//
         DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_APERTURAR_CERRAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_APERTURAR_CERRAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset1.xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASESUISA_CAJA_APERTURAR_CERRAR ORDER BY PRUEBA ASC",
                "ASESUISA_CAJA_APERTURAR_CERRAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset1.xml");
//
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaCajaAsociarCajero_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
