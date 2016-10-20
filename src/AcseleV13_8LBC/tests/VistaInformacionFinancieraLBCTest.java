package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.InformacionFinancieraLBCBean;
import AcseleV13_8LBC.main.controller.InformacionFinancieraLBC;
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
public class VistaInformacionFinancieraLBCTest {

    private final static Logger log = Logger.getLogger(VistaInformacionFinancieraLBCTest.class);

    @Test
    public void mainTest(){

        ArrayList terceros = null;

        try {
            terceros = InformacionFinancieraLBCBean.getInformacionFinanciera();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < terceros.size(); i++){

            InformacionFinancieraLBCBean informacionFinancieraLBCBean = (InformacionFinancieraLBCBean) terceros.get(i);
            InformacionFinancieraLBC a = new InformacionFinancieraLBC();

            try {
                a.testLink(informacionFinancieraLBCBean, i);
            }catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

    /*    DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, FEC_EXPE_DOC_ID, LUG_EXPE_DOC_ID, ACTIVIDAD_ECONOMICA_CIIU, NACIONALIDAD, EMPRESA_TRABAJA, AREA, CARGO, DIRECCION_LABORAL, CIUDAD_LABORAL, TELF_LABORAL, NUM_FAX, TELF_FIJO, TELF_CELULAR, FEC_DILIG_SARLAFT, INGRESOS_MENSUALES, OTROS_INGRESOS, CONCEPTO_OTROS_INGRESOS, EGRESOS_MENSUALES, ACTIVOS, PASIVOS, VERIF_INFORMACION, OBSERVACIONES, MANEJA_RECURSO_PUBLICOS, EJERCE_PODER_PUBLICO, RECONOCIMIENTO_PUBLICO_GENERAL, REP_PRODUCTOS_EXTERIOR, OPERA_EXTRANJERAS_NO, OPERA_EXTRANJERAS_EXPORTA, OPERA_EXTRANJERAS_IMPORTA, OPERA_EXTRANJERAS_INVERSION, OPERA_EXTRANJERAS_OTRA FROM INFORMACION_FINANCIERA_LBC ORDER BY PRUEBA ASC",
                "INFORMACION_FINANCIERA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/tercerosInfoFinanciera_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, TIPO_TERCERO, TIPO_DOC_IDENTIDAD, CEDULA, NOMBRE, APELLIDO, FEC_EXPE_DOC_ID, LUG_EXPE_DOC_ID, ACTIVIDAD_ECONOMICA_CIIU, NACIONALIDAD, EMPRESA_TRABAJA, AREA, CARGO, DIRECCION_LABORAL, CIUDAD_LABORAL, TELF_LABORAL, NUM_FAX, TELF_FIJO, TELF_CELULAR, FEC_DILIG_SARLAFT, INGRESOS_MENSUALES, OTROS_INGRESOS, CONCEPTO_OTROS_INGRESOS, EGRESOS_MENSUALES, ACTIVOS, PASIVOS, VERIF_INFORMACION, OBSERVACIONES, MANEJA_RECURSO_PUBLICOS, EJERCE_PODER_PUBLICO, RECONOCIMIENTO_PUBLICO_GENERAL, REP_PRODUCTOS_EXTERIOR, OPERA_EXTRANJERAS_NO, OPERA_EXTRANJERAS_EXPORTA, OPERA_EXTRANJERAS_IMPORTA, OPERA_EXTRANJERAS_INVERSION, OPERA_EXTRANJERAS_OTRA FROM INFORMACION_FINANCIERA_LBC ORDER BY PRUEBA ASC",
                "INFORMACION_FINANCIERA_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/tercerosInfoFinanciera_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfoFinanciera_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/tercerosInfoFinanciera_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
