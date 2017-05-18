package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_GeneracionDocumentosSiniestrosBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ValidacionOperacionSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

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









        }catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

}
