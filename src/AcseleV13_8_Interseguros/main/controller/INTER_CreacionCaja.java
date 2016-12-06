package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_CreacionCajaBean;
import AcseleV13_8_Interseguros.main.controller.INTER_Caja.INTER_CrearCaja;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by mchurion on 25/11/2016.
 */
public class INTER_CreacionCaja {


    private final static Logger log = Logger.getLogger(INTER_CreacionCaja.class);

    public String nombreAutomatizacion = "INTER Creacion de Caja";

    public void testLink(INTER_CreacionCajaBean interCreacionCajaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento interMenuMantenimiento = new Interseguros_MenuMantenimiento();
            //Crear Caja
            INTER_CrearCaja interCrearCaja = new INTER_CrearCaja();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            interMenuMantenimiento.UAA_Caja(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la Caja */

            Thread.sleep(3000);
            interCrearCaja.CrearCaja(a, driver, interCreacionCajaBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
