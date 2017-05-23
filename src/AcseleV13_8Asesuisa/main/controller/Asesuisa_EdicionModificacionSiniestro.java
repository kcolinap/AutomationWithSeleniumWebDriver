package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by cortiz on 09/05/2017.
 */
public class Asesuisa_EdicionModificacionSiniestro {
    private final static Logger log = Logger.getLogger(Asesuisa_EdicionModificacionSiniestro.class);

    public String nombreAutomatizacion = "Validar Operacion Siniestro";
    private WebDriver driver;
    private int polizaEncontrada=0;

    public void testLink(Asesuisa_ValidacionOperacionSiniestroBean bean, int i, String folderName){
        try {
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menu = new Asesuisa_MenuOperaciones();

            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(2000);

            //Entrando a la opcion crear siniestro
            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menu.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(1500);
            m.cambiarVentana(driver);

            BusquedaSiniestro(bean, m, i, folderName, 3, 4, 5, 6, 7, 8, 9, 10, 11);

            Thread.sleep(1000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BusquedaSiniestro(Asesuisa_ValidacionOperacionSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                                  int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9){


         try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
             Thread.sleep(1000);

            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(4000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("/*//*[@id=\"buttonBuscar\"]"));
            buscar.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            //seleccionar siniestro encontrado
            Thread.sleep(3000);
            WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            sencontrado.click();

            WebElement EstatusSiniestro = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr/td[3]/div"));
            String stringEstatus = EstatusSiniestro.getText();



             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
             Thread.sleep(1000);
            WebElement ok = driver.findElement(By.xpath("/*//*[@id=\"buttonOk\"]/span"));
            ok.click();

            Thread.sleep(4000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);






            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);




            if (stringEstatus.equals("Cerrado")){

            WebElement msgCerrado = driver.findElement(By.className("TD_GREY_C"));
             String strmsgCerrado =  msgCerrado.getText();

                if (strmsgCerrado.equals("No se pudo abrir el reclamo: " +  bean.getID())){

                    System.out.print("\nEste reclamo tiene estatus cerrado.");

                }

            }

             if (stringEstatus.equals("Rechazado")){
/*
                 WebDriverWait wait = new WebDriverWait(driver, 30);
                 wait.until(ExpectedConditions.alertIsPresent());*/

                 //Manejo de alert para aceptar la reserva
                 if (ExpectedConditions.alertIsPresent() != null) {
                 Thread.sleep(1000);
                 Alert alert = driver.switchTo().alert();
                 alert.accept();
                 Thread.sleep(1000);
                 driver.switchTo().defaultContent();
                 }

                 WebElement boton = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_01\"]"));

                 if(boton.isEnabled())
                 {
                     System.out.print("\nEste boton no debe estar activo.");
                     log.error("Este boton no debe estar activo" );
                 }
                 else {
                     System.out.print("\nEl siniestro esta rechazado. .");

                 }

             }




        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
