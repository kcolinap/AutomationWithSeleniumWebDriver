package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_AjusteReservaSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ManteSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;

/**
 * Created by cortiz on 12/05/2017.
 */
public class ASesuisa_AjusteReservaSiniestro {

    private final static Logger log = Logger.getLogger(Asesuisa_ManteSiniestro.class);

    public String nombreAutomatizacion = "Asesuisa Mantenimiento de siniestro";
    private WebDriver driver;



    public void testLink(Asesuisa_AjusteReservaSiniestroBean bean, int i, String folderName){

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();


            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            //Ingreso a la opcion Mantenimiento siniestros
            menuOperaciones.OpeSini_MantenimientoSiniestro(driver, nombreAutomatizacion, 2, i, folderName);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7,8,9,10,11);
            AjusteReserva(bean, a, i, folderName, 12);

            Thread.sleep(3000);


            driver.quit();

        } catch (Exception e) {
                e.printStackTrace();
                log.info("Test Case - " + nombreAutomatizacion + " - " + e);
                if (driver != null) {
                    driver.quit();
                }

    }
}

    public void BusquedaT(Asesuisa_AjusteReservaSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5,
                          int numScreenShoot6, int numScreenShoot7, int numScreenShoot8, int numScreenShoot9) {

        salida:   try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;


            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(3000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input")).sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]"));
            buscar.click();


            //seleccionar siniestro encontrado
            Thread.sleep(4000);
            WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            sencontrado.click();


            Thread.sleep(2000);
            WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span"));
            ok.click();

            /////
            Thread.sleep(6000);
            a.changeLastWindows(driver);
            Thread.sleep(2000);

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Thread.sleep(1000);



            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
}

    public void AjusteReserva(Asesuisa_AjusteReservaSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot){

        try {

            // Salir del frame
            //driver.switchTo().parentFrame();
            driver.switchTo().defaultContent();
            WebElement cobertura = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            cobertura.click();

            Thread.sleep(2000);
            WebElement btnreserva = driver.findElement(By.xpath("//*[@id=\"coverageSelect\"]/option"));
            btnreserva.click();

            Thread.sleep(2000);
            WebElement aajuste = driver.findElement(By.xpath("//*[@id=\"idb_0402006_editReverse_02\"]"));
            aajuste.click();

            Thread.sleep(2000);
            WebElement razonAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[3]/td[5]/textarea"));
            razonAjuste.click();

            Thread.sleep(2000);
            WebElement montoAjuste = driver.findElement(By.xpath("/html/body/div[14]/div[2]/form/table/tbody[3]/tr[3]/td[6]/input[1]"));
            montoAjuste.click();



        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
