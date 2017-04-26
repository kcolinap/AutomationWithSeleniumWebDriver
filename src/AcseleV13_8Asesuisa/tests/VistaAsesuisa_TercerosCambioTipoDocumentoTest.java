package AcseleV13_8Asesuisa.tests;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosCambioTipoDocumentoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_TercerosCambioTipoDocumento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 20/04/2017.
 */
public class VistaAsesuisa_TercerosCambioTipoDocumentoTest {

    private final static Logger Log = Logger.getLogger(VistaAsesuisa_TercerosCambioTipoDocumentoTest.class);

    @Test
    public void mainTest() throws SQLException{
        ArrayList asesuisaCambioTipoDocumento = null;

        try{
            asesuisaCambioTipoDocumento = Asesuisa_TercerosCambioTipoDocumentoBean.getBean();
        }catch (SQLException e){
            Log.error(e);
        }

        for (int j=0; j<asesuisaCambioTipoDocumento.size(); j++){
            Asesuisa_TercerosCambioTipoDocumentoBean bean = (Asesuisa_TercerosCambioTipoDocumentoBean)asesuisaCambioTipoDocumento.get(j);
            Asesuisa_TercerosCambioTipoDocumento a = new Asesuisa_TercerosCambioTipoDocumento();
            Metodos asesuisaMetodos = new Metodos();
            String horaC = asesuisaMetodos.horaCarpeta();

            try{
                a.testLink(bean, j, horaC);
            }catch (Exception e){
                e.printStackTrace();
                Log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }
    }
    @Before
    public void setUp(String num) throws Exception {


       /* DataSetManager.createPartialDataSet("SELECT * FROM Asesuisa_terc_CambioTipoDoc ORDER BY PRUEBA ASC",
                "Asesuisa_terc_CambioTipoDoc",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCambiotipoDoc_dataset" + num + ".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM Asesuisa_terc_CambioTipoDoc ORDER BY PRUEBA ASC",
                "Asesuisa_terc_CambioTipoDoc",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCambiotipoDoc_dataset" + num + ".xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCambiotipoDoc_dataset" + num + ".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaTercerosCambiotipoDoc_dataset" + num + ".xml", DataSetManager.DELETE_OPERATION);
    }
}
