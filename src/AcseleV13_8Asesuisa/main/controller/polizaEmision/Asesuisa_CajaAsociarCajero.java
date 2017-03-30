package AcseleV13_8Asesuisa.main.controller.polizaEmision;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAsociarCajeroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 30/03/2017.
 */
public class Asesuisa_CajaAsociarCajero {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAsociarCajero.class);

    public String nombreAutomatizacion = "Asesuisa Caja Asociar Cajero";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaAsociarCajeroBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuMantenimiento menuMantenimiento = new Asesuisa_MenuMantenimiento();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuMantenimiento.UAA_AsociarCajaCajero(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Asociar Caja con Cajero */

            //AsociarCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(3000);


            //driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                //driver.quit();
            }
        }
    }
/* Logica Selenium
    public void AsociarCaja(Asesuisa_CajaAsociarCajeroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            driver.findElement(By.xpath("//input[@name='insert']")).click();
            // Si se ingresaron todos los campos solicitados: Descripcion, Ubicacion y Localidad
            if (bean.getDescripcion() != null && bean.getUbicacion() != null && bean.getSucursal() != null ) {
                WebElement descripcion = driver.findElement(By.xpath("//input[@name='description']"));
                descripcion.sendKeys(bean.getDescripcion());
                Thread.sleep(2000);
                WebElement ubicacion = driver.findElement(By.xpath("//input[@name='location']"));
                ubicacion.sendKeys(bean.getUbicacion());
                Thread.sleep(2000);
                Select sucursal = new Select(driver.findElement(By.xpath("//select[@name='branchID']")));
                sucursal.selectByValue(bean.getSucursal());
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@name='Insert']")).click();

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }
            // Si el campo Descripcion esta vacio
            else if (bean.getDescripcion() == null && bean.getUbicacion() != null) {
                WebElement descripcion = driver.findElement(By.xpath("//input[@name='description']"));
                descripcion.clear();
                Thread.sleep(2000);
                WebElement ubicacion = driver.findElement(By.xpath("//input[@name='location']"));
                ubicacion.sendKeys(bean.getUbicacion());
                Thread.sleep(2000);
                Select sucursal = new Select(driver.findElement(By.xpath("//select[@name='branchID']")));
                sucursal.selectByValue(bean.getSucursal());

                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@name='Insert']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }
            // Si el campo Ubicacion esta vacio
            else if (bean.getDescripcion() != null && bean.getUbicacion() == null){
                WebElement descripcion = driver.findElement(By.xpath("//input[@name='description']"));
                descripcion.sendKeys(bean.getDescripcion());
                Thread.sleep(2000);
                WebElement ubicacion = driver.findElement(By.xpath("//input[@name='location']"));
                ubicacion.clear();
                Thread.sleep(2000);
                Select sucursal = new Select(driver.findElement(By.xpath("//select[@name='branchID']")));
                sucursal.selectByValue(bean.getSucursal());

                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@name='Insert']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }

            // Si todos los campos estan vacios
            else if (bean.getDescripcion() == null && bean.getUbicacion() == null && bean.getSucursal() == null){
                WebElement descripcion = driver.findElement(By.xpath("//input[@name='description']"));
                descripcion.clear();
                Thread.sleep(2000);
                WebElement ubicacion = driver.findElement(By.xpath("//input[@name='location']"));
                ubicacion.clear();

                Thread.sleep(2000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@name='Insert']")).click();

                // Mensajes de Alerta JavaScript
                if (ExpectedConditions.alertIsPresent() != null) {
                    Thread.sleep(1000);
                    Alert alert = driver.switchTo().alert();
                    String alertmess = alert.getText();
                    alert.accept();
                    System.out.println(alertmess);
                    Thread.sleep(1000);
                    driver.switchTo().defaultContent();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }

    }
*/ //fin logica Selenium
}
