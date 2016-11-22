package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.Inter_TercerosCrearBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_CrearTercero;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by agil on 17/11/2016.
 */
public class Inter_TercerosCrear {

    private final static Logger log = Logger.getLogger(Inter_TercerosCrear.class);

    public String nombreAutomatizacion = "Inter Terceros Crear";

    public void testLink(Inter_TercerosCrearBean interTercerosCrearBean, int i) throws IOException, InterruptedException {

        try {

            // Instanciando clases
            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento intersegurosMenuMantenimiento = new Interseguros_MenuMantenimiento();
            Inter_CrearTercero interCrearTercero = new Inter_CrearTercero();


            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);


            //Entrando en Menu
            intersegurosMenuMantenimiento.MantTerc_IngresarTercero(driver, nombreAutomatizacion, 2, i);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Ingresar Tercero */

            Thread.sleep(3000);
            interCrearTercero.CrearTerceroNatural(a, driver, interTercerosCrearBean, nombreAutomatizacion, i, 3, 4, 5, 6);

            Thread.sleep(2000);
            interCrearTercero.ValidarCreacionTercero(driver, nombreAutomatizacion);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
