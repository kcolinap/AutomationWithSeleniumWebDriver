package AcseleV13_8_Rimac.main.controller;

import AcseleV13_8_Rimac.beans.Rimac_ImportProductoBean;
import AcseleV13_8_Rimac.main.controller.Rimac_Menu.Rimac_MenuConfiguracion;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 20/03/2017.
 */
public class Rimac_ImportProducto {

    private final static Logger log = Logger.getLogger(Rimac_ImportProducto.class);

    public String nombreAutomatizacion = "Rimac Import Producto";
    private WebDriver driver;

    public void testLink(Rimac_ImportProductoBean bean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Rimac_MenuConfiguracion menuConfiguracion = new Rimac_MenuConfiguracion();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            menuConfiguracion.NuevoMantenimientoProducto(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Importar el producto */

            Thread.sleep(3000);
            //interAsociarCajaConCajero.AsociarCajaConCajero(a, driver, interAsociarCajaCajeroBean, nombreAutomatizacion, i, folderName, 3, 4, 5, 6);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }


    }
}
