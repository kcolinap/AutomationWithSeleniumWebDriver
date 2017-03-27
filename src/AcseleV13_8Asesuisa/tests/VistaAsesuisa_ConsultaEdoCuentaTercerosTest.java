package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_ConsultaEdoCuentaTercerosBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ConsultaEdoCuentaTerceros;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 23/03/2017.
 */
public class VistaAsesuisa_ConsultaEdoCuentaTercerosTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_ConsultaEdoCuentaTercerosTest.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList asesuisaConsultaEdoCuentaTerceros = null;

        try {
            asesuisaConsultaEdoCuentaTerceros = Asesuisa_ConsultaEdoCuentaTercerosBean.getConsultaEdoCuentaTerceros();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < asesuisaConsultaEdoCuentaTerceros.size(); j++) {
            Asesuisa_ConsultaEdoCuentaTercerosBean bean = (Asesuisa_ConsultaEdoCuentaTercerosBean) asesuisaConsultaEdoCuentaTerceros.get(j);
            Asesuisa_ConsultaEdoCuentaTerceros a = new Asesuisa_ConsultaEdoCuentaTerceros();
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
    public void setUp(int num) throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASE_CONSULTA_ESTADO_CUENTA ORDER BY PRUEBA ASC",
                "ASE_CONSULTA_ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaConsultaEdoCuentaTerceros_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_CONSULTA_ESTADO_CUENTA ORDER BY PRUEBA ASC",
                "ASE_CONSULTA_ESTADO_CUENTA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaConsultaEdoCuentaTerceros_dataset"+num+".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaConsultaEdoCuentaTerceros_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(int num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaConsultaEdoCuentaTerceros_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
    }
}
