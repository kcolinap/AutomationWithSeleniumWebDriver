package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosHabilitarDeshabilitarBean;
import AcseleV13_8_Interseguros.beans.Inter_TercerosBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;

/**
 * Created by kcolina on 06/02/2017.
 */

public class INTER_TercerosHabilitarDeshabilitar extends Inter_BuscarTerceros {

    private final static Logger Log = Logger.getLogger(INTER_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Habilitar-Deshabilitar-terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosHabilitarDeshabilitarBean interTercerosHabilitarDeshabilitarBean, int i, String folderName){

        try{

            Interseguros_Metodos a = new Interseguros_Metodos();
            Interseguros_MenuMantenimiento intersegurosMenuMantenimiento = new Interseguros_MenuMantenimiento();
           Inter_BuscarTerceros interBuscarTerceros = new Inter_BuscarTerceros();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion Consulta de terceros
            intersegurosMenuMantenimiento.MantTerc_BuscarTercero(driver, nombreAutomatizacion, i, 2, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            interBuscarTerceros.BusquedaT(driver,a,interTercerosHabilitarDeshabilitarBean, nombreAutomatizacion,i,folderName,3,4,5,6);
            Thread.sleep(1500);

            HabilitarDeshabilitarTercero(a, driver, interTercerosHabilitarDeshabilitarBean,i,folderName,7,8,9);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void HabilitarDeshabilitarTercero(Interseguros_Metodos a, WebDriver driver, INTER_TercerosHabilitarDeshabilitarBean
            interTercerosHabilitarDeshabilitarBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

       try{
           JavascriptExecutor jse = (JavascriptExecutor) driver;

           //Seleccion de tercero encontrado
           WebElement seleccionTercero = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_ThirdPartyRadioGroup_resultsTable_1_thirdPartyRadio']"));
           seleccionTercero.click();
           Thread.sleep(2000);

           //ScreenShot para mostrar seleccionado y estatus actual
           a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
           Toolkit.getDefaultToolkit().beep();


           try{
               //Boton habilitar/deshabilitar
               WebElement btnHabDes = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_EnableDisableThirdButton']"));
               btnHabDes.click();
               Thread.sleep(2000);

               jse.executeScript("window.scrollBy(0,-1900)", "");
               Thread.sleep(1000);
               //ScreenShot para mostrar ventana de confirmacion
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
               Toolkit.getDefaultToolkit().beep();
               Thread.sleep(1000);

               //Boton de confirmacion
               WebElement btnAceptar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_confirmDialog_content_questionForm_confirmButton']"));
               btnAceptar.click();
               Thread.sleep(1000);

               jse.executeScript("window.scrollBy(0,1900)", "");
               Thread.sleep(1000);
               //screenShoot para mostrar nuevo estatus
               a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
               Toolkit.getDefaultToolkit().beep();
               Thread.sleep(2000);

           }catch (Exception e){
               e.printStackTrace();
           }

       }catch (Exception e)       {
           e.printStackTrace();
       }
    }
}
