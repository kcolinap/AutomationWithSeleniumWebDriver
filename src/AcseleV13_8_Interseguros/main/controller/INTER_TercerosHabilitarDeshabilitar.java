package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by kcolina on 06/02/2017.
 */

public class INTER_TercerosHabilitarDeshabilitar {

    private final static Logger Log = Logger.getLogger(INTER_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Habilitar / Deshabilitar terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosHabilitarDeshabilitarBean interTercerosHabilitarDeshabilitarBean, int i, String folderName){

        try{

            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento intersegurosMenuMantenimiento = new Interseguros_MenuMantenimiento();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion Consulta de terceros
            intersegurosMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BuscarTercero(a, driver, interTercerosHabilitarDeshabilitarBean, i, folderName, 3);
            Thread.sleep(1500);

            //Boton Habilitar-Deshabilitar
            WebElement btnHabDes = driver.findElement(By.xpath())

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarTercero(Interseguros_Metodos a, WebDriver driver, INTER_TercerosHabilitarDeshabilitarBean
            interTercerosHabilitarDeshabilitarBean, int i, String folderName, int numScreenShoot){


    }
}
