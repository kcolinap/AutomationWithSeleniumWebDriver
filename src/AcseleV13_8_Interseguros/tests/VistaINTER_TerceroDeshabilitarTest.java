package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_TerceroDeshabilitarBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TerceroDeshabilitar;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 08/02/2017.
 */
public class VistaINTER_TerceroDeshabilitarTest {

    private final static Logger log = Logger.getLogger(VistaINTER_TerceroDeshabilitarTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList interTerceroDeshabilitar = null;

        try {
            interTerceroDeshabilitar = INTER_TerceroDeshabilitarBean.getINTER_TerceroDeshabilitar();

        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< interTerceroDeshabilitar.size(); j++) {
            INTER_TerceroDeshabilitarBean inter_terceroDeshabilitarBean = (INTER_TerceroDeshabilitarBean) interTerceroDeshabilitar.get(j);
            INTER_TerceroDeshabilitar a = new INTER_TerceroDeshabilitar();
            Interseguros_Metodos intersegurosMetodos = new Interseguros_Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_terceroDeshabilitarBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,tipo_tercero, tipo_doc, doc_id,nombre, apellido, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, planes_Financiamiento, monedas, tipo_Documento, numero_Documento, moneda_DePrima, monto_Primera_Prima, fecha_Cotizacion, envio_Comunicaciones_Poliza, plan, contratante1_Nombre1, contratante1_Nombre2, contratante1_Apellido1,contratante1_Apellido2,porcentaje_Contratante1,porcentaje_Contratante2 FROM INTER_TERCERODESHABILITAR ORDER BY PRUEBA ASC",
                "INTER_TERCERODESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTerceroDeshabilitar_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,tipo_tercero, tipo_doc, doc_id,nombre, apellido, producto, vigencia, fecha_Desde, fecha_Hasta, evento_Aplicar, fecha_Movimiento, planes_Financiamiento, monedas, tipo_Documento, numero_Documento, moneda_DePrima, monto_Primera_Prima, fecha_Cotizacion, envio_Comunicaciones_Poliza, plan, contratante1_Nombre1, contratante1_Nombre2, contratante1_Apellido1,contratante1_Apellido2,porcentaje_Contratante1,porcentaje_Contratante2 FROM INTER_TERCERODESHABILITAR ORDER BY PRUEBA ASC",
                "INTER_TERCERODESHABILITAR",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTerceroDeshabilitar_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTerceroDeshabilitar_dataset.xml", DataSetManager.REFRESH_OPERATION);

    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTerceroDeshabilitar_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
