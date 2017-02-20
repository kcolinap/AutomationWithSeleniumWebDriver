package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaTerceroBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaTercero;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 14/11/2016.
 */
public class VistaINTER_ConsultaTerceroTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaTerceroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consultaTerceroINTER = null;

        try {
            consultaTerceroINTER = INTER_ConsultaTerceroBean.getConsutaTercerosINTERBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< consultaTerceroINTER.size(); j++) {
            INTER_ConsultaTerceroBean inter_consultaTerceroBean = (INTER_ConsultaTerceroBean) consultaTerceroINTER.get(j);
            INTER_ConsultaTercero a = new INTER_ConsultaTercero();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_consultaTerceroBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {
/*
        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, COD_IDENTIFICADOR, NUM_DOC_ID  from CONSULTA_TERCEROS_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/consultaTercerosINTER_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,TIPO_TERCERO,APELLIDO,NOMBRE, COD_IDENTIFICADOR, NUM_DOC_ID  from CONSULTA_TERCEROS_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_TERCEROS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/consultaTercerosINTER_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/consultaTercerosINTER_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/consultaTercerosINTER_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
