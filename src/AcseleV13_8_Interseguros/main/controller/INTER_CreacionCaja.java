package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CreacionCajaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Caja.INTER_CrearCaja;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by mchurion on 25/11/2016.
 */
public class INTER_CreacionCaja {


    private final static Logger log = Logger.getLogger(INTER_CreacionCaja.class);

    public String nombreAutomatizacion = "INTER Creacion de Caja";
    private WebDriver driver;

    public void testLink(INTER_CreacionCajaBean interCreacionCajaBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            //Crear Caja
            INTER_CrearCaja interCrearCaja = new INTER_CrearCaja();

            driver = a.entrarPagina(a.UrlInterseguros());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            interMenuMantenimiento.UAA_Caja(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la Caja */

            Thread.sleep(3000);
            interCrearCaja.CrearCaja(a, driver, interCreacionCajaBean, nombreAutomatizacion, i, folderName, 3, 4, 5);

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
