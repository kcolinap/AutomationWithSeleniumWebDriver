package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CrearOpenItemsBean;
import AcseleV13_8LBC.main.controller.LBC_CrearOpenItems;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 26/10/2016.
 */

public class VistaLBC_CrearOpenItemsTest {

    private final static Logger log = Logger.getLogger(VistaLBC_CrearOpenItemsTest.class);

    @Test
    public void mainTest() throws SQLException {
        ArrayList item = LBC_CrearOpenItemsBean.getCrearOpenItems();

        for ( int i = 0; i < item.size(); i++) {

            LBC_CrearOpenItemsBean lbcCrearOpenItemsBean = (LBC_CrearOpenItemsBean) item.get(i);
            LBC_CrearOpenItems a = new LBC_CrearOpenItems();

            try {
                a.testLink(lbcCrearOpenItemsBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                //                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,APELLIDO_CASADA,TIPO_DOC_IDENT,NUM_DOC_IDENT,EXTENSION_DOC_IDENT,COMPLEMENTO_DOC_IDENT,SEXO,ESTADO_CIVIL,NOMBRE_CONYUGE,NUM_DOC_CONYUGE,NIVEL_EDUCACIONAL,NIT,FACTURAR_CI_NIT,DIRECC_CORRESPONDENCIA,NACIONALIDAD,FECHA_NACIMIENTO,PROFESION,OCUPACION_PRINCIPAL,TIPO_TRABAJADOR,LUGAR_TRABAJO_ACTUAL,FECHA_INGRESO_TRABAJO,CARGO,INGRESOS_MENSUALES,REFERENCIAS,TELEFONO_FIJO,TELEFONO_CELULAR,TELEFONO_CONTACTO,TELEFONO_EMPLEADOR,TELEFONO_COBRANZA_1,TELEFONO_COBRANZA_2,PAGINA_WEB,EMAIL,LOGIN,PREDETERMINEDNAME,COD_IDENTIFICADOR,CHEQUEO_UNICIDAD,IDIOMA_X_OMISION,IDIOMA,IDENTIFICADOR_IV,ROL2,CONCEPTO_CUENTA,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_LBC ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCrearOpenItems_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,APELLIDO_CASADA,TIPO_DOC_IDENT,NUM_DOC_IDENT,EXTENSION_DOC_IDENT,COMPLEMENTO_DOC_IDENT,SEXO,ESTADO_CIVIL,NOMBRE_CONYUGE,NUM_DOC_CONYUGE,NIVEL_EDUCACIONAL,NIT,FACTURAR_CI_NIT,DIRECC_CORRESPONDENCIA,NACIONALIDAD,FECHA_NACIMIENTO,PROFESION,OCUPACION_PRINCIPAL,TIPO_TRABAJADOR,LUGAR_TRABAJO_ACTUAL,FECHA_INGRESO_TRABAJO,CARGO,INGRESOS_MENSUALES,REFERENCIAS,TELEFONO_FIJO,TELEFONO_CELULAR,TELEFONO_CONTACTO,TELEFONO_EMPLEADOR,TELEFONO_COBRANZA_1,TELEFONO_COBRANZA_2,PAGINA_WEB,EMAIL,LOGIN,PREDETERMINEDNAME,COD_IDENTIFICADOR,CHEQUEO_UNICIDAD,IDIOMA_X_OMISION,IDIOMA,IDENTIFICADOR_IV,ROL2,CONCEPTO_CUENTA,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_LBC ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCrearOpenItems_dataset.xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCrearOpenItems_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCrearOpenItems_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
