package AcseleV13_8_Interseguros.tests;


//import AcseleV13_8_Interseguros.beans.INTER_CrearOpenItemsBean;
//import AcseleV13_8_Interseguros.main.controller.INTER_CrearOpenItems;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 20/01/2017.
 */
public class VistaINTER_CrearOpenItemsTest {
    private final static Logger log = Logger.getLogger(VistaINTER_CrearOpenItemsTest.class);

    @Test
    public void mainTest() throws SQLException {
       /* ArrayList item = INTER_CrearOpenItemsBean.getCrearOpenItems();

        for ( int i = 0; i < item.size(); i++) {

            INTER_CrearOpenItemsBean interCrearOpenItemsBean = (INTER_CrearOpenItemsBean) item.get(i);
            INTER_CrearOpenItems a = new INTER_CrearOpenItems();

            try {
                //a.testLink(interCrearOpenItemsBean, i);
            } catch (Exception e) {
                e.printStackTrace();
                //                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
*/
    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,TIPO_DOC_IDENT,NUM_DOC_IDENT,CONCEPTO_CUENTA,ROL2,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_INTER ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interCrearOpenItems_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,TERCERO,TIPO_TERCERO,ROL1,APELLIDO_PATERNO,APELLIDO_MATERNO,PRIMER_NOMBRE,SEGUNDO_NOMBRE,TERCER_NOMBRE,TIPO_DOC_IDENT,NUM_DOC_IDENT,CONCEPTO_CUENTA,ROL2,FECHA_MOV,FECHA_VENCIMIENTO,MONEDA,MONTO,NUM_POLIZA,TIPO_REF FROM CREAR_OPEN_ITEMS_INTER ORDER BY PRUEBA ASC",
                "CREAR_OPEN_ITEMS_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interCrearOpenItems_dataset.xml");

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCrearOpenItems_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interCrearOpenItems_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
