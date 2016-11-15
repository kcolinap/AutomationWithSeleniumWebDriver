package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_ConsultaEdoCuentaTercerosBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaEdoCuentaTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 15/11/2016.
 */
public class VistaINTER_ConsultaEdoCuentaTercerosTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaEdoCuentaTercerosTest.class);

    @Test
    //@Transactional
    public void mainTest() throws SQLException {

        ArrayList interEdoCuentas = INTER_ConsultaEdoCuentaTercerosBean.getInterConsultaEdoCuentaTerceros();

        for (int i = 0; i < interEdoCuentas.size(); i++) {

            INTER_ConsultaEdoCuentaTercerosBean inter_consultaEdoCuentaTercerosBean = (INTER_ConsultaEdoCuentaTercerosBean) interEdoCuentas.get(i);
            INTER_ConsultaEdoCuentaTerceros a = new INTER_ConsultaEdoCuentaTerceros();

            try {
                a.testLink(inter_consultaEdoCuentaTercerosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }


    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA,TIPO_TERCERO, NUM_DOC_IDENT,APELLIDO,NOMBRE, FECHA_INICIAL, FECHA_FINAL, MONEDA, PRODUCTO FROM INTER_CONSULTA_EDO_CUENTAS ORDER BY PRUEBA ASC",
                "INTER_CONSULTA_EDO_CUENTAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interConsultaEdoCuentas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,TIPO_TERCERO, NUM_DOC_IDENT,APELLIDO,NOMBRE, FECHA_INICIAL, FECHA_FINAL, MONEDA, PRODUCTO FROM INTER_CONSULTA_EDO_CUENTAS ORDER BY PRUEBA ASC",
                "INTER_CONSULTA_EDO_CUENTAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interConsultaEdoCuentas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaEdoCuentas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interConsultaEdoCuentas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
