package AcseleV13_8_Interseguros.main.controller;

import AcseleV13_8_Interseguros.beans.INTER_TercerosEditarNombreApellidoBean;
import AcseleV13_8_Interseguros.main.controller.Inter_Terceros.Inter_BuscarTerceros;
import AcseleV13_8_Interseguros.main.controller.Interseguros_Menu.Interseguros_MenuMantenimiento;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.io.IOException;


/**
 * Created by kcolina on 19/01/2017.
 */
public class INTER_TercerosEditarNombreApellido extends Inter_BuscarTerceros {

    private final static Logger Log = Logger.getLogger(INTER_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Edicion de nombre y apellido de terceros";
    private WebDriver driver;

    public void testLink(INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean, int i, String folderName) throws Exception{
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

            interBuscarTerceros.BusquedaT(driver, a, inter_tercerosEditarNombreApellidoBean, nombreAutomatizacion,i,folderName,3,4,5,6);

            //Boton editar
            WebElement editar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            editar.click();

            a.waitSearchWicket(driver, "Espera para editar");

            EditarT(a, driver, inter_tercerosEditarNombreApellidoBean, i, folderName, 7, 8, 9);
            Thread.sleep(4000);

            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if(driver != null){
                driver.quit();
            }
        }
    }

    public void EditarT(Interseguros_Metodos a, WebDriver driver, INTER_TercerosEditarNombreApellidoBean inter_tercerosEditarNombreApellidoBean, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3) throws InterruptedException, IOException{

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try{

            Thread.sleep(1500);

            if(inter_tercerosEditarNombreApellidoBean.getApellidoPaterno() != null) {

                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(1500);
                WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellido.click();
                apellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(800);
                apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                apellido.sendKeys(inter_tercerosEditarNombreApellidoBean.getApellidoNuevo());
                Thread.sleep(800);
                apellido.sendKeys(Keys.chord(Keys.TAB));
                Thread.sleep(3000);
            }
            /*
                Thread.sleep(1500);
                for (int j=0; j<=2; j++){

                    try{

                        WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                        apellido.sendKeys(Keys.chord(Keys.BACK_SPACE));
                        Thread.sleep(800);
                        apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                        apellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                        Thread.sleep(800);
                        apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                        apellido.sendKeys(inter_tercerosEditarNombreApellidoBean.getApellidoNuevo());
                        Thread.sleep(800);
                        break;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                WebElement title = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_ThirdInformationLabel']"));
                title.click();
            }else{
                try{
                    WebElement apellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_7_fila_field']"));
                    apellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(800);
                    apellido.sendKeys(inter_tercerosEditarNombreApellidoBean.getApellidoNuevo());
                    Thread.sleep(800);
                }catch (Exception e){
                    e.printStackTrace();
                }
            */

            if(inter_tercerosEditarNombreApellidoBean.getNombrePrimero() != null) {

                WebElement otroEelemento = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_etiqueta']"));
                otroEelemento.click();
                Thread.sleep(1500);
                WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(800);
               // nombre.click();

                //nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));

                //Thread.sleep(1000);
                /*nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(Keys.chord(Keys.BACK_SPACE));
                Thread.sleep(500);

                Thread.sleep(500);
                nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombre.click();

                Thread.sleep(3000);*/
                nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                nombre.sendKeys(inter_tercerosEditarNombreApellidoBean.getNombreNuevo());
                Thread.sleep(800);
/*
                for (int j=0; j<=2; j++){

                    try{

                        WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                        nombre.sendKeys(Keys.chord(Keys.BACK_SPACE));
                        Thread.sleep(800);
                        nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                        nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                        Thread.sleep(800);
                        nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                        nombre.sendKeys(inter_tercerosEditarNombreApellidoBean.getNombreNuevo());
                        Thread.sleep(800);
                        break;
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }else{
                try{
                    WebElement nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                    nombre.sendKeys(Keys.chord(Keys.BACK_SPACE));
                    Thread.sleep(800);
                    nombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel1_8_fila_field']"));
                    nombre.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                    Thread.sleep(1000);
                    nombre.sendKeys(inter_tercerosEditarNombreApellidoBean.getNombreNuevo());
                    Thread.sleep(800);
                }catch (Exception e){
                    e.printStackTrace();
                }*/
            }

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();



            jse.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton guardar
            Thread.sleep(2000);
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
            guardar.click();
            Thread.sleep(5000);
            guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
            guardar.click();
            Thread.sleep(2000);

            //Volver a la busqueda
            WebElement volver = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_panelInformationAndReturnPage_form_editValidity_editValidityLabel']"));
            volver.click();
            Thread.sleep(2000);

            jse.executeScript("window.scrollBy(0,1900)", "");
            Thread.sleep(800);

            //ScreenShot
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
