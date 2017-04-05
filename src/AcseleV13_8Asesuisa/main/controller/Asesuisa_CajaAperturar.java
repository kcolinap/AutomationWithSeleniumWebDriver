package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_CajaAperturarBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by aandrade on 03/04/2017.
 */
public class Asesuisa_CajaAperturar {

    private final static Logger log = Logger.getLogger(Asesuisa_CajaAperturar.class);

    public String nombreAutomatizacion = "Asesuisa Caja Aperturar";
    private WebDriver driver;

    public void testLink(Asesuisa_CajaAperturarBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();

            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            menuOperaciones.UAA_Caja_AperturaCaja(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            /** Aperturar Caja*/

            AperturarCaja(bean, a, i, folderName, 3, 4, 5, 6, 7);
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

    public void AperturarCaja(Asesuisa_CajaAperturarBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            String mensaje = driver.findElement(By.xpath("/html/body/center/form/table/tbody/tr[4]/td[2]")).getText();

            // Si no permite aperturar caja
            if (!mensaje.substring(0,2).equals("--")){

                // Captura la pantalla con el mensaje de informacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
                System.out.println(mensaje);
            }
            // Si se seleccionan todos los campos solicitados: numero de caja
            else if(bean.getNrocaja() != null){

                Thread.sleep(1000);
                Select nrocaja = new Select(driver.findElement(By.xpath("//select[@name='cashierRegisterID']")));
                nrocaja.selectByValue(bean.getNrocaja());

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

                // Mensajes de Resultado de la operacion
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

            }
            // Si no se selecciona el campo: Nro. de caja
            else if (bean.getNrocaja() == null){

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

                driver.findElement(By.xpath("//input[@value='Aceptar']")).click();

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
