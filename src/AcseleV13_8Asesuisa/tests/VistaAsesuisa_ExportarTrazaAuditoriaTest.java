package AcseleV13_8Asesuisa.tests;
import AcseleV13_8Asesuisa.beans.Asesuisa_ExportarTrazaAuditoriaBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_ExportarTrazaAuditoria;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by cortiz on 29/03/2017.
 */
public class VistaAsesuisa_ExportarTrazaAuditoriaTest {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_ExportarTrazaAuditoriaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList ExportarTrazaAuditoria = Asesuisa_ExportarTrazaAuditoriaBean.getExportarTrazaAuditoria();

        for (int i = 0; i < ExportarTrazaAuditoria.size(); i++) {
            Asesuisa_ExportarTrazaAuditoriaBean exportarTrazaAuditoriaBean = (Asesuisa_ExportarTrazaAuditoriaBean) ExportarTrazaAuditoria.get(i);
            Asesuisa_ExportarTrazaAuditoria a = new Asesuisa_ExportarTrazaAuditoria();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
             a.testLink(exportarTrazaAuditoriaBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }

        }

    }

    @Before
    public void setUp(String num) throws Exception {

  /*     DataSetManager.createPartialDataSet("SELECT * FROM EXPORT_DOCUMENTOS_TRAZA ORDER BY PRUEBA ASC",
                "EXPORT_DOCUMENTOS_TRAZA ",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaExportarTrazaAuditoria_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM EXPORT_DOCUMENTOS_TRAZA ORDER BY PRUEBA ASC",
                "EXPORT_DOCUMENTOS_TRAZA",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaExportarTrazaAuditoria_dataset"+num+".xml");*/

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaExportarTrazaAuditoria_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaExportarTrazaAuditoria_dataset"+ num + ".xml", DataSetManager.DELETE_OPERATION);
    }

}
