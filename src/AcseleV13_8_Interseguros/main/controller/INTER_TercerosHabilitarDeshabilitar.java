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

    public String nombreAutomatizacion = "Habilitar-Deshabilitar-terceros";
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

            BuscarTercero(a, driver, interTercerosHabilitarDeshabilitarBean, i, folderName, 3,4);
            Thread.sleep(1500);

            HabilitarDeshabilitarTercero(a, driver, interTercerosHabilitarDeshabilitarBean,i,folderName,5,6,7);

            driver.quit();

        }catch (Exception e) {
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public void BuscarTercero(Interseguros_Metodos a, WebDriver driver, INTER_TercerosHabilitarDeshabilitarBean
            interTercerosHabilitarDeshabilitarBean, int i, String folderName, int numScreenShoot, int numScreenShoot2){

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,100)", "");
            Thread.sleep(800);

            Thread.sleep(1500);
            WebElement title = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformationLabel']"));

            //Seleccion de Tipo de tercero
            if(interTercerosHabilitarDeshabilitarBean.getTipoTerceros() != null){
                Thread.sleep(1500);
                Select tipoTercero = new Select(driver.findElement(By.xpath("//select[@wicketpath='SearchContent_ThirdInformation_thirdPartyTypes']")));
                tipoTercero.selectByValue(interTercerosHabilitarDeshabilitarBean.getTipoTerceros());
                Thread.sleep(1000);
                title.click();
            }

            //Ingresar dto de identidad
            if(interTercerosHabilitarDeshabilitarBean.getNumDocIdentificacion() != null){
                WebElement nroDocIden = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_1_fila_field']"));
                nroDocIden.sendKeys(interTercerosHabilitarDeshabilitarBean.getNumDocIdentificacion());
                Thread.sleep(1000);
                title.click();
            }

            //Ingresar apellido
            if(interTercerosHabilitarDeshabilitarBean.getApellido() != null){
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                //apellido.sendKeys(Keys.chord(Keys.CONTROL, "a"), inter_tercerosEditarNombreApellidoBean.getApellido());
                apellido.clear();
                Thread.sleep(1000);
                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(500);
                apellido = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys(interTercerosHabilitarDeshabilitarBean.getApellido());
                Thread.sleep(1000);
                title.click();
            }

            //Ingresar nombre
            if(interTercerosHabilitarDeshabilitarBean.getNombre() != null){
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                //nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"), inter_tercerosEditarNombreApellidoBean.getNombre());
                nombre.clear();
                Thread.sleep(1000);
                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(500);
                nombre = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_templateThird_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(interTercerosHabilitarDeshabilitarBean.getNombre());
                Thread.sleep(1000);
                title.click();
            }

            Thread.sleep(1000);

            //ScreenShot tomando los campo que se estan insertando
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,1500)", "");
            Thread.sleep(800);

            //Buscar
            WebElement buscar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            //WebElement buscar2 = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,1700)", "");
            Thread.sleep(1500);
            buscar =driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_templateContainer_searchForm_searchButton']"));
            buscar.click();//Borrar funcion al corregirse defecto
            Thread.sleep(500);

            a.waitSearchWicket(driver, "Buscando tercero");

            jse.executeScript("window.scrollBy(0,1900)", "");
            Thread.sleep(800);

            //ScreenShot tomando el registro buscado
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();

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
