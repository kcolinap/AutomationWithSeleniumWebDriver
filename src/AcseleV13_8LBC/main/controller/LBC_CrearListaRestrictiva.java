package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CrearListaRestrictivaBean;
import AcseleV13_8LBC.main.controller.LBC_Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 25/10/2016.
 */
public class LBC_CrearListaRestrictiva {

    private final static Logger log = Logger.getLogger(LBC_CrearListaRestrictiva.class);

    public String nombreAutomatizacion = "LBC Crear Listas Resctrictiva";

    public void testLink(LBC_CrearListaRestrictivaBean lbcCrearListaRestrictivaBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            LBCMenuMantenimiento.AdminLisRest_CrearListasRestrictivas(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando la Caja */

            Thread.sleep(3000);
            CrearListaRestrictiva(a, driver, lbcCrearListaRestrictivaBean, nombreAutomatizacion, i, 3, 4, 5);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }

    public void CrearListaRestrictiva(LBC_Metodos a, WebDriver driver, LBC_CrearListaRestrictivaBean lbcCrearListaRestrictivaBean, String nombreAutomatizacion, int i, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

        }catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
