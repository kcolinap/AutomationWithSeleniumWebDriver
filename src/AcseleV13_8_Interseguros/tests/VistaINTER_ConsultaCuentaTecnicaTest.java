package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaCuentaTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaCuentaTecnica;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 07/12/2016.
 */
public class VistaINTER_ConsultaCuentaTecnicaTest {

        private final static Logger log = Logger.getLogger(VistaINTER_ConsultaCuentaTecnicaTest.class);

        @Test
        public void mainTest() throws SQLException {

            ArrayList interCuentaTecnica = null;

            try {
                interCuentaTecnica = INTER_ConsultaCuentaTecnicaBean.getInterConsultaCuentaTecnica();
            }catch (SQLException e) {
                log.error(e);
            }

            for (int j = 0; j< interCuentaTecnica.size(); j++) {
                INTER_ConsultaCuentaTecnicaBean inter_consultaCuentaTecnicaBean = (INTER_ConsultaCuentaTecnicaBean) interCuentaTecnica.get(j);
                INTER_ConsultaCuentaTecnica a = new INTER_ConsultaCuentaTecnica();
                Metodos intersegurosMetodos = new Metodos();
                String horaC = intersegurosMetodos.horaCarpeta();

                try {
                    a.testLink(inter_consultaCuentaTecnicaBean, j, horaC);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
                }
            }

        }

        @Before
        public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Reasegurador,Corredor,Fecha_Desde,Fecha_Hasta,Tipo_Contrato,Moneda FROM CONSULTA_CUENTA_TECNICA ORDER BY PRUEBA ASC",
                "CONSULTA_CUENTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interConsultaCuentaTecnica_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Reasegurador,Corredor,Fecha_Desde,Fecha_Hasta,Tipo_Contrato,Moneda FROM CONSULTA_CUENTA_TECNICA ORDER BY PRUEBA ASC",
                "CONSULTA_CUENTA_TECNICA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interConsultaCuentaTecnica_dataset.xml");
*/
            DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaCuentaTecnica_dataset.xml", DataSetManager.REFRESH_OPERATION);
        }

        @After
        public void tearDown() throws Exception {

            DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaCuentaTecnica_dataset.xml", DataSetManager.DELETE_OPERATION);
        }
}
