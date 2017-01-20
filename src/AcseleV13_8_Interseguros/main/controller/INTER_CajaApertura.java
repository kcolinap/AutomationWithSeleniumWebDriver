package AcseleV13_8_Interseguros.main.controller;


import AcseleV13_8_Interseguros.beans.INTER_CajaAperturaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Caja.INTER_Caja;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by mchurion on 12/12/2016.
 */
public class INTER_CajaApertura {
    private final static Logger log = Logger.getLogger(INTER_CajaApertura.class);

    public String nombreAutomatizacion = "INTER Caja Apertura";

    public void testLink(INTER_CajaAperturaBean interCajaAperturaBean, int i, String folderName) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuOperaciones interMenuOperaciones = new Interseguros_MenuOperaciones();
            //Aperturar Caja
            INTER_Caja interCaja = new INTER_Caja();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);


            //Entrando en Menu
            interMenuOperaciones.UAA_Caja_AperturaCaja(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            interCaja.AperturaCaja(a, driver, interCajaAperturaBean, nombreAutomatizacion, i, folderName, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
