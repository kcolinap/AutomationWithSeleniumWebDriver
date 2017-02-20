package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_TercerosCrearBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_CrearTercero;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 17/11/2016.
 */
public class Inter_TercerosCrear {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrear.class);

    public String nombreAutomatizacion = "Inter Terceros Crear";
    private WebDriver driver;

    public void testLink(Inter_TercerosCrearBean interTercerosCrearBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento intersegurosMenuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_CrearTercero interCrearTercero = new Inter_CrearTercero();


            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            intersegurosMenuMantenimiento.MantTerc_IngresarTercero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Ingresar Tercero */

            Thread.sleep(3000);
            interCrearTercero.CrearTerceroNatural(a, driver, interTercerosCrearBean, nombreAutomatizacion, i, folderName, 3, 4, 5, 6);

            Thread.sleep(2000);
            interCrearTercero.ValidarCreacionTercero(driver, nombreAutomatizacion);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }
}
