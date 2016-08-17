package AcseleV13_8.tests;

import AcseleV13_8.beans.EditarSiniestrosBean;
import AcseleV13_8.main.controller.EditarSiniestros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by aazuaje on 15/08/2016.
 */
public class VistaEditarSiniestrosTest {

    private final static Logger log = Logger.getLogger(VistaEditarSiniestrosTest.class);

    @Test
    public void mainTest() {

        ArrayList edicion = null;
        try{
            edicion = EditarSiniestrosBean.getEditarSiniestros();
        } catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < edicion.size(); i++) {
            EditarSiniestrosBean editarSiniestrosBean = (EditarSiniestrosBean) edicion.get(i);
            EditarSiniestros a = new EditarSiniestros();

            try {
                a.testLink(editarSiniestrosBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }


    @Before
    public void setUp() throws Exception {


        /*DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro, Fecha_Compromiso, Fecha_Inicial, Fecha_Final, Razon,  Estado, Tipo, Monto_Siniestro from EDITAR_SINIESTRO ORDER BY PRUEBA ASC",
                "EDITAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/editar_siniestro_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Ordenar_Por,Num_Siniestro,Num_Poliza,Fecha_Ocurrencia_Siniestro,Producto, Hora_Ocurrencia, Fecha_Aviso_Compania, Hora_Notificacion, Fecha_Oper_Const_Siniestro, Fecha_Recl_Formalizacion, Fecha_Interrupcion_Terminos, Documento_Ident_Reclamante, Reclamante, Causa_General_Muerte, Causales_Especif_Cobert_Muerte, Departamento, Ciudad, Genero_Asegurado, Profesion_Asegurado, Actividad_Siniestro, Fecha_Actividad, Observaciones_Siniestro, Certificado, Objetos_Asegurados, Cobertura_Afectada, Pago_Maximo, Moneda_Siniestro, Fecha_Compromiso, Fecha_Inicial, Fecha_Final, Razon,  Estado, Tipo, Monto_Siniestro from EDITAR_SINIESTRO ORDER BY PRUEBA ASC",
                "EDITAR_SINIESTRO",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/editar_siniestro_dataset.xml");

*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/editar_siniestro_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/editar_siniestro_dataset.xml", DataSetManager.DELETE_OPERATION);
    }















}
