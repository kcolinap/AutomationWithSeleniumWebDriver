package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_IncluirEtiquetaTransformadorBean;
import AcseleV13_8LBC.main.controller.LBC_IncluirEtiquetaTransformador;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 01/11/2016.
 */
public class VistaLBC_IncluirEtiquetaTransformadorTest {

    private final static Logger log = Logger.getLogger(VistaLBC_IncluirEtiquetaTransformadorTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList lbc_IncluirEtiquetaTransformador = LBC_IncluirEtiquetaTransformadorBean.getLBC_IncluirEtiquetaTransformador();

        for (int i = 0; i < lbc_IncluirEtiquetaTransformador.size(); i++) {
            LBC_IncluirEtiquetaTransformadorBean lbc_IncluirEtiquetaTransformadorBean = (LBC_IncluirEtiquetaTransformadorBean) lbc_IncluirEtiquetaTransformador.get(i);
            LBC_IncluirEtiquetaTransformador a = new LBC_IncluirEtiquetaTransformador();


            try {
                a.testLink(lbc_IncluirEtiquetaTransformadorBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, PROPIEDAD, VALOR, ETIQUETA, LOCALE, PRODUCTO FROM LBC_ETIQUETA_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_ETIQUETA_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/LBC_etiqueta_Transformadores_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PROPIEDAD, VALOR, ETIQUETA, LOCALE, PRODUCTO FROM LBC_ETIQUETA_TRANSFORMADORES ORDER BY PRUEBA ASC",
                "LBC_ETIQUETA_TRANSFORMADORES",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/LBC_etiqueta_Transformadores_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_etiqueta_Transformadores_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/LBC_etiqueta_Transformadores_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
