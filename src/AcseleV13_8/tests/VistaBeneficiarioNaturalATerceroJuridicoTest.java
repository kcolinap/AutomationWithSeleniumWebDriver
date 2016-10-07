package AcseleV13_8.tests;

import AcseleV13_8.beans.BeneficiarioNaturalATerceroJuridicoBean;
import AcseleV13_8.main.controller.BeneficiarioNaturalATercerosJuridico;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by mchurion on 12/07/2016.
 */
public class VistaBeneficiarioNaturalATerceroJuridicoTest {
    private final static Logger log = Logger.getLogger(VistaBeneficiarioNaturalATerceroJuridicoTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = BeneficiarioNaturalATerceroJuridicoBean.getBeneficiarioNaturalATerceroJuridico();

        for (int i = 0; i < terceros.size(); i++) {
            BeneficiarioNaturalATerceroJuridicoBean beneficiarioNaturalATerceroJuridicoBean = (BeneficiarioNaturalATerceroJuridicoBean) terceros.get(i);
            BeneficiarioNaturalATercerosJuridico a = new BeneficiarioNaturalATercerosJuridico();

            try {
                a.testLink(beneficiarioNaturalATerceroJuridicoBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, ROL FROM BENEFICIARIO_NATURAL_TERCERO ORDER BY PRUEBA ASC",
                "BENEFICIARIO_NATURAL_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.tests.xmls/beneficiarioNaturalATerceroJuridico_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, ROL FROM BENEFICIARIO_NATURAL_TERCERO ORDER BY PRUEBA ASC",
                "BENEFICIARIO_NATURAL_TERCERO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.tests.xmls/beneficiarioNaturalATerceroJuridico_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/beneficiarioNaturalATerceroJuridico_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/beneficiarioNaturalATerceroJuridico_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
