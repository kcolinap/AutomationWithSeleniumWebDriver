package AcseleV13_8.tests;

import AcseleV13_8.beans.BeneficiarioJuridicoATerceroNaturalBean;
import AcseleV13_8.main.controller.BeneficiarioJuridicoATerceroNatural;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by mchurion on 13/07/2016.
 */
public class VistaBeneficiarioJuridicoATerceroNaturalTest {

    private final static Logger log = Logger.getLogger(VistaBeneficiarioJuridicoATerceroNaturalTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = BeneficiarioJuridicoATerceroNaturalBean.getBeneficiarioJuridicoATerceroNatural();

        for (int i = 0; i < terceros.size(); i++) {
            BeneficiarioJuridicoATerceroNaturalBean beneficiarioJuridicoATerceroNaturalBean = (BeneficiarioJuridicoATerceroNaturalBean) terceros.get(i);
            BeneficiarioJuridicoATerceroNatural a = new BeneficiarioJuridicoATerceroNatural();

            try {
                a.testLink(beneficiarioJuridicoATerceroNaturalBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }
    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, NIT, RAZON_SOCIAL, ROL FROM BENEFICIARIO_JURIDICO_TERCERO ORDER BY PRUEBA ASC",
                "BENEFICIARIO_JURIDICO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/beneficiarioJuridicoATerceroNatural_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, NIT, RAZON_SOCIAL, ROL FROM BENEFICIARIO_JURIDICO_TERCERO ORDER BY PRUEBA ASC",
                "BENEFICIARIO_JURIDICO_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/beneficiarioJuridicoATerceroNatural_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/beneficiarioJuridicoATerceroNatural_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/beneficiarioJuridicoATerceroNatural_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
