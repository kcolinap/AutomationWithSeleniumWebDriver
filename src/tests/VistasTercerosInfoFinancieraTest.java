package tests;

import beans.TercerosInfoFinancieraBean;
import main.controller.TercerosInfoFinanciera;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 22/06/2016.
 */
public class VistasTercerosInfoFinancieraTest {

    private final static Logger log = Logger.getLogger(VistasTercerosInfoFinancieraTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = TercerosInfoFinancieraBean.getTercerosInfoFinanciera();

        for (int i = 0; i < terceros.size(); i++){
            TercerosInfoFinancieraBean tercerosInfoFinancieraBean = (TercerosInfoFinancieraBean) terceros.get(i);
            TercerosInfoFinanciera a = new TercerosInfoFinanciera();

            try {
                a.testLink(tercerosInfoFinancieraBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - Terceros Informacion Financiera - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, FEC_EXPE_DOC_ID, LUG_EXPE_DOC_ID, ACTIVIDAD_ECONOMICA_CIIU, NACIONALIDAD, EMPRESA_TRABAJA, AREA, CARGO, DIRECCION_LABORAL, CIUDAD_LABORAL, TELF_LABORAL, NUM_FAX, TELF_FIJO, TELF_CELULAR, FEC_DILIG_SARLAFT, INGRESOS_MENSUALES, OTROS_INGRESOS, CONCEPTO_OTROS_INGRESOS, EGRESOS_MENSUALES, ACTIVOS, PASIVOS, VERIF_INFORMACION, OBSERVACIONES, MANEJA_RECURSO_PUBLICOS, EJERCE_PODER_PUBLICO, RECONOCIMIENTO_PUBLICO_GENERAL, REP_PRODUCTOS_EXTERIOR, OPERA_EXTRANJERAS_NO, OPERA_EXTRANJERAS_EXPORTA, OPERA_EXTRANJERAS_IMPORTA, OPERA_EXTRANJERAS_INVERSION, OPERA_EXTRANJERAS_OTRA FROM TERCEROS_INF_FINANCIERA ORDER BY PRUEBA ASC",
                "TERCEROS_INF_FINANCIERA",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/tercerosInfoFinanciera_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, FEC_EXPE_DOC_ID, LUG_EXPE_DOC_ID, ACTIVIDAD_ECONOMICA_CIIU, NACIONALIDAD, EMPRESA_TRABAJA, AREA, CARGO, DIRECCION_LABORAL, CIUDAD_LABORAL, TELF_LABORAL, NUM_FAX, TELF_FIJO, TELF_CELULAR, FEC_DILIG_SARLAFT, INGRESOS_MENSUALES, OTROS_INGRESOS, CONCEPTO_OTROS_INGRESOS, EGRESOS_MENSUALES, ACTIVOS, PASIVOS, VERIF_INFORMACION, OBSERVACIONES, MANEJA_RECURSO_PUBLICOS, EJERCE_PODER_PUBLICO, RECONOCIMIENTO_PUBLICO_GENERAL, REP_PRODUCTOS_EXTERIOR, OPERA_EXTRANJERAS_NO, OPERA_EXTRANJERAS_EXPORTA, OPERA_EXTRANJERAS_IMPORTA, OPERA_EXTRANJERAS_INVERSION, OPERA_EXTRANJERAS_OTRA FROM TERCEROS_INF_FINANCIERA ORDER BY PRUEBA ASC",
                "TERCEROS_INF_FINANCIERA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/tercerosInfoFinanciera_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/tercerosInfoFinanciera_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/tercerosInfoFinanciera_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
