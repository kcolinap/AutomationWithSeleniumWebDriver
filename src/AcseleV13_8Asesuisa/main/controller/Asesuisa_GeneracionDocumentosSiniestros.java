package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_GeneracionDocumentosSiniestrosBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import junit.framework.Assert;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.jetty.html.Break;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

/**
 * Created by cortiz on 17/05/2017.
 */
public class Asesuisa_GeneracionDocumentosSiniestros {
    private final static Logger log = Logger.getLogger(Asesuisa_GeneracionDocumentosSiniestros.class);

    public String nombreAutomatizacion = "Generación de documentos en Siniestros";
    private WebDriver driver;


    public void testLink(Asesuisa_GeneracionDocumentosSiniestrosBean bean, int i, String folderName){
        try {
            Metodos m = new Metodos();
            Asesuisa_MenuOperaciones menu = new Asesuisa_MenuOperaciones();

            driver= m.entrarPagina(m.UrlAsesuisa());
            m.IniciarSesion(driver,nombreAutomatizacion,i,folderName);
            m.ValidandoSesion(driver,nombreAutomatizacion,i,folderName);
            Thread.sleep(2000);


            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menu.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);
            Thread.sleep(2000);
            m.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaSiniestro(bean, m, i, folderName, 3, 4, 5, 6, 7, 8, 9);

            GenerarDocumento(bean, m, i, folderName,10,11,12);

            Thread.sleep(3000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }

    }

    public void BusquedaSiniestro(Asesuisa_GeneracionDocumentosSiniestrosBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5,
                                  int numScreenShoot6, int numScreenShoot7){


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



             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
             Thread.sleep(1000);
            WebElement ok = driver.findElement(By.xpath("/*//*[@id=\"buttonOk\"]/span"));
            ok.click();

            Thread.sleep(4000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);

             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

             WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
             cobertura.click();

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion, folderName);
             Thread.sleep(1000);

            // jse.executeScript("window.scrollBy(0,1000)", "");

             WebElement documentos = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_60\"]"));
             documentos.click();

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot6, nombreAutomatizacion, folderName);
             Thread.sleep(1000);

             Thread.sleep(2000);
             a.changeLastWindows(driver);
             Thread.sleep(2000);

             Thread.sleep(1000);
             a.ScreenShotPool(driver, i, "screen" + numScreenShoot7, nombreAutomatizacion, folderName);
             Thread.sleep(1000);


            /* WebElement nodocumentos = driver.findElement(By.xpath("/html/body/form/div/b/i/font"));


           if  ((nodocumentos.getText()).equals("No hay documentos configurados")){

               System.out.println("ESte siniestro no tiene documentos configurados ");
               Assert.assertEquals("No hay documentos configurados", nodocumentos.getText());
             }*/


        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void GenerarDocumento(Asesuisa_GeneracionDocumentosSiniestrosBean bean, Metodos a, int i, String folderName,
                                 int numScreenShoot, int numScreenShoot2, int numScreenShoot3){

        try {

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnselArchivo = driver.findElement(By.xpath("//*[@id=\"theFile\"]"));
            btnselArchivo.click();
            Thread.sleep(1500);


            switch (bean.getTIPODOC()){

                case "xlsx":

                    Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaGeneraDocumentosSiniestroXlsx.exe");
                    Thread.sleep(2000);

                    break;

                case "docx":

                    Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaGeneraDocumentosSiniestroDocx.exe");
                    Thread.sleep(2000);
                    break;

                case "pdf":

                    Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaGeneraDocumentosSiniestroPdf.exe");
                    Thread.sleep(2000);
                    break;

                case "txt":

                    Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaGeneraDocumentosSiniestroTxt.exe");
                    Thread.sleep(2000);
                    break;

                case "png":

                    Runtime.getRuntime().exec("C:\\AcseleTests\\AutomationTestAcsele\\AutoIT\\asesuisaGeneraDocumentosSiniestroPng.exe");
                    Thread.sleep(2000);
                    break;

            }

            if (bean.getCCOMENTARIO() != null) {
                WebElement descripcion = driver.findElement(By.xpath("//*[@id=\"desc\"]"));
                descripcion.sendKeys(bean.getCCOMENTARIO());
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            WebElement btnCargar = driver.findElement(By.xpath("//*[@id=\"DivComDocuments\"]/form/table[2]/tbody/tr/td/input"));
            btnCargar.click();
            Thread.sleep(3000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);  //*[@id="inner"]/a

            WebElement vtnclose = driver.findElement(By.xpath("//*[@id=\"inner\"]/a"));
            vtnclose.click();




        }catch (Exception e){
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
