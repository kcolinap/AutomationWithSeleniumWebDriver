package AcseleV13_8.tests;

import AcseleV13_8.beans.EmisionProductoImportadoBean;
import AcseleV13_8.main.controller.EmisionProductoImportado;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 28/09/2016.
 */
public class VistaEmisionProductoImportadoTest {
    private final static Logger log = Logger.getLogger(VistaEmisionProductoImportadoTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList emisionProdImport = EmisionProductoImportadoBean.getEmisionProductoImportado();

        for (int j = 0; j< emisionProdImport.size(); j++) {
            EmisionProductoImportadoBean emisionProductoImportadoBean = (EmisionProductoImportadoBean) emisionProdImport.get(j);
            EmisionProductoImportado a = new EmisionProductoImportado();

            try {
                a.testLink(emisionProductoImportadoBean, j);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select PRUEBA,PRODUCTO,VIGENCIA,FECHA_DESDE,FECHA_HASTA,EVENTO_APLICAR,FECHA_MOVIMIENTO,SUCURSAL,NUMERO_POLIZA,TIPO_PRODUCCION,PERIODO_GRACIA,LINEA_CREDITO,HORA_INICIACION_VENCIMIENTO,UNIDAD_NEGOCIO,CANAL_VENTA,TIPO_VALOR_ASEGURADO,TOMADOR_NOMBRE1,TOMADOR_NOMBRE2,TOMADOR_APELLIDO1,TOMADOR_APELLIDO2,NUMERO_CREDITO,MONTO_ASEGURADO,FACTOR_VIDA,VALOR_SEGURO_PRIMA,FECHA_DESEMBOLSO,VALOR_PRESTAMO,FECHA_PROCESO,DOCUMENTO_IDENTIDAD_ASEGURADO,FECHA_NACIMIENTO_ASEGURADO,DIRECCION_ASEGURADO,TELEFONO_FIJO,DEPARTAMENTO,CIUDAD,ASEGURADO_VIDA_NOMBRE1,ASEGURADO_VIDA_NOMBRE2,ASEGURADO_VIDA_APELLIDO1,ASEGURADO_VIDA_APELLIDO2   from EMISION_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC",
                "EMISION_PRODUCTO_IMPORTADO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/emisionProductoImportado_dataset.xml");

        DataSetManager.createPartialDataSet("select PRUEBA,PRODUCTO,VIGENCIA,FECHA_DESDE,FECHA_HASTA,EVENTO_APLICAR,FECHA_MOVIMIENTO,SUCURSAL,NUMERO_POLIZA,TIPO_PRODUCCION,PERIODO_GRACIA,LINEA_CREDITO,HORA_INICIACION_VENCIMIENTO,UNIDAD_NEGOCIO,CANAL_VENTA,TIPO_VALOR_ASEGURADO,TOMADOR_NOMBRE1,TOMADOR_NOMBRE2,TOMADOR_APELLIDO1,TOMADOR_APELLIDO2,NUMERO_CREDITO,MONTO_ASEGURADO,FACTOR_VIDA,VALOR_SEGURO_PRIMA,FECHA_DESEMBOLSO,VALOR_PRESTAMO,FECHA_PROCESO,DOCUMENTO_IDENTIDAD_ASEGURADO,FECHA_NACIMIENTO_ASEGURADO,DIRECCION_ASEGURADO,TELEFONO_FIJO,DEPARTAMENTO,CIUDAD,ASEGURADO_VIDA_NOMBRE1,ASEGURADO_VIDA_NOMBRE2,ASEGURADO_VIDA_APELLIDO1,ASEGURADO_VIDA_APELLIDO2   from EMISION_PRODUCTO_IMPORTADO ORDER BY PRUEBA ASC",
                "EMISION_PRODUCTO_IMPORTADO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/emisionProductoImportado_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionProductoImportado_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/emisionProductoImportado_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
