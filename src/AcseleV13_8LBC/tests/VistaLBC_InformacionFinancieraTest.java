package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_InformacionFinancieraBean;
import AcseleV13_8LBC.main.controller.LBC_InformacionFinanciera;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by rmontilla on 20/10/2016.
 */
public class VistaLBC_InformacionFinancieraTest {

    private final static Logger log = Logger.getLogger(VistaLBC_InformacionFinancieraTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = null;

        try {
            terceros = LBC_InformacionFinancieraBean.getInformacionFinanciera();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < terceros.size(); i++){

            LBC_InformacionFinancieraBean lbcInformacionFinancieraBean = (LBC_InformacionFinancieraBean) terceros.get(i);
            LBC_InformacionFinanciera a = new LBC_InformacionFinanciera();

            try {
                a.testLink(lbcInformacionFinancieraBean, i);
            }catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, COD_IDENTIFICADOR, ACTIVOS, ACTIVOS_FIJOS, INVERSIONES, OTROS_ACTIVOS, TOTAL_ACTIVOS, PASIVO_CIRCULANTE, PASIVO_LARGO_PLAZO, CAPITAL_PAGADO, CAPITAL_RESERVA, EXCEDENTE, TOTAL_PASIVO_CAPITAL, CAPITAL_TRABAJO, SOLVENCIA, LIQUIDEZ FROM INFORMACION_FINANCIERA_LBC ORDER BY PRUEBA ASC",
                "INFORMACION_FINANCIERA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/tercerosInfoFinancieraLBC_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_DOC_IDENTIDAD, TIPO_TERCERO, CEDULA, NOMBRE, APELLIDO, COD_IDENTIFICADOR, ACTIVOS, ACTIVOS_FIJOS, INVERSIONES, OTROS_ACTIVOS, TOTAL_ACTIVOS, PASIVO_CIRCULANTE, PASIVO_LARGO_PLAZO, CAPITAL_PAGADO, CAPITAL_RESERVA, EXCEDENTE, TOTAL_PASIVO_CAPITAL, CAPITAL_TRABAJO, SOLVENCIA, LIQUIDEZ FROM INFORMACION_FINANCIERA_LBC ORDER BY PRUEBA ASC",
                "INFORMACION_FINANCIERA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/tercerosInfoFinancieraLBC_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfoFinancieraLBC_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfoFinancieraLBC_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
