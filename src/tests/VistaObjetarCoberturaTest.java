package tests;

import beans.ObjetarCoberturaBean;
import main.controller.ObjetarCobertura;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.util.ArrayList;
/**
 * Created by aazuaje on 03/08/2016.
 */
public class VistaObjetarCoberturaTest {

    private final static Logger log = Logger.getLogger(VistaObjetarCoberturaTest.class);

    @Test
    public void mainTest() {

        ArrayList cobertura = ObjetarCoberturaBean.getObjetarCobertura();

        for (int i = 0; i < cobertura.size(); i++) {
            ObjetarCoberturaBean objetarCoberturaBean = (ObjetarCoberturaBean) cobertura.get(i);
            ObjetarCobertura a = new ObjetarCobertura();

            try {
                //a.testLink(objetarCoberturaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Tipo_Moneda, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Reclamante, Causa_Muerte, Causales_cobertura_Muerte, Departamento, Ciudad, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Motivos_Objecion, Fecha_Objecion, Comentarios_Siniestro from CREAC_SINI_OBJET_COB ORDER BY PRUEBA ASC",
                "CREAC_SINI_OBJET_COB",
                "C:/AcseleTests/AutomationTestAcsele/src/tests/creacionSiniestrosObjetarCobertura_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba, Ordenar_Por, Producto, Estados_ciclo_vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Tipo_Moneda, fecha_ocurrencia_siniestro, Sucursal_siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Reclamante, Causa_Muerte, Causales_cobertura_Muerte, Departamento, Ciudad, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_siniestro, Motivos_Objecion, Fecha_Objecion, Comentarios_Siniestro from CREAC_SINI_OBJET_COB ORDER BY PRUEBA ASC",
                "CREAC_SINI_OBJET_COB",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/tests/creacionSiniestrosObjetarCobertura_dataset.xml");
*/
        DataSetManager.loadDataSet("/tests/creacionSiniestrosObjetarCobertura_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/tests/creacionSiniestrosObjetarCobertura_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}
