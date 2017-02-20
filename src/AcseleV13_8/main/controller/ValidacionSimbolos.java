package AcseleV13_8.main.controller;
import AcseleV13_8.beans.ValidacionSimbolosBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.IOException;
/**
 * Created by aazuaje on 05/10/2016.
 */
public class ValidacionSimbolos {

    private final static Logger log = Logger.getLogger(ValidacionSimbolos.class);

    public static String nombreAutomatizacion = "Validacion Simbolos";

    public void testLink(ValidacionSimbolosBean validacionSimbolosBean, int i) throws IOException, InterruptedException {

        try {
            //implementando clases
            Metodos13_8 a = new Metodos13_8();
            MenuConfiguracion menuConfiguracion = new MenuConfiguracion();
            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion, i);
            Thread.sleep(5000);

            // Ingreso al menu
            menuConfiguracion.MantenimientoProducto(driver, nombreAutomatizacion, 2);
            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            IngresarProductTool(a, driver, validacionSimbolosBean, i, 3, 4, 5, 6, 7);
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void IngresarProductTool(Metodos13_8 a, WebDriver driver, ValidacionSimbolosBean validacionSimbolosBean, int i,
                                    int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try {

            Thread.sleep(7000);
            WebElement seleccionProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            seleccionProducto.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement pestanaProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div[1]/ul/li[2]/a[2]/em/span/span"));
            pestanaProducto.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/div/img[1]"));
            expandirCarpetaProducto1.click();

            Thread.sleep(2000);
            WebElement expandirCarpetaProducto2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/div/img[1]"));
            expandirCarpetaProducto2.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlanes = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/div/img[1]"));
            expandirCarpetaPlanes.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaPlVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/div/img[1]"));
            expandirCarpetaPlVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaObjetosAsegurados = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/div/img[1]"));
            expandirCarpetaObjetosAsegurados.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaOaVDeudoresVillas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaOaVDeudoresVillas.click();

            Thread.sleep(1000);
            WebElement expandirCarpetaCoberturas = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/div/img[1]"));
            expandirCarpetaCoberturas.click();

            Thread.sleep(1000);
            WebElement seleccionarDesaparicionForzada = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/ul/li/ul/li/ul/li[3]/ul/li/ul/li/ul/li/ul/li/ul/li[1]/div/a/span"));
            seleccionarDesaparicionForzada.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            //WebElement btnEditar = driver.findElement(By.xpath(""));
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/div/div/div/div/table/tbody/tr[4]/td/div/div/div/img"));
            btnEditar.click();

            Thread.sleep(3000);

            Thread.sleep(1000);
            WebElement seleccionSimbolo = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/table/tbody/tr/td[1]/div"));
            seleccionSimbolo.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);

            WebElement btnEditarSimbolo = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button"));
            btnEditarSimbolo.click();

            Thread.sleep(4000);
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(5000);

            WebElement simbolo = driver.findElement(By.xpath("/html/body/div[19]/div/div[2]/div/div/div/div[1]/div/div[1]/div/div[1]/div/div/div/div/div/div[4]/div/div/table/tbody[2]/tr[107]/td/div"));
            simbolo.click();


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot5, nombreAutomatizacion);
            Toolkit.getDefaultToolkit().beep();
            Thread.sleep(1000);


        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}





