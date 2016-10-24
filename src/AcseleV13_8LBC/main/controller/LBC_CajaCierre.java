package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CajaCierreBean;
import AcseleV13_8LBC.main.controller.LBC_Caja.LBC_Caja;
import AcseleV13_8LBC.main.controller.Menu.LBC_MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 20/10/2016.
 */
public class LBC_CajaCierre {

    private final static Logger log = Logger.getLogger(LBC_CajaCierre.class);

    public String nombreAutomatizacion = "LBC Caja Cierre";

    public void testLink(LBC_CajaCierreBean lbcCajaCierreBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuOperaciones LBCMenuOperaciones = new LBC_MenuOperaciones();
            //Aperturar Caja
            LBC_Caja lbcCaja = new LBC_Caja();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            LBCMenuOperaciones.UAA_Caja_CierreCaja(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar la Caja a Cajero */

            Thread.sleep(3000);
            lbcCaja.CierreCaja(a, driver, lbcCajaCierreBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
