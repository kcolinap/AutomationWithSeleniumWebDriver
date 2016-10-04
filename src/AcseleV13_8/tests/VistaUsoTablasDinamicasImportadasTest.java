package AcseleV13_8.tests;

import AcseleV13_8.beans.UsoTablasDinamicasImportadasBean;
import AcseleV13_8.main.controller.UsoTablasDinamicasImportadas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 17/08/2016.
 */
public class VistaUsoTablasDinamicasImportadasTest {

    private final static Logger log = Logger.getLogger(VistaUsoTablasDinamicasImportadasTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tablasDinamicas = UsoTablasDinamicasImportadasBean.getUsoTablasDinamicasImportadas();

        for (int i = 0; i < tablasDinamicas.size(); i++){
            UsoTablasDinamicasImportadasBean importExportTablasDinamicasBean = (UsoTablasDinamicasImportadasBean) tablasDinamicas.get(i);
            UsoTablasDinamicasImportadas a = new UsoTablasDinamicasImportadas();

            try {
                a.testLink(importExportTablasDinamicasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, RUTA_TABLA_DINAMICA, VALOR_COMPARACION_TD, PRODUCTO, VIGENCIA, FECHA_DESDE, EVENTO_APLICAR, FECHA_MOVIMIENTO, NUM_POLIZA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TOMADOR_NOMBRE, NUM_CREDITO, FECHA_PROCESO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, DEPARTAMENTO_ASEGURADO, CIUDAD_ASEGURADO FROM USO_TABLA_DINAMICA_IMPORTADA ORDER BY PRUEBA ASC",
                "USO_TABLA_DINAMICA_IMPORTADA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/usoTablasDinamicasImportadas_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, NOMBRE_TABLA_DINAMICA, RUTA_TABLA_DINAMICA, VALOR_COMPARACION_TD, PRODUCTO, VIGENCIA, FECHA_DESDE, EVENTO_APLICAR, FECHA_MOVIMIENTO, NUM_POLIZA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TOMADOR_NOMBRE, NUM_CREDITO, FECHA_PROCESO, DOC_ID_ASEGURADO, FECHA_NAC_ASEGURADO, DIRECCION_ASEGURADO, DEPARTAMENTO_ASEGURADO, CIUDAD_ASEGURADO FROM USO_TABLA_DINAMICA_IMPORTADA ORDER BY PRUEBA ASC",
                "USO_TABLA_DINAMICA_IMPORTADA",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/usoTablasDinamicasImportadas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/usoTablasDinamicasImportadas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/usoTablasDinamicasImportadas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
