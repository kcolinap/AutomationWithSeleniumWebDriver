package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_TercerosEditarNombreApellidoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Terceros.Asesuisa_BuscarTerceros;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;

import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import sun.awt.windows.ThemeReader;

import java.awt.*;
import java.io.IOException;
/**
 * Created by kcolina on 01/03/2017.
 */
public class Asesuisa_TercerosEditarNombreApellido extends Asesuisa_BuscarTerceros {

    private final static Logger Log = Logger.getLogger(Asesuisa_TercerosEditarNombreApellido.class);

    public String nombreAutomatizacion = "Edicion de nombre y apellido de terceros";
    private WebDriver driver;

    public void testLink(Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean, int i, String folderName)throws Exception{

        try{
            Metodos m = new Metodos();
            Asesuisa_MenuMantenimiento menu = new Asesuisa_MenuMantenimiento();
            Asesuisa_BuscarTerceros buscarTerceros = new Asesuisa_BuscarTerceros();

            driver = m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(1000);

            //Ingreso a la opcion consulta de terceros
            menu.MantTerc_BuscarTercero(driver,nombreAutomatizacion, 2,i,folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);
            Thread.sleep(1000);

            //Buscamos al tercero a ser editado
            buscarTerceros.BusquedaT(driver, m, asesuisaTercerosEditarNombreApellidoBean,nombreAutomatizacion,i,folderName, 3,4,5,6, 7);

            Thread.sleep(600);

            //Lamada al metodo editar tercero
            EditarT(driver, asesuisaTercerosEditarNombreApellidoBean, i,m,folderName, 8,9,10, 11);
            Thread.sleep(1000);

            //Salimos
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            Log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if(driver != null){
                driver.quit();
            }
        }
    }

    public void EditarT(WebDriver driver, Asesuisa_TercerosEditarNombreApellidoBean asesuisaTercerosEditarNombreApellidoBean,
                        int i, Metodos m, String folderName, int numScreen, int numScreen2, int numScreen3, int numScreen4){

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;

            //Boton editar
            WebElement btnEditar = driver.findElement(By.xpath("//input[@wicketpath='SearchContent_ThirdInformation_showDetailSearchTable_proof_TableForm_associateButton']"));
            btnEditar.click();
            Thread.sleep(2000);

            //Capturo el nombre nuevo
            if (asesuisaTercerosEditarNombreApellidoBean.getPrimerNombre()!=null){
                etiqueta = driver.findElement(By.xpath("//div[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_etiqueta']"));
                etiqueta.click();
                WebElement primerNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                primerNombre.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(600);
                primerNombre = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_1_fila_field']"));
                primerNombre.sendKeys(asesuisaTercerosEditarNombreApellidoBean.getNombreNuevo());
                Thread.sleep(1000);
            }

            WebElement primerApellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
            primerApellido.click();
            Thread.sleep(300);

            //Capturo el apellido nuevo
            if (asesuisaTercerosEditarNombreApellidoBean.getPrimerApellido()!=null){
                primerApellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                primerApellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                primerApellido = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_DataTemplate_repeaterPanel2_2_fila_field']"));
                primerApellido.click();
                Thread.sleep(300);
                primerApellido.sendKeys(Keys.chord(Keys.CONTROL, "a"));
                Thread.sleep(300);
                primerApellido.sendKeys(asesuisaTercerosEditarNombreApellidoBean.getApellidoNuevo());
                Thread.sleep(1000);
            }

            jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + numScreen, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,400)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + numScreen2, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            jse.executeScript("window.scrollBy(0,500)", "");
            Thread.sleep(2000);
            m.ScreenShotPool(driver, i, "screen" + numScreen3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Guardando los cambios
            //Boton guardar
            Thread.sleep(2000);
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
            guardar.click();
            Thread.sleep(2000);
            guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_BasicInformation_formThirdBasic_saveButton']"));
            guardar.click();
            Thread.sleep(4000);

            //Volver a la busqueda
            WebElement volver = driver.findElement(By.xpath("//span[@wicketpath='ThirdInformationContent_panelInformationAndReturnPage_form_editValidity_editValidityLabel']"));
            volver.click();
            Thread.sleep(2000);

            jse.executeScript("window.scrollBy(0,1900)", "");
            Thread.sleep(800);

            //ScreenShot
            m.ScreenShotPool(driver, i, "screen" + numScreen4, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();


        }catch (Exception e){

        }

    }
}
