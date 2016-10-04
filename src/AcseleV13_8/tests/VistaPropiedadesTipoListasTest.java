package AcseleV13_8.tests;

import AcseleV13_8.beans.PropiedadesTipoListasBean;
import AcseleV13_8.main.controller.PropiedadesTipoListas;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.DataSetManager;

import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Created by aazuaje on 22/08/2016.
 */
public class VistaPropiedadesTipoListasTest {

    private final static Logger log = Logger.getLogger(VistaPropiedadesTipoListasTest.class);

    @Test
    public void mainTest() throws SQLException {

        ArrayList propiedadesListas = PropiedadesTipoListasBean.getPropiedadesTipoListas();

        for (int i = 0; i < propiedadesListas.size(); i++) {
            PropiedadesTipoListasBean propiedadesTipoListasBean = (PropiedadesTipoListasBean) propiedadesListas.get(i);
            PropiedadesTipoListas a = new PropiedadesTipoListas();

            try {
                a.testLink(propiedadesTipoListasBean, i);
            } catch (Exception e) {
                e.printStackTrace();
//                log.info(e);
                log.info("Test Case - " + a.nombreAutomatizacion + " - " + e);
            }
        }

    }

    @Before
    public void setUp() throws Exception {

        /*DataSetManager.createPartialDataSet("select Prueba,Nombre_Propiedad,Tipo_Visualizacion,Etiqueta ,Descripcion, Regla ,Validador ,Funcion_Transformadora ,Funcion_Presentadora ,Etiqueta1 ,Mascara ,Funcion_Validadora, Propiedad_Padre ,Valor_Defecto ,Minimo_Valor ,Maximo_Valor ,Num_decimal ,Tipo_Precision ,Unico, Buscar  from PROPIEDADES_TIPO_LISTAS ORDER BY PRUEBA ASC",
                "PROPIEDADES_TIPO_LISTAS",
                "C:/AcseleTests/AutomationTestAcsele/src/AcseleV13_8/tests/xmls/propiedadesTipoListas_dataset.xml");

        DataSetManager.createPartialDataSet("select Prueba,Nombre_Propiedad,Tipo_Visualizacion,Etiqueta ,Descripcion, Regla ,Validador ,Funcion_Transformadora ,Funcion_Presentadora ,Etiqueta1 ,Mascara ,Funcion_Validadora, Propiedad_Padre ,Valor_Defecto ,Minimo_Valor ,Maximo_Valor ,Num_decimal ,Tipo_Precision ,Unico, Buscar  from PROPIEDADES_TIPO_LISTAS ORDER BY PRUEBA ASC",
                "PROPIEDADES_TIPO_LISTAS",
                "C:/AcseleTests/AutomationTestAcsele/target/classes/AcseleV13_8/tests/xmls/propiedadesTipoListas_dataset.xml");
*/
        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/propiedadesTipoListas_dataset.xml", DataSetManager.REFRESH_OPERATION);
    }

    @After
    public void tearDown() throws Exception {

        DataSetManager.loadDataSet("/AcseleV13_8/tests/xmls/propiedadesTipoListas_dataset.xml", DataSetManager.DELETE_OPERATION);
    }

}
