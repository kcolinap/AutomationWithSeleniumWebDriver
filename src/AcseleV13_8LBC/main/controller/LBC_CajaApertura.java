package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CajaAperturaBean;
import AcseleV13_8LBC.main.controller.LBC_Caja.LBC_Caja;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 20/10/2016.
 */
public class LBC_CajaApertura {

    private final static Logger log = Logger.getLogger(LBC_CajaApertura.class);

    public String nombreAutomatizacion = "LBC Caja Apertura";

    public void testLink(LBC_CajaAperturaBean lbcCajaAperturaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuOperaciones lbcMenuOperaciones = new LBC_MenuOperaciones();
            //Aperturar Caja
            LBC_Caja lbcCaja = new LBC_Caja();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            lbcMenuOperaciones.UAA_Caja_AperturaCaja(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            lbcCaja.AperturaCaja(a, driver, lbcCajaAperturaBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
