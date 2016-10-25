package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_AsociarCajaCajeroBean;
import AcseleV13_8LBC.main.controller.LBC_Caja.LBC_AsociarCajaConCajero;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 19/10/2016.
 */
public class LBC_AsociarCajaCajero {

    private final static Logger log = Logger.getLogger(LBC_CreacionCaja.class);

    public String nombreAutomatizacion = "LBC Asociar Caja a Cajero";

    public void testLink(LBC_AsociarCajaCajeroBean lbcAsociarCajaCajeroBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento lbcMenuMantenimiento = new LBC_MenuMantenimiento();
            //Crear Caja
            LBC_AsociarCajaConCajero lbcAsociarCajaConCajero = new LBC_AsociarCajaConCajero();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            lbcMenuMantenimiento.UAA_AsociarCajaCajero(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            lbcAsociarCajaConCajero.AsociarCajaConCajero(a, driver, lbcAsociarCajaCajeroBean, nombreAutomatizacion, i, 3, 4 ,5, 6);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
