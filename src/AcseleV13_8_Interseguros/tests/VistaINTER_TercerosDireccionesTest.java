package AcseleV13_8_Interseguros.tests;


import AcseleV13_8_Interseguros.beans.INTER_TercerosDireccionesBean;
import AcseleV13_8_Interseguros.main.controller.INTER_TercerosDirecciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by mchurion on 22/12/2016.
 */
public class VistaINTER_TercerosDireccionesTest {
    private final static Logger log = Logger.getLogger(VistaINTER_TercerosDireccionesTest.class);

    @Test
    public void mainTest() {

        ArrayList dirTerceros = null;

        try {
            dirTerceros = INTER_TercerosDireccionesBean.getTercerodDirecciones();
        }catch (SQLException e) {
            log.error(e);
        }

        for (int i = 0; i < dirTerceros.size(); i++) {

            INTER_TercerosDireccionesBean intertercerosDireccionesBean = (INTER_TercerosDireccionesBean) dirTerceros.get(i);
            INTER_TercerosDirecciones a = new INTER_TercerosDirecciones();
            Metodos intersegurosMetodos = new Metodos();
            String horaC = intersegurosMetodos.horaCarpeta();

            try {
                a.testLink(intertercerosDireccionesBean, i, horaC);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

/*
        DataSetManager.createPartialDataSet("SELECT PRUEBA,TIPO_TERCEROS,NUM_DOC_IDENTIDAD,APELLIDO_PATERNO,PRIMER_NOMBRE,REF_DIRECCION,COD_PAIS,DESCRIPCION_DIRECCION,COD_DEPARTAMENTO,COD_PROVINCIA,NUM_FAX,COD_DISTRITO,TIPO_DIRECCION,TLF_FIJO,USER_LOGIN,TLF_CELULAR,EMAIL FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml");

        DataSetManager.createPartialDataSet("SELECT PRUEBA,TIPO_TERCEROS,NUM_DOC_IDENTIDAD,APELLIDO_PATERNO,PRIMER_NOMBRE,REF_DIRECCION,COD_PAIS,DESCRIPCION_DIRECCION,COD_DEPARTAMENTO,COD_PROVINCIA,NUM_FAX,COD_DISTRITO,TIPO_DIRECCION,TLF_FIJO,USER_LOGIN,TLF_CELULAR,EMAIL FROM TERCEROS_DIRECCIONES_INTER ORDER BY PRUEBA ASC",
                "TERCEROS_DIRECCIONES_INTER",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8_Interseguros/tests/xmls/interTercerosDirecciones_dataset.xml", DataSetManager.DELETE_OPERATION);
    }
}
