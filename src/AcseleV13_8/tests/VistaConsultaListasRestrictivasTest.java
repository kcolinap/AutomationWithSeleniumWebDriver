package AcseleV13_8.tests;
import AcseleV13_8.beans.ConsultaListasRestrictivasBean;
import AcseleV13_8.main.controller.ConsultaListasRestrictivas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 25/08/2016.
 */
public class VistaConsultaListasRestrictivasTest {

    /**
     *
    */
    private final static Logger log = Logger.getLogger(VistaConsultaListasRestrictivasTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList listasRestritivas = ConsultaListasRestrictivasBean.getConsultaListasRestrictivas();

        for (int i = 0; i < listasRestritivas.size(); i++) {
            ConsultaListasRestrictivasBean consultaListasRestrictivasBean = (ConsultaListasRestrictivasBean) listasRestritivas.get(i);
            ConsultaListasRestrictivas a = new ConsultaListasRestrictivas();

            try {
                a.testLink(consultaListasRestrictivasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Lista_Restrictiva,Ident_Lista_Restrictiva,Nombre_Lista_Restrictiva,Apellido_Lista_Restrictiva,Codigo_Lista_Restrictiva,Observacion_Lista_Restrictiva,Lista_Relativa_Sanciones FROM LISTA_RESTRICTIVA ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/consultaListasRestrictivas_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Lista_Restrictiva,Ident_Lista_Restrictiva,Nombre_Lista_Restrictiva,Apellido_Lista_Restrictiva,Codigo_Lista_Restrictiva,Observacion_Lista_Restrictiva,Lista_Relativa_Sanciones FROM LISTA_RESTRICTIVA ORDER BY PRUEBA ASC",
                "LISTA_RESTRICTIVA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/consultaListasRestrictivas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaListasRestrictivas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/consultaListasRestrictivas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }



}
