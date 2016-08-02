package tests;

import beans.EmisionPolizaBeneficiarioNaturalBean;
import main.controller.EmisionPolizaBeneficiarioNatural;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by agil on 02/08/2016.
 */
public class VistaEmisionPolizaBeneficiarioNaturalTest {

    private final static Logger log = Logger.getLogger(VistaEmisionPolizaInclusionTomadoresTest.class);

    @Test
    public void mainTest(){

        ArrayList emision = EmisionPolizaBeneficiarioNaturalBean.getEmisionPolizaBeneficiarioNatural();

        for (int i = 0; i < emision.size(); i++){
            EmisionPolizaBeneficiarioNaturalBean emisionPolizaInclusionBeneficiarioNaturalBean = (EmisionPolizaBeneficiarioNaturalBean) emision.get(i);
            EmisionPolizaBeneficiarioNatural a = new EmisionPolizaBeneficiarioNatural();

            try {
                a.testLink(emisionPolizaInclusionBeneficiarioNaturalBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case 25 - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }

    @Before
    public void setUp() throws Exception {

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO_T, TIPO_DOC_IDENTIDAD_T, CEDULA_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, TIPO_TERCERO_ASEG_VIDA_1, TIPO_DOC_IDENTIDAD_ASEG_VIDA_1, CEDULA_ASEG_VIDA_1, NOMBRE_ASEG_VIDA_1, APELLIDO_ASEG_VIDA_1, PORCENTAJE_ASEG_VIDA_1, TIPO_TERCERO_ASEG_VIDA_2, TIPO_DOC_IDENTIDAD_ASEG_VIDA_2, CEDULA_ASEG_VIDA_2, NOMBRE_ASEG_VIDA_2, APELLIDO_ASEG_VIDA_2, PORCENTAJE_ASEG_VIDA_2, NUEVO_PORCENTAJE_ASEG_VIDA_1 FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC",
                "POLIZA_BENEFICIARIO_NATURAL",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/emisionPolizaBeneficiarioNatural_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, PRODUCTO, VIGENCIA, FECHA_DESDE, FECHA_HASTA, EVENTO_APLICAR, SUCURSAL, TIPO_PRODUCCION, PERIODO_GRACIA, LINEA_CREDITO, UNIDAD_NEGOCIO, CANAL_VENTA, TIPO_VALOR_ASEGURADO, TASA, TIPO_TASA, TIPO_TERCERO_T, TIPO_DOC_IDENTIDAD_T, CEDULA_T, NOMBRE_T, APELLIDO_T, PORCENTAJE_TOMADOR, NUM_UNIDAD_RIESGO, NUM_CREDITO, MONTO_ASEGURADO, TIPO_TERCERO_ASEG_VIDA_1, TIPO_DOC_IDENTIDAD_ASEG_VIDA_1, CEDULA_ASEG_VIDA_1, NOMBRE_ASEG_VIDA_1, APELLIDO_ASEG_VIDA_1, PORCENTAJE_ASEG_VIDA_1, TIPO_TERCERO_ASEG_VIDA_2, TIPO_DOC_IDENTIDAD_ASEG_VIDA_2, CEDULA_ASEG_VIDA_2, NOMBRE_ASEG_VIDA_2, APELLIDO_ASEG_VIDA_2, PORCENTAJE_ASEG_VIDA_2, NUEVO_PORCENTAJE_ASEG_VIDA_1 FROM POLIZA_BENEFICIARIO_NATURAL ORDER BY PRUEBA ASC",
                "POLIZA_BENEFICIARIO_NATURAL",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/emisionPolizaBeneficiarioNatural_dataset.xml");

        DataSetManager.loadDataSet("/tests/emisionPolizaBeneficiarioNatural_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception{
        DataSetManager.loadDataSet("/tests/emisionPolizaBeneficiarioNatural_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
