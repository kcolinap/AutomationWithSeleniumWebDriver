package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_HistSiniestroBean;
import AcseleV13_8Asesuisa.beans.Asesuisa_ModosdePagoBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuMantenimiento;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;


/**
 * Created by cortiz on 29/03/2017.
 */
public class Asesuisa_HistSiniestro {

    private final static Logger log = Logger.getLogger(Asesuisa_HistSiniestro.class);

    public String nombreAutomatizacion = "Asesuisa Historico de Siniestro";
    private WebDriver driver;

    public void testLink(Asesuisa_HistSiniestroBean bean, int i, String folderName) {

        try {

            // Instanciando clases
            Metodos a = new Metodos();
            Asesuisa_MenuOperaciones menuOperaciones = new Asesuisa_MenuOperaciones();


            driver = a.entrarPagina(a.UrlAsesuisa());
            a.IniciarSesion(driver, nombreAutomatizacion, i, folderName);
            a.ValidandoSesion(driver, nombreAutomatizacion, i, folderName);
            Thread.sleep(5000);

            //Entrando en Menu
            //Ingreso a la opcion historico de siniestro
            menuOperaciones.OpeSini_HistorialReclamo(driver, nombreAutomatizacion, i, folderName);


            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7);



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

    public void BusquedaT(Asesuisa_HistSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {

            Thread.sleep(1000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;


            //Tipo tercero
            if (bean.getnSiniestro() != null) {
                Thread.sleep(1000);
                WebElement nSiniestro = driver.findElement(By.xpath("//*[@id=\"tableHeader\"]/tbody/tr[1]/td[2]/input"));
                nSiniestro.sendKeys(bean.getnSiniestro());
                Thread.sleep(1000);

            } else {

                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
                Thread.sleep(1000);

               /* WebElement ok = driver.findElement(By.xpath("/*//*[@id=\"panel-3\"]/div[3]/span/button"));
                ok.click();*/
                System.out.println("No. reclamo vacio");


            }



            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_claimHistoryScrem_01\"]"));
            buscar.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            if (bean.getnSiniestro() != null) {
            Boolean msgnoNSini = driver.findElements(By.xpath("//*[@id=\"panel-3_c\"]")).size() > 0;

            if (msgnoNSini){
                System.out.println("No se encontró resultados asociados con esta búsqueda");
                System.out.println(driver.findElement(By.xpath("//*[@id=\"panel-3_c\"]")).getText());
                System.out.println();
                Thread.sleep(1000);
                a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
                Thread.sleep(1000);
            }
            }


            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);





        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }




}
