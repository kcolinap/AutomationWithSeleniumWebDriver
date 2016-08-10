package AcseleV13_8_Alfa.tests;

import AcseleV13_8.beans.ObjetarCoberturaBean;
import AcseleV13_8.main.controller.ObjetarCobertura;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 27/07/2016.
 */

public class VistaObjetarCoberturaTest {

    private final static Logger log = Logger.getLogger(VistaObjetarCoberturaTest.class);

    @Test
    public void mainTest() {

        ArrayList cobertura = null;
        try{
            cobertura = ObjetarCoberturaBean.getObjetarCobertura();
        } catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < cobertura.size(); i++) {
            ObjetarCoberturaBean objetarCoberturaBean = (ObjetarCoberturaBean) cobertura.get(i);
            ObjetarCobertura a = new ObjetarCobertura();

            try {
                a.testLink(objetarCoberturaBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }



    @Before
    public void setUp() throws Exception {


        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por, Producto, Estados_Ciclo_Vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Fecha_Ocurrencia_Siniestro,Sucursal_Siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro,Motivos_Objecion, Fecha_Objecion, Comentarios_Siniestro from CREAC_SINI_OBJET_COB ORDER BY PRUEBA ASC",
                "CREAC_SINI_OBJET_COB",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8.AcseleV13_8_Alfa.tests.xmls/creacionSiniestrosObjetarCobertura_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por, Producto, Estados_Ciclo_Vida, Contratante, Asegurado, ID_Poliza, Fecha_Desde, Fecha_Hasta, Sucursal_Poliza, Numero_Poliza, Fecha_Emision, Moneda_Poliza, Tipo_Moneda_Poliza, Tipo_Produccion, Tipo_Vigencia, Vigencia, Canal_Venta, Frecuencia_Pago, Fecha_Evento_Anterior, Fecha_Proxima_Generacion_Prima, Fecha_Proxima_Facturacion, Tipo_Poliza, Numero_Cotizacion, Numero_Propuesta, Fecha_Ocurrencia_Siniestro,Sucursal_Siniestros, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro,Motivos_Objecion, Fecha_Objecion, Comentarios_Siniestro from CREAC_SINI_OBJET_COB ORDER BY PRUEBA ASC",
                "CREAC_SINI_OBJET_COB",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8.AcseleV13_8_Alfa.tests.xmls/creacionSiniestrosObjetarCobertura_dataset.xml");
*/

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/creacionSiniestrosObjetarCobertura_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/creacionSiniestrosObjetarCobertura_dataset.xml", DataSetManager.DELETE_OPERATION);
    }


}

