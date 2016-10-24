package AcseleV13_8LBC.main.controller;

import AcseleV13_8LBC.beans.LBC_CreacionTercerosBean;
import AcseleV13_8LBC.main.controller.LBC_Terceros.LBC_Crear;
import AcseleV13_8LBC.main.controller.Menu.LBC_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Created by agil on 13/10/2016.
 */
public class LBC_CreacionTerceros {

    private final static Logger log = Logger.getLogger(LBC_CreacionTerceros.class);

    public String nombreAutomatizacion = "LBC Creacion de LBC_Terceros";

    public void testLink(LBC_CreacionTercerosBean lbcCreacionTercerosBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            LBC_Metodos a = new LBC_Metodos();
            LBC_MenuMantenimiento LBCMenuMantenimiento = new LBC_MenuMantenimiento();
            //Crear Tercero
            LBC_Crear lbcCrear = new LBC_Crear();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            LBCMenuMantenimiento.MantTerc_IngresarTerceroFrontEnd(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Creando el Tercero */

            Thread.sleep(3000);
            lbcCrear.CrearTercero(a, driver, lbcCreacionTercerosBean, nombreAutomatizacion, i, 3, 4, 5, 6);


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }


    }
}
