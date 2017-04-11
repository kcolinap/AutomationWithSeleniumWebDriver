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

            AsociarCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
            Thread.sleep(3000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
            if (driver != null){
                driver.quit();
            }
        }
    }

    public void AsociarCaja(Asesuisa_CajaAsociarCajeroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            // Si se seleccionan todos los campos solicitados: cajero y numero de caja
            if(bean.getCajero() != null && bean.getNrocaja() != null){
                Thread.sleep(1000);
                Select cajero = new Select(driver.findElement(By.xpath("//select[@name='cashierID']")));
                cajero.selectByValue(bean.getCajero());

                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@id='idb_040203703_associateCashierRegisterWithCashier_01']")).click();

                int t = (driver.findElements(By.xpath("//*[@id='scrolly']/table/tbody/tr")).size())-1;
                driver.findElement(By.xpath("//*[@id='scrolly']/table/tbody/tr[" + t + "]/td[1]/input")).click();

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            // Si no se selecciona el campo: cajero
            else if (bean.getCajero() == null && bean.getNrocaja() != null){
                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@id='idb_040203703_associateCashierRegisterWithCashier_01']")).click();

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
            // Si no se selecciona el campo: numero de caja
            else if (bean.getCajero() != null && bean.getNrocaja() == null){
                Thread.sleep(1000);
                Select cajero = new Select(driver.findElement(By.xpath("//select[@name='cashierID']")));
                cajero.selectByValue(bean.getCajero());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@id='idb_040203703_associateCashierRegisterWithCashier_01']")).click();

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
            // Si no se selecciona ningun campo
            else if (bean.getCajero() == null && bean.getNrocaja() == null){
                Thread.sleep(1000);

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@id='idb_040203703_associateCashierRegisterWithCashier_01']")).click();

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
}
