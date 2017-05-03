package AcseleV13_8Asesuisa.main.controller;

import AcseleV13_8Asesuisa.beans.Asesuisa_ManteSiniestroBean;
import AcseleV13_8Asesuisa.main.controller.Asesuisa_Menu.Asesuisa_MenuOperaciones;
import metodo.Metodos;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;


/**
 * Created by cortiz on 01/04/2017.
 */
public class Asesuisa_ManteSiniestro {

    private final static Logger log = Logger.getLogger(Asesuisa_ManteSiniestro.class);

    public String nombreAutomatizacion = "Asesuisa Mantenimiento de siniestro";
    private WebDriver driver;

    public void testLink(Asesuisa_ManteSiniestroBean bean, int i, String folderName) {

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

            BusquedaT(bean, a, i, folderName, 3,4,5,6,7);
          //  AgregarModoPago(bean, a, i, folderName,8,9,10,11,12);


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

    public void BusquedaT(Asesuisa_ManteSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShot5) {

        try {

            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement etiqueta;


            if (bean.getNSINIESTRO() != null) {
                Thread.sleep(3000);
                WebElement nsiniestro = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/div[5]/div/div/div/div[3]/input"));
                nsiniestro.sendKeys(bean.getNSINIESTRO());
                Thread.sleep(1000);
            }

          //  jse.executeScript("window.scrollBy(0,-5000)", "");
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot, nombreAutomatizacion, folderName);
            Thread.sleep(1000);


            //Boton buscar
            WebElement buscar = driver.findElement(By.xpath("//*[@id=\"buttonBuscar\"]"));
            buscar.click();
            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot2, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

            //seleccionar siniestro encontrado

            Thread.sleep(2000);
            WebElement sencontrado = driver.findElement(By.xpath("//*[@id=\"layoutResultTable\"]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[2]/div"));
            sencontrado.click();


                Thread.sleep(2000);
                WebElement ok = driver.findElement(By.xpath("//*[@id=\"buttonOk\"]/span"));
                ok.click();

            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot3, nombreAutomatizacion, folderName);
            Toolkit.getDefaultToolkit().beep();

            //Boton cerrar
            WebElement cerrar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_32\"]"));
            cerrar.click();
            Thread.sleep(2000);

            //Boton rechazar
            WebElement recharar = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_32\"]"));
            recharar.click();
            Thread.sleep(2000);

            //Boton rechazar
            WebElement reabrir = driver.findElement(By.xpath("//*[@id=\"idb_0402006_structure_31\"]"));
            reabrir.click();
            Thread.sleep(2000);



            Thread.sleep(1000);
            a.ScreenShotPool(driver, i, "screen" + numScreenShoot4, nombreAutomatizacion, folderName);
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

   public void AgregarModoPago(Asesuisa_ManteSiniestroBean bean, Metodos a, int i, String folderName, int numScreenShoot, int numScreenShoot2, int numScreenShoot3, int numScreenShoot4, int numScreenShoot5){

        try{
            Thread.sleep(2000);
            JavascriptExecutor jse = (JavascriptExecutor)driver;


          /*//  if (bean.getMododePago() != null){
                Thread.sleep(1000);
                Select   tipoT = new Select(driver.findElement(By.xpath("//select[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_rolComb']")));
                tipoT.selectByValue(bean.getMododePago());
                Thread.sleep(1000);

          //  }*/



            WebElement Agregar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_RolForm_AddButton']"));
            Agregar.click();






            driver.findElement(By.xpath("//*[@id=\"campos_obligatoriosPan\"]/h1/div/label")).click();
            WebElement guardar = driver.findElement(By.xpath("//input[@wicketpath='ThirdInformationContent_thirdInformation_PanelPayment__Mode_templateContainer_ModeForm_saveButton']"));
            guardar.click();
            Thread.sleep(4000);




        } catch (Exception e) {
            e.printStackTrace();
            log.error("Test Case - " + nombreAutomatizacion + " - " + e);
        }



    }



}
