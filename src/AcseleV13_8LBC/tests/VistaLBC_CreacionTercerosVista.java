package AcseleV13_8LBC.tests;

import AcseleV13_8LBC.beans.LBC_CreacionTercerosBean;
import AcseleV13_8LBC.main.controller.LBC_CreacionTerceros;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by agil on 13/10/2016.
 */
public class VistaLBC_CreacionTercerosVista {

    private final static Logger log = Logger.getLogger(VistaConsultaSimplePolizaTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList tercero = null;

        try {
            tercero = LBC_CreacionTercerosBean.getLBC_CreacionTercerosBean();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int j = 0; j< tercero.size(); j++) {
            LBC_CreacionTercerosBean lbc_creacionTercerosBean = (LBC_CreacionTercerosBean) tercero.get(j);
            LBC_CreacionTerceros a = new LBC_CreacionTerceros();

            try {
                a.testLink(lbc_creacionTercerosBean, j);
            } catch (Exception e) {
                e.printStackTrace();
                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*        DataSetManager.createPartialDataSet("SELECT PRUEBA, Tipo_Terceros, Apellido_Paterno, Apellido_Materno, Primer_Nombre, Segundo_Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion, Sexo, Estado_Civil, Factura_CI_NIT, Nacionalidad, Fecha_Nacimiento, Categ_Activ_Eco_Ocu_Ppal, Activ_Eco_Ocu_Ppal, Tipo_Trabajador, Telefono_Fijo_1 FROM CREACION_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CREACION_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8LBC/tests/xmls/lbcCreacionTerceros_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA, Tipo_Terceros, Apellido_Paterno, Apellido_Materno, Primer_Nombre, Segundo_Nombre, Tipo_Doc_Identificacion, Num_Doc_Identificacion, Sexo, Estado_Civil, Factura_CI_NIT, Nacionalidad, Fecha_Nacimiento, Categ_Activ_Eco_Ocu_Ppal, Activ_Eco_Ocu_Ppal, Tipo_Trabajador, Telefono_Fijo_1 FROM CREACION_TERCEROS_LBC ORDER BY PRUEBA ASC",
                "CREACION_TERCEROS_LBC",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8LBC/tests/xmls/lbcCreacionTerceros_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCreacionTerceros_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8LBC/tests/xmls/lbcCreacionTerceros_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
