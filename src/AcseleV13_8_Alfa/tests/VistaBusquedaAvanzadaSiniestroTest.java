package AcseleV13_8_Alfa.tests;

import AcseleV13_8_Alfa.beans.BusquedaAvanzadaSiniestroBean;
import AcseleV13_8_Alfa.main.controller.BusquedaAvanzadaSiniestro;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 09/08/2016.
 */
public class VistaBusquedaAvanzadaSiniestroTest {

    private final static Logger log = Logger.getLogger(VistaBusquedaAvanzadaSiniestroTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList caja = BusquedaAvanzadaSiniestroBean.getBusquedaAvanzadaSiniestro();

        for (int i = 0; i < caja.size(); i++) {
            BusquedaAvanzadaSiniestroBean busquedaAvanzadaSiniestroBean = (BusquedaAvanzadaSiniestroBean) caja.get(i);
            BusquedaAvanzadaSiniestro a = new BusquedaAvanzadaSiniestro();

            try {
                //a.testLink(busquedaAvanzadaSiniestroBean, i);
            } catch (Exception e) {
                e.printStackTrace();
    //                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
    }
}

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDEN,PRODUCTO,EVENTO,SUCURSAL,NUM_POLIZA,EMISION,TIPO_PRODUCCION,CANAL_VENTA,FRECUENCIA_PAGO,TIPO_POLIZA,TIPO_TERCERO,TIPO_DOCUMENTO,NUM_DOCUMENTO,NOMBRE_APELLIDO,FECHA_INCLUSION,TLF_OFICINA,EXTENSION,TLF_OFICINA_COMPLETO,EMAIL_1,EMAIL_2,CODIGO_INTERNO,CODIGO_IDENTIFICADOR,INDICATIVO,ROL,NUM_UNIDAD_RIESGO,TIPO_OBJ_ASEGURADO,NUM_OBJ_ASEGURADO,NOMBRE_ASEGURADO,NOMBRE_BENEFICIARIO FROM BUSQUEDA_AVANZADA_SINIESTRO ORDER BY PRUEBA ASC",
                "BUSQUEDA_AVANZADA_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xmls/busquedaAvanzadaSiniestro_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDEN,PRODUCTO,EVENTO,SUCURSAL,NUM_POLIZA,EMISION,TIPO_PRODUCCION,CANAL_VENTA,FRECUENCIA_PAGO,TIPO_POLIZA,TIPO_TERCERO,TIPO_DOCUMENTO,NUM_DOCUMENTO,NOMBRE_APELLIDO,FECHA_INCLUSION,TLF_OFICINA,EXTENSION,TLF_OFICINA_COMPLETO,EMAIL_1,EMAIL_2,CODIGO_INTERNO,CODIGO_IDENTIFICADOR,INDICATIVO,ROL,NUM_UNIDAD_RIESGO,TIPO_OBJ_ASEGURADO,NUM_OBJ_ASEGURADO,NOMBRE_ASEGURADO,NOMBRE_BENEFICIARIO FROM BUSQUEDA_AVANZADA_SINIESTRO ORDER BY PRUEBA ASC",
                "BUSQUEDA_AVANZADA_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Alfa/tests/xmls/busquedaAvanzadaSiniestro_dataset.xml");

        //DataSetManager.loadDataSet("C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Alfa/tests/xmls/busquedaAvanzadaSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/busquedaAvanzadaSiniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8_Alfa/tests/xmls/busquedaAvanzadaSiniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
