package AcseleV13_8_Interseguros.tests;

import AcseleV13_8_Interseguros.beans.INTER_ConsultaAvanzadaPolizaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_ConsultaAvanzadaPoliza;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by mchurion on 15/11/2016.
 */
public class VistaINTER_ConsultaAvanzadaPolizaTest {

    private final static Logger log = Logger.getLogger(VistaINTER_ConsultaAvanzadaPolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList consultaAvanzada = null;

        try {
            consultaAvanzada = INTER_ConsultaAvanzadaPolizaBean.getConsultaAvanzadaPolizaBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< consultaAvanzada.size(); j++) {
            INTER_ConsultaAvanzadaPolizaBean inter_ConsultaAvanzadaPolizaBean = (INTER_ConsultaAvanzadaPolizaBean) consultaAvanzada.get(j);
            INTER_ConsultaAvanzadaPoliza a = new INTER_ConsultaAvanzadaPoliza();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(inter_ConsultaAvanzadaPolizaBean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDENAR_POR,BUSCAR_POR,CON_PRIMA_DEPOSITO,PRODUCTO,EDO_CICLO_VIDA,MOTIVO_EDO_CICLO_VIDA,OFICINA,NUM_PROPUESTA,FECHA_EMISION,FRECUENCIA_PAGO,FECHA_GENERACION_PRIMA,FLAG_SUSP_CANCEL,NOMBRE_ARCHIVO_TRAMAS,PERIODO_SUSPENSION_CANCEL,PROCEDE_SUSPENSION_CANCEL,FECHA_EMISION_ACSELE,NUM_COTIZACION,NUM_POLIZA,CANAL_VENTA,FECHA_EVENTO_ANTERIOR,FECHA_PROXIMA_FACTURACION,FECHA_SUSPENSION_CANCEL,NUM_PLAN,FECHA_INICIO_SUSPEN_CANCEL,MONTO_PRIMA_ENV_ARCH_TRAMA,INFO_PARTICIPACION,VIA,SUBVIA,MODO_PAGO,INFO_TERCEROS,TIPO_TERCEROS,PARTICIPACION,ACTIVIDAD_ECONOMICA,EMAIL_2,TWITTER_ID,YAHOO_ID,ID_ORIGEN_TERCERO,USER_LOGIN,CODIGO_INTERNO,EMAIL_1,EMAIL_3,FACEBOOK_ID,SKYPE_ID,CÓDIGO_IDENTIFICADOR,ROL,INFO_UR,NUM_UR,INFO_OA,TIPO_OBJETO_ASEGURADO,NUM_OBJETO_ASEGURADO,NOMBRE_BENEFICIARIO,NOMBRE_ASEGURADO FROM CONSULTA_POLIZA_AVANZADA_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_AVANZADA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interconsultaAvanzadaPoliza_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,ORDENAR_POR,BUSCAR_POR,CON_PRIMA_DEPOSITO,PRODUCTO,EDO_CICLO_VIDA,MOTIVO_EDO_CICLO_VIDA,OFICINA,NUM_PROPUESTA,FECHA_EMISION,FRECUENCIA_PAGO,FECHA_GENERACION_PRIMA,FLAG_SUSP_CANCEL,NOMBRE_ARCHIVO_TRAMAS,PERIODO_SUSPENSION_CANCEL,PROCEDE_SUSPENSION_CANCEL,FECHA_EMISION_ACSELE,NUM_COTIZACION,NUM_POLIZA,CANAL_VENTA,FECHA_EVENTO_ANTERIOR,FECHA_PROXIMA_FACTURACION,FECHA_SUSPENSION_CANCEL,NUM_PLAN,FECHA_INICIO_SUSPEN_CANCEL,MONTO_PRIMA_ENV_ARCH_TRAMA,INFO_PARTICIPACION,VIA,SUBVIA,MODO_PAGO,INFO_TERCEROS,TIPO_TERCEROS,PARTICIPACION,ACTIVIDAD_ECONOMICA,EMAIL_2,TWITTER_ID,YAHOO_ID,ID_ORIGEN_TERCERO,USER_LOGIN,CODIGO_INTERNO,EMAIL_1,EMAIL_3,FACEBOOK_ID,SKYPE_ID,CÓDIGO_IDENTIFICADOR,ROL,INFO_UR,NUM_UR,INFO_OA,TIPO_OBJETO_ASEGURADO,NUM_OBJETO_ASEGURADO,NOMBRE_BENEFICIARIO,NOMBRE_ASEGURADO FROM CONSULTA_POLIZA_AVANZADA_INTER ORDER BY PRUEBA ASC",
                "CONSULTA_POLIZA_AVANZADA_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interconsultaAvanzadaPoliza_dataset.xml");*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interconsultaAvanzadaPoliza_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interconsultaAvanzadaPoliza_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
