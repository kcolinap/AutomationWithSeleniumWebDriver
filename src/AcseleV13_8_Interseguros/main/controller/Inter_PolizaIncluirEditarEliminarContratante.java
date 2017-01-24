package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_PolizaIncluirEditarEliminarContratanteBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.Inter_Contratante;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.Inter_InformacionGeneralPoliza;
import AcseleV13_8_Interseguros.main.controller.PolizaEmision.Inter_PrePoliza;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by agil on 23/01/2017.
 */
public class Inter_PolizaIncluirEditarEliminarContratante {

    private final static Logger log = Logger.getLogger(Inter_PolizaIncluirEditarEliminarContratante.class);

    public String nombreAutomatizacion = "Inter Poliza Incluir Editar y Eliminar Contratante";
    private WebDriver driver;

    public void testLink(Inter_PolizaIncluirEditarEliminarContratanteBean interPolizaIncluirEditarEliminarContratanteBean, int i, String folderName){

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones intersegurosMenuOperaciones = new Interseguros_MenuOperaciones();
            Inter_PrePoliza interPrePoliza = new Inter_PrePoliza();
            Inter_InformacionGeneralPoliza interInformacionGeneralPoliza = new Inter_InformacionGeneralPoliza();
            Inter_Contratante interContratante = new Inter_Contratante();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            intersegurosMenuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Crear Poliza */

            Thread.sleep(3000);
            interPrePoliza.AdministracionPropuestaPoliza(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 3);
            Thread.sleep(2000);
            interPrePoliza.EvAplicar(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 4);
            Thread.sleep(2000);

            if (interPolizaIncluirEditarEliminarContratanteBean.getProducto().equals("DotalSimple")){
                interInformacionGeneralPoliza.InformacionGeneralDotalSimple(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 5, 6, 7);
                Thread.sleep(2000);
                interContratante.AgregarContratante(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 8, 9);
                Thread.sleep(2000);
                interContratante.EditarContratante(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 10, 11, 12);
                Thread.sleep(2000);
                interContratante.EliminarContratante(a, driver, interPolizaIncluirEditarEliminarContratanteBean, nombreAutomatizacion, i, folderName, 13, 14, 15);
            }

            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
