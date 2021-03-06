package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_TercerosInfTecnicaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TercerosInfTecnica;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 14/12/2016.
 */
public class VistaINTER_TercerosInfTecnicaTest {
    private final static Logger log = Logger.getLogger(VistaINTER_TercerosInfTecnicaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tercerosInfTecnicaINTER = null;

        try {
            tercerosInfTecnicaINTER = INTER_TercerosInfTecnicaBean.getTercerosInfTecnicaINTER();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< tercerosInfTecnicaINTER.size(); j++) {
            INTER_TercerosInfTecnicaBean interTercerosInfTecnicaBean = (INTER_TercerosInfTecnicaBean) tercerosInfTecnicaINTER.get(j);
            INTER_TercerosInfTecnica a = new INTER_TercerosInfTecnica();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(interTercerosInfTecnicaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*
        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_INF_TECNICA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosInfTecnica_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Tipo_Terceros,Apellido, Nombre, Num_Doc_Identificacion from TERCEROS_INF_TECNICA_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_INF_TECNICA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosInfTecnica_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosInfTecnica_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosInfTecnica_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
