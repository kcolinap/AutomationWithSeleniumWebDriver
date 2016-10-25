package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CreacionCajaBean;
import AcseleV13_8LBC.main.controller.LBC_Caja.LBC_CrearCaja;
import AcseleV13_8LBC.main.controller.Menu.MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 19/10/2016.
 */
public class LBC_CreacionCaja {

    private final static Logger log = Logger.getLogger(LBC_CreacionCaja.class);

    public String nombreAutomatizacion = "LBC Creacion de Caja";

    public void testLink(LBC_CreacionCajaBean lbcCreacionCajaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            MetodosLBC a = new MetodosLBC();
            MenuMantenimiento menuMantenimiento = new MenuMantenimiento();
            //Crear Caja
            LBC_CrearCaja lbcCrearCaja = new LBC_CrearCaja();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            menuMantenimiento.UAA_Caja(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la Caja */

            Thread.sleep(3000);
            lbcCrearCaja.CrearCaja(a, driver, lbcCreacionCajaBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
