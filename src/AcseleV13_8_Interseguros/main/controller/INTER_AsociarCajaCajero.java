package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_AsociarCajaCajeroBean;
import AcseleV13_8_Interseguros.beans.INTER_CajaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Caja.INTER_AsociarCajaConCajero;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by mchurion on 07/12/2016.
 */
public class INTER_AsociarCajaCajero extends INTER_CajaBean implements Serializable {
    private final static Logger log = Logger.getLogger(INTER_CreacionCaja.class);

    public String nombreAutomatizacion = "INTER Asociar Caja a Cajero";
    private WebDriver driver;

    public void testLink(INTER_AsociarCajaCajeroBean interAsociarCajaCajeroBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            //Crear Caja
            INTER_AsociarCajaConCajero interAsociarCajaConCajero = new INTER_AsociarCajaConCajero();

            driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            interMenuMantenimiento.UAA_AsociarCajaCajero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            interAsociarCajaConCajero.AsociarCajaConCajero(a, driver, interAsociarCajaCajeroBean, nombreAutomatizacion, i, folderName, 3, 4, 5, 6);

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
