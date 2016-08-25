package AcseleV13_8.main.controller;

import AcseleV13_8.beans.ValidacionFormulacionesImExProductoBean;
import AcseleV13_8.main.controller.Menu.MenuConfiguracion;
import AcseleV13_8.main.controller.Menu.MenuOperaciones;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by agil on 22/08/2016.
 */
public class ValidacionFormulacionesImExProducto {

    private final static Logger log = Logger.getLogger(ValidacionFormulacionesImExProducto.class);

    public static String nombreAutomatizacion = "Validacion de formulaciones Inport Export Producto";

    public void testLink(ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean, int i) throws IOException, InterruptedException {

        try {
            //implementando clases
            Metodos a = new Metodos();

            MenuConfiguracion menuConfiguracion = new MenuConfiguracion();
            MenuOperaciones menuOperaciones = new MenuOperaciones();

            WebDriver driver = a.entrarPagina();
            a.IniciarSesion(driver, nombreAutomatizacion);
            Thread.sleep(2000);
            a.ValidandoSesion(driver, nombreAutomatizacion);
            Thread.sleep(5000);

            // Ingreso al menu
            menuConfiguracion.MantenimientoProducto(a, driver, nombreAutomatizacion, 2);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            IngresarProductTool(a, driver, validacionFormulacionesImExProductoBean);
            Thread.sleep(1000);
            //ImportTablaDinamica(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);
/**            driver.close();

            a.regresarVentana(driver);

            menuOperaciones.OpePol_Crear(driver, nombreAutomatizacion, 7);

            Thread.sleep(2000);
            a.cambiarVentana(driver);
            Thread.sleep(2000);

            //TablaDinamica(a, driver, importExportTablasDinamicasBean);
          //  CrearPoliza(a, driver, usoTablasDinamicasImportadasBean);
            Thread.sleep(1000);

*/
        } catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }

    public void IngresarProductTool(Metodos a, WebDriver driver, ValidacionFormulacionesImExProductoBean validacionFormulacionesImExProductoBean){

        try {

            Thread.sleep(7000);
            WebElement seleccionProducto = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/ul/li/ul/li/div/a/span"));
            seleccionProducto.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen3", nombreAutomatizacion);
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
            a.ScreenShot(driver, "screen4", nombreAutomatizacion);
            Thread.sleep(1000);

            //WebElement btnEditar = driver.findElement(By.xpath(""));
            WebElement btnEditar = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/table[2]/tbody/tr[2]/td/div/div/div/div/div/div/table/tbody/tr[4]/td/div/div/div/img"));
            btnEditar.click();

            Thread.sleep(3000);

            Thread.sleep(1000);
            WebElement seleccionFormula = driver.findElement(By.xpath("//div[18]/table/tbody/tr/td[4]/div"));
            seleccionFormula.click();

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen5", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnEditarFormula = driver.findElement(By.xpath("//td[2]/table/tbody/tr/td[2]/em/button"));
            btnEditarFormula.click();

            Thread.sleep(4000);
            Thread.sleep(1000);
            a.ScreenShot(driver, "screen6", nombreAutomatizacion);
            Thread.sleep(1000);
            //WebElement campoFormula = driver.findElement(By.xpath("//div[24]/div/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div/div/form/table/tbody[2]/tr[2]/td/textarea"));
            WebElement campoFormula = driver.findElement(By.xpath("//*[@id=\"isc_3R\"]"));
            campoFormula.clear();
            campoFormula.sendKeys(validacionFormulacionesImExProductoBean.getFormula());

            Thread.sleep(1000);
            a.ScreenShot(driver, "screen7", nombreAutomatizacion);
            Thread.sleep(1000);

            WebElement btnAceptar = driver.findElement(By.xpath("//div[20]/div/div[2]/div/div/div/div[2]/div/div/div/table/tbody/tr/td"));
            btnAceptar.click();

            Thread.sleep(2000);

            WebElement btnSalvar = driver.findElement(By.xpath("//div[3]/div/table/tbody/tr/td/table/tbody/tr/td[2]/em/button"));
            btnSalvar.click();





        }catch (Exception e) {
            e.printStackTrace();
            //             log.info(e);
            log.info("Test Case - " + nombreAutomatizacion + " - " + e);
        }
    }
}
