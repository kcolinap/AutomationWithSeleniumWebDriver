package AcseleV13_8Asesuisa.tests;


import  AcseleV13_8Asesuisa.main.controller.Asesuisa_PolizaEmisionGeneral30282;
import AcseleV13_8Asesuisa.beans.Asesuisa_PolizaEmisionGeneral30282Bean;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by kcolina on 03/04/2017.
 */
public class VistaAsesuisa_PolizaEmisionGeneral30282Test {

    private final static Logger log = Logger.getLogger(VistaAsesuisa_PolizaEmisionGeneral30282Test.class);

    @org.junit.Test
    public void mainTest() throws SQLException {

        ArrayList poliza = null;

        try {
            poliza = Asesuisa_PolizaEmisionGeneral30282Bean.getAsesuisaPolizaEmisionGeneral30282();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j < poliza.size(); j++) {
            Asesuisa_PolizaEmisionGeneral30282Bean bean = (Asesuisa_PolizaEmisionGeneral30282Bean) poliza.get(j);
            Asesuisa_PolizaEmisionGeneral30282 a = new Asesuisa_PolizaEmisionGeneral30282();
            Metodos metodos = new Metodos();
            String horaC = metodos.horaCarpeta();

            try {
                a.testLink(bean, j, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp(String num) throws Exception {

       /* DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLIZAEMISION_30282 ORDER BY PRUEBA ASC",
                "ASE_POLIZAEMISION_30282",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPolizaEmisionGeneral30282_dataset"+num+".xml");

        DataSetManager.createPartialDataSet("SELECT * FROM ASE_POLIZAEMISION_30282 ORDER BY PRUEBA ASC",
                "ASE_POLIZAEMISION_30282",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8Asesuisa/tests/xmls/asesuisaPolizaEmisionGeneral30282_dataset"+num+".xml");
       */
        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPolizaEmisionGeneral30282_dataset" + num +".xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown(String num) throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8Asesuisa/tests/xmls/asesuisaPolizaEmisionGeneral30282_dataset" + num +".xml", DataSetManager.DELETE_OPERATION);
    }
}
