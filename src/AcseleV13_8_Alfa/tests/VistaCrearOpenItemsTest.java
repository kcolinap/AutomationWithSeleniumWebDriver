package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.CrearOpenItemsBean;
import AcseleV13_8_Alfa.main.controller.CrearOpenItems;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by mchurion on 23/08/2016.
 */
public class VistaCrearOpenItemsTest {

    private final static Logger log = Logger.getLogger(VistaCrearOpenItemsTest.class);

    @Test
    public void mainTest() throws SQLException{
        ArrayList item = CrearOpenItemsBean.getCrearOpenItems();

        for ( int i = 0; i < item.size(); i++) {

            CrearOpenItemsBean crearOpenItemsBean = (CrearOpenItemsBean) item.get(i);
            CrearOpenItems a = new CrearOpenItems();

            try {
                a.testLink(crearOpenItemsBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                //                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA,ROL1,TIPO_TERCERO,ROL2,TIPO_DOCUMENTO,PASAPORTE,NUM_DOCUMENTO,INDICATIVO1,PRIMER_NOMBRE,TELEFONO_FIJO,SEGUNDO_NOMBRE,TLF_FIJO_COMPLETO,PRIMER_APELLIDO,INDICATIVO2,SEGUNDO_APELLIDO,TLF_OFICINA,NOMBRE_APELLIDO,EXTENSION,ESTADO_CIVIL,TLF_OFICINA_COMPLETO,EMAIL_1,TLF_CELULAR,EMAIL_2,AUTORIZA_USO_DATOS_PERSONALES,GRADO_INSTRUCCION,OCUPACION,RECIBIR_INF_X_TLF,RECIBIR_INF_X_CORREO,FECHA_INCLUSION,CODIGO_IDENTIFICADOR,CODIGO_INTERNO,TARJETA_IDENTIDAD,REGISTRO_CIVIL,TARJETA_EXTRANJERÍA,CÉDULA_EXTRANJERÍA,DOCUMENTO_EXTRANJERO FROM CREAR_OPEN_ITEMS ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xmls/crearOpenItems_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,ROL1,TIPO_TERCERO,ROL2,TIPO_DOCUMENTO,PASAPORTE,NUM_DOCUMENTO,INDICATIVO1,PRIMER_NOMBRE,TELEFONO_FIJO,SEGUNDO_NOMBRE,TLF_FIJO_COMPLETO,PRIMER_APELLIDO,INDICATIVO2,SEGUNDO_APELLIDO,TLF_OFICINA,NOMBRE_APELLIDO,EXTENSION,ESTADO_CIVIL,TLF_OFICINA_COMPLETO,EMAIL_1,TLF_CELULAR,EMAIL_2,AUTORIZA_USO_DATOS_PERSONALES,GRADO_INSTRUCCION,OCUPACION,RECIBIR_INF_X_TLF,RECIBIR_INF_X_CORREO,FECHA_INCLUSION,CODIGO_IDENTIFICADOR,CODIGO_INTERNO,TARJETA_IDENTIDAD,REGISTRO_CIVIL,TARJETA_EXTRANJERÍA,CÉDULA_EXTRANJERÍA,DOCUMENTO_EXTRANJERO FROM CREAR_OPEN_ITEMS ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Alfa/tests/xmls/crearOpenItems_dataset.xml");*/

       DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/crearOpenItems_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/crearOpenItems_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
