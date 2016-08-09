package tests;

import beans.CreacionSiniestrosBean;
import main.controller.CreacionSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;

/**
 * Created by aazuaje on 27/07/2016.
 */
public class VistaCreacionSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaCreacionSiniestrosTest.class);

    @Test
    public void mainTest() {

        ArrayList siniestro = CreacionSiniestrosBean.getCreacionSiniestros();

        for (int i = 0; i < siniestro.size(); i++) {
            CreacionSiniestrosBean creacionSiniestrosBean = (CreacionSiniestrosBean) siniestro.get(i);
            CreacionSiniestros a = new CreacionSiniestros();

            try {
                a.testLink(creacionSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet(" select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza,Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos,Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Fecha_Compromiso, Fecha_inicial, Fecha_Final, Razon, Estado, Tipo, Monto_Siniestro from CREACION_SINIESTROS ORDER BY PRUEBA ASC",
                "CREACION_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/creacionSiniestros_dataset.xml");

        DataSetManager.createPartialDataSet(" select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza,Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos,Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Fecha_Compromiso, Fecha_inicial, Fecha_Final, Razon, Estado, Tipo, Monto_Siniestro from CREACION_SINIESTROS ORDER BY PRUEBA ASC",
                "CREACION_SINIESTROS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/creacionSiniestros_dataset.xml");*/

        DataSetManager.loadDataSet("/tests/creacionSiniestros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/creacionSiniestros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
